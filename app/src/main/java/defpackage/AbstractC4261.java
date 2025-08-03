package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutSettingHintDiaBinding.java */
/* renamed from: ਤ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4261 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final View f14615;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final View f14616;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14617;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f14618;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f14619;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f14620;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f14621;

    public AbstractC4261(Object obj, View view, int i, View view2, View view3, RelativeLayout relativeLayout, StrokeTextView strokeTextView, StrokeTextView strokeTextView2, StrokeTextView strokeTextView3, StrokeTextView strokeTextView4) {
        super(obj, view, i);
        this.f14615 = view2;
        this.f14616 = view3;
        this.f14617 = relativeLayout;
        this.f14618 = strokeTextView;
        this.f14619 = strokeTextView2;
        this.f14620 = strokeTextView3;
        this.f14621 = strokeTextView4;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4261 m13376(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13377(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4261 m13377(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4261) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_setting_hint_dia, viewGroup, z, obj);
    }
}
