package com.springboot.aspect;

import com.springboot.dao.BookDao;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class BorrowLog {
    @Autowired
    private BookDao bookDao;
    private final Logger logger= LoggerFactory.getLogger(BorrowLog.class);
    @Pointcut("execution(* com.springboot.service.impl.BookServiceImpl.borrowAdd())")
    public void BorrowAdd(){}
}
