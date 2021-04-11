package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class IPNDecodeResult {
	
	private TokenResult tokenResult;
	
	private PaymentResult paymentResult;

}
