package defpackage;

import android.location.Location;
import defpackage.C3881;

/* compiled from: LocationAddressManager.java */
/* renamed from: ࠎ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3902 implements C3881.InterfaceC3887 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f13519;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f13520;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f13521;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public long f13522;

    /* renamed from: ԫ, reason: contains not printable characters */
    public Location f13523;

    /* compiled from: LocationAddressManager.java */
    /* renamed from: ࠎ$Ԩ, reason: contains not printable characters */
    public static final class C3904 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final C3902 f13524 = new C3902();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static C3902 m12637() {
        return C3904.f13524;
    }

    @Override // defpackage.C3881.InterfaceC3887
    /* renamed from: Ϳ */
    public void mo12340(Location location, String str, String str2, String str3) {
        if (this.f13523 == location) {
            this.f13519 = str;
            this.f13520 = str2;
            this.f13521 = str3;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String m12638() {
        return this.f13521;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public String m12639() {
        return this.f13519;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String m12640() {
        return this.f13520;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean m12641() {
        return r1.m8138(this.f13521) && r1.m8138(this.f13519) && r1.m8138(this.f13520);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m12642(Location location) {
        m12643(location);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m12643(Location location) {
        if (location == null) {
            return;
        }
        Location location2 = this.f13523;
        if (location2 != null && location2.getLatitude() == location.getLatitude() && this.f13523.getLongitude() == location.getLongitude()) {
            return;
        }
        if (m12641() || System.currentTimeMillis() - this.f13522 >= 3600000) {
            this.f13523 = location;
            this.f13522 = System.currentTimeMillis();
            new C3881(this.f13523, this).m12337();
        }
    }

    public C3902() {
        this.f13523 = null;
    }
}
