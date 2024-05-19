package cn.l13z.lottery.domain.support.ids.policy;

import cn.l13z.lottery.domain.support.ids.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * ClassName: RandomNumeric.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-16 01:44 <br> Description: 随机生成算法 <br>
 * <p>
 * Modification History: <br> - 2024/5/16 AlfredOrlando 随机生成算法 <br>
 */
@Component
public class RandomNumeric implements IIdGenerator {

    @Override
    public long nextId() {
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }

}
