package parser.rule.ruleElement;

import parser.ast.ASTNode;
import parser.lexer.Lexer;
import parser.lexer.Token;

import java.util.ArrayList;
import java.util.List;

public interface RuleElement {
    void createAST(ArrayList<Token> tokenList, List<ASTNode> results);
    boolean match(ArrayList<Token> tokenList);
}
