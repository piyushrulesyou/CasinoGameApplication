package com.nagarro.adminPanel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.nagarro.adminPanel.constants.Constants;


@Configuration
@EnableWebMvc
public class AppConfig {

	
//	@Bean(name = "multipartResolver")
//	public CommonsMultipartResolver multipartResolver() {
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		multipartResolver.setMaxUploadSize(Constants.IMAGE_MAX_SIZE);
//		return multipartResolver;
//	}
	
	
}
