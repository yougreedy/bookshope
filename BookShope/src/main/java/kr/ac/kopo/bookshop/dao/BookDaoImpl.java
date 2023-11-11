package kr.ac.kopo.bookshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.pager.Pager;


@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SqlSession sql;
	
	@Override
	public List<Book> list(Pager pager) throws Exception {
		return sql.selectList("book.list",pager);
	}

	@Override
	public int total(Pager pager) throws Exception {
		return sql.selectOne("book.total", pager);
	}

	@Override
	public void add(Book item) throws Exception {
        sql.insert("book.add", item);
	}

	@Override
	public Book item(Long bookid) throws Exception {
		return sql.selectOne("book.item",bookid);
	}

	@Override
	public void update(Book item) throws Exception {
        sql.update("book.update", item);
	}

	@Override
	public void delete(Long bookid) throws Exception {
        sql.delete("book.delete", bookid);
	}


}
