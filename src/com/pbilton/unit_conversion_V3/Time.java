package com.pbilton.unit_conversion_V3;

public class Time {
    private String ShortName;
    private String LongName;
    private double Ratio;
    private double ValueInSeconds;
    private double Value;

    public static Time Seconds = new Time(1D,1D,"secs","Seconds");
    
    public Time (double value, double ratio, String shortName, String longName){
        Value = value;
        Ratio = ratio;
        ShortName = shortName;
        LongName= longName;
        ValueInSeconds = Value * Ratio;
    }

}
