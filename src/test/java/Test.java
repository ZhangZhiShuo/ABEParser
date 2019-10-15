import parser.ABEParser;
import parser.ast.ASTNode;
import parser.lexer.Lexer;
import parser.lexer.Token;
import parser.prepare.LoadCode;

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
        ABEParser abeParser=new ABEParser();
        ASTNode root=abeParser.parser((ArrayList<Token>) tokenMap.get("name"));
        System.out.println("ending");
    }
}
