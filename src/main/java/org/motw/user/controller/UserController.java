package org.motw.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	String dir = "user";
	
	@RequestMapping("/signUp")
	public String signUp(){
		return dir+"/signUp";
	}
	
	@RequestMapping("/signIn")
	public String signIn(){
		return dir+"/signIn";
	}
	

}
