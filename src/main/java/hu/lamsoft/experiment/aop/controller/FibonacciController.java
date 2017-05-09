package hu.lamsoft.experiment.aop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.experiment.aop.annotation.EnablePerformanceLogging;

@RestController
public class FibonacciController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciController.class);
	
	@EnablePerformanceLogging
	@RequestMapping("/fibonacci/{n}")
	public long calcFibonacci(@PathVariable(value="n") int n) {
		LOGGER.info("Calc Fibonacci invoked with n="+n+".");
		return fibonacci(n);
	}
	
    private long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }
	
}
