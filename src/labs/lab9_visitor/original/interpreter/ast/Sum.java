package labs.lab9_visitor.original.interpreter.ast;

public class Sum implements Expression {

	public Expression left, right;

	public Sum(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
}
