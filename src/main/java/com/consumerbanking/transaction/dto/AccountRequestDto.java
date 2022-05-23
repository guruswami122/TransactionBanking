package com.consumerbanking.transaction.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

public class AccountRequestDto {
	@NotNull(message = "Account IDcannot be Empty")
	private Integer accountId;
    @NotNull(message = "Account Balance cannot be Empty")
	private BigDecimal balance;
    @NotNull(message = "Account Typecannot be Empty")
	private String accountType;
	private LocalDate openDate;
    @NotNull(message = "Phone Number cannot be Empty")
	private Long phoneNumber;

	
    public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public LocalDate getOpenDate() {
		return openDate;
	}
	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}


}
