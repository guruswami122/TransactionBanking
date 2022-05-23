package com.consumerbanking.transaction.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.consumerbanking.transaction.dto.AccountRequestDto;
import com.consumerbanking.transaction.dto.AccountResponseDto;
import com.consumerbanking.transaction.dto.CustomerRequestDto;
import com.consumerbanking.transaction.dto.CustomerResponseDto;
import com.consumerbanking.transaction.dto.FundTransferRequestDto;
import com.consumerbanking.transaction.dto.FundTransferResponseDto;
import com.consumerbanking.transaction.dto.GooglePayTransferRequestDto;
import com.consumerbanking.transaction.dto.GooglePayTransferResponseDto;
import com.consumerbanking.transaction.service.CustomerService;


@RestController
@Validated
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	//Save Customer
	@PostMapping("/saveCustomer")
	public ResponseEntity<CustomerResponseDto> saveCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.saveCustomer(customerRequestDto));
	}
	
	//Perform Account Fund Transfer
	@PostMapping("/fundTransfer")
	public ResponseEntity<FundTransferResponseDto> performFundTransfer(@Valid @RequestBody FundTransferRequestDto fundTransferRequestDto) {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.performFundTransfer(fundTransferRequestDto));
	
		}
	
	//Perform Account Fund Transfer
	@PostMapping("/googlePayfundTransfer")
	public ResponseEntity<GooglePayTransferResponseDto> performGooglePayFundTransfer(@Valid @RequestBody GooglePayTransferRequestDto googlePayTransferRequestDto){
		return ResponseEntity.status(HttpStatus.OK).body(customerService.performGooglePayFundTransfer(googlePayTransferRequestDto));
	}
	
}
