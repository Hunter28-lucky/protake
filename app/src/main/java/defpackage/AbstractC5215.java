package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.exposure.SlideBarView;
import com.blink.academy.film.widgets.exposure.TouchSquareView;
import com.blink.academy.protake.R;

/* compiled from: LayoutCameraTouchBinding.java */
/* renamed from: Ⴒ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC5215 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final SlideBarView f17273;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final TouchSquareView f17274;

    public AbstractC5215(Object obj, View view, int i, SlideBarView slideBarView, TouchSquareView touchSquareView) {
        super(obj, view, i);
        this.f17273 = slideBarView;
        this.f17274 = touchSquareView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC5215 m15220(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m15221(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC5215 m15221(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC5215) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_camera_touch, viewGroup, z, obj);
    }
}
