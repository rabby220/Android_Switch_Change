package com.fajlarabby.switchchange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.CompoundButton;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variable
        SwitchMaterial switchBtn = findViewById(R.id.switchBtn);
       // getSupportActionBar().setTitle("Light Mode vs Night Theme Mode");

        //switch theme mode per user wishes

        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //code here

                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    buttonView.setText("Night Mode");
                }else {

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    buttonView.setText("Light Mode");
                }
            }
        });

        //is night mode on?
        boolean isNightModeOn = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES;
        switchBtn.setChecked(isNightModeOn);

        if(isNightModeOn){
            switchBtn.setText("Night Mode");
        }else {
            switchBtn.setText("Light Mode");
        }

    }

            //remove eye flickers
            @Override
            public void recreate(){
                //super.recreate();
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                startActivity(getIntent());
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
}