package defpackage;

import com.bumptech.glide.load.engine.C1821;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Jobs.java */
/* renamed from: ɀ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2552 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Map<InterfaceC3773, C1821<?>> f9428 = new HashMap();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Map<InterfaceC3773, C1821<?>> f9429 = new HashMap();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C1821<?> m9396(InterfaceC3773 interfaceC3773, boolean z) {
        return m9397(z).get(interfaceC3773);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Map<InterfaceC3773, C1821<?>> m9397(boolean z) {
        return z ? this.f9429 : this.f9428;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m9398(InterfaceC3773 interfaceC3773, C1821<?> c1821) {
        m9397(c1821.m4971()).put(interfaceC3773, c1821);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m9399(InterfaceC3773 interfaceC3773, C1821<?> c1821) {
        Map<InterfaceC3773, C1821<?>> mapM9397 = m9397(c1821.m4971());
        if (c1821.equals(mapM9397.get(interfaceC3773))) {
            mapM9397.remove(interfaceC3773);
        }
    }
}
