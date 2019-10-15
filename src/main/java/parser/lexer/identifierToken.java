package parser.lexer;

public class identifierToken extends StringToken{
public identifierToken(String value){
    super(value);
    this.type="identifier";
}
}
