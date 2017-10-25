package au.com.xp.calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import au.com.xp.calculator.exception.InValidOperationException;
import au.com.xp.calculator.exception.InvalidOperandException;
import au.com.xp.calculator.exception.NotImplementedException;
import au.com.xp.calculator.operation.base.Operation;
import au.com.xp.calculator.type.OperationType;

public class Calculator {

	public BigDecimal execute(List<String> params)
			throws InValidOperationException, NotImplementedException, InvalidOperandException {
		try {
			OperationType operationType = getOperationType(params);
			Operation operation = operationType.getOperation();

			List<BigDecimal> operands = new ArrayList();
			BigDecimal operand1 = BigDecimal.valueOf(Double.parseDouble(params.get(0)));
			
			operands.add(BigDecimal.valueOf(Double.parseDouble(params.get(0))));
			
			if(operationType.getNumberOfOperands() == params.size()-1) {
				for(int i = 2 ; i <= operationType.getNumberOfOperands() ; i++) {
					operands.add(BigDecimal.valueOf(Double.parseDouble(params.get(i))));
				}
			} else {
				throw new InvalidOperandException(
						String.format("Not enough number of Operands for the operation %s : Required %s - Actual %s",
								operationType, operationType.getNumberOfOperands(), params.size()-1));
			}
			
			return execute(operation, operands);
		} catch (NumberFormatException e) {
			throw new InvalidOperandException("Invalid Operand ", e);
		}
	}

	public BigDecimal execute(Operation operation, List<BigDecimal> operands)
			throws NotImplementedException, InvalidOperandException {
		return operation.execute(operands);
	}

	private OperationType getOperationType(List<String> params) throws InValidOperationException {
		if (params.size() < 2) {
			throw new InValidOperationException("Operation not Specified");
		}
		return OperationType.getOperationType(params.get(1).toUpperCase());
	}

}
