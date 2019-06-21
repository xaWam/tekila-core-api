package com.jaravir.tekila.module.payment;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.joda.time.DateTime;

import com.jaravir.tekila.base.binding.xml.mapper.XmlSchemaNamespace;

@XmlType(namespace=XmlSchemaNamespace.PAYMENT_NS)
public class BasePayment implements Serializable {
	
	protected PaymentSourceType source;
	protected long transactionId;	
	protected DateTime date;
	private static final long serialVersionUID = 1L;
	
	public BasePayment() {}
	
	public BasePayment(PaymentSourceType source, long transactionId,
			DateTime date) {
		this.source = source;
		this.transactionId = transactionId;
		this.date = date;
	}
	
	@XmlAttribute
	public final PaymentSourceType getSource() {
		return source;
	}
	public final void setSource(PaymentSourceType source) {
		this.source = source;
	}
	
	@XmlAttribute
	public final long getTransactionId() {
		return transactionId;
	}
	public final void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	
	@XmlTransient
	public final DateTime getDate() {
		return date;
	}
	
	public final void setDate(DateTime date) {
		this.date = date;
	}
	
	@XmlAttribute
	public Calendar getTimeStamp() {
		return this.date.toCalendar(new Locale("en"));
	}
	
	public void setTimeStamp (Calendar dt) {
		this.date = new DateTime(dt);
	}
}
