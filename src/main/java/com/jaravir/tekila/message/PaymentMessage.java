package com.jaravir.tekila.message;

import java.io.Serializable;

public final class PaymentMessage implements Serializable {
	
	private static final long serialVersionUID = -4656558653463559703L;
	private final int origintType;
	private final long transactionId;
	private final long date;
	private final long amount;
	private final long accountID;
	private final int accountIDType;
	
	public PaymentMessage(int origintType, long transactionId, long date,
			long amount, long accountID, int accountIDType) {
		this.origintType = origintType;
		this.transactionId = transactionId;
		this.date = date;
		this.amount = amount;
		this.accountID = accountID;
		this.accountIDType = accountIDType;
	}

	public int getOrigintType() {
		return origintType;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public long getDate() {
		return date;
	}

	public long getAmount() {
		return amount;
	}

	public long getAccountID() {
		return accountID;
	}

	public int getAccountIDType() {
		return accountIDType;
	}
	
	
}
