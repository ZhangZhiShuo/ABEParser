package parser.lexer;

import java.util.ArrayList;

public class TokenListOp {
    public static Token getNextToken(ArrayList<Token> tokenList){
        if(tokenList.size()>0){
            return tokenList.remove(0);
        }
        else{
            return null;
        }
    }
    public static Token peekNextToken(ArrayList<Token> tokenList){
        if(tokenList.size()>0){
            return tokenList.get(0);
        }
        else{
            return null;
        }
    }
}
