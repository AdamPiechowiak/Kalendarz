package org.example;

import main.java.org.example.Reminder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

public class Main {
    public static void main(String[] args) {


        ArrayList<Reminder> reminders = readFile("dane.csv");

        ArrayList<Reminder> remindersToDisplay = new ArrayList<Reminder>();

        Calendar now = Calendar.getInstance();

        now.add(Calendar.DAY_OF_MONTH,5);

        for(Reminder r : reminders)
        {
            if(r.getDate().before(now))
            {
                remindersToDisplay.add(r);
            }

        }

        if(!remindersToDisplay.isEmpty())
        {
            showMessageDialog(null, formatArray(remindersToDisplay),"Przypomnienie",2);
        }
    }



    public static ArrayList<Reminder> readFile(String filePath)
    {
        ArrayList<Reminder> reminders = new ArrayList<Reminder>();

        File file = new File(filePath);

        try {
            Scanner skaner = new Scanner(file);
            while (skaner.hasNextLine()) {
                Reminder r = new Reminder(skaner.nextLine());
                reminders.add(r);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak Pliku do odczytania!");
        }

        return reminders;
    }

    public static String formatArray(ArrayList<Reminder> reminders)
    {
        String message="";

        for(Reminder r : reminders)
        {
            message = message + "\n" + r;

        }

        return message;
    }

}

