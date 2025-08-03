package com.blink.academy.film.widgets.score;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.blink.academy.film.R$styleable;
import com.blink.academy.protake.R;
import defpackage.C4792;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BaseRatingBar extends LinearLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f3879;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f3880;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3881;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3882;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f3883;

    /* renamed from: ՠ, reason: contains not printable characters */
    public float f3884;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f3885;

    /* renamed from: ֏, reason: contains not printable characters */
    public float f3886;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f3887;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f3888;

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f3889;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f3890;

    /* renamed from: ނ, reason: contains not printable characters */
    public float f3891;

    /* renamed from: ރ, reason: contains not printable characters */
    public float f3892;

    /* renamed from: ބ, reason: contains not printable characters */
    public Drawable f3893;

    /* renamed from: ޅ, reason: contains not printable characters */
    public Drawable f3894;

    /* renamed from: ކ, reason: contains not printable characters */
    public InterfaceC1362 f3895;

    /* renamed from: އ, reason: contains not printable characters */
    public List<PartialView> f3896;

    /* renamed from: ވ, reason: contains not printable characters */
    public InterfaceC1363 f3897;

    /* renamed from: com.blink.academy.film.widgets.score.BaseRatingBar$Ϳ, reason: contains not printable characters */
    public interface InterfaceC1362 {
        /* renamed from: Ϳ */
        void mo2879(BaseRatingBar baseRatingBar, float f, boolean z);
    }

    /* renamed from: com.blink.academy.film.widgets.score.BaseRatingBar$Ԩ, reason: contains not printable characters */
    public interface InterfaceC1363 {
        void onUp();
    }

    public BaseRatingBar(Context context) {
        this(context, null);
    }

    public int getNumStars() {
        return this.f3879;
    }

    public float getRating() {
        return this.f3884;
    }

    public int getStarHeight() {
        return this.f3882;
    }

    public int getStarPadding() {
        return this.f3880;
    }

    public int getStarWidth() {
        return this.f3881;
    }

    public float getStepSize() {
        return this.f3885;
    }

    @Override // android.view.View
    public boolean isClickable() {
        return this.f3889;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRating(savedState.m3901());
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.m3902(this.f3884);
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (m3888()) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f3891 = x;
            this.f3892 = y;
            this.f3886 = this.f3884;
        } else if (action != 1) {
            if (action == 2) {
                if (!m3890()) {
                    return false;
                }
                m3884(x);
            }
        } else {
            if (!C1366.m3909(this.f3891, this.f3892, motionEvent) || !isClickable()) {
                InterfaceC1363 interfaceC1363 = this.f3897;
                if (interfaceC1363 != null) {
                    interfaceC1363.onUp();
                }
                return false;
            }
            m3883(x);
            InterfaceC1363 interfaceC13632 = this.f3897;
            if (interfaceC13632 != null) {
                interfaceC13632.onUp();
            }
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public void setClearRatingEnabled(boolean z) {
        this.f3890 = z;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.f3889 = z;
    }

    public void setEmptyDrawable(@NonNull Drawable drawable) {
        this.f3893 = drawable;
        Iterator<PartialView> it = this.f3896.iterator();
        while (it.hasNext()) {
            it.next().m3895(drawable);
        }
    }

    public void setEmptyDrawableRes(@DrawableRes int i) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), i);
        if (drawable != null) {
            setEmptyDrawable(drawable);
        }
    }

    public void setFilledDrawable(@NonNull Drawable drawable) {
        this.f3894 = drawable;
        Iterator<PartialView> it = this.f3896.iterator();
        while (it.hasNext()) {
            it.next().m3897(drawable);
        }
    }

    public void setFilledDrawableRes(@DrawableRes int i) {
        Drawable drawable = ContextCompat.getDrawable(getContext(), i);
        if (drawable != null) {
            setFilledDrawable(drawable);
        }
    }

    public void setIsIndicator(boolean z) {
        this.f3887 = z;
    }

    public void setMinimumStars(@FloatRange(from = 0.0d) float f) {
        this.f3883 = C1366.m3908(f, this.f3879, this.f3885);
    }

    public void setNumStars(int i) {
        if (i <= 0) {
            return;
        }
        this.f3896.clear();
        removeAllViews();
        this.f3879 = i;
        m3886();
    }

    public void setOnRatingChangeListener(InterfaceC1362 interfaceC1362) {
        this.f3895 = interfaceC1362;
    }

    public void setOnTouchListener(InterfaceC1363 interfaceC1363) {
        this.f3897 = interfaceC1363;
    }

    public void setRating(float f) {
        m3891(f, false);
    }

    public void setScrollable(boolean z) {
        this.f3888 = z;
    }

    public void setStarHeight(@IntRange(from = 0) int i) {
        this.f3882 = i;
        Iterator<PartialView> it = this.f3896.iterator();
        while (it.hasNext()) {
            it.next().m3899(i);
        }
    }

    public void setStarPadding(int i) {
        if (i < 0) {
            return;
        }
        this.f3880 = i;
        for (PartialView partialView : this.f3896) {
            int i2 = this.f3880;
            partialView.setPadding(i2, 0, i2, 0);
        }
    }

    public void setStarWidth(@IntRange(from = 0) int i) {
        this.f3881 = i;
        Iterator<PartialView> it = this.f3896.iterator();
        while (it.hasNext()) {
            it.next().m3900(i);
        }
    }

    public void setStepSize(@FloatRange(from = 0.1d, to = 1.0d) float f) {
        this.f3885 = f;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo3881(float f) {
        for (PartialView partialView : this.f3896) {
            int iIntValue = ((Integer) partialView.getTag()).intValue();
            double dCeil = Math.ceil(f);
            double d = iIntValue;
            if (d > dCeil) {
                partialView.m3894();
            } else if (d == dCeil) {
                partialView.m3898(f);
            } else {
                partialView.m3896();
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final PartialView m3882(int i, int i2, int i3, int i4, Drawable drawable, Drawable drawable2) {
        PartialView partialView = new PartialView(getContext(), i, i2, i3, i4);
        partialView.m3897(drawable);
        partialView.m3895(drawable2);
        return partialView;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m3883(float f) {
        for (PartialView partialView : this.f3896) {
            if (m3889(f, partialView)) {
                float f2 = this.f3885;
                float fIntValue = f2 == 1.0f ? ((Integer) partialView.getTag()).intValue() : C1366.m3906(partialView, f2, f);
                if (this.f3886 == fIntValue && m3887()) {
                    return;
                }
                m3891(fIntValue, true);
                return;
            }
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m3884(float f) {
        for (PartialView partialView : this.f3896) {
            if (f < (partialView.getWidth() / 10.0f) + (this.f3883 * partialView.getWidth())) {
                return;
            }
            if (m3889(f, partialView)) {
                float fM3906 = C1366.m3906(partialView, this.f3885, f);
                if (this.f3884 != fM3906 && fM3906 != 0.0f) {
                    m3891(fM3906, true);
                }
            }
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m3885(TypedArray typedArray, Context context) {
        this.f3879 = typedArray.getInt(6, this.f3879);
        this.f3885 = typedArray.getFloat(12, this.f3885);
        this.f3883 = typedArray.getFloat(5, this.f3883);
        this.f3880 = typedArray.getDimensionPixelSize(10, this.f3880);
        this.f3881 = typedArray.getDimensionPixelSize(11, 0);
        this.f3882 = typedArray.getDimensionPixelSize(9, 0);
        this.f3893 = typedArray.hasValue(2) ? ContextCompat.getDrawable(context, typedArray.getResourceId(2, -1)) : null;
        this.f3894 = typedArray.hasValue(3) ? ContextCompat.getDrawable(context, typedArray.getResourceId(3, -1)) : null;
        this.f3887 = typedArray.getBoolean(4, this.f3887);
        this.f3888 = typedArray.getBoolean(8, this.f3888);
        this.f3889 = typedArray.getBoolean(1, this.f3889);
        this.f3890 = typedArray.getBoolean(0, this.f3890);
        typedArray.recycle();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m3886() {
        this.f3896 = new ArrayList();
        for (int i = 1; i <= this.f3879; i++) {
            PartialView partialViewM3882 = m3882(i, this.f3881, this.f3882, this.f3880, this.f3894, this.f3893);
            addView(partialViewM3882);
            this.f3896.add(partialViewM3882);
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean m3887() {
        return this.f3890;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean m3888() {
        return this.f3887;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean m3889(float f, View view) {
        return f > ((float) view.getLeft()) && f < ((float) view.getRight());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean m3890() {
        return this.f3888;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m3891(float f, boolean z) {
        int i = this.f3879;
        if (f > i) {
            f = i;
        }
        float f2 = this.f3883;
        if (f < f2) {
            f = f2;
        }
        if (this.f3884 == f) {
            return;
        }
        float fFloatValue = Double.valueOf(Math.floor(f / this.f3885)).floatValue() * this.f3885;
        this.f3884 = fFloatValue;
        InterfaceC1362 interfaceC1362 = this.f3895;
        if (interfaceC1362 != null) {
            interfaceC1362.mo2879(this, fFloatValue, z);
        }
        mo3881(f);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m3892() {
        if (this.f3879 <= 0) {
            this.f3879 = 5;
        }
        if (this.f3880 < 0) {
            this.f3880 = 0;
        }
        if (this.f3893 == null) {
            this.f3893 = ContextCompat.getDrawable(getContext(), R.drawable.star_border);
        }
        if (this.f3894 == null) {
            this.f3894 = ContextCompat.getDrawable(getContext(), R.drawable.star_full);
        }
        float f = this.f3885;
        if (f > 1.0f) {
            this.f3885 = 1.0f;
        } else if (f < 0.1f) {
            this.f3885 = 0.1f;
        }
        this.f3883 = C1366.m3908(this.f3883, this.f3879, this.f3885);
    }

    public BaseRatingBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseRatingBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3880 = C4792.m14375().m14477(20.0f, 1.0f);
        this.f3883 = 0.0f;
        this.f3884 = -1.0f;
        this.f3885 = 1.0f;
        this.f3886 = 0.0f;
        this.f3887 = false;
        this.f3888 = true;
        this.f3889 = true;
        this.f3890 = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BaseRatingBar);
        float f = typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
        m3885(typedArrayObtainStyledAttributes, context);
        m3892();
        m3886();
        setRating(f);
    }
}
