package com.bumos.vgvee.codigo;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    String name;
    String desc;
    int img;
    public boolean progress = false;
    String java, xml;

    protected Data(Parcel in) {
        name = in.readString();
        desc = in.readString();
        img = in.readInt();
        progress = in.readByte() != 0;
        java = in.readString();
        xml = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };


    public String getJava() {
        return java;
    }

    public void setJava(String java) {
        this.java = java;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public Data(String name, String desc, int img, String java, String xml) {
        this.name = name;
        this.desc = desc;
        this.img = img;
        this.java = java;
        this.xml = xml;
    }

    public boolean isProgress() {
        return progress;
    }

    public void setProgress(boolean progress) {
        this.progress = progress;
    }

    public Data() {
    }

    public Data(String name, String desc, int img) {
        this.name = name;
        this.desc = desc;
        this.img = img;
    }

    public Data(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Data(String name, String desc, int img, String java) {
        this.name = name;
        this.desc = desc;
        this.img = img;
        this.java = java;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(desc);
        parcel.writeInt(img);
        parcel.writeByte((byte) (progress ? 1 : 0));
        parcel.writeString(java);
        parcel.writeString(xml);
    }
}
