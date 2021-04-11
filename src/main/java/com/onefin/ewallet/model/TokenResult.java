package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class TokenResult {

	private String result;
	
	private TokenResultResponse response;
	
	private String token;
	
	private TokenResultCard card;
	
	private String deviceId;
	
}
