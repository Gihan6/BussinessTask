package com.alokda.bussinesstask.MyLocation;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.alokda.bussinesstask.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        getLocation();

    }

    private void getLocation() {

        LocationTrack locationTrack = new LocationTrack(getApplicationContext());
        if (locationTrack.canGetLocation == true) {
            Location loc = locationTrack.getLocation();
            if (loc != null) {
                latLng = new LatLng(loc.getLatitude(), loc.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latLng).title("Your Place"));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17.0f));

            } else {
                LatLng sydney = new LatLng(-34, 151);
                mMap.addMarker(new MarkerOptions().position(sydney).title("Default "));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            }
            locationTrack.stopListener();
        }
    }

}
