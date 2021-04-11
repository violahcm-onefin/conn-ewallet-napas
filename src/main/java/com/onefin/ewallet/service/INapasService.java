package com.onefin.ewallet.service;

import org.springframework.http.ResponseEntity;

import com.onefin.service.IBaseService;

public interface INapasService extends IBaseService {

	/**
	 * Validate response from Napas
	 * 
	 * @param responseObj
	 * @param language
	 * @return
	 */
	ResponseEntity<?> validateResponse(Object baseMessage, String token);
	
	

}
