package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import defpackage.C3475;
import defpackage.C4513;
import defpackage.InterfaceC2866;
import defpackage.InterfaceC3462;
import defpackage.InterfaceC3907;
import defpackage.InterfaceC4536;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DecodePath.java */
/* renamed from: com.bumptech.glide.load.engine.Ԯ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1812<DataType, ResourceType, Transcode> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Class<DataType> f5275;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final List<? extends InterfaceC3907<DataType, ResourceType>> f5276;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final InterfaceC3462<ResourceType, Transcode> f5277;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Pools.Pool<List<Throwable>> f5278;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final String f5279;

    /* compiled from: DecodePath.java */
    /* renamed from: com.bumptech.glide.load.engine.Ԯ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC1813<ResourceType> {
        @NonNull
        /* renamed from: Ϳ */
        InterfaceC4536<ResourceType> mo4885(@NonNull InterfaceC4536<ResourceType> interfaceC4536);
    }

    public C1812(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends InterfaceC3907<DataType, ResourceType>> list, InterfaceC3462<ResourceType, Transcode> interfaceC3462, Pools.Pool<List<Throwable>> pool) {
        this.f5275 = cls;
        this.f5276 = list;
        this.f5277 = interfaceC3462;
        this.f5278 = pool;
        this.f5279 = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f5275 + ", decoders=" + this.f5276 + ", transcoder=" + this.f5277 + '}';
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public InterfaceC4536<Transcode> m4943(InterfaceC2866<DataType> interfaceC2866, int i, int i2, @NonNull C3475 c3475, InterfaceC1813<ResourceType> interfaceC1813) throws GlideException {
        return this.f5277.mo7539(interfaceC1813.mo4885(m4944(interfaceC2866, i, i2, c3475)), c3475);
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC4536<ResourceType> m4944(InterfaceC2866<DataType> interfaceC2866, int i, int i2, @NonNull C3475 c3475) throws GlideException {
        List<Throwable> list = (List) C4513.m13867(this.f5278.acquire());
        try {
            return m4945(interfaceC2866, i, i2, c3475, list);
        } finally {
            this.f5278.release(list);
        }
    }

    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters */
    public final InterfaceC4536<ResourceType> m4945(InterfaceC2866<DataType> interfaceC2866, int i, int i2, @NonNull C3475 c3475, List<Throwable> list) throws GlideException {
        int size = this.f5276.size();
        InterfaceC4536<ResourceType> interfaceC4536Mo5018 = null;
        for (int i3 = 0; i3 < size; i3++) {
            InterfaceC3907<DataType, ResourceType> interfaceC3907 = this.f5276.get(i3);
            try {
                if (interfaceC3907.mo5017(interfaceC2866.mo9066(), c3475)) {
                    interfaceC4536Mo5018 = interfaceC3907.mo5018(interfaceC2866.mo9066(), i, i2, c3475);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + interfaceC3907, e2);
                }
                list.add(e2);
            }
            if (interfaceC4536Mo5018 != null) {
                break;
            }
        }
        if (interfaceC4536Mo5018 != null) {
            return interfaceC4536Mo5018;
        }
        throw new GlideException(this.f5279, new ArrayList(list));
    }
}
