package com.springboot.service.impl;

import com.springboot.dao.TopDao;
import com.springboot.entity.BookTop;
import com.springboot.entity.State;
import com.springboot.entity.UserTop;
import com.springboot.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class TopServiceImpl implements TopService {
    @Autowired
    TopDao topDao;
    @Override
    public State<ArrayList<BookTop>> getBookTop() {
        State<ArrayList<BookTop>> arrayListState = new State<>();
        ArrayList<BookTop> bookTops = topDao.getBookTop();
        if(bookTops!=null){
            arrayListState.setState_id(true);
            arrayListState.setData(bookTops);
            arrayListState.setError(null);
            return arrayListState;
        }
        arrayListState.setState_id(false);
        arrayListState.setData(null);
        arrayListState.setError(null);
        return arrayListState;
    }

    @Override
    public State<ArrayList<UserTop>> getUserTop() {
        State<ArrayList<UserTop>> arrayListState = new State<>();
        ArrayList<UserTop> userTops = topDao.getUserTop();
        if(userTops!=null){
            arrayListState.setState_id(true);
            arrayListState.setData(userTops);
            arrayListState.setError(null);
            return arrayListState;
        }
        arrayListState.setState_id(false);
        arrayListState.setData(null);
        arrayListState.setError(null);
        return arrayListState;
    }
}
