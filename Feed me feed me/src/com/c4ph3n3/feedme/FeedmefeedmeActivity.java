package com.c4ph3n3.feedme;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FeedmefeedmeActivity extends Activity {
	
	/*Minimum time between update request for location*/
	final long minTimeLoc = 60*1000;
	
	/*Minimum distance between update request for location*/
	final int minDistLoc = 0;
	
	LocationManager LM;
	LocationListener locationListener;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*Button to trigger a restaurant request*/
        Button feedmeButton = (Button) findViewById(R.id.button1);
        
        /*Click listener for feedmeButton*/
        feedmeButton.setOnClickListener(
        	new View.OnClickListener() 
        	{
        		public void onClick(View v) 
        		{
        			System.exit(0);
        		}
        	}
        );
        
        /*LocationManager to handle GPS/Network location*/
        LM = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE); 
        
        /*Listener that handles location updates*/
        locationListener = new LocationListener() 
        	{
            	public void onLocationChanged(Location location) 
            	{
            		// Called when a new location is found by the network location provider.
            		//makeUseOfNewLocation(location);
            		Context context = getApplicationContext();
            		CharSequence text = "Hello toast!";
            		int duration = Toast.LENGTH_SHORT;

            		Toast toast = Toast.makeText(context, location.toString(), duration);
            		toast.show();
            	}

            	public void onStatusChanged(String provider, int status, Bundle extras) 
            	{
            		Context context = getApplicationContext();
            		CharSequence text = provider.toString() + " status:" + status;
            		int duration = Toast.LENGTH_SHORT;

            		Toast toast = Toast.makeText(context, text, duration);
            		toast.show();
            		
            	}
            
            	public void onProviderEnabled(String provider) 
            	{
            		Context context = getApplicationContext();
            		CharSequence text = provider.toString() + " enabled!";
            		int duration = Toast.LENGTH_SHORT;

            		Toast toast = Toast.makeText(context, text, duration);
            		toast.show();
            	}

            	public void onProviderDisabled(String provider) 
            	{
            		Context context = getApplicationContext();
            		CharSequence text = provider.toString() + " disabled!";
            		int duration = Toast.LENGTH_SHORT;

            		Toast toast = Toast.makeText(context, text, duration);
            		toast.show();
            	}
        	};

       LM.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTimeLoc, minDistLoc, locationListener);
          
    }
}