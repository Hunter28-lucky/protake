package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.C3151;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: SysLocationManager.java */
/* loaded from: classes.dex */
public class t0 {

    /* renamed from: ވ, reason: contains not printable characters */
    @SuppressLint({"StaticFieldLeak"})
    public static t0 f8532;

    /* renamed from: ԩ, reason: contains not printable characters */
    public LocationManager f8535;

    /* renamed from: ԫ, reason: contains not printable characters */
    public Location f8537;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Context f8539;

    /* renamed from: ށ, reason: contains not printable characters */
    public InterfaceC2283 f8548;

    /* renamed from: ނ, reason: contains not printable characters */
    public Executor f8549;

    /* renamed from: އ, reason: contains not printable characters */
    public C3151.InterfaceC3152 f8554;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean f8533 = false;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String f8534 = t0.class.getSimpleName();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Handler f8536 = new Handler(Looper.getMainLooper(), new C2275());

    /* renamed from: Ԭ, reason: contains not printable characters */
    public long f8538 = -1;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f8540 = 0;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final long f8541 = Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final float f8542 = 0.0f;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final long f8543 = 15000;

    /* renamed from: ֏, reason: contains not printable characters */
    public final LocationListener f8544 = new C2277();

    /* renamed from: ׯ, reason: contains not printable characters */
    public final LocationListener f8545 = new C2278();

    /* renamed from: ؠ, reason: contains not printable characters */
    public final LocationListener f8546 = new C2279();

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean f8547 = false;

    /* renamed from: ރ, reason: contains not printable characters */
    public final Object f8550 = new Object();

    /* renamed from: ބ, reason: contains not printable characters */
    public final long f8551 = 2000;

    /* renamed from: ޅ, reason: contains not printable characters */
    public final float f8552 = 5.0f;

    /* renamed from: ކ, reason: contains not printable characters */
    public final LocationListener f8553 = new C2281();

    /* compiled from: SysLocationManager.java */
    /* renamed from: t0$Ϳ, reason: contains not printable characters */
    public class C2275 implements Handler.Callback {
        public C2275() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 5) {
                t0.this.m8265();
                t0.this.m8275();
                return true;
            }
            if (i == 6) {
                t0.this.m8265();
                t0.this.m8277();
                return true;
            }
            if (i != 7) {
                return false;
            }
            t0.this.m8265();
            t0.this.m8278();
            return true;
        }
    }

    /* compiled from: SysLocationManager.java */
    /* renamed from: t0$Ԩ, reason: contains not printable characters */
    public class RunnableC2276 implements Runnable {
        public RunnableC2276() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t0.this.m8270();
        }
    }

    /* compiled from: SysLocationManager.java */
    /* renamed from: t0$Ԫ, reason: contains not printable characters */
    public class C2277 implements LocationListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final String f8557;

        public C2277() {
            this.f8557 = t0.this.f8534 + "GPS";
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            t0.this.m8266(location, System.currentTimeMillis());
            t0.this.f8536.removeMessages(5);
            t0.this.f8536.sendEmptyMessage(5);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* compiled from: SysLocationManager.java */
    /* renamed from: t0$Ԭ, reason: contains not printable characters */
    public class C2278 implements LocationListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final String f8559;

        public C2278() {
            this.f8559 = t0.this.f8534 + "NetWork";
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            t0.this.m8266(location, System.currentTimeMillis());
            t0.this.f8536.removeMessages(6);
            t0.this.f8536.sendEmptyMessage(6);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* compiled from: SysLocationManager.java */
    /* renamed from: t0$Ԯ, reason: contains not printable characters */
    public class C2279 implements LocationListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final String f8561;

        public C2279() {
            this.f8561 = t0.this.f8534 + "Passive";
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            t0.this.m8266(location, System.currentTimeMillis());
            t0.this.f8536.removeMessages(7);
            t0.this.f8536.sendEmptyMessage(7);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* compiled from: SysLocationManager.java */
    /* renamed from: t0$ՠ, reason: contains not printable characters */
    public class RunnableC2280 implements Runnable {
        public RunnableC2280() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t0.this.m8276();
        }
    }

    /* compiled from: SysLocationManager.java */
    /* renamed from: t0$ֈ, reason: contains not printable characters */
    public class C2281 implements LocationListener {
        public C2281() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            t0.this.m8279(t0.this.m8268(location.getSpeed()));
        }
    }

    /* compiled from: SysLocationManager.java */
    /* renamed from: t0$֏, reason: contains not printable characters */
    public class RunnableC2282 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ float f8565;

        public RunnableC2282(float f) {
            this.f8565 = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            t0.this.f8548.m8280(this.f8565);
        }
    }

    /* compiled from: SysLocationManager.java */
    /* renamed from: t0$ׯ, reason: contains not printable characters */
    public interface InterfaceC2283 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void m8280(float f);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static t0 m8253(Context context) {
        if (f8532 == null) {
            synchronized (t0.class) {
                if (f8532 == null) {
                    f8532 = new t0();
                }
            }
        }
        return f8532;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final synchronized void m8254() {
        this.f8540++;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final boolean m8255() {
        return m8256(this.f8539);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final boolean m8256(Context context) {
        return context != null && context.checkPermission("android.permission.ACCESS_FINE_LOCATION", Process.myPid(), Process.myUid()) == 0;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final synchronized void m8257() {
        this.f8540 = 0;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final Location m8258() {
        Location location = null;
        if (!m8255()) {
            return null;
        }
        Iterator<String> it = this.f8535.getProviders(true).iterator();
        while (it.hasNext()) {
            Location lastKnownLocation = this.f8535.getLastKnownLocation(it.next());
            if (lastKnownLocation != null && m8262(lastKnownLocation, location)) {
                location = lastKnownLocation;
            }
        }
        return location;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public Location m8259() {
        return this.f8537;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final synchronized int m8260() {
        return this.f8540;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m8261(Context context) {
        if (this.f8535 != null) {
            return;
        }
        this.f8539 = context;
        if (m8255()) {
            this.f8535 = (LocationManager) context.getSystemService("location");
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public boolean m8262(Location location, Location location2) {
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z = time > 120000;
        boolean z2 = time < -120000;
        boolean z3 = time > 0;
        if (z) {
            return true;
        }
        if (z2) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z4 = accuracy > 0;
        boolean z5 = accuracy < 0;
        boolean z6 = accuracy > 200;
        boolean zM8264 = m8264(location.getProvider(), location2.getProvider());
        if (z5) {
            return true;
        }
        if (!z3 || z4) {
            return z3 && !z6 && zM8264;
        }
        return true;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final boolean m8263() {
        return m8260() > 0;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final boolean m8264(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final synchronized void m8265() {
        this.f8540--;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m8266(Location location, long j) {
        this.f8537 = location;
        if (j != -1) {
            this.f8538 = j;
        }
        C3151.InterfaceC3152 interfaceC3152 = this.f8554;
        if (interfaceC3152 != null) {
            interfaceC3152.mo1327(location);
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m8267(C3151.InterfaceC3152 interfaceC3152) {
        this.f8554 = interfaceC3152;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final float m8268(float f) {
        return ((f * 60.0f) * 60.0f) / 1000.0f;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m8269() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.f8536.post(new RunnableC2276());
        } else {
            m8270();
        }
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final void m8270() {
        if (System.currentTimeMillis() - this.f8538 < Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL || m8263() || this.f8547) {
            return;
        }
        m8266(m8258(), -1L);
        m8257();
        m8273();
        m8272();
        m8271();
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final boolean m8271() {
        if (this.f8535 == null || !m8255() || this.f8535.getProvider("gps") == null) {
            return false;
        }
        this.f8535.requestLocationUpdates("gps", Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL, 0.0f, this.f8544);
        this.f8536.sendEmptyMessageDelayed(5, 15000L);
        m8254();
        return true;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final boolean m8272() {
        if (this.f8535 == null || !m8255() || this.f8535.getProvider("network") == null) {
            return false;
        }
        this.f8535.requestLocationUpdates("network", Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL, 0.0f, this.f8545);
        this.f8536.sendEmptyMessageDelayed(6, 15000L);
        m8254();
        return true;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final boolean m8273() {
        if (this.f8535 == null || !m8255() || this.f8535.getProvider("passive") == null) {
            return false;
        }
        this.f8535.requestLocationUpdates("passive", Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL, 0.0f, this.f8546);
        this.f8536.sendEmptyMessageDelayed(7, 15000L);
        m8254();
        return true;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public void m8274() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.f8536.post(new RunnableC2280());
        } else {
            m8276();
        }
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m8275() {
        LocationManager locationManager;
        if (m8255() && (locationManager = this.f8535) != null) {
            locationManager.removeUpdates(this.f8544);
            this.f8536.removeMessages(5);
        }
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final void m8276() {
        m8275();
        m8277();
        m8278();
        m8257();
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m8277() {
        LocationManager locationManager;
        if (m8255() && (locationManager = this.f8535) != null) {
            locationManager.removeUpdates(this.f8545);
            this.f8536.removeMessages(6);
        }
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final void m8278() {
        LocationManager locationManager;
        if (m8255() && (locationManager = this.f8535) != null) {
            locationManager.removeUpdates(this.f8546);
            this.f8536.removeMessages(7);
        }
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final void m8279(float f) {
        synchronized (this.f8550) {
            Executor executor = this.f8549;
            if (executor != null && this.f8548 != null) {
                executor.execute(new RunnableC2282(f));
            }
        }
    }
}
