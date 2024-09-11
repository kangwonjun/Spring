package com.yedam.app.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCconfig implements WebMvcConfigurer {

	@Value("${file.upload.path}")
	private String uploadPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/imgs/**") // URL
		.addResourceLocations("file:///" + uploadPath); //실제경로
	} 
	
}
