package com.revature.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.revature.dao.mapper.EmployeeRowMapper;
import com.revature.pojo.Employee;

@Repository
public class EmployeeDaoJDBCTemplate implements EmployeeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	private EmployeeRowMapper employeeRowMapper;
	
	
	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		
		String sql = "SELECT * FROM employees WHERE employee_id = ?";
		
		// List<Employee> employeeList = jdbcTemplate.query(sql, employeeRowMapper, employeeId); does not work with JUnit?
		
		return jdbcTemplate.queryForObject(sql, employeeRowMapper, employeeId);
		
	}
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public void setEmployeeRowMapper(EmployeeRowMapper employeeRowMapper) {
		this.employeeRowMapper = employeeRowMapper;
	}

	/***************************************************************************************************************************
	 * 
	 * Only available for manager application
	 * 
	@Override
	public void addEmployee(Employee employee) { //maybe return employee to show the employee_id for the newly added employee
		
		String sql = "INSERT INTO employees (first_name, last_name, pass_word, department)"
				+ "VALUES (?, ?, ?, ?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getPassword());
			ps.setString(4, employee.getDepartment());
			return ps;
		}, keyHolder);
		
		employee.setEmployeeId((int) keyHolder.getKeys().get("employee_id"));
		
		//return employee; uncomment later when ready

	}

	@Override
	public List<Employee> getAllEmployee() {
		
		String sql = "SELECT * FROM employees";
		
		List<Employee> allEmployeeList = jdbcTemplate.query(sql, employeeRowMapper);
		
		return allEmployeeList;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}
	
	************************************************************************************************************/

}
