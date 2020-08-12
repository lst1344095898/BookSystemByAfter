package com.springboot.aspect;

import com.springboot.controller.LoginController;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;

@Aspect
@Component
public class Log {
    @Autowired
    private LoginController loginController;
    private final Logger logger = LoggerFactory.getLogger(Log.class);
    @Pointcut("execution(* com.springboot.controller..*.*(*))")//切面
    public void log(){
    }
    @Before( value = "log()")
    public void before(JoinPoint joinPoint){
        logger.info("\n调用了"+joinPoint.getSignature().getName()+"\ncontroller方法\n传入的参数是:\n"+joinPoint.getArgs()[0]+"\n");
    }
    @Transactional(rollbackFor = RuntimeException.class)
    @After(value = "log()")
    public void after(JoinPoint joinPoint) throws RuntimeException{
        try {
            logger.info("异常回滚");
        } catch (Exception e){
            throw new RuntimeException("回滚");
        }
    }
    @AfterReturning(value = "log()", returning = "returnValue")
    public void afterResult(JoinPoint joinPoint,Object returnValue) throws Throwable{
        logger.info("\n"+joinPoint.getSignature().getName()+"\ncontroller方法调用完成"+"\n返回的参数是"+returnValue);
    }

}
