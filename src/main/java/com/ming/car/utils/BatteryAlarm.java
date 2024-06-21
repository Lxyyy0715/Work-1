package com.ming.car.utils;

/**
 * @author chao
 * @date 2024/6/17 16:57
 * @desciption TODO
 */
public class BatteryAlarm {

    // 三元电池 Ｍx－Mi 的预警规则
    public static String getAlarmLevelForTernaryBattery(double difference) {
        if (difference >= 5) {
            return "0"; // 报警等级：0
        } else if (difference >= 3 && difference < 5) {
            return "1"; // 报警等级：1
        } else if (difference >= 1 && difference < 3) {
            return "2"; // 报警等级：2
        } else if (difference >= 0.6 && difference < 1) {
            return "3"; // 报警等级：3
        } else if (difference >= 0.2 && difference < 0.6) {
            return "4"; // 报警等级：4
        } else {
            return "不报警"; // 不报警
        }
    }

    // 铁锂电池 Ｍx－Mi  的预警规则
    public static String getAlarmLevelForLithiumIronBattery(double difference) {
        if (difference >= 2) {
             return "0"; // 报警等级：0
        } else if (difference >= 1 && difference < 2) {
             return "1"; // 报警等级：1
        } else if (difference >= 0.7 && difference < 1) {
             return "2"; // 报警等级：2
        } else if (difference >= 0.4 && difference < 0.7) {
             return "3"; // 报警等级：3
        } else if (difference >= 0.2 && difference < 0.4) {
             return "4"; // 报警等级：4
        } else {
             return "不报警"; // 不报警
        }
    }

    // 三元电池 Ix-Ii 的预警规则
    public static String getAlarmLevelForTernaryBatteryIxIi(double difference) {
        if (difference >= 3) {
             return "0"; // 报警等级：0
        } else if (difference >= 1 && difference < 3) {
             return "1"; // 报警等级：1
        } else if (difference >= 0.2 && difference < 1) {
             return "2"; // 报警等级：2
        } else {
             return "不报警"; // 不报警
        }
    }

    // 铁锂电池 Ix-Ii 的预警规则
    public static String getAlarmLevelForLithiumIronBatteryIxIi(double difference) {
        if (difference >= 1) {
             return "0"; // 报警等级：0
        } else if (difference >= 0.5 && difference < 1) {
             return "1"; // 报警等级：1
        } else if (difference >= 0.2 && difference < 0.5) {
             return "2"; // 报警等级：2
        } else {
             return "不报警"; // 不报警
        }
    }
}
