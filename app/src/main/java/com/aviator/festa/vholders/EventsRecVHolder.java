package com.aviator.festa.vholders;

import androidx.annotation.NonNull;
import android.view.View;

import com.aviator.festa.R;
import com.aviator.festa.abstracts.BaseVHolder;
import com.joooonho.SelectableRoundedImageView;

public class EventsRecVHolder extends BaseVHolder {
    public EventsRecVHolder(@NonNull View itemView) {
        super(itemView);
        ViewHolder(itemView);
    }

    public SelectableRoundedImageView imgMainImg;

    public void ViewHolder(View convertView) {
        imgMainImg = convertView.findViewById(R.id.imgMainImg);
    }
}
