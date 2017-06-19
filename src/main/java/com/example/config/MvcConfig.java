package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry reg) {
		reg.addViewController("/home").setViewName("home");
		reg.addViewController("/").setViewName("home");
		reg.addViewController("/hello").setViewName("hello");
		reg.addViewController("/login").setViewName("login");
		
	}
}
