package com.springboot.service;

import com.springboot.entity.Paging;
import com.springboot.entity.State;
import com.springboot.entity.userEntity.User;

import java.util.Date;
import java.util.ArrayList;

public interface UserService {
	 State<User> checkPassword(String username, String password);
	 User getUserByName(String username);
	 State<ArrayList<User>> getUserInfoById(String userid);
	 State<String> editUser(int userid, String username, String e_mail, String birthday ,String sex,String grade, String interest, String introduce);
	 Paging<ArrayList<User>> getUserAllByInput(int userid,String username,int page,int count);
	 State<User> e_mailJudge(String e_mail);
	 boolean editPassword(String userid,String password);
	 State<Boolean> deletUser(User user);
//	public List<User> getAll();
}
