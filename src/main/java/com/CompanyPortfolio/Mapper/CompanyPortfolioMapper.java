package com.CompanyPortfolio.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author rohit
 * 
 *         MAPPER CLASS
 *
 */

@Configuration
public class CompanyPortfolioMapper {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
