package com.springboot.controller;

import com.springboot.entity.BorrowInfo;
import com.springboot.entity.State;
import com.springboot.service.BookService;
import mockit.*;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookBorrowControllerTest {
    @Tested
    BookBorrowController bookBorrowController;
    @Injectable
    BookService bookService;
    @Injectable
    HttpServletRequest request;
    @Test
    public void getBorrowBookTestFalse(){
        MockUp<BookService> bookService=new MockUp<BookService>() {
            @Mock
            public State<ArrayList<BorrowInfo>> getBorrowBook(){
                State<ArrayList<BorrowInfo>> arrayListState = new State<>();
                arrayListState.setState_id(false);
                arrayListState.setData(null);
                arrayListState.setError(null);
                return arrayListState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookBorrowController,"bookService",bookService.getMockInstance());
            }
        };
        State<ArrayList<BorrowInfo>> state=bookBorrowController.getBorrowBook();
        assertEquals(false,state.getState_id());
    }
    @Test
    public void getBorrowBookTestTrue(){
        MockUp<BookService> bookService=new MockUp<BookService>() {
            @Mock
            public State<ArrayList<BorrowInfo>> getBorrowBook(){
                State<ArrayList<BorrowInfo>> arrayListState = new State<>();
                arrayListState.setState_id(true);
                arrayListState.setData(null);
                arrayListState.setError(null);
                return arrayListState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookBorrowController,"bookService",bookService.getMockInstance());
            }
        };
        State<ArrayList<BorrowInfo>> state=bookBorrowController.getBorrowBook();
        assertEquals(true,state.getState_id());
    }
    @Test
    public void searchByInputTestFalse(){
        BorrowInfo borrowInfo = new BorrowInfo();
        MockUp<BookService> bookService=new MockUp<BookService>() {
            @Mock
            public State<ArrayList<BorrowInfo>> getBooksByInput(int userid,int bookid,String authorName,String bookName,String educationName){
                State<ArrayList<BorrowInfo>> arrayListState = new State<>();
                arrayListState.setState_id(false);
                arrayListState.setData(null);
                arrayListState.setError(null);
                return arrayListState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookBorrowController,"bookService",bookService.getMockInstance());
            }
        };
        State<ArrayList<BorrowInfo>> state=bookBorrowController.searchByInput(borrowInfo);
        assertEquals(false,state.getState_id());
    }
    @Test
    public void searchByInputTestTrue(){
        BorrowInfo borrowInfo = new BorrowInfo();
        MockUp<BookService> bookService=new MockUp<BookService>() {
            @Mock
            public State<ArrayList<BorrowInfo>> getBooksByInput(int userid,int bookid,String authorName,String bookName,String educationName){
                State<ArrayList<BorrowInfo>> arrayListState = new State<>();
                arrayListState.setState_id(true);
                arrayListState.setData(null);
                arrayListState.setError(null);
                return arrayListState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookBorrowController,"bookService",bookService.getMockInstance());
            }
        };
        State<ArrayList<BorrowInfo>> state=bookBorrowController.searchByInput(borrowInfo);
        assertEquals(true,state.getState_id());
    }
    @Test
    public void borrowAddTestFalse(){
        BorrowInfo borrowInfo = new BorrowInfo();
        borrowInfo.setBookid(1);
        borrowInfo.setUserid(1);
        MockUp<BookService> bookService=new MockUp<BookService>() {
            @Mock
            public State<Boolean> borrowAdd(int userid,int bookid,String authorName,String bookName,String educationName){
                State<Boolean> booleanState = new State<>();
                booleanState.setState_id(false);
                return booleanState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookBorrowController,"bookService",bookService.getMockInstance());
            }
        };
        State<Boolean> state=bookBorrowController.borrowAdd(borrowInfo);
        System.out.println(state);
        assertEquals(false,state.getState_id());
    }
    @Test
    public void borrowAddTestTrue(){
        BorrowInfo borrowInfo = new BorrowInfo();
        MockUp<BookService> bookService=new MockUp<BookService>() {
            @Mock
            public State<Boolean> borrowAdd(int userid,int bookid,String authorName,String bookName,String educationName){
                State<Boolean> booleanState = new State<>();
                booleanState.setState_id(true);
                return booleanState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookBorrowController,"bookService",bookService.getMockInstance());
            }
        };
        State<Boolean> state=bookBorrowController.borrowAdd(borrowInfo);
        assertEquals(true,state.getState_id());
    }
    @Test
    public void returnBookTestFalse(){
        MockUp<HttpServletRequest> request=new MockUp<HttpServletRequest>() {
        };
        MockUp<BookService> bookService=new MockUp<BookService>() {
            @Mock
            public boolean returnBook(String userid,String bookid){
                return false;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookBorrowController,"bookService",bookService.getMockInstance());
            }
        };
        boolean state=bookBorrowController.returnBook(request.getMockInstance());
        assertEquals(false,state);
    }
    @Test
    public void returnBookTestTrue(){
        new Expectations(){
            {
                bookService.returnBook("bookid","userid");
                result=true;
            }
            {
                request.getParameter("bookid");
                result="bookid";
            }
            {
                request.getParameter("userid");
                result="userid";
            }
        };
        boolean result=bookBorrowController.returnBook(request);
        assertEquals(true,result);
    }
    @Test
    public void getBorrowInfosByUserIdTestFalse(){
        State<ArrayList<BorrowInfo>> state= bookBorrowController.getBorrowInfosByUserId(request);
        assertEquals(false,state.getState_id());
    }
    @Test
    public void getBorrowInfosByUserIdTestTrue(){
        new Expectations(){
            {
                bookService.getBorrowInfosByUserId("userid");
                State<ArrayList<BorrowInfo>> state = new State<>();
                state.setState_id(true);
                result=state;
            }
            {
                request.getParameter("userid");
                result="userid";
            }
        };
        State<ArrayList<BorrowInfo>> state=bookBorrowController.getBorrowInfosByUserId(request);
        assertEquals(true,state.getState_id());
    }
}