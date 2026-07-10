package in.amolD.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* in.amolD.service.BookService.addBook(..))")
    public void beforeMethod(JoinPoint joinpoint) {
        String methodName = joinpoint.getSignature().getName();
        System.out.println("Before method " + methodName);
    }

    @After("execution(* in.amolD.service.BookService.addBook(..))")
    public void afterMethod(JoinPoint joinpoint) {
        String methodName = joinpoint.getSignature().getName();
        System.out.println("After method " + methodName);
    }


}
