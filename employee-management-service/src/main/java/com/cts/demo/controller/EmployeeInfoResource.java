package com.cts.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.demo.model.Department;
import com.cts.demo.model.Employee;
import com.cts.demo.model.EmployeeInfo;
import com.cts.demo.model.Location;

@RestController
public class EmployeeInfoResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/employees/{id}")
	public EmployeeInfo getEmployeeInfo(@PathVariable int id) {
		
	
		Employee employee=restTemplate.
			getForObject("http://employee-service/employees/"+id, Employee.class);
		
		
		Department dept=restTemplate.
		getForObject("http://department-service/departments/"+employee.getDepartmentId(), Department.class);
		
		Location location=
				restTemplate.
				getForObject("http://location-service/locations/"+dept.getLocationId(), Location.class);
		
		EmployeeInfo info=
				new EmployeeInfo(employee.getName(), employee.getGender(), employee.getAge(), employee.getSalary(), dept.getDepartmentName(), location.getLocationName());
		
		return info;
		
	}
}
