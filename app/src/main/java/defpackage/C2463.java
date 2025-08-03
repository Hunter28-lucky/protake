package defpackage;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import defpackage.InterfaceC2866;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: InputStreamRewinder.java */
/* renamed from: ƶ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2463 implements InterfaceC2866<InputStream> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final RecyclableBufferedInputStream f9162;

    /* compiled from: InputStreamRewinder.java */
    /* renamed from: ƶ$Ϳ, reason: contains not printable characters */
    public static final class C2464 implements InterfaceC2866.InterfaceC2867<InputStream> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC4950 f9163;

        public C2464(InterfaceC4950 interfaceC4950) {
            this.f9163 = interfaceC4950;
        }

        @Override // defpackage.InterfaceC2866.InterfaceC2867
        @NonNull
        /* renamed from: Ϳ, reason: contains not printable characters */
        public Class<InputStream> mo9069() {
            return InputStream.class;
        }

        @Override // defpackage.InterfaceC2866.InterfaceC2867
        @NonNull
        /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2866<InputStream> mo9070(InputStream inputStream) {
            return new C2463(inputStream, this.f9163);
        }
    }

    public C2463(InputStream inputStream, InterfaceC4950 interfaceC4950) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, interfaceC4950);
        this.f9162 = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    @Override // defpackage.InterfaceC2866
    /* renamed from: Ԩ, reason: contains not printable characters */
    public void mo9067() {
        this.f9162.release();
    }

    @Override // defpackage.InterfaceC2866
    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InputStream mo9066() throws IOException {
        this.f9162.reset();
        return this.f9162;
    }
}
