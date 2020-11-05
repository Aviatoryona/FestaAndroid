package com.aviator.festa.abstracts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.aviator.festa.interfaces.BaseInterface;

public abstract class BaseActivity extends AppCompatActivity
        //extends LocationBaseActivity
         implements BaseInterface
{

    Location location;


    public Location getMyLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

//    @Override
//    public LocationConfiguration getLocationConfiguration() {
//        return Configurations.defaultConfiguration("Grant Permission", "Turn GPS on now?");
//    }
//
//    @Override
//    public void onLocationChanged(Location location) {
////        Toast.makeText(this, "New location " + location.getLatitude(), Toast.LENGTH_SHORT).show();
//        setLocation(location);
//    }
//
//    @Override
//    public void onLocationFailed(int type) {
//
//    }

    @Override
    public void NextActivity(@NonNull Class T) {
        NextActivity(new Intent(this, T));
    }

    @Override
    public void NextActivity(@NonNull Intent intent) {
        startActivity(intent);
    }

    @Override
    public void showView(@NonNull View view) {
        view.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideView(@NonNull View view) {
        view.setVisibility(View.GONE);
    }

    @Override
    public boolean checkPermission(@NonNull String perm) {
        return ActivityCompat.checkSelfPermission(this,perm)== PackageManager.PERMISSION_GRANTED;
//        return EasyPermissions.hasPermissions(this, perm);
    }

    @Override
    public boolean isConnected() {
        //check internet connection
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission")
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (!(networkInfo != null && networkInfo.isConnectedOrConnecting())) {
            return false;
        }
        return true;
    }

}
