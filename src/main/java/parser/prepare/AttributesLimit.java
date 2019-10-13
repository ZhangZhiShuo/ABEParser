package parser.prepare;

public class AttributesLimit {
    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    public String getLimitExpression() {
        return limitExpression;
    }

    public void setLimitExpression(String limitsExpression) {
        this.limitExpression = limitsExpression;
    }

    private String attributeName;
    private String attributeType;
    private String limitExpression;
    public AttributesLimit(String attributeName, String attributeType, String limitExpression){
        this.attributeName=attributeName;
        this.attributeType=attributeType;
        this.limitExpression=limitExpression;
    }

}
