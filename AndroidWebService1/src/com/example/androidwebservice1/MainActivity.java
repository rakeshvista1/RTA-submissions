package com.example.androidwebservice1;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.text.format.DateFormat;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		b1 = (Button) findViewById(R.id.button1);

		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// Get the current date and time
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy/MM/dd HH:mm:ss");
				String formattedDate = dateFormat.format(date).toString();

				// Get the current location
				LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				String mlocProvider;
				Criteria hdCrit = new Criteria();
				hdCrit.setAccuracy(Criteria.ACCURACY_COARSE);
				mlocProvider = locationManager.getBestProvider(hdCrit, true);
				Location currentLocation = locationManager
						.getLastKnownLocation(mlocProvider);
				// double currentLatitude = currentLocation.getLatitude();
				// double currentLongitude = currentLocation.getLongitude();

				double currentLatitude = 32.443223;
				double currentLongitude = 43.435536;
				final String recordToWrite = formattedDate + '\t'
						+ Double.toString(currentLatitude) + '\t'
						+ Double.toString(currentLongitude);

				String root = Environment.getExternalStorageDirectory()
						.toString();
				File myDir = new File(root + "/Data2");
				String fname = "GPS.txt";
				myDir.mkdirs();
				File file = new File(myDir, fname);
				if (file.exists())
					file.delete();
				try {
					FileOutputStream out = new FileOutputStream(file, true);
					out.write(recordToWrite.getBytes());
					out.flush();
					out.close();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Toast toast = new Toast(getBaseContext()); 
				toast.makeText(getBaseContext(), "File created", Toast.LENGTH_SHORT);
				toast.show();

			}
		});

		b2 = (Button) findViewById(R.id.button2);

		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		b3 = (Button) findViewById(R.id.button3);

		b3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		b4 = (Button) findViewById(R.id.button4);

		b4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		b5 = (Button) findViewById(R.id.button5);

		b5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
	}
}
