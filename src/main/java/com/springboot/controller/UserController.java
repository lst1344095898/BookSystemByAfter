package com.springboot.controller;

import com.springboot.entity.Paging;
import com.springboot.entity.SelectInfo;
import com.springboot.entity.State;
import com.springboot.entity.UserLog;
import com.springboot.entity.userEntity.User;
import com.springboot.entity.userEntity.UserManagement;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;
import com.springboot.service.UserLogService;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@CrossOrigin(origins = {"http://localhost:4200", "null"})
@RestController
@Transactional(rollbackFor = RuntimeException.class)
public class UserController {

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService=userService;
    }
    private UserLogService userLogService;
    @Autowired
    public void setUserLogService(UserLogService userLogService){
        this.userLogService=userLogService;
    }
    @GetMapping(value = "getUserInfo")
    @ResponseBody
    public State<ArrayList<User>> getUserInfoById(HttpServletRequest request){
        System.out.println(request.getParameter("userid"));
//        int userid=Integer.parseInt(request.getParameter("userid").trim());
        State<ArrayList<User>> arrayListState = new State<>();
        arrayListState = userService.getUserInfoById(request.getParameter("userid"));
        if (arrayListState.getState_id()==false){
            try {
                System.out.println("错误进行回滚");
                throw new RuntimeException("异常测试45_2");
            }catch (Exception e){

                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return arrayListState;
    }
    @PostMapping(value = "editUser")
    public State<String> editUser(@RequestBody User user){
        System.out.println(user);
        State<String> stringState = userService.editUser(user.getUserid(),user.getUsername(), user.getE_mail(),
                user.getBirthday(), user.getSex(), user.getGrade(), user.getInterest(), user.getIntroduce());
        if (stringState.getState_id()==false){
            try {
                System.out.println("错误进行回滚");
                throw new RuntimeException("异常测试45_2");
            }catch (Exception e){

                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return stringState;
    }

    @PostMapping(value = "getUserAllByInput")
    public Paging<ArrayList<User>> getUserAllByInput(@RequestBody UserManagement userManagement){ //根据前端传上来的用户检索信息来获得limit用户
        System.out.println("userManagement:" + userManagement);
        Paging<ArrayList<User>> arrayListPaging = new Paging<>();
        arrayListPaging=userService.getUserAllByInput(userManagement.getUserid(),userManagement.getUsername(),
                userManagement.getPage(),userManagement.getCount()); //将得到的用户返回到Paging中，将前端参数添加到函数实参
        if (arrayListPaging.getState_id()==false){
            try {
                System.out.println("错误进行回滚");
                throw new RuntimeException("异常测试45_2");
            }catch (Exception e){

                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return  arrayListPaging;
    }
    @GetMapping(value = "/getLog")
    public State<ArrayList<UserLog>> getLog(){
        State<ArrayList<UserLog>> userLogState = new State<>();
        userLogState= userLogService.getLog();
        if (userLogState.getState_id()==false){
            try {
                System.out.println("异常测试45_2");
                throw new RuntimeException("异常测试45_2");
            }catch (Exception e){

                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return userLogState;
    }
//    @Transactional(rollbackFor = RuntimeException.class)
    @PostMapping(value = "/deletUser")
    public State<Boolean> deletUser(@RequestBody User user){
        State<Boolean> state = new State<>();
        state = userService.deletUser(user);
        if (state.getState_id()==false){
            try {
                System.out.println("异常测试45_2");
                throw new RuntimeException("异常测试45_2");
            }catch (Exception e){

                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				}
			}
        return state;
    }
}
