package com.pbilton.unit_conversion_V3;

public class Distance {

    private String ShortName;
    private String LongName;
    private double Ratio;
    private double ValueInMeters;
    private double Value;

    public static Distance Millimeter = new Distance(1D, 0.001D, "mm", "Millimeter");
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

    public Distance ConvertTo(Distance target) {
        var targetDistance = ValueInMeters / target.Ratio;
        return Create(targetDistance, target);
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

    public double getValue() {
        return this.Value;
    }

    public static Distance[] AllUnits = new Distance[]{
            Millimeter,
            Centimeter,
            Inch,
            Foot,
            Yard,
            Meter,
            Kilometer,
            Mile
    };

    public static Distance tryParse(String input)  {
        int distanceValue = Integer.parseInt(input.replaceAll("[^0-9]", ""));
        String unitValue = input.replaceAll("[^a-z,A-Z]", "");

        boolean contains = false;
        Distance unit = null;

        for (Distance AllUnit : AllUnits) {
            if (unitValue.equalsIgnoreCase(AllUnit.LongName)|| unitValue.equalsIgnoreCase(AllUnit.ShortName)){
                unit = AllUnit;
                contains = true;
                break;
            }
        }

        if (contains == true)
            return Create(distanceValue, unit);
        else
            return null;
    }

    public Distance tryParseUnit(String input){
        String unitValue = input.replaceAll("[^a-z,A-Z]", "");

        boolean contains = false;
        Distance unit = null;

        for (Distance AllUnit : AllUnits) {
            if (unitValue.equalsIgnoreCase(AllUnit.LongName)|| unitValue.equalsIgnoreCase(AllUnit.ShortName)){
                unit = AllUnit;
                contains = true;
                break;
            }
        }

        if (contains == true)
            return ConvertTo(unit);
        else
            return null;
    }
}