package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class PayResultAuthRes {

	private String cardSecurityCodeError;
	
	private String date;
	
	private String financialNetworkDate;
	
	private String processingCode;
	
	private String responseCode;
	
	private String returnAci;
	
	private String stan;
	
	private String time;
	
}
