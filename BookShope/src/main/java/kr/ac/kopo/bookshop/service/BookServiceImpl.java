package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.BookDao;
import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;


@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao dao;
	
	@Override
	public List<Book> list(Pager pager)throws Exception  {
		
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}


	@Override
	public void add(Book item) throws Exception {
        dao.add(item);
	}

	@Override
	public Book item(Long bookid) throws Exception {
		return dao.item(bookid);
	}

	@Override
	public void update(Book item) throws Exception {
        dao.update(item);
	}

	@Override
	public void delete(Long bookid) throws Exception {
        dao.delete(bookid);
	}

	@Override
	public void dummy() throws Exception {
        for(int i = 13; i <= 100; i ++) {
        	Book item = new Book();
        	
        	item.setBookid((long)i);
        	item.setBookname("도서명" + i);
        	item.setPublisher("출판사" + i);
        	item.setPrice((long)i * 1000);
        	
        	dao.add(item);
        }
		
	}

	@Override
	public void init() throws Exception {
         for(int i = 13; i <= 100; i++) {
        	 dao.delete((long)i);
         }
	}




	

}
