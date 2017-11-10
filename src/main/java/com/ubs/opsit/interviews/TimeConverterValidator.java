package com.ubs.opsit.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeConverterValidator {
    private static final Logger log = LoggerFactory.getLogger(TimeConverterValidator.class);
    private static final String TIME_REGEX_PATTERN = "([0-1][0-9]|2[0-3]|24(?=:00:00)):([0-5][0-9]):([0-5][0-9])";

    public static boolean validateTime(String time) {
        try {
            if (time != null && !time.isEmpty()) {
                Pattern timeRegexPattern = Pattern.compile(TIME_REGEX_PATTERN);
                Matcher timeMatcher = timeRegexPattern.matcher(time);
                if (!timeMatcher.matches()) {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("Error occured in validating time: " + time + ", ", e);
            throw e;
        }
        return true;
    }
}
