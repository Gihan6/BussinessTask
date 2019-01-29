package com.alokda.bussinesstask.Qbla;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.alokda.bussinesstask.MyLocation.LocationTrack;
import com.alokda.bussinesstask.R;
import com.google.android.gms.maps.model.LatLng;

public class QblaActivity extends AppCompatActivity {

    LatLng latLng;

    ImageView iv_arrow, iv_compass;
    TextView tv_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qbla);

        initView();
        getLocation();
        QiblaDirectionCompass obj = new QiblaDirectionCompass(getApplicationContext(), iv_compass, iv_arrow, tv_data, latLng.longitude, latLng.latitude);

    }

    private void initView() {
        iv_arrow = (ImageView) findViewById(R.id.needle);
        iv_compass = (ImageView) findViewById(R.id.imageCompass);
        tv_data = (TextView) findViewById(R.id.tv_qbla);
    }

    private void getLocation() {

        LocationTrack locationTrack = new LocationTrack(getApplicationContext());
        if (locationTrack.canGetLocation == true) {
            Location loc = locationTrack.getLocation();
            if (loc != null) {
                latLng = new LatLng(loc.getLatitude(), loc.getLongitude());
            } else {
                latLng = new LatLng(-34, 151);

            }
            locationTrack.stopListener();
        }
    }


}
