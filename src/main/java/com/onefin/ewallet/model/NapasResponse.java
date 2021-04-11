package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class NapasResponse {

	private String acquirerCode;

	private String gatewayCode;

	private String message;

}
