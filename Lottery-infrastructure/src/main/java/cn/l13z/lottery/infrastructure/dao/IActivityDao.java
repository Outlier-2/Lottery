package cn.l13z.lottery.infrastructure.dao;

import cn.l13z.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IActivityDao {

   void insert(Activity req);

   Activity queryActivityById(Long activityId);

}
