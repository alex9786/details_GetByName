package com.example.known.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoClass {

private int id;
	
	private String name;
	
	private String job;
	
	private long salary;
	
	private long contact;
}
