package org.motw.user.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.motw.user.service.UserService;
import org.motw.user.util.BaseProvider;
import org.motw.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
	
	String dir = "user";
	
	@Resource
	UserService userService;
	
	/*    소셜 로그인   */
	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	
	@Autowired
	private OAuth2Parameters gooogleOAuth2Parameters;
	
	@Autowired
	private BaseProvider baseProvider;
	/*   //소셜 로그인   */
	
	
	@RequestMapping("/signUp")
	public String signUp(){
		return dir+"/signUp";
	}
	
	@RequestMapping("/signUpProc")
	public String signUpProc(UserVO userVO) throws Exception {
		String page = "";
		int result = userService.insertUser(userVO);
		System.out.println(result);
		
		if(result == 1){
			page = dir+"/signUpOk";
		} else{
			page = dir+"/signUp";			
		}
		
		return page;
	}
	
	
	@RequestMapping("/signIn")
	public String signIn(Model model, HttpSession session) throws Exception {
		//구글 code 발행
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		
		//로그인페이지 이동 url 생성
		String url = oauthOperations.buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, gooogleOAuth2Parameters);
		
		model.addAttribute("google_url", url);
		
		return dir+"/signIn";
	}
	
	@RequestMapping(value="/signInProc", method=RequestMethod.POST)
	public String signInProc(){
		return "/";
	}
	
	//구글 callback 호출
	@RequestMapping(value="/googleSignInCallback", method={RequestMethod.GET, RequestMethod.POST})
	public String gogoleCallback(Model model, @RequestParam String code) throws IOException{
		System.out.println("구글 로그인 성공!");
		/*Google google = baseProvider.getGoogle();
		Person googleUser = google.plusOperations().getGoogleProfile();
		System.out.println(googleUser.getAccountEmail());
		System.out.println(googleUser.getDisplayName());
		System.out.println(googleUser.getImageUrl());*/
		
		return "index";
	}
	
	/*
	 
	  
	  
	  
	// 구글 Callback호출 메소드
	  @RequestMapping(value = "oauth2callback.do", method = { RequestMethod.GET, RequestMethod.POST })
	  public String googleCallback(Model model, @RequestParam String code) throws IOException {

	    System.out.println("Google login success");

	    //저는 성공하면 메인페이지로 리다이렉트합니다.
	    return "redirect:main.do";
	  }
	*/

}
