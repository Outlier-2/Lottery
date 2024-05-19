package cn.l13z.lottery.domain.support.ids.policy;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import cn.l13z.lottery.domain.support.ids.IIdGenerator;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * ClassName: SnowFlake.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-16 01:46 <br> Description: 雪花算法 <br>
 * <p>
 * Modification History: <br> - 2024/5/16 AlfredOrlando 雪花算法 <br>
 */
@Component
public class SnowFlake implements IIdGenerator {

    private Snowflake snowflake;

    @PostConstruct
    public void init() {
        // 0 ~ 31 位，可以采用配置的方式使用
        long workerId;
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            workerId = NetUtil.getLocalhostStr().hashCode();
        }

        workerId = workerId >> 16 & 31;

        long dataCenterId = 1L;
        snowflake = IdUtil.createSnowflake(workerId, dataCenterId);
    }

    @Override
    public synchronized long nextId() {
        return snowflake.nextId();
    }
}
