package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class PayResultOrder {

	private String amount;
	
	private String creationTime;
	
	private String currency;
	
	private String id;
	
	private String reference;
	
	private String totalAuthorizedAmount;
	
	private String totalCapturedAmount;
	
	private String totalRefundedAmount;
	
}
