package labs.lab9_visitor.original.interpreter.ast;

public class Assignment implements Statement {
	
	public Variable variable;
	public Expression expression;

	public Assignment(Variable variable, Expression expression) {
		this.variable = variable;
		this.expression = expression;
	}
}
