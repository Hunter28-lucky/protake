package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorUnitBinding.java */
/* renamed from: ӣ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3117 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextViewWithBottomBlock f11072;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextViewWithBottomBlock f11073;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextViewWithBottomBlock f11074;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextViewWithBottomBlock f11075;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextViewWithBottomBlock f11076;

    public AbstractC3117(Object obj, View view, int i, StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock, StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock2, StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock3, StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock4, StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock5) {
        super(obj, view, i);
        this.f11072 = strokeTextViewWithBottomBlock;
        this.f11073 = strokeTextViewWithBottomBlock2;
        this.f11074 = strokeTextViewWithBottomBlock3;
        this.f11075 = strokeTextViewWithBottomBlock4;
        this.f11076 = strokeTextViewWithBottomBlock5;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3117 m10705(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m10706(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3117 m10706(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3117) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_monitor_unit, viewGroup, z, obj);
    }
}
