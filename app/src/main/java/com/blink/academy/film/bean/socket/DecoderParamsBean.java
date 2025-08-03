package com.blink.academy.film.bean.socket;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class DecoderParamsBean implements Parcelable {
    public static final Parcelable.Creator<DecoderParamsBean> CREATOR = new C0115();

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f394;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f395;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f396;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f397;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f398;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f399;

    /* renamed from: ֈ, reason: contains not printable characters */
    public String f400;

    /* renamed from: ֏, reason: contains not printable characters */
    public String f401;

    /* renamed from: com.blink.academy.film.bean.socket.DecoderParamsBean$Ϳ, reason: contains not printable characters */
    public class C0115 implements Parcelable.Creator<DecoderParamsBean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public DecoderParamsBean createFromParcel(Parcel parcel) {
            return new DecoderParamsBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public DecoderParamsBean[] newArray(int i) {
            return new DecoderParamsBean[i];
        }
    }

    public DecoderParamsBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f394);
        parcel.writeInt(this.f395);
        parcel.writeInt(this.f396);
        parcel.writeInt(this.f397);
        parcel.writeInt(this.f398);
        parcel.writeInt(this.f399);
        parcel.writeString(this.f400);
        parcel.writeString(this.f401);
    }

    /* renamed from: ຉ, reason: contains not printable characters */
    public int m470() {
        return this.f395;
    }

    /* renamed from: ຑ, reason: contains not printable characters */
    public int m471() {
        return this.f394;
    }

    /* renamed from: ຒ, reason: contains not printable characters */
    public int m472() {
        return this.f396;
    }

    /* renamed from: ຓ, reason: contains not printable characters */
    public int m473() {
        return this.f399;
    }

    /* renamed from: ຘ, reason: contains not printable characters */
    public String m474() {
        return this.f400;
    }

    /* renamed from: ຠ, reason: contains not printable characters */
    public int m475() {
        return this.f398;
    }

    /* renamed from: ຨ, reason: contains not printable characters */
    public int m476() {
        return this.f397;
    }

    /* renamed from: ຩ, reason: contains not printable characters */
    public String m477() {
        return this.f401;
    }

    /* renamed from: ຬ, reason: contains not printable characters */
    public DecoderParamsBean m478(int i) {
        this.f395 = i;
        return this;
    }

    /* renamed from: ໞ, reason: contains not printable characters */
    public DecoderParamsBean m479(int i) {
        this.f394 = i;
        return this;
    }

    /* renamed from: ໟ, reason: contains not printable characters */
    public DecoderParamsBean m480(int i) {
        this.f396 = i;
        return this;
    }

    /* renamed from: ྈ, reason: contains not printable characters */
    public DecoderParamsBean m481(int i) {
        this.f399 = i;
        return this;
    }

    /* renamed from: ྉ, reason: contains not printable characters */
    public DecoderParamsBean m482(String str) {
        this.f400 = str;
        return this;
    }

    /* renamed from: ྌ, reason: contains not printable characters */
    public DecoderParamsBean m483(int i) {
        this.f398 = i;
        return this;
    }

    /* renamed from: ဢ, reason: contains not printable characters */
    public DecoderParamsBean m484(int i) {
        this.f397 = i;
        return this;
    }

    /* renamed from: ဨ, reason: contains not printable characters */
    public DecoderParamsBean m485(String str) {
        this.f401 = str;
        return this;
    }

    public DecoderParamsBean(int i, int i2, int i3, int i4, int i5, int i6, String str) {
        this.f394 = i;
        this.f395 = i2;
        this.f396 = i3;
        this.f397 = i4;
        this.f398 = i5;
        this.f399 = i6;
        this.f400 = str;
    }

    public DecoderParamsBean(Parcel parcel) {
        this.f394 = parcel.readInt();
        this.f395 = parcel.readInt();
        this.f396 = parcel.readInt();
        this.f397 = parcel.readInt();
        this.f398 = parcel.readInt();
        this.f399 = parcel.readInt();
        this.f400 = parcel.readString();
        this.f401 = parcel.readString();
    }
}
