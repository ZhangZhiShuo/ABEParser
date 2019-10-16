package parser.rule.ruleElement;

import parser.ast.ASTLeaf;
import parser.ast.ASTList;
import parser.ast.ASTNode;
import parser.lexer.Token;
import parser.lexer.TokenListOp;
import parser.rule.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OpExpElement implements RuleElement {
    private Operators opsMap;
    private Rule factor;

    public OpExpElement(Operators opsMap,Rule factor){
        this.opsMap=opsMap;
        this.factor=factor;
    }
    @Override
    public void createAST(ArrayList<Token> tokenList, List<ASTNode> results) {
        ASTNode left=factor.createAST(tokenList);
        Precedence pre;
        while((pre=peekNextOperator(tokenList))!=null){
            left=doShift(pre,left,tokenList);
        }
        results.add(left);
    }
    private ASTNode doShift(Precedence pre,ASTNode left,ArrayList<Token> tokenList){

        Token op=TokenListOp.getNextToken(tokenList);
        ASTLeaf opLeaf=new ASTLeaf(op,"op");
        opLeaf.setName(opLeaf.getType());
        ASTNode right=factor.createAST(tokenList);
        Precedence post;
        while((post=peekNextOperator(tokenList))!=null&&isPrecedence(pre,post)){
            right=doShift(post,right,tokenList);
        }
        ASTList list=new ASTList(Arrays.asList(left,opLeaf,right));
        list.setName("opList");
        return list;
    }
    private Precedence peekNextOperator(ArrayList<Token> tokenList){
        Token t= TokenListOp.peekNextToken(tokenList);
        if(t!=null) {
            return opsMap.get(t.getValue());
        }
        else{
            return null;
        }
    }
    private boolean isPrecedence(Precedence pre,Precedence post){
        if(post.isLeftAsso()){
            return pre.getPrecedence()<post.getPrecedence();
        }
        else{
            return pre.getPrecedence()<=post.getPrecedence();
        }
    }

    @Override
    public boolean match(ArrayList<Token> tokenList) {
        return factor.match(tokenList);
    }
    public static class Operators extends HashMap<String,Precedence>{
        public void add(String name,int precedence,boolean leftAsso){
            this.put(name,new Precedence(precedence,leftAsso));
        }
        public int getOpPrecedence(String name){
            return this.get(name).getPrecedence();
        }
        public boolean isLeftAssoc(String name){
            return this.get(name).isLeftAsso();
        }
    }
    private static class Precedence{
        private int precedence;

        public int getPrecedence() {
            return precedence;
        }

        public boolean isLeftAsso() {
            return leftAsso;
        }

        private boolean leftAsso;
        public Precedence(int precedence,boolean leftAsso){
            this.precedence=precedence;
            this.leftAsso=leftAsso;
        }
    }

}
