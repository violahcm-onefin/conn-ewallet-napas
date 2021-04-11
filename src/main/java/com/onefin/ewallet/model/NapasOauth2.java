package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class NapasOauth2 {
	
	private String access_token;
	
	private String token_type;
	
	private String refresh_token;
	
	private String expires_in;
	
	private String scope;

}
