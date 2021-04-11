package com.onefin.ewallet.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onefin.ewallet.model.NapasOauth2;

@Service
public class Oauth2ServiceImpl implements IOauth2Service {

	private static final Logger LOGGER = LoggerFactory.getLogger(Oauth2ServiceImpl.class);

	@Autowired
	private ConfigLoader configLoader;

	@Override
	public NapasOauth2 napasToken() {
		String url = configLoader.getOauth2Url() + "grant_type=" + configLoader.getGrantType() + "&client_id="
				+ configLoader.getClientId() + "&client_secret=" + configLoader.getClientSecret() + "&username="
				+ configLoader.getUsername() + "&password=" + configLoader.getPassword();
		LOGGER.info("== URL - " + url);
		Map<String, String> obj = new HashMap<>();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("User-Agent", configLoader.getUserAgent());
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity entity = new HttpEntity(obj, headers);
		ResponseEntity<String> resp = null;
		try {
			resp = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		} catch (Exception e) {
			LOGGER.error("== Error response from Oauth2 Napas!!! - {}", e.toString());
			return null;
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			LOGGER.info("== Response - " + resp.getBody());
			NapasOauth2 result = mapper.readValue(resp.getBody(), NapasOauth2.class);
			return result;
		} catch (Exception e) {
			LOGGER.error("== Can't parse result from Oauth2 Napas!!! - {}", e.toString());
			return null;
		}
	}

}
