package com.springboot.controller;

import com.springboot.entity.Paging;
import com.springboot.entity.SelectInfo;
import com.springboot.entity.State;
import com.springboot.entity.UserLog;
import com.springboot.entity.userEntity.User;
import com.springboot.entity.userEntity.UserManagement;
import com.springboot.service.UserLogService;
import com.springboot.service.UserService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import mockit.*;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class UserControllerTest {
    UserController userController = new UserController();
    @Injectable
    UserService userService;

    @Test
    public void getUserInfoByIdTestFalse() {
//        User user = new User();
//        user.setUsername("user_id");
//        user.setPassword("password");
        MockUp<HttpServletRequest> request=new MockUp<HttpServletRequest>(){};
        MockUp<UserService> userService = new MockUp<UserService>() {
            @Mock
            public State<ArrayList<User>> getUserInfoById(String userid) {
                State<ArrayList<User>> state = new State<>();
                state.setState_id(false);
                state.setData(null);
                state.setError(null);
                return state;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(userController,"userService",userService.getMockInstance());
            }
        };
        State<ArrayList<User>> stateState=userController.getUserInfoById(request.getMockInstance());
        assertEquals(false,stateState.getState_id());

    }
    @Test
    public void getUserInfoByIdTestTrue() {
//        User user = new User();
//        user.setUsername("user_id");
//        user.setPassword("password");
        MockUp<HttpServletRequest> request=new MockUp<HttpServletRequest>(){};
        MockUp<UserService> userService = new MockUp<UserService>() {
            @Mock
            public State<ArrayList<User>> getUserInfoById(String userid) {
                State<ArrayList<User>> state = new State<>();
                state.setState_id(true);
                state.setData(null);
                state.setError(null);
                return state;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(userController,"userService",userService.getMockInstance());
            }
        };
        State<ArrayList<User>> stateState=userController.getUserInfoById(request.getMockInstance());
        assertEquals(true,stateState.getState_id());

    }

    @Test
    public void editUserTestFalse() {
        User user = new User();
        user.setUsername("user_id");
        user.setPassword("password");
        MockUp<UserService> userService = new MockUp<UserService>() {
            @Mock
            public State<String> editUser(int userid, String username, String e_mail, String birthday, String sex, String grade, String interest, String introduce) {
                State<String> stringState = new State<>();
                stringState.setState_id(false);
                stringState.setData(null);
                stringState.setError(null);
                return stringState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(userController,"userService",userService.getMockInstance());
            }
        };
        State<String> stateState=userController.editUser(user);
        assertEquals(false,stateState.getState_id());

    }
    @Test
    public void editUserTestTrue() {
        User user = new User();
        user.setUsername("user_id");
        user.setPassword("password");
        MockUp<UserService> userService = new MockUp<UserService>() {
            @Mock
            public State<String> editUser(int userid, String username, String e_mail, String birthday, String sex, String grade, String interest, String introduce) {
                State<String> stringState = new State<>();
                stringState.setState_id(true);
                stringState.setData(null);
                stringState.setError(null);
                return stringState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(userController,"userService",userService.getMockInstance());
            }
        };
        State<String> stateState=userController.editUser(user);
        assertEquals(true,stateState.getState_id());

    }
    @Test
    public void getUserAllByInputTestFalse() {
        UserManagement userManagement = new UserManagement();
        userManagement.setUserid(1);
        userManagement.setUsername("23");
        MockUp<UserService> userService = new MockUp<UserService>() {
            @Mock
            public 	 Paging<ArrayList<User>> getUserAllByInput(int userid,String username,int page,int count)
            {
                Paging<ArrayList<User>> stringState = new Paging<ArrayList<User>>();
                stringState.setState_id(false);
                stringState.setData(null);
                stringState.setError(null);
                return stringState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(userController,"userService",userService.getMockInstance());
            }
        };
        Paging<ArrayList<User>> stateState=userController.getUserAllByInput(userManagement);
        assertEquals(false,stateState.getState_id());

    }
    @Test
    public void getUserAllByInputTestTrue() {
        UserManagement userManagement = new UserManagement();
        userManagement.setUserid(1);
        userManagement.setUsername("23");
        MockUp<UserService> userService = new MockUp<UserService>() {
            @Mock
            public 	 Paging<ArrayList<User>> getUserAllByInput(int userid,String username,int page,int count)
            {
                Paging<ArrayList<User>> stringState = new Paging<ArrayList<User>>();
                stringState.setState_id(true);
                stringState.setData(null);
                stringState.setError(null);
                return stringState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(userController,"userService",userService.getMockInstance());
            }
        };
        Paging<ArrayList<User>> stateState=userController.getUserAllByInput(userManagement);
        assertEquals(true,stateState.getState_id());

    }

    @Test
    public void getLogTestFalse() {
        SelectInfo selectInfo = new SelectInfo();
        selectInfo.setBookid("1");
        selectInfo.setBookName("123");
        MockUp<UserLogService> userLogService = new MockUp<UserLogService>() {
            @Mock
            public 	 State<ArrayList<UserLog>> getLog()
            {
                State<ArrayList<UserLog>> stringState = new State<ArrayList<UserLog>>();
                stringState.setState_id(false);
                stringState.setData(null);
                stringState.setError(null);
                return stringState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(userController,"userLogService",userLogService.getMockInstance());
            }
        };
        State<ArrayList<UserLog>> stateState=userController.getLog();
        assertEquals(false,stateState.getState_id());

    }
    @Test
    public void getLogTestTrue() {
        SelectInfo selectInfo = new SelectInfo();
        MockUp<UserLogService> userLogService = new MockUp<UserLogService>() {
            @Mock
            public 	 State<ArrayList<UserLog>> getLog()
            {
                State<ArrayList<UserLog>> stringState = new State<ArrayList<UserLog>>();
                stringState.setState_id(true);
                stringState.setData(null);
                stringState.setError(null);
                return stringState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(userController,"userLogService",userLogService.getMockInstance());
            }
        };
        State<ArrayList<UserLog>> stateState=userController.getLog();
        assertEquals(true,stateState.getState_id());

    }

}