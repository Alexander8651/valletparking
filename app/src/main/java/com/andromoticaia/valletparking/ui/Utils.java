package com.andromoticaia.valletparking.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public String getDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String currentDateandTime = simpleDateFormat.format(new Date());
        return  currentDateandTime;
    }


}
