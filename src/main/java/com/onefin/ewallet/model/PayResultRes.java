package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class PayResultRes {

	private String acquirerCode;
	
	private String acquirerMessage;
	
	private PayResultResCardSerCode cardSecurityCode;
	
	private String gatewayCode;
	
	private String message;
	
}
