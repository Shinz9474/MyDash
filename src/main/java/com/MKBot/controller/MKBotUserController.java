package com.MKBot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.MKBot.command.MKBotLoginCommand;
import com.MKBot.domain.MKBotUser;
import com.MKBot.exceptions.MKBotUserBlockedException;
import com.MKBot.service.MKBotUserService;

@Controller
public class MKBotUserController {
	
	@Autowired
	private MKBotUserService userService;
	
	
	@RequestMapping(value= {"/userlogin","/"},method=RequestMethod.GET)
	public String login(Model m,HttpSession session) {
		session.invalidate();
		m.addAttribute("command",new MKBotLoginCommand());
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String redirect(Model m) {
		m.addAttribute("command",new MKBotLoginCommand());
		return "redirect:userlogin";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") MKBotLoginCommand cmd,Model m,HttpSession session) {
		try {
			MKBotUser user= userService.login(cmd.getUserName(), cmd.getPassword());
			
			if(user==null) {
				
				m.addAttribute("err","err");
				
				return "redirect:userlogin";
			}
			else {
//				System.out.println(user.getUserName());
			//	req.getSession().setAttribute("userName", user.getFirstName()+" "+user.getLastName());
				//ModelAndView mav=new ModelAndView();
				//mav.setViewName("redirect:home");
				addUserInSession(user, session);
				//m.addAttribute("userName",user.getUserName());
				//new SessionDataTest().storeAndRetrieveSomethingInAppScope("userName", user.getUserName()); 
				//req.getSession().setAttribute("userName", user.getUserName());
				return "redirect:home";
			}
			
		} catch (MKBotUserBlockedException e) {
			m.addAttribute("err",e.getMessage());
			return "redirect:userlogin";
		}
		
		
		
	}
	
	
	public void addUserInSession(MKBotUser user,HttpSession session) {
		session.setAttribute("user", user);
		session.setAttribute("userName",  user.getFirstName()+" "+user.getLastName());
		
	}
	
	@RequestMapping(value={"/logout"})
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:userlogin";
	}

	
}
