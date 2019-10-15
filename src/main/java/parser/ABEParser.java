package parser;

import parser.ast.ASTNode;
import parser.lexer.Token;
import parser.rule.Rule;
import parser.rule.ruleElement.OpExpElement.Operators;

import java.util.ArrayList;

public class ABEParser {
    private Operators operators=new Operators();
    private Rule compareString,stringSetOp;
    private Rule factor;
    private Rule OpExp;
    public ABEParser(){
        operators.add("or",1,true);
        operators.add("OR",1,true);
        operators.add("and",1,true);
        operators.add("AND",1,true);
        compareString=Rule.initRule("compareString");
        compareString.addIdentifierElement("!=|!|==").addStringElement();
        stringSetOp=Rule.initRule("stringSetOp");
        stringSetOp.addIdentifierElement("not in|in").addSkipElement("\\[").addStringElement().addRepeatElement(Rule.initRule("memberRepeat").addSkipElement(",").addStringElement(),false).addSkipElement("\\]");
        factor=Rule.initRule("factor");
        OpExp=Rule.initRule("OpExp");
        factor.addOrElement(compareString,stringSetOp,Rule.initRule("()").addSkipElement("\\(").addASTree(OpExp).addSkipElement("\\)"));
        OpExp.addOpExp(factor,operators);
    }
    public ASTNode parser(ArrayList<Token> tokenList){
        return OpExp.createAST(tokenList);

    }
}
