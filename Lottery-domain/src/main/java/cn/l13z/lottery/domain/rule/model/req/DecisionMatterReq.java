package cn.l13z.lottery.domain.rule.model.req;

import java.util.Map;

/**
 * ClassName: DecisionMatterReq.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 19:57 <br> Description: 决策物料  <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando  决策物料 <br>
 */
public class DecisionMatterReq {
    /** 规则树ID */
    private Long treeId;
    /** 用户ID */
    private String userId;
    /** 决策值 */
    private Map<String, Object> valMap;

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Object> getValMap() {
        return valMap;
    }

    public void setValMap(Map<String, Object> valMap) {
        this.valMap = valMap;
    }

}
