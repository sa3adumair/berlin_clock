package com.ubs.opsit.interviews.unit;

import com.ubs.opsit.interviews.TimeConverterUtil;
import org.junit.Assert;
import org.junit.Test;

public class TimeConverterUtilTest {

    @Test
    public void testSwitchOnFiveHourLamps() {
        Assert.assertEquals(TimeConverterUtil.switchOnFiveHourLamps("16"), "RRRO");
    }

    @Test
    public void testSwitchOnIncorrectFiveHourLamps() {
        Assert.assertNotEquals(TimeConverterUtil.switchOnFiveHourLamps("16"), "RROO");
    }

    @Test
    public void testSwitchOnOneHourLamps() {
        Assert.assertEquals(TimeConverterUtil.switchOnOneHourLamps("09"), "RRRR");
    }

    @Test
    public void testSwitchOnIncorrectOneHourLamps() {
        Assert.assertNotEquals(TimeConverterUtil.switchOnOneHourLamps("09"), "ROOO");
    }

    @Test
    public void testSwitchOnFiveMinuteLamps() {
        Assert.assertEquals(TimeConverterUtil.switchOnFiveMinuteLamps("19"), "YYROOOOOOOO");
    }

    @Test
    public void testSwitchOnIncorrectFiveMinuteLamps() {
        Assert.assertNotEquals(TimeConverterUtil.switchOnFiveMinuteLamps("16"), "YYRYOOOOOOO");
    }

    @Test
    public void testSwitchOnOneMinuteLamps() {
        Assert.assertEquals(TimeConverterUtil.switchOnOneMinuteLamps("23"), "YYYO");
    }

    @Test
    public void testSwitchOnIncorrectOneMinuteLamps() {
        Assert.assertNotEquals(TimeConverterUtil.switchOnOneMinuteLamps("23"), "YOOO");
    }

    @Test
    public void testSwitchOnSecondsLamp() {
        Assert.assertEquals(TimeConverterUtil.switchOnSecondsLamp("59"), "O");
    }

    @Test
    public void testSwitchOnIncorrectSecondsLamp() {
        Assert.assertNotEquals(TimeConverterUtil.switchOnSecondsLamp("06"), "O");
    }
}
