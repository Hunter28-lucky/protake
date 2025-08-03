package defpackage;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ResourceDecoderRegistry.java */
/* renamed from: ഛ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4705 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final List<String> f15969 = new ArrayList();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Map<String, List<C4706<?, ?>>> f15970 = new HashMap();

    /* compiled from: ResourceDecoderRegistry.java */
    /* renamed from: ഛ$Ϳ, reason: contains not printable characters */
    public static class C4706<T, R> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Class<T> f15971;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final Class<R> f15972;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final InterfaceC3907<T, R> f15973;

        public C4706(@NonNull Class<T> cls, @NonNull Class<R> cls2, InterfaceC3907<T, R> interfaceC3907) {
            this.f15971 = cls;
            this.f15972 = cls2;
            this.f15973 = interfaceC3907;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean m14243(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f15971.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f15972);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public synchronized <T, R> void m14238(@NonNull String str, @NonNull InterfaceC3907<T, R> interfaceC3907, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        m14240(str).add(new C4706<>(cls, cls2, interfaceC3907));
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized <T, R> List<InterfaceC3907<T, R>> m14239(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f15969.iterator();
        while (it.hasNext()) {
            List<C4706<?, ?>> list = this.f15970.get(it.next());
            if (list != null) {
                for (C4706<?, ?> c4706 : list) {
                    if (c4706.m14243(cls, cls2)) {
                        arrayList.add(c4706.f15973);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters */
    public final synchronized List<C4706<?, ?>> m14240(@NonNull String str) {
        List<C4706<?, ?>> arrayList;
        if (!this.f15969.contains(str)) {
            this.f15969.add(str);
        }
        arrayList = this.f15970.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f15970.put(str, arrayList);
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters */
    public synchronized <T, R> List<Class<R>> m14241(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f15969.iterator();
        while (it.hasNext()) {
            List<C4706<?, ?>> list = this.f15970.get(it.next());
            if (list != null) {
                for (C4706<?, ?> c4706 : list) {
                    if (c4706.m14243(cls, cls2) && !arrayList.contains(c4706.f15972)) {
                        arrayList.add(c4706.f15972);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public synchronized void m14242(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f15969);
        this.f15969.clear();
        this.f15969.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f15969.add(str);
            }
        }
    }
}
