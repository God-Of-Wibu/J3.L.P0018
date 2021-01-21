package com.narga.fashion_blog;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.narga.fashion_blog.converter.StringToPostTypeConverter;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToPostTypeConverter());
	}
}
