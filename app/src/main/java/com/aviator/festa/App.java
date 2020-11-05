package com.aviator.festa;

import android.app.Application;

import com.aviator.festa.fsta.FontsOverride;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class App extends Application {

    @Override
    public void onCreate() {
        FontsOverride.setDefaultFont(this, "SERIF","fonts/apercu_regular.otf");
        super.onCreate();
        Fabric.with(this, new Crashlytics());
    }
}
