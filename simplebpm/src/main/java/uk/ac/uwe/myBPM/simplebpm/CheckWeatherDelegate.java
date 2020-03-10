package uk.ac.uwe.myBPM.simplebpm;

import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * A Delegate for Camunda
 *
 */
public class CheckWeatherDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		Random rand = new Random();
		execution.setVariable("weatherOK", rand.nextBoolean());
	}

}
