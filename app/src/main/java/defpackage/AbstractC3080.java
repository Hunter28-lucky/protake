package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.stream.ACUnitView;
import com.blink.academy.film.widgets.GuideView;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorTextureGroupBinding.java */
/* renamed from: ҳ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3080 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final GuideView f10949;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final View f10950;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final View f10951;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final ACUnitView f10952;

    public AbstractC3080(Object obj, View view, int i, GuideView guideView, View view2, View view3, ACUnitView aCUnitView) {
        super(obj, view, i);
        this.f10949 = guideView;
        this.f10950 = view2;
        this.f10951 = view3;
        this.f10952 = aCUnitView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3080 m10654(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m10655(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3080 m10655(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3080) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_monitor_texture_group, viewGroup, z, obj);
    }
}
