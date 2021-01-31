// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Calendar;
public class SprintEntry extends Entry {
    //private String name;
    //private Calendar dateAndTime;
    //private float distance;
    private int repetitions;
    private int recovery;

    public SprintEntry (String n, int d, int m, int y, int h, int min, int s, float dist, int rep, int rec) {
        //name = n;
        //Calendar inst = Calendar.getInstance();
        //inst.set(y,m-1,d,h,min,s);
        //dateAndTime = inst;
        //distance = dist;
        super(n, d, m, y, h, min, s, dist);
        repetitions = rep;
        recovery = rec;
    } //constructor

    public int getRepetitions () {
        return repetitions;
    }

    public int getRecovery () {
        return recovery;
    }

    public String getEntry () {
        String result = super.getName()+" sprinted " + getRepetitions() + "x" + (int)super.getDistance() + "m in "
                +super.getHour()+":"+super.getMin()+":"+ super.getSec() + " with " + getRecovery() + " minutes recovery on "
                +super.getDay()+"/"+super.getMonth()+"/"+super.getYear()+"\n";
        return result;
    } //getEntry

} // SprintEntry