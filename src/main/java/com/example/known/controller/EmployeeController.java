package com.example.known.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.known.entity.DtoClass;
import com.example.known.entity.Employee;
import com.example.known.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService empservice;
	
	//post
	@PostMapping("/post")
	public Employee post(@RequestBody Employee employee) {
		return empservice.post(employee);
	}
	
	//get
	@GetMapping("/get/{id}")
	public Optional<Employee> get(@PathVariable ("id") int id){
		return  empservice.get(id);
	}
	
	//update
	@PutMapping("/update")
	public Employee update (@RequestBody Employee employee) {
		return empservice.update(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return empservice.delete(id);
	}
	
	@GetMapping("/getBy")
	public List<Employee> getEmployee(@RequestParam (value="name",required=false)String name){
		return empservice.getEmployee(name);
	}
	
	@GetMapping("/getJob")
	public List<Employee> getEmp(@RequestParam(value="job",required=false) String job){
		return empservice.getEmp(job);
	}
	
	/***************************DTO Class******************************/
	
	@PostMapping("/postDto")
	public DtoClass dtoPost(@RequestBody DtoClass dto) {
		return empservice.dtopost(dto);
	}
	
	@GetMapping("/getDto/{id}")
	public DtoClass getDto (@PathVariable ("id") int id) {
		return empservice.getDto(id);
	}

	
	

}









