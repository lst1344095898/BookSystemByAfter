package com.springboot.service;

import com.springboot.entity.BookTop;
import com.springboot.entity.State;
import com.springboot.entity.UserTop;

import java.util.ArrayList;

public interface TopService {
    State<ArrayList<BookTop>> getBookTop();
    State<ArrayList<UserTop>> getUserTop();
}
