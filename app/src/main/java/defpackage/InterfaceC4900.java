package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* compiled from: ModelLoader.java */
/* renamed from: พ, reason: contains not printable characters */
/* loaded from: classes.dex */
public interface InterfaceC4900<Model, Data> {

    /* compiled from: ModelLoader.java */
    /* renamed from: พ$Ϳ, reason: contains not printable characters */
    public static class C4901<Data> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC3773 f16543;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final List<InterfaceC3773> f16544;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final InterfaceC3129<Data> f16545;

        public C4901(@NonNull InterfaceC3773 interfaceC3773, @NonNull InterfaceC3129<Data> interfaceC3129) {
            this(interfaceC3773, Collections.emptyList(), interfaceC3129);
        }

        public C4901(@NonNull InterfaceC3773 interfaceC3773, @NonNull List<InterfaceC3773> list, @NonNull InterfaceC3129<Data> interfaceC3129) {
            this.f16543 = (InterfaceC3773) C4513.m13867(interfaceC3773);
            this.f16544 = (List) C4513.m13867(list);
            this.f16545 = (InterfaceC3129) C4513.m13867(interfaceC3129);
        }
    }

    /* renamed from: Ϳ */
    boolean mo7(@NonNull Model model);

    @Nullable
    /* renamed from: Ԩ */
    C4901<Data> mo8(@NonNull Model model, int i, int i2, @NonNull C3475 c3475);
}
