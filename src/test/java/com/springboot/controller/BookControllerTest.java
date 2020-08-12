package com.springboot.controller;

import com.springboot.entity.*;
import com.springboot.entity.book.BookPageInfo;
import com.springboot.entity.userEntity.User;
import com.springboot.service.BookService;
import com.springboot.service.TopService;
import mockit.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookControllerTest {
    @Tested
    BookController bookController;
    @Test
    public void getBooksByInputInfoTestFalse() {
        Book book = new Book();
        MockUp<BookService> bookService =new MockUp<BookService>() {
            @Mock
            public State<ArrayList<Book>> getBooksByInputInfo(int bookid,String authorName,String bookName,String educationName){
                State<ArrayList<Book>> listState = new State<>();
                listState.setState_id(false);
                listState.setData(null);
                listState.setError(null);
                return listState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookController,"bookService",bookService.getMockInstance());
            }

        };
        State<ArrayList<Book>> state=bookController.getBooksByInputInfo(book);
        assertEquals(false,state.getState_id());
    }
    @Test
    public void getBooksByInputInfoTestTrue() {
        Book book = new Book();
        MockUp<BookService> bookService =new MockUp<BookService>() {
            @Mock
            public State<ArrayList<Book>> getBooksByInputInfo(int bookid,String authorName,String bookName,String educationName){
                State<ArrayList<Book>> listState = new State<>();
                listState.setState_id(true);
                listState.setData(null);
                listState.setError(null);
                return listState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookController,"bookService",bookService.getMockInstance());
            }

        };
        State<ArrayList<Book>> state=bookController.getBooksByInputInfo(book);
        assertEquals(true,state.getState_id());
    }
    @Test
    public void getBooksByPramTestFalse() {
        BookPageInfo bookPageInfo = new BookPageInfo();
        MockUp<BookService> bookService =new MockUp<BookService>() {
            @Mock
            public Paging<ArrayList<Book>> getBooksByPram(int page,int count,int bookid,String authorName,String bookName,String educationName){
                Paging<ArrayList<Book>> listState = new Paging<ArrayList<Book>>();
                listState.setState_id(false);
                listState.setData(null);
                listState.setError(null);
                return listState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookController,"bookService",bookService.getMockInstance());
            }

        };
        Paging<ArrayList<Book>> state=bookController.getBooksByPram(bookPageInfo);
        assertEquals(false,state.getState_id());
    }
    @Test
    public void getBooksByPramTestTrue() {
        BookPageInfo bookPageInfo = new BookPageInfo();
        MockUp<BookService> bookService =new MockUp<BookService>() {
            @Mock
            public Paging<ArrayList<Book>> getBooksByPram(int page,int count,int bookid,String authorName,String bookName,String educationName){
                Paging<ArrayList<Book>> listState = new Paging<ArrayList<Book>>();
                listState.setState_id(true);
                listState.setData(null);
                listState.setError(null);
                return listState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookController,"bookService",bookService.getMockInstance());
            }

        };
        Paging<ArrayList<Book>> state=bookController.getBooksByPram(bookPageInfo);
        assertEquals(true,state.getState_id());
    }
    @Test
    public void book_addTestFalse() {
        Book book = new Book();
        MockUp<BookService> bookService =new MockUp<BookService>() {
            @Mock
            public boolean bookAdd(int bookid,String authorName,String bookName,String educationName,int quantity){
                return false;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookController,"bookService",bookService.getMockInstance());
            }

        };
        Boolean result=bookController.book_add(book);
        assertEquals(false,result);
    }
    @Test
    public void book_addTestTrue() {
        Book book = new Book();
        book.setBookid(2);
        MockUp<BookService> bookService =new MockUp<BookService>() {
            @Mock
            public boolean bookAdd(int bookid,String authorName,String bookName,String educationName,int quantity){

                return true;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookController,"bookService",bookService.getMockInstance());
            }

        };
        Boolean result=bookController.book_add(book);
        System.out.println(result);
        assertEquals(true,result);
    }
    @Test
    public void getBooksTestFalse() {
        MockUp<BookService> bookService =new MockUp<BookService>() {
            @Mock
            public State<ArrayList<Book>> getBooks(){
                State<ArrayList<Book>> listState = new State<>();
                listState.setState_id(false);
                listState.setData(null);
                listState.setError(null);
                return listState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookController,"bookService",bookService.getMockInstance());
            }

        };
        State<ArrayList<Book>> result=bookController.getBooks();
        assertEquals(false,result.getState_id());
    }
    @Test
    public void getBooksTestTrue() {
        MockUp<BookService> bookService =new MockUp<BookService>() {
            @Mock
            public State<ArrayList<Book>> getBooks(){
                State<ArrayList<Book>> listState = new State<>();
                listState.setState_id(true);
                listState.setData(null);
                listState.setError(null);
                return listState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookController,"bookService",bookService.getMockInstance());
            }

        };
        State<ArrayList<Book>> result=bookController.getBooks();
        assertEquals(true,result.getState_id());
    }
    @Test
    public void updataTestFalse() {
        Book book = new Book();
        MockUp<BookService> bookService =new MockUp<BookService>() {
            @Mock
            public State<Book> updata(int bookid,String authorName,String bookName,String educationName,int quantity ){
                State<Book> state = new State<>();
                state.setState_id(false);
                state.setData(null);
                state.setError(null);
                return state;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookController,"bookService",bookService.getMockInstance());
            }

        };
        State<Book> state=bookController.updata(book);
        assertEquals(false,state.getState_id());
    }
    @Test
    public void updataTestTrue() {
        Book book = new Book();
        MockUp<BookService> bookService =new MockUp<BookService>() {
            @Mock
            public State<Book> updata(int bookid,String authorName,String bookName,String educationName,int quantity ){
                State<Book> state = new State<>();
                state.setState_id(true);
                state.setData(null);
                state.setError(null);
                return state;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookController,"bookService",bookService.getMockInstance());
            }

        };
        State<Book> state=bookController.updata(book);
        assertEquals(true,state.getState_id());
    }
    @Test
    public void getBookTopTestFalse() {
        MockUp<TopService> topService =new MockUp<TopService>() {
            @Mock
            public State<ArrayList<BookTop>> getBookTop(){
                State<ArrayList<BookTop>> arrayListState = new State<>();
                arrayListState.setState_id(false);
                arrayListState.setData(null);
                arrayListState.setError(null);
                return arrayListState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookController,"topService",topService.getMockInstance());
            }

        };
        State<ArrayList<BookTop>> state=bookController.getBookTop();
        assertEquals(false,state.getState_id());
    }
    @Test
    public void getBookTopTestTrue() {
        MockUp<TopService> topService =new MockUp<TopService>() {
            @Mock
            public State<ArrayList<BookTop>> getBookTop(){
                State<ArrayList<BookTop>> arrayListState = new State<>();
                arrayListState.setState_id(true);
                arrayListState.setData(null);
                arrayListState.setError(null);
                return arrayListState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookController,"topService",topService.getMockInstance());
            }

        };
        State<ArrayList<BookTop>> state=bookController.getBookTop();
        assertEquals(true,state.getState_id());
    }
    @Test
    public void getUserTopTestFalse() {
        MockUp<TopService> topService =new MockUp<TopService>() {
            @Mock
            public State<ArrayList<UserTop>> getUserTop(){
                State<ArrayList<UserTop>> arrayListState = new State<ArrayList<UserTop>>();
                arrayListState.setState_id(false);
                arrayListState.setData(null);
                arrayListState.setError(null);
                return arrayListState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookController,"topService",topService.getMockInstance());
            }

        };
        State<ArrayList<UserTop>> state=bookController.getUserTop();
        assertEquals(false,state.getState_id());
    }
    @Test
    public void getUserTopTestTrue() {
        MockUp<TopService> topService =new MockUp<TopService>() {
            @Mock
            public State<ArrayList<UserTop>> getUserTop(){
                State<ArrayList<UserTop>> arrayListState = new State<ArrayList<UserTop>>();
                arrayListState.setState_id(true);
                arrayListState.setData(null);
                arrayListState.setError(null);
                return arrayListState;
            }
        };
        new Expectations(){
            {
                Deencapsulation.setField(bookController,"topService",topService.getMockInstance());
            }

        };
        State<ArrayList<UserTop>> state=bookController.getUserTop();
        assertEquals(true,state.getState_id());
    }
}