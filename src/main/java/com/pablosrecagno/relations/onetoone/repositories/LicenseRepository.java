package com.pablosrecagno.relations.onetoone.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pablosrecagno.relations.onetoone.entities.License;

public interface LicenseRepository extends CrudRepository<License,Long>{

}
