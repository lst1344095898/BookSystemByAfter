package com.springboot.aspect;

import com.springboot.dao.UserLogDao;
import com.springboot.entity.State;
import com.springboot.entity.userEntity.User;
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
@Component // 放入spring容器扫描
public class LoginLog {
    @Autowired
    private UserLogDao userLogDao;
    private final Logger logger= LoggerFactory.getLogger(LoginLog.class);
    @Pointcut("execution(* com.springboot.service.UserService.checkPassword(..))")//切面
    public void log(){

    }
    @AfterReturning(value = "log()",returning = "returnValue")
    public void   LoginDate(JoinPoint joinPoint,Object returnValue) throws  Throwable{
        logger.info("进行登录日志管理\n方法返回值:"+returnValue);
        State<User> state = (State<User>) returnValue;
        if (((State<User>) returnValue).getState_id()){
            SimpleDateFormat df_24=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String log_datetime=df_24.format(new Date());
            userLogDao.setLoginDate(state.getData().getUserid(),state.getData().getUsername(),state.getData().getUser_code(),log_datetime);
        }
    }

}
