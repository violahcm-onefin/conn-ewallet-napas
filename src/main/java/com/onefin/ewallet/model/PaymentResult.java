package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class PaymentResult {

	private PayResultOrder order;
	
	private String result;
	
	private String apiOperation;
	
	private PayResultAuthRes authorizationResponse;
	
	private String merchantId;
	
	private PayResultRes response;
	
	private PayResultSourceOfFunds sourceOfFunds;
	
	private String timeOfRecord;
	
	private PayResultTransaction transaction;
	
	private String channel;
	
	private String version;
	
}
