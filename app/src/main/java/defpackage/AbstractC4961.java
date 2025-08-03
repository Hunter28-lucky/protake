package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutCloudMonitorSwitchBinding.java */
/* renamed from: ທ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4961 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ImageView f16683;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ImageView f16684;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16685;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16686;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16687;

    public AbstractC4961(Object obj, View view, int i, ImageView imageView, ImageView imageView2, StrokeTextView strokeTextView, StrokeTextView strokeTextView2, StrokeTextView strokeTextView3) {
        super(obj, view, i);
        this.f16683 = imageView;
        this.f16684 = imageView2;
        this.f16685 = strokeTextView;
        this.f16686 = strokeTextView2;
        this.f16687 = strokeTextView3;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4961 m14736(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m14737(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4961 m14737(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4961) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_cloud_monitor_switch, viewGroup, z, obj);
    }
}
