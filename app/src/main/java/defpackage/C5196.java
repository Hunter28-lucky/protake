package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import defpackage.InterfaceC3129;
import defpackage.InterfaceC4900;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: MultiModelLoader.java */
/* renamed from: Ⴃ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5196<Model, Data> implements InterfaceC4900<Model, Data> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final List<InterfaceC4900<Model, Data>> f17244;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Pools.Pool<List<Throwable>> f17245;

    /* compiled from: MultiModelLoader.java */
    /* renamed from: Ⴃ$Ϳ, reason: contains not printable characters */
    public static class C5197<Data> implements InterfaceC3129<Data>, InterfaceC3129.InterfaceC3130<Data> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final List<InterfaceC3129<Data>> f17246;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Pools.Pool<List<Throwable>> f17247;

        /* renamed from: ԭ, reason: contains not printable characters */
        public int f17248;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public Priority f17249;

        /* renamed from: ԯ, reason: contains not printable characters */
        public InterfaceC3129.InterfaceC3130<? super Data> f17250;

        /* renamed from: ՠ, reason: contains not printable characters */
        @Nullable
        public List<Throwable> f17251;

        public C5197(@NonNull List<InterfaceC3129<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.f17247 = pool;
            C4513.m13866(list);
            this.f17246 = list;
            this.f17248 = 0;
        }

        @Override // defpackage.InterfaceC3129
        public void cancel() {
            Iterator<InterfaceC3129<Data>> it = this.f17246.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // defpackage.InterfaceC3129
        @NonNull
        /* renamed from: Ϳ */
        public Class<Data> mo7075() {
            return this.f17246.get(0).mo7075();
        }

        @Override // defpackage.InterfaceC3129
        /* renamed from: Ԩ */
        public void mo7076() {
            List<Throwable> list = this.f17251;
            if (list != null) {
                this.f17247.release(list);
            }
            this.f17251 = null;
            Iterator<InterfaceC3129<Data>> it = this.f17246.iterator();
            while (it.hasNext()) {
                it.next().mo7076();
            }
        }

        @Override // defpackage.InterfaceC3129.InterfaceC3130
        /* renamed from: ԩ */
        public void mo4918(@NonNull Exception exc) {
            ((List) C4513.m13867(this.f17251)).add(exc);
            m15168();
        }

        @Override // defpackage.InterfaceC3129
        @NonNull
        /* renamed from: Ԫ */
        public DataSource mo7077() {
            return this.f17246.get(0).mo7077();
        }

        @Override // defpackage.InterfaceC3129
        /* renamed from: ԫ */
        public void mo7078(@NonNull Priority priority, @NonNull InterfaceC3129.InterfaceC3130<? super Data> interfaceC3130) {
            this.f17249 = priority;
            this.f17250 = interfaceC3130;
            this.f17251 = this.f17247.acquire();
            this.f17246.get(this.f17248).mo7078(priority, this);
        }

        @Override // defpackage.InterfaceC3129.InterfaceC3130
        /* renamed from: Ԭ */
        public void mo4919(@Nullable Data data) {
            if (data != null) {
                this.f17250.mo4919(data);
            } else {
                m15168();
            }
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final void m15168() {
            if (this.f17248 < this.f17246.size() - 1) {
                this.f17248++;
                mo7078(this.f17249, this.f17250);
            } else {
                C4513.m13867(this.f17251);
                this.f17250.mo4918(new GlideException("Fetch failed", new ArrayList(this.f17251)));
            }
        }
    }

    public C5196(@NonNull List<InterfaceC4900<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f17244 = list;
        this.f17245 = pool;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f17244.toArray()) + '}';
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ϳ */
    public boolean mo7(@NonNull Model model) {
        Iterator<InterfaceC4900<Model, Data>> it = this.f17244.iterator();
        while (it.hasNext()) {
            if (it.next().mo7(model)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԩ */
    public InterfaceC4900.C4901<Data> mo8(@NonNull Model model, int i, int i2, @NonNull C3475 c3475) {
        InterfaceC4900.C4901<Data> c4901Mo8;
        int size = this.f17244.size();
        ArrayList arrayList = new ArrayList(size);
        InterfaceC3773 interfaceC3773 = null;
        for (int i3 = 0; i3 < size; i3++) {
            InterfaceC4900<Model, Data> interfaceC4900 = this.f17244.get(i3);
            if (interfaceC4900.mo7(model) && (c4901Mo8 = interfaceC4900.mo8(model, i, i2, c3475)) != null) {
                interfaceC3773 = c4901Mo8.f16543;
                arrayList.add(c4901Mo8.f16545);
            }
        }
        if (arrayList.isEmpty() || interfaceC3773 == null) {
            return null;
        }
        return new InterfaceC4900.C4901<>(interfaceC3773, new C5197(arrayList, this.f17245));
    }
}
