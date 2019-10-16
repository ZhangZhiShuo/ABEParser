package parser.ast;

import java.util.List;

public interface ASTNode extends Iterable<ASTNode> {
     ASTNode child(int i);
     int numChildren();
     List<ASTNode> children();
     void setName(String name);
     String getName();
     Object getValue();
}

