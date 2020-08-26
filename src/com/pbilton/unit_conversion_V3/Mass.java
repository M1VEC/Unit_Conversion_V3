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

    public double getRatio() {
        return this.Ratio;
    }

}
