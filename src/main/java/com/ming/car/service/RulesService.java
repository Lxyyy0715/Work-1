package com.ming.car.service;

import com.ming.car.entity.dto.Rules;
import com.ming.car.mapper.RulesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chao
 * @date 2024/6/15 15:48
 * @desciption TODO
 */
@Service
public class RulesService {

    @Autowired
    private RulesMapper rulesMapper;

    public Rules getRuleNameByWarnId(String batteryType, Integer warnId) {
        return rulesMapper.getRuleNameByWarnId(batteryType,warnId);
    }

    public List<Rules> getRuleNameByBatteryType(String batteryType) {
        return rulesMapper.getRuleNameByBatteryType(batteryType);
    }
}
