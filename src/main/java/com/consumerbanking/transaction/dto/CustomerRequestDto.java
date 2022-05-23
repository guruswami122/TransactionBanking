package com.consumerbanking.transaction.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

public class CustomerRequestDto {
	@NotNull(message = "First Name cannot be Empty")
	private String firstName;
    @NotNull(message = "Last Name cannot be Empty")
	private String lastName;
    @NotNull(message = "Gender cannot be Empty")
	private String gender;
    @NotNull(message = "Email cannot be Empty")
	private String email;
    @NotNull(message = "Date of Birth cannot be Empty")
	private LocalDate dob;
    @NotNull(message = "Address cannot be Empty")
	private String address;
    @NotNull(message = "Balance cannot be Empty")
	private BigDecimal balance;
    @NotNull(message = "Account Typecannot be Empty")
	private String accountType;
	private LocalDate openDate;
    @NotNull(message = "Phone Number cannot be Empty")
    @Min(value = 10, message = "Phone Number should not be less than 10 digits")
    @Max(value = 10, message = "Phone Number should not be less than 10 digits")
	private Long phoneNumber;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	private Integer accountId;

	
	
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
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
