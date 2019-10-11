package parser.lexer;

import parser.prepare.AttributeLimits;
import parser.prepare.LoadCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
    private static String stringPattern = "\"([^\"`~!@#$%^&*()-=+\\/;:'<>,.。？?～`|、×（）\\-——]*)\"";
    private static String intPattern = "-?(0|[1-9][0-9]*)";
    private static String doublePattern = "-?(0|[1-9][0-9]*\\.[0-9]*)";
    private static String identifierPattern = "in|not in|\\[|\\]|\\+|-|\\*|/|>=|<=|>|<|&&|\\|\\||\\(|\\)|==|!=";

    private Pattern strType = Pattern.compile(String.format("%s|(%s)", stringPattern, identifierPattern));
    private Pattern intType = Pattern.compile(String.format("(%s)|(%s)", intPattern, identifierPattern));
    private Pattern doubleType = Pattern.compile(String.format("(%s)|(%s)", doublePattern, identifierPattern));
    private HashMap<String, List> tokenMap = new HashMap<>(16);

    public void genToken(String fileName) {
        LoadCode lc = new LoadCode();
        lc.loadCodesByLines(fileName);
        lc.turnCodesToHashMap();
        HashMap<String, AttributeLimits> attributeLimitsMap = lc.getAttributeLimitsMap();
        for (String key : attributeLimitsMap.keySet()) {
            AttributeLimits al = attributeLimitsMap.get(key);
            ArrayList<List> tokenListList = new ArrayList<>();
            if (al.getAttributeType().equals("string")) {

                for (String limitExpr : al.getLimitsExpression()) {
                    ArrayList<Token> tokenList = new ArrayList<>();
                    Matcher matcher = strType.matcher(limitExpr);
                    while (matcher.find()) {
                        if (matcher.group(1) != null) {
                            tokenList.add(new StringToken(matcher.group(1)));
                        } else if (matcher.group(2) != null) {
                            tokenList.add(new identifierToken(matcher.group(2)));
                        }
                    }
                    tokenListList.add(tokenList);
                }
            } else if (al.getAttributeType().equals("int")) {
                for (String limitExpr : al.getLimitsExpression()) {
                    ArrayList<Token> tokenList = new ArrayList<>();
                    Matcher matcher = intType.matcher(limitExpr);
                    while (matcher.find()) {
                        if (matcher.group(1) != null) {
                            tokenList.add(new IntToken(Integer.valueOf(matcher.group(1))));
                        } else if (matcher.group(3) != null) {
                            tokenList.add(new identifierToken(matcher.group(3)));
                        }
                    }
                    tokenListList.add(tokenList);
                }
            } else {
                for (String limitExpr : al.getLimitsExpression()) {
                    ArrayList<Token> tokenList = new ArrayList<>();
                    Matcher matcher = doubleType.matcher(limitExpr);
                    while (matcher.find()) {
                        if (matcher.group(1) != null) {
                            tokenList.add(new DoubleToken(Double.valueOf(matcher.group(1))));
                        } else if (matcher.group(3) != null) {
                            tokenList.add(new identifierToken(matcher.group(3)));
                        }
                    }
                }
            }
            tokenMap.put(key,tokenListList);
        }
        //lc.printResult();

    }


}
