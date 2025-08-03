package com.blink.academy.film.widgets.score;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* loaded from: classes.dex */
class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new C1364();

    /* renamed from: ԫ, reason: contains not printable characters */
    public float f3902;

    /* renamed from: com.blink.academy.film.widgets.score.SavedState$Ϳ, reason: contains not printable characters */
    public class C1364 implements Parcelable.Creator<SavedState> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public SavedState createFromParcel(Parcel parcel) {
            return new SavedState(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public SavedState[] newArray(int i) {
            return new SavedState[i];
        }
    }

    public /* synthetic */ SavedState(Parcel parcel, C1364 c1364) {
        this(parcel);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f3902);
    }

    /* renamed from: ຉ, reason: contains not printable characters */
    public float m3901() {
        return this.f3902;
    }

    /* renamed from: ຑ, reason: contains not printable characters */
    public void m3902(float f) {
        this.f3902 = f;
    }

    public SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public SavedState(Parcel parcel) {
        super(parcel);
        this.f3902 = parcel.readFloat();
    }
}
