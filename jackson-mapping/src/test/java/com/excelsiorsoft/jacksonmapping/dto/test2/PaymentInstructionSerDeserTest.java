/**
 * 
 */
package com.excelsiorsoft.jacksonmapping.dto.test2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Simeon
 *
 */

@Slf4j
public class PaymentInstructionSerDeserTest {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void deserialization() throws Exception {
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
			log.debug(objectMapper.writeValueAsString(pi));
	}

}
