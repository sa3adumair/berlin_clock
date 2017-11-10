package com.ubs.opsit.interviews;

import org.apache.commons.lang.StringUtils;

public class TimeConverterUtil {

    public static String switchOnFiveHourLamps(String hours) {
        int numberOfFiveHourLampsToLit = Integer.parseInt(hours) / 5;
        return litLampsForFiller(TimeConstants.FOUR_LAMPS_DIGITS, TimeConstants.RED_LAMP, numberOfFiveHourLampsToLit, false);
    }

    public static String switchOnOneHourLamps(String hours) {
        int numberOfOneHourLampsToLit = Integer.parseInt(hours) % 5;
        return litLampsForFiller(TimeConstants.FOUR_LAMPS_DIGITS, TimeConstants.RED_LAMP, numberOfOneHourLampsToLit, false);

    }

    public static String switchOnFiveMinuteLamps(String minute) {
        int numberOfFiveMinuteLampsToLit = Integer.parseInt(minute) / 5;
        String numberOfFiveMinuteLamps = litLampsForFiller(TimeConstants.ELEVEN_LAMPS_DIGITS, TimeConstants.YELLOW_LAMP,
                numberOfFiveMinuteLampsToLit, true);
        return numberOfFiveMinuteLamps;
    }

    public static String switchOnOneMinuteLamps(String minute) {
        int numberOfOneMinuteLampsToLit = Integer.parseInt(minute) % 5;
        return litLampsForFiller(TimeConstants.FOUR_LAMPS_DIGITS, TimeConstants.YELLOW_LAMP, numberOfOneMinuteLampsToLit, false);

    }

    public static String switchOnSecondsLamp(String second) {
        return (Integer.parseInt(second) % 2) == 0 ? TimeConstants.YELLOW_LAMP : TimeConstants.OFF_LAMP;
    }

    private static String litLampsForFiller(int length, String filler, int numberOfLampsToLit, boolean litQuarterMinuteFlag) {
        String lamps = StringUtils.repeat(TimeConstants.OFF_LAMP, length);
        lamps = StringUtils.replace(lamps, TimeConstants.OFF_LAMP, filler, numberOfLampsToLit);
        if (litQuarterMinuteFlag)
            lamps = litQuarterMinuteLamp(lamps, numberOfLampsToLit);
        return lamps;
    }

    private static String litQuarterMinuteLamp(String lamps, int numberOfLampsToLit) {
        int numberOfQuarterLampsToLit = numberOfLampsToLit / 3;
        if (numberOfQuarterLampsToLit > 0) {
            for (int i = 1 ; i <= numberOfQuarterLampsToLit ; i++) {
                lamps = StringUtils.overlay(lamps, TimeConstants.RED_LAMP, (i * 3 -1), i * 3);
            }
        }
        return lamps;
    }
}
