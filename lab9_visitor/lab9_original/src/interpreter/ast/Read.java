package interpreter.ast;

import labs.lab9_visitor.original.interpreter.ast.Variable;

public class Read implements Statement {
	
	public Variable variable;

	public Read(Variable variable) {
		this.variable = variable;
	}
}
