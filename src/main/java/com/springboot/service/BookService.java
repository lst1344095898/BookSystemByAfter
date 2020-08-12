package com.springboot.service;

import com.springboot.entity.Book;
import com.springboot.entity.BorrowInfo;
import com.springboot.entity.Paging;
import com.springboot.entity.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BookService {
    boolean bookAdd(int bookid,String authorName,String bookName,String educationName,int quantity);
    State<ArrayList<Book>> getBooks();
    State<Book> updata(int bookid,String authorName,String bookName,String educationName,int quantity );
    State<ArrayList<BorrowInfo>> getBooksByInput(int userid,int bookid,String authorName,String bookName,String educationName);
    State<Boolean> borrowAdd(int userid,int bookid,String authorName,String bookName,String educationName);
    boolean returnBook(String bookid ,String userid);
    State<ArrayList<BorrowInfo>> getBorrowBook();
    State<ArrayList<Book>> getBooksByInputInfo(int bookid,String authorName,String bookName,String educationName);
    Paging<ArrayList<Book>> getBooksByPram(int page,int count,int bookid,String authorName,String bookName,String educationName);
    State<ArrayList<BorrowInfo>> getBorrowInfosByUserId(String userid);
}
