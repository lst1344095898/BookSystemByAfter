package com.springboot.aspect;

import com.springboot.controller.LoginController;

import com.springboot.entity.State;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;

@Aspect
@Component
public class ServiceLog {
    @Autowired
    private LoginController loginController;
    private final Logger logger = LoggerFactory.getLogger(ServiceLog.class);
    @Pointcut("execution(* com.springboot.service.impl.*.*(..))")
    public void service(){

    }
    @Before(value = "service()")
    public void ServiceBefore(JoinPoint joinPoint){
        logger.info("\n调用了"+joinPoint.getSignature().getName()+"\nservice接口实现类"+"\n传入参数是:"+Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(value = "service()" ,returning = "returnValue")
    public void ServiceAfterReturning(JoinPoint joinPoint,Object returnValue) throws  Throwable{
        logger.info("\n"+joinPoint.getSignature().getName()+"\nservice接口实现类调用完成"+"\n返回值是："+returnValue);
    }

}
