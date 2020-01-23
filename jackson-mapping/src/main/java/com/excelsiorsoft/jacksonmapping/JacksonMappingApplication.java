package com.excelsiorsoft.jacksonmapping;

import java.util.List;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.diff.changetype.PropertyChange;
import org.javers.core.diff.changetype.ValueChange;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.excelsiorsoft.jacksonmapping.dto.test2.Deal;

@SpringBootApplication
public class JacksonMappingApplication {

	public static void main(String[] args) {
		//SpringApplication.run(JacksonMappingApplication.class, args);
		
		Deal deal1 = Deal.builder()
				.acsKey("acsKey1")
				.acsDealId("acsDealId1")
				.dealShortName("dealShortName1")
				.legalEntityId("legalEntityId1")
				.clientId("clientId1")
				.clientName("clientName1")
				.build();
		
		Deal deal2 = Deal.builder()
				.acsKey("acsKey2")
				.acsDealId("acsDealId2")
				.dealShortName("dealShortName2")
				.legalEntityId("legalEntityId2")
				.clientId("clientId2")
				.clientName("clientName2")
				.build();
		
		/*
		DiffNode root = ObjectDifferBuilder.buildDefault().compare(deal2, deal1);
		root.visit(new DiffNode.Visitor()
		{
		    public void node(DiffNode node, Visit visit)
		    {
		        final Object baseValue = node.canonicalGet(deal1);
		        final Object workingValue = node.canonicalGet(deal2);
		        if (node.hasChanges() && !node.hasChildren()) {
		        final String message = node.getPath() + " changed from " + 
		                               baseValue + " to " + workingValue;
		        System.out.println(message);
		        }
		    }
		});
	*/
		Javers javers = JaversBuilder.javers().build();	
		Diff diff = javers.compare(deal1, deal2);
		System.out.println(diff);
		System.out.println(diff.getPropertyChanges("acsKey"));
		System.out.println(diff.getChanges());
		
		PropertyChange change = diff.getPropertyChanges("acsKey").get(0);
		System.out.println(change.isPropertyValueChanged());
		
		
		
	}

}
