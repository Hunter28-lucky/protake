package com.blink.academy.film.netbean.store;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class StoreMessageBean implements Parcelable {
    public static final Parcelable.Creator<StoreMessageBean> CREATOR = new C0449();
    private String body;
    private String button_left_action;
    private String button_left_title;
    private String button_right_action;
    private String button_right_title;
    private boolean close_on_lost_focus;
    private String show_on;
    private String title;

    /* renamed from: com.blink.academy.film.netbean.store.StoreMessageBean$Ϳ, reason: contains not printable characters */
    public class C0449 implements Parcelable.Creator<StoreMessageBean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public StoreMessageBean createFromParcel(Parcel parcel) {
            return new StoreMessageBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public StoreMessageBean[] newArray(int i) {
            return new StoreMessageBean[i];
        }
    }

    public StoreMessageBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBody() {
        return this.body;
    }

    public String getButton_left_action() {
        return this.button_left_action;
    }

    public String getButton_left_title() {
        return this.button_left_title;
    }

    public String getButton_right_action() {
        return this.button_right_action;
    }

    public String getButton_right_title() {
        return this.button_right_title;
    }

    public String getShow_on() {
        return this.show_on;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isClose_on_lost_focus() {
        return this.close_on_lost_focus;
    }

    public StoreMessageBean setBody(String str) {
        this.body = str;
        return this;
    }

    public StoreMessageBean setButton_left_action(String str) {
        this.button_left_action = str;
        return this;
    }

    public StoreMessageBean setButton_left_title(String str) {
        this.button_left_title = str;
        return this;
    }

    public StoreMessageBean setButton_right_action(String str) {
        this.button_right_action = str;
        return this;
    }

    public StoreMessageBean setButton_right_title(String str) {
        this.button_right_title = str;
        return this;
    }

    public StoreMessageBean setClose_on_lost_focus(boolean z) {
        this.close_on_lost_focus = z;
        return this;
    }

    public StoreMessageBean setShow_on(String str) {
        this.show_on = str;
        return this;
    }

    public StoreMessageBean setTitle(String str) {
        this.title = str;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.show_on);
        parcel.writeString(this.title);
        parcel.writeString(this.body);
        parcel.writeString(this.button_left_title);
        parcel.writeString(this.button_right_title);
        parcel.writeString(this.button_left_action);
        parcel.writeString(this.button_right_action);
        parcel.writeByte(this.close_on_lost_focus ? (byte) 1 : (byte) 0);
    }

    public StoreMessageBean(Parcel parcel) {
        this.show_on = parcel.readString();
        this.title = parcel.readString();
        this.body = parcel.readString();
        this.button_left_title = parcel.readString();
        this.button_right_title = parcel.readString();
        this.button_left_action = parcel.readString();
        this.button_right_action = parcel.readString();
        this.close_on_lost_focus = parcel.readByte() != 0;
    }
}
