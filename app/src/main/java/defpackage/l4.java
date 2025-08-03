package defpackage;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import defpackage.InterfaceC3129;
import defpackage.InterfaceC4900;

/* compiled from: UnitModelLoader.java */
/* loaded from: classes.dex */
public class l4<Model> implements InterfaceC4900<Model, Model> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final l4<?> f7947 = new l4<>();

    /* compiled from: UnitModelLoader.java */
    /* renamed from: l4$Ϳ, reason: contains not printable characters */
    public static class C2167<Model> implements InterfaceC5295<Model, Model> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final C2167<?> f7948 = new C2167<>();

        @Deprecated
        public C2167() {
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static <T> C2167<T> m7485() {
            return (C2167<T>) f7948;
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<Model, Model> mo12(C4057 c4057) {
            return l4.m7484();
        }
    }

    /* compiled from: UnitModelLoader.java */
    /* renamed from: l4$Ԩ, reason: contains not printable characters */
    public static class C2168<Model> implements InterfaceC3129<Model> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Model f7949;

        public C2168(Model model) {
            this.f7949 = model;
        }

        @Override // defpackage.InterfaceC3129
        public void cancel() {
        }

        @Override // defpackage.InterfaceC3129
        @NonNull
        /* renamed from: Ϳ */
        public Class<Model> mo7075() {
            return (Class<Model>) this.f7949.getClass();
        }

        @Override // defpackage.InterfaceC3129
        /* renamed from: Ԩ */
        public void mo7076() {
        }

        @Override // defpackage.InterfaceC3129
        @NonNull
        /* renamed from: Ԫ */
        public DataSource mo7077() {
            return DataSource.LOCAL;
        }

        @Override // defpackage.InterfaceC3129
        /* renamed from: ԫ */
        public void mo7078(@NonNull Priority priority, @NonNull InterfaceC3129.InterfaceC3130<? super Model> interfaceC3130) {
            interfaceC3130.mo4919(this.f7949);
        }
    }

    @Deprecated
    public l4() {
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T> l4<T> m7484() {
        return (l4<T>) f7947;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ϳ */
    public boolean mo7(@NonNull Model model) {
        return true;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԩ */
    public InterfaceC4900.C4901<Model> mo8(@NonNull Model model, int i, int i2, @NonNull C3475 c3475) {
        return new InterfaceC4900.C4901<>(new C2969(model), new C2168(model));
    }
}
