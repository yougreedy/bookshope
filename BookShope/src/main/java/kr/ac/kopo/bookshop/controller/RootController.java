package kr.ac.kopo.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.service.CustomerService;

@Controller
public class RootController {

	@Autowired
	CustomerService customerService; //스프링에서 처음 문자를 소문자로 하는게 관례이다.
	
	@GetMapping("/")
	public String index()throws Exception {
		return "index";
	}
	
	@GetMapping("/signup")
	public String signup()throws Exception{
		
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(Customer item)throws Exception{
		
		customerService.add(item);
		
		return "redirect:."; 
	}

	@ResponseBody//리던되는 값을 view 리졸브에게 줘서 리즐조가 ok.jsp, fail.jsp 찾지 못하게 하는것 그대로 클라이언트에게 보내라
	@GetMapping("/checkId/{custid}")
	public String checkId(@PathVariable String custid, Customer item)throws Exception{
		
		if(customerService.item(custid) == null)
			return "OK";
		else  
		    return "FAIL";
		
	}
	
	
}
