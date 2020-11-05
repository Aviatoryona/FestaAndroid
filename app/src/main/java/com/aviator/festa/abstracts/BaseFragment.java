package com.aviator.festa.abstracts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import android.view.View;


import com.aviator.festa.interfaces.BaseInterface;

import java.util.HashMap;
import java.util.Map;


public abstract class BaseFragment extends Fragment implements BaseInterface {
    public View baseView;

    @Override
    public void NextActivity(@NonNull Class T) {
        NextActivity(new Intent(getContext(), T));
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

    /*
    dont use
     */
    @Override
    public boolean checkPermission(@NonNull String perm) {
        return ActivityCompat.checkSelfPermission(getContext(), perm) == PackageManager.PERMISSION_GRANTED;
//        if (getActivity() != null) {
//            return EasyPermissions.hasPermissions(getActivity(), perm);
//        }
//        return false;
    }

    @Override
    public boolean isConnected() {
        //check internet connection
        if (getActivity() != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            @SuppressLint("MissingPermission")
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (!(networkInfo != null && networkInfo.isConnectedOrConnecting())) {
                return false;
            }
            return true;
        }
        return false;
    }

    // TODO: 5/3/2019
    public Map<String, String> defaulParams(@NonNull String target, @NonNull String action) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("target", target);
        stringMap.put("action", action);
        return stringMap;
    }

}
