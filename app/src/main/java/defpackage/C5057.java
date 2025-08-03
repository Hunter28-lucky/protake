package defpackage;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import defpackage.InterfaceC3129;
import defpackage.InterfaceC4900;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ByteArrayLoader.java */
/* renamed from: ར, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5057<Data> implements InterfaceC4900<byte[], Data> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC5060<Data> f16838;

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: ར$Ϳ, reason: contains not printable characters */
    public static class C5058 implements InterfaceC5295<byte[], ByteBuffer> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: ར$Ϳ$Ϳ, reason: contains not printable characters */
        public class C5059 implements InterfaceC5060<ByteBuffer> {
            public C5059() {
            }

            @Override // defpackage.C5057.InterfaceC5060
            /* renamed from: Ϳ, reason: contains not printable characters */
            public Class<ByteBuffer> mo14872() {
                return ByteBuffer.class;
            }

            @Override // defpackage.C5057.InterfaceC5060
            /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public ByteBuffer mo14873(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<byte[], ByteBuffer> mo12(@NonNull C4057 c4057) {
            return new C5057(new C5059());
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: ར$Ԩ, reason: contains not printable characters */
    public interface InterfaceC5060<Data> {
        /* renamed from: Ϳ */
        Class<Data> mo14872();

        /* renamed from: Ԩ */
        Data mo14873(byte[] bArr);
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: ར$Ԫ, reason: contains not printable characters */
    public static class C5061<Data> implements InterfaceC3129<Data> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final byte[] f16840;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC5060<Data> f16841;

        public C5061(byte[] bArr, InterfaceC5060<Data> interfaceC5060) {
            this.f16840 = bArr;
            this.f16841 = interfaceC5060;
        }

        @Override // defpackage.InterfaceC3129
        public void cancel() {
        }

        @Override // defpackage.InterfaceC3129
        @NonNull
        /* renamed from: Ϳ */
        public Class<Data> mo7075() {
            return this.f16841.mo14872();
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
        public void mo7078(@NonNull Priority priority, @NonNull InterfaceC3129.InterfaceC3130<? super Data> interfaceC3130) {
            interfaceC3130.mo4919(this.f16841.mo14873(this.f16840));
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: ར$Ԭ, reason: contains not printable characters */
    public static class C5062 implements InterfaceC5295<byte[], InputStream> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: ར$Ԭ$Ϳ, reason: contains not printable characters */
        public class C5063 implements InterfaceC5060<InputStream> {
            public C5063() {
            }

            @Override // defpackage.C5057.InterfaceC5060
            /* renamed from: Ϳ */
            public Class<InputStream> mo14872() {
                return InputStream.class;
            }

            @Override // defpackage.C5057.InterfaceC5060
            /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public InputStream mo14873(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<byte[], InputStream> mo12(@NonNull C4057 c4057) {
            return new C5057(new C5063());
        }
    }

    public C5057(InterfaceC5060<Data> interfaceC5060) {
        this.f16838 = interfaceC5060;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4900.C4901<Data> mo8(@NonNull byte[] bArr, int i, int i2, @NonNull C3475 c3475) {
        return new InterfaceC4900.C4901<>(new C2969(bArr), new C5061(bArr, this.f16838));
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7(@NonNull byte[] bArr) {
        return true;
    }
}
