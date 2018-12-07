package com.pablosrecagno.relations.onetomany.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<PhoneNumber> numbers;
	
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
	public Set<PhoneNumber> getNumbers() {
		return numbers;
	}
	public void setNumbers(Set<PhoneNumber> numbers) {
		this.numbers = numbers;
	}
	
	public void addPhoneNumber(PhoneNumber ph){
		if(ph!=null){
			if(this.numbers==null){
				this.numbers=new HashSet<>();
			}
			ph.setCustomer(this);
			this.numbers.add(ph);
		}
	}
}