package parser.rule.ruleElement;

import parser.ast.ASTNode;
import parser.lexer.Lexer;

import java.util.List;

public interface RuleElement {
    void parse(Lexer lexer, List<ASTNode> results);
    boolean match(Lexer lexer);
}
