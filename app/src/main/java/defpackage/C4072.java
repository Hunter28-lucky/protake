package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.FilmTextView;
import com.blink.academy.film.widgets.RoundButton;
import com.blink.academy.film.widgets.score.ScaleRatingBar;
import com.blink.academy.protake.R;

/* compiled from: LayoutMarketScoreBindingImpl.java */
/* renamed from: ञ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4072 extends AbstractC3771 {

    /* renamed from: ހ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14158 = null;

    /* renamed from: ށ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f14159;

    /* renamed from: ؠ, reason: contains not printable characters */
    public long f14160;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14159 = sparseIntArray;
        sparseIntArray.put(R.id.root_content, 1);
        sparseIntArray.put(R.id.dialog_title, 2);
        sparseIntArray.put(R.id.dialog_rating_bar, 3);
        sparseIntArray.put(R.id.dialog_line, 4);
        sparseIntArray.put(R.id.dialog_hint_content, 5);
        sparseIntArray.put(R.id.dialog_confirm, 6);
        sparseIntArray.put(R.id.dialog_dont_show, 7);
        sparseIntArray.put(R.id.dialog_hint_cancel, 8);
    }

    public C4072(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f14158, f14159));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f14160 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14160 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14160 = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }

    public C4072(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RoundButton) objArr[6], (FilmTextView) objArr[7], (FilmTextView) objArr[8], (FilmTextView) objArr[5], (View) objArr[4], (ScaleRatingBar) objArr[3], (FilmTextView) objArr[2], (ConstraintLayout) objArr[0], (LinearLayout) objArr[1]);
        this.f14160 = -1L;
        this.f13019.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
