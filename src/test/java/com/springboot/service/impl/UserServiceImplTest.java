package com.springboot.service.impl;

import static org.junit.Assert.*;

import com.springboot.dao.AnotationUserDao;
import com.springboot.entity.Paging;
import com.springboot.entity.State;
import com.springboot.entity.userEntity.User;
import com.springboot.entity.userEntity.UserManagement;
import com.springboot.service.UserService;
import mockit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

public class UserServiceImplTest {
	UserService userService=new UserServiceImpl();
	@Test
	public void checkPasswordTestFalse() {
		String username="1";
		String password="1";
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			User findById(String username){
				return null;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(userService,"userDao",userDao.getMockInstance());
			}
		};
		State<User> user=userService.checkPassword(username,password);
		assertNull(null,user.getData());
	}
	@Test
	public void checkPasswordTestTrue() {
		String username="1";
		String password="1";
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			User findById(String username){
				User user = new User();
				user.setUsername("1");
				user.setUserid(1);
				user.setPassword("1");
				return user;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(userService,"userDao",userDao.getMockInstance());
			}
		};
		State<User> user=userService.checkPassword(username,password);
		System.out.println(user.getData());
		assertNotNull(user.getData());
	}
	@Test
	public void getUserByNameTestFalse() {
		String username="1";
		String password="1";
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			User findById(String username){
//				User user = new User();
//				user.setUsername("1");
//				user.setUserid(1);
//				user.setPassword("1");
				return null;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(userService,"userDao",userDao.getMockInstance());
			}
		};
		User user=userService.getUserByName(username);
		System.out.println(user);
		assertNull(null,user);
	}
	@Test
	public void getUserByNameTestTrue() {
		String username="1";
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			User findById(String username){
				User user = new User();
				user.setUsername("1");
				user.setUserid(1);
				user.setPassword("1");
				return user;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(userService,"userDao",userDao.getMockInstance());
			}
		};
		User user=userService.getUserByName(username);
		System.out.println(user);
		assertNotNull(user);
	}
	@Test
	public void getUserInfoByIdTestFalse() {
		String userid="123";
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			ArrayList<User> getUserInfoById(String userid){
				System.out.println(userid);
				return null;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(userService,"userDao",userDao.getMockInstance());
			}
		};
		State<ArrayList<User>> user=userService.getUserInfoById(userid);
		System.out.println(user);
		assertEquals(false,user.getState_id());
	}
	@Test
	public void getUserInfoByIdTestTrue() {
		String userid="1";
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			ArrayList<User> getUserInfoById(String userid){
				ArrayList<User> user = new ArrayList<User>();
				User user2=new User();
				user2.setUserid(1);
				user.add(0,user2);
				return user;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(userService,"userDao",userDao.getMockInstance());
			}
		};
		State<ArrayList<User>> user=userService.getUserInfoById(userid);
		System.out.println(user.getData());
		assertNotNull(user);
	}
	@Test
	public void editUserTestFalse() {
		User user = new User();
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			boolean editUser(int userid, String username, String e_mail, String birthday, String sex, String grade, String interest, String introduce){
				return false;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(userService,"userDao",userDao.getMockInstance());
			}
		};
		State<String> state=userService.editUser(user.getUserid(),user.getUsername(),user.getE_mail(),user.getBirthday(),user.getSex(),user.getGrade(),user.getInterest(),user.getIntroduce());
		assertEquals(false,state.getState_id());
	}
	@Test
	public void editUserTestTrue() {
		User user = new User();
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			boolean editUser(int userid, String username, String e_mail, String birthday, String sex, String grade, String interest, String introduce){
				return true;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(userService,"userDao",userDao.getMockInstance());
			}
		};
		State<String> state=userService.editUser(user.getUserid(),user.getUsername(),user.getE_mail(),user.getBirthday(),user.getSex(),user.getGrade(),user.getInterest(),user.getIntroduce());
		assertEquals(true,state.getState_id());
	}
	@Test
	public void e_mailJudgeTestFalse() {
		String e_mail="123";
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			 String e_mailJudge(String e_mail){
				return null;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(userService,"userDao",userDao.getMockInstance());
			}
		};
		State<User> state=userService.e_mailJudge(e_mail);
		assertEquals(false,state.getState_id());
	}
	@Test
	public void e_mailJudgeTestTrue() {
		String e_mail="123";
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			String e_mailJudge(String e_mail){
				return "123";
			}
			@Mock
			User getUserBuE_mail(String e_mail){
				User user = new User();
				user.setUsername("123");
				return user;
			}

		};
		new Expectations(){
			{
				Deencapsulation.setField(userService,"userDao",userDao.getMockInstance());
			}
		};
		State<User> state=userService.e_mailJudge(e_mail);
		assertEquals(true,state.getState_id());
	}
	@Test
	public void editPasswordTestFalse() {
		String userid="123";
		String password="123";
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			int editPassword(String userid,String password){
				return 0;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(userService,"userDao",userDao.getMockInstance());
			}
		};
		boolean state=userService.editPassword(userid,password);
		assertEquals(false,state);
	}
	@Test
	public void editPasswordTestTrue() {
		String userid="123";
		String password="123";
		MockUp<AnotationUserDao> userDao=new MockUp<AnotationUserDao>() {
			@Mock
			int editPassword(String userid,String password){
				return 1;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(userService,"userDao",userDao.getMockInstance());
			}
		};
		boolean state=userService.editPassword(userid,password);
		assertEquals(true,state);
	}

}
