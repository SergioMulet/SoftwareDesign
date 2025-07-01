package interpreter.ast;

import labs.lab9_visitor.original.interpreter.ast.Expression;
import labs.lab9_visitor.original.interpreter.ast.Statement;
import labs.lab9_visitor.original.interpreter.ast.Variable;

public class Assignment implements Statement {
	
	public Variable variable;
	public Expression expression;

	public Assignment(Variable variable, Expression expression) {
		this.variable = variable;
		this.expression = expression;
	}
}
