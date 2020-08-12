package com.springboot.service.impl;

import static org.junit.Assert.*;

import com.springboot.dao.TopDao;
import com.springboot.entity.BookTop;
import com.springboot.entity.State;
import com.springboot.entity.UserTop;
import com.springboot.service.TopService;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import java.util.ArrayList;

public class TopServiceImplTest {
TopService topService=new TopServiceImpl();
	@Test
	public void getBookTopTestFalse() {
		MockUp<TopDao> topDao=new MockUp<TopDao>(){
			@Mock
			ArrayList<BookTop> getBookTop(){
				return  null;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(topService,"topDao",topDao.getMockInstance());
			}
		};
		State<ArrayList<BookTop>> state=topService.getBookTop();
		assertEquals(false,state.getState_id());
	}
	@Test
	public void getBookTopTestTrue() {
		MockUp<TopDao> topDao=new MockUp<TopDao>(){
			@Mock
			ArrayList<BookTop> getBookTop(){
				ArrayList<BookTop> bookTops = new ArrayList<BookTop>();
				BookTop bookTop=new BookTop();
				bookTop.setBookName("23123");
				bookTops.add(0,bookTop);
				return  bookTops;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(topService,"topDao",topDao.getMockInstance());
			}
		};
		State<ArrayList<BookTop>> state=topService.getBookTop();
		assertEquals(true,state.getState_id());
	}
	@Test
	public void getUserTopTestTrue() {
		MockUp<TopDao> topDao=new MockUp<TopDao>(){
			@Mock
			ArrayList<UserTop> getUserTop(){
				ArrayList<UserTop> userTops = new ArrayList<UserTop>();
				UserTop userTop=new UserTop();
				userTops.add(0,userTop);
				return  userTops;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(topService,"topDao",topDao.getMockInstance());
			}
		};
		State<ArrayList<UserTop>> state=topService.getUserTop();
		assertEquals(true,state.getState_id());
	}
	@Test
	public void getUserTopTestFalse() {
		MockUp<TopDao> topDao=new MockUp<TopDao>(){
			@Mock
			ArrayList<UserTop> getUserTop(){
				return  null;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(topService,"topDao",topDao.getMockInstance());
			}
		};
		State<ArrayList<UserTop>> state=topService.getUserTop();
		assertEquals(false,state.getState_id());
	}

}
