package com.aviator.festa.interfaces;

import android.content.Intent;
import androidx.annotation.NonNull;
import android.view.View;

public interface BaseInterface {
    void Initialize();

    void NextActivity(@NonNull Class T);

    void NextActivity(@NonNull Intent intent);

    void showView(@NonNull View view);

    void hideView(@NonNull View view);

    boolean checkPermission(@NonNull String perm);

    boolean isConnected();
}
