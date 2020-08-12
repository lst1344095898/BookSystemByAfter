package com.springboot.service.impl;

import com.springboot.dao.UserLogDao;
import com.springboot.entity.Paging;
import com.springboot.entity.State;

import com.springboot.entity.userEntity.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.AnotationUserDao;
import com.springboot.entity.userEntity.User;
import com.springboot.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private AnotationUserDao userDao;
	@Override
	public State<User> checkPassword(String username, String password) {
		User user = userDao.findById(username);
		System.out.println(user);
		State<User> state = new State<>();
		if (user != null && password.equals(user.getPassword())) {
//			getLoginDate(username);
			state.setState_id(true);
			state.setData(user);
			state.setError(null);
			return state;
		}
		state.setState_id(false);
		state.setData(null);
		state.setError(null);
		return state;
	}
	@Override
	public User getUserByName(String username) {
		User user = userDao.findById(username);
		return user;
	}

	@Override
	public State<ArrayList<User>> getUserInfoById(String userid) {
		State<ArrayList<User>> state = new State<ArrayList<User>>();
		ArrayList<User> user = userDao.getUserInfoById(userid);
		if (user!=null){
			state.setState_id(true);
			state.setData(user);
			state.setError(null);
			return state;
		}
		state.setState_id(false);
		state.setData(null);
		state.setError(null);
		return state;

	}

	@Override
	public State<String> editUser(int userid, String username, String e_mail, String birthday, String sex, String grade, String interest, String introduce) {
		State<String> stringState = new State<>();
		boolean state=userDao.editUser(userid,username,e_mail,birthday,sex,grade,interest,introduce);
		if (state){
			stringState.setState_id(true);
			stringState.setData("修改成功");
			stringState.setError(null);
			return stringState;
		}
		stringState.setState_id(false);
		stringState.setData("修改失败");
		stringState.setError(null);
		return stringState;
	}

	@Override
	public Paging<ArrayList<User>> getUserAllByInput(int userid, String username, int page, int count) { //services实现类实现从数据库得到数据
		Paging<ArrayList<User>> arrayListPaging =new Paging<ArrayList<User>>(); //得到Pageing对象
		ArrayList<User> users= new ArrayList<>(); //得到User对象
		System.out.println("userid:"+userid);
		users=userDao.getUserAllByInput(userid,username,page,count); //得到用户限定消息
		UserManagement pageNew = userDao.getPage(userid,username); //得到用户的页数
		String pages =pageNew.getPageNew();
		if (users!=null){
			arrayListPaging.setState_id(true);
			arrayListPaging.setData(users);
			arrayListPaging.setError(null);
			if (pageNew!=null){
				arrayListPaging.setPages(pages);
				System.out.println(pageNew);
				System.out.println(pages);
			}else{
				arrayListPaging.setPages("1");
			}
			return arrayListPaging;
		}
		arrayListPaging.setState_id(false);
		arrayListPaging.setData(null);
		arrayListPaging.setPages("1");
		arrayListPaging.setError(null);
		return  arrayListPaging;
	}

	@Override
	public State<User> e_mailJudge(String e_mail) {
		State<User> state = new State<>();
		System.out.println(e_mail);
		System.out.println(userDao.e_mailJudge(e_mail));
		if (userDao.e_mailJudge(e_mail)!=null){
			User user=userDao.getUserBuE_mail(e_mail);
			if (user!=null){
				state.setState_id(true);
				state.setData(user);
				state.setError(null);
				return state;
			}
			state.setState_id(false);
			state.setData(null);
			state.setError(null);
			return state;
		}
		else {
			state.setState_id(false);
			state.setData(null);
			state.setError("邮箱错误");
			return state;
		}
	}

	@Override
	public boolean editPassword(String userid, String password) {
		if (userDao.editPassword(userid, password)!=0){
			return true;
		}
		return false;
	}
//	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public State<Boolean> deletUser(User user) throws RuntimeException{
		State<Boolean> state = new State<>();
		if (userDao.deletUser(user.getUserid())!=0){
			state.setState_id(true);
			state.setData(true);
			state.setError(null);
//			if (user.getUserid()==45){
//				try {
//					throw new RuntimeException("异常测试45_2");
//				}catch (Exception e){
//					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//					state.setState_id(false);
//					state.setData(false);
//					state.setError(e.getMessage());
//					return state;
//				}
//			}
			return state;
		}

		state.setState_id(false);
		state.setData(false);
		state.setError(null);
		return state;
	}
}
