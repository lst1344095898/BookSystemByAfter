package com.springboot.controller;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import com.springboot.service.RegisterService;
import org.junit.Test;
import com.springboot.entity.State;
import com.springboot.entity.userEntity.User;
import com.springboot.service.UserService;

import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;

import javax.servlet.http.HttpServletRequest;

public class LoginControllerTest {
	@Tested
	LoginController loginController;
	@Injectable
	HttpServletRequest request;
	@Injectable
	UserService userService;
	@Test
	public void loginTestFalse() throws NoSuchAlgorithmException {
		//测试对象
		//数据实体
		User user = new User();
		//假数据
		user.setUsername("user_id");
		user.setPassword("password");
		//service对象
	MockUp<UserService> userService = new MockUp<UserService>() {
			@Mock
			public State<User> checkPassword(String username,String password) {
				//返回为错误
				State<User> state = new State<User>();
				state.setState_id(false);
				state.setData(null);
				state.setError(null);
				return state;
			}
		};
		new Expectations() {
			{
				//将service返回到测试对象
			 Deencapsulation.setField(loginController, "userService", userService.getMockInstance());
			}
		};
		State<User> state=loginController.login(user);
		//断言
		assertEquals(false,state.getState_id());
	}
	@Test
	public void loginTestTrue(){
		//测试对象
		//数据实体
		User user = new User();
		//假数据
		user.setUsername("user_id");
		user.setPassword("password");
		//service对象
		MockUp<UserService> userService = new MockUp<UserService>() {
			@Mock
			public State<User> checkPassword(String username,String password) {
				//返回为错误
				State<User> state = new State<User>();
				state.setState_id(true);
				state.setData(null);
				state.setError(null);
				return state;
			}
		};
		new Expectations() {
			{
				//将service返回到测试对象
				Deencapsulation.setField(loginController, "userService", userService.getMockInstance());
			}
		};
		State<User> state=loginController.login(user);
		//断言
		assertEquals(true,state.getState_id());
	}
	@Test
	public void registerTestFalse(){
		//测试对象
		//数据实体
		User user = new User();
		//假数据
		user.setUsername("user_id");
		user.setPassword("password");
		user.setBirthday(null);
		user.setGrade("231");
		user.setUser_code("2");
		user.setSex("2");
		user.setInterest("21");
		user.setIntroduce("23");
		//service对象
		MockUp<RegisterService>  registerService = new MockUp<RegisterService>() {
			@Mock
			public State<Boolean> register(String username, String password, String e_mail, String birthday, String grade, String user_code, String sex, String interest, String introduce) {
				//返回为错误
				State<Boolean> state = new State<Boolean>();
				state.setState_id(false);
				state.setData(false);
				state.setError(null);
				return state;
			}
		};
		new Expectations() {
			{
				//将service返回到测试对象
				Deencapsulation.setField(loginController, "registerService", registerService.getMockInstance());
			}
		};
		State<Boolean> state=loginController.register(user);
		//断言
		assertEquals(false,state.getState_id());
	}
	@Test
	public void registerTestTrue(){
		//测试对象
		//数据实体
		User user = new User();
		//假数据
		user.setUsername("user_id");
		user.setPassword("password");
		user.setBirthday(null);
		user.setGrade("231");
		user.setUser_code("2");
		user.setSex("2");
		user.setInterest("21");
		user.setIntroduce("23");
		//service对象
		MockUp<RegisterService>  registerService = new MockUp<RegisterService>() {
			@Mock
			public State<Boolean> register(String username, String password, String e_mail, String birthday, String grade, String user_code, String sex, String interest, String introduce) {
				//返回为错误
				State<Boolean> state = new State<Boolean>();
				state.setState_id(true);
				state.setData(true);
				state.setError(null);
				return state;
			}
		};
		new Expectations() {
			{
				//将service返回到测试对象
				Deencapsulation.setField(loginController, "registerService", registerService.getMockInstance());
			}
		};
		State<Boolean> state=loginController.register(user);
		//断言
		assertEquals(true,state.getState_id());
	}
	@Test
	public void e_mailJudgeFalse(){
		MockUp<HttpServletRequest> request = new MockUp<HttpServletRequest>(){};
		String email="123";
		MockUp<UserService> userService=new MockUp<UserService>() {
			@Mock
			public State<User> e_mailJudge(String email){
				State<User> state=new State<>();
				state.setState_id(false);
				state.setData(null);
				state.setError("密码错误");
				return  state;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(loginController,"userService",userService.getMockInstance());
			}
		};
		State<User> state=loginController.e_mailJudge(request.getMockInstance());
		assertEquals(false,state.getState_id());
	}
	@Test
	public void e_mailJudgeTrue(){
		MockUp<HttpServletRequest> request = new MockUp<HttpServletRequest>(){};
		User user=new User();
		user.setUserid(123);
		String email="123";
		MockUp<UserService> userService=new MockUp<UserService>() {
			@Mock
			public State<User> e_mailJudge(String email){
				State<User> state=new State<>();
				state.setState_id(true);
				state.setData(null);
				state.setError("密码错误");
				return  state;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(loginController,"userService",userService.getMockInstance());
			}
		};
		State<User> state=loginController.e_mailJudge(request.getMockInstance());
		assertEquals(true,state.getState_id());
	}
	@Test
	public void editPasswordTestFalse()  {
		request.setAttribute("x","1230");
		System.out.println(request.getParameter("x"));
		boolean result=loginController.editPassword(request);
		assertEquals(false,result);
	}
	@Test
	public void editPasswordTestTrue(){
		new Expectations(){
			{
				userService.editPassword("userid","password");
				result= true;
			}
			{
				request.getParameter("userid");
				result="userid";
			}
			{
				request.getParameter("password");
				result="password";
			}
		};
		boolean result=loginController.editPassword(request);
		assertEquals(true,result);
	}


}
