package defpackage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker.java */
/* renamed from: ࡔ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3946 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Set<InterfaceC3684> f13597 = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final List<InterfaceC3684> f13598 = new ArrayList();

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean f13599;

    public String toString() {
        return super.toString() + "{numRequests=" + this.f13597.size() + ", isPaused=" + this.f13599 + "}";
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean m12719(@Nullable InterfaceC3684 interfaceC3684, boolean z) {
        boolean z2 = true;
        if (interfaceC3684 == null) {
            return true;
        }
        boolean zRemove = this.f13597.remove(interfaceC3684);
        if (!this.f13598.remove(interfaceC3684) && !zRemove) {
            z2 = false;
        }
        if (z2) {
            interfaceC3684.clear();
            if (z) {
                interfaceC3684.recycle();
            }
        }
        return z2;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean m12720(@Nullable InterfaceC3684 interfaceC3684) {
        return m12719(interfaceC3684, true);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m12721() {
        Iterator it = j5.m7092(this.f13597).iterator();
        while (it.hasNext()) {
            m12719((InterfaceC3684) it.next(), false);
        }
        this.f13598.clear();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m12722() {
        this.f13599 = true;
        for (InterfaceC3684 interfaceC3684 : j5.m7092(this.f13597)) {
            if (interfaceC3684.isRunning()) {
                interfaceC3684.pause();
                this.f13598.add(interfaceC3684);
            }
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m12723() {
        for (InterfaceC3684 interfaceC3684 : j5.m7092(this.f13597)) {
            if (!interfaceC3684.isComplete() && !interfaceC3684.isCancelled()) {
                interfaceC3684.pause();
                if (this.f13599) {
                    this.f13598.add(interfaceC3684);
                } else {
                    interfaceC3684.mo5034();
                }
            }
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m12724() {
        this.f13599 = false;
        for (InterfaceC3684 interfaceC3684 : j5.m7092(this.f13597)) {
            if (!interfaceC3684.isComplete() && !interfaceC3684.isCancelled() && !interfaceC3684.isRunning()) {
                interfaceC3684.mo5034();
            }
        }
        this.f13598.clear();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m12725(@NonNull InterfaceC3684 interfaceC3684) {
        this.f13597.add(interfaceC3684);
        if (!this.f13599) {
            interfaceC3684.mo5034();
            return;
        }
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f13598.add(interfaceC3684);
    }
}
