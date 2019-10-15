package parser.lexer;

public class DoubleToken extends Token {
    public Double getValue() {
        return (Double)value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public DoubleToken(Double value){
        this.value=value;
        this.type="double";
    }

}
