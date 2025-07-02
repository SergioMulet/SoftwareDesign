package interpreter;

import interpreter.ast.*;

public interface Visitor {

    Object visit(Program program, Object param);
    Object visit(Print print, Object param);
    Object visit(Read read, Object param);
    Object visit(Sum sum, Object param);
    Object visit(Assignment assignment, Object param);
    Object visit(Division division, Object param);
    Object visit(IntegerLiteral integerLiteral, Object param);
    Object visit(Product product, Object param);
    Object visit(Variable variable, Object param);
}
