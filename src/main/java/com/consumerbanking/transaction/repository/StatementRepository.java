package com.consumerbanking.transaction.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumerbanking.transaction.entity.Transaction;



@Repository
public interface StatementRepository extends JpaRepository<Transaction, Integer>{
	
	//List<Transaction> findByFromAccountOrToAccountAndTransactionDateBetween(Long long1,Long long2, LocalDate date1,LocalDate date2);
	List<Transaction> findByFromAccountOrToAccount(Long Long1,Long Long2);

	



}
