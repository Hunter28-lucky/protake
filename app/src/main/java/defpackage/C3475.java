package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;

/* compiled from: Options.java */
/* renamed from: ؽ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3475 implements InterfaceC3773 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final ArrayMap<C4238<?>, Object> f11984 = new C2756();

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Ԭ, reason: contains not printable characters */
    public static <T> void m11328(@NonNull C4238<T> c4238, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        c4238.m13345(obj, messageDigest);
    }

    @Override // defpackage.InterfaceC3773
    public boolean equals(Object obj) {
        if (obj instanceof C3475) {
            return this.f11984.equals(((C3475) obj).f11984);
        }
        return false;
    }

    @Override // defpackage.InterfaceC3773
    public int hashCode() {
        return this.f11984.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f11984 + '}';
    }

    @Override // defpackage.InterfaceC3773
    /* renamed from: Ԩ */
    public void mo7626(@NonNull MessageDigest messageDigest) {
        for (int i = 0; i < this.f11984.size(); i++) {
            m11328(this.f11984.keyAt(i), this.f11984.valueAt(i), messageDigest);
        }
    }

    @Nullable
    /* renamed from: ԩ, reason: contains not printable characters */
    public <T> T m11329(@NonNull C4238<T> c4238) {
        return this.f11984.containsKey(c4238) ? (T) this.f11984.get(c4238) : c4238.m13343();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m11330(@NonNull C3475 c3475) {
        this.f11984.putAll((SimpleArrayMap<? extends C4238<?>, ? extends Object>) c3475.f11984);
    }

    @NonNull
    /* renamed from: ԫ, reason: contains not printable characters */
    public <T> C3475 m11331(@NonNull C4238<T> c4238, @NonNull T t) {
        this.f11984.put(c4238, t);
        return this;
    }
}
