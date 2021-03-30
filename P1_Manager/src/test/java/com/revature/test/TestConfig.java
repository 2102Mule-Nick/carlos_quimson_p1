package com.revature.test;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.dao.EmployeeDaoJDBCTemplate;
import com.revature.dao.mapper.EmployeeExtractor;
import com.revature.dao.mapper.EmployeeRowMapper;

@Profile("employeedao-test")
@Configuration
public class TestConfig {

	@Bean
	public JdbcTemplate mockJdbcTemplate() {
		
		System.out.println("Running TestConfig"); //switch to logger when possible
		return Mockito.mock(JdbcTemplate.class);
	}
	
	@Bean
	public EmployeeRowMapper mockRowMapper() {
		return Mockito.mock(EmployeeRowMapper.class);
	}
	
	@Bean
	public EmployeeExtractor mockExtractor() {
		return Mockito.mock(EmployeeExtractor.class);
	}
	
	@Bean
	public EmployeeDaoJDBCTemplate employeeJdbc(JdbcTemplate mockJdbcTemplate, 
			EmployeeRowMapper mockRowMapper) {
		EmployeeDaoJDBCTemplate employeeDao = new EmployeeDaoJDBCTemplate();
		
		employeeDao.setJdbcTemplate(mockJdbcTemplate);
		employeeDao.setEmployeeRowMapper(mockRowMapper);
		
		return employeeDao;
	}
}
