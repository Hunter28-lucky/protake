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

/* compiled from: LayoutSettingProtakeFocusBinding.java */
/* renamed from: ঈ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4140 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final View f14335;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final View f14336;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14337;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final RecyclerView f14338;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f14339;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f14340;

    public AbstractC4140(Object obj, View view, int i, View view2, View view3, RelativeLayout relativeLayout, RecyclerView recyclerView, StrokeTextView strokeTextView, StrokeTextView strokeTextView2) {
        super(obj, view, i);
        this.f14335 = view2;
        this.f14336 = view3;
        this.f14337 = relativeLayout;
        this.f14338 = recyclerView;
        this.f14339 = strokeTextView;
        this.f14340 = strokeTextView2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4140 m13117(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13118(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4140 m13118(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4140) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_setting_protake_focus, viewGroup, z, obj);
    }
}
