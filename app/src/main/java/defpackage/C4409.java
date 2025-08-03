package defpackage;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.widgets.OneTakeProgressBar;
import com.blink.academy.protake.R;

/* compiled from: LayoutPortraitAccessoriesBindingImpl.java */
/* renamed from: ଜ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4409 extends AbstractC4067 {

    /* renamed from: ޠ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f15188 = null;

    /* renamed from: ޡ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f15189;

    /* renamed from: ޞ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f15190;

    /* renamed from: ޟ, reason: contains not printable characters */
    public long f15191;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f15189 = sparseIntArray;
        sparseIntArray.put(R.id.rl_zhiyun, 1);
        sparseIntArray.put(R.id.line_zhiyun_top, 2);
        sparseIntArray.put(R.id.tv_zhiyun, 3);
        sparseIntArray.put(R.id.sb_zhiyun, 4);
        sparseIntArray.put(R.id.zhiyun_switch_top, 5);
        sparseIntArray.put(R.id.pb_zhiyun, 6);
        sparseIntArray.put(R.id.line_zhiyun_bottom, 7);
        sparseIntArray.put(R.id.rl_anamo, 8);
        sparseIntArray.put(R.id.tv_anamo, 9);
        sparseIntArray.put(R.id.sb_anamo, 10);
        sparseIntArray.put(R.id.pb_anamo, 11);
        sparseIntArray.put(R.id.line_anamo_bottom, 12);
        sparseIntArray.put(R.id.rl_155, 13);
        sparseIntArray.put(R.id.tv_155, 14);
        sparseIntArray.put(R.id.sb_155, 15);
        sparseIntArray.put(R.id.pb_155, 16);
        sparseIntArray.put(R.id.line_155_bottom, 17);
        sparseIntArray.put(R.id.rl_dof, 18);
        sparseIntArray.put(R.id.tv_dof, 19);
        sparseIntArray.put(R.id.sb_dof, 20);
        sparseIntArray.put(R.id.pb_dof, 21);
        sparseIntArray.put(R.id.line_dof_bottom, 22);
        sparseIntArray.put(R.id.rl_protake_focus, 23);
        sparseIntArray.put(R.id.line_protake_focus_top, 24);
        sparseIntArray.put(R.id.tv_protake_focus, 25);
        sparseIntArray.put(R.id.sb_protake_focus, 26);
        sparseIntArray.put(R.id.protake_focus_switch_top, 27);
        sparseIntArray.put(R.id.pb_protake_focus, 28);
        sparseIntArray.put(R.id.line_protake_focus_bottom, 29);
        sparseIntArray.put(R.id.rl_reverse_focus_wheel, 30);
        sparseIntArray.put(R.id.tv_reverse_focus_wheel, 31);
        sparseIntArray.put(R.id.sb_reverse_focus_wheel, 32);
        sparseIntArray.put(R.id.pb_reverse_focus_wheel, 33);
        sparseIntArray.put(R.id.line_reverse_focus_wheel_bottom, 34);
        sparseIntArray.put(R.id.rl_hdmi, 35);
        sparseIntArray.put(R.id.tv_hdmi, 36);
        sparseIntArray.put(R.id.sb_hdmi, 37);
        sparseIntArray.put(R.id.hdmi_switch_top, 38);
        sparseIntArray.put(R.id.pb_hdmi, 39);
        sparseIntArray.put(R.id.line_hdmi_bottom, 40);
    }

    public C4409(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 41, f15188, f15189));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f15191 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f15191 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f15191 = 1L;
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

    public C4409(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (View) objArr[38], (View) objArr[17], (View) objArr[12], (View) objArr[22], (View) objArr[40], (View) objArr[29], (View) objArr[24], (View) objArr[34], (View) objArr[7], (View) objArr[2], (OneTakeProgressBar) objArr[16], (OneTakeProgressBar) objArr[11], (OneTakeProgressBar) objArr[21], (OneTakeProgressBar) objArr[39], (OneTakeProgressBar) objArr[28], (OneTakeProgressBar) objArr[33], (OneTakeProgressBar) objArr[6], (View) objArr[27], (RelativeLayout) objArr[13], (RelativeLayout) objArr[8], (RelativeLayout) objArr[18], (RelativeLayout) objArr[35], (RelativeLayout) objArr[23], (RelativeLayout) objArr[30], (RelativeLayout) objArr[1], (Switch) objArr[15], (Switch) objArr[10], (Switch) objArr[20], (Switch) objArr[37], (Switch) objArr[26], (Switch) objArr[32], (Switch) objArr[4], (TextView) objArr[14], (TextView) objArr[9], (TextView) objArr[19], (TextView) objArr[36], (TextView) objArr[25], (TextView) objArr[31], (TextView) objArr[3], (View) objArr[5]);
        this.f15191 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f15190 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
