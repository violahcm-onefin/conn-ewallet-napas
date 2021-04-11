package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class LinkCardResponse {

	private String apiOperation;

	private String merchantId;

	private NapasOrder order;

	private NapasResponse response;

	private String result;

	private NapasSOF sourceOfFunds;

	private NapasTransaction transaction;

	private String channel;

	private String version;

	private String dataKey;

	private String napasKey;

	private ResultError tokenResult;

	private ResultError paymentResult;
	
	private NapasErrorRes error;

}
