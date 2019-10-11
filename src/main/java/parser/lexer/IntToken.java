package parser.lexer;

public class IntToken extends Token{
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public IntToken(Integer value){
     this.value=value;
     this.type="int";
    }

}
