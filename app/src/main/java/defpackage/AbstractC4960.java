package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;

/* compiled from: LayoutCloudPlayerConnnectBinding.java */
/* renamed from: ຖ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4960 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f16676;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f16677;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f16678;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16679;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final TextView f16680;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final TextView f16681;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16682;

    public AbstractC4960(Object obj, View view, int i, RelativeLayout relativeLayout, ConstraintLayout constraintLayout, FrameLayout frameLayout, StrokeTextView strokeTextView, TextView textView, TextView textView2, StrokeTextView strokeTextView2) {
        super(obj, view, i);
        this.f16676 = relativeLayout;
        this.f16677 = constraintLayout;
        this.f16678 = frameLayout;
        this.f16679 = strokeTextView;
        this.f16680 = textView;
        this.f16681 = textView2;
        this.f16682 = strokeTextView2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4960 m14734(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m14735(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4960 m14735(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4960) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_cloud_player_connnect, viewGroup, z, obj);
    }
}
