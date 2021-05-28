package com.example.langutils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton btnHindi, btnEnglish;
    Context context;
    Resources resources;
    MySharedPreference lang;
    Button check;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHindi = (RadioButton) findViewById(R.id.btnHindi);
        btnEnglish = (RadioButton) findViewById(R.id.btnEnglish);
        check = (Button) findViewById(R.id.check);


        MySharedPreference lang = MySharedPreference.getsharedprefInstance(this);

        btnEnglish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
//                    btnHindi.setEnabled(false);
                    btnHindi.setActivated(false);
                    btnHindi.setChecked(false);
                    lang.setLocale("en");
                    Log.d(TAG, lang.getLocale());
                }
            }
        });
        btnHindi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    btnEnglish.setActivated(false);
                    btnEnglish.setChecked(false);
                    lang.setLocale("hi");
                    Log.d(TAG, lang.getLocale());
                }
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
                finish();
            }
        });

    }
}


