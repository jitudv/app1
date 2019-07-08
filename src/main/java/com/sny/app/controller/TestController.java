package com.sny.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/")
public class TestController
{
          
	@GetMapping("/test")
	public String viewName() {
		return "index";
	}
   
   
}
