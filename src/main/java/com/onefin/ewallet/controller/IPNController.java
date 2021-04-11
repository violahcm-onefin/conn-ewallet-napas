//package com.onefin.ewallet.controller;
//
//import java.util.Base64;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//
//import org.apache.commons.codec.digest.DigestUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.onefin.ewallet.common.HTTPRequestUtil;
//import com.onefin.ewallet.common.MessageUtil;
//import com.onefin.ewallet.model.IPNRaw;
//import com.onefin.ewallet.service.ConfigLoader;
//import com.onefin.ewallet.service.IOauth2Service;
//
//@Controller
//@Configuration
//@RequestMapping("/napas/ewallet")
//public class IPNController {
//
//	@Autowired
//	private MessageUtilImpl msgUtil;
//
//	@Autowired
//	private ConfigLoader configLoader;
//
//	@Autowired
//	private HTTPRequestUtil hTTPRequestUtil;
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(IPNController.class);
//
//	@RequestMapping(method = RequestMethod.POST, value = "/ipn")
//	public @ResponseBody ResponseEntity<?> IPN(@Valid @RequestBody(required = true) IPNRaw ipnData,
//			HttpServletRequest request) throws Exception {
//		String errorMsg = "";
//		LOGGER.info("== Receive IPN Response from Napas");
//		try {
//			// Validate checksum
//			String oneFinCheckSum = DigestUtils.sha256Hex(ipnData.getData() + configLoader.getClientSecret());
//			if (!oneFinCheckSum.equals(ipnData.getChecksum())) {
//				LOGGER.error("== Checksum fail from Napas");
//			}
//			// Base64 decode
//			byte[] decodeData = Base64.getDecoder().decode(ipnData.getData());
//
//			// Validate response from VTB
//			ResponseEntity<?> responseEntity = vietinUtils.validateResponse(baseMessage);
//			return responseEntity;
//		} catch (Exception e) {
//			e.printStackTrace();
//			errorMsg = "Fail to process TokenIssue function: " + e;
//			LOGGER.error("== RequestID {} - " + errorMsg, requestBody.getRequestId());
//			return new ResponseEntity<>(msgUtil.buildVietinInternalServerError(configLoader.getVietinVersion(), null),
//					HttpStatus.OK);
//		}
//
//	}
//
//}
