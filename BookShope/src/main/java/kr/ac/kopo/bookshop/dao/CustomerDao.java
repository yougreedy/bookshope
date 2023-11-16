package kr.ac.kopo.bookshop.dao;

import java.util.List;

import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.pager.Pager;

public interface CustomerDao {

	List<Customer> list(Pager pager)throws Exception;

	int total(Pager pager)throws Exception;

	void add(Customer item)throws Exception;

	Customer item(String custid)throws Exception;

	void update(Customer item)throws Exception;

	void delete(String custid)throws Exception;

	Customer login(Customer item)throws Exception;

	

	

}
