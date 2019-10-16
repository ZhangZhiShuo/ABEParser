package parser.rule;

import parser.ast.ASTList;
import parser.ast.ASTNode;
import parser.lexer.Token;
import parser.rule.ruleElement.*;
import parser.rule.ruleElement.OpExpElement.Operators;

import java.util.ArrayList;

public class Rule {
    private ArrayList<RuleElement> elements;
    private String ruleName;

    public static Rule initRule(String ruleName) {
        ArrayList<RuleElement> elements = new ArrayList<>();
        return new Rule(elements, ruleName);
    }

    public Rule(ArrayList<RuleElement> elements, String ruleName) {
        this.elements = elements;
        this.ruleName = ruleName;
    }

    public Rule addStringElement() {
        StringElement stringElement = new StringElement();
        this.elements.add(stringElement);
        return this;
    }
public Rule addIntElement(){
        IntElement intElement=new IntElement();
        this.elements.add(intElement);
        return this;
}
public Rule addDoubleElement(){
        DoubleElement doubleElement=new DoubleElement();
        this.elements.add(doubleElement);
        return this;
}
    public Rule addIdentifierElement(String ruleName) {
        IdentifierElement identifierElement = new IdentifierElement(ruleName);
        this.elements.add(identifierElement);
        return this;
    }

    public Rule addOpExp(Rule factor, Operators opsMap) {
        OpExpElement opExpElement = new OpExpElement(opsMap, factor);
        this.elements.add(opExpElement);
        return this;
    }

    public Rule addSkipElement(String rule) {
        SkipElement skipElement = new SkipElement(rule);
        this.elements.add(skipElement);
        return this;
    }

    public Rule addRepeatElement(Rule rule, boolean onlyOnce) {
        RepeatElement repeatElement = new RepeatElement(rule, onlyOnce);
        this.elements.add(repeatElement);
        return this;
    }

    public Rule addOrElement(Rule... rules) {
        OrElement orElement = new OrElement(rules);
        this.elements.add(orElement);
        return this;
    }

    public Rule addASTree(Rule rule){
        TreeElement treeElement=new TreeElement(rule);
        this.elements.add(treeElement);
        return this;
    }
    public ASTNode createAST(ArrayList<Token> tokenList) {
        ArrayList<ASTNode> astNodes = new ArrayList<>();
        for (RuleElement e : this.elements) {
            e.createAST(tokenList, astNodes);
        }
        if (astNodes.size() == 1) {
            ASTNode result = astNodes.get(0);
            if(result.getName()==null) {
                result.setName(this.ruleName);
            }
            return result;
        } else {
            ASTList results = new ASTList(astNodes);
            results.setName(this.ruleName);
            return results;
        }
    }

    public boolean match(ArrayList<Token> tokenList) {
        RuleElement first = this.elements.get(0);
        return first.match(tokenList);
    }

}
