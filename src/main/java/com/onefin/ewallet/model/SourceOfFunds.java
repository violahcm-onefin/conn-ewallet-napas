package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class SourceOfFunds {

	private String type;
	
	private SOFProvided provided;
	
}
