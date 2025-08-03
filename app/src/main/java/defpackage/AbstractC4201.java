package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.transmit.monitor.MonitorNormalCoverView;
import com.blink.academy.film.widgets.transmit.monitor.MonitorRedRecordingView;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorParentViewBinding.java */
/* renamed from: ল, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4201 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final MonitorNormalCoverView f14485;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ProgressBar f14486;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final MonitorRedRecordingView f14487;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f14488;

    public AbstractC4201(Object obj, View view, int i, MonitorNormalCoverView monitorNormalCoverView, ProgressBar progressBar, MonitorRedRecordingView monitorRedRecordingView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.f14485 = monitorNormalCoverView;
        this.f14486 = progressBar;
        this.f14487 = monitorRedRecordingView;
        this.f14488 = constraintLayout;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4201 m13270(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13271(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4201 m13271(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4201) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_monitor_parent_view, viewGroup, z, obj);
    }
}
