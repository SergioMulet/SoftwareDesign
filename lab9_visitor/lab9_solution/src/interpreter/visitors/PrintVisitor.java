package interpreter.visitors;

import interpreter.Visitor;
import interpreter.ast.*;

public class PrintVisitor implements Visitor {
    @Override
    public Object visit(Program program, Object param) {
        for(Statement statement : program.statements){
            statement.accept(this, null);
        }
        return null;
    }

    @Override
    public Object visit(Print print, Object param) {
        System.out.println("print ");
        print.expression.accept(this, null);
        System.out.println(";");
        return null;
    }

    @Override
    public Object visit(Read read, Object param) {
        System.out.println("read ");
        read.variable.accept(this, null);
        System.out.println(";");
        return null;
    }

    @Override
    public Object visit(Sum sum, Object param) {
        sum.left.accept(this, null);
        System.out.println(" + ");
        sum.left.accept(this, null);
        return null;
    }

    @Override
    public Object visit(Assignment assignment, Object param) {
        assignment.variable.accept(this, null);
        System.out.println(" = ");
        assignment.expression.accept(this, null);
        System.out.println(";");
        return null;
    }

    @Override
    public Object visit(Division division, Object param) {
        division.left.accept(this, null);
        System.out.println(" / ");
        division.left.accept(this, null);
        return null;
    }

    @Override
    public Object visit(IntegerLiteral integerLiteral, Object param) {
        System.out.println(integerLiteral.value);
        return null;
    }

    @Override
    public Object visit(Product product, Object param) {
        product.left.accept(this, null);
        System.out.println(" * ");
        product.left.accept(this, null);
        return null;
    }

    @Override
    public Object visit(Variable variable, Object param) {
        System.out.println(variable.name);
        return null;
    }
}
