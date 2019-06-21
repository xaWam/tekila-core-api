package com.jaravir.tekila.module.payment;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

import com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace;

@XmlRootElement (namespace=XmlSchemaNamespace.PAYMENT_NS)

public class PaymentDummy extends BasePayment implements Serializable {
	private long amount;
	private long subctiptionId;
	private static final long serialVersionUID = 3201356268299341943L;
	
	public PaymentDummy() {}
	
	public PaymentDummy(PaymentSourceType source, long transactionId, DateTime date,
			long amount) {
		super(source, transactionId, date);
		this.amount = amount;
	}

	@XmlAttribute
	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getSubctiptionId() {
		return subctiptionId;
	}

	public void setSubctiptionId(long subctiptionId) {
		this.subctiptionId = subctiptionId;
	}		
}
