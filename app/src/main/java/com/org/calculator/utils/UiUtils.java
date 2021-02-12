package com.org.calculator.utils;

import android.content.Context;
import android.widget.Toast;

public class UiUtils {

    public static void returnToast(Context context,String text){
        Toast.makeText(
                context,
                text,
                Toast.LENGTH_LONG).
                show();
    }

    public static void returnToast(Context context,int textId){
        Toast.makeText(
                context,
                textId,
                Toast.LENGTH_LONG).
                show();
    }
}
