package cn.l13z.lottery.infrastructure.dao;

import cn.l13z.lottery.domain.activity.model.vo.AlterStateVO;
import cn.l13z.lottery.infrastructure.po.Activity;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author AlfredOrlando
 */
@Mapper
public interface IActivityDao {

   void insert(Activity req);

   Activity queryActivityById(Long activityId);

    int alterState(AlterStateVO alterStateVO);

    int subtractionActivityStock(Long activityId);

    /**
     * 扫描待处理的活动列表，状态为：通过、活动中
     * 形参:
     * id – ID
     * 返回值:
     * 待处理的活动集
     */
    List<Activity> scanToDoActivityList(Long id);
}
