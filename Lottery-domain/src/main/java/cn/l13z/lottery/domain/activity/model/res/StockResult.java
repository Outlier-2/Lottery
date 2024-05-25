package cn.l13z.lottery.domain.activity.model.res;

import cn.l13z.lottery.common.Result;

/**
 * ClassName: StockResult.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-25 01:03 <br> Description: 库存结果列 <br>
 * <p>
 * Modification History: <br> - 2024/5/25 AlfredOrlando 库存结果列 <br>
 */
public class StockResult extends Result {

    /**
     * 库存 Key
     */
    private String stockKey;
    /**
     * activity 库存剩余
     */
    private Integer stockSurplusCount;

    public StockResult(String code, String info) {
        super(code, info);
    }

    public StockResult(String code, String info, String stockKey, Integer stockSurplusCount) {
        super(code, info);
        this.stockKey = stockKey;
        this.stockSurplusCount = stockSurplusCount;
    }

    public String getStockKey() {
        return stockKey;
    }

    public void setStockKey(String stockKey) {
        this.stockKey = stockKey;
    }

    public Integer getStockSurplusCount() {
        return stockSurplusCount;
    }

    public void setStockSurplusCount(Integer stockSurplusCount) {
        this.stockSurplusCount = stockSurplusCount;
    }
}