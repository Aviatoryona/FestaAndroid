package com.aviator.festa.frags;


import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aviator.festa.R;
import com.aviator.festa.abstracts.BaseFragment;
import com.aviator.festa.abstracts.BaseModel;
import com.aviator.festa.adapters.EventsRecAdapter;
import com.aviator.festa.fsta.MyDecorator;
import com.aviator.festa.models.MainEventsModel;

import java.util.ArrayList;

import reubensousa.GravitySnapHelper;
import wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import wasabeef.recyclerview.animators.ScaleInAnimator;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends BaseFragment {

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.baseView = view;

        initViews();

        Initialize();
    }

    private ImageView imgMainImg;
    private Toolbar toolbar;
    private ImageView navIcon;
    private SwipeRefreshLayout swipeRefresh;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;

    public void initViews() {
        imgMainImg = baseView.findViewById(R.id.imgMainImg);
        toolbar = baseView.findViewById(R.id.toolbar);
        navIcon = baseView.findViewById(R.id.navIcon);
        swipeRefresh = baseView.findViewById(R.id.swipeRefresh);
        recyclerView1 = baseView.findViewById(R.id.recyclerView1);
        recyclerView2 = baseView.findViewById(R.id.recyclerView2);
        recyclerView3 = baseView.findViewById(R.id.recyclerView3);
    }


    @Override
    public void Initialize() {
        swipeRefresh.setOnRefreshListener(() -> {
            swipeRefresh.setRefreshing(false);
            LoadData(recyclerView1);
            LoadData(recyclerView2);
            LoadData(recyclerView3);
        });
        initRec(recyclerView1);
        initRec(recyclerView2);
        initRec(recyclerView3);

        LoadData(recyclerView1);
        LoadData(recyclerView2);
        LoadData(recyclerView3);
    }


    void initRec(@NonNull RecyclerView recyclerView) {
        recyclerView.setItemAnimator(new ScaleInAnimator());
        recyclerView.addItemDecoration(new MyDecorator(8));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        new GravitySnapHelper(Gravity.START)
                .attachToRecyclerView(recyclerView);
    }

    void LoadData(@NonNull RecyclerView recyclerView) {
        new Handler().postDelayed(() -> {
            recyclerView.setAdapter(new AlphaInAnimationAdapter(
                    new EventsRecAdapter(Home.this, getArrayList())
            ));
        }, 4000);
    }

    ArrayList<BaseModel> getArrayList() {
        ArrayList<BaseModel> arrayList = new ArrayList<>();
        arrayList.add(new MainEventsModel(R.mipmap.events));
        arrayList.add(new MainEventsModel(R.mipmap.dia));
        arrayList.add(new MainEventsModel(R.mipmap.chris));
        arrayList.add(new MainEventsModel(R.mipmap.dia));
        arrayList.add(new MainEventsModel(R.mipmap.events));
        arrayList.add(new MainEventsModel(R.mipmap.chris));
        return arrayList;
    }
}
