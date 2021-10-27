package com.example.ex8;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import  android.widget.Toast;



public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    Button btnShowLocation;
    GPStrace gps;
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowLocation = (Button) findViewById(R.id.show_Location);
        btnShowLocation.setOnClickListener(v -> {

            // TODO Auto-generated method stub
            gps = new GPStrace(MainActivity.this);
            if (gps.canGetLocation()) {
                double latitude = gps.getLatitude();

                double longitude = gps.getLongitude();

                Toast.makeText(getApplicationContext(), "Your Location is \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
            } else {
                gps.showSettingAlert();
            }
        });
    }
}
