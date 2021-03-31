package com.revature.test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.PreparedStatement;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.revature.dao.EmployeeDaoJDBCTemplate;
import com.revature.dao.mapper.EmployeeRowMapper;
import com.revature.pojo.Employee;

@ActiveProfiles("employeedao-test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
public class EmployeeDaoJdbcTest {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	EmployeeRowMapper employeeRowMapper;
	
	@Autowired //calls the mockEmployeeDao from the TestConfig
	EmployeeDaoJDBCTemplate employeeDao;
	
	Employee employee = null; // required to make the employee variable available for the entire class
	
	@BeforeEach 
	void setUp() throws Exception{
		employee = new Employee();
		employee.setEmployeeId(1);
		employee.setFirstName("mike");
		employee.setLastName("test");
		employee.setPassword("1234");
		employee.setDepartment("Front Desk");
	}
	
	@Test
	void getEmployeeById() {
		
		int employeeId = 1;
		
		//Copied from EmployeeDaoJDBCTemplate
		String sql = "SELECT * FROM employees WHERE employee_id = ?";
		
		when(jdbcTemplate.queryForObject(sql, employeeRowMapper, employeeId)).thenReturn(employee);
		
		Employee employeeReturn = employeeDao.getEmployeeByEmployeeId(employeeId);
		
		verify(jdbcTemplate).queryForObject(sql, employeeRowMapper, employeeId);
		
		assertEquals(employee, employeeReturn);
	}
	
	@Test //currently not working
	void addEmployee() {
		
		//copied from EmployeeDaoJDBCTemplate.addEmployee
		String sql = "INSERT INTO employees (first_name, last_name, pass_word, department)"
				+ "VALUES (?, ?, ?, ?)";
		
		doNothing().when(employeeDao).addEmployee(employee);
		
		verify(employeeDao,times(1)).addEmployee(employee);
		
		
	}
}
