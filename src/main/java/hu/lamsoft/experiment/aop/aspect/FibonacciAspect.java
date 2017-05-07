package hu.lamsoft.experiment.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class FibonacciAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciAspect.class);
	
    @Around("execution(* hu.lamsoft.experiment.aop.controller.FibonacciController.calcFibonacci(*)) && args(n)")
    public Object doLogging(ProceedingJoinPoint pjp, int n) throws Throwable {
        StopWatch stopWatch = new StopWatch("Fibonacci stop watch");
        stopWatch.start("Calc Fibonacci for "+n);
        Object retVal = pjp.proceed();
        stopWatch.stop();
        LOGGER.info(stopWatch.prettyPrint());
        return retVal;
    }
	
}
