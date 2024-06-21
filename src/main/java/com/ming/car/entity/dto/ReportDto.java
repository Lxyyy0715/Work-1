package com.ming.car.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chao
 * @date 2024/6/15 13:51
 * @desciption 上报接口
 */
@Data
public class ReportDto implements Serializable {
    /**
     * 车架编号
     */
    private Integer carId;

    /**
     * 规则编号  不传时候，遍历所有规则
     */
    private Integer warnId;

    /**
     * 信号
     */
    private String signal;

}
