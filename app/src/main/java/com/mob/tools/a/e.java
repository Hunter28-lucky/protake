package com.mob.tools.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.mob.commons.n;
import com.mob.tools.MobLog;
import com.mob.tools.utils.ReflectHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jcodec.codecs.mjpeg.JpegConst;

/* loaded from: classes2.dex */
public class e implements j {
    private Context a;
    private Object b;
    private PackageManager c;
    private ConcurrentHashMap<String, Object> d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, Integer> f17714e = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> f = new ConcurrentHashMap<>();
    private String g;

    public static abstract class a<T> {
        private T a;
        private long b;
        public int d;

        public a(T t) {
            this(t, 0L);
        }

        public abstract T b() throws Throwable;

        public a(T t, long j) {
            this(t, 1, j);
        }

        public a(T t, int i, long j) {
            this.a = t;
            this.d = i;
            this.b = j;
        }
    }

    public e(Context context) {
        this.a = context;
        String packageName = context.getPackageName();
        this.g = packageName;
        try {
            a(packageName, JpegConst.SOF1);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    @Override // com.mob.tools.a.j
    public ResolveInfo b(Intent intent, int i) {
        try {
            return (ResolveInfo) ReflectHelper.invokeInstanceMethod(this.a.getPackageManager(), n.b("015Wcg-h_efdbdc9ih,dicf'c0cdZiCcd=c ch"), new Object[]{intent, Integer.valueOf(i)}, new Class[]{Intent.class, Integer.TYPE});
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    @Override // com.mob.tools.a.j
    public int c() {
        try {
            if (Build.VERSION.SDK_INT < 24 || !c.a(this.a).b().h(n.b("035JcecjOgTcgdbcdSgDdk9dh;cgMkNcdefefcddbcjdkfdfcdiehccfggcekdefcccdgdhdidhfc"))) {
                return -1;
            }
            if (this.b == null) {
                this.b = b("phone");
            }
            return ((Integer) ReflectHelper.invokeInstanceMethod(this.b, n.b("0184eeGhc^ehceFcScede!hc_ecdbcgcidhch0dh"), new Object[0])).intValue();
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return -1;
        }
    }

    @Override // com.mob.tools.a.j
    public ApplicationInfo d() {
        return this.a.getApplicationInfo();
    }

    @Override // com.mob.tools.a.j
    public String a(String str) {
        try {
            Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(n.b("027McecjYg_cgdbcd%g^dkdbefdkdgchef7chk!fgcgdb[dh:cg+cRcd_hTef")), n.b("003JeeBhc"), str);
            return objInvokeStaticMethod != null ? String.valueOf(objInvokeStaticMethod) : "";
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return "";
        }
    }

    @Override // com.mob.tools.a.j
    public int b() {
        try {
            if (this.b == null) {
                this.b = b("phone");
            }
            return ((Integer) ReflectHelper.invokeInstanceMethod(this.b, n.b("014ZeeIhcSde5hcIecdbcgcidhch:dh"), new Object[0])).intValue();
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return -1;
        }
    }

    @Override // com.mob.tools.a.j
    public String a(String str, String str2) {
        try {
            Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(n.b("027Xcecj$g>cgdbcd9gLdkdbefdkdgchefKchkXfgcgdbIdh'cgKc8cd.h@ef")), n.b("0039ee6hc"), str, str2);
            if (objInvokeStaticMethod != null) {
                return String.valueOf(objInvokeStaticMethod);
            }
            return null;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    @Override // com.mob.tools.a.j
    public ApplicationInfo b(String str, int i) throws PackageManager.NameNotFoundException {
        if (this.c == null) {
            this.c = this.a.getPackageManager();
        }
        return this.c.getApplicationInfo(str, i);
    }

    @Override // com.mob.tools.a.j
    public Enumeration<NetworkInterface> a() {
        try {
            return NetworkInterface.getNetworkInterfaces();
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    @Override // com.mob.tools.a.j
    public List<ResolveInfo> a(Intent intent, int i) {
        try {
            return (List) ReflectHelper.invokeInstanceMethod(this.a.getPackageManager(), n.b("019jIcbDh!cgchdfcj]chPcj.c%dgXh]cg2i9cdcf5hOef"), new Object[]{intent, Integer.valueOf(i)}, new Class[]{Intent.class, Integer.TYPE});
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public Object b(String str) {
        try {
            return this.a.getSystemService(str);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    @Override // com.mob.tools.a.j
    public PackageInfo a(final String str, final int i) throws PackageManager.NameNotFoundException {
        if (this.c == null) {
            this.c = this.a.getPackageManager();
        }
        if (str.equals(this.g)) {
            final int i2 = (i == 0 || i == 1 || i == 128 || i == 64) ? 193 : i;
            PackageInfo packageInfo = null;
            PackageInfo packageInfo2 = (PackageInfo) a("gpisys-" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2, new a<PackageInfo>(packageInfo) { // from class: com.mob.tools.a.e.1
                @Override // com.mob.tools.a.e.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public PackageInfo b() throws Throwable {
                    return e.this.c.getPackageInfo(str, i2);
                }
            });
            if (packageInfo2 != null || i2 != 193) {
                return packageInfo2;
            }
            return (PackageInfo) a("gpisys-" + str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i, new a<PackageInfo>(packageInfo) { // from class: com.mob.tools.a.e.2
                @Override // com.mob.tools.a.e.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public PackageInfo b() throws Throwable {
                    return e.this.c.getPackageInfo(str, i);
                }
            });
        }
        return this.c.getPackageInfo(str, i);
    }

    @Override // com.mob.tools.a.j
    public Enumeration<InetAddress> a(NetworkInterface networkInterface) {
        try {
            return (Enumeration) ReflectHelper.invokeInstanceMethod(networkInterface, "getInetAddresses", new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    private <T> T a(String str, a<T> aVar) {
        return (T) a(str, aVar, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> T a(java.lang.String r10, com.mob.tools.a.e.a<T> r11, boolean r12) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L9
            java.lang.Object r10 = r11.b()     // Catch: java.lang.Throwable -> L8b
            goto L94
        L9:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r1 = r9.f17714e     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r1 = r1.get(r10)     // Catch: java.lang.Throwable -> L8b
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L8b
            if (r1 == 0) goto L2a
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r2 = r9.d     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r0 = r2.get(r10)     // Catch: java.lang.Throwable -> L8b
            if (r0 != 0) goto L2a
            int r2 = r1.intValue()     // Catch: java.lang.Throwable -> L8b
            int r3 = r11.d     // Catch: java.lang.Throwable -> L8b
            if (r2 < r3) goto L2a
            if (r12 != 0) goto L2a
            java.lang.Object r10 = com.mob.tools.a.e.a.a(r11)     // Catch: java.lang.Throwable -> L8b
            return r10
        L2a:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r2 = r9.f     // Catch: java.lang.Throwable -> L8b
            java.lang.Object r2 = r2.get(r10)     // Catch: java.lang.Throwable -> L8b
            java.lang.Long r2 = (java.lang.Long) r2     // Catch: java.lang.Throwable -> L8b
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L43
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8b
            long r7 = r2.longValue()     // Catch: java.lang.Throwable -> L8b
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L43
            r3 = r4
        L43:
            if (r0 == 0) goto L49
            if (r3 != 0) goto L49
            if (r12 == 0) goto L93
        L49:
            java.lang.Object r0 = r11.b()     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L70
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r12 = r9.d     // Catch: java.lang.Throwable -> L8b
            r12.put(r10, r0)     // Catch: java.lang.Throwable -> L8b
            long r2 = com.mob.tools.a.e.a.b(r11)     // Catch: java.lang.Throwable -> L8b
            r5 = 0
            int r12 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r12 <= 0) goto L70
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> r12 = r9.f     // Catch: java.lang.Throwable -> L8b
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L8b
            long r5 = com.mob.tools.a.e.a.b(r11)     // Catch: java.lang.Throwable -> L8b
            long r2 = r2 + r5
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L8b
            r12.put(r10, r2)     // Catch: java.lang.Throwable -> L8b
        L70:
            if (r1 != 0) goto L7c
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r12 = r9.f17714e     // Catch: java.lang.Throwable -> L8b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L8b
            r12.put(r10, r1)     // Catch: java.lang.Throwable -> L8b
            goto L93
        L7c:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r12 = r9.f17714e     // Catch: java.lang.Throwable -> L8b
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L8b
            int r1 = r1 + r4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L8b
            r12.put(r10, r1)     // Catch: java.lang.Throwable -> L8b
            goto L93
        L8b:
            r10 = move-exception
            com.mob.tools.log.NLog r12 = com.mob.tools.MobLog.getInstance()
            r12.d(r10)
        L93:
            r10 = r0
        L94:
            if (r10 != 0) goto L9a
            java.lang.Object r10 = com.mob.tools.a.e.a.a(r11)
        L9a:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.a.e.a(java.lang.String, com.mob.tools.a.e$a, boolean):java.lang.Object");
    }
}
