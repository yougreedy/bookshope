package kr.ac.kopo.bookshop.service;

import java.util.List;

import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.pager.Pager;

public interface CustomerService {

	List<Customer> list(Pager pager)throws Exception;

	void add(Customer item)throws Exception;

	Customer item(String custid)throws Exception;

	void update(Customer item)throws Exception;

	void delete(String custid)throws Exception;

	Boolean login(Customer item)throws Exception;


}
