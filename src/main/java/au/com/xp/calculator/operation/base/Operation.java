package au.com.xp.calculator.operation.base;

import java.math.BigDecimal;
import java.util.List;

import au.com.xp.calculator.exception.InvalidOperandException;
import au.com.xp.calculator.exception.NotImplementedException;

public interface Operation {
	
	public BigDecimal execute(List<BigDecimal> operands) throws NotImplementedException, InvalidOperandException;
	
}
