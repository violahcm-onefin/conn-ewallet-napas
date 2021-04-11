package com.onefin.ewallet.service;

import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onefin.ewallet.common.OneFinConstants;
import com.onefin.service.BaseService;

@Service
public class NapasServiceImpl extends BaseService implements INapasService {

	private static final Logger LOGGER = LoggerFactory.getLogger(NapasServiceImpl.class);

	@Autowired
	private IMessageUtil iMessageUtil;

	@Autowired
	private ConfigLoader configLoader;

	/**
	 * Validate response from Napas
	 * 
	 * @param responseObj
	 * @param language
	 * @return
	 */
	@Override
	public ResponseEntity<?> validateResponse(Object data, String token) {
		// Check response
		if (data == null) {
			LOGGER.error("== NULL response from Napas!!!");
			return new ResponseEntity<>(
					iMessageUtil.buildNapasConnectorResponse(OneFinConstants.NAPAS_ERROR_RESPONSE, data, token),
					HttpStatus.OK);
		}

		try {
			Map<String, Object> mapData = super.convertObject2Map(data);
			String merchantId = Objects.toString(mapData.get(OneFinConstants.NAPAS_MERCHANTID), "");
			String result = Objects.toString(mapData.get(OneFinConstants.NAPAS_RESULT), "");
			Map<String, Object> tokenResultError = (Map<String, Object>) mapData
					.get(OneFinConstants.NAPAS_TOKENRESULT_ERROR);
			Map<String, Object> paymentResultError = (Map<String, Object>) mapData
					.get(OneFinConstants.NAPAS_PAYMENTRESULT_ERROR);

			if (tokenResultError != null || paymentResultError != null || result.equals(OneFinConstants.ERROR)) {
				LOGGER.error("== Validation fail from Napas!");
				return new ResponseEntity<>(iMessageUtil.buildNapasConnectorResponse(
						OneFinConstants.NAPAS_VALIDATION_FAIL_FROM_NAPAS, data, token), HttpStatus.OK);
			}

			if (!isValidMessage(merchantId)) {
				LOGGER.error("== Invalid response from Napas!");
				return new ResponseEntity<>(
						iMessageUtil.buildNapasConnectorResponse(OneFinConstants.NAPAS_INVALID_RESPONSE, data, token),
						HttpStatus.OK);
			}

			if (!configLoader.getClientId()
					.equals(Objects.toString(mapData.get(OneFinConstants.NAPAS_MERCHANTID), ""))) {
				LOGGER.error("== MerchantId not support: {}", merchantId);
				return new ResponseEntity<>(iMessageUtil.buildNapasConnectorResponse(
						OneFinConstants.NAPAS_INVALID_MERCHANT_ID, data, token), HttpStatus.OK);
			}

			LOGGER.info("== Validation success!");
			return new ResponseEntity<>(
					iMessageUtil.buildNapasConnectorResponse(OneFinConstants.NAPAS_CONNECTOR_SUCCESS, data, token),
					HttpStatus.OK);

		} catch (Exception e) {
			LOGGER.error("== Validate response from Napas error!!! - {}", e.toString());
			return new ResponseEntity<>(iMessageUtil.buildNapasConnectorResponse(
					OneFinConstants.NAPAS_VALIDATION_FUNCTION_FAIL, data, token), HttpStatus.OK);

		}
	}

	private boolean isValidMessage(String merchantId) {
		if (merchantId == null || merchantId.trim().isEmpty()) {

			return false;
		}
		return true;
	}

}
