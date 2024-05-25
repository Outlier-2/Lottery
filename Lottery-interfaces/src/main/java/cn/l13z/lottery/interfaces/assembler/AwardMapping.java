package cn.l13z.lottery.interfaces.assembler;

import cn.l13z.lottery.domain.strategy.model.vo.DrawAwardInfo;
import cn.l13z.lottery.rpc.dto.AwardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * ClassName: AwardMapping.java <br>
 *
 * @author AlfredOrlando <br>
 * <p>
 * Created: 2024-05-19 23:01 <br> Description: award转化 <br>
 * <p>
 * Modification History: <br> - 2024/5/19 AlfredOrlando award转化 <br>
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AwardMapping extends IMapping<DrawAwardInfo, AwardDTO> {

    @Mapping(target = "userId", source = "awardId")
    @Override
    AwardDTO sourceToTarget(DrawAwardInfo var1);

    @Override
    DrawAwardInfo targetToSource(AwardDTO var1);

}
