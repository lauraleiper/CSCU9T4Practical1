// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Calendar;
public class SwimEntry extends Entry {
    //private String name;
    //private Calendar dateAndTime;
    //private float distance;
    private String location;// new attribute for swim entry class for location

    public SwimEntry (String n, int d, int m, int y, int h, int min, int s, float dist, String where) {
        //name = n;
        //Calendar inst = Calendar.getInstance();
        //inst.set(y,m-1,d,h,min,s);
        //dateAndTime = inst;
        //distance = dist;
        super(n, d, m, y, h, min, s, dist);
        location = where;// new variable location to find location
    } //constructor

    public String getWhere () {
        if (location.equals("pool")) {
            return "in a pool";
        } else {
            return location;
        }
    }//getWhere -- new method get where

    public String getEntry () {
        String result = super.getName()+" swam " + super.getDistance() + " km " + getWhere() + " in "
                +super.getHour()+":"+super.getMin()+":"+ super.getSec() + " on "
                +super.getDay()+"/"+super.getMonth()+"/"+super.getYear()+ "\n";
        return result;
    } //getEntry

} // SwimEntry