package com.codeflow.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

	/**
	 * liberar apenas os permitidos, deixei * pois não sei quais as urls utilizadas
	 * pela empresa. qualquer coisa apenas adicionar novo registry.
	 */
	@Override
	public void addCorsMappings(final CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD",
				"TRACE", "CONNECT");
	}
}