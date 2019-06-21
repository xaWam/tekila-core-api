package com.jaravir.tekila.module.payment.adapter;

import com.jaravir.tekila.module.payment.Payment;
import com.jaravir.tekila.module.payment.PaymentInfo;

public interface PaymentAdaptor {
	public Payment convert (PaymentInfo data);
	public long convertAmount (double amount);
}
