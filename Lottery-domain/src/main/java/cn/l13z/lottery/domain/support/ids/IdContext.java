package cn.l13z.lottery.domain.support.ids;

import cn.l13z.lottery.common.Constants;
import cn.l13z.lottery.domain.support.ids.policy.RandomNumeric;
import cn.l13z.lottery.domain.support.ids.policy.ShortCode;
import cn.l13z.lottery.domain.support.ids.policy.SnowFlake;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: IdContext.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-16 01:39 <br> Description: ID内容 <br>
 * <p>
 * Modification History: <br> - 2024/5/16 AlfredOrlando ID内容 <br>
 */
@Configuration
public class IdContext {

    /**
     * 创建 ID 生成策略对象，属于策略设计模式的使用方式
     *
     * @param snowFlake     雪花算法，长码，大量
     * @param shortCode     日期算法，短码，少量，全局唯一需要自己保证
     * @param randomNumeric 随机算法，短码，大量，全局唯一需要自己保证
     * @return IIdGenerator 实现类
     */
    @Bean
    public Map<Constants.Ids, IIdGenerator> idGenerator(SnowFlake snowFlake, ShortCode shortCode,
        RandomNumeric randomNumeric) {
        Map<Constants.Ids, IIdGenerator> idGeneratorMap = new HashMap<>(8);
        idGeneratorMap.put(Constants.Ids.SnowFlake, snowFlake);
        idGeneratorMap.put(Constants.Ids.ShortCode, shortCode);
        idGeneratorMap.put(Constants.Ids.RandomNumeric, randomNumeric);
        return idGeneratorMap;
    }
}
