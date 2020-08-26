package com.pbilton.unit_conversion_V3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.pbilton.unit_conversion_V3.Time.*;

public class testTime {

    @Test
    public void testRatios() {
        Assertions.assertEquals(0.001D, Time.Millisecond.getRatio());
        Assertions.assertEquals(1D, Second.getRatio());
        Assertions.assertEquals(60D, Time.Minute.getRatio());
        Assertions.assertEquals(3600D, Time.Hour.getRatio());
        Assertions.assertEquals(86400D, Time.Day.getRatio());
        Assertions.assertEquals(31536000D, Time.Year.getRatio());
    }

    @Test
    public void testConvert_Seconds_Day(){
        var baseUnit = Time.Create(86400D,Second);
        var day = baseUnit.convertTo(Day);
        Assertions.assertEquals(baseUnit.getValueInSeconds(),day.getValueInSeconds());
        Assertions.assertEquals(1D,day.getValue());
    }

    @Test
    public void testConvert_Year_Seconds(){
        var baseUnit = Time.Create(1D,Year);
        var second = baseUnit.convertTo(Second);
        Assertions.assertEquals(baseUnit.getValueInSeconds(),second.getValueInSeconds());
        Assertions.assertEquals(31536000D,second.getValue());
    }

    @Test
    public void testConvert_Hour_Day(){
        var baseUnit = Time.Create(48D,Hour);
        var day = baseUnit.convertTo(Day);
        Assertions.assertEquals(baseUnit.getValueInSeconds(),day.getValueInSeconds());
        Assertions.assertEquals(2D,day.getValue());
    }

    @Test
    public void test_tryParse_Min_Hour(){
        var baseUnit = Time.tryParse("180m");
        var hour = baseUnit.tryParseUnit("hour");
        Assertions.assertEquals(3D,hour.getValue());
    }

    @Test
    public void fail_tryParse_Test() {
        var baseUnit = Time.tryParse("36000 secs");
        Assertions.assertNull(null,"Invalid unit input");
    }

}
