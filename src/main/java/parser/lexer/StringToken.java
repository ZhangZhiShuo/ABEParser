package parser.lexer;

public class StringToken extends Token {
    public String getValue() {
        return (String)value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public StringToken(String value){
        this.value=value;
        this.type="string";
    }

}
