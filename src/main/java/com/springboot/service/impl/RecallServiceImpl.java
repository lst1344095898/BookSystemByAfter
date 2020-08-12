package com.springboot.service.impl;

import com.springboot.dao.RecallDao;
import com.springboot.entity.BorrowInfo;
import com.springboot.entity.State;
import com.springboot.service.RecallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RecallServiceImpl implements RecallService {

    private RecallDao recallDao;
    @Autowired
    public void setRecallDao(RecallDao recallDao){
        this.recallDao=recallDao;
    }
    @Override
    public State<Boolean> recallAdd(BorrowInfo borrowInfo) {
        State<Boolean> state = new State<>();
        if (recallDao.recallAdd(borrowInfo.getUserid(),borrowInfo.getBookid(),borrowInfo.getBookName(),borrowInfo.getStartTime())==1){
            state.setState_id(true);
            state.setData(true);
            state.setError(null);
            return  state;
        }
        state.setState_id(false);
        state.setData(false);
        state.setError(null);
        return  state;
    }

    @Override
    public State<Boolean> delay(BorrowInfo borrowInfo) {
        State<Boolean> state=new State<>();
        String date=getDate();
        System.out.println("borrowInfo="+borrowInfo +"\n date="+ date);
        if (recallDao.delay(borrowInfo.getBookid(),borrowInfo.getUserid(),date)!=0){
            state.setState_id(true);
            state.setData(true);
            state.setError(null);
            return state;
        }
        state.setState_id(false);
        state.setData(false);
        state.setError(null);
        return state;
    }
    public String getDate(){
        SimpleDateFormat df_24=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将deta类型日期转换为数据库特有类型。
        String register_datetime=df_24.format(new Date());
        return register_datetime;
    }
}
