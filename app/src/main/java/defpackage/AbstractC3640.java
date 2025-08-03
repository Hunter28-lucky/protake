package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutShutterViewBinding.java */
/* renamed from: ۓ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3640 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f12633;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final RecyclerView f12634;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f12635;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final RecyclerView f12636;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final FilmSeekBar f12637;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final SwitchButton f12638;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f12639;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final FilmSeekBar f12640;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final FilmStopView f12641;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final FilmStopView f12642;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f12643;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextViewWithBottomBlock f12644;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f12645;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextViewWithBottomBlock f12646;

    /* renamed from: ބ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f12647;

    public AbstractC3640(Object obj, View view, int i, ConstraintLayout constraintLayout, RecyclerView recyclerView, FrameLayout frameLayout, RecyclerView recyclerView2, FilmSeekBar filmSeekBar, SwitchButton switchButton, FrameLayout frameLayout2, FilmSeekBar filmSeekBar2, FilmStopView filmStopView, FilmStopView filmStopView2, FrameLayout frameLayout3, StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock, StrokeTextView strokeTextView, StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock2, StrokeTextView strokeTextView2) {
        super(obj, view, i);
        this.f12633 = constraintLayout;
        this.f12634 = recyclerView;
        this.f12635 = frameLayout;
        this.f12636 = recyclerView2;
        this.f12637 = filmSeekBar;
        this.f12638 = switchButton;
        this.f12639 = frameLayout2;
        this.f12640 = filmSeekBar2;
        this.f12641 = filmStopView;
        this.f12642 = filmStopView2;
        this.f12643 = frameLayout3;
        this.f12644 = strokeTextViewWithBottomBlock;
        this.f12645 = strokeTextView;
        this.f12646 = strokeTextViewWithBottomBlock2;
        this.f12647 = strokeTextView2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC3640 m11707(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m11708(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC3640 m11708(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC3640) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_shutter_view, viewGroup, z, obj);
    }
}
