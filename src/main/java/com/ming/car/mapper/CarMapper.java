package com.ming.car.mapper;

import com.ming.car.entity.dto.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chao
 * @date 2024/6/15 15:49
 * @desciption TODO
 */
@Repository
@Mapper
public interface CarMapper {
    Car getBatteryTypeByCarId(@Param("carId") Integer carId);
}
