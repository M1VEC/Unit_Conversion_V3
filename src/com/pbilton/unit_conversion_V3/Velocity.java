package com.pbilton.unit_conversion_V3;

public class Velocity {
    //s = d / t
    //d = s * t
    //t = d / s
    private String ShortName;

    public static Velocity Mph = new Velocity(Distance.Mile, Time.Hour, "mph");
    public static Velocity Kph = new Velocity(Distance.Kilometer, Time.Hour, "kph");
    public static Velocity Ms = new Velocity(Distance.Meter, Time.Second, "ms");

    public Velocity(Distance distance, Time time, String shortName) {
        Distance Distance = distance;
        Time Time = time;
        ShortName = shortName;
    }

    public static Velocity[] AllUnits = new Velocity[]{
            Mph,
            Kph,
            Ms
    };
}
