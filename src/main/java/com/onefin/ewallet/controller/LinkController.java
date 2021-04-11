package com.onefin.ewallet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onefin.ewallet.common.OneFinConstants;
import com.onefin.ewallet.model.LinkCard;
import com.onefin.ewallet.model.LinkCardResponse;
import com.onefin.ewallet.model.NapasOauth2;
import com.onefin.ewallet.service.IHTTPRequestUtil;
import com.onefin.ewallet.service.IMessageUtil;
import com.onefin.ewallet.service.INapasService;
import com.onefin.ewallet.service.IOauth2Service;

@Controller
@Configuration
@RequestMapping("/napas/ewallet")
public class LinkController {

	@Autowired
	public IOauth2Service iOauth2Service;

	@Autowired
	private IMessageUtil msgUtil;

	@Autowired
	private IHTTPRequestUtil IhTTPRequestUtil;

	@Autowired
	private INapasService iNapasService;

	private static final Logger LOGGER = LoggerFactory.getLogger(LinkController.class);

	/**
	 * Link card
	 * 
	 * @param orderId
	 * @param transactionId
	 * @param requestBody
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/order/{orderId}/transaction/{transactionId}")
	public @ResponseBody ResponseEntity<?> linkCard(@PathVariable(required = true) String orderId,
			@PathVariable(required = true) String transactionId,
			@Valid @RequestBody(required = true) LinkCard requestBody, HttpServletRequest request) throws Exception {
		String errorMsg = "";
		LOGGER.info("== OrderId {}, TransactionId {}  - Send Link Card Request", orderId, transactionId);
		try {

			NapasOauth2 token = iOauth2Service.napasToken();

			if (token == null) {
				return new ResponseEntity<>(
						msgUtil.buildNapasConnectorResponse(OneFinConstants.NAPAS_GET_TOKEN_FAIL, null, null),
						HttpStatus.OK);
			}

			LinkCardResponse response = (LinkCardResponse) IhTTPRequestUtil.send2NapasLinkCard(requestBody, token,
					orderId, transactionId);

			// Validate response from Napas
			ResponseEntity<?> responseEntity = iNapasService.validateResponse(response, token.getAccess_token());
			return responseEntity;
		} catch (Exception e) {
			LOGGER.error("== OrderId {}, TransactionId {}  - Fail to process Link Card function - {}", orderId,
					transactionId, e.toString());
			return new ResponseEntity<>(
					msgUtil.buildNapasConnectorResponse(OneFinConstants.INTERNAL_SERVER_ERROR, null, null),
					HttpStatus.OK);
		}

	}

}
