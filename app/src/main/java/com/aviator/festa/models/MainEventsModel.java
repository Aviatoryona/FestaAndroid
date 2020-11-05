package com.aviator.festa.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.aviator.festa.abstracts.BaseModel;

public class MainEventsModel extends BaseModel {
    private int imgRes;

    public MainEventsModel(int imgRes) {
        setImgRes(imgRes);
    }

    protected MainEventsModel(Parcel in) {
        imgRes = in.readInt();
    }

    public static final Creator<MainEventsModel> CREATOR = new Creator<MainEventsModel>() {
        @Override
        public MainEventsModel createFromParcel(Parcel in) {
            return new MainEventsModel(in);
        }

        @Override
        public MainEventsModel[] newArray(int size) {
            return new MainEventsModel[size];
        }
    };

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imgRes);
    }
}
