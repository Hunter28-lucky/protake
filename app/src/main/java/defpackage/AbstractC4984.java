package defpackage;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import defpackage.InterfaceC3129;
import java.io.IOException;

/* compiled from: AssetPathFetcher.java */
/* renamed from: ຩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4984<T> implements InterfaceC3129<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final String f16736;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final AssetManager f16737;

    /* renamed from: ԭ, reason: contains not printable characters */
    public T f16738;

    public AbstractC4984(AssetManager assetManager, String str) {
        this.f16737 = assetManager;
        this.f16736 = str;
    }

    @Override // defpackage.InterfaceC3129
    public void cancel() {
    }

    @Override // defpackage.InterfaceC3129
    /* renamed from: Ԩ */
    public void mo7076() {
        T t = this.f16738;
        if (t == null) {
            return;
        }
        try {
            mo7660(t);
        } catch (IOException unused) {
        }
    }

    /* renamed from: ԩ */
    public abstract void mo7660(T t) throws IOException;

    @Override // defpackage.InterfaceC3129
    @NonNull
    /* renamed from: Ԫ */
    public DataSource mo7077() {
        return DataSource.LOCAL;
    }

    @Override // defpackage.InterfaceC3129
    /* renamed from: ԫ */
    public void mo7078(@NonNull Priority priority, @NonNull InterfaceC3129.InterfaceC3130<? super T> interfaceC3130) {
        try {
            T tMo7661 = mo7661(this.f16737, this.f16736);
            this.f16738 = tMo7661;
            interfaceC3130.mo4919(tMo7661);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e2);
            }
            interfaceC3130.mo4918(e2);
        }
    }

    /* renamed from: Ԭ */
    public abstract T mo7661(AssetManager assetManager, String str) throws IOException;
}
