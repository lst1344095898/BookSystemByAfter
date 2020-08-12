package com.springboot.service;

import com.springboot.entity.Book;
import com.springboot.entity.State;
import com.springboot.entity.UserLog;

import java.util.ArrayList;

public interface UserLogService {
    State<ArrayList<UserLog>> getLog();
}
