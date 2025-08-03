package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blink.academy.film.widgets.FilmSeekBar;
import com.blink.academy.film.widgets.FilmStopView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;

/* compiled from: LayoutAudioPortraitSettingBindingImpl.java */
/* renamed from: ԟ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3165 extends AbstractC2644 {

    /* renamed from: ރ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11229 = null;

    /* renamed from: ބ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f11230;

    /* renamed from: ށ, reason: contains not printable characters */
    @NonNull
    public final ConstraintLayout f11231;

    /* renamed from: ނ, reason: contains not printable characters */
    public long f11232;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f11230 = sparseIntArray;
        sparseIntArray.put(R.id.bottom_setting_title, 1);
        sparseIntArray.put(R.id.bottom_container, 2);
        sparseIntArray.put(R.id.audio_type_list, 3);
        sparseIntArray.put(R.id.bottom_options, 4);
        sparseIntArray.put(R.id.audio_options_list, 5);
        sparseIntArray.put(R.id.center_parent, 6);
        sparseIntArray.put(R.id.audio_stop_view, 7);
        sparseIntArray.put(R.id.bottom_auto, 8);
        sparseIntArray.put(R.id.bottom_auto_tv, 9);
        sparseIntArray.put(R.id.audio_auto_switch, 10);
        sparseIntArray.put(R.id.sb_audio, 11);
    }

    public C3165(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, f11229, f11230));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f11232 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11232 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11232 = 1L;
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

    public C3165(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (SwitchButton) objArr[10], (RecyclerView) objArr[5], (FilmStopView) objArr[7], (RecyclerView) objArr[3], (LinearLayout) objArr[8], (StrokeTextView) objArr[9], (LinearLayout) objArr[2], (RelativeLayout) objArr[4], (StrokeTextView) objArr[1], (RelativeLayout) objArr[6], (FilmSeekBar) objArr[11]);
        this.f11232 = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f11231 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
