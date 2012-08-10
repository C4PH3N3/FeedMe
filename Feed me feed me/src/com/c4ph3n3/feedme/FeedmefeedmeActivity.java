package com.c4ph3n3.feedme;


import android.app.Activity;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FeedmefeedmeActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button feedmeButton = (Button) findViewById(R.id.button1);
        feedmeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
           	 //finish();
                System.exit(0);
            }
        });
        
        LocationManager LM = (LocationManager) this.getSystemService(LOCATION_SERVICE); 
        
    }
}