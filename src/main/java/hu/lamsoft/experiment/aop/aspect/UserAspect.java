package hu.lamsoft.experiment.aop.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import hu.lamsoft.experiment.aop.vo.CreatedUserVO;
import hu.lamsoft.experiment.aop.vo.UserVO;

@Aspect
@Component
public class UserAspect {

    @Around("execution(* hu.lamsoft.experiment.aop.controller.UserController.createUser(*))")
    public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
        UserVO user = (UserVO) pjp.proceed();
        return new CreatedUserVO(user, new Date());
    }
	
}
