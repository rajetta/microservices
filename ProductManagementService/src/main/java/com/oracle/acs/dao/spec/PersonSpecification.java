package com.oracle.acs.dao.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.oracle.acs.model.Person;

/**
 * 
 * @author anvarana
 *
 */
public class PersonSpecification implements Specification<Person>{
	private Person filter;
	
	public PersonSpecification(Person filter) {
		super();
		this.filter = filter;
		
	}

	@Override
	public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> c, CriteriaBuilder cb) {
		Predicate p = cb.conjunction();

        if (filter.getFirstName() != null) {
            p.getExpressions() 
                    .add(cb.like(root.<String>get("firstName"), "%"+filter.getFirstName()+"%"));
        }

        if (filter.getLastName() != null)  {
            p.getExpressions().add(
            		cb.and(cb.like(root.<String>get("lastName"), "%"+filter.getLastName()+"%")));
                          
        }
        
        if (filter.getAge() != null) {
        	p.getExpressions().add(
        			cb.and(cb.equal(root.get("age"), filter.getAge())));	
        }
        
        if (filter.getFavColor() != null) {
        	p.getExpressions().add(
        			cb.and(cb.like(root.<String>get("favColor"), "%"+filter.getFavColor()+"%")));
        }        

        return p;
	}

}
