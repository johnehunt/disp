package uk.ac.uwe.myBPM.simplebpm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineAssertions.assertThat;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineAssertions.init;
import static org.camunda.bpm.engine.test.assertions.ProcessEngineAssertions.processEngine;

import org.apache.ibatis.logging.LogFactory;
import org.camunda.bpm.engine.impl.persistence.entity.TaskEntity;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.test.assertions.TaskAssert;
import org.camunda.bpm.extension.process_test_coverage.junit.rules.TestCoverageProcessEngineRuleBuilder;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * Test case starting an in-memory database-backed Process Engine.
 */
public class ProcessUnitTest {

	@ClassRule
	@Rule
	public static ProcessEngineRule rule = TestCoverageProcessEngineRuleBuilder.create().build();

	private static final String PROCESS_DEFINITION_KEY = "simplebpm";

	static {
		LogFactory.useSlf4jLogging(); // Set up the use of logging
	}

	// Set up the Fixture that will run before each test
	@Before
	public void setup() {
		init(rule.getProcessEngine());
	}

	/**
	 * Just tests if the process definition is deployable.
	 */
	@Test
	@Deployment(resources = "process.bpmn")
	public void testParsingAndDeployment() {
		// nothing is done here, as we just want to check for exceptions during
		// deployment
	}

	@Test
	@Deployment(resources = "process.bpmn")
	public void testCurrentStatus() {

		// Obtain test run of BPMN
		ProcessInstanceWithVariables processInstance = (ProcessInstanceWithVariables) processEngine()
				.getRuntimeService().startProcessInstanceByKey(PROCESS_DEFINITION_KEY);

		// Obtain the value of the weatherOK variable
		boolean weatherOK = (boolean) processInstance.getVariables().get("weatherOK");
		System.out.println("weatherOK: " + weatherOK);

		// Obtain a reference to the current task
		TaskAssert task = assertThat(processInstance).task();

		if (weatherOK) {
			assertThat(processInstance).isWaitingAt("Task_1advnfb");
			task.hasName("Checkout 2");
			task.isNotAssigned();
		} else {
			assertThat(processInstance).isWaitingAt("Task_1fekbp5");
			task.hasName("Checkout");
			task.isNotAssigned();
		}

	}
	
	@Test
	@Deployment(resources = "process.bpmn")
	public void testCompletionOftask() {
		
		// Obtain test run of BPMN
		ProcessInstanceWithVariables processInstance = (ProcessInstanceWithVariables) processEngine()
				.getRuntimeService().startProcessInstanceByKey(PROCESS_DEFINITION_KEY);

		// Obtain a reference to the current task
		TaskAssert taskAssert = assertThat(processInstance).task();
		
		TaskEntity task = (TaskEntity)taskAssert.getActual();
		task.delegate("user");
		
		task.resolve();
		
		assertThat(processInstance.isEnded());
		
	}

	
}
