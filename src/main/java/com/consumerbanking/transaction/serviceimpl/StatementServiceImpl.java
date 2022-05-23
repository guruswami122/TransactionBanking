package com.consumerbanking.transaction.serviceimpl;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumerbanking.transaction.dto.StatementRequestDto;
import com.consumerbanking.transaction.entity.Transaction;
import com.consumerbanking.transaction.fiegnclient.AccountClient;
import com.consumerbanking.transaction.repository.StatementRepository;
import com.consumerbanking.transaction.service.StatementService;

@Service
public class StatementServiceImpl implements StatementService{
	
	@Autowired
	StatementRepository statementRepository;
	
	@Autowired
	AccountClient accountClient;

	/*
	 * @Override public List<Transaction> getMonthlyEStatement(long accountno, int
	 * month, int year) { // TODO Auto-generated method stub LocalDate
	 * startDate=LocalDate.of(year, month, 1); LocalDate lastDate=LocalDate.of(year,
	 * month, startDate.lengthOfMonth()); return
	 * statementRepository.findByFromAccountOrToAccountAndTransactionDateBetween(
	 * accountno, accountno, startDate, lastDate);
	 * 
	 * 
	 * }
	 * 
	 * @Override public List<Transaction> getMonthlyEStatementByPhoneNumber(long
	 * phonenumber, int month, int year) { // TODO Auto-generated method stub Long
	 * account=accountClient.getAccountNumberByPhoneNumber(phonenumber); LocalDate
	 * startDate=LocalDate.of(year, month, 1); LocalDate lastDate=LocalDate.of(year,
	 * month, startDate.lengthOfMonth()); return
	 * statementRepository.findByFromAccountOrToAccountAndTransactionDateBetween(
	 * account, account, startDate, lastDate);
	 * 
	 * }
	 */

	@Override
	public List<Transaction> getMonthlyEStatement(long phonenumber) {
		// TODO Auto-generated method stub
		Long account=accountClient.getAccountNumberByPhoneNumber(phonenumber);
		//return (List<Transaction>) statementRepository.findByFromAccountOrToAccount(account,account).stream().limit(5).toList();
		return statementRepository.findByFromAccountOrToAccount(account,account).stream().sorted(Comparator.comparing(Transaction::getTransactionDate).reversed()).limit(5).toList();


	}

	

}
