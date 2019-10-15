package parser.rule.ruleElement;

import parser.ast.ASTNode;
import parser.lexer.Token;
import parser.rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class OrElement implements RuleElement {
    private Rule[] rules;
    public OrElement(Rule[] rules){
        this.rules=rules;
    }
    @Override
    public void createAST(ArrayList<Token> tokenList, List<ASTNode> results) {
        for(Rule rule:rules){
            if(rule.match(tokenList)){
                ASTNode astNode=rule.createAST(tokenList);
                results.add(astNode);
                return;
            }
        }
        System.getLogger("myLogger").log(System.Logger.Level.ERROR,"Bad createAST at orElement");
    }

    @Override
    public boolean match(ArrayList<Token> tokenList) {
        for(Rule rule:rules){
            if(rule.match(tokenList)){
                return true;
            }
        }
        return false;
    }
}
