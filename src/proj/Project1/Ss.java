package proj.Project1;

import sun.java2d.pipe.SpanShapeRenderer;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ss {
    public static void main(String[] args) {
        DateFormat date = DateFormat.getDateInstance(2);
        Calendar cals = Calendar.getInstance();
        String currentDate = date.format(cals.getTime());



        String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());


        DateFormat dateFormat = new SimpleDateFormat("MMM dd hh:mm aa");
        DateFormat day = new SimpleDateFormat("MMM dd");
        DateFormat time = new SimpleDateFormat("hh:mm aa");
        Date d = new Date();
        System.out.println(day.format(d) + " at " + time.format(d));

//        System.out.println(ts);
    }
}
