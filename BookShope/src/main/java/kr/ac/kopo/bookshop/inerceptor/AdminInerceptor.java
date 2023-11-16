package kr.ac.kopo.bookshop.inerceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.bookshop.model.Customer;

public class AdminInerceptor extends HandlerInterceptorAdapter {

	//Inerceptor 매커니즘 preHandle에서 return false: () 작동을 안한는 것   return true: 작동 하는 것 
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {//preHandle 메서드는 컨트롤러가 호출되기 전에 실행되는 메서드

		HttpSession session = request.getSession();// 세션을 얻어옵니다.
		
		Customer member = (Customer) session.getAttribute("member");
		// 세션에서 "member"라는 속성으로 저장된 Customer 객체를 가져옵니다.
		if(member != null) {// 로그인된 사용자가 있는 경우
		
		    if(!member.getCustid().equals("admin")){// 만약 일반 사용자라면 홈페이지로 리다이렉트하고 false를 반환합니다.
		    	response.sendRedirect("/");
                 return false;//false를 반환하면 컨트롤러 실행을 하지 않음		    	
		    }
			return true; // "admin"인 경우 true를 반환하여 컨트롤러가 실행되도록 합니다
		}
		
		response.sendRedirect("/login");
		
		return false;// 로그인되지 않은 사용자인 경우 "/login"으로 리다이렉트하고 false를 반환합니다
		
	}
	
}
