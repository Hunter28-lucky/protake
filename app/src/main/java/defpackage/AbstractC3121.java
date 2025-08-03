package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import defpackage.InterfaceC3129;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher.java */
/* renamed from: ӫ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3121<T> implements InterfaceC3129<T> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Uri f11108;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final ContentResolver f11109;

    /* renamed from: ԭ, reason: contains not printable characters */
    public T f11110;

    public AbstractC3121(ContentResolver contentResolver, Uri uri) {
        this.f11109 = contentResolver;
        this.f11108 = uri;
    }

    @Override // defpackage.InterfaceC3129
    public void cancel() {
    }

    @Override // defpackage.InterfaceC3129
    /* renamed from: Ԩ */
    public void mo7076() {
        T t = this.f11110;
        if (t != null) {
            try {
                mo8131(t);
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: ԩ */
    public abstract void mo8131(T t) throws IOException;

    @Override // defpackage.InterfaceC3129
    @NonNull
    /* renamed from: Ԫ */
    public DataSource mo7077() {
        return DataSource.LOCAL;
    }

    @Override // defpackage.InterfaceC3129
    /* renamed from: ԫ */
    public final void mo7078(@NonNull Priority priority, @NonNull InterfaceC3129.InterfaceC3130<? super T> interfaceC3130) {
        try {
            T tMo8132 = mo8132(this.f11108, this.f11109);
            this.f11110 = tMo8132;
            interfaceC3130.mo4919(tMo8132);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e2);
            }
            interfaceC3130.mo4918(e2);
        }
    }

    /* renamed from: Ԭ */
    public abstract T mo8132(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}
