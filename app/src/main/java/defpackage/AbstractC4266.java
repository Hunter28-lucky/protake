package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.BorderView;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.LooksMorePointView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.WhiteBorderView;
import com.blink.academy.film.widgets.looks.ScrollBackItem;
import com.blink.academy.protake.R;

/* compiled from: LayoutPreviewItemBinding.java */
/* renamed from: ਨ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4266 extends ViewDataBinding {

    /* renamed from: ԫ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14629;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @NonNull
    public final BorderView f14630;

    /* renamed from: ԭ, reason: contains not printable characters */
    @NonNull
    public final LooksMorePointView f14631;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @NonNull
    public final ImageView f14632;

    /* renamed from: ԯ, reason: contains not printable characters */
    @NonNull
    public final ImageView f14633;

    /* renamed from: ՠ, reason: contains not printable characters */
    @NonNull
    public final WhiteBorderView f14634;

    /* renamed from: ֈ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14635;

    /* renamed from: ֏, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14636;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final FilmSeekBar f14637;

    /* renamed from: ؠ, reason: contains not printable characters */
    @NonNull
    public final ScrollBackItem f14638;

    /* renamed from: ހ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f14639;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f14640;

    /* renamed from: ނ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f14641;

    /* renamed from: ރ, reason: contains not printable characters */
    @NonNull
    public final StrokeTextView f14642;

    /* renamed from: ބ, reason: contains not printable characters */
    @NonNull
    public final View f14643;

    public AbstractC4266(Object obj, View view, int i, RelativeLayout relativeLayout, BorderView borderView, LooksMorePointView looksMorePointView, ImageView imageView, ImageView imageView2, WhiteBorderView whiteBorderView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, FilmSeekBar filmSeekBar, ScrollBackItem scrollBackItem, RelativeLayout relativeLayout4, StrokeTextView strokeTextView, StrokeTextView strokeTextView2, StrokeTextView strokeTextView3, View view2) {
        super(obj, view, i);
        this.f14629 = relativeLayout;
        this.f14630 = borderView;
        this.f14631 = looksMorePointView;
        this.f14632 = imageView;
        this.f14633 = imageView2;
        this.f14634 = whiteBorderView;
        this.f14635 = relativeLayout2;
        this.f14636 = relativeLayout3;
        this.f14637 = filmSeekBar;
        this.f14638 = scrollBackItem;
        this.f14639 = relativeLayout4;
        this.f14640 = strokeTextView;
        this.f14641 = strokeTextView2;
        this.f14642 = strokeTextView3;
        this.f14643 = view2;
    }

    @NonNull
    /* renamed from: ຉ, reason: contains not printable characters */
    public static AbstractC4266 m13378(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return m13379(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    /* renamed from: ຑ, reason: contains not printable characters */
    public static AbstractC4266 m13379(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AbstractC4266) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_preview_item, viewGroup, z, obj);
    }
}
