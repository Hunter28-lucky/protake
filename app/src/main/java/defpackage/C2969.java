package defpackage;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: ObjectKey.java */
/* renamed from: ҩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2969 implements InterfaceC3773 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Object f10731;

    public C2969(@NonNull Object obj) {
        this.f10731 = C4513.m13867(obj);
    }

    @Override // defpackage.InterfaceC3773
    public boolean equals(Object obj) {
        if (obj instanceof C2969) {
            return this.f10731.equals(((C2969) obj).f10731);
        }
        return false;
    }

    @Override // defpackage.InterfaceC3773
    public int hashCode() {
        return this.f10731.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f10731 + '}';
    }

    @Override // defpackage.InterfaceC3773
    /* renamed from: Ԩ */
    public void mo7626(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f10731.toString().getBytes(InterfaceC3773.f13027));
    }
}
