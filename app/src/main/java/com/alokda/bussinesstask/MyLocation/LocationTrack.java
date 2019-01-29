package com.alokda.bussinesstask.MyLocation;
import android.Manifest;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;

import com.google.android.gms.location.places.Place;

public class LocationTrack extends Service implements LocationListener {
    private static final int MY_PERMISSIONS_REQUEST_FINE_LOCATION = 123;
    private final Context mContext;
    boolean checkGPS = false;
    boolean checkNetwork = false;
    public boolean canGetLocation = false;
    Location loc;
    Place place;
    double latitude;
    double longitude;
    protected LocationManager locationManager;

    public LocationTrack(Context mContext) {
        this.mContext = mContext;
        getLocation();
    }

    public Location getLocation() {


        try {
            locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
            // get GPS status
            checkGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            checkNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
                if (!checkGPS) {
                    this.canGetLocation = false;
                    if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions((Activity) mContext, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_FINE_LOCATION);
                    }else {
                         showSettingsAlert();
                    }
                } else {
                    this.canGetLocation = true;
                    loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                }

        } catch (Exception e) {

        }

        return loc;
    }


    public double getLongitude() {
        if (loc != null) {
            longitude = loc.getLongitude();
        }
        return longitude;
    }

    public double getLatitude() {
        if (loc != null) {
            latitude = loc.getLatitude();
        }
        return latitude;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
        alertDialog.setTitle("GPS is not Enabled!");
        alertDialog.setMessage("Please Enable Gps ");

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                mContext.startActivity(intent);
                dialog.cancel();


            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }


    public void stopListener() {
        if (locationManager != null) {

            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            locationManager.removeUpdates(LocationTrack.this);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}



