package labs.lab9_visitor.original.interpreter.ast;

public class Product implements Expression {
	
	public Expression left, right;

	public Product(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
}
