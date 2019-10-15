package parser.lexer;

public class IntToken extends Token{

    public Integer getValue() {
        return (Integer)value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public IntToken(Integer value){
     this.value=value;
     this.type="int";
    }

}
