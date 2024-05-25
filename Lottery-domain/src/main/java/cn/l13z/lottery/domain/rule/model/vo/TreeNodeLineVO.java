package cn.l13z.lottery.domain.rule.model.vo;

/**
 * ClassName: TreeNodeLineVO.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 19:49 <br> Description: 策略数线信息 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 策略数线信息 <br>
 */
public class TreeNodeLineVO {

    /** 节点From */
    private Long nodeIdFrom;
    /** 节点To */
    private Long nodeIdTo;
    /** 限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围] */
    private Integer ruleLimitType;
    /** 限定值 */
    private String ruleLimitValue;

    public Long getNodeIdFrom() {
        return nodeIdFrom;
    }

    public void setNodeIdFrom(Long nodeIdFrom) {
        this.nodeIdFrom = nodeIdFrom;
    }

    public Long getNodeIdTo() {
        return nodeIdTo;
    }

    public void setNodeIdTo(Long nodeIdTo) {
        this.nodeIdTo = nodeIdTo;
    }

    public Integer getRuleLimitType() {
        return ruleLimitType;
    }

    public void setRuleLimitType(Integer ruleLimitType) {
        this.ruleLimitType = ruleLimitType;
    }

    public String getRuleLimitValue() {
        return ruleLimitValue;
    }

    public void setRuleLimitValue(String ruleLimitValue) {
        this.ruleLimitValue = ruleLimitValue;
    }

    @Override
    public String toString() {
        return "TreeNodeLineVO{" +
            "nodeIdFrom=" + nodeIdFrom +
            ", nodeIdTo=" + nodeIdTo +
            ", ruleLimitType=" + ruleLimitType +
            ", ruleLimitValue='" + ruleLimitValue + '\'' +
            '}';
    }


}
