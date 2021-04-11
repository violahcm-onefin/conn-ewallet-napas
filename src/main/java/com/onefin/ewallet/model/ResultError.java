package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class ResultError {
	
	private String result;
	
	private NapasErrorRes error;

}
