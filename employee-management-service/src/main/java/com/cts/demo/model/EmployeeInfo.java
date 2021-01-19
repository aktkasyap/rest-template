package com.cts.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInfo {

	private String name;
	private String gender;
	private int age;
	private double salary;
	private String department;
	private String location;
	
}
