package defpackage;

import androidx.annotation.NonNull;
import defpackage.InterfaceC2866;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferRewinder.java */
/* renamed from: ȋ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2515 implements InterfaceC2866<ByteBuffer> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final ByteBuffer f9330;

    /* compiled from: ByteBufferRewinder.java */
    /* renamed from: ȋ$Ϳ, reason: contains not printable characters */
    public static class C2516 implements InterfaceC2866.InterfaceC2867<ByteBuffer> {
        @Override // defpackage.InterfaceC2866.InterfaceC2867
        @NonNull
        /* renamed from: Ϳ */
        public Class<ByteBuffer> mo9069() {
            return ByteBuffer.class;
        }

        @Override // defpackage.InterfaceC2866.InterfaceC2867
        @NonNull
        /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2866<ByteBuffer> mo9070(ByteBuffer byteBuffer) {
            return new C2515(byteBuffer);
        }
    }

    public C2515(ByteBuffer byteBuffer) {
        this.f9330 = byteBuffer;
    }

    @Override // defpackage.InterfaceC2866
    /* renamed from: Ԩ */
    public void mo9067() {
    }

    @Override // defpackage.InterfaceC2866
    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public ByteBuffer mo9066() {
        this.f9330.position(0);
        return this.f9330;
    }
}
