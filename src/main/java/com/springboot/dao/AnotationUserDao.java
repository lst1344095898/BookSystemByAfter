package com.springboot.dao;

import com.springboot.entity.userEntity.UserManagement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.springboot.entity.userEntity.User;

import java.util.Date;
import java.util.ArrayList;

@Mapper
public interface AnotationUserDao {

	 ArrayList<User> getUserInfoById(@Param("userid") String userid);
	 User findById(@Param("username") String username);
	 int register(@Param("username") String username, @Param("password") String password, @Param("e_mail") String e_mail, @Param("birthday") String birthday,
				  @Param("grade") String grade, @Param("user_code") String user_code, @Param("sex") String sex, @Param("interest") String interest, @Param("introduce") String introduce);
	 boolean editUser(@Param("userid") int userid,@Param("username") String username, @Param("e_mail") String e_mail,@Param("birthday") String birthday,
				  @Param("sex") String sex,@Param("grade") String grade,@Param("interest") String interest,@Param("introduce") String introduce);
	 ArrayList<User> getUserAllByInput(@Param("userid") int userid,@Param("username") String username,@Param("page") int page,
									   @Param("count") int count);
	 UserManagement getPage(@Param("userid") int userid, @Param("username") String username);
	 String judgeExistence(@Param("username") String username);
	 String e_mailJudge(@Param("e_mail") String e_mail);
	 User getUserBuE_mail(@Param("e_mail") String e_mail);
	 int editPassword(@Param("userid") String userid,@Param("password") String password);
	 int userBorrowTimesAdd(@Param("userid") int userid);
	 int deletUser(@Param("userid") int userid);
}