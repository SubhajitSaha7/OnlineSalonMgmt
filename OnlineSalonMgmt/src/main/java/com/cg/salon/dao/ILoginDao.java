package com.cg.salon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.salon.entity.Login;

/*
 * Created By Titas Sarkar
 */
@Repository
public interface ILoginDao extends JpaRepository<Login, Integer> {

}
