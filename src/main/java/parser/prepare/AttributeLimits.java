package parser.prepare;

public class AttributeLimits {
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

    public String getLimitsExpression() {
        return limitsExpression;
    }

    public void setLimitsExpression(String limitsExpression) {
        this.limitsExpression = limitsExpression;
    }

    private String attributeName;
    private String attributeType;
    private String limitsExpression;
    public AttributeLimits(String attributeName,String attributeType,String limitsExpression){
        this.attributeName=attributeName;
        this.attributeType=attributeType;
        this.limitsExpression=limitsExpression;
    }

}
