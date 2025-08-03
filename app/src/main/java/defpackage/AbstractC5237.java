package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutSettingGimbalBinding.java */
/* renamed from: Ⴟ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC5237 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final View f17356;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final View f17357;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f17358;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final RecyclerView f17359;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f17360;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f17361;

    public AbstractC5237(Object obj, View view, int i, View view2, View view3, RelativeLayout relativeLayout, RecyclerView recyclerView, StrokeTextView strokeTextView, StrokeTextView strokeTextView2) {
        super(obj, view, i);
        this.f17356 = view2;
        this.f17357 = view3;
        this.f17358 = relativeLayout;
        this.f17359 = recyclerView;
        this.f17360 = strokeTextView;
        this.f17361 = strokeTextView2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC5237 m15252(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m15253(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC5237 m15253(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC5237) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_setting_gimbal, viewGroup, z, obj);
    }
}
