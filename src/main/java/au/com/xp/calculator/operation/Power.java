package au.com.xp.calculator.operation;

import java.math.BigDecimal;
import java.util.List;

import au.com.xp.calculator.exception.NotImplementedException;
import au.com.xp.calculator.operation.base.Operation;

public class Power implements Operation{

	public BigDecimal execute(List<BigDecimal> operands) throws NotImplementedException {
		throw new NotImplementedException("Operation Power not Implemented");
	}

}
