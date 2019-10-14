package parser.ast;

import parser.lexer.Token;

import java.util.Iterator;
import java.util.List;

public class ASTLeaf implements ASTNode {
    public Token getToken() {
        return token;
    }

    private Token token;

    public String getType() {
        return type;
    }

    private String type;
   public ASTLeaf(Token token,String type){
       this.token=token;
       this.type=type;
   }
    @Override
    public ASTNode child(int i) {
        return null;
    }

    @Override
    public int numChildren() {
        return 0;
    }

    @Override
    public List<ASTNode> children() {
        return null;
    }

    @Override
    public Iterator<ASTNode> iterator() {
        return null;
    }
}
