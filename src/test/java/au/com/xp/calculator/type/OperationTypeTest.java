package au.com.xp.calculator.type;

import org.junit.Assert;
import org.junit.Test;

import au.com.xp.calculator.exception.InValidOperationException;
import au.com.xp.calculator.operation.base.Operation;

public class OperationTypeTest {

	@Test
	public void shouldReturnOperationTypeforValidInput() throws InValidOperationException {
		Assert.assertNotNull(OperationType.getOperationType("+"));
		Assert.assertNotNull(OperationType.getOperationType("-"));
		Assert.assertNotNull(OperationType.getOperationType("*"));
		Assert.assertNotNull(OperationType.getOperationType("/"));
		Assert.assertNotNull(OperationType.getOperationType("SQRT"));
		Assert.assertNotNull(OperationType.getOperationType("POW"));
		Assert.assertNotNull(OperationType.getOperationType("COS"));
		Assert.assertNotNull(OperationType.getOperationType("SIN"));
		Assert.assertNotNull(OperationType.getOperationType("TAN"));
		Assert.assertNotNull(OperationType.getOperationType("LOG"));
	}
	
	@Test
	public void shouldReturnOperationforValidInput() throws InValidOperationException {
		Assert.assertTrue(OperationType.getOperationType("+").getOperation() instanceof Operation);
		Assert.assertTrue(OperationType.getOperationType("-").getOperation() instanceof Operation);
		Assert.assertTrue(OperationType.getOperationType("*").getOperation() instanceof Operation);
		Assert.assertTrue(OperationType.getOperationType("/").getOperation() instanceof Operation);
		Assert.assertTrue(OperationType.getOperationType("SQRT").getOperation() instanceof Operation);
		Assert.assertTrue(OperationType.getOperationType("POW").getOperation() instanceof Operation);
		Assert.assertTrue(OperationType.getOperationType("COS").getOperation() instanceof Operation);
		Assert.assertTrue(OperationType.getOperationType("SIN").getOperation() instanceof Operation);
		Assert.assertTrue(OperationType.getOperationType("TAN").getOperation() instanceof Operation);
		Assert.assertTrue(OperationType.getOperationType("LOG").getOperation() instanceof Operation);
	}
	
	@Test(expected = InValidOperationException.class)
	public void shouldExpectExceptionforInValidInput() throws InValidOperationException {
		OperationType.getOperationType("&");
	}
	
}
