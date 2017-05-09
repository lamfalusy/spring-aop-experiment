package hu.lamsoft.experiment.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloWorldAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldAspect.class);
	
	@Pointcut("execution(* hu.lamsoft.experiment.aop.controller.HelloWorldController.helloworld())")
	private void executionOfHelloWorld() {}
	
	@Before("executionOfHelloWorld()")
	public void beforeHelloWorld() {
		LOGGER.info("HelloWorldAspect before invoked.");
	}
	
	@After("executionOfHelloWorld()")
	public void afterHelloWorld() {
		LOGGER.info("HelloWorldAspect after invoked.");
	}

	@AfterReturning("executionOfHelloWorld()")
	public void afterReturningHelloWorld() {
		LOGGER.info("HelloWorldAspect after returning invoked.");
	}
	
}
