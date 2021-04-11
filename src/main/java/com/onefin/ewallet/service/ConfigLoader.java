package com.onefin.ewallet.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class ConfigLoader {

	@Value("${napas.oauth2.url}")
	private String oauth2Url;

	@Value("${napas.oauth2.grant_type}")
	private String grantType;

	@Value("${napas.oauth2.client_id}")
	private String clientId;

	@Value("${napas.oauth2.client_secret}")
	private String clientSecret;

	@Value("${napas.oauth2.username}")
	private String username;

	@Value("${napas.oauth2.password}")
	private String password;

	@Value("${napas.url.linkCard}")
	private String linkCard;
	
	@Value("${napas.oauth2.userAgent}")
	private String userAgent;

}
