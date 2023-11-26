package kr.ac.kopo.bookshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.pager.Pager;
import kr.ac.kopo.bookshop.service.CustomerService;

@Controller
public class RootController {

	@Autowired
	CustomerService customerService; //스프링에서 처음 문자를 소문자로 하는게 관례이다.
	
	 @Autowired
	 CustomerService service;
	
	@GetMapping("/")
	public String index(HttpSession session, Model model)throws Exception {
	  
	  String msg = (String) session.getAttribute("msg");
		
		if(msg != null) {
            model.addAttribute("msg",msg);
            // 모델에 "msg"라는 속성을 추가하고, 이에 세션에서 가져온 메시지를 할당 이렇게 모델에 추가된 속성은 뷰에서 사용
            session.removeAttribute("msg");
            //메시지를 모델에 추가한 후에는 세션에서 해당 메시지를 제거 이렇게 하면 메시지가 한 번만 표시되고, 이후에는 세션에서 제거되어 더 이상 메시지가 남지 않음
		}
	  
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		
		session.invalidate();
		//invalidate() 메서드는 현재 세션을 무효화시킵니다. 이는 사용자의 로그아웃을 의미하며, 세션에 저장된 모든 데이터가 삭제됩니다
		return "redirect:/";
	}
	
	
	@GetMapping("/login")
	public String login()throws Exception{
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Customer item, HttpSession session , Model model)throws Exception{
		  
	     Boolean result = customerService.login(item);
	     //customerService의 login 메서드를 호출하여 로그인 시도를 합니다. 이 메서드는 아마도 사용자 정보를 기반으로 로그인을 처리하고, 로그인 성공 여부를 반환

	     if(result) {
	        //result가 true이면 로그인이 성공한 경우이고, false이면 로그인이 실패
		    session.setAttribute("member", item);
		    //: 로그인이 성공하면 세션에 사용자 정보(result)를 저장 일반적으로 로그인 후 사용자 정보를 세션에 저장하여 다른 페이지에서도 이 정보를 활용
		    // 로그인이 성공하면 세션에 사용자 정보(item)를 저장합니다. 
	        // 로그인 후 다른 페이지에서 이 정보를 활용할 수 있습니다.
	        session.setAttribute("msg", "로그인 되었다 짜샤!.");//세션에 "환영합니다."라는 메시지를 저장합니다. 이 메시지는 로그인 후 사용자에게 표시	 
	      
	     }
	     else {
	    	 session.setAttribute("msg", "아이디 비번 까먹음??.");//로그인이 실패한 경우 세션에 실패 메시지를 저장
	     }
	     
	     return "redirect:/";
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

	@ResponseBody//리턴되는 값을 view 리졸브에게 줘서 리즐조가 ok.jsp, fail.jsp 찾지 못하게 하는것 그대로 클라이언트에게 보내라
	@GetMapping("/checkId/{custid}")
	public String checkId(@PathVariable String custid, Customer item)throws Exception{
		
		if(customerService.item(custid) == null)
			return "OK";
		else  
		    return "FAIL";
		
	}
	
	
}
