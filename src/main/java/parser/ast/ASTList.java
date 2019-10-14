package parser.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ASTList implements ASTNode{
    private ArrayList<ASTNode> children;
    public ASTList(ArrayList<ASTNode> children){
        this.children=children;
    }
    @Override
    public ASTNode child(int i) {
        return children.get(i);
    }

    @Override
    public int numChildren() {
        return children.size();
    }

    @Override
    public List<ASTNode> children() {
        return children;
    }

    @Override
    public Iterator<ASTNode> iterator() {
        return children.iterator();
    }
}
