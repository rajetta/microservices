package com.oracle.acs.controller;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.acs.dao.ProductRepository;
import com.oracle.acs.model.Product;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * This class provides functionality to do CRUD operations on Products
 * @author anvarana
 *
 */

@RestController

public class ProductsController {
	
	@Autowired
	private ProductRepository productDao;
	
	@RequestMapping(value="/products", method=GET)
	public List<Product> getProducts() {
		List<Product> returnList = new ArrayList<Product>();
		 productDao.findAll().iterator().forEachRemaining(returnList::add);;
		return returnList;
	}
	
	@RequestMapping(value="/products/{id}", method=GET)
	public Product getProduct( @PathVariable("id") Long id) {
		return productDao.findOne(id);
	}
	
	@RequestMapping(value="/products", method=POST, consumes={MediaType.APPLICATION_JSON_VALUE})
	public void addProduct(@RequestBody Product product) {
		productDao.save(product);
	}
	
	@RequestMapping(value="/products/{id}", method=PUT, consumes={MediaType.APPLICATION_JSON_VALUE})
	public void updateProduct(@RequestBody Product product, @PathVariable("id") Long id) {
		product.setId(id);
		productDao.save(product);
	}
	
	@RequestMapping(value="/products/{id}", method=DELETE, consumes={MediaType.APPLICATION_JSON_VALUE})
	public void deleteProduct(@PathVariable("id") Long id) {
		productDao.delete(id);
		
	}

}
