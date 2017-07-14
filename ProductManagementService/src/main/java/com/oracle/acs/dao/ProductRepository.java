package com.oracle.acs.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oracle.acs.model.Product;
 
/**
 * 
 * @author anvarana
 *
 */
@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	List<Product> findByName(String name);
	

}
