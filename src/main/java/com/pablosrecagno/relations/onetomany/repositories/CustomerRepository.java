package com.pablosrecagno.relations.onetomany.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pablosrecagno.relations.onetomany.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer>{
}