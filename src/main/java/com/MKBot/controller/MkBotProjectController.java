package com.MKBot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.MKBot.domain.MKBotUser;

@Controller

public class MkBotProjectController {

	@RequestMapping(value= {"/mkbotproject"},method=RequestMethod.GET)
	public String mkbotProject(HttpSession session) {
		
		MKBotUser user=(MKBotUser) session.getAttribute("user");
		  
		  if(user==null) {
			  return "redirect:userlogin";
		  }
		  
		  return "mkbotproject";
		
	}
	
	 @RequestMapping(value="/test1", method = RequestMethod.GET)
	    public String getHome1() {
	        return "test2";
	    }
	 
	 //tableEdit.html
	 @RequestMapping(value="/ProjectDetailsTableEdit.html", method = RequestMethod.GET)
	    public String tableEdit() {
	        return "ProjectDetailsTableEdit";
	    }
	 
	 @RequestMapping(value="/ProjectDetailsTableView.html", method = RequestMethod.GET)
	    public String tableView() {
	        return "ProjectDetailsTableView";
	    }
	 
}
