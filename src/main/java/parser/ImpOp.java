package parser;

import parser.ast.ASTNode;

import java.util.ArrayList;
import java.util.HashSet;

public class ImpOp {
    public static boolean implementOp(ASTNode root,Object value){
        if(root.getName().equals("opList")){
            ASTNode left=root.child(0);
            ASTNode op=root.child(1);
            ASTNode right=root.child(2);
            boolean leftBoolean=ImpOp.implementOp(left,value);
            boolean rightBoolean=ImpOp.implementOp(right,value);
            String opValue=(String)op.getValue();
            if(opValue.equals("AND")||opValue.equals("and")){
                return leftBoolean&&rightBoolean;
            }
            else {
                return leftBoolean||rightBoolean;
            }
        }
        else if(root.getName().equals("compareString")){
             ASTNode compare=root.child(0);
             ASTNode stringNode=root.child(1);
            String string=(String)stringNode.getValue();
             if(compare.getValue().equals("!")||compare.getValue().equals("!=")){

                 return !string.equals((String)value);
             }
             else{
                 return string.equals((String)value);
             }
        }else if(root.getName().equals("stringSetOp")){
            HashSet<String> strSet=new HashSet<>(16);
            ArrayList<ASTNode> children=(ArrayList<ASTNode>) root.children();
            for(int i=1;i<children.size();i++){
                   strSet.add((String)root.child(i).getValue());
            }
            ASTNode setOpNode=root.child(0);
            String setOp=(String)setOpNode.getValue();
            if(setOp.equals("in")){
                return strSet.contains(value);
            }
            else{
                return !strSet.contains(value);
            }
        }
        else if(root.getName().equals("compareInt")){
            ASTNode compareOp=root.child(0);
            ASTNode intNode=root.child(1);
            Integer intVal=(Integer)intNode.getValue();
            String op=(String)compareOp.getValue();
            if(op.equals(">")){
                return (Integer)value>intVal;
            }else if(op.equals(">=")){
                return (Integer)value>=intVal;
            }else if(op.equals("==")){
                return intVal==(Integer)value;
            }
            else if(op.equals("<")){
                return (Integer)value<intVal;
            }
            else if(op.equals("<=")){
                return (Integer)value<=intVal;
            }
            else{
                return intVal!=(Integer)value;
            }
        }
        else if(root.getName().equals("compareDouble")){
            ASTNode compareOp=root.child(0);
            ASTNode doubleNode=root.child(1);
            Double doubleVal=(Double)doubleNode.getValue();
            String op=(String)compareOp.getValue();
            if(op.equals(">")){
                return (Double)value>doubleVal;
            }else if(op.equals(">=")){
                return (Double)value>=doubleVal;
            }else if(op.equals("==")){
                return doubleVal==(Double)value;
            }
            else if(op.equals("<")){
                return (Double)value<doubleVal;
            }
            else if(op.equals("<=")){
                return (Double)value<=doubleVal;
            }
            else{
                return doubleVal!=(Double)value;
            }
        }
        return false;

    }
}
