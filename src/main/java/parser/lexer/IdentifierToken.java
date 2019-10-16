package parser.lexer;

public class IdentifierToken extends StringToken{
public IdentifierToken(String value){
    super(value);
    this.type="identifier";
}
}
