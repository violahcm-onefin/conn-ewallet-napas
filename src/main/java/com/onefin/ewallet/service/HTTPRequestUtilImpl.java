package com.onefin.ewallet.service;

import java.text.MessageFormat;

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
import com.onefin.ewallet.controller.LinkController;
import com.onefin.ewallet.model.LinkCardResponse;
import com.onefin.ewallet.model.NapasOauth2;

@Service
public class HTTPRequestUtilImpl implements IHTTPRequestUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinkController.class);

	@Autowired
	private ConfigLoader configLoader;

	/**
	 * Send request to Napas
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object send2NapasLinkCard(Object obj, NapasOauth2 token, String orderId, String transactionId)
			throws Exception {
		HttpHeaders headers = new HttpHeaders();
		// headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer " + token.getAccess_token());
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity entity = new HttpEntity(obj, headers);
		ResponseEntity<String> resp = null;
		String url = MessageFormat.format(configLoader.getLinkCard(), configLoader.getClientId(), orderId,
				transactionId);
		try {
			resp = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
		} catch (Exception e) {
			LOGGER.error("== REST API {}, request {}, response {} error from Napas!!! - {}", url, obj, resp.getBody(),
					e.toString());
			return null;
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			LOGGER.info("== Response - " + resp.getBody());
			LinkCardResponse result = mapper.readValue(resp.getBody(), LinkCardResponse.class);
			return result;
		} catch (Exception e) {
			LOGGER.error("== Can't parse API {}, request {}, response {} from Napas!!! - {}", url, obj, resp.getBody(),
					e.toString());
			return null;
		}
	}

}
