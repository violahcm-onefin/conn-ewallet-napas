package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class NapasTransaction {

	private NapasTransactionAquirer acquirer;

	private String amount;

	private String currency;

	private String id;

	private String type;

	private String typeOfVerification;

}
