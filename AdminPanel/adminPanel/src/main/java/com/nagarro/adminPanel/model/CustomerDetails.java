package com.nagarro.adminPanel.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerDetails")
public class CustomerDetails {

	@Id
	private String customerID;

	private String customerName;
	private String dateOfBirth;
	private String contactNumber;
	private String emailID;
//	private Blob idProof;
//
//	public Blob getIdProof() {
//		return idProof;
//	}
//
//	public void setIdProof(Blob idProof) {
//		this.idProof = idProof;
//	}

	private double accountBalance;
	private double blockedAmount;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double getBlockedAmount() {
		return blockedAmount;
	}

	public void setBlockedAmount(double blockedAmount) {
		this.blockedAmount = blockedAmount;
	}

	@Override
	public String toString() {
		return "CustomerDetails [customerID=" + customerID + ", customerName=" + customerName + ", dateOfBirth="
				+ dateOfBirth + ", contactNumber=" + contactNumber + ", emailID=" + emailID + ", accountBalance="
				+ accountBalance + ", blockedAmount=" + blockedAmount + "]";
	}

}
