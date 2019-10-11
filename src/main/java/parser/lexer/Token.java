package parser.lexer;

public abstract class Token {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    protected String type;
    protected Object value;

    @Override
    public String toString() {
        return String.format("Token type:%s;Token value:%s;",type,value.toString());
    }
}
