package com.sny.app.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

 
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4100"})
@RestController
//@RequestMapping("/")
public class TestController
{
    Log log = LogFactory.getLog(TestController.class);
    
    
    @GetMapping(value = "/test" ,produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> freeForAccess()
    {
		return  ResponseEntity.ok("{ \n "+"\"name\":\""+"jitudv09"+"\",\n"+"\"role\":\""+"password123"+"\" \n }");
	}
    
	
	@GetMapping("/admin/test")
	public String viewName() {
		return "admin can access ";
	}
	
    
	@GetMapping("/user/test")
	public String userTest() {
		return "user are can access";
	}
	
	@GetMapping("/logout/both")
	public ResponseEntity<String> logoutDo(HttpServletRequest request,HttpServletResponse response){
     
		HttpSession session= request.getSession(false);
	    log.warn(" this is the session attribute names \t  "+session.getAttributeNames());
	        SecurityContextHolder.clearContext();
	         session= request.getSession(false);
	        if(session != null) {
	        	log.warn("yes sessioni not null ");
	            session.invalidate();
	            log.warn("session is destroyred ");
	        }
	       
		     return ResponseEntity.ok("logout");
	}
	
	
//
//   @GetMapping("/logout")
//   public ResponseEntity<String> logout(ServletRequest req ,ServletResponse res )
//   {
//	    String uname = SecurityContextHolder.getContext().getAuthentication().getName();
//		return null;
//   }
	
//   
//	@GetMapping("/login")
//	public String loginView()
//	{
//		return "login";
//	}
   
}
