package com.onefin.ewallet.model;

import lombok.Data;

@Data
public class PayResultSOFProvidedCard {
	
	private String brand;
	
	private PayResultSOFProvidedCardExpiry expiry;
	
	private String issuer;
	
	private String number;
	
	private String scheme;

}
