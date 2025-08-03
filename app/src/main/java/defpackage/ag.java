package defpackage;

import com.alipay.sdk.m.x.e;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes.dex */
public class ag {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Stack<e> f32 = new Stack<>();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m41() {
        if (m43()) {
            return;
        }
        Iterator<e> it = this.f32.iterator();
        while (it.hasNext()) {
            it.next().m386();
        }
        this.f32.clear();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m42(e eVar) {
        this.f32.push(eVar);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean m43() {
        return this.f32.isEmpty();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public e m44() {
        return this.f32.pop();
    }
}
