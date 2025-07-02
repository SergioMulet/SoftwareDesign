package interpreter.visitors;

import interpreter.Visitor;
import interpreter.ast.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class InterpreteVisitor implements Visitor {

    private Map<String, Integer> memory = new HashMap<>();
    private BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public Object visit(Program program, Object param) {
        for(Statement statement : program.statements){
            statement.accept(this, null);
        }
        return null;
    }

    @Override
    public Object visit(Print print, Object param) {
        System.out.println(print.expression.accept(this, null));
        return null;
    }

    @Override
    public Object visit(Read read, Object param) {
        int value;
        System.out.print("Enter value for the variable " + read.variable.name + ": ");
        try{
            value = Integer.parseInt(console.readLine());
        } catch(Exception e){
            value = 0;
        }
        memory.put(read.variable.name, value);
        return null;
    }

    @Override
    public Object visit(Sum sum, Object param) {
        return (Integer) sum.left.accept(this, null) +
                (Integer) sum.right.accept(this, null);
    }

    @Override
    public Object visit(Assignment assignment, Object param) {
        int value = (Integer) assignment.expression.accept(this, null);
        memory.put(assignment.variable.name, value);
        return null;
    }

    @Override
    public Object visit(Division division, Object param) {
        return (Integer) division.left.accept(this, null) /
                (Integer) division.right.accept(this, null);
    }

    @Override
    public Object visit(IntegerLiteral integerLiteral, Object param) {
        return Integer.parseInt(integerLiteral.value);
    }

    @Override
    public Object visit(Product product, Object param) {
        return (Integer) product.left.accept(this, null) *
                (Integer) product.right.accept(this, null);
    }

    @Override
    public Object visit(Variable variable, Object param) {
        Integer value = memory.get(variable.name);
        if(value == null){
            value = 0;
        }
        return value;
    }
}
