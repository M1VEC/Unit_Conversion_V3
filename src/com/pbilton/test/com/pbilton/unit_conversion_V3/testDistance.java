package com.pbilton.unit_conversion_V3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.pbilton.unit_conversion_V3.Distance.*;

public class testDistance {

    private Distance targetDistance;

//    @Override
//    public String toString(){
//        return targetDistance;
//    }

    @Test
    public void testRatios(){
        Assertions.assertEquals(0.0001D,Distance.Millimeter.getRatio());
        Assertions.assertEquals(0.01D, Centimeter.getRatio());
        Assertions.assertEquals(0.0254D,Distance.Inch.getRatio());
        Assertions.assertEquals(0.30479999999999996D,Distance.Foot.getRatio());
        Assertions.assertEquals(0.9143999999999999D,Distance.Yard.getRatio());
        Assertions.assertEquals(1D,Distance.Meter.getRatio());
        Assertions.assertEquals(1000D, Kilometer.getRatio());
        Assertions.assertEquals(1609.344D,Distance.Mile.getRatio());
    }


    @Test
    public void testBaseUnitCM(){
    var baseUnit = Distance.Create(10,Centimeter);
        Assertions.assertEquals("cm" ,baseUnit.getShortName());
        Assertions.assertEquals("Centimeter" ,baseUnit.getLongName());
        Assertions.assertEquals(0.01D,baseUnit.getRatio());
        Assertions.assertEquals(0.1D,baseUnit.getValueInMeters());
    }

    @Test
    public void testBaseUnitFoot(){
        var baseUnit = Distance.Create(10,Foot);
        Assertions.assertEquals("ft" ,baseUnit.getShortName());
        Assertions.assertEquals("Foot" ,baseUnit.getLongName());
        Assertions.assertEquals(0.30479999999999996D,baseUnit.getRatio());
        Assertions.assertEquals(3.0479999999999996D,baseUnit.getValueInMeters());
    }

    @Test
    public void testTargetUnitYard(){
        var targetUnit = Distance.Create(10,Yard);
        Assertions.assertEquals("yd" ,targetUnit.getShortName());
        Assertions.assertEquals("Yard" ,targetUnit.getLongName());
        Assertions.assertEquals(0.9143999999999999D,targetUnit.getRatio());
        Assertions.assertEquals(9.143999999999998D,targetUnit.getValueInMeters());
    }

    @Test
    public void testTargetUnitKilometer(){
        var targetUnit = Distance.Create(2,Kilometer);
        Assertions.assertEquals("km" ,targetUnit.getShortName());
        Assertions.assertEquals("Kilometer" ,targetUnit.getLongName());
        Assertions.assertEquals(1000D,targetUnit.getRatio());
        Assertions.assertEquals(2000D,targetUnit.getValueInMeters());
    }
 }
