package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
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

/* compiled from: LayoutShutterPortraitViewBinding.java */
/* renamed from: ဉ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC5095 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final HorizontalScrollView f16913;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f16914;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final RecyclerView f16915;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f16916;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final RecyclerView f16917;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final FilmSeekBar f16918;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final SwitchButton f16919;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f16920;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final FilmSeekBar f16921;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final FilmStopView f16922;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final FilmStopView f16923;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final FrameLayout f16924;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f16925;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextViewWithBottomBlock f16926;

    /* renamed from: ބ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16927;

    /* renamed from: ޅ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextViewWithBottomBlock f16928;

    /* renamed from: ކ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f16929;

    public AbstractC5095(Object obj, View view, int i, HorizontalScrollView horizontalScrollView, ConstraintLayout constraintLayout, RecyclerView recyclerView, FrameLayout frameLayout, RecyclerView recyclerView2, FilmSeekBar filmSeekBar, SwitchButton switchButton, FrameLayout frameLayout2, FilmSeekBar filmSeekBar2, FilmStopView filmStopView, FilmStopView filmStopView2, FrameLayout frameLayout3, ConstraintLayout constraintLayout2, StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock, StrokeTextView strokeTextView, StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock2, StrokeTextView strokeTextView2) {
        super(obj, view, i);
        this.f16913 = horizontalScrollView;
        this.f16914 = constraintLayout;
        this.f16915 = recyclerView;
        this.f16916 = frameLayout;
        this.f16917 = recyclerView2;
        this.f16918 = filmSeekBar;
        this.f16919 = switchButton;
        this.f16920 = frameLayout2;
        this.f16921 = filmSeekBar2;
        this.f16922 = filmStopView;
        this.f16923 = filmStopView2;
        this.f16924 = frameLayout3;
        this.f16925 = constraintLayout2;
        this.f16926 = strokeTextViewWithBottomBlock;
        this.f16927 = strokeTextView;
        this.f16928 = strokeTextViewWithBottomBlock2;
        this.f16929 = strokeTextView2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC5095 m14924(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m14925(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC5095 m14925(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC5095) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_shutter_portrait_view, viewGroup, z, obj);
    }
}
