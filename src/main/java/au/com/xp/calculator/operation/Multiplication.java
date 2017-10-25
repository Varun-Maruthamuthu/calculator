package au.com.xp.calculator.operation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import au.com.xp.calculator.operation.base.Operation;

public class Multiplication implements Operation{

	public BigDecimal execute(List<BigDecimal> operands) {
		return (operands.get(0).setScale(2, RoundingMode.HALF_UP)
				.multiply(operands.get(1).setScale(2, RoundingMode.HALF_UP)))
				.setScale(2, RoundingMode.HALF_UP);
	}

}
