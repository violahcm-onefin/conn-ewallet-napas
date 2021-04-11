package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class NapasErrorRes {
	
	private String cause;
	
	private String explanation;
	
	private String supportCode;
	
	private String validationType;

}
