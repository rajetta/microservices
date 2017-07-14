package com.oracle.acs.dao;

import org.springframework.stereotype.Repository;

import com.oracle.acs.model.Person;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, JpaSpecificationExecutor<Person>{
	

}
