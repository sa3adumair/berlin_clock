package com.ubs.opsit.interviews.unit;

import com.ubs.opsit.interviews.BerlinClock;
import com.ubs.opsit.interviews.TimeConverter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class BerlinClockTest {

    TimeConverter converter = new BerlinClock();
    private String time;
    private String convertedTime;

    public BerlinClockTest(String time, String convertedTime) {
        this.time = time;
        this.convertedTime = convertedTime;
    }

    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"24:00:00", "Y\n" +
                             "RRRR\n" +
                             "RRRR\n" +
                             "OOOOOOOOOOO\n" +
                             "OOOO"},
                {"23:59:59", "O\n" +
                             "RRRR\n" +
                             "RRRO\n" +
                             "YYRYYRYYRYY\n" +
                             "YYYY"},
                {"13:17:01", "O\n" +
                             "RROO\n" +
                             "RRRO\n" +
                             "YYROOOOOOOO\n" +
                             "YYOO"},
                {"00:00:00", "Y\n" +
                             "OOOO\n" +
                             "OOOO\n" +
                             "OOOOOOOOOOO\n" +
                             "OOOO"}
        });
    }

    @Test
    public void testBerlinClockForValidTime() {
        Assert.assertEquals(converter.convertTime(time), convertedTime);

    }

    @Test
    public void testBerlinClockForInvalidTime() {
        Assert.assertEquals(converter.convertTime("24:01:01"), "Invalid time provided.");
    }
}
