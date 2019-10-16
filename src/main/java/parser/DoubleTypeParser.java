package parser;

import parser.ast.ASTNode;
import parser.lexer.Token;
import parser.rule.Rule;
import parser.rule.ruleElement.OpExpElement;

import java.util.ArrayList;

public class DoubleTypeParser {
    private OpExpElement.Operators operators=new OpExpElement.Operators();
    private Rule compareDouble;
    private Rule factor;
    private Rule OpExp;
    public DoubleTypeParser(){
        operators.add("or",1,true);
        operators.add("OR",1,true);
        operators.add("and",1,true);
        operators.add("AND",1,true);
        compareDouble=Rule.initRule("compareDouble");
        compareDouble.addIdentifierElement("!=|>=|==|<=|>|<").addDoubleElement();
        factor=Rule.initRule("factor");
        OpExp=Rule.initRule("OpExp");
        factor.addOrElement(compareDouble,Rule.initRule("()").addSkipElement("\\(").addASTree(OpExp).addSkipElement("\\)"));
        OpExp.addOpExp(factor,operators);
    }
    public ASTNode parser(ArrayList<Token> tokenList){
        return OpExp.createAST(tokenList);
    }
}
