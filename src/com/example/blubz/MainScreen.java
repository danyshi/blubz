package com.example.blubz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by macalester on 2/19/14.
 */
public class MainScreen extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_layout);
    }

    public void goToMessage(View view) {
        Intent intent = new Intent(this, AddMessage.class);
        startActivity(intent);
    }

    public void goToPicture(View view) {
        // Add camera stuff here
    }

    public void goToReturnMessage(View view) {
        // Add return context here
    }
}