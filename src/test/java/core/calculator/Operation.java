package core.calculator;

public class Operation {
	
	private Integer numberOne;
	private String operation;
	private Integer numberTwo;
	
	public Operation() {
		// TODO Auto-generated constructor stub
	}
	
	public Operation(Integer numberOne, String operation, Integer numberTwo) {
		super();
		this.numberOne = numberOne;
		this.operation = operation;
		this.numberTwo = numberTwo;
	}

	public Integer getNumberOne() {
		return numberOne;
	}
	public void setNumberOne(Integer numberOne) {
		this.numberOne = numberOne;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Integer getNumberTwo() {
		return numberTwo;
	}
	public void setNumberTwo(Integer numberTwo) {
		this.numberTwo = numberTwo;
	}
	
	public String toString(){
		return numberOne + " " + operation + " " + numberTwo;
	}
}
