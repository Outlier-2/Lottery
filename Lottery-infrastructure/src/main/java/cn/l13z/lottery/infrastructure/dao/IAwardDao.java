package cn.l13z.lottery.infrastructure.dao;

import cn.l13z.lottery.infrastructure.po.Award;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author AlfredOrlando
 */
@Mapper
public interface IAwardDao {

    Award queryAwardInfo(String awardId);

    void insertList(List<Award> req);
}
