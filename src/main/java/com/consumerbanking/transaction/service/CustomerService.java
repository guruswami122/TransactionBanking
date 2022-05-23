package com.consumerbanking.transaction.service;


import com.consumerbanking.transaction.dto.CustomerRequestDto;
import com.consumerbanking.transaction.dto.CustomerResponseDto;
import com.consumerbanking.transaction.dto.FundTransferRequestDto;
import com.consumerbanking.transaction.dto.FundTransferResponseDto;
import com.consumerbanking.transaction.dto.GooglePayTransferRequestDto;
import com.consumerbanking.transaction.dto.GooglePayTransferResponseDto;

public interface CustomerService {
	
	public CustomerResponseDto saveCustomer(CustomerRequestDto customerRequestDto);
	public FundTransferResponseDto performFundTransfer(FundTransferRequestDto fundTransferRequestDto);
	public GooglePayTransferResponseDto performGooglePayFundTransfer(GooglePayTransferRequestDto googlePayTransferRequestDto);



}
