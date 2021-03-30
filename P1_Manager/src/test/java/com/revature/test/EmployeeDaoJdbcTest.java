package com.revature.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
	
	@Test
	void getEmployeeById() {
		
		int employeeId = 1;
		
		//Copied from EmployeeDaoJDBCTemplate
		String sql = "SELECT * FROM employees WHERE employee_id = ?";
		
		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setFirstName("mike");
		employee.setLastName("test");
		employee.setPassword("1234");
		employee.setDepartment("Front Desk");
		
		when(jdbcTemplate.queryForObject(sql, employeeRowMapper, employeeId)).thenReturn(employee);
		
		Employee employeeReturn = employeeDao.getEmployeeByEmployeeId(employeeId);
		
		verify(jdbcTemplate).queryForObject(sql, employeeRowMapper, employeeId);
		
		assertEquals(employee, employeeReturn);
	}
}
