package com.springboot.controller;

import javax.servlet.http.HttpServletRequest;


import com.springboot.entity.*;
import com.springboot.entity.userEntity.User;

import com.springboot.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@CrossOrigin(origins = { "http://localhost:4200", "null" })
@Transactional(rollbackFor=RuntimeException.class)
@RestController
public class LoginController {
	private TopService topService;
	@Autowired
	public void setTopService (TopService topService){
		this.topService = topService;
	}
	private BookService bookService;
	@Autowired
	public  void setBookService(BookService bookService){
		this.bookService= bookService;
	}
	private RegisterService registerService;
	@Autowired
	public  void  setRegisterService(RegisterService registerService){
		this.registerService= registerService;
	}
	private UserLogService userLogService;
	@Autowired
	public  void setUserLogService(UserLogService userLogService){
		this.userLogService=userLogService;
	}
	private UserService userService;
	@Autowired
	public void setUserService(UserService userService){
		this.userService=userService;
	}
	@PostMapping(value = "/login")
	@ResponseBody
	public State<User> login(@RequestBody User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		State<User> state = new State<>();
		state = userService.checkPassword(username, password);
		if (state.getState_id()==false){
			try {
				System.out.println("错误进行回滚");
				throw new RuntimeException("异常测试45_2");
			}catch (Exception e){

				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}
		}
		return state;
	}
	@PostMapping(value = "/register")
	public  State<Boolean> register(@RequestBody User user){
		System.out.println(user);
		State<Boolean> booleanState = new State<>();
		int userid=user.getUserid();
		System.out.println("text");
		System.out.println(user);
		booleanState = registerService.register(user.getUsername(),user.getPassword(),user.getE_mail(),user.getBirthday(),
				user.getGrade(),user.getUser_code(),user.getSex(),user.getInterest(),user.getIntroduce());
		if (booleanState.getState_id()==false){
			try {
				System.out.println("错误进行回滚");
				throw new RuntimeException("异常测试45_2");
			}catch (Exception e){

				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}
		}
		return booleanState;
	}

	@GetMapping(value = "/e_mailJudge")
	public State<User> e_mailJudge(HttpServletRequest request){
		String e_mail=request.getParameter("email");
		State<User> state =userService.e_mailJudge(e_mail);
		if (state.getState_id()==false){
			try {
				System.out.println("错误进行回滚");
				throw new RuntimeException("异常测试45_2");
			}catch (Exception e){

				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}
		}
		return state;
	}
	@GetMapping(value = "/editPassword")
    public boolean editPassword(HttpServletRequest request){
        System.out.println(request.getParameter("userid") + "   " + request.getParameter("password"));
        String password = request.getParameter("password");
        if (userService.editPassword(request.getParameter("userid"), password)){
            return true;
        }
        try {
        	System.out.println("错误进行回滚");
        	throw new RuntimeException("异常测试45_2");
        }catch (Exception e){
        	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

}
