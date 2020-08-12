package com.springboot.dao;

import com.springboot.entity.Book;
import com.springboot.entity.BorrowInfo;
import com.springboot.entity.book.BookPageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface BookDao {
    int bookAdd(@Param("bookid") int bookid, @Param("authorName") String authorName, @Param("bookName") String bookName, @Param("educationName") String educationName,@Param("quantity") int quantity);
    ArrayList<Book> getBooks();
    ArrayList<BorrowInfo> getBooksByInput(@Param("userid") int userid,@Param("bookid") int bookid, @Param("authorName") String authorName, @Param("bookName") String bookName, @Param("educationName") String educationName);
    int updata(@Param("bookid") int bookid, @Param("authorName") String authorName, @Param("bookName") String bookName, @Param("educationName") String educationName,@Param("quantity") int quantity);

    int borrowAdd(@Param("userid") int userid,@Param("bookid") int bookid, @Param("authorName") String authorName, @Param("bookName") String bookName, @Param("educationName") String educationName,@Param("startTime") String startTime);
    int bookUpById(@Param("userid") String userid,@Param("bookid") String bookid);
    int bookDownById(@Param("userid") int userid,@Param("bookid") int bookid);
    int returnBook(@Param("bookid") String bookid ,@Param("userid") String userid,@Param("returnTime") String returnTime);
    int bookBorrowTimesAdd(@Param("bookid") int bookid);
    String judgmentRepetition(@Param("userid") int userid,@Param("bookid") int bookid);
    ArrayList<BorrowInfo> getBorrowBook();
    ArrayList<Book> getBooksByInputInfo(@Param("bookid") int bookid, @Param("authorName") String authorName, @Param("bookName") String bookName, @Param("educationName") String educationName);
    ArrayList<Book> getBooksByPram(@Param("page") int page,@Param("count") int count,@Param("bookid") int bookid, @Param("authorName") String authorName, @Param("bookName") String bookName, @Param("educationName") String educationName);
    BookPageInfo getPage(@Param("bookid") int bookid, @Param("authorName") String authorName, @Param("bookName") String bookName, @Param("educationName") String educationName);
    ArrayList<BorrowInfo> getBorrowInfosByUserId(@Param("userid") String userid);
}
