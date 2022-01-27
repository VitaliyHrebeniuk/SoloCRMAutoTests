package com.api;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.valueOf;

public class Demo {
    public static void main(String[] args) {
        Date today;
        String result;
        SimpleDateFormat ym;
        SimpleDateFormat d;
        SimpleDateFormat hours;
        SimpleDateFormat minutes;
        String minutes_result;
        int minutest_result_int;
        String d_result;
        int d_result_int;
        today = new Date();

        ym = new SimpleDateFormat("y-M-");
        d = new SimpleDateFormat("d");
        d_result = valueOf(d.format(today));
        d_result_int = Integer.parseInt(valueOf(d_result))+ 2;
        hours = new SimpleDateFormat("H:");
        minutes = new SimpleDateFormat("m");
        minutes_result = valueOf(minutes.format(today));
        minutest_result_int = Integer.parseInt(valueOf(minutes_result))+ 2;

        result = ym.format(today)+ d_result_int  + " " + hours.format(today) + minutest_result_int;
        System.out.println(result);
        System.out.println(getDate2());
    }
    private static String getDate2(){
        Date today;
        String result;
        SimpleDateFormat ymd;
        SimpleDateFormat hours;
        SimpleDateFormat minutes;
        String minutes_result;
        int minutest_result_int;
        today = new Date();

        ymd = new SimpleDateFormat("y-M-d");
        hours = new SimpleDateFormat("H:");
        minutes = new SimpleDateFormat("m");
        minutes_result = valueOf(minutes.format(today));
        minutest_result_int = Integer.parseInt(valueOf(minutes_result))+ 2;
        result = ymd.format(today) + " " + hours.format(today) + minutest_result_int;
        return result;
    }
}
