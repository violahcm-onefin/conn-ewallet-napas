package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class PayResultTransaction {

	private PayResultTransAcquirer acquirer;

	private String amount;

	private String authorizationCode;

	private String currency;

	private String id;

	private String receipt;

	private String type;

}
