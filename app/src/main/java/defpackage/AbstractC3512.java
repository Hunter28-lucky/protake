package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.RecordTimeFrameView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorRecordTimeBinding.java */
/* renamed from: ڃ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3512 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f12283;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final RecordTimeFrameView f12284;

    public AbstractC3512(Object obj, View view, int i, StrokeTextView strokeTextView, RecordTimeFrameView recordTimeFrameView) {
        super(obj, view, i);
        this.f12283 = strokeTextView;
        this.f12284 = recordTimeFrameView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3512 m11459(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m11460(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3512 m11460(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3512) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_monitor_record_time, viewGroup, z, obj);
    }
}
