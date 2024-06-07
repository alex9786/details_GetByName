package com.example.known.service;

import java.util.List;
import java.util.Optional;

import com.example.known.entity.DtoClass;
import com.example.known.entity.Employee;

public interface EmployeeService {

	Employee post(Employee employee);

	Optional<Employee> get(int id);

	Employee update(Employee employee);

	String delete(int id);

	List<Employee> getEmployee(String name);

//	List<Employee> getEmp(String job);
	
	DtoClass dtopost(DtoClass dto);

	DtoClass getDto(int id);

	DtoClass getSalary(int salary);

	List<DtoClass> getById(String job);

	DtoClass update(DtoClass dtoClass);



	

	

	

}
