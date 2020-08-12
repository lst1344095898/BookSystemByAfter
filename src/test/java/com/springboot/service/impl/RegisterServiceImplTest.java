package com.springboot.service.impl;

import static org.junit.Assert.*;

import com.springboot.dao.AnotationUserDao;
import com.springboot.entity.State;
import com.springboot.entity.userEntity.User;
import com.springboot.service.RegisterService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import javax.swing.*;
import java.util.Date;

public class RegisterServiceImplTest {
RegisterService registerService=new RegisterServiceImpl();
	@Test
	public void testRegisterFalse() {
		User user = new User();
		user.setUsername("123");
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			String judgeExistence(String username){
				return  "test";
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(registerService,"userDao",userDao.getMockInstance());
			}
		};
		State<Boolean> state=registerService.register(user.getUsername(),user.getPassword(),user.getE_mail(),user.getBirthday(),user.getGrade(),user.getUser_code(),user.getSex(),user.getInterest(),user.getIntroduce());
		assertEquals(false,state.getState_id());
	}
	@Test
	public void testRegisterFalse1() {
		User user = new User();
		user.setUsername("123");
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			String judgeExistence(String username){
				return  null;
			}
			@Mock
			int register(String username, String password, String e_mail, String birthday, String grade, String user_code, String sex, String interest, String introduce){
				return 0;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(registerService,"userDao",userDao.getMockInstance());
			}
		};
		State<Boolean> state=registerService.register(user.getUsername(),user.getPassword(),user.getE_mail(),user.getBirthday(),user.getGrade(),user.getUser_code(),user.getSex(),user.getInterest(),user.getIntroduce());
		assertEquals(false,state.getState_id());
	}
	@Test
	public void testRegisterTrue() {
		User user = new User();
		user.setUsername("123");
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			String judgeExistence(String username){
				return  null;
			}
			@Mock
			int register(String username, String password, String e_mail, String birthday, String grade, String user_code, String sex, String interest, String introduce){
				return 1;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(registerService,"userDao",userDao.getMockInstance());
			}
		};
		State<Boolean> state=registerService.register(user.getUsername(),user.getPassword(),user.getE_mail(),user.getBirthday(),user.getGrade(),user.getUser_code(),user.getSex(),user.getInterest(),user.getIntroduce());
		assertEquals(true,state.getState_id());
	}

}
