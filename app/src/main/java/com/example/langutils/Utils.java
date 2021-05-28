package com.example.langutils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import androidx.annotation.NonNull;

import java.util.Locale;

public class Utils {
    @NonNull
    public static Resources getLocalizedResources(Context context, Locale desiredLocale) {
        Configuration configuration = context.getResources().getConfiguration();
        configuration = new Configuration(configuration);
        configuration.setLocale(desiredLocale);
        Context localizedContext = context.createConfigurationContext(configuration);
        return localizedContext.getResources();

    }
    public static Context updateLocale(Context context) {
        MySharedPreference pref = MySharedPreference.getsharedprefInstance(context);
       String lang= pref.getLocale();
        Configuration configuration = context.getResources().getConfiguration();
        configuration = new Configuration(configuration);
        configuration.setLocale(new Locale(lang));
        return context.createConfigurationContext(configuration);

    }
}
