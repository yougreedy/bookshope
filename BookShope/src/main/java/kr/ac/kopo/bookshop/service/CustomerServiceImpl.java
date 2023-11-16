package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
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

	@Override
	public Boolean login(Customer item) throws Exception {
		Customer result = dao.login(item);
		
		if(result != null) {
            	BeanUtils.copyProperties(result, item);
            	//BeanUtils.copyProperties(result, item)은 result 객체의 프로퍼티를 item 객체로 복사합니다. 
            	//이를 통해 item 객체에 로그인에 성공한 사용자의 정보가 담기게 됩니다
            	item.setPasswd(null);//item.setPasswd(null)은 보안 상의 이유로 비밀번호를 null로 설정
			return true;
		}
		
		return false;
	}





}
