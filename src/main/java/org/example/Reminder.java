package main.java.org.example;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
public class Reminder {

    private String description;
    private Calendar date;

    public Reminder(String lineFromCsv) {
        String[] line = lineFromCsv.split(";");
        String[] date = line[0].split(":");

        Calendar now = Calendar.getInstance();

        this.date = Calendar.getInstance();

        try {
            if(date.length==1) {

                int m = now.get(Calendar.MONTH)+1;
                String mon = String.valueOf(m);
                if(mon.length()==1)
                {
                    mon="0"+mon;
                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d = sdf.parse(now.get(Calendar.YEAR)+"-"+mon+"-"+date[0]);
                this.date.setTime(d);

                while (this.date.before(now)) {
                    this.date.add(Calendar.MONTH,1);
                }

            }
            else if(date.length==2) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d = sdf.parse(now.get(Calendar.YEAR)+"-"+date[1]+"-"+date[0]);
                this.date.setTime(d);

                while (this.date.before(now)) {
                    this.date.add(Calendar.YEAR,1);
                }

            }
            else if (date.length==3){

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d = sdf.parse(date[2]+"-"+date[1]+"-"+date[0]);
                this.date.setTime(d);

            }
        }
        catch (Exception e){

        }

        this.description = line[1];
    }

    public String toString()
    {
        return this.date.get(Calendar.DAY_OF_MONTH) + "-" + (this.date.get(Calendar.MONTH)+1) + "-" + this.date.get(Calendar.YEAR) + " " + description;
    }
}
