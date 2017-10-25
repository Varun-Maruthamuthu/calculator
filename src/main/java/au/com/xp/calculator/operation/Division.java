package au.com.xp.calculator.operation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import au.com.xp.calculator.exception.InvalidOperandException;
import au.com.xp.calculator.operation.base.Operation;

public class Division implements Operation{

	public BigDecimal execute(List<BigDecimal> operands) throws InvalidOperandException {
		if(operands.get(1).intValue() == 0 )
			throw new InvalidOperandException("Error : Divide By Zero");
		return operands.get(0).divide(operands.get(1), 2, RoundingMode.HALF_UP);
	}

}
