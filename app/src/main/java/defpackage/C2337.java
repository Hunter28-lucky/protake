package defpackage;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import defpackage.InterfaceC3129;
import defpackage.InterfaceC4900;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferFileLoader.java */
/* renamed from: ĭ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2337 implements InterfaceC4900<File, ByteBuffer> {

    /* compiled from: ByteBufferFileLoader.java */
    /* renamed from: ĭ$Ϳ, reason: contains not printable characters */
    public static final class C2338 implements InterfaceC3129<ByteBuffer> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final File f8869;

        public C2338(File file) {
            this.f8869 = file;
        }

        @Override // defpackage.InterfaceC3129
        public void cancel() {
        }

        @Override // defpackage.InterfaceC3129
        @NonNull
        /* renamed from: Ϳ */
        public Class<ByteBuffer> mo7075() {
            return ByteBuffer.class;
        }

        @Override // defpackage.InterfaceC3129
        /* renamed from: Ԩ */
        public void mo7076() {
        }

        @Override // defpackage.InterfaceC3129
        @NonNull
        /* renamed from: Ԫ */
        public DataSource mo7077() {
            return DataSource.LOCAL;
        }

        @Override // defpackage.InterfaceC3129
        /* renamed from: ԫ */
        public void mo7078(@NonNull Priority priority, @NonNull InterfaceC3129.InterfaceC3130<? super ByteBuffer> interfaceC3130) {
            try {
                interfaceC3130.mo4919(C2360.m8825(this.f8869));
            } catch (IOException e2) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e2);
                }
                interfaceC3130.mo4918(e2);
            }
        }
    }

    /* compiled from: ByteBufferFileLoader.java */
    /* renamed from: ĭ$Ԩ, reason: contains not printable characters */
    public static class C2339 implements InterfaceC5295<File, ByteBuffer> {
        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<File, ByteBuffer> mo12(@NonNull C4057 c4057) {
            return new C2337();
        }
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4900.C4901<ByteBuffer> mo8(@NonNull File file, int i, int i2, @NonNull C3475 c3475) {
        return new InterfaceC4900.C4901<>(new C2969(file), new C2338(file));
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7(@NonNull File file) {
        return true;
    }
}
