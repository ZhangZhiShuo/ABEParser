package parser.rule.ruleElement;

import parser.ast.ASTNode;
import parser.lexer.Token;
import parser.rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class TreeElement implements  RuleElement {
    private Rule rule;
    public TreeElement(Rule rule){
        this.rule=rule;
    }
    @Override
    public void createAST(ArrayList<Token> tokenList, List<ASTNode> results) {
        results.add(rule.createAST(tokenList));
    }

    @Override
    public boolean match(ArrayList<Token> tokenList) {
        return rule.match(tokenList);
    }
}
