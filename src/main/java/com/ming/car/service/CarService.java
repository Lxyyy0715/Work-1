package com.ming.car.service;

import com.ming.car.entity.dto.Car;
import com.ming.car.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chao
 * @date 2024/6/15 15:48
 * @desciption TODO
 */
@Service
public class CarService {

    @Autowired
    private CarMapper carMapper;

    public Car getBatteryTypeByCarId(Integer carId) {
        return carMapper.getBatteryTypeByCarId(carId);
    }
}
