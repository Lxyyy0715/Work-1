package com.ming.car.mapper;

import com.ming.car.entity.dto.Rules;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chao
 * @date 2024/6/15 15:49
 * @desciption TODO
 */
@Repository
@Mapper
public interface RulesMapper {
    Rules getRuleNameByWarnId(@Param("batteryType") String batteryType,@Param("warnId") Integer warnId);

    List<Rules> getRuleNameByBatteryType(String batteryType);
}
