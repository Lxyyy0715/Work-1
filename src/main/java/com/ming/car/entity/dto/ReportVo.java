package com.ming.car.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chao
 * @date 2024/6/15 13:51
 * @desciption 上报接口
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportVo implements Serializable {
    /**
     * 车架编号
     */
    private Integer carId;

    /**
     * 电池类型（三元电池/铁锂电池）
     */
    private String batteryType;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 报警等级
     */
    private String warnLevel;


}
