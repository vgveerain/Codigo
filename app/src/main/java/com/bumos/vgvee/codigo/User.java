package com.bumos.vgvee.codigo;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable{
    public String Name;
    public String Email;
    public String PhoneNum;
    public String ReferralCodeSelf;
    public String ReferralCodeReceived;
    public int referrals = 0;
    public String Key;


    public User() {
        Name = "";
        Email = "";
        PhoneNum = "";
        ReferralCodeReceived = "";
        ReferralCodeSelf = "";
        Key = "";
        referrals = 0;
    }

    protected User(Parcel in) {
        Name = in.readString();
        Email = in.readString();
        PhoneNum = in.readString();
        ReferralCodeSelf = in.readString();
        ReferralCodeReceived = in.readString();
        referrals = in.readInt();
        Key = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Email);
        dest.writeString(PhoneNum);
        dest.writeString(ReferralCodeSelf);
        dest.writeString(ReferralCodeReceived);
        dest.writeInt(referrals);
        dest.writeString(Key);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
