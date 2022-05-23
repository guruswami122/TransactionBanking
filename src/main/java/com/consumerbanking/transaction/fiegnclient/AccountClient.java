package com.consumerbanking.transaction.fiegnclient;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.consumerbanking.transaction.dto.AccountRequestDto;
import com.consumerbanking.transaction.dto.AccountResponseDto;
import com.consumerbanking.transaction.dto.FundTransferRequestDto;
import com.consumerbanking.transaction.dto.FundTransferResponseDto;
import com.consumerbanking.transaction.dto.GooglePayTransferRequestDto;
import com.consumerbanking.transaction.dto.GooglePayTransferResponseDto;

@FeignClient(value = "account-client", url = "http://localhost:9090/account")
public interface AccountClient {
	
	
	@PostMapping("/saveAccountDetails")
	public ResponseEntity<AccountResponseDto> saveAccountDetails(@RequestBody AccountRequestDto accountRequestDto);
	
	@PostMapping("/fundTransfer")
	public ResponseEntity<FundTransferResponseDto> sendAmount(@Valid @RequestBody FundTransferRequestDto fundTransferRequestDto);
      
	@PostMapping("/googlePayfundTransfer")
	public ResponseEntity<GooglePayTransferResponseDto> performGooglePayFundTransfer(@Valid @RequestBody GooglePayTransferRequestDto googlePayTransferRequestDto);
	
	 @GetMapping("/getAccountNumber")
	public Long getAccountNumberByPhoneNumber(@RequestParam Long phoneNumber);

	}


