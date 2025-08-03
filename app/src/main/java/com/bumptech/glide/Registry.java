package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.C1812;
import com.bumptech.glide.load.engine.C1826;
import defpackage.C2371;
import defpackage.C2380;
import defpackage.C2408;
import defpackage.C2507;
import defpackage.C2841;
import defpackage.C4065;
import defpackage.C4279;
import defpackage.C4705;
import defpackage.C5033;
import defpackage.InterfaceC2866;
import defpackage.InterfaceC3462;
import defpackage.InterfaceC3823;
import defpackage.InterfaceC3907;
import defpackage.InterfaceC4536;
import defpackage.InterfaceC4797;
import defpackage.InterfaceC4900;
import defpackage.InterfaceC5295;
import defpackage.z2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Registry {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C2507 f5154;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C2408 f5155;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C4705 f5156;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C2371 f5157;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C5033 f5158;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final z2 f5159;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final C4065 f5160;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final C2841 f5161 = new C2841();

    /* renamed from: ԯ, reason: contains not printable characters */
    public final C4279 f5162 = new C4279();

    /* renamed from: ՠ, reason: contains not printable characters */
    public final Pools.Pool<List<Throwable>> f5163;

    public static class MissingComponentException extends RuntimeException {
        public MissingComponentException(@NonNull String str) {
            super(str);
        }
    }

    public static final class NoImageHeaderParserException extends MissingComponentException {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }

        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public Registry() {
        Pools.Pool<List<Throwable>> poolM8869 = C2380.m8869();
        this.f5163 = poolM8869;
        this.f5154 = new C2507(poolM8869);
        this.f5155 = new C2408();
        this.f5156 = new C4705();
        this.f5157 = new C2371();
        this.f5158 = new C5033();
        this.f5159 = new z2();
        this.f5160 = new C4065();
        m4849(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    @NonNull
    /* renamed from: Ϳ, reason: contains not printable characters */
    public <Data> Registry m4832(@NonNull Class<Data> cls, @NonNull InterfaceC3823<Data> interfaceC3823) {
        this.f5155.m8900(cls, interfaceC3823);
        return this;
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public <TResource> Registry m4833(@NonNull Class<TResource> cls, @NonNull InterfaceC4797<TResource> interfaceC4797) {
        this.f5157.m8837(cls, interfaceC4797);
        return this;
    }

    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters */
    public <Model, Data> Registry m4834(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull InterfaceC5295<Model, Data> interfaceC5295) {
        this.f5154.m9257(cls, cls2, interfaceC5295);
        return this;
    }

    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters */
    public <Data, TResource> Registry m4835(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull InterfaceC3907<Data, TResource> interfaceC3907) {
        m4836("legacy_append", cls, cls2, interfaceC3907);
        return this;
    }

    @NonNull
    /* renamed from: ԫ, reason: contains not printable characters */
    public <Data, TResource> Registry m4836(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull InterfaceC3907<Data, TResource> interfaceC3907) {
        this.f5156.m14238(str, interfaceC3907, cls, cls2);
        return this;
    }

    @NonNull
    /* renamed from: Ԭ, reason: contains not printable characters */
    public final <Data, TResource, Transcode> List<C1812<Data, TResource, Transcode>> m4837(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f5156.m14241(cls, cls2)) {
            for (Class cls5 : this.f5159.m8641(cls4, cls3)) {
                arrayList.add(new C1812(cls, cls4, cls5, this.f5156.m14239(cls, cls4), this.f5159.m8640(cls4, cls5), this.f5163));
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: ԭ, reason: contains not printable characters */
    public List<ImageHeaderParser> m4838() {
        List<ImageHeaderParser> listM13000 = this.f5160.m13000();
        if (listM13000.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return listM13000;
    }

    @Nullable
    /* renamed from: Ԯ, reason: contains not printable characters */
    public <Data, TResource, Transcode> C1826<Data, TResource, Transcode> m4839(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        C1826<Data, TResource, Transcode> c1826M13394 = this.f5162.m13394(cls, cls2, cls3);
        if (this.f5162.m13396(c1826M13394)) {
            return null;
        }
        if (c1826M13394 == null) {
            List<C1812<Data, TResource, Transcode>> listM4837 = m4837(cls, cls2, cls3);
            c1826M13394 = listM4837.isEmpty() ? null : new C1826<>(cls, cls2, cls3, listM4837, this.f5163);
            this.f5162.m13397(cls, cls2, cls3, c1826M13394);
        }
        return c1826M13394;
    }

    @NonNull
    /* renamed from: ԯ, reason: contains not printable characters */
    public <Model> List<InterfaceC4900<Model, ?>> m4840(@NonNull Model model) {
        List<InterfaceC4900<Model, ?>> listM9259 = this.f5154.m9259(model);
        if (listM9259.isEmpty()) {
            throw new NoModelLoaderAvailableException(model);
        }
        return listM9259;
    }

    @NonNull
    /* renamed from: ՠ, reason: contains not printable characters */
    public <Model, TResource, Transcode> List<Class<?>> m4841(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> listM10181 = this.f5161.m10181(cls, cls2);
        if (listM10181 == null) {
            listM10181 = new ArrayList<>();
            Iterator<Class<?>> it = this.f5154.m9258(cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f5156.m14241(it.next(), cls2)) {
                    if (!this.f5159.m8641(cls4, cls3).isEmpty() && !listM10181.contains(cls4)) {
                        listM10181.add(cls4);
                    }
                }
            }
            this.f5161.m10182(cls, cls2, Collections.unmodifiableList(listM10181));
        }
        return listM10181;
    }

    @NonNull
    /* renamed from: ֈ, reason: contains not printable characters */
    public <X> InterfaceC4797<X> m4842(@NonNull InterfaceC4536<X> interfaceC4536) throws NoResultEncoderAvailableException {
        InterfaceC4797<X> interfaceC4797M8838 = this.f5157.m8838(interfaceC4536.mo4978());
        if (interfaceC4797M8838 != null) {
            return interfaceC4797M8838;
        }
        throw new NoResultEncoderAvailableException(interfaceC4536.mo4978());
    }

    @NonNull
    /* renamed from: ֏, reason: contains not printable characters */
    public <X> InterfaceC2866<X> m4843(@NonNull X x) {
        return this.f5158.m14837(x);
    }

    @NonNull
    /* renamed from: ׯ, reason: contains not printable characters */
    public <X> InterfaceC3823<X> m4844(@NonNull X x) throws NoSourceEncoderAvailableException {
        InterfaceC3823<X> interfaceC3823M8901 = this.f5155.m8901(x.getClass());
        if (interfaceC3823M8901 != null) {
            return interfaceC3823M8901;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean m4845(@NonNull InterfaceC4536<?> interfaceC4536) {
        return this.f5157.m8838(interfaceC4536.mo4978()) != null;
    }

    @NonNull
    /* renamed from: ހ, reason: contains not printable characters */
    public Registry m4846(@NonNull InterfaceC2866.InterfaceC2867<?> interfaceC2867) {
        this.f5158.m14838(interfaceC2867);
        return this;
    }

    @NonNull
    /* renamed from: ށ, reason: contains not printable characters */
    public Registry m4847(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f5160.m12999(imageHeaderParser);
        return this;
    }

    @NonNull
    /* renamed from: ނ, reason: contains not printable characters */
    public <TResource, Transcode> Registry m4848(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull InterfaceC3462<TResource, Transcode> interfaceC3462) {
        this.f5159.m8642(cls, cls2, interfaceC3462);
        return this;
    }

    @NonNull
    /* renamed from: ރ, reason: contains not printable characters */
    public final Registry m4849(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f5156.m14242(arrayList);
        return this;
    }
}
