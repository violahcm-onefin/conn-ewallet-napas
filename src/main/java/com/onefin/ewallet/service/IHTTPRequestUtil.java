package com.onefin.ewallet.service;

import com.onefin.ewallet.model.NapasOauth2;

public interface IHTTPRequestUtil {

	/**
	 * Send request to Napas
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	Object send2NapasLinkCard(Object obj, NapasOauth2 token, String orderId, String transactionId) throws Exception;

	

}
