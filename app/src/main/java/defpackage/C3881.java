package defpackage;

import android.location.Geocoder;
import android.location.Location;
import com.blink.academy.film.FilmApp;
import java.util.Locale;

/* compiled from: GetAddressTask.java */
/* renamed from: ࠃ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3881 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f13353;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f13354;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f13355;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Location f13356;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Object f13357 = new Object();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f13358 = 0;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC3887 f13359;

    /* compiled from: GetAddressTask.java */
    /* renamed from: ࠃ$Ϳ, reason: contains not printable characters */
    public class C3882 implements InterfaceC4515 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ C4122 f13360;

        public C3882(C4122 c4122) {
            this.f13360 = c4122;
        }

        @Override // defpackage.InterfaceC4515
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo12338() {
            C3881 c3881 = C3881.this;
            c3881.m12335(c3881.f13356, this.f13360);
        }

        @Override // defpackage.InterfaceC4515
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo12339(String str) {
            C3881.this.f13353 = str;
            C3881 c3881 = C3881.this;
            c3881.m12335(c3881.f13356, this.f13360);
        }
    }

    /* compiled from: GetAddressTask.java */
    /* renamed from: ࠃ$Ԩ, reason: contains not printable characters */
    public class C3883 implements InterfaceC4515 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ C4122 f13362;

        public C3883(C4122 c4122) {
            this.f13362 = c4122;
        }

        @Override // defpackage.InterfaceC4515
        /* renamed from: Ϳ */
        public void mo12338() {
            C3881 c3881 = C3881.this;
            c3881.m12335(c3881.f13356, this.f13362);
        }

        @Override // defpackage.InterfaceC4515
        /* renamed from: Ԩ */
        public void mo12339(String str) {
            C3881.this.f13354 = str;
            C3881 c3881 = C3881.this;
            c3881.m12335(c3881.f13356, this.f13362);
        }
    }

    /* compiled from: GetAddressTask.java */
    /* renamed from: ࠃ$Ԫ, reason: contains not printable characters */
    public class C3884 implements InterfaceC4515 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ C4122 f13364;

        public C3884(C4122 c4122) {
            this.f13364 = c4122;
        }

        @Override // defpackage.InterfaceC4515
        /* renamed from: Ϳ */
        public void mo12338() {
            C3881 c3881 = C3881.this;
            c3881.m12335(c3881.f13356, this.f13364);
        }

        @Override // defpackage.InterfaceC4515
        /* renamed from: Ԩ */
        public void mo12339(String str) {
            C3881.this.f13355 = str;
            C3881 c3881 = C3881.this;
            c3881.m12335(c3881.f13356, this.f13364);
        }
    }

    /* compiled from: GetAddressTask.java */
    /* renamed from: ࠃ$Ԭ, reason: contains not printable characters */
    public class C3885 implements InterfaceC4515 {
        public C3885() {
        }

        @Override // defpackage.InterfaceC4515
        /* renamed from: Ϳ */
        public void mo12338() {
        }

        @Override // defpackage.InterfaceC4515
        /* renamed from: Ԩ */
        public void mo12339(String str) {
            C3881.this.f13353 = str;
            C3881.this.f13354 = str;
            C3881.this.f13355 = str;
        }
    }

    /* compiled from: GetAddressTask.java */
    /* renamed from: ࠃ$Ԯ, reason: contains not printable characters */
    public class C3886 implements InterfaceC4515 {
        public C3886() {
        }

        @Override // defpackage.InterfaceC4515
        /* renamed from: Ϳ */
        public void mo12338() {
            C3881.this.m12336();
        }

        @Override // defpackage.InterfaceC4515
        /* renamed from: Ԩ */
        public void mo12339(String str) {
            C3881.this.f13353 = str;
            C3881.this.f13354 = str;
            C3881.this.f13355 = str;
            C3881.this.m12336();
        }
    }

    /* compiled from: GetAddressTask.java */
    /* renamed from: ࠃ$ՠ, reason: contains not printable characters */
    public interface InterfaceC3887 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo12340(Location location, String str, String str2, String str3);
    }

    public C3881(Location location, InterfaceC3887 interfaceC3887) {
        this.f13356 = location;
        this.f13359 = interfaceC3887;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m12334(Location location, C4122 c4122) {
        if (this.f13358 == 3) {
            if (r1.m8138(this.f13353) && r1.m8138(this.f13354) && r1.m8138(this.f13355)) {
                c4122.m13095(FilmApp.m402(), Locale.getDefault(), location, new C3886());
            } else {
                m12336();
            }
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m12335(Location location, C4122 c4122) {
        synchronized (this.f13357) {
            this.f13358++;
        }
        m12334(location, c4122);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m12336() {
        if (r1.m8138(this.f13355)) {
            String str = this.f13354;
            this.f13355 = str;
            if (r1.m8138(str)) {
                this.f13355 = this.f13353;
            }
        }
        if (r1.m8138(this.f13354)) {
            String str2 = this.f13353;
            this.f13354 = str2;
            if (r1.m8138(str2)) {
                this.f13354 = this.f13355;
            }
        }
        if (r1.m8138(this.f13353)) {
            String str3 = this.f13354;
            this.f13353 = str3;
            if (r1.m8138(str3)) {
                this.f13353 = this.f13355;
            }
        }
        InterfaceC3887 interfaceC3887 = this.f13359;
        if (interfaceC3887 != null) {
            interfaceC3887.mo12340(this.f13356, this.f13353, this.f13354, this.f13355);
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m12337() {
        if (this.f13356 == null) {
            return;
        }
        C4122 c4122 = new C4122();
        if (!Geocoder.isPresent()) {
            c4122.m13095(FilmApp.m402(), Locale.getDefault(), this.f13356, new C3885());
            return;
        }
        synchronized (this.f13357) {
            this.f13358 = 0;
        }
        c4122.m13094(FilmApp.m402(), Locale.SIMPLIFIED_CHINESE, this.f13356, new C3882(c4122));
        c4122.m13094(FilmApp.m402(), Locale.TRADITIONAL_CHINESE, this.f13356, new C3883(c4122));
        c4122.m13094(FilmApp.m402(), Locale.ENGLISH, this.f13356, new C3884(c4122));
    }
}
