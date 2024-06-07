package com.example.known.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.known.entity.DtoClass;
import com.example.known.entity.Employee;
import com.example.known.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	@Override
	public Employee post(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Optional<Employee> get(int id) {
		return employeeRepo.findById(id);
	}

	@Override
	public Employee update(Employee employee) {
		Optional<Employee> employee1 = employeeRepo.findById(employee.getId());
		Employee employee2 = employee1.get();
		employee2.setId(employee.getId());
		employee2.setName(employee.getName());
		employee2.setJob(employee.getJob());
		employee2.setSalary(employee.getSalary());
		employee2.setContact(employee.getContact());
		return employeeRepo.save(employee2);
	}

	@Override
	public String delete(int id) {
		employeeRepo.deleteById(id);
		return "delete completed";
	}

	@Override
	public List<Employee> getEmployee(String name) {

		if (name == null) {
			return employeeRepo.findAll();
		} else {
			return employeeRepo.findByName(name);
		}

	}

//	@Override
//	public List<Employee> getEmp(String job) {
//		
//		if (job == null) {
//			return employeeRepo.findAll();
//		} else {
//			return employeeRepo.findByJob(job);
//		}
//
//	}

	/******************** DTO Class ***********************/

	// POST METHOD
	@Override
	public DtoClass dtopost(DtoClass dto) {
		Employee employee = new Employee();
		employee.setId(dto.getId());
		employee.setName(dto.getName());
		employee.setJob(dto.getJob());
		employee.setSalary(dto.getSalary());
		employee.setContact(dto.getContact());
		employeeRepo.save(employee);
		return dto;
	}

	// GET METHOD
	@Override
	public DtoClass getDto(int id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		Employee entity = employee.get();
		DtoClass dto = new DtoClass();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setJob(entity.getJob());
		dto.setSalary(entity.getSalary());
		dto.setContact(entity.getContact());
		return dto;
	}

	// GET BY SALARY
	@Override
	public DtoClass getSalary(int salary) {
		Optional<Employee> employee = employeeRepo.findBySalary(salary);
		Employee entity = employee.get();
		DtoClass dto = new DtoClass();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setJob(entity.getJob());
		dto.setSalary(entity.getSalary());
		dto.setContact(entity.getContact());
		return dto;

	}

	// GET BY JOBNAME (or)GET ALL
	@Override
	public List<DtoClass> getById(String job) {
		List<Employee> employee;
		if (job == null) {
			employee = employeeRepo.findAll();
		} else {
			employee = employeeRepo.findByJob(job);
		}
		List<DtoClass> dto = new ArrayList<DtoClass>();
		for (Employee e : employee) {
			DtoClass main = new DtoClass();
			main.setId(e.getId());
			main.setName(e.getName());
			main.setJob(e.getJob());
			main.setSalary(e.getSalary());
			main.setContact(e.getContact());
			dto.add(main);
		}
		return dto;
	}

	// UPDATE METHOD
	@Override
	public DtoClass update(DtoClass dtoClass) {
		Employee employee = new Employee();
		employee.setId(dtoClass.getId());
		employee.setName(dtoClass.getName());
		employee.setJob(dtoClass.getJob());
		employee.setSalary(dtoClass.getSalary());
		employee.setContact(dtoClass.getContact());
		employeeRepo.save(employee);
		return dtoClass;
	}

}
