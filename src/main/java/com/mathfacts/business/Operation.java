package com.mathfacts.business;

public class Operation {
	private String operationString = "";
	private String operationSymbol = "";
	
	public Operation(String operationString, String operationSymbol) {
		super();
		this.operationString = operationString;
		this.operationSymbol = operationSymbol;
	}

	public String getOperationString() {
		return operationString;
	}

	public void setOperationString(String operationString) {
		this.operationString = operationString;
	}

	public String getOperationSymbol() {
		return operationSymbol;
	}

	public void setOperationSymbol(String operationSymbol) {
		this.operationSymbol = operationSymbol;
	}

	@Override
	public String toString() {
		return "Operation [operationString=" + operationString + ", operationSymbol=" + operationSymbol + "]";
	}
	
}
