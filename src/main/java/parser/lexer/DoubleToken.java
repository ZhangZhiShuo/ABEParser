package parser.lexer;

public class DoubleToken extends Token {
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    private Double value;
    public DoubleToken(Double value){
        this.value=value;
        this.type="double";
    }
}
