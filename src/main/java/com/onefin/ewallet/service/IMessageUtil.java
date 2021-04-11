package com.onefin.ewallet.service;

import com.onefin.ewallet.model.NapasConnectorResponse;

public interface IMessageUtil {

	NapasConnectorResponse buildNapasConnectorResponse(String code, Object napasBase, String token);

}
