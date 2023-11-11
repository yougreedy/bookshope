package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.CustomerDao;
import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.pager.Pager;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao dao;
	
	@Override
	public List<Customer> list(Pager pager) throws Exception {
        int total = dao.total(pager);
        pager.setTotal(total);
		return dao.list(pager);
	}

	@Override
	public void add(Customer item) throws Exception {
        dao.add(item);		
	}

	@Override
	public Customer item(String custid) throws Exception {
		return dao.item(custid);
	}

	@Override
	public void update(Customer item) throws Exception {
        dao.update(item);		
	}

	@Override
	public void delete(String custid) throws Exception {
        dao.delete(custid);		
	}





}
