package interpreter.ast;

import labs.lab9_visitor.original.interpreter.ast.Node;
import labs.lab9_visitor.original.interpreter.ast.Statement;

import java.util.List;

public class Program implements Node {
    
    public List<Statement> statements;
    
    public Program(List<Statement> program) {
        this.statements = program;
    }
}
