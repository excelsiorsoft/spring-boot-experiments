package com.excelsiorsoft.jacksonmapping.dto.test2;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Deal {
	
	private String acsKey;
	private String acsDealId;
	private String dealShortName;
	private String legalEntityId;
	private String clientId;
	private String clientName;

}
