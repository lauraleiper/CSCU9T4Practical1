package com.stir.cscu9t4practical1;

import java.util.Calendar;
public class CycleEntry extends Entry {
    //private String name;
    //private Calendar dateAndTime;
    //private float distance;
    private String terrain;
    private String tempo;

    public CycleEntry (String n, int d, int m, int y, int h, int min, int s, float dist, String terr, String temp) {
        //name = n;
        //Calendar inst = Calendar.getInstance();
        //inst.set(y,m-1,d,h,min,s);
        //dateAndTime = inst;
        //distance = dist;
        super(n, d, m, y, h, min, s, dist);
        terrain = terr;
        tempo = temp;
    } //constructor


    public String getTerrain () {
        return terrain;
    }

    public String getTempo () {
        return tempo;
    }

    public String getEntry () {
        String result = super.getName()+" cycled " + super.getDistance() + " km in "
                +super.getHour()+":"+super.getMin()+":"+ super.getSec() + " on "
                +super.getDay()+"/"+super.getMonth()+"/"+super.getYear()+ " on " + getTerrain()
                + " at " + getTempo() + " tempo" + "\n";
        return result;
    } //getEntry

} // CycleEntry

