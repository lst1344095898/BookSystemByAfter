package com.springboot.dao;

import com.springboot.entity.Book;
import com.springboot.entity.UserLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
@Mapper
public interface UserLogDao {
    ArrayList<UserLog> getLog();
    int setLoginDate(@Param("userid") int userid,@Param("userName")String userName,@Param("power") String power,@Param("log_datetime") String log_datetime);
}
