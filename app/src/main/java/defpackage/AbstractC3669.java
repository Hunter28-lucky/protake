package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutIsoViewBinding.java */
/* renamed from: ܚ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3669 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f12712;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final FilmStopView f12713;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f12714;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final SwitchButton f12715;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final FilmSeekBar f12716;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f12717;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f12718;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f12719;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f12720;

    public AbstractC3669(Object obj, View view, int i, ConstraintLayout constraintLayout, FilmStopView filmStopView, ConstraintLayout constraintLayout2, SwitchButton switchButton, FilmSeekBar filmSeekBar, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, StrokeTextView strokeTextView, StrokeTextView strokeTextView2) {
        super(obj, view, i);
        this.f12712 = constraintLayout;
        this.f12713 = filmStopView;
        this.f12714 = constraintLayout2;
        this.f12715 = switchButton;
        this.f12716 = filmSeekBar;
        this.f12717 = constraintLayout3;
        this.f12718 = constraintLayout4;
        this.f12719 = strokeTextView;
        this.f12720 = strokeTextView2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3669 m11780(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m11781(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3669 m11781(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3669) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_iso_view, viewGroup, z, obj);
    }
}
