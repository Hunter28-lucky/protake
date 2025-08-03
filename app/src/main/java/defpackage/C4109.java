package defpackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;
import java.io.IOException;

/* compiled from: GifDrawableEncoder.java */
/* renamed from: ढ़, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4109 implements InterfaceC4797<C3465> {
    @Override // defpackage.InterfaceC4797
    @NonNull
    /* renamed from: Ԩ */
    public EncodeStrategy mo9992(@NonNull C3475 c3475) {
        return EncodeStrategy.SOURCE;
    }

    @Override // defpackage.InterfaceC3823
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7881(@NonNull InterfaceC4536<C3465> interfaceC4536, @NonNull File file, @NonNull C3475 c3475) throws Throwable {
        try {
            C2360.m8828(interfaceC4536.get().m11286(), file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e2);
            }
            return false;
        }
    }
}
