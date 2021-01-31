// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry

    //Returns all entries on a given date in a single string
    public String lookupAllEntries (int d, int m, int y) { //method to pass in the dates
        ListIterator<Entry> iter = tr.listIterator();// declaring iter to go through list tr
        String result = "";
        while (iter.hasNext()) { //while loop to get entries in list
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)// if entry is for day entered -- add to result
                result = result + current.getEntry() + "\n";
        }
        if (result.equals("")) {
            result = "No entries found";
        }
        return result;
    } // lookUpAllEntries

   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord