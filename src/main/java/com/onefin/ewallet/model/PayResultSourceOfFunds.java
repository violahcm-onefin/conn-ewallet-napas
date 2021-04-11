package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class PayResultSourceOfFunds {

	private PayResultSOFProvided provided;
	
	private String type;
	
}
