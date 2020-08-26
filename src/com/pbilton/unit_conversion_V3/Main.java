package com.pbilton.unit_conversion_V3;

public class Main {

    public static void main(String[] args) {

        var availableUnits =  Distance.AllUnits;
        System.out.println(availableUnits[1].getShortName());

    }
}
