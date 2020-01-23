/**
 * 
 */
package com.excelsiorsoft.jacksonmapping.dto.test2;

import org.junit.jupiter.api.Test;

import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import de.danielbechler.diff.node.Visit;

/**
 * @author Simeon
 *
 */
public class ObjectDiffTest {

	public static void main(String args) throws Exception {
		
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
		
		
		DiffNode root = ObjectDifferBuilder.buildDefault().compare(deal2, deal1);
		root.visit(new DiffNode.Visitor()
		{
		    public void node(DiffNode node, Visit visit)
		    {
		        final Object baseValue = node.canonicalGet(deal1);
		        final Object workingValue = node.canonicalGet(deal2);
		        final String message = node.getPath() + " changed from " + 
		                               baseValue + " to " + workingValue;
		        System.out.println(message);
		    }
		});
	}
}
