package com.jaravir.tekila.module.payment;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.joda.time.DateTime;

import com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace;

@XmlRootElement
@XmlType(namespace=XmlSchemaNamespace.PAYMENT_NS)

public class PaymentInfo extends BasePayment {

	private double amount;
	private String customerIdentifier;
	private static final long serialVersionUID = 6750102886741714215L;

	public PaymentInfo() {
		
	}
	
	public PaymentInfo(PaymentSourceType source, long transactionId,
			DateTime date, double amount, String customerIdentifier) {
		super(source, transactionId, date);
		this.amount = amount;
		this.customerIdentifier = customerIdentifier;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getCustomerIdentifier() {
		return customerIdentifier;
	}
	
	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}
		
}
