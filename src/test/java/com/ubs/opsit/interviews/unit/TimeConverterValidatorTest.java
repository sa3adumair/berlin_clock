package com.ubs.opsit.interviews.unit;

import com.ubs.opsit.interviews.TimeConverterValidator;
import org.junit.Assert;
import org.junit.Test;

public class TimeConverterValidatorTest {

    @Test
    public void testValidateTime() {
        Assert.assertTrue(TimeConverterValidator.validateTime("23:59:59"));
    }

    @Test
    public void testInvalidateTime() {
        Assert.assertFalse(TimeConverterValidator.validateTime("24:00:01"));
    }

    @Test
    public void testValid24HourTime() {
        Assert.assertTrue(TimeConverterValidator.validateTime("24:00:00"));
    }
}
