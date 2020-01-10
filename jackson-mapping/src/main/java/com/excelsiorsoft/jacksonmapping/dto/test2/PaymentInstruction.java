/**
 * 
 */
package com.excelsiorsoft.jacksonmapping.dto.test2;

import lombok.Data;

/**
 * @author Simeon
 *
 */
@Data
public class PaymentInstruction {
	
	private String id;
	private String sourceAccountNumber;
	private String sourceAccountBranch;
	private Deal dealAttributes;

}
