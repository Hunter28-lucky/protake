package defpackage;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferEncoder.java */
/* renamed from: ߺ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3873 implements InterfaceC3823<ByteBuffer> {
    @Override // defpackage.InterfaceC3823
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7881(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull C3475 c3475) throws Throwable {
        try {
            C2360.m8828(byteBuffer, file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e2);
            }
            return false;
        }
    }
}
