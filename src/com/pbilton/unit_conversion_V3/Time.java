package com.pbilton.unit_conversion_V3;

public class Time {
    private String ShortName;
    private String LongName;
    private double Ratio;
    private double ValueInSeconds;
    private double Value;

    public static Time Millisecond = new Time(1D, 0.001D,"ms","Milliseconds");
    public static Time Second = new Time(1D,1D,"s","Seconds");
    public static Time Minute = new Time(1D, 60D, "m", "Minute");
    public static Time Hour = new Time(1D,60D* Minute.Ratio,"hr","Hour");
    public static Time Day = new Time(1D,24D* Hour.Ratio,"d","Day");
    public static Time Year = new Time(1D,365D* Day.Ratio,"y","Year");

    public static Time Create(double value, Time  unit){
        return new Time(value, unit.Ratio, unit.ShortName, unit.LongName);
    }

    public Time (double value, double ratio, String shortName, String longName){
        Value = value;
        Ratio = ratio;
        ShortName = shortName;
        LongName= longName;
        ValueInSeconds = Value * Ratio;
    }

    public Time convertTo(Time target){
        var targetTime = ValueInSeconds / target.Ratio;
        return Create(targetTime, target);
    }

    public double getRatio(){
        return this.Ratio;
    }

    public String getShortName() {
        return this.ShortName;
    }

    public String getLongName() {
        return this.LongName;
    }

    public double getValueInSeconds() {
        return this.ValueInSeconds;
    }

    public double getValue() {
        return this.Value;
    }

    public static Time AllUnits[] = new Time[]{
            Millisecond,
            Second,
            Minute,
            Hour,
            Day,
            Year,
    };

}
