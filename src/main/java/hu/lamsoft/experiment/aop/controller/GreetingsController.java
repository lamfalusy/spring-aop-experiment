package hu.lamsoft.experiment.aop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingsController.class);
	
	@RequestMapping("/greetings")
	public String greetings(@RequestParam(name = "name") String name) {
		LOGGER.info("Greetings invoked.");
		return "Hello "+name;
	}
	
}
