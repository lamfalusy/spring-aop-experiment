package hu.lamsoft.experiment.aop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.experiment.aop.vo.UserVO;

@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(path = "/create-user")
	public UserVO createUser(@RequestParam(name = "name", required = true) String name) {
		LOGGER.info("Create user invoked.");
		return new UserVO(name);
	}
	
}
