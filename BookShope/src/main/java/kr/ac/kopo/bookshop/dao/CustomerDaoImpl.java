package kr.ac.kopo.bookshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.pager.Pager;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SqlSession sql;
	
	
	@Override
	public List<Customer> list(Pager pager) throws Exception {
		return sql.selectList("customer.list", pager);
	}

	@Override
	public int total(Pager pager) throws Exception {
		return sql.selectOne("customer.total", pager);
	}

	@Override
	public void add(Customer item) throws Exception {
       sql.insert("customer.add", item);
	}

	@Override
	public Customer item(String custid) throws Exception {
		return sql.selectOne("customer.item", custid);
	}

	@Override
	public void update(Customer item) throws Exception {
        sql.update("customer.update",item);
	}

	@Override
	public void delete(String custid) throws Exception {
       sql.delete("customer.delete", custid);
	}

	@Override
	public Customer login(Customer item) throws Exception {
		return sql.selectOne("customer.login",item);
	}

	

}
