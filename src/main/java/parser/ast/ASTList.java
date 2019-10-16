package parser.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ASTList implements ASTNode{
    private ArrayList<ASTNode> children;
    public ASTList(List<ASTNode> children){
        ArrayList<ASTNode> astNodes=new ArrayList<>(children);
        this.children=astNodes;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    private String listName;

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
    public void setName(String name) {
         setListName(name);
    }

    @Override
    public String getName() {
        return this.getListName();
    }

    @Override
    public Object getValue() {
        return "This is a list";
    }

    @Override
    public Iterator<ASTNode> iterator() {
        return children.iterator();
    }
}
