package defpackage;

import android.util.SparseIntArray;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blink.academy.film.videotools.CameraView;
import com.blink.academy.film.widgets.socket.ReceiverView;
import com.blink.academy.protake.R;

/* compiled from: ActivityTesttBindingImpl.java */
/* renamed from: ࢧ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3971 extends AbstractC3970 {

    /* renamed from: ހ, reason: contains not printable characters */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13888 = null;

    /* renamed from: ށ, reason: contains not printable characters */
    @Nullable
    public static final SparseIntArray f13889;

    /* renamed from: ׯ, reason: contains not printable characters */
    @NonNull
    public final RelativeLayout f13890;

    /* renamed from: ؠ, reason: contains not printable characters */
    public long f13891;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13889 = sparseIntArray;
        sparseIntArray.put(R.id.preview_surface, 1);
        sparseIntArray.put(R.id.decode_surface, 2);
        sparseIntArray.put(R.id.bt, 3);
        sparseIntArray.put(R.id.btn_start_send, 4);
        sparseIntArray.put(R.id.btn_start_send_h265, 5);
        sparseIntArray.put(R.id.btn_start_receive, 6);
        sparseIntArray.put(R.id.receiver_list, 7);
        sparseIntArray.put(R.id.tv_local_ip, 8);
    }

    public C3971(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f13888, f13889));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13891 = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13891 != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13891 = 1L;
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

    public C3971(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[3], (Button) objArr[6], (Button) objArr[4], (Button) objArr[5], (SurfaceView) objArr[2], (CameraView) objArr[1], (ReceiverView) objArr[7], (TextView) objArr[8]);
        this.f13891 = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f13890 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
