package com.example.mohit.helloworld;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends ListActivity {
    String[] names;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        names = getResources().getStringArray(R.array.friends);
        setListAdapter(new ArrayAdapter<>(this, R.layout.friend_item, names));
        Log.i(TAG,"onCreate()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop()");
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent in = new Intent(this, ShowMessage.class);

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        if (hour >= 6 && hour <= 12) {
            in.putExtra("message", "Good Morning " + names[(int) id] + "!");
            startActivity(in);
        } else if (hour > 12 && hour < 17) {
            in.putExtra("message", "Good Afternoon " + names[(int) id] + "!");
            startActivity(in);
        } else if (hour >= 17 && hour <= 21) {
            in.putExtra("message", "Good Evening " + names[(int) id] + "!");
            startActivity(in);
        } else if (hour > 21 && hour <= 23) {
            in.putExtra("message", "Good Night " + names[(int) id] + "!");
            startActivity(in);
        } else {
            in.putExtra("message", "Good Night " + names[(int) id] + "!");
            startActivity(in);
        }
    }

}
