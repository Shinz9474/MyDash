package com.MKBot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.MKBot.domain.MKBotUser;

@Controller
@RequestMapping("/")
public class IndexController {

	  @RequestMapping(value="/test",method = RequestMethod.GET)
	    public String getIndexPage() {
	        return "test";
	    }
	  @RequestMapping( value="/home", method = RequestMethod.GET)
	    public String getHome(HttpSession session) {
		  
		  MKBotUser user=(MKBotUser) session.getAttribute("user");
		  
		  if(user==null) {
			  return "redirect:userlogin";
		  }
		  
		  return "home";
	    }
	  @RequestMapping(value="/home1", method = RequestMethod.GET)
	    public String getHome1() {
	        return "home1";
	    }
	  
	 
	  
	
}