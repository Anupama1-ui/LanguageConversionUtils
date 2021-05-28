package com.example.langutils;

import android.content.Context;
import android.content.SharedPreferences;

public class
MySharedPreference {
    private static MySharedPreference gardenSharedPrfs;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String LOCAL_STORAGE = "com.mohit.voodoo.inventory.sharedPreference";

    private MySharedPreference(Context context) {
        this.sharedPreferences = context.getSharedPreferences(LOCAL_STORAGE, Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public static MySharedPreference getsharedprefInstance(Context con) {
        if (gardenSharedPrfs == null)
            gardenSharedPrfs = new MySharedPreference(con);
        return gardenSharedPrfs;
    }
    public String getLocale() {
        return sharedPreferences.getString("Locale","en" );
    }

    public void  setLocale(String s){
        editor.putString("Locale", s)
                .commit();
    }


}
