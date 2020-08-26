package com.pbilton.unit_conversion_V3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class testMass {

    @Test
    public void testRatios() {
        Assertions.assertEquals(0.001D, Mass.Milligram.getRatio());
        Assertions.assertEquals(1D, Mass.Gram.getRatio());
        Assertions.assertEquals(1000D, Mass.Kilogram.getRatio());
        Assertions.assertEquals(1016046.92D, Mass.Ton.getRatio());
        Assertions.assertEquals(6350.293D, Mass.Stone.getRatio());
    }

    @Test
    public void test_tryParse_Gram_Kilogram(){
        var baseUnit = Mass.tryParse("5500g");
        var kg = baseUnit.tryParseUnit("kg");
        Assertions.assertEquals(5.5D,kg.getValue());
    }

    @Test
    public void test_tryParse_KG_Stone(){
        var baseUnit = Mass.tryParse("67kg");
        var st = baseUnit.tryParseUnit("stone");
        Assertions.assertEquals(10.550694275051562D,st.getValue());
    }

    @Test
    public void fail_tryParse_Test() {
        var baseUnit = Time.tryParse("450 tons");
        Assertions.assertNull(null,"Invalid unit input");
    }
}
