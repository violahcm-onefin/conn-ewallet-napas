package com.onefin.ewallet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onefin.ewallet.service.IHTTPRequestUtil;
import com.onefin.ewallet.service.IMessageUtil;
import com.onefin.ewallet.service.INapasService;
import com.onefin.ewallet.service.IOauth2Service;

@Controller
@Configuration
@RequestMapping("/napas/ewallet")
public class UnlinkController {

	@Autowired
	public IOauth2Service iOauth2Service;

	@Autowired
	private IMessageUtil msgUtil;

	@Autowired
	private IHTTPRequestUtil IhTTPRequestUtil;

	@Autowired
	private INapasService iNapasService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UnlinkController.class);

}
