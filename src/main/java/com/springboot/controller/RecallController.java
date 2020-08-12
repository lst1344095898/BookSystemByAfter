package com.springboot.controller;

import com.springboot.entity.BorrowInfo;
import com.springboot.entity.State;
import com.springboot.service.RecallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200", "null"})
@Transactional(rollbackFor = RuntimeException.class)
@RestController
public class RecallController {
    private  RecallService recallService;
    @Autowired
    public void setRecallService(RecallService recallService){
        this.recallService=recallService;
    }
    // 添加催还的信息
    @PostMapping(value = "/recallAdd")
    public State<Boolean> recallAdd(@RequestBody BorrowInfo borrowInfo){
        State<Boolean> state = new State<>();
        state=recallService.recallAdd(borrowInfo);
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
    // 延长借阅（图书id,userid）
    @PostMapping(value = "/delay")
    public State<Boolean> delay(@RequestBody BorrowInfo borrowInfo){
        State<Boolean> state=recallService.delay(borrowInfo);
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
}
