package com.ming.car.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chao
 * @date 2024/6/15 15:56
 * @desciption TODO
 */
@Data
public class Rules implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 规则编号
     */
    private Integer ruleId;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 电池类型（三元电池/铁锂电池）
     */
    private String batteryType;

    /**
     * 预警规则
     */
    private String warnRule;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改者
     */
    private String updateUser;
}
