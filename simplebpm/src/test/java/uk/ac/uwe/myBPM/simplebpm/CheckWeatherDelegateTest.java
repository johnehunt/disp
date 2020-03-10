package uk.ac.uwe.myBPM.simplebpm;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.Test;

public class CheckWeatherDelegateTest {

	@Test
	public void verifyThatTheDelegateSetsVariable() {
		// Set up class under test
		CheckWeatherDelegate delegate = new CheckWeatherDelegate();
		// Set up mock of Camunda execution environment
		DelegateExecution mockExecution = mock(DelegateExecution.class);
		// Run the delegate behaviour
		try {
			delegate.execute(mockExecution);
		} catch (Exception e) {
			e.printStackTrace();
			// If an exception is thrown this is a failure of the test
			fail("throw exception: " + e.getMessage());
		}
		// Now verify that the mock was called.
		verify(mockExecution, times(1))
		    .setVariable(eq("weatherOK"), 
		    		     any(Boolean.class));
	}

}
