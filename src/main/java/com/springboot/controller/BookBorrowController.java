package com.springboot.controller;

import com.springboot.entity.Book;
import com.springboot.entity.BorrowInfo;
import com.springboot.entity.State;
import com.springboot.service.BookService;
import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@CrossOrigin(origins = { "http://localhost:4200", "null" })
@Transactional(rollbackFor = RuntimeException.class)
@RestController
public class BookBorrowController {
    private BookService bookService;
    @Autowired
    public void setBookService(BookService bookService){
        this.bookService=bookService;
    }
    @GetMapping(value = "/getBorowBooks")
    public State<ArrayList<BorrowInfo>> getBorrowBook(){
        System.out.println("getBorrowBook");
        State<ArrayList<BorrowInfo>> arrayListState = new State<>();
        arrayListState=bookService.getBorrowBook();
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
    @PostMapping(value = "/booksByInput")
    public State<ArrayList<BorrowInfo>> searchByInput(@RequestBody BorrowInfo borrowInfo){
        System.out.println(borrowInfo);
        State<ArrayList<BorrowInfo>> listState = bookService.getBooksByInput(borrowInfo.getUserid(),borrowInfo.getBookid(),
                borrowInfo.getAuthorName(),borrowInfo.getBookName(),borrowInfo.getEducationName());
        if (listState.getState_id()==false){
            try {
                System.out.println("错误进行回滚");
                throw new RuntimeException("异常测试45_2");
            }catch (Exception e){

                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return listState;
    }
    @PostMapping(value = "/borrowAdd")
    public State<Boolean> borrowAdd(@RequestBody BorrowInfo borrowInfo){
        System.out.println(borrowInfo);
        State<Boolean> booleanState = new State<Boolean>();
        booleanState=bookService.borrowAdd(borrowInfo.getUserid(),borrowInfo.getBookid(),
                borrowInfo.getAuthorName(),borrowInfo.getBookName(),borrowInfo.getEducationName());
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
    @GetMapping(value = "/returnBook")
    @ResponseBody
    public boolean returnBook(HttpServletRequest request){
        if(bookService.returnBook(request.getParameter("bookid"),request.getParameter("userid"))){
            System.out.println("true");
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
    @GetMapping(value = "/getBorrowInfosByUserId")
    public State<ArrayList<BorrowInfo>> getBorrowInfosByUserId(HttpServletRequest request){
        System.out.println(request.getParameter("userid"));
        State<ArrayList<BorrowInfo>> arrayListState = new State<>();
        arrayListState=bookService.getBorrowInfosByUserId(request.getParameter("userid"));
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

}
