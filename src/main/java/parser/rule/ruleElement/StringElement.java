package parser.rule.ruleElement;

import parser.ast.ASTLeaf;
import parser.ast.ASTNode;
import parser.lexer.Token;
import parser.lexer.TokenListOp;

import java.util.ArrayList;
import java.util.List;

public class StringElement implements RuleElement {

    @Override
    public void createAST(ArrayList<Token> tokenList, List<ASTNode> results) {
        Token t = TokenListOp.getNextToken(tokenList);
        if (t.getType().equals("string")) {
            ASTLeaf leaf = new ASTLeaf(t, "stringLeaf");
            leaf.setName((String)t.getValue());
            results.add(leaf);
        } else {
            System.getLogger("myLogger").log(System.Logger.Level.ERROR, "Bad createAST at StringElement about token " + t.toString());
        }
    }

    @Override
    public boolean match(ArrayList<Token> tokenList) {
        Token t = TokenListOp.peekNextToken(tokenList);
        if(t==null){
            return false;
        }
        if (t.getType().equals("string")) {
            return true;
        }
       else{
           return false;
        }
    }
}
