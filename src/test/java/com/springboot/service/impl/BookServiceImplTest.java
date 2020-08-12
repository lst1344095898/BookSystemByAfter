package com.springboot.service.impl;

import static org.junit.Assert.*;

import com.springboot.dao.AnotationUserDao;
import com.springboot.dao.BookDao;
import com.springboot.entity.Book;
import com.springboot.entity.BorrowInfo;
import com.springboot.entity.Paging;
import com.springboot.entity.State;
import com.springboot.entity.book.BookPageInfo;
import com.springboot.service.BookService;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookServiceImplTest {
	BookService bookService=new BookServiceImpl();
	@Test
	public void bookAddTestFalse() {
		Book book = new Book();
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			int bookAdd(int bookid, String authorName, String bookName, String educationName ,int quantity){
				return 0;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		boolean result=bookService.bookAdd(book.getBookid(),book.getAuthorName(),book.getBookName(),book.getEducationName(),book.getQuantity());
		assertEquals(false,result);
	}
	@Test
	public void bookAddTestTrue() {
		Book book = new Book();
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			int bookAdd(int bookid, String authorName, String bookName, String educationName ,int quantity){
				return 1;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		boolean result=bookService.bookAdd(book.getBookid(),book.getAuthorName(),book.getBookName(),book.getEducationName(),book.getQuantity());
		assertEquals(true,result);
	}
	@Test
	public void getBooksTestFalse() {
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			ArrayList<Book> getBooks(){
				return  null;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		State<ArrayList<Book>> result=bookService.getBooks();
		assertEquals(false,result.getState_id());
	}
	@Test
	public void getBooksTestTrue() {
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			ArrayList<Book> getBooks(){
				ArrayList<Book> books = new ArrayList<>();
				Book book=new Book();
				book.setBookid(1);
				books.add(0,book);
				return  books;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		State<ArrayList<Book>> result=bookService.getBooks();
		assertEquals(true,result.getState_id());
	}
	@Test
	public void updataTestFalse() {
		Book book = new Book();
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			int updata(int bookid, String authorName, String bookName, String educationName, int quantity){
				return  0;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		State<Book> result=bookService.updata(book.getBookid(),book.getAuthorName(),book.getBookName(),book.getEducationName(),book.getQuantity());
		assertEquals(false,result.getState_id());
	}
	@Test
	public void updataTestTrue() {
		Book book = new Book();
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			int updata(int bookid, String authorName, String bookName, String educationName, int quantity){
				return  1;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		State<Book> result=bookService.updata(book.getBookid(),book.getAuthorName(),book.getBookName(),book.getEducationName(),book.getQuantity());
		assertEquals(true,result.getState_id());
	}
	@Test
	public void getBooksByInputTestFalse() {
		Book book = new Book();
		int userid=12;
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			ArrayList<BorrowInfo> getBooksByInput(int userid, int bookid, String authorName, String bookName, String educationName){
				return  null;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		State<ArrayList<BorrowInfo>> result=bookService.getBooksByInput(userid,book.getBookid(),book.getAuthorName(),book.getBookName(),book.getEducationName());
		assertEquals(false,result.getState_id());
	}
	@Test
	public void getBooksByInputTestTrue() {
		Book book = new Book();
		int userid=12;
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			ArrayList<BorrowInfo> getBooksByInput(int userid, int bookid, String authorName, String bookName, String educationName){
				ArrayList<BorrowInfo> borrowInfos = new ArrayList<>();
				BorrowInfo borrowInfo=new BorrowInfo();
				borrowInfo.setBookid(2);
				borrowInfos.add(0, borrowInfo);
				return  borrowInfos;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		State<ArrayList<BorrowInfo>> result=bookService.getBooksByInput(userid,book.getBookid(),book.getAuthorName(),book.getBookName(),book.getEducationName());
		assertEquals(true,result.getState_id());
	}
	@Test
	public void borrowAddTestFalse() {
		Book book = new Book();
		book.setBookid(2);
		int userid=12;
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			String  judgmentRepetition(int userid,int bookid){
				return "test";
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		State<Boolean> result=bookService.borrowAdd(userid,book.getBookid(),book.getAuthorName(),book.getBookName(),book.getEducationName());
		assertEquals(false,result.getState_id());
	}
	@Test
	public void borrowAddTestFalse2() {
		Book book = new Book();
		int userid=12;
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			String  judgmentRepetition(int userid,int bookid){
				return null;
			}
			@Mock
			int borrowAdd(int userid, int bookid, String authorName, String bookName, String educationName, String startTime){
				return 1;
			}
			@Mock
			int bookDownById(int userid, int bookid){
				return 0;
			}
			@Mock
			int bookBorrowTimesAdd(int bookid){
				return 0;
			}

		};
		MockUp<AnotationUserDao> userDao =new MockUp<AnotationUserDao>() {
			@Mock
			int userBorrowTimesAdd(int userid){
				return 0;
			}

		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
			{
				Deencapsulation.setField(bookService,"userDao",userDao.getMockInstance());

			}
		};
		State<Boolean> result=bookService.borrowAdd(userid,book.getBookid(),book.getAuthorName(),book.getBookName(),book.getEducationName());
		assertEquals(false,result.getState_id());
	}
	@Test
	public void borrowAddTestTrue() {
		Book book = new Book();
		int userid=12;
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			String  judgmentRepetition(int userid,int bookid){
				return null;
			}
			@Mock
			int borrowAdd(int userid, int bookid, String authorName, String bookName, String educationName, String date){
				return  1;
			}
			@Mock
			int bookDownById(int userid, int bookid){
				return 1;
			}
			@Mock
			int bookBorrowTimesAdd(int bookid){
				return 1;
			}

		};
		MockUp<AnotationUserDao> userDao =new MockUp<AnotationUserDao>() {
			@Mock
			int userBorrowTimesAdd(int userid){
				return 1;
			}

		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
			{
				Deencapsulation.setField(bookService,"userDao",userDao.getMockInstance());

			}
		};
		State<Boolean> result=bookService.borrowAdd(userid,book.getBookid(),book.getAuthorName(),book.getBookName(),book.getEducationName());
		assertEquals(true,result.getState_id());
	}
	@Test
	public void returnBookTestFalse() {
		String bookid="12";
		String userid="12";
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			int returnBook(String bookud, String userid, String date){
				return  0;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		boolean result=bookService.returnBook(bookid,userid);
		assertEquals(false,result);
	}
	@Test
	public void returnBookTestFalse2() {
		String bookid="12";
		String userid="12";
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			int returnBook(String bookud, String userid, String date){
				return  1;
			}
			@Mock
			int bookUpById(String bookud, String userid){
				return  0;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		boolean result=bookService.returnBook(bookid,userid);
		assertEquals(false,result);
	}
	@Test
	public void returnBookTestTrue() {
		String bookid="12";
		String userid="12";
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			int returnBook(String bookid, String userid, String date){
				return  1;
			}
			@Mock
			int bookUpById(String  userid, String bookid){
				return  1;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		boolean result=bookService.returnBook(bookid,userid);
		assertEquals(true,result);
	}
	@Test
	public void getBorrowBookTestFalse() {
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			ArrayList<BorrowInfo> getBorrowBook(){
				return  null;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		State<ArrayList<BorrowInfo>> result=bookService.getBorrowBook();
		assertEquals(false,result.getState_id());
	}
	@Test
	public void getBorrowBookTestTrue() {
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			ArrayList<BorrowInfo> getBorrowBook(){
				ArrayList<BorrowInfo> borrowInfos = new ArrayList<>();
				BorrowInfo borrowInfo=new BorrowInfo();
				borrowInfo.setBookid(1);
				borrowInfos.add(0,borrowInfo);
				return  borrowInfos;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		State<ArrayList<BorrowInfo>> result=bookService.getBorrowBook();
		assertEquals(true,result.getState_id());
	}
	@Test
	public void getBooksByInputInfoTestFalse() {
		Book book = new Book();
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			ArrayList<Book> getBooksByInputInfo(int bookid, String authorName, String bookName, String educationName){
				return  null;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		State<ArrayList<Book>> result=bookService.getBooksByInputInfo(book.getBookid(),book.getAuthorName(),book.getBookName(),book.getEducationName());
		assertEquals(false,result.getState_id());
	}
	@Test
	public void getBooksByInputInfoTestTrue() {
		Book book = new Book();
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			ArrayList<Book> getBooksByInputInfo(int bookid, String authorName, String bookName, String educationName){
				ArrayList<Book> books = new ArrayList<>();
				Book book=new Book();
				books.add(0,book);
				return  books;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		State<ArrayList<Book>> result=bookService.getBooksByInputInfo(book.getBookid(),book.getAuthorName(),book.getBookName(),book.getEducationName());
		assertEquals(true,result.getState_id());
	}
	@Test
	public void getBooksByPramTestFalse() {
		int page=1;
		int count=1;
		int bookid=1;
		String authorName="23";
		String bookName="23";
		String educationName="23";
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			ArrayList<Book> getBooksByPram(int page, int count, int bookid, String authorName, String bookName, String educationName){

				return  null;
			}
			@Mock
			BookPageInfo getPage(int bookid, String authorName, String bookName, String educationName){
				BookPageInfo bookPageInfo = new BookPageInfo();
				bookPageInfo.setAuthorName("123");
				return bookPageInfo;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		Paging<ArrayList<Book>> result=bookService.getBooksByPram(page,  count,  bookid,  authorName,  bookName,  educationName);
		assertEquals(false,result.getState_id());
	}
	@Test
	public void getBooksByPramTestTrue() {
		int page=1;
		int count=1;
		int bookid=1;
		String authorName="23";
		String bookName="23";
		String educationName="23";
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			ArrayList<Book> getBooksByPram(int page, int count, int bookid, String authorName, String bookName, String educationName){
				ArrayList<Book> books = new ArrayList<>();
				Book book=new Book();
				book.setBookid(1);
				books.add(0,book);
				return  books;
			}
			@Mock
			BookPageInfo getPage(int bookid, String authorName, String bookName, String educationName){
				BookPageInfo bookPageInfo = new BookPageInfo();
				bookPageInfo.setAuthorName("123");
				bookPageInfo.setPageNew("123");
				return bookPageInfo;
			}
		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		Paging<ArrayList<Book>> result=bookService.getBooksByPram(page,  count,  bookid,  authorName,  bookName,  educationName);
		assertEquals(true,result.getState_id());
	}
	@Test
	public void getBorrowInfosByUserIdTestFalse() {
		String userid="123";
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			ArrayList<BorrowInfo> getBorrowInfosByUserId(String userid){
//				ArrayList<BorrowInfo> books = new ArrayList<>();
//				if (books!=null&&books.size()!=0){
//					books.get(0).setBookid(123);
//				}
				return  null;
			}

		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		State<ArrayList<BorrowInfo>> result=bookService.getBorrowInfosByUserId(userid);
		assertEquals(false,result.getState_id());
	}
	@Test
	public void getBorrowInfosByUserIdTestTrue() {
		String userid="123";
		MockUp<BookDao> bookDao=new MockUp<BookDao>() {
			@Mock
			ArrayList<BorrowInfo> getBorrowInfosByUserId(String userid){
				ArrayList<BorrowInfo> books = new ArrayList<>();
				BorrowInfo book=new BorrowInfo();
				book.setBookid(1);
				books.add(0,book);
				return  books;
			}

		};
		new Expectations(){
			{
				Deencapsulation.setField(bookService,"bookDao",bookDao.getMockInstance());
			}
		};
		State<ArrayList<BorrowInfo>> result=bookService.getBorrowInfosByUserId(userid);
		assertEquals(true,result.getState_id());
	}

}
