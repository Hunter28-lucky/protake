package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.C1812;
import defpackage.C3475;
import defpackage.C4513;
import defpackage.InterfaceC2866;
import defpackage.InterfaceC4536;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: LoadPath.java */
/* renamed from: com.bumptech.glide.load.engine.ׯ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1826<Data, ResourceType, Transcode> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Class<Data> f5336;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Pools.Pool<List<Throwable>> f5337;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final List<? extends C1812<Data, ResourceType, Transcode>> f5338;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String f5339;

    public C1826(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<C1812<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f5336 = cls;
        this.f5337 = pool;
        this.f5338 = (List) C4513.m13866(list);
        this.f5339 = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f5338.toArray()) + '}';
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public InterfaceC4536<Transcode> m4983(InterfaceC2866<Data> interfaceC2866, @NonNull C3475 c3475, int i, int i2, C1812.InterfaceC1813<ResourceType> interfaceC1813) throws GlideException {
        List<Throwable> list = (List) C4513.m13867(this.f5337.acquire());
        try {
            return m4984(interfaceC2866, c3475, i, i2, interfaceC1813, list);
        } finally {
            this.f5337.release(list);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC4536<Transcode> m4984(InterfaceC2866<Data> interfaceC2866, @NonNull C3475 c3475, int i, int i2, C1812.InterfaceC1813<ResourceType> interfaceC1813, List<Throwable> list) throws GlideException {
        int size = this.f5338.size();
        InterfaceC4536<Transcode> interfaceC4536M4943 = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                interfaceC4536M4943 = this.f5338.get(i3).m4943(interfaceC2866, i, i2, c3475, interfaceC1813);
            } catch (GlideException e2) {
                list.add(e2);
            }
            if (interfaceC4536M4943 != null) {
                break;
            }
        }
        if (interfaceC4536M4943 != null) {
            return interfaceC4536M4943;
        }
        throw new GlideException(this.f5339, new ArrayList(list));
    }
}
