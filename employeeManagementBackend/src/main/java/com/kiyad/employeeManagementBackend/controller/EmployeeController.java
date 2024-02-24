package com.kiyad.employeeManagementBackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kiyad.employeeManagementBackend.model.Employee;
import com.kiyad.employeeManagementBackend.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//http://localhost:8080/api/employee
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		
		Employee savedEmployee = employeeService.createEmployee(employee);
		
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
		
	}
	
	//http://localhost:8080/api/employee/6
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		
		Employee getEmployee = employeeService.getEmployeeById(id);
		
		return ResponseEntity.ok(getEmployee);
		
	}
	
	//http://localhost:8080/api/employee
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
         List<Employee> employeeList = employeeService.getAllEmployee();
         
         return ResponseEntity.ok(employeeList);
		
	}
	
	//http://localhost:8080/api/employee/4
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmplyee){
		
		Employee updated = employeeService.updateEmployee(id, updatedEmplyee);
		
		return ResponseEntity.ok(updated);
		
	}
	
	//http://localhost:8080/api/employee/3
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
		
		employeeService.deleteEmployee(id);
		
		return ResponseEntity.ok("employee deleted successfully");
	}
}
