package au.com.xp.calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import au.com.xp.calculator.exception.InValidOperationException;
import au.com.xp.calculator.exception.InvalidOperandException;
import au.com.xp.calculator.exception.NotImplementedException;
import au.com.xp.calculator.type.OperationType;
import junit.framework.Assert;

public class CalculatorTest {
	private Calculator calculator;
	
	@Before
	public void init() {
		calculator = new Calculator();
	}
	
	@Test
	public void shouldReturnresultforValidInputs() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<BigDecimal>  operands = new ArrayList() ;
		operands.add(BigDecimal.ONE);
		operands.add(BigDecimal.ONE);
		
		String operator = "+";
		Assert.assertNotNull(calculator
				.execute(OperationType.getOperationType(operator).getOperation(),operands));
	}
	
	@Test
	public void shouldExecuteOpearationforValidInputs() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<String> params = new ArrayList<>();
		params.add("2");
		params.add("*");
		params.add("2");
		Assert.assertNotNull(calculator.execute(params));
	}

	@Test(expected = InvalidOperandException.class)
	public void Error() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<String> params = new ArrayList<>();
		params.add("Q");
		params.add("*");
		params.add("E");
		Assert.assertNotNull(calculator.execute(params));
	}
	
	@Test(expected = InValidOperationException.class)
	public void shouldThrowExceptionForValidOperation() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<String> params = new ArrayList<>();
		params.add("2");
		params.add("Q");
		params.add("2");
		Assert.assertNotNull(calculator.execute(params));
	}
	
	@Test(expected = InValidOperationException.class)
	public void shouldThrowErrorIfOperandNotSpecified() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<String> params = new ArrayList<>();
		params.add("2");
		
		Assert.assertNotNull(calculator.execute(params));
	}
	
	@Test(expected = InvalidOperandException.class)
	public void shouldReturnErrorforInValidNumberOfOperands() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<String> params = new ArrayList<>();
		params.add("2");
		params.add("+");
		Assert.assertNotNull(calculator.execute(params));
	}
	
	@Test
	public void shouldAddOperandforValidInputs() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<BigDecimal>  operands = new ArrayList() ;
		operands.add(BigDecimal.ONE);
		operands.add(BigDecimal.ONE);
		
		String operator = "+";
		Assert.assertEquals(BigDecimal.valueOf(2), calculator
				.execute(OperationType.getOperationType(operator).getOperation(),operands));
	}
	
	@Test
	public void shouldSubtractOperandforValidInputs() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<BigDecimal>  operands = new ArrayList() ;
		operands.add(BigDecimal.ONE);
		operands.add(BigDecimal.ONE);
		
		String operator = "-";
		Assert.assertEquals(BigDecimal.valueOf(0), calculator
				.execute(OperationType.getOperationType(operator).getOperation(),operands));
	}
	
	@Test
	public void shouldMultiplyOperandforValidInputs() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<BigDecimal>  operands = new ArrayList() ;
		operands.add(BigDecimal.ONE);
		operands.add(BigDecimal.ONE);
		
		String operator = "*";
		Assert.assertEquals(BigDecimal.valueOf(1).setScale(2), calculator
				.execute(OperationType.getOperationType(operator).getOperation(),operands));
	}
	
	@Test
	public void shouldDivideOperandforValidInputs() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<BigDecimal>  operands = new ArrayList() ;
		operands.add(BigDecimal.TEN);
		operands.add(BigDecimal.ONE);
		
		String operator = "/";
		Assert.assertEquals(BigDecimal.valueOf(10).setScale(2), calculator
				.execute(OperationType.getOperationType(operator).getOperation(),operands));
	}
	
	@Test(expected = InvalidOperandException.class)
	public void shouldReturnErrorforInValidOperands() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<BigDecimal>  operands = new ArrayList() ;
		operands.add(BigDecimal.TEN);
		operands.add(BigDecimal.ZERO);
		
		String operator = "/";
		calculator.execute(OperationType.getOperationType(operator).getOperation(),operands);
	}
	
	@Test(expected = InValidOperationException.class)
	public void shouldReturnErrorforInValidOperations() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<BigDecimal>  operands = new ArrayList() ;
		operands.add(BigDecimal.TEN);
		operands.add(BigDecimal.ONE);
		
		String operator = "&";
		calculator.execute(OperationType.getOperationType(operator).getOperation(),operands);
	}
	
	@Test(expected = NotImplementedException.class)
	public void shouldReturnErrorforCosineOperations() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<BigDecimal>  operands = new ArrayList() ;
		operands.add(BigDecimal.TEN);
		operands.add(BigDecimal.ONE);
		
		String operator = "COS";
		calculator.execute(OperationType.getOperationType(operator).getOperation(),operands);
	}
	
	@Test(expected = NotImplementedException.class)
	public void shouldReturnErrorforSineOperations() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<BigDecimal>  operands = new ArrayList() ;
		operands.add(BigDecimal.TEN);
		operands.add(BigDecimal.ONE);
		
		String operator = "SIN";
		calculator.execute(OperationType.getOperationType(operator).getOperation(),operands);
	}
	
	@Test(expected = NotImplementedException.class)
	public void shouldReturnErrorforPowerOperations() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<BigDecimal>  operands = new ArrayList() ;
		operands.add(BigDecimal.TEN);
		operands.add(BigDecimal.ONE);
		
		String operator = "POW";
		calculator.execute(OperationType.getOperationType(operator).getOperation(),operands);
	}
	
	@Test(expected = NotImplementedException.class)
	public void shouldReturnErrorforSquareRootOperations() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<BigDecimal>  operands = new ArrayList() ;
		operands.add(BigDecimal.TEN);
		operands.add(BigDecimal.ONE);
		
		String operator = "SQRT";
		calculator.execute(OperationType.getOperationType(operator).getOperation(),operands);
	}
	
	@Test(expected = NotImplementedException.class)
	public void shouldReturnErrorforTangentOperations() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<BigDecimal>  operands = new ArrayList() ;
		operands.add(BigDecimal.TEN);
		operands.add(BigDecimal.ONE);
		
		String operator = "TAN";
		calculator.execute(OperationType.getOperationType(operator).getOperation(),operands);
	}
	
	@Test(expected = NotImplementedException.class)
	public void shouldReturnErrorforLogOperations() throws NotImplementedException, InvalidOperandException, InValidOperationException {
		List<BigDecimal>  operands = new ArrayList() ;
		operands.add(BigDecimal.TEN);
		operands.add(BigDecimal.ONE);
		
		String operator = "LOG";
		calculator.execute(OperationType.getOperationType(operator).getOperation(),operands);
	}
}
