package cn.l13z.lottery.domain.support.ids.policy;

import cn.l13z.lottery.domain.support.ids.IIdGenerator;
import java.util.Calendar;
import java.util.Random;
import org.springframework.stereotype.Component;

/**
 * ClassName: ShortCode.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-16 01:45 <br> Description: 短码少量的日期算法 <br>
 * <p>
 * Modification History: <br> - 2024/5/16 AlfredOrlando 短码少量的日期算法 <br>
 */
@Component
public class ShortCode implements IIdGenerator {

    @Override
    public synchronized long nextId() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // 打乱排序：2020年为准 + 小时 + 周期 + 日 + 三位随机数
        String idStr = String.valueOf(year - 2020)
            + hour
            + String.format("%02d", week)
            + day
            + String.format("%03d", new Random().nextInt(1000));

        return Long.parseLong(idStr);

    }
}