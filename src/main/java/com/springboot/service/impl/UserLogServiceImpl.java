package com.springboot.service.impl;

import com.springboot.dao.UserLogDao;
import com.springboot.entity.State;
import com.springboot.entity.UserLog;
import com.springboot.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserLogServiceImpl implements UserLogService {

    private UserLogDao userLogDao;
    @Autowired
    public void setUserLogDao(UserLogDao userLogDao){
        this.userLogDao=userLogDao;
    }
    @Override
    public State<ArrayList<UserLog>> getLog() {
        State<ArrayList<UserLog>> arrayListState = new State<>();
        ArrayList<UserLog> userLogs = new ArrayList<>();
        userLogs=userLogDao.getLog();
        System.out.println("userLogs=" + userLogs);
        if (userLogs!=null){
            arrayListState.setState_id(true);
            arrayListState.setData(userLogs);
            arrayListState.setError(null);
            return arrayListState;
        }
        arrayListState.setState_id(false);
        arrayListState.setData(null);
        arrayListState.setError(null);
        return arrayListState;
    }
}
