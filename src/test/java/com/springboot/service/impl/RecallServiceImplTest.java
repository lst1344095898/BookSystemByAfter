package com.springboot.service.impl;

import static org.junit.Assert.*;

import com.springboot.dao.RecallDao;
import com.springboot.entity.BorrowInfo;
import com.springboot.entity.State;
import com.springboot.service.RecallService;
import mockit.*;
import org.junit.Test;

public class RecallServiceImplTest {
	@Tested
	RecallService recallService=new RecallServiceImpl();
	@Test
	public void testRecallAddFase() {
		BorrowInfo borrowInfo = new BorrowInfo();
		MockUp<RecallDao> recallDao=new MockUp<RecallDao>() {
			@Mock
			int recallAdd(int userid,int bookid,String username,String startTime){
				return 0;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(recallService,"recallDao",recallDao.getMockInstance());
			}
		};
		State<Boolean> state=recallService.recallAdd(borrowInfo);
		assertEquals(false,state.getState_id());
	}
	@Test
	public void testRecallAddTrue() {
		BorrowInfo borrowInfo = new BorrowInfo();
		MockUp<RecallDao> recallDao=new MockUp<RecallDao>() {
			@Mock
			int recallAdd(int userid,int bookid,String username,String startTime){
				return 0;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(recallService,"recallDao",recallDao.getMockInstance());
			}
		};
		State<Boolean> state=recallService.recallAdd(borrowInfo);
		assertEquals(false,state.getState_id());
	}

}
