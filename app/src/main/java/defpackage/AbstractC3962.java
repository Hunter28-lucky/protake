package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.stream.secondscreen.SecondScreenTextureView;
import com.blink.academy.film.widgets.GuideView;
import com.blink.academy.protake.R;

/* compiled from: ActivitySecondDisplayBinding.java */
/* renamed from: ࡩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3962 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f13787;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final SecondScreenTextureView f13788;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final GuideView f13789;

    public AbstractC3962(Object obj, View view, int i, ConstraintLayout constraintLayout, SecondScreenTextureView secondScreenTextureView, GuideView guideView) {
        super(obj, view, i);
        this.f13787 = constraintLayout;
        this.f13788 = secondScreenTextureView;
        this.f13789 = guideView;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3962 m12807(@NonNull LayoutInflater layoutInflater) {
        return m12808(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3962 m12808(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AbstractC3962) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_second_display, null, false, obj);
    }
}
