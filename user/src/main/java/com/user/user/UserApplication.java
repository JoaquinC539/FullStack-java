package com.user.user;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.user.user.configuration.AppConfig;


@SpringBootApplication
@Controller
public class UserApplication {
	@GetMapping("/index")
	public ModelAndView index(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("index");
		// AppConfig conf=new AppConfig();
		System.out.println(System.getenv("DB_URL")); 
		return modelAndView;
	}
	@GetMapping("/")
	public ModelAndView index0(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	public static void main(String[] args) {		
		SpringApplication.run(UserApplication.class, args);
	}

}
