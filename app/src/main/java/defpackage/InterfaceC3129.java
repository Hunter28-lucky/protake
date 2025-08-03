package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* compiled from: DataFetcher.java */
/* renamed from: ӵ, reason: contains not printable characters */
/* loaded from: classes.dex */
public interface InterfaceC3129<T> {

    /* compiled from: DataFetcher.java */
    /* renamed from: ӵ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC3130<T> {
        /* renamed from: ԩ */
        void mo4918(@NonNull Exception exc);

        /* renamed from: Ԭ */
        void mo4919(@Nullable T t);
    }

    void cancel();

    @NonNull
    /* renamed from: Ϳ */
    Class<T> mo7075();

    /* renamed from: Ԩ */
    void mo7076();

    @NonNull
    /* renamed from: Ԫ */
    DataSource mo7077();

    /* renamed from: ԫ */
    void mo7078(@NonNull Priority priority, @NonNull InterfaceC3130<? super T> interfaceC3130);
}
