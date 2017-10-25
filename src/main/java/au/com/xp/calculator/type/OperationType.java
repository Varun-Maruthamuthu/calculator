package au.com.xp.calculator.type;

import java.util.HashMap;
import java.util.Map;

import au.com.xp.calculator.exception.InValidOperationException;
import au.com.xp.calculator.operation.Addition;
import au.com.xp.calculator.operation.Cosine;
import au.com.xp.calculator.operation.Division;
import au.com.xp.calculator.operation.Log;
import au.com.xp.calculator.operation.Multiplication;
import au.com.xp.calculator.operation.Power;
import au.com.xp.calculator.operation.Sine;
import au.com.xp.calculator.operation.Squareroot;
import au.com.xp.calculator.operation.Subtraction;
import au.com.xp.calculator.operation.Tangent;
import au.com.xp.calculator.operation.base.Operation;

public enum OperationType {
	// TODO : Use a DI framework like Spring / CDI if needed.
	ADDITION("+", 2, new Addition()),
	SUBTRACTION("-", 2, new Subtraction()),
	MULTIPLICATION("*", 2, new Multiplication()),
	DIVISION("/", 2, new Division()),
	SQUAREROOT("SQRT", 1, new Squareroot()),
	POWER("POW", 1, new Power()),
	COS("COS", 1, new Cosine()),
	SIN("SIN", 1, new Sine()),
	TAN("TAN", 2, new Tangent()),
	LOG("LOG", 3, new Log());

	private String symbol;
	private int numberOfOperands;
	private Operation operation;

	// Reverse-lookup map for getting a day from an abbreviation
	private static final Map<String, OperationType> lookup = new HashMap<String, OperationType>();

	static {
		for (OperationType d : OperationType.values()) {
			lookup.put(d.getSymbol(), d);
		}
	}

	OperationType(String symbol, int numberOfOperands, Operation operation) {
		this.symbol = symbol;
		this.numberOfOperands = numberOfOperands;
		this.operation = operation;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getNumberOfOperands() {
		return numberOfOperands;
	}

	public static OperationType getOperationType(String abbreviation) throws InValidOperationException {
		OperationType operationType = lookup.get(abbreviation);
		if (operationType == null) {
			throw new InValidOperationException(String.format("Operation not valid %s", abbreviation));
		}
		return operationType;
	}

	public Operation getOperation() {
		return operation;
	}

	public static boolean contains(String abbreviation) {
		return lookup.containsValue(abbreviation);
	}
}
