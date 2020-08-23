package com.pbilton.unit_conversion_V3;


import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Distance {

    private String ShortName;
    private String LongName;
    private double Ratio;
    private double ValueInMeters;
    private double Value;

    public static Distance Millimeter = new Distance(1D, 0.0001D, "mm", "Millimeter");
    public static Distance Centimeter = new Distance(1D, 0.01D, "cm", "Centimeter");
    public static Distance Inch = new Distance(1D, 0.0254D, "i", "Inch");
    public static Distance Foot = new Distance(1D, 12D * Inch.Ratio, "ft", "Foot");
    public static Distance Yard = new Distance(1D, 3D * Foot.Ratio, "yd", "Yard");
    public static Distance Meter = new Distance(1D, 1D, "m", "Meter");
    public static Distance Kilometer = new Distance(1D, 1000D, "km", "Kilometer");
    public static Distance Mile = new Distance(1D, 1609.344D, "mi", "Mile");

    public static Distance Create(double value, Distance unit) {
        return new Distance(value, unit.Ratio, unit.ShortName, unit.LongName);
    }

    public Distance(double value, double ratio, String shortName, String longName) {
        Value = value;
        Ratio = ratio;
        ShortName = shortName;
        LongName = longName;
        ValueInMeters = Value * Ratio;
    }

    public double getRatio() {
        return this.Ratio;
    }

    public String getShortName() {
        return this.ShortName;
    }

    public String getLongName() {
        return this.LongName;
    }

    public double getValueInMeters() {
        return this.ValueInMeters;
    }

    public Distance ConvertTo(Distance target) {
        var targetDistance = ValueInMeters / target.Ratio;
        return Create(targetDistance, target);
    }

    @Override
    public String toString(){
        return String.valueOf(ValueInMeters);
    }

    public static Distance[] AllUnits = new Distance[]
            {
                    Millimeter,
                    Centimeter,
                    Inch,
                    Foot,
                    Yard,
                    Meter,
                    Kilometer,
                    Mile
            };
}

//
//    public static boolean TryParse(String input){
//        String pattern = "^(?<distance>[+-]?(([1-9][0-9]*)?[0-9](\\.[0-9]*)?|\\.[0-9]+))(\\s*)$";
//        Pattern regex = Pattern.compile(pattern);
//
//        boolean doublePart = Pattern.matches("km",input);
//        var unitPart = Pattern.matches("[^a-zA-Z]",input);
//        var temp = pattern.matches(input);
//
//        boolean unit = doublePart;
//
//        distance = Create(value, unit);
//        return temp;
//
//    }