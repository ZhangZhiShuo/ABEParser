import parser.IntTypeParser;
import parser.StringTypeParser;
import parser.ImpOp;
import parser.ast.ASTNode;
import parser.lexer.Lexer;
import parser.lexer.Token;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args){
//        LoadCode lc=new LoadCode();
//        lc.loadCodesByLines("./src/test/policy");
//        lc.turnCodesToHashMap();
//        lc.printResult();
        Lexer lexer=new Lexer();
        lexer.genToken("./src/test/policy");
        HashMap<String, List> tokenMap=lexer.getTokenMap();
        StringTypeParser stringParser=new StringTypeParser();
        ASTNode root1=stringParser.parser((ArrayList<Token>) tokenMap.get("name"));
        boolean result=ImpOp.implementOp(root1,"垃圾");
        System.out.println("string parser result : "+result);

        IntTypeParser intParser=new IntTypeParser();
        ASTNode root2=intParser.parser((ArrayList<Token>)tokenMap.get("age"));
        boolean result2=ImpOp.implementOp(root2,11);
        System.out.println("int parser result : "+result2);



    }
}
