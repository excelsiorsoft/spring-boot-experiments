/**
 * 
 */
package com.excelsiorsoft.jacksonmapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.excelsiorsoft.jacksonmapping.dto.test1.Item;
import com.excelsiorsoft.jacksonmapping.dto.test2.Deal;
import com.excelsiorsoft.jacksonmapping.dto.test2.PaymentInstruction;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Simeon
 *
 */
@RestController
@RequestMapping ("/mappings") @Slf4j
public class TestController {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@PostMapping (value = "/test1")
    public ResponseEntity<StreamingResponseBody> test1(@RequestBody Item payload) {
		log.info("{}",payload);
		return null;}

	@GetMapping (value = "/serialize")
    public ResponseEntity<StreamingResponseBody> serializePmtInstr() throws Exception {
		
		PaymentInstruction pi = new PaymentInstruction();
		Deal deal = Deal.builder()
				.acsKey("acsKey")
				.acsDealId("acsDealId")
				.dealShortName("dealShortName")
				.legalEntityId("legalEntityId")
				.clientId("clientId")
				.clientName("clientName")
				.build();
		pi.setDealAttributes(deal);
		log.info(objectMapper.writeValueAsString(pi));
			
		
		return null;}
	

	
	
}
