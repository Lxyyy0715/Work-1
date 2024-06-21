package com.ming.car.controller;

import com.alibaba.fastjson.JSONObject;
import com.ming.car.entity.dto.*;
import com.ming.car.service.CarService;
import com.ming.car.service.RulesService;
import com.ming.car.utils.BatteryAlarm;
import com.ming.car.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author chao
 * @date 2024/6/15 13:53
 * @desciption TODO
 */
@RestController
@RequestMapping("/api")
public class WarnController {

    @Autowired
    private CarService carService;

    @Autowired
    private RulesService rulesService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @PostMapping("/warn")
    public Result warn(@RequestBody List<ReportDto> reportDtoList) {
        List<ReportVo> reportVos = new ArrayList<>();
        for (ReportDto reportDto : reportDtoList) {
            //1.将ReportDto中的signal，json字符串解析为对象
            String signalStr = reportDto.getSignal();
            Signal signal = JSONObject.parseObject(signalStr, Signal.class);
            //2.根据车架号。查询该汽车是哪个电池 先从redis里面存储车架号和电池类型  车架号为key 电池类型为values  如果有就从redis里面取，没有就从数据库查询
            String batteryTypeCar;
            if (!redisTemplate.hasKey(reportDto.getCarId().toString())) {
                //2.1 如果没有这个key,就新增一个字符串类型的值，key是键，value是值。  并从数据库中去取
                Car car = carService.getBatteryTypeByCarId(reportDto.getCarId());
                batteryTypeCar = car.getBatteryType();
                redisTemplate.opsForValue().set(reportDto.getCarId().toString(), batteryTypeCar, 3, TimeUnit.DAYS);
            }else {
                //2.2如果有这个key(车架号),则直接通过key从redis里面根据key(车架号)取出来values(电池类型)
                batteryTypeCar = redisTemplate.opsForValue().get(reportDto.getCarId().toString());
            }
            //3.1计算电压差值
            double mxmi_difference;
            if (signal.getMx() == null || signal.getMi() == null) {
                mxmi_difference = 0;
            } else {
                mxmi_difference = signal.getMx() - signal.getMi();
            }
            //3.2计算电流差值
            double lxli_difference;
            if (signal.getIx() == null || signal.getIi() == null) {
                lxli_difference = 0;
            } else {
                lxli_difference = signal.getIx() - signal.getIi();
            }
            //4.判断规则编号是否为空，如果为空。则遍历所有规则。如果不为空则只遍历当前规则
            if (reportDto.getWarnId() != null) {
                //4.1.1不为空。则去根据规则编号和电池类型去查询对应的规则名称
                Rules rules = rulesService.getRuleNameByWarnId(batteryTypeCar, reportDto.getWarnId());
                //4.1.2根据规则名称去查找相应的规则
                String warnLevel = getWarnLevel(rules, mxmi_difference, lxli_difference);
                ReportVo reportVo = new ReportVo(reportDto.getCarId(), batteryTypeCar, rules.getRuleName(), warnLevel);
                reportVos.add(reportVo);
            } else {
                //4.2.1遍历所有的规则
                List<Rules> rulesList = rulesService.getRuleNameByBatteryType(batteryTypeCar);
                for (Rules rules : rulesList) {
                    String warnLevel = getWarnLevel(rules, mxmi_difference, lxli_difference);
                    ReportVo reportVo = new ReportVo(reportDto.getCarId(), batteryTypeCar, rules.getRuleName(), warnLevel);
                    reportVos.add(reportVo);
                }
            }
        }
        return Result.build(reportVos);
    }

    private String getWarnLevel(Rules rules, double mxmi_difference, double lxli_difference) {
        String warnLevel = "不报警";
        if (rules.getBatteryType().equals("三元电池")){
            if (rules.getRuleId() == 1) {
                // 三元电池 Ｍx－Mi 的预警规则
                warnLevel = BatteryAlarm.getAlarmLevelForTernaryBattery(mxmi_difference);
            }else if (rules.getRuleId() == 2) {
                // 三元电池 Ix-Ii 的预警规则
                warnLevel = BatteryAlarm.getAlarmLevelForTernaryBatteryIxIi(lxli_difference);
            }
        }
        if (rules.getBatteryType().equals("铁锂电池")){
            if (rules.getRuleId() == 1) {
                // 铁锂电池 Ｍx－Mi  的预警规则
                warnLevel = BatteryAlarm.getAlarmLevelForLithiumIronBattery(mxmi_difference);
            } else if (rules.getRuleId() == 2) {
                // 铁锂电池 Ix-Ii 的预警规则
                warnLevel = BatteryAlarm.getAlarmLevelForLithiumIronBatteryIxIi(lxli_difference);
            }
        }
        return warnLevel;
    }
}
