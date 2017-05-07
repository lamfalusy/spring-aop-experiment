package hu.lamsoft.experiment.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloAspect.class);
	
	@Before("execution(* hu.lamsoft.experiment.aop.controller.HelloWordController.helloWorld())")
	public void beforeHelloWorld() {
		LOGGER.info("HelloAspect before invoked.");
	}
	
	@After("execution(* hu.lamsoft.experiment.aop.controller.HelloWordController.helloWorld())")
	public void afterHelloWorld() {
		LOGGER.info("HelloAspect after invoked.");
	}

	@AfterReturning("execution(* hu.lamsoft.experiment.aop.controller.HelloWordController.helloWorld())")
	public void afterReturningHelloWorld() {
		LOGGER.info("HelloAspect after returning invoked.");
	}
	
}
