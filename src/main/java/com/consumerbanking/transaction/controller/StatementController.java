package com.consumerbanking.transaction.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumerbanking.transaction.entity.Transaction;
import com.consumerbanking.transaction.service.StatementService;

@RestController
public class StatementController {
	
	@Autowired
	StatementService statementService;
	
	/*
	 * @GetMapping("/monthly/{accountno}/{month}/{year}") public List<Transaction>
	 * getMonthlyEStatement(@PathVariable long accountno,@PathVariable int
	 * month,@PathVariable int year) { return
	 * statementService.getMonthlyEStatement(accountno, month, year); }
	 * 
	 * @GetMapping("/monthlygooglepaystatement/{phonenumber}/{month}/{year}") public
	 * List<Transaction> getMonthlyEStatementByPhoneNumber(@PathVariable long
	 * phonenumber,@PathVariable int month,@PathVariable int year) { return
	 * statementService.getMonthlyEStatementByPhoneNumber(phonenumber, month, year);
	 * 
	 * }
	 */
	
	@GetMapping("/monthlygooglepaystatement/{phonenumber}")
	public List<Transaction> getMonthlyEStatement(@PathVariable long phonenumber) {
		return statementService.getMonthlyEStatement(phonenumber);
		
	}

}
