package com.trichain.functionsphp.util;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import java.util.Calendar;

public class DateTimePicker {
    /*TODO Need to add this to gradle
            Under app->android
       compileOptions {
            sourceCompatibility JavaVersion.VERSION_1_8
            targetCompatibility JavaVersion.VERSION_1_8
         }
         Set editText focusable false in case using
    */
    public void showDateTimePicker(Context context) {
        final Calendar currentDate = Calendar.getInstance();
        new DatePickerDialog(context, (view, year, monthOfYear, dayOfMonth) -> {
            final String date1 = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth + " ";
            new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    String fDate = date1 + String.valueOf(hourOfDay) + ":" + minute;
                }
            }, currentDate.get(Calendar.HOUR_OF_DAY), currentDate.get(Calendar.MINUTE), false).show();
        }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();
    }
}
