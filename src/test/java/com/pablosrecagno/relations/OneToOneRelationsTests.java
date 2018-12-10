package com.pablosrecagno.relations;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pablosrecagno.relations.onetoone.entities.License;
import com.pablosrecagno.relations.onetoone.entities.Person;
import com.pablosrecagno.relations.onetoone.repositories.LicenseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OneToOneRelationsTests {
	@Autowired
	private LicenseRepository repository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateLicense(){
		this.repository.deleteAll();

		Person person=new Person();
		
		person.setFirstname("Pablo");
		person.setLastname("Santiago");
		person.setAge(30);
		
		License license=new License();
		license.setType("Car");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		
		license.setPerson(person);
		
		this.repository.save(license);
	}
}