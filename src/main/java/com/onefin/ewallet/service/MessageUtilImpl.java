package com.onefin.ewallet.service;

import org.springframework.stereotype.Service;

import com.onefin.ewallet.model.NapasConnectorResponse;

@Service
public class MessageUtilImpl implements IMessageUtil {

	@Override
	public NapasConnectorResponse buildNapasConnectorResponse(String code, Object napasBase, String token) {
		NapasConnectorResponse response = new NapasConnectorResponse();
		response.setConnectorCode(code);
		response.setNapasResponse(napasBase);
		response.setToken(token);
		return response;
	}

}
