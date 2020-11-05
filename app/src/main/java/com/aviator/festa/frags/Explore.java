package com.aviator.festa.frags;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.aviator.festa.R;
import com.aviator.festa.abstracts.BaseFragment;
import com.aviator.festa.fsta.CustomCl;

/**
 * A simple {@link Fragment} subclass.
 */
public class Explore extends BaseFragment {


    public Explore() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.baseView = view;

        initViews();

        Initialize();
    }

    private Toolbar toolbar;
    private ImageView navIcon;
    private ListView listExplore;

    public void initViews() {
        toolbar = baseView.findViewById(R.id.toolbar);
        navIcon = baseView.findViewById(R.id.navIcon);
        listExplore = baseView.findViewById(R.id.listExplore);
    }



    @Override
    public void Initialize() {
        listExplore.setAdapter(new MyExploreAdapter());
    }

    // TODO: 5/26/2019
    class MyExploreAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 22;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = new CustomCl.Builder(getContext())
                        .getView(parent, R.layout.hori_main_event_model_large);
            }
            return convertView;
        }
    }
}
