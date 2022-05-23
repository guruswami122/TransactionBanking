package com.consumerbanking.transaction.service;

import java.util.List;

import com.consumerbanking.transaction.dto.StatementRequestDto;
import com.consumerbanking.transaction.entity.Transaction;


public interface StatementService {
	
	//List<Transaction> getMonthlyEStatement(long accountno, int month, int year);
	//List<Transaction> getMonthlyEStatementByPhoneNumber(long phonenumber, int month, int year);
	List<Transaction> getMonthlyEStatement(long phonenumber);


}
