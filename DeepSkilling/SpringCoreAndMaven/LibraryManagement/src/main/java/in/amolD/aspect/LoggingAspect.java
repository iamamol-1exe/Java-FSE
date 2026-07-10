package in.amolD.aspect;


import org.aspectj.lang.JoinPoint;

public class LoggingAspect      {


    public LoggingAspect() {

    }

    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger : Before "+methodName);
    }

    public   void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger : After "+methodName);
    }
}
