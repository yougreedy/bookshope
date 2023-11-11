package kr.ac.kopo.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.bookshop.model.Customer;
import kr.ac.kopo.bookshop.pager.Pager;
import kr.ac.kopo.bookshop.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	 final String path = "customer/";
	 
	 @Autowired
	 CustomerService service;
	 
	 @GetMapping("/list")
	 String list(Pager pager, Model model) throws Exception {
		 List<Customer> list = service.list(pager);
		 
		 for(Customer item : list)
			 System.out.println(item.getCustid());
		 
		 model.addAttribute("list", list);
	 
	 return path + "list";
	 }
	 
	 @GetMapping("/add")
	 String add() {
		
		 return path + "add";
	 }
	 
	 @PostMapping("/add")
	 String add(Customer item) throws Exception {
		 service.add(item);
		 
		 return "redirect:list";

	 }
	 
   @GetMapping("/update/{custid}")
  String update(@PathVariable String custid, Model model) throws Exception {
	   Customer item = service.item(custid);
	   
	   model.addAttribute("item", item);
	   
	   return path + "update";
   }
   
   @PostMapping("/update/{custid}")
   String update(@PathVariable String custid, Customer item) throws Exception {
	   item.setCustid(custid);
	   
	   service.update(item);
	   
	   return "redirect:../list";
   }
   
   @GetMapping("/delete/{custid}")
  String delete(@PathVariable String custid) throws Exception {
	   service.delete(custid);
	   
	   return "redirect:../list";
   }
}


















