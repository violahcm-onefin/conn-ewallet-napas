package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class TokenResultCard {

	private String brand;

	private CardExpiry expiry;

	private String issuer;

	private String number;

	private String scheme;

	private String status3ds;

}
