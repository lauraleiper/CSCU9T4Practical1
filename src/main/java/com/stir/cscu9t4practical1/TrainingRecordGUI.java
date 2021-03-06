// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField where = new JTextField(10);// For swim
    private JTextField rep = new JTextField(3);// For Sprint
    private JTextField rec = new JTextField(2);// For Sprint
    private JTextField terr = new JTextField(10);// For Cycle
    private JTextField tempo = new JTextField(15);// For Cycle
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labwhere = new JLabel(" Swim Location: ");
    private JLabel labrep = new JLabel(" Sprint Repetitions: ");
    private JLabel labrec = new JLabel(" Sprint Recovery time (min): ");
    private JLabel labterr = new JLabel(" Cycle Terrain: ");
    private JLabel labtempo = new JLabel(" Cycle Tempo: ");
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find all by date");// New button FindAllByDate added
    private JButton RemoveEntry = new JButton("Remove entries"); // button to remove data
    private JButton addSwim = new JButton("Add swimming session");//button for add swim
    private JButton addCycle = new JButton("Add cycling session");//button for add cycle
    private JButton addSprint = new JButton("Add sprint session");//button for add sprint


    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labwhere);
        add(where);
        where.setEditable(true);
        add(labrep);
        add(rep);
        rep.setEditable(true);
        add(labrec);
        add(rec);
        rec.setEditable(true);
        add(labterr);
        add(terr);
        terr.setEditable(true);
        add(labtempo);
        add(tempo);
        tempo.setEditable(true);
        add(addR);
        addR.addActionListener(this);
        add(addSwim);
        addSwim.addActionListener(this);// adding button swim
        add(addCycle);
        addCycle.addActionListener(this);// adding button cycle
        add(addSprint);
        addSprint.addActionListener(this);// adding button sprint
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);// adding button for FindAllByDate
        findAllByDate.addActionListener(this);// make button use this class
        add(RemoveEntry);
        RemoveEntry.addActionListener(this);//adding button for removing entries
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";

        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == addSwim) {
            message = addEntry("swim");
        }
        if (event.getSource() == addCycle) {
            message = addEntry("cycle");
        }
        if (event.getSource() == addSprint) {
            message = addEntry("sprint");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = findAllDate(); //statement added to actionPerformed to handle FindAllByDate button
        }
        if (event.getSource() == RemoveEntry) {
            message = RemoveEntry();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        Entry e; // declare entry e

        if(what.equals("swim")) {
            String w = where.getText();
            e = new SwimEntry(n, d, m, y, h, mm, s, km, w);
        } else if(what.equals("cycle")) {
            String c = terr.getText();
            String c2 = tempo.getText();
            e = new CycleEntry(n, d, m, y, h, mm, s, km, c, c2);
        } else if(what.equals("sprint")) {
            int s1 = Integer.parseInt(rep.getText());
            int s2 = Integer.parseInt(rec.getText());
            e = new SprintEntry(n, d, m, y, h, mm, s, km, s1, s2);
        } else {
            e = new Entry(n, d, m, y, h, mm, s, km);
        }
        myAthletes.addEntry(e);
        return message;
    }

    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public String findAllDate() { //reading strings from all records from Training Record for a day
        //outputArea.setText("Not implemented yet");//place holder for FindAllByDate button
        int m = Integer.parseInt(month.getText());// receiving month integer
        int d = Integer.parseInt(day.getText());// receiving day integer
        int y = Integer.parseInt(year.getText());// receiving year integer
        outputArea.setText("looking up all records ...");// output text
        String message = myAthletes.lookupEntries(d, m, y);// get data
        return message;// return data
    }
    public String RemoveEntry() {
        System.out.println("Removing entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());

        return myAthletes.RemoveEntry(n, d, m, y);
    }


    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        where.setText("");
        rep.setText("");
        rec.setText("");
        terr.setText("");
        tempo.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

