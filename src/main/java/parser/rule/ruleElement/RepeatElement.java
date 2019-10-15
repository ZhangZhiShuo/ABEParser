package parser.rule.ruleElement;

import parser.ast.ASTNode;
import parser.lexer.Token;
import parser.rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class RepeatElement implements RuleElement {
     private Rule rule;
     private boolean onlyOnce;
     public RepeatElement(Rule rule,boolean onlyOnce){
         this.rule=rule;
         this.onlyOnce=onlyOnce;
     }
    @Override
    public void createAST(ArrayList<Token> tokenList, List<ASTNode> results) {
      while(rule.match(tokenList)){
          ASTNode astNode=rule.createAST(tokenList);
          results.add(astNode);
          if(onlyOnce){
              break;
          }
      }
    }

    @Override
    public boolean match(ArrayList<Token> tokenList) {
        return rule.match(tokenList);
    }
}
