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
public class Car implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 16位随机字符串车辆识别码，每辆车唯一
     */
    private String vid;

    /**
     * 车架编号
     */
    private Integer carId;

    /**
     * 电池类型（三元电池/铁锂电池）
     */
    private String batteryType;

    /**
     * 总里程(km)
     */
    private String totalMileage;

    /**
     * 健康状态
     */
    private String healthStatus;

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
