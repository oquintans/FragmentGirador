package com.example.android.fragmentgirador;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        detectFragment();
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentB fragment = (FragmentB) getFragmentManager().
                        findFragmentById(R.id.fragB);
                if (fragment == null || !fragment.isInLayout()) {
                    createIntent();
                }

            }
        });


    }

    public void detectFragment() {
        FragmentB fragment = (FragmentB) getFragmentManager().
                findFragmentById(R.id.fragB);
        if (fragment == null || !fragment.isInLayout()) {
            TextView tv = (TextView) findViewById(R.id.buttonFragA);
            tv.setText("PORTRAIT");

        } else {
            TextView tv = (TextView) findViewById(R.id.buttonFragA);
            tv.setText("LAND");
        }
    }

    public void createIntent() {

        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);


    }


}
