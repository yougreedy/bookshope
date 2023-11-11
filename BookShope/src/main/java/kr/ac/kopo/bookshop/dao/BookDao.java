package kr.ac.kopo.bookshop.dao;

import java.util.List;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;



public interface BookDao {

	
	List<Book> list(Pager pager)throws Exception;

	int total(Pager pager)throws Exception;

	void add(Book item)throws Exception;

	Book item(Long bookid)throws Exception;

	void update(Book item)throws Exception;

	void delete(Long bookid)throws Exception;



}
