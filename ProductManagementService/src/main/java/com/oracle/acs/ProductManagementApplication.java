package com.oracle.acs;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.oracle.acs.dao.OrderRepository;
import com.oracle.acs.dao.PersonRepository;
import com.oracle.acs.dao.ProductRepository;
import com.oracle.acs.model.Person;
import com.oracle.acs.model.Product;



@SpringBootApplication
public class ProductManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(ProductRepository productRepository, OrderRepository orderRepository
			) {
		return (evt) -> Arrays.asList(
				"Galaxy,iPhone".split(","))
				.forEach(
						a -> {
							productRepository.save(new Product(a,
									"Cell Phone"));
								
						});
	}
	
	@Bean
	CommandLineRunner initPeople(PersonRepository personRepository) {
		
		 return(evt) -> Arrays.asList(
	                new Person("John", "Doe", 10, "Blue"),
	                new Person("Robert", "Doe", 8, "Black"),
	                new Person("Anu", "Varanasi", 5, "Pink"),
	                new Person("Amruta", "Taylor", 5, "Pink"),
	                new Person("Tom", "Christopher", 6, "Brown"),
	                new Person("Chris", "D", 15, "Purple"),
	                new Person("Sam", "B", 25, "Yellow"),
	                new Person("Bob", "A", 28, "Orange"),
	                new Person("Smith", "Taylor", 32, "Indigo"),
	                new Person("Thomas", "Donald", 2, "Green"),
	                new Person("Katherine", "Joseph", 22, "Violet"))
	                .forEach(p -> {
	                	personRepository.save(p);
	                });
	                
	                

			
	}
	
	
}




