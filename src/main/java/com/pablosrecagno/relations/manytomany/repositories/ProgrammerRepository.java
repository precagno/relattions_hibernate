package com.pablosrecagno.relations.manytomany.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pablosrecagno.relations.manytomany.entities.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer,Integer> {
}