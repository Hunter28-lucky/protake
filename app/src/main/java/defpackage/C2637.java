package defpackage;

import androidx.annotation.NonNull;

/* compiled from: BytesResource.java */
/* renamed from: ɾ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2637 implements InterfaceC4536<byte[]> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final byte[] f9815;

    public C2637(byte[] bArr) {
        this.f9815 = (byte[]) C4513.m13867(bArr);
    }

    @Override // defpackage.InterfaceC4536
    public void recycle() {
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f9815;
    }

    @Override // defpackage.InterfaceC4536
    /* renamed from: Ԩ */
    public int mo4977() {
        return this.f9815.length;
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    /* renamed from: ԩ */
    public Class<byte[]> mo4978() {
        return byte[].class;
    }
}
