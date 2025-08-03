package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.CircleBgView;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.film.widgets.StrokePointView;
import com.blink.academy.protake.R;

/* compiled from: LayoutMonitorFlagViewBinding.java */
/* renamed from: ห, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4914 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f16569;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final CircleBgView f16570;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f16571;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final StrokePointView f16572;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f16573;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final ImageView f16574;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final ImageView f16575;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final ImageView f16576;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f16577;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final ImageView f16578;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f16579;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final ImageView f16580;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f16581;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final ImageView f16582;

    /* renamed from: ބ, reason: contains not printable characters */
    @NonNull
    public final OneTakeProgressBar f16583;

    /* renamed from: ޅ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f16584;

    public AbstractC4914(Object obj, View view, int i, FrameLayout frameLayout, CircleBgView circleBgView, ConstraintLayout constraintLayout, StrokePointView strokePointView, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout3, ImageView imageView4, ConstraintLayout constraintLayout4, ImageView imageView5, ConstraintLayout constraintLayout5, ImageView imageView6, OneTakeProgressBar oneTakeProgressBar, ConstraintLayout constraintLayout6) {
        super(obj, view, i);
        this.f16569 = frameLayout;
        this.f16570 = circleBgView;
        this.f16571 = constraintLayout;
        this.f16572 = strokePointView;
        this.f16573 = constraintLayout2;
        this.f16574 = imageView;
        this.f16575 = imageView2;
        this.f16576 = imageView3;
        this.f16577 = constraintLayout3;
        this.f16578 = imageView4;
        this.f16579 = constraintLayout4;
        this.f16580 = imageView5;
        this.f16581 = constraintLayout5;
        this.f16582 = imageView6;
        this.f16583 = oneTakeProgressBar;
        this.f16584 = constraintLayout6;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4914 m14640(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m14641(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4914 m14641(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4914) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_monitor_flag_view, viewGroup, z, obj);
    }
}
