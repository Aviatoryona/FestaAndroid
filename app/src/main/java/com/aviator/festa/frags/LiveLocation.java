package com.aviator.festa.frags;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aviator.festa.R;
import com.aviator.festa.abstracts.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveLocation extends BaseFragment {


    public LiveLocation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_location, container, false);
    }

    @Override
    public void Initialize() {

    }
}
