package com.springboot.service.impl;

import static org.junit.Assert.*;

import com.springboot.dao.UserLogDao;
import com.springboot.entity.State;
import com.springboot.entity.UserLog;
import com.springboot.service.UserLogService;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import java.util.ArrayList;

public class UserLogServiceImplTest {
	UserLogService userLogService=new UserLogServiceImpl();
	@Test
	public void testGetLogFalse() {
		MockUp<UserLogDao>  userLogDao=new MockUp<UserLogDao>() {
			@Mock
			ArrayList<UserLog> getLog(){
				return null;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(userLogService,"userLogDao",userLogDao.getMockInstance());
			}
		};
		State<ArrayList<UserLog>> state=userLogService.getLog();
		assertEquals(false,state.getState_id());
	}
	@Test
	public void testGetLogTrue() {
		MockUp<UserLogDao>  userLogDao=new MockUp<UserLogDao>() {
			@Mock
			ArrayList<UserLog> getLog(){
				ArrayList<UserLog> userLog = new ArrayList<UserLog>();
				UserLog userLog2=new UserLog();
				userLog.add(0,userLog2);
				return userLog;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(userLogService,"userLogDao",userLogDao.getMockInstance());
			}
		};
		State<ArrayList<UserLog>> state=userLogService.getLog();
		assertEquals(true,state.getState_id());
	}

}
