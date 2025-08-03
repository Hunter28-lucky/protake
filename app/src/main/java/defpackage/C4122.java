package defpackage;

import android.content.Context;
import android.location.Location;
import java.util.Locale;

/* compiled from: ReverseGecodeProvider.java */
/* renamed from: ॷ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4122 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String f14279 = "ॷ";

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean f14280 = false;

    /* compiled from: ReverseGecodeProvider.java */
    /* renamed from: ॷ$Ϳ, reason: contains not printable characters */
    public class RunnableC4123 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Location f14281;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ Context f14282;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ Locale f14283;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4515 f14284;

        public RunnableC4123(Location location, Context context, Locale locale, InterfaceC4515 interfaceC4515) {
            this.f14281 = location;
            this.f14282 = context;
            this.f14283 = locale;
            this.f14284 = interfaceC4515;
        }

        @Override // java.lang.Runnable
        public void run() {
            Location location = new Location("gps");
            location.setLatitude(this.f14281.getLatitude());
            location.setLongitude(this.f14281.getLongitude());
            C4122.this.m13092(this.f14282, this.f14283, this.f14281, this.f14284);
        }
    }

    /* compiled from: ReverseGecodeProvider.java */
    /* renamed from: ॷ$Ԩ, reason: contains not printable characters */
    public class C4124 implements InterfaceC4515 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4515 f14286;

        public C4124(InterfaceC4515 interfaceC4515) {
            this.f14286 = interfaceC4515;
        }

        @Override // defpackage.InterfaceC4515
        /* renamed from: Ϳ */
        public void mo12338() {
            if (C4122.f14280) {
                C4638.m14099(C4122.f14279, String.format("outGeoCodingWithPoint : %s ", "failed"));
            }
            InterfaceC4515 interfaceC4515 = this.f14286;
            if (interfaceC4515 != null) {
                interfaceC4515.mo12338();
            }
        }

        @Override // defpackage.InterfaceC4515
        /* renamed from: Ԩ */
        public void mo12339(String str) {
            if (C4122.f14280) {
                C4638.m14099(C4122.f14279, String.format("onReverseGecodeSuccess : %s ", str));
            }
            if (r1.m8143(str)) {
                InterfaceC4515 interfaceC4515 = this.f14286;
                if (interfaceC4515 != null) {
                    interfaceC4515.mo12339(str);
                    return;
                }
                return;
            }
            InterfaceC4515 interfaceC45152 = this.f14286;
            if (interfaceC45152 != null) {
                interfaceC45152.mo12338();
            }
        }
    }

    /* compiled from: ReverseGecodeProvider.java */
    /* renamed from: ॷ$Ԫ, reason: contains not printable characters */
    public class C4125 implements InterfaceC4515 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC4515 f14288;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ Context f14289;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final /* synthetic */ Locale f14290;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final /* synthetic */ Location f14291;

        public C4125(InterfaceC4515 interfaceC4515, Context context, Locale locale, Location location) {
            this.f14288 = interfaceC4515;
            this.f14289 = context;
            this.f14290 = locale;
            this.f14291 = location;
        }

        @Override // defpackage.InterfaceC4515
        /* renamed from: Ϳ */
        public void mo12338() {
            if (C4122.f14280) {
                C4638.m14099(C4122.f14279, String.format("outGeoCodingWithPoint : %s ", "failed"));
            }
            C4122.this.m13093(this.f14289, this.f14290, this.f14291, this.f14288);
        }

        @Override // defpackage.InterfaceC4515
        /* renamed from: Ԩ */
        public void mo12339(String str) {
            if (C4122.f14280) {
                C4638.m14099(C4122.f14279, String.format("onReverseGecodeSuccess : %s ", str));
            }
            if (!r1.m8143(str)) {
                C4122.this.m13093(this.f14289, this.f14290, this.f14291, this.f14288);
                return;
            }
            InterfaceC4515 interfaceC4515 = this.f14288;
            if (interfaceC4515 != null) {
                interfaceC4515.mo12339(str);
            }
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m13092(Context context, Locale locale, Location location, InterfaceC4515 interfaceC4515) {
        if (f14280) {
            C4638.m14099(f14279, String.format("outGeoCodingWithPoint lat : %s , long : %s ", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
        }
        new x0().m8584(context, locale, location, new C4125(interfaceC4515, context, locale, location));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m13093(Context context, Locale locale, Location location, InterfaceC4515 interfaceC4515) {
        if (f14280) {
            C4638.m14099(f14279, String.format("outNetGeoCodingWithPoint lat : %s , long : %s ", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
        }
        new C2826().m10173(context, locale, location, interfaceC4515);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m13094(Context context, Locale locale, Location location, InterfaceC4515 interfaceC4515) {
        if (f14280) {
            C4638.m14099(f14279, String.format("outSystemGeoCodingWithPoint lat : %s , long : %s ", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
        }
        new x0().m8584(context, locale, location, new C4124(interfaceC4515));
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m13095(Context context, Locale locale, Location location, InterfaceC4515 interfaceC4515) {
        new Thread(new RunnableC4123(location, context, locale, interfaceC4515)).start();
    }
}
