package com.cg.salon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.salon.entity.Customer;

@Repository("customerdao")
public interface ICustomerDao extends JpaRepository<Customer, Integer>{

	@Query("from Customer c where c.name=:name")
	public List<Customer> viewCustomerByName(@Param("name") String name);
	
	@Query("from Customer c where c.city=:city")
	public List<Customer> viewCustomerByCity(@Param("city") String city);
	
	@Query("from Customer c where c.contactNo=:contactNo")
	public List<Customer> viewCustomerByContactNo(@Param("contactNo")String contactNo);
}
