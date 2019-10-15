package parser.lexer;

public class identifierToken extends Token{
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;
public identifierToken(String value){
    this.value=value;
    this.type="identifier";
}
}
