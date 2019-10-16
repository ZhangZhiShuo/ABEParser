package parser.rule.ruleElement;

import parser.ast.ASTLeaf;
import parser.ast.ASTNode;
import parser.lexer.DoubleToken;
import parser.lexer.IntToken;
import parser.lexer.Token;
import parser.lexer.TokenListOp;

import java.util.ArrayList;
import java.util.List;

public class DoubleElement implements RuleElement {
    @Override
    public void createAST(ArrayList<Token> tokenList, List<ASTNode> results) {
        Token t=TokenListOp.getNextToken(tokenList);
        if(t instanceof DoubleToken){
            ASTLeaf intLeaf=new ASTLeaf(t,"double");
            intLeaf.setName("double");
            results.add(intLeaf);
        }
        else{
            System.getLogger("myLogger").log(System.Logger.Level.ERROR, "Bad createAST at StringElement about token " + t.toString());
        }

    }
    @Override
    public boolean match(ArrayList<Token> tokenList) {
        Token t=TokenListOp.peekNextToken(tokenList);
        if(t instanceof DoubleToken){
            return true;
        }
        else{
            return false;
        }
    }
}
