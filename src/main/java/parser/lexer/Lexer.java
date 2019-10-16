package parser.lexer;

import parser.prepare.AttributesLimit;
import parser.prepare.LoadCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    private static String stringType = "\"((\\\\\"|[^\"])*)\"";
    private static String intType = "-?(0|[1-9][0-9]*)";
    private static String doubleType = "-?(0|[1-9][0-9]*\\.[0-9]*)";
    private static String stringIdentifier = "in|not in|\\[|\\]|\\(|\\)|==|!=|or|and|OR|AND|contains|,|!";
    private static String numIdentifier="\\(|\\)|==|!=|or|and|OR|AND|>=|<=|<|>";

    private Pattern strPattern = Pattern.compile(String.format("(%s)|(%s)|\\s+", stringType, stringIdentifier));
    private Pattern intPattern = Pattern.compile(String.format("(%s)|(%s)|\\s+", intType, numIdentifier));
    private Pattern doublePattern = Pattern.compile(String.format("(%s)|(%s)|\\s+", doubleType, numIdentifier));

    public HashMap<String, List> getTokenMap() {
        return tokenMap;
    }

    private HashMap<String, List> tokenMap = new HashMap<>(16);

    public void genToken(String fileName) {
        LoadCode lc = new LoadCode();
        lc.loadCodesByLines(fileName);
        lc.turnCodesToHashMap();
        HashMap<String, AttributesLimit> attributeLimitsMap = lc.getAttributesLimitMap();
        for (String key : attributeLimitsMap.keySet()) {
            AttributesLimit al = attributeLimitsMap.get(key);
            ArrayList<Token> tokenList = new ArrayList<>();
            if (al.getAttributeType().equals("string")) {
                    Matcher matcher=strPattern.matcher(al.getLimitExpression());
                    int start=0;
                    int end=al.getLimitExpression().length();
                    while(start<end){
                        matcher.region(start,end);
                        if(matcher.lookingAt()){
                            if(matcher.group(2)!=null){
                                tokenList.add(new StringToken(matcher.group(2)));
                            }
                            else if(matcher.group(4)!=null){
                                tokenList.add(new IdentifierToken(matcher.group(4)));
                            }
                            start=matcher.end();
                        }
                        else{
                            System.getLogger("myLogger").log(System.Logger.Level.ERROR,"Bad Lexer at "+start+" to "+end+" about limit "+al.getAttributeName());
                            return ;
                        }
                    }

            } else if (al.getAttributeType().equals("int")) {
                Matcher matcher=intPattern.matcher(al.getLimitExpression());
                int start=0;
                int end=al.getLimitExpression().length();
                while(start<end){
                    matcher.region(start,end);
                    if(matcher.lookingAt()){
                        if (matcher.group(1) != null) {
                            tokenList.add(new IntToken(Integer.valueOf(matcher.group(1))));
                        } else if (matcher.group(3) != null) {
                            tokenList.add(new IdentifierToken(matcher.group(3)));
                        }
                        start=matcher.end();
                    }
                    else{
                        System.getLogger("myLogger").log(System.Logger.Level.ERROR,"Bad Lexer at "+start+" to "+end+" about limit "+al.getAttributeName());
                        return ;
                    }
                }
            } else {
                Matcher matcher=doublePattern.matcher(al.getLimitExpression());
                int start=0;
                int end=al.getLimitExpression().length();
                while(start<end){
                    matcher.region(start,end);
                    if(matcher.lookingAt()){
                        if (matcher.group(1) != null) {
                            tokenList.add(new DoubleToken(Double.valueOf(matcher.group(1))));
                        } else if (matcher.group(3) != null) {
                            tokenList.add(new IdentifierToken(matcher.group(3)));
                        }
                        start=matcher.end();
                    }
                    else{
                        System.getLogger("myLogger").log(System.Logger.Level.ERROR,"Bad Lexer at "+start+" to "+end+" about limit "+al.getAttributeName());
                        return ;
                    }
                }

            }
            tokenMap.put(key,tokenList);
        }
        //lc.printResult();

    }


}
