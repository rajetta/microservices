package com.oracle.acs.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.acs.dao.OrderRepository;
import com.oracle.acs.model.Order;

@RestController
public class OrdersController {
	
	@Autowired
	private OrderRepository orderDao;
	
	@RequestMapping(value="/orders", method=GET)
	public List<Order> getOrders() {
		List<Order> returnList = new ArrayList<Order>();
		 orderDao.findAll().iterator().forEachRemaining(returnList::add);;
		return returnList;
	}
	
	@RequestMapping(value="/orders/{id}", method=GET)
	public Order getOrder( @PathVariable("id") Long id) {
		return orderDao.findOne(id);
	}
	
	@RequestMapping(value="/orders", method=POST, consumes={MediaType.APPLICATION_JSON_VALUE})
	public void addOrder(@RequestBody Order Order) {
		orderDao.save(Order);
	}
	
	@RequestMapping(value="/orders/{id}", method=PUT, consumes={MediaType.APPLICATION_JSON_VALUE})
	public void updateOrder(@RequestBody Order Order, @PathVariable("id") Long id) {
		Order.setId(id);
		orderDao.save(Order);
	}
	
	@RequestMapping(value="/orders/{id}", method=DELETE, consumes={MediaType.APPLICATION_JSON_VALUE})
	public void deleteOrder(@PathVariable("id") Long id) {
		orderDao.delete(id);
		
	}

}
