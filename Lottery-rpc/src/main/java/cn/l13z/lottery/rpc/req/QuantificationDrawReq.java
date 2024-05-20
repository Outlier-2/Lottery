package cn.l13z.lottery.rpc.req;

import java.util.Map;

/**
 * ClassName: QuantificationDrawReq.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 22:44 <br> Description: 量化人群抽奖参数 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando 量化人群抽奖参数  <br>
 */
public class QuantificationDrawReq {

    /** 用户ID */
    private String uId;
    /** 规则树ID */
    private Long treeId;
    /** 决策值 */
    private Map<String, Object> valMap;

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Map<String, Object> getValMap() {
        return valMap;
    }

    public void setValMap(Map<String, Object> valMap) {
        this.valMap = valMap;
    }

}
