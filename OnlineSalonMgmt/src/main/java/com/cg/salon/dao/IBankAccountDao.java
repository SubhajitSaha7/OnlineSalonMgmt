package com.cg.salon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.salon.entity.BankAccount;

@Repository
public interface IBankAccountDao extends JpaRepository<BankAccount, Integer> {
	

}
