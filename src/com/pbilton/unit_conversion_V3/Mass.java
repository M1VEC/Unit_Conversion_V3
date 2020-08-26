package com.pbilton.unit_conversion_V3;

public class Mass {

    private String ShortName;
    private String LongName;
    private double Ratio;
    private double ValueInGrams;
    private double Value;

    public static Mass Gram = new Mass(1D,1D,"g","Gram");
    public static Mass Milligram = new Mass(1D,0.001D* Gram.Ratio,"mg","Milligram");
    public static Mass Kilogram = new Mass(1D,1000D* Gram.Ratio,"kg","Kilogram");
    public static Mass Ton = new Mass(1D,1016.04692D* Kilogram.Ratio,"Ton","Ton");
    public static Mass Stone = new Mass(1D,6.350293D* Kilogram.Ratio,"st","Stone");

    public static Mass Create(double value, Mass unit){
        return new Mass(value, unit.Ratio, unit.ShortName, unit.LongName);
    }

    public Mass(double value, double ratio, String shortName, String longName){
        Value = value;
        Ratio = ratio;
        ShortName = shortName;
        LongName = longName;
        ValueInGrams = Value * Ratio;
    }

    public Mass convertTo(Mass target){
        var targetMass = ValueInGrams / target.Ratio;
        return Create(targetMass, target);
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

    public double getValueInGrams() {
        return this.ValueInGrams;
    }

    public double getValue() {
        return this.Value;
    }

    public static Mass AllUnits[] = new Mass[]{
            Gram,
            Milligram,
            Kilogram,
            Ton,
            Stone
    };

    public static Mass tryParse(String input)  {
        int massValue = Integer.parseInt(input.replaceAll("[^0-9]", ""));
        String unitValue = input.replaceAll("[^a-z,A-Z]", "");

        boolean contains = false;
        Mass unit = null;

        for (Mass AllUnit : AllUnits) {
            if (unitValue.equalsIgnoreCase(AllUnit.LongName)|| unitValue.equalsIgnoreCase(AllUnit.ShortName)){
                unit = AllUnit;
                contains = true;
                break;
            }
        }

        if (contains == true)
            return Create(massValue, unit);
        else
            return null;
    }

    public Mass tryParseUnit(String input){
        String unitValue = input.replaceAll("[^a-z,A-Z]", "");

        boolean contains = false;
        Mass unit = null;

        for (Mass AllUnit : AllUnits) {
            if (unitValue.equalsIgnoreCase(AllUnit.LongName)|| unitValue.equalsIgnoreCase(AllUnit.ShortName)){
                unit = AllUnit;
                contains = true;
                break;
            }
        }

        if (contains == true)
            return convertTo(unit);
        else
            return null;
    }
}
