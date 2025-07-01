package interpreter.ast;

public class Variable implements Expression {
	
	public String name;

	public Variable(String name) {
		this.name = name;
	}
}
