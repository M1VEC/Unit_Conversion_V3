package com.pbilton.unit_conversion_V3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.pbilton.unit_conversion_V3.Distance.*;

public class testDistance {

    @Test
    public void testRatios(){
        Assertions.assertEquals(0.001D,Distance.Millimeter.getRatio());
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

    @Test
    public void testConvert_MM_M(){
        var baseUnit = Distance.Create(1000,Millimeter);
        var m = baseUnit.ConvertTo(Meter) ;
        Assertions.assertEquals(1.0,m.getValue());
    }

    @Test
    public void testConvert_CM_KM(){
        var baseUnit = Distance.Create(1000,Centimeter);
        var km = baseUnit.ConvertTo(Kilometer);
        Assertions.assertEquals(baseUnit.getValueInMeters(),km.getValueInMeters());
        Assertions.assertEquals(0.01,km.getValue());
    }

    @Test
    public void test_tryParse_CM_Meter(){
        var baseUnit = Distance.tryParse("1000 centimeter");
        var meter = baseUnit.tryParseUnit("meter");
        Assertions.assertEquals(10,meter.getValue());

    }

    @Test
    public void test_tryParse_MM_Mile(){
        var baseUnit = Distance.tryParse("25000mm");
        var mile = baseUnit.tryParseUnit("Mile");
        Assertions.assertEquals(0.01553427980593335,mile.getValue());
    }

    @Test
    public void fail_tryParse_Test() {
        var baseUnit = Distance.tryParse("25000 mn");
        Assertions.assertNull(null,"Invalid unit input");
    }

    @Test
    public void fail_tryParseUnit_CM_Yard(){
        var baseUnit = Distance.tryParse("5 cm");
        var mile = baseUnit.tryParseUnit("yards");
        Assertions.assertNull(null,"Invalid unit input");
    }
}
