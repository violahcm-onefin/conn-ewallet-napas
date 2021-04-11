package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class LinkCard {
	
	private String apiOperation;
	
	private Order order;
	
	private SourceOfFunds sourceOfFunds;
	
	//private Submerchant submerchant;
	
	private String channel;
	
	private InputParameter inputParameters;

}
