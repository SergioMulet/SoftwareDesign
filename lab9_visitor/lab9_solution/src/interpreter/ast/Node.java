package interpreter.ast;

import interpreter.Visitor;

public interface Node {

    Object accept(Visitor visitor, Object param);
}
