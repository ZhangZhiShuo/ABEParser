package parser.rule.ruleElement;

import parser.ast.ASTLeaf;
import parser.ast.ASTNode;
import parser.lexer.Token;
import parser.lexer.TokenListOp;

import java.util.ArrayList;
import java.util.List;

public class IdentifierElement implements RuleElement {
    protected String rule;

    public IdentifierElement(String rule) {
        this.rule = rule;
    }

    @Override
    public void createAST(ArrayList<Token> tokenList, List<ASTNode> results) {
        Token t = TokenListOp.getNextToken(tokenList);
        if (t.getType().equals("identifier") && t.getValue().toString().matches(this.rule)) {
            ASTLeaf leaf = new ASTLeaf(t, "identifier");
            results.add(leaf);
        }
        else{
            System.getLogger("myLogger").log(System.Logger.Level.ERROR,"Bad createAST at IdentifierElement about token "+t.toString());
        }
    }

    @Override
    public boolean match(ArrayList<Token> tokenList) {
        Token t=TokenListOp.peekNextToken(tokenList);
        if (t.getType().equals("identifier") && t.getValue().toString().matches(this.rule)) {
           return true;
        }
        else{
            return false;
        }
    }
}
