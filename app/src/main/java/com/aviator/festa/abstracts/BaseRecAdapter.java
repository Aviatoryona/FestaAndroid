package com.aviator.festa.abstracts;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aviator.festa.models.MainEventsModel;
import com.aviator.festa.vholders.EventsRecVHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public abstract class BaseRecAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context context;
    protected BaseActivity activity;
    public BaseFragment fragment;
    protected ArrayList<BaseModel> arrayList;

    public ArrayList<BaseModel> getBaseModelArrayList() {
        return arrayList;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        BaseModel baseModel = arrayList.get(viewHolder.getAdapterPosition());
        if (viewHolder instanceof EventsRecVHolder) {
            if (baseModel instanceof MainEventsModel) {
                MainEventsModel mainEventsModel = (MainEventsModel) baseModel;
                Picasso//.with(context)
                        .get()
                        .load(mainEventsModel.getImgRes())
                        .into(((EventsRecVHolder) viewHolder).imgMainImg);
            }
        }
    }
}
