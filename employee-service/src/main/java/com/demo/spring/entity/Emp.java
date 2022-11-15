package com.demo.spring.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="EMP")
@XmlRootElement
public class Emp {

	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DOB")
	private LocalDate dob;
	
	public Emp() {
		
	}

	
	
	public Emp(int id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
}
