package com.springboot.controller;

import com.springboot.entity.*;
import com.springboot.entity.book.BookPageInfo;
import com.springboot.service.BookService;
import com.springboot.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = {"http://localhost:4200", "null" })
@RestController
@Transactional(rollbackFor = RuntimeException.class)
public class BookController {
    @Autowired
    private BookService bookService;
    public void setBookService(BookService bookService){
        this.bookService=bookService;
    }
    private TopService topService;
    @Autowired
    public void setTopService(TopService topService){
        this.topService=topService;
    }
    // 通过输入信息得到图书
    @PostMapping(value = "/getBooksByInputInfo")
    public State<ArrayList<Book>> getBooksByInputInfo(@RequestBody Book book){
        System.out.println(book);
        State<ArrayList<Book>> listState =bookService.getBooksByInputInfo(book.getBookid(),book.getAuthorName(),book.getBookName(),book.getEducationName());
        if (listState.getState_id()==false){
            try {
                throw  new RuntimeException("操作失败进行回滚");
            }catch (Exception e){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }
        return listState;
    }
    //通过分页得到图书（分页数据，起始页，每页条数，图书检索信息）
    @PostMapping(value = "/booksByPram")
    public Paging<ArrayList<Book>> getBooksByPram(@RequestBody BookPageInfo bookPageInfo){
        System.out.println(bookPageInfo);
        Paging<ArrayList<Book>> arrayListPaging = new Paging<>();
        arrayListPaging=bookService.getBooksByPram(bookPageInfo.getPage(),bookPageInfo.getCount(),
                bookPageInfo.getBookid(),bookPageInfo.getAuthorName(),bookPageInfo.getBookName(),bookPageInfo.getEducationName());
        System.out.println(arrayListPaging.getPages());
        return arrayListPaging;
    }
    // 添加图书，（参数是图书信息）
    @PostMapping(value = "/book_add")
    public boolean book_add(@RequestBody Book book){
        System.out.println(book);
        if (bookService.bookAdd(book.getBookid(),book.getAuthorName(),book.getBookName(),book.getEducationName(),book.getQuantity())){
            return true;
        }
        return false;
    }
    // 得到所有的图书
    @GetMapping(value = "/books")
    public  State<ArrayList<Book>> getBooks(){
        State<ArrayList<Book>> listState = new State<>();
        listState=bookService.getBooks();
        System.out.println(listState);
        return listState;
    }
    // 更改图书，（前端图书数据）
    @PostMapping(value = "/updata")
    public  State<Book> updata(@RequestBody Book book){
        State<Book> state = new State<>();
        state=bookService.updata(book.getBookid(),book.getAuthorName(),book.getBookName(), book.getEducationName(),book.getQuantity());
        System.out.println(state);
        return state;
    }
    // 得到图书排行榜
    @GetMapping(value = "/getBookTop")
    public State<ArrayList<BookTop>> getBookTop(){
        State<ArrayList<BookTop>> arrayListState = new State<>();
        arrayListState=topService.getBookTop();
        return arrayListState;

    }
    // 得到用户借阅排行榜
    @GetMapping(value = "/getUserTop")
    public State<ArrayList<UserTop>> getUserTop(){
        State<ArrayList<UserTop>> arrayListState = new State<>();
        arrayListState=topService.getUserTop();
        return arrayListState;
    }
}
