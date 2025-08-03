package defpackage;

import java.io.IOException;

/* compiled from: Appendable.kt */
/* loaded from: classes2.dex */
public class x {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <T> void m8583(Appendable appendable, T t, InterfaceC2392<? super T, ? extends CharSequence> interfaceC2392) throws IOException {
        C3921.m12666(appendable, "<this>");
        if (interfaceC2392 != null) {
            appendable.append(interfaceC2392.invoke(t));
            return;
        }
        if (t == 0 ? true : t instanceof CharSequence) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
