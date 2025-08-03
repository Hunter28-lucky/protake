package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.transmit.ChangeTintImageView;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorSignalViewBinding.java */
/* renamed from: ݻ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3772 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f13021;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final AppCompatImageView f13022;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final AppCompatImageView f13023;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final ChangeTintImageView f13024;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f13025;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f13026;

    public AbstractC3772(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ChangeTintImageView changeTintImageView, StrokeTextView strokeTextView, StrokeTextView strokeTextView2) {
        super(obj, view, i);
        this.f13021 = frameLayout;
        this.f13022 = appCompatImageView;
        this.f13023 = appCompatImageView2;
        this.f13024 = changeTintImageView;
        this.f13025 = strokeTextView;
        this.f13026 = strokeTextView2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3772 m12076(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m12077(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3772 m12077(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3772) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_monitor_signal_view, viewGroup, z, obj);
    }
}
