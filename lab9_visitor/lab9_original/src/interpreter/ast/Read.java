package interpreter.ast;

public class Read implements Statement {
	
	public Variable variable;

	public Read(Variable variable) {
		this.variable = variable;
	}
}
