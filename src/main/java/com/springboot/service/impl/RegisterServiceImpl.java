package com.springboot.service.impl;

import com.springboot.dao.AnotationUserDao;
import com.springboot.entity.State;
import com.springboot.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private AnotationUserDao userDao;
	@Override
	public State<Boolean> register(String username, String password, String e_mail, String birthday, String grade, String user_code, String sex, String interest, String introduce) {
		State<Boolean> booleanState = new State<>();
		if (userDao.judgeExistence(username)!=null){
			booleanState.setState_id(false);
			booleanState.setData(false);
			booleanState.setError("用户名已存在");
			System.out.println("用户名已存在");
		}else{
			int user=userDao.register(username, password, e_mail, birthday,grade,user_code,sex,interest,introduce);
			System.out.println(user);
			if (user!=0){
				booleanState.setState_id(true);
				booleanState.setData(true);
				booleanState.setError(null);
				System.out.println(booleanState.getState_id());
				return booleanState;
			}
			booleanState.setState_id(false);
			booleanState.setData(false);
			System.out.println(booleanState.getState_id());
			booleanState.setError(null);
		}
		return booleanState;

	}


}
