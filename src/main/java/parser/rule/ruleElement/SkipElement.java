package parser.rule.ruleElement;

import parser.ast.ASTNode;
import parser.lexer.Token;
import parser.lexer.TokenListOp;

import java.util.ArrayList;
import java.util.List;

public class SkipElement extends IdentifierElement {
    public SkipElement(String rule) {
        super(rule);
    }
    @Override
    public void createAST(ArrayList<Token> tokenList, List<ASTNode> results) {
        Token t = TokenListOp.getNextToken(tokenList);
        if (t.getType().equals("identifier") && t.getValue().toString().matches(this.rule)) {
                 System.getLogger("myLogger").log(System.Logger.Level.INFO,"Skip about token "+t.toString());
        }
        else{
            System.getLogger("myLogger").log(System.Logger.Level.ERROR,"Bad createAST at IdentifierElement about token "+t.toString());
        }
    }
}
