package parser.lexer;

public class StringToken extends Token {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;
    public StringToken(String value){
        this.value=value;
        this.type="string";
    }

}
