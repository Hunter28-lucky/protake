package defpackage;

import java.util.List;
import java.util.Map;
import kotlin.reflect.KVisibility;

/* compiled from: KCallable.kt */
/* renamed from: ȯ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public interface InterfaceC2537<R> extends InterfaceC5017 {
    R call(Object... objArr);

    R callBy(Map<Object, ? extends Object> map);

    List<Object> getParameters();

    InterfaceC3179 getReturnType();

    List<Object> getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
