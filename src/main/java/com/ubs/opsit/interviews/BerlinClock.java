package com.ubs.opsit.interviews;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class BerlinClock implements TimeConverter {

    private static final Logger log = LoggerFactory.getLogger(BerlinClock.class);

    @Override
    public String convertTime(String time) {
        log.info("Converting time " + time + " into Berlin Clock time");
        try {
            if (!TimeConverterValidator.validateTime(time))
                return TimeConstants.INVALID_TIME_PROVIDED_ERROR;

            String[] splitTime = time.split(TimeConstants.COLON);
            String fiveHourLamps = TimeConverterUtil.switchOnFiveHourLamps(splitTime[0]);
            String oneHourLamps = TimeConverterUtil.switchOnOneHourLamps(splitTime[0]);
            String fiveMinuteLamps = TimeConverterUtil.switchOnFiveMinuteLamps(splitTime[1]);
            String oneMinuteLamps = TimeConverterUtil.switchOnOneMinuteLamps(splitTime[1]);
            String secondsLamps = TimeConverterUtil.switchOnSecondsLamp(splitTime[2]);

            return StringUtils.join(Arrays.asList(secondsLamps, fiveHourLamps, oneHourLamps, fiveMinuteLamps, oneMinuteLamps),
                    TimeConstants.LINE_SEPARATOR);
        } catch (Exception e) {
            log.error("Exception in converting time " + time + ", ", e);
            throw e;
        }
    }
}
