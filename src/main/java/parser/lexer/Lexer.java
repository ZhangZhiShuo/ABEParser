package parser.lexer;

import parser.prepare.AttributeLimits;
import parser.prepare.LoadCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Lexer {
 private static String stringPattern="\"([^\"`~!@#$%^&*()-=+\\/;:'<>,.。？?～`|、×（）\\-——]*)\"";
 private   static String intPattern="0|[1-9][0-9]*";
 private  static String doublePattern="0|[1-9][0-9]*\\.[0-9]*";
 private static String identifierPattern="in|not in|\\[|\\]|\\+|-|\\*|/|>=|<=|>|<|&&|\\|\\||\\(|\\)";

 private Pattern strp=Pattern.compile(stringPattern);
 private Pattern intp=Pattern.compile(intPattern);
 private Pattern doublep=Pattern.compile(doublePattern);
 private Pattern idp=Pattern.compile(identifierPattern);
 private HashMap<String, List> tokenMap=new HashMap<>(16);
 public void genToken(String fileName){
     LoadCode lc=new LoadCode();
     lc.loadCodesByLines(fileName);
     lc.turnCodesToHashMap();
     HashMap<String, AttributeLimits> attributeLimitMap=lc.getAttributeLimitsMap();
     for(String key:attributeLimitMap.keySet()){
         AttributeLimits al=attributeLimitMap.get(key);
         for(String limitExpr:al.getLimitsExpression()){
             ArrayList<Token> tokenList=new ArrayList<>();
         }
     }
     //lc.printResult();

 }


}
