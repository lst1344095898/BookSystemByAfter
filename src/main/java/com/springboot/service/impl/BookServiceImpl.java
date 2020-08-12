package com.springboot.service.impl;

import com.springboot.dao.AnotationUserDao;
import com.springboot.dao.BookDao;
import com.springboot.entity.Book;
import com.springboot.entity.BorrowInfo;
import com.springboot.entity.Paging;
import com.springboot.entity.State;
import com.springboot.entity.book.BookPageInfo;
import com.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private AnotationUserDao userDao;
    @Override
    public boolean bookAdd(int bookid, String authorName, String bookName, String educationName ,int quantity) {
        System.out.println(bookid+authorName+bookName+educationName);
        int Add=bookDao.bookAdd(bookid,authorName,bookName,educationName,quantity);
        if(Add==1){
            return true;
        }
        return false;
    }
    @Override
    public State<ArrayList<Book>> getBooks() {
        State<ArrayList<Book>> listState = new State<>();
        ArrayList<Book> books = bookDao.getBooks();
        System.out.println(books);
        if (books!=null){
            System.out.println("test1");
            listState.setState_id(true);
            listState.setData(books);
            listState.setError(null);
            return listState;
        }
        listState.setState_id(false);
        listState.setData(null);
        listState.setError(null);
        return listState;
    }

    @Override
    public State<Book> updata(int bookid, String authorName, String bookName, String educationName, int quantity) {
        int book=bookDao.updata(bookid,authorName,bookName,educationName,quantity);
        State<Book> bookState = new State<>();
        Book book1 = new Book();
        book1.setBookid(bookid);
        book1.setAuthorName(authorName);
        book1.setBookName(bookName);
        book1.setEducationName(educationName);
        book1.setQuantity(quantity);
        if (book==1){
            bookState.setState_id(true);
            bookState.setData(book1);
            bookState.setError(null);
            return bookState;
        }
        bookState.setState_id(false);
        bookState.setData(null);
        bookState.setError(null);
        return bookState;
    }

    @Override
    public State<ArrayList<BorrowInfo>> getBooksByInput(int userid, int bookid, String authorName, String bookName, String educationName) {
        State<ArrayList<BorrowInfo>> listState = new State<>();
        ArrayList<BorrowInfo> booksByInput = bookDao.getBooksByInput(userid,bookid,authorName,bookName,educationName);
        System.out.println(booksByInput);
        if (booksByInput!=null){
            System.out.println("test1");
            listState.setState_id(true);
            listState.setData(booksByInput);
            listState.setError(null);
            return listState;
        }
        listState.setState_id(false);
        listState.setData(null);
        listState.setError(null);
        return listState;
    }

    @Override
    public State<Boolean> borrowAdd(int userid, int bookid, String authorName, String bookName, String educationName) {
        State<Boolean> state = new State<Boolean>();
        String date=getDate();
        String judgmentRepetition=bookDao.judgmentRepetition(userid,bookid);
        if (judgmentRepetition==null) {
            int borrow = bookDao.borrowAdd(userid, bookid, authorName, bookName, educationName, date);
            int bookDownById = bookDao.bookDownById(userid, bookid);//减少存货
            int bookBorrowTimesAdd = bookDao.bookBorrowTimesAdd(bookid);//借阅次数
            int userBorrowTimesAdd = userDao.userBorrowTimesAdd(userid);//借阅次数
            System.out.println(userid);
            System.out.println("bookDownById=" + borrow + "\nbookDownById=" + bookDownById + "bookBorrowTimesAdd=" + bookBorrowTimesAdd + "userBorrowTimesAdd=" + userBorrowTimesAdd);
            if (borrow!=0) {
                if (bookDownById != 0 && bookBorrowTimesAdd != 0 && userBorrowTimesAdd != 0) {
                    state.setState_id(true);
                    state.setData(true);
                    state.setError("借阅成功");
                    return state;
                }
                state.setState_id(false);
                state.setData(false);
                state.setError("借阅失败");
                return state;
            }
            state.setState_id(false);
            state.setData(false);
            state.setError("借阅失败");
            return state;
        }
        state.setState_id(false);
        state.setData(false);
        state.setError("请不要重复借阅");
        return state;
    }

    @Override
    public boolean returnBook(String bookid,String userid) {
        String date=getDate();
        int book=bookDao.returnBook(bookid,userid,date);
        int bookUpById=bookDao.bookUpById(userid,bookid);
        System.out.println("book:" + book+"bookUpById:" +bookUpById);
        if (book!=0){
            if (bookUpById!=0){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
        public State<ArrayList<BorrowInfo>> getBorrowBook() {
        State<ArrayList<BorrowInfo>> listState = new State<ArrayList<BorrowInfo>>();
        ArrayList<BorrowInfo> borrowBook = bookDao.getBorrowBook();
        System.out.println(borrowBook);
        if (borrowBook!=null){
            System.out.println("test1");
            listState.setState_id(true);
            listState.setData(borrowBook);
            listState.setError(null);
            return listState;
        }
        listState.setState_id(false);
        listState.setData(null);
        listState.setError(null);
        return listState;
    }
    // 形式参数
    @Override
    public State<ArrayList<Book>> getBooksByInputInfo(int bookid, String authorName, String bookName, String educationName) {
        State<ArrayList<Book>> listState = new State<>();
        //实参
        ArrayList<Book> booksByInputInfo = bookDao.getBooksByInputInfo(bookid,authorName,bookName,educationName);
        System.out.println(booksByInputInfo);
        if (booksByInputInfo!=null){
            System.out.println("test1");
            listState.setState_id(true);
            listState.setData(booksByInputInfo);
            listState.setError(null);
            return listState;
        }
        listState.setState_id(false);
        listState.setData(null);
        listState.setError("没有查询到请检查");
        return listState;
    }

    @Override
    public Paging<ArrayList<Book>> getBooksByPram(int page, int count, int bookid, String authorName, String bookName, String educationName) {
        Paging<ArrayList<Book>> arrayListPaging = new Paging<>();
        ArrayList<Book> books = new ArrayList<>();
        books=bookDao.getBooksByPram( page,  count,  bookid,  authorName,  bookName,  educationName);
        BookPageInfo pageNew = bookDao.getPage(bookid,authorName,bookName,educationName);
        String pages = pageNew.getPageNew();
        if (books!=null){
            arrayListPaging.setState_id(true);
            arrayListPaging.setData(books);
            arrayListPaging.setError(null);
            if (pageNew!=null){
                arrayListPaging.setPages(pages);
                System.out.println(pageNew);
                System.out.println(pages);
            }else{
                arrayListPaging.setPages("1");
            }
            return  arrayListPaging;
        }
        arrayListPaging.setState_id(false);
        arrayListPaging.setData(null);
        arrayListPaging.setPages("1");
        arrayListPaging.setError(null);
        return  arrayListPaging;
    }

    @Override
    public State<ArrayList<BorrowInfo>> getBorrowInfosByUserId(String userid) {
        State<ArrayList<BorrowInfo>> arrayListState = new State<>();
        ArrayList<BorrowInfo> borrowInfos = new ArrayList<>();
        borrowInfos=bookDao.getBorrowInfosByUserId(userid);
        if (borrowInfos!=null){
            arrayListState.setState_id(true);
            arrayListState.setData(borrowInfos);
            arrayListState.setError(null);
            return arrayListState;
        }
        arrayListState.setState_id(false);
        arrayListState.setData(null);
        arrayListState.setError(null);
        return arrayListState;
    }

    public String getDate(){
        SimpleDateFormat df_24=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将deta类型日期转换为数据库特有类型。
        String register_datetime=df_24.format(new Date());
        return register_datetime;
    }
}
