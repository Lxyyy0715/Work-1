package com.ming.car.entity.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chao
 * @date 2024/6/15 14:02
 * @desciption 用于映射signal字段的类
 */
@Data
public class Signal implements Serializable {

    /**
     * 最高电压
     */
    private Double Mx;

    /**
     * 最低电压
     */
    private Double Mi;

    /**
     * 最高电流
     */
    private Double Ix;

    /**
     * 最小电流
     */
    private Double Ii;
}
