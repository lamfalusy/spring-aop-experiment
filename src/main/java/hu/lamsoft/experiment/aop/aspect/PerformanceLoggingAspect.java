package hu.lamsoft.experiment.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;

@Aspect
@Component
public class PerformanceLoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceLoggingAspect.class);
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	private void anyRequestMappingAnnotated() {}

	@Pointcut("@annotation(hu.lamsoft.experiment.aop.annotation.EnablePerformanceLogging)")
	private void anyEnablePerformanceLoggingAnnotated() {}
	
	@Pointcut("anyRequestMappingAnnotated() && anyEnablePerformanceLoggingAnnotated()")
	private void anyRequestMappingAndEnablePerformanceLoggingAnnotated() {}
	
    @Around("anyRequestMappingAndEnablePerformanceLoggingAnnotated() && @annotation(requestMapping)")
    public Object doLogging(ProceedingJoinPoint pjp, RequestMapping requestMapping) throws Throwable {
        StopWatch stopWatch = new StopWatch("Performamce logging stop watch");
        stopWatch.start(String.join(",", requestMapping.value()));
        Object retVal = pjp.proceed();
        stopWatch.stop();
        LOGGER.info(stopWatch.prettyPrint());
        return retVal;
    }
	
}
