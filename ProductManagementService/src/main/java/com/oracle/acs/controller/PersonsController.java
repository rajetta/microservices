package com.oracle.acs.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.acs.dao.PersonRepository;
import com.oracle.acs.dao.spec.PersonSpecification;
import com.oracle.acs.model.Person;

/**
 * This is a demonstration of Spring's sorting and paging dao
 * @author anvarana
 *
 */

@RestController
public class PersonsController {
	@Autowired
	private PersonRepository personDao;
	
	@RequestMapping(value="/persons", method=GET)
	public Iterable<Person> getPersons(@RequestParam(value = "page", required=false) Integer page, 
			@RequestParam(value = "offset", required=false) Integer offset,
			@RequestParam(value = "sort", required=false) String sort,
			HttpServletRequest request) {
			
		// Check for optional programmatic query params
		Person filter = new Person();
		filter.setFirstName(request.getParameter("firstName"));
		filter.setLastName(request.getParameter("lastName"));
		filter.setAge(request.getParameter("age") == null? null:new Integer(request.getParameter("age")));
		filter.setFavColor(request.getParameter("favColor"));
		
		Specification<Person> spec = new PersonSpecification(filter);
		
		
		// Handle the simple case first. If none of the query params are provided, return all the persons
		if ((page == null) && (offset == null) && (sort == null) ) {
			return personDao.findAll(spec);
		} 
		
		// Set defaults
		if (page == null) page = 1;
		if (offset == null) offset = 5;
		
		// prepare sort order
		Sort sortOrder = null;
		if (sort != null) {
			List<Sort.Order> orderList = new ArrayList<>();
			String[] sortFields = sort.split(",");
			
			for (String s: sortFields) {
				Sort.Direction direction = null;
				if (s.charAt(0) == '+') { 
					direction = Direction.ASC;
				} else if (s.charAt(0) == '-') {
					direction = Direction.DESC;
				}
				
				Sort.Order order = new Sort.Order(direction, s.substring(1, s.length()));
				orderList.add(order);
			}
			sortOrder = new Sort(orderList);
		}
		
		// Return the results
		Page<Person> personpage = null;
		if (sortOrder != null) {
			personpage = personDao.findAll(spec, new PageRequest(page, offset, sortOrder));
		} else {
			personpage = personDao.findAll(spec, new PageRequest(page, offset));
		}
			
		return personpage.getContent();
	}

}
