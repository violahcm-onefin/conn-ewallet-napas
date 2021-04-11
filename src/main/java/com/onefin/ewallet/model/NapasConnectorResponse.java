package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class NapasConnectorResponse {

	private String connectorCode;
	
	private Object napasResponse;
	
	private String token;

}
