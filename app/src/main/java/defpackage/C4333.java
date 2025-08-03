package defpackage;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import defpackage.InterfaceC3129;
import defpackage.InterfaceC4900;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataUrlLoader.java */
/* renamed from: ઙ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4333<Model, Data> implements InterfaceC4900<Model, Data> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC4334<Data> f14882;

    /* compiled from: DataUrlLoader.java */
    /* renamed from: ઙ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC4334<Data> {
        Data decode(String str) throws IllegalArgumentException;

        /* renamed from: Ϳ, reason: contains not printable characters */
        Class<Data> mo13489();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo13490(Data data) throws IOException;
    }

    /* compiled from: DataUrlLoader.java */
    /* renamed from: ઙ$Ԩ, reason: contains not printable characters */
    public static final class C4335<Data> implements InterfaceC3129<Data> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final String f14883;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4334<Data> f14884;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Data f14885;

        public C4335(String str, InterfaceC4334<Data> interfaceC4334) {
            this.f14883 = str;
            this.f14884 = interfaceC4334;
        }

        @Override // defpackage.InterfaceC3129
        public void cancel() {
        }

        @Override // defpackage.InterfaceC3129
        @NonNull
        /* renamed from: Ϳ */
        public Class<Data> mo7075() {
            return this.f14884.mo13489();
        }

        @Override // defpackage.InterfaceC3129
        /* renamed from: Ԩ */
        public void mo7076() {
            try {
                this.f14884.mo13490(this.f14885);
            } catch (IOException unused) {
            }
        }

        @Override // defpackage.InterfaceC3129
        @NonNull
        /* renamed from: Ԫ */
        public DataSource mo7077() {
            return DataSource.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [Data, java.lang.Object] */
        @Override // defpackage.InterfaceC3129
        /* renamed from: ԫ */
        public void mo7078(@NonNull Priority priority, @NonNull InterfaceC3129.InterfaceC3130<? super Data> interfaceC3130) {
            try {
                Data dataDecode = this.f14884.decode(this.f14883);
                this.f14885 = dataDecode;
                interfaceC3130.mo4919(dataDecode);
            } catch (IllegalArgumentException e2) {
                interfaceC3130.mo4918(e2);
            }
        }
    }

    /* compiled from: DataUrlLoader.java */
    /* renamed from: ઙ$Ԫ, reason: contains not printable characters */
    public static final class C4336<Model> implements InterfaceC5295<Model, InputStream> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC4334<InputStream> f14886 = new C4337();

        /* compiled from: DataUrlLoader.java */
        /* renamed from: ઙ$Ԫ$Ϳ, reason: contains not printable characters */
        public class C4337 implements InterfaceC4334<InputStream> {
            public C4337() {
            }

            @Override // defpackage.C4333.InterfaceC4334
            /* renamed from: Ϳ */
            public Class<InputStream> mo13489() {
                return InputStream.class;
            }

            @Override // defpackage.C4333.InterfaceC4334
            /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public void mo13490(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // defpackage.C4333.InterfaceC4334
            /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public InputStream decode(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<Model, InputStream> mo12(@NonNull C4057 c4057) {
            return new C4333(this.f14886);
        }
    }

    public C4333(InterfaceC4334<Data> interfaceC4334) {
        this.f14882 = interfaceC4334;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ϳ */
    public boolean mo7(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԩ */
    public InterfaceC4900.C4901<Data> mo8(@NonNull Model model, int i, int i2, @NonNull C3475 c3475) {
        return new InterfaceC4900.C4901<>(new C2969(model), new C4335(model.toString(), this.f14882));
    }
}
