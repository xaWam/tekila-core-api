package com.jaravir.tekila.module.payment;

import com.jaravir.tekila.module.payment.adapter.PaymentAdaptor;

public class BasePaymentAdaptor implements PaymentAdaptor {
	private static final int CONVERSION_FACTOR;
	
	static {
		CONVERSION_FACTOR = 10 ^ 2;
	}
	
	@Override
	public Payment convert(PaymentInfo data) {
		Payment pm = new Payment(data.getSource(), 
				data.getTransactionId(), 
				data.getDate(), 
				this.convertAmount(data.getAmount())
				);
		return pm;
	}

	@Override
	public long convertAmount(double amount) {
		return (long)(amount * CONVERSION_FACTOR);
	}	
	
	
}
