package parser.ast;

import parser.lexer.Token;

import java.util.Iterator;
import java.util.List;

public class ASTLeaf implements ASTNode {
   private Token token;
   public ASTLeaf(Token token){
       this.token=token;
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
