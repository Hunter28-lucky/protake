package defpackage;

import io.reactivex.internal.util.NotificationLite;

/* compiled from: Notification.java */
/* renamed from: ࠐ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3906<T> {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final C3906<Object> f13525 = new C3906<>(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Object f13526;

    public C3906(Object obj) {
        this.f13526 = obj;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T> C3906<T> m12645() {
        return (C3906<T>) f13525;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T> C3906<T> m12646(Throwable th) {
        C4246.m13353(th, "error is null");
        return new C3906<>(NotificationLite.error(th));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T> C3906<T> m12647(T t) {
        C4246.m13353(t, "value is null");
        return new C3906<>(t);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C3906) {
            return C4246.m13351(this.f13526, ((C3906) obj).f13526);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f13526;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f13526;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.f13526 + "]";
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public Throwable m12648() {
        Object obj = this.f13526;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public T m12649() {
        Object obj = this.f13526;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) this.f13526;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean m12650() {
        return this.f13526 == null;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean m12651() {
        return NotificationLite.isError(this.f13526);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean m12652() {
        Object obj = this.f13526;
        return (obj == null || NotificationLite.isError(obj)) ? false : true;
    }
}
