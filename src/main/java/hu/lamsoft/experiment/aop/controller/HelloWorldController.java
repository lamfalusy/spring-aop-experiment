package hu.lamsoft.experiment.aop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);
	
	@RequestMapping("/helloworld")
	public String helloworld() {
		LOGGER.info("Hello world invoked.");
		return "Hello World";
	}
	
}
