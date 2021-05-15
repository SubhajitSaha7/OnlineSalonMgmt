package com.cg.salon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.salon.entity.SalonService;

@Repository("salonservicedao")
public interface ISalonServiceDao extends JpaRepository<SalonService, Integer>{

	@Query("from SalonService s where s.serviceName=:sname")
	public List<SalonService> viewSalonServiceByName(@Param("sname") String serviceName);
	@Query("from SalonService s where s.salonLocation=:sloc")
	public List<SalonService> viewSalonServiceByLocation(@Param("sloc") String serviceLocation);
}
