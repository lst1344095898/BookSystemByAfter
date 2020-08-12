package com.springboot.service;

import com.springboot.entity.BorrowInfo;
import com.springboot.entity.State;

public interface RecallService {
    State<Boolean> recallAdd(BorrowInfo borrowInfo);
    State<Boolean> delay(BorrowInfo borrowInfo);
}
