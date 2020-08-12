package com.springboot.controller;

import static org.junit.Assert.*;

import com.springboot.entity.BorrowInfo;
import com.springboot.entity.State;
import com.springboot.service.RecallService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import mockit.*;
import org.junit.Test;

public class RecallControllerTest {
	@Tested
	RecallController recallController;
	@Test
	public void testRecallAddFalse() {
		BorrowInfo borrowInfo = new BorrowInfo();
		MockUp<RecallService> recallService=new MockUp<RecallService>() {
			@Mock
			State<Boolean> recallAdd(BorrowInfo borrowInfo1){
				State<Boolean> state = new State<>();
				state.setState_id(false);
				return state;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(recallController,"recallService",recallService.getMockInstance());
			}
		};
		State<Boolean> state = recallController.recallAdd(borrowInfo);
		assertEquals(false,state.getState_id());
	}
	@Test
	public void testRecallAddTrue() {
		BorrowInfo borrowInfo = new BorrowInfo();
		MockUp<RecallService> recallService=new MockUp<RecallService>() {
			@Mock
			State<Boolean> recallAdd(BorrowInfo borrowInfo1){
				State<Boolean> state = new State<>();
				state.setState_id(true);
				return state;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(recallController,"recallService",recallService.getMockInstance());
			}
		};
		State<Boolean> state = recallController.recallAdd(borrowInfo);
		assertEquals(true,state.getState_id());
	}

}
