package hu.lamsoft.experiment.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingsAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingsAspect.class);
	
	@Around("execution(* hu.lamsoft.experiment.aop.controller.GreetingsController.greetings(String)) && args(name)")
    public Object doLogging(ProceedingJoinPoint pjp, String name) throws Throwable {
		Object ret;
		if(name == null || name.isEmpty()) {
			ret = "John Doe, is that you?";
		} else {
			LOGGER.info("GreetingsAspect before invoke.");
			ret = pjp.proceed();
//			ret = pjp.proceed(new Object[]{name.toUpperCase()});
			LOGGER.info("GreetingsAspect after invoke.");
		}
        return ret;
    }
	
}
