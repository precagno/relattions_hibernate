package com.pablosrecagno.relations;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pablosrecagno.relations.manytomany.entities.Programmer;
import com.pablosrecagno.relations.manytomany.entities.Project;
import com.pablosrecagno.relations.manytomany.repositories.ProgrammerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToManyRelationsTests {
	@Autowired
	private ProgrammerRepository repository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateCustomers(){
		this.repository.deleteAll();
		
		Programmer prg1 = new Programmer();
		prg1.setName("Pablo");
		
		Set<Project> projects=new HashSet<>();
		
		Project project1=new Project();
		Project project2=new Project();
		
		project1.setName("Hibernate Project");
		project2.setName("Eclipse Link Project");
		
		projects.add(project1);
		projects.add(project2);
		
		prg1.setProjects(projects);
		
		this.repository.save(prg1);
	}
	
	@Test
	@Transactional
	public void testFindProgrammer(){
		Programmer programmer = this.repository.findById(1).get();
		System.out.println(programmer);
		System.out.println(programmer.getProjects());
	}
}