package cn.l13z.lottery.infrastructure.dao;

import cn.l13z.lottery.domain.activity.model.vo.AlterStateVO;
import cn.l13z.lottery.infrastructure.po.Activity;
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
}
