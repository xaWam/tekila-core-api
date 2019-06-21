package com.jaravir.tekila.module.payment;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.joda.time.DateTime;

import com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace;
import com.jaravir.tekila.module.subscription.persistence.entity.Subscription;

@XmlRootElement
@XmlType(namespace=XmlSchemaNamespace.PAYMENT_NS)
public class Payment extends BasePayment {
	
	private static final long serialVersionUID = -8618217284272792587L;
	private long amount;
	private Subscription subcription;

	public Payment() {}
	
	public Payment(PaymentSourceType source, long transactionId, DateTime date,
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

	public Subscription getSubcription() {
		return subcription;
	}

	public void setSubcription(Subscription subcription) {
		this.subcription = subcription;
	}
}
