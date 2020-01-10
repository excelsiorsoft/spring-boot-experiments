/**
 * 
 */
package com.excelsiorsoft.jacksonmapping.dto.test2;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.junit4.SpringRunner;

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
		Deal deal = new Deal();
		pi.setDealAttributes(deal);
			log.debug(objectMapper.writeValueAsString(pi));
	}

}
