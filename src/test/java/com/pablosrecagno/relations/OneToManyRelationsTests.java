package com.pablosrecagno.relations;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pablosrecagno.relations.onetomany.entities.Customer;
import com.pablosrecagno.relations.onetomany.entities.PhoneNumber;
import com.pablosrecagno.relations.onetomany.repositories.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToManyRelationsTests {
	@Autowired
	private CustomerRepository repository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateCustomers(){
		this.repository.deleteAll();
		
		Customer cust1=new Customer();
		cust1.setName("Alejandro Ghioldi");
		
		Customer cust2=new Customer();
		cust2.setName("gustavo Diaz");
		
		PhoneNumber ph1 = new PhoneNumber();
		ph1.setPhoneNumber("8778898");
		ph1.setPhoneType("cell");
		
		PhoneNumber ph2 = new PhoneNumber();
		ph2.setPhoneNumber("57344");
		ph2.setPhoneType("cell");
		
		PhoneNumber ph3 = new PhoneNumber();
		ph3.setPhoneNumber("873332");
		ph3.setPhoneType("cell");
		
		PhoneNumber ph4 = new PhoneNumber();
		ph4.setPhoneNumber("00000113");
		ph4.setPhoneType("cell");
		
		cust1.addPhoneNumber(ph1);
		cust1.addPhoneNumber(ph2);
		cust2.addPhoneNumber(ph3);
		cust2.addPhoneNumber(ph4);
		
		
		
		this.repository.save(cust1);
		this.repository.save(cust2);
	}
}