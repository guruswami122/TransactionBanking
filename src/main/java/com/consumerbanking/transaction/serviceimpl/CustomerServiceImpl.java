package com.consumerbanking.transaction.serviceimpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.consumerbanking.transaction.dto.AccountRequestDto;
import com.consumerbanking.transaction.dto.CustomerRequestDto;
import com.consumerbanking.transaction.dto.CustomerResponseDto;
import com.consumerbanking.transaction.dto.FundTransferRequestDto;
import com.consumerbanking.transaction.dto.FundTransferResponseDto;
import com.consumerbanking.transaction.dto.GooglePayTransferRequestDto;
import com.consumerbanking.transaction.dto.GooglePayTransferResponseDto;
import com.consumerbanking.transaction.entity.Customer;
import com.consumerbanking.transaction.entity.Transaction;
import com.consumerbanking.transaction.fiegnclient.AccountClient;
import com.consumerbanking.transaction.repository.CustomerRepository;
import com.consumerbanking.transaction.repository.TransactionRepository;
import com.consumerbanking.transaction.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountClient accountClient;
	
	@Autowired
	TransactionRepository transactionRepository;

	//Save Customer
	@Override
	public CustomerResponseDto saveCustomer(CustomerRequestDto customerRequestDto) {
		// TODO Auto-generated method stub
		Customer customer=new Customer();
		BeanUtils.copyProperties(customerRequestDto, customer);
		Customer mainuser=customerRepository.save(customer);
		CustomerResponseDto customerResponseDto=new CustomerResponseDto();
		BeanUtils.copyProperties(mainuser, customerResponseDto);
		AccountRequestDto accountRequestDto=new AccountRequestDto();
		accountRequestDto.setAccountType(customerRequestDto.getAccountType());
		accountRequestDto.setBalance(customerRequestDto.getBalance());
		accountRequestDto.setOpenDate(customerRequestDto.getOpenDate());
		accountRequestDto.setPhoneNumber(customerRequestDto.getPhoneNumber());
		accountRequestDto.setAccountId(customerRequestDto.getAccountId());
		accountClient.saveAccountDetails(accountRequestDto).getStatusCode();
		return customerResponseDto;
		//Account createdAccount = accountClient.saveAccountDetails(null)
		
		
	}
	
	//Perform Account Fund Transfer
	public FundTransferResponseDto performFundTransfer(FundTransferRequestDto fundTransferRequestDto) {
		accountClient.sendAmount(fundTransferRequestDto);
		Transaction transaction=new Transaction();
		transaction.setAmount(fundTransferRequestDto.getAmount());
		transaction.setFromAccount(fundTransferRequestDto.getFromAccountNumber());
		transaction.setToAccount(fundTransferRequestDto.getToAccountNumber());
		transaction.setTransactionType(fundTransferRequestDto.getTransactionType());
		transaction.setTransactionDate(LocalDate.now());
		transactionRepository.save(transaction);
		FundTransferResponseDto fundTransferResponseDto=new FundTransferResponseDto();
		 BeanUtils.copyProperties(transaction,fundTransferResponseDto);
		return fundTransferResponseDto;		
		
	}

	//Perform Account Fund Transfer
	@Override
	public GooglePayTransferResponseDto performGooglePayFundTransfer(
			GooglePayTransferRequestDto googlePayTransferRequestDto) {
		// TODO Auto-generated method stub
		accountClient.performGooglePayFundTransfer(googlePayTransferRequestDto);
		Transaction transaction=new Transaction();
		transaction.setAmount(googlePayTransferRequestDto.getAmount());
		transaction.setFromAccount(accountClient.getAccountNumberByPhoneNumber(googlePayTransferRequestDto.getFromPhoneNumber()));
		transaction.setToAccount(accountClient.getAccountNumberByPhoneNumber(googlePayTransferRequestDto.getToPhoneNumber()));
		transaction.setTransactionType(googlePayTransferRequestDto.getTransactionType());
		transaction.setTransactionDate(LocalDate.now());
		transactionRepository.save(transaction);
		GooglePayTransferResponseDto googlePayTransferResponseDto=new GooglePayTransferResponseDto();
		googlePayTransferResponseDto.setAmount(transaction.getAmount());
		googlePayTransferResponseDto.setFromPhoneNumber(googlePayTransferRequestDto.getFromPhoneNumber());
		googlePayTransferResponseDto.setToPhoneNumber(googlePayTransferRequestDto.getToPhoneNumber());
		googlePayTransferResponseDto.setTransactionDate(transaction.getTransactionDate());
		googlePayTransferResponseDto.setTransactionType(transaction.getTransactionType());
		return googlePayTransferResponseDto;
	}
	

}
