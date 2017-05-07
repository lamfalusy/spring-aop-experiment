package hu.lamsoft.experiment.aop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWordController.class);
	
	@RequestMapping("/helloworld")
	public String helloWorld() {
		LOGGER.info("HelloWorld invoked.");
		return "Hello World";
	}
	
}
