package interpreter.ast;

import java.util.List;

public class Program implements Node {
    
    public List<Statement> statements;
    
    public Program(List<Statement> program) {
        this.statements = program;
    }
}
