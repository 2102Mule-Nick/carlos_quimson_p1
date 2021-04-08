package com.revature.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.revature.pojo.Employee;

@Component
public class EmployeeRowMapper implements RowMapper<Employee> {
	
	private EmployeeExtractor employeeExtractor;

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return employeeExtractor.extractData(rs);
	}

	@Autowired
	public void setEmployeeExtractor(EmployeeExtractor employeeExtractor) {
		this.employeeExtractor = employeeExtractor;
	}
	
	

}
