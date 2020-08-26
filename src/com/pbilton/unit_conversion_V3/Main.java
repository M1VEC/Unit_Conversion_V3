package com.pbilton.unit_conversion_V3;

import static com.pbilton.unit_conversion_V3.Distance.Meter;
import static com.pbilton.unit_conversion_V3.Distance.Mile;

public class Main {

    public static void main(String[] args) {

        var availableUnits =  Distance.AllUnits;
//        System.out.println(availableUnits[5].getShortName());
        var selected = Distance.Create(12000, availableUnits[5]);
        var result = selected.ConvertTo(Mile);
        System.out.println(result.getValue() + " " + result.getLongName());
    }
}
