package parser.rule;

import parser.rule.ruleElement.RuleElement;
import parser.rule.ruleElement.StringElement;

import java.util.ArrayList;

public class Rule {
    private ArrayList<RuleElement> elements;
    private String ruleName;
    public static Rule initRule(String ruleName){
        ArrayList<RuleElement> elements=new ArrayList<>();
        return new Rule(elements,ruleName);
    }
    public Rule(ArrayList<RuleElement> elements,String ruleName){
        this.elements=elements;
        this.ruleName=ruleName;
    }
    public Rule addStringElement(){
        StringElement stringElement=new StringElement();
        this.elements.add(stringElement);
        return this;
    }
}
