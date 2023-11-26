package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.CustomerDao;
import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.pager.Pager;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao dao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;//passwordEncoder는 주로 보안을 위해 사용되는 인터페이스
	
	@Override
	public List<Customer> list(Pager pager) throws Exception {
        int total = dao.total(pager);
        pager.setTotal(total);
		return dao.list(pager);
	}

	@Override
	public void add(Customer item) throws Exception {
		
		//사용자가 입력한 비밀번호 암호화
        String originPasswd = item.getPasswd(); //사용자가 입력한 비밀번호	
        String encodedPassword = passwordEncoder.encode(originPasswd);
        item.setPasswd(encodedPassword);
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
	
	
//	@Override
//	public Boolean login(Customer item)throws Exception {//dao.login(item) 메서드를 호출하여 사용자가 입력한 로그인 정보를 데이터베이스와 비교하고
//        Customer result = dao.login(item); //일치하는 사용자 정보를 result 변수에 저장
//		if(result != null) { //null 아니면 로그인 성공 
//			BeanUtils.copyProperties(result, item);
//			// Apache Commons BeanUtils 라이브러리를 사용하여 result 객체에서 item 객체로 속성을 복사 
//			//이렇게 하면 item 객체에 사용자 정보가 복사됨
// 			item.setPasswd(null);
// 			//보안을 위해 사용자 비밀번호를 지웁니다. 이렇게 하면 비밀번호가 더 이상 item 객체에 저장 안됨 			
//			return true;
//          }
//		return false;      //null 로그인 실패
//	}
	
//     
//	@Override
//	public Boolean login(Customer item) throws Exception {
//		Customer result = dao.login(item);
//		
//		if(result != null) {
//	        boolean e = passwordEncoder.matches(item.getPasswd(), result.getPasswd());	
//	        
//	        if(e) {
//	    	BeanUtils.copyProperties(result, item);
//	    	//BeanUtils.copyProperties(result, item)은 result 객체의 프로퍼티를 item 객체로 복사합니다. 
//	    	//이를 통해 item 객체에 로그인에 성공한 사용자의 정보가 담기게 됩니다
//	    	//item.setPasswd(null);//item.setPasswd(null)은 보안 상의 이유로 비밀번호를 null로 설정
//			   return true;
//		}
//    }	
//		return false;
//	}
	
	@Override
	public Boolean login(Customer item) throws Exception {
	    Customer result = dao.login(item);
//dao.login(item)은 사용자의 아이디와 비밀번호를 이용하여 데이터베이스에서 사용자 정보를 조회하는 메서드일 것입니다.
// 조회 결과를 result에 저장합니다
	    if (result != null) {//데이터베이스에서 사용자 정보가 조회되었는지 확인합니다.
	        boolean passwordMatches = passwordEncoder.matches(item.getPasswd(), result.getPasswd());
         //사용자가 입력한 비밀번호와 데이터베이스에서 가져온 사용자의 암호화된 비밀번호가 일치하는지 확인합니다.
	        if (passwordMatches) {
	            BeanUtils.copyProperties(result, item);
                //은 MyBatis가 가져온 result 객체의 속성을 로그인에 사용된 item 객체로 복사합니다. 
	            //일반적으로 이렇게 해서 로그인한 사용자 정보를 계속 사용할 수 있게 합니다.	            
	            return true;//로그인 성공을 나타냅니다
	        }
	    }

	    return false;//로그인 실패
	}


}
