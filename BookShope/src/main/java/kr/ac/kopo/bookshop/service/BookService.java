package kr.ac.kopo.bookshop.service;

import java.util.List;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;



public interface BookService {

	List<Book> list(Pager pager)throws Exception ;

	void add(Book item)throws Exception ;

	Book item(Long bookid)throws Exception ;

	void update(Book item)throws Exception ;

	void delete(Long bookid)throws Exception ;

	void dummy()throws Exception;

	void init()throws Exception;

	

}
