package defpackage;

import android.content.Context;
import android.location.Location;

/* compiled from: MapManager.java */
/* renamed from: ԓ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3151 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static C3151 f11184;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Context f11185;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f11186 = false;

    /* compiled from: MapManager.java */
    /* renamed from: ԓ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC3152 {
        /* renamed from: Ϳ */
        void mo1327(Location location);
    }

    public C3151(Context context, boolean z) {
        this.f11185 = context;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C3151 m10755(Context context, boolean z) {
        if (f11184 == null) {
            synchronized (C3151.class) {
                if (f11184 == null) {
                    f11184 = new C3151(context, z);
                }
            }
        }
        return f11184;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Location m10756() {
        return t0.m8253(this.f11185).m8259();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public C3151 m10757(InterfaceC3152 interfaceC3152) {
        t0.m8253(this.f11185).m8267(interfaceC3152);
        return this;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m10758() {
        this.f11186 = true;
        t0.m8253(this.f11185).m8261(this.f11185);
        t0.m8253(this.f11185).m8269();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m10759() {
        if (this.f11186) {
            t0.m8253(this.f11185).m8274();
        }
    }
}
