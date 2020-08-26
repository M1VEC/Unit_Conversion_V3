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
}
