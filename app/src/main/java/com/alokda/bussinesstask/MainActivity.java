package com.alokda.bussinesstask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.alokda.bussinesstask.Azkary.ActivityAzkary;
import com.alokda.bussinesstask.MyLocation.MapsActivity;
import com.alokda.bussinesstask.Qbla.QblaActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    TextView tv_myLocation, tv_qbla, tv_azkary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tv_myLocation = (TextView) findViewById(R.id.tv_mainActivity_MyLocation);
        tv_azkary = (TextView) findViewById(R.id.tv_mainActivity_azkary);
        tv_qbla = (TextView) findViewById(R.id.tv_mainActivity_qbla);


        //init Listener
        tv_myLocation.setOnClickListener(this);
        tv_azkary.setOnClickListener(this);
        tv_qbla.setOnClickListener(this);

        //init Tag
        tv_myLocation.setTag(0);
        tv_azkary.setTag(1);
        tv_qbla.setTag(2);


    }

    @Override
    public void onClick(View v) {
        switch ((Integer) v.getTag()) {
            case 0:
                myLocation();
                break;
            case 1:
                myAzkary();
                break;
            case 2:
                myDirection();
                break;
            default:
                break;
        }

    }

    private void myDirection() {
        Intent intent = new Intent(getApplicationContext(), QblaActivity.class);
        startActivity(intent);
    }

    private void myAzkary() {
        Intent intent = new Intent(getApplicationContext(), ActivityAzkary.class);
        startActivity(intent);
    }

    private void myLocation() {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);

    }

    private void azkary() {

    }

    private void qbla() {

    }
}

