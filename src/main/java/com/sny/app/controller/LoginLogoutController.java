package com.sny.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Base64;
import org.springframework.web.bind.annotation.RestController;

import com.sny.app.securityConfig.MyPrinciple;
import com.sny.app.user.Employee;

@CrossOrigin(origins = "http://localhost:4200" ,maxAge = 3600)
@RestController
public class LoginLogoutController
{
	
  Log log = LogFactory.getLog(LoginLogoutController.class);	
 // method is responsible for login and start a session 	
 @GetMapping(value="/user/login",produces=MediaType.APPLICATION_JSON_VALUE )
 public ResponseEntity<String> userLogin(HttpServletRequest req)
 { 
	 
	 String msg =  req.getHeader("Authorization");
	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	 String[] usernameAndPasword =msg.split(" ");
	 String username =  usernameAndPasword[1];
	
	 //log.info("this is header \t\t\t "+username);
	 
	 byte[] decodeUsername =  Base64.getDecoder().decode(username);
	 
	   log.warn("\t\t\t\t\t\t  this is the decode username and password  \t\t"+new String(decodeUsername));
	   log.warn("\t\t\t\t\t\t\t your athentication \t "+msg);
	 
	 String currentPrincipalName = authentication.getName();
	 String currentPrincipalRole = authentication.getAuthorities().iterator().next().getAuthority().toString();
	 String userpass = new String(decodeUsername).split(":")[1];
	 Employee ee = new Employee();
	 ee.setName(currentPrincipalName);
	 HttpSession session = req.getSession(false);
	 if(session != null)
	 {
	     log.warn("session is created properly and this si  session atribute  "+session.getId());
	 }
	 else 
	 {
      log.warn("session does not created properly  ");
	 }
	  return ResponseEntity.ok("{ \n " + "\"username\":\""+currentPrincipalName +
	 "\",\n"+"\"role\":\""+ currentPrincipalRole+
	 "\",\n\"password\":\""+userpass+"\", \n \"userid\":\""+MyPrinciple.userId
	                                     +"\" \n }");	 
 }
 
}
