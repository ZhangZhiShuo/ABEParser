package parser.lexer;

public abstract class Token {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    protected String type;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    protected Object value;
    @Override
    public String toString() {
        return String.format("Token type:%s  Token value:%s",type,String.valueOf(value));
    }
}
