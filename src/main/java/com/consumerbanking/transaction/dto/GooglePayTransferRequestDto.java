package com.consumerbanking.transaction.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class GooglePayTransferRequestDto {
	@NotNull(message = "Amount cannot be Empty")
	private BigDecimal amount;
        @NotNull(message = "From Phone Number cannot be Empty")
	private Long fromPhoneNumber;
       @NotNull(message = "To Phone Number cannot be Empty")
	private Long toPhoneNumber;
       @NotNull(message = "Transaction  cannot be Empty")
	private String transactionType;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Long getFromPhoneNumber() {
		return fromPhoneNumber;
	}
	public void setFromPhoneNumber(Long fromPhoneNumber) {
		this.fromPhoneNumber = fromPhoneNumber;
	}
	public Long getToPhoneNumber() {
		return toPhoneNumber;
	}
	public void setToPhoneNumber(Long toPhoneNumber) {
		this.toPhoneNumber = toPhoneNumber;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


}
