package com.pbilton.unit_conversion_V3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.pbilton.unit_conversion_V3.Distance.*;

public class testTime {

    @Test
    public void testRatios() {
        Assertions.assertEquals(0.001D, Time.Millisecond.getRatio());
        Assertions.assertEquals(1D, Time.Second.getRatio());
        Assertions.assertEquals(60D, Time.Minute.getRatio());
        Assertions.assertEquals(3600D, Time.Hour.getRatio());
        Assertions.assertEquals(86400D, Time.Day.getRatio());
        Assertions.assertEquals(31536000D, Time.Year.getRatio());

    }
}
