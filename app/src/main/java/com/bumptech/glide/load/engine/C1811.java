package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.DecodeJob;
import defpackage.AbstractC3541;
import defpackage.C2964;
import defpackage.C3475;
import defpackage.InterfaceC3238;
import defpackage.InterfaceC3773;
import defpackage.InterfaceC3823;
import defpackage.InterfaceC4536;
import defpackage.InterfaceC4797;
import defpackage.InterfaceC4900;
import defpackage.InterfaceC4950;
import defpackage.a3;
import defpackage.n4;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeHelper.java */
/* renamed from: com.bumptech.glide.load.engine.Ԭ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C1811<Transcode> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final List<InterfaceC4900.C4901<?>> f5257 = new ArrayList();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final List<InterfaceC3773> f5258 = new ArrayList();

    /* renamed from: ԩ, reason: contains not printable characters */
    public C2964 f5259;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public Object f5260;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f5261;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f5262;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Class<?> f5263;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public DecodeJob.InterfaceC1800 f5264;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C3475 f5265;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Map<Class<?>, a3<?>> f5266;

    /* renamed from: ֈ, reason: contains not printable characters */
    public Class<Transcode> f5267;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f5268;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f5269;

    /* renamed from: ؠ, reason: contains not printable characters */
    public InterfaceC3773 f5270;

    /* renamed from: ހ, reason: contains not printable characters */
    public Priority f5271;

    /* renamed from: ށ, reason: contains not printable characters */
    public AbstractC3541 f5272;

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean f5273;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f5274;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m4920() {
        this.f5259 = null;
        this.f5260 = null;
        this.f5270 = null;
        this.f5263 = null;
        this.f5267 = null;
        this.f5265 = null;
        this.f5271 = null;
        this.f5266 = null;
        this.f5272 = null;
        this.f5257.clear();
        this.f5268 = false;
        this.f5258.clear();
        this.f5269 = false;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public InterfaceC4950 m4921() {
        return this.f5259.m10372();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public List<InterfaceC3773> m4922() {
        if (!this.f5269) {
            this.f5269 = true;
            this.f5258.clear();
            List<InterfaceC4900.C4901<?>> listM4926 = m4926();
            int size = listM4926.size();
            for (int i = 0; i < size; i++) {
                InterfaceC4900.C4901<?> c4901 = listM4926.get(i);
                if (!this.f5258.contains(c4901.f16543)) {
                    this.f5258.add(c4901.f16543);
                }
                for (int i2 = 0; i2 < c4901.f16544.size(); i2++) {
                    if (!this.f5258.contains(c4901.f16544.get(i2))) {
                        this.f5258.add(c4901.f16544.get(i2));
                    }
                }
            }
        }
        return this.f5258;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public InterfaceC3238 m4923() {
        return this.f5264.mo4890();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3541 m4924() {
        return this.f5272;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int m4925() {
        return this.f5262;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public List<InterfaceC4900.C4901<?>> m4926() {
        if (!this.f5268) {
            this.f5268 = true;
            this.f5257.clear();
            List listM4840 = this.f5259.m10377().m4840(this.f5260);
            int size = listM4840.size();
            for (int i = 0; i < size; i++) {
                InterfaceC4900.C4901<?> c4901Mo8 = ((InterfaceC4900) listM4840.get(i)).mo8(this.f5260, this.f5261, this.f5262, this.f5265);
                if (c4901Mo8 != null) {
                    this.f5257.add(c4901Mo8);
                }
            }
        }
        return this.f5257;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public <Data> C1826<Data, ?, Transcode> m4927(Class<Data> cls) {
        return this.f5259.m10377().m4839(cls, this.f5263, this.f5267);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public List<InterfaceC4900<File, ?>> m4928(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f5259.m10377().m4840(file);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public C3475 m4929() {
        return this.f5265;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public Priority m4930() {
        return this.f5271;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public List<Class<?>> m4931() {
        return this.f5259.m10377().m4841(this.f5260.getClass(), this.f5263, this.f5267);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public <Z> InterfaceC4797<Z> m4932(InterfaceC4536<Z> interfaceC4536) {
        return this.f5259.m10377().m4842(interfaceC4536);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public InterfaceC3773 m4933() {
        return this.f5270;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public <X> InterfaceC3823<X> m4934(X x) throws Registry.NoSourceEncoderAvailableException {
        return this.f5259.m10377().m4844(x);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public Class<?> m4935() {
        return this.f5267;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public <Z> a3<Z> m4936(Class<Z> cls) {
        a3<Z> a3Var = (a3) this.f5266.get(cls);
        if (a3Var == null) {
            Iterator<Map.Entry<Class<?>, a3<?>>> it = this.f5266.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, a3<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    a3Var = (a3) next.getValue();
                    break;
                }
            }
        }
        if (a3Var != null) {
            return a3Var;
        }
        if (!this.f5266.isEmpty() || !this.f5273) {
            return n4.m7625();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public int m4937() {
        return this.f5261;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ބ, reason: contains not printable characters */
    public boolean m4938(Class<?> cls) {
        return m4927(cls) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ޅ, reason: contains not printable characters */
    public <R> void m4939(C2964 c2964, Object obj, InterfaceC3773 interfaceC3773, int i, int i2, AbstractC3541 abstractC3541, Class<?> cls, Class<R> cls2, Priority priority, C3475 c3475, Map<Class<?>, a3<?>> map, boolean z, boolean z2, DecodeJob.InterfaceC1800 interfaceC1800) {
        this.f5259 = c2964;
        this.f5260 = obj;
        this.f5270 = interfaceC3773;
        this.f5261 = i;
        this.f5262 = i2;
        this.f5272 = abstractC3541;
        this.f5263 = cls;
        this.f5264 = interfaceC1800;
        this.f5267 = cls2;
        this.f5271 = priority;
        this.f5265 = c3475;
        this.f5266 = map;
        this.f5273 = z;
        this.f5274 = z2;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public boolean m4940(InterfaceC4536<?> interfaceC4536) {
        return this.f5259.m10377().m4845(interfaceC4536);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public boolean m4941() {
        return this.f5274;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean m4942(InterfaceC3773 interfaceC3773) {
        List<InterfaceC4900.C4901<?>> listM4926 = m4926();
        int size = listM4926.size();
        for (int i = 0; i < size; i++) {
            if (listM4926.get(i).f16543.equals(interfaceC3773)) {
                return true;
            }
        }
        return false;
    }
}
