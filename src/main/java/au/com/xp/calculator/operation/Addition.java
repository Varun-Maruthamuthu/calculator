package au.com.xp.calculator.operation;

import java.math.BigDecimal;
import java.util.List;

import au.com.xp.calculator.operation.base.Operation;

public class Addition implements Operation{

	public BigDecimal execute(List<BigDecimal> operands) {
		return operands.get(0).add(operands.get(1));
	}
}
