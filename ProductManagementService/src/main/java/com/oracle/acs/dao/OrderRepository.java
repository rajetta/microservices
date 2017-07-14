package com.oracle.acs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oracle.acs.model.Order;

@RepositoryRestResource
public interface OrderRepository extends CrudRepository<Order, Long>{

}
