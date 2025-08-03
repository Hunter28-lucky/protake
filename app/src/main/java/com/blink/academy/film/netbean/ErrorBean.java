package com.blink.academy.film.netbean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ErrorBean implements Parcelable {
    public static final Parcelable.Creator<ErrorBean> CREATOR = new C0446();
    private boolean error;
    private int error_code;
    private String error_msg;

    /* renamed from: com.blink.academy.film.netbean.ErrorBean$Ϳ, reason: contains not printable characters */
    public class C0446 implements Parcelable.Creator<ErrorBean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public ErrorBean createFromParcel(Parcel parcel) {
            return new ErrorBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public ErrorBean[] newArray(int i) {
            return new ErrorBean[i];
        }
    }

    public ErrorBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getError_code() {
        return this.error_code;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public boolean isError() {
        return this.error;
    }

    public void setError(boolean z) {
        this.error = z;
    }

    public void setError_code(int i) {
        this.error_code = i;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.error ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.error_code);
        parcel.writeString(this.error_msg);
    }

    public ErrorBean(Parcel parcel) {
        this.error = parcel.readByte() != 0;
        this.error_code = parcel.readInt();
        this.error_msg = parcel.readString();
    }
}
