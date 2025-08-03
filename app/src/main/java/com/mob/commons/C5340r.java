package com.mob.commons;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.UIHandler;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;

/* renamed from: com.mob.commons.r, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5340r {

    /* renamed from: com.mob.commons.r$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[InternationalDomain.values().length];
            a = iArr;
            try {
                iArr[InternationalDomain.JP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[InternationalDomain.US.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Context a() {
        try {
            return b();
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static Context b() {
        try {
            Object objC = c();
            if (objC != null) {
                return (Context) ReflectHelper.invokeInstanceMethod(objC, o.a("014Mff?id4ej2ee_eddedgdf+d,deecdk"), new Object[0]);
            }
            return null;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static Object c() {
        final ReflectHelper.a<Void, Object> aVar = new ReflectHelper.a<Void, Object>() { // from class: com.mob.commons.r.1
            @Override // com.mob.tools.utils.ReflectHelper.a
            public Object a(Void r3) {
                try {
                    return ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(o.a("026Qdfdk0hGdhecdeDhOeldf4eeRelejdg-d?de0j>deEdLdieiPc3dhViWdfHh")), o.a("021@dgdcdhdhXiAdkMd!ejdgEdPdeWj>deMd9dieiIc_dhNi2df)h"), new Object[0]);
                } catch (Throwable th) {
                    MobLog.getInstance().w(th);
                    return null;
                }
            }
        };
        int i = (Thread.currentThread().getId() > Looper.getMainLooper().getThread().getId() ? 1 : (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 0 : -1));
        Object objA = aVar.a(null);
        if (objA != null) {
            return objA;
        }
        final Object obj = new Object();
        final Object[] objArr = new Object[1];
        synchronized (obj) {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.commons.r.2
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    NLog mobLog;
                    synchronized (obj) {
                        try {
                            objArr[0] = aVar.a(null);
                            try {
                                obj.notify();
                            } catch (Throwable th) {
                                th = th;
                                mobLog = MobLog.getInstance();
                                mobLog.w(th);
                                return false;
                            }
                        } catch (Throwable th2) {
                            try {
                                MobLog.getInstance().w(th2);
                                try {
                                    obj.notify();
                                } catch (Throwable th3) {
                                    th = th3;
                                    mobLog = MobLog.getInstance();
                                    mobLog.w(th);
                                    return false;
                                }
                            } finally {
                            }
                        }
                    }
                    return false;
                }
            });
            try {
                obj.wait();
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
            }
        }
        return objArr[0];
    }

    public static void a(Closeable... closeableArr) {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
            }
        }
    }

    public static String b(String str) {
        Uri uri;
        String scheme;
        String str2;
        try {
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        boolean zCheckForceHttps = MobSDK.checkForceHttps();
        if (zCheckForceHttps || !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
            str = str.trim();
            if (str.startsWith(o.a("007cddefgg")) && (uri = Uri.parse(str.trim())) != null && (scheme = uri.getScheme()) != null && scheme.equals(o.a("004cdde"))) {
                String host = uri.getHost();
                String path = uri.getPath();
                String query = uri.getQuery();
                String str3 = "";
                if (host != null) {
                    int port = uri.getPort();
                    StringBuilder sb = new StringBuilder();
                    sb.append(host);
                    if (port <= 0 || port == 80) {
                        str2 = "";
                    } else {
                        str2 = Constants.COLON_SEPARATOR + port;
                    }
                    sb.append(str2);
                    host = sb.toString();
                    if (!zCheckForceHttps && Build.VERSION.SDK_INT >= 24 && ((Boolean) ReflectHelper.invokeInstanceMethod(NetworkSecurityPolicy.getInstance(), o.a("027;defgggedIiHdfdh9diZdl-d2eidhdffhfhdedgghTiWdhOlXdeXddih"), host)).booleanValue()) {
                        return str;
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("https://");
                sb2.append(host);
                if (path == null) {
                    path = "";
                }
                sb2.append(path);
                if (query != null) {
                    str3 = "?" + query;
                }
                sb2.append(str3);
                return sb2.toString();
            }
        }
        return str;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strA = "";
        if (str.startsWith(o.a("007cddefgg"))) {
            str = str.replace(o.a("007cddefgg"), "");
        }
        if (str.startsWith("https://")) {
            str = str.replace("https://", "");
        }
        if (MobSDK.checkV6()) {
            strA = o.a("002jBie");
        } else {
            int i = AnonymousClass3.a[MobSDK.getDomain().ordinal()];
            if (i == 1) {
                strA = "jp";
            } else if (i == 2) {
                strA = o.a("0029dcfg");
            }
        }
        if (TextUtils.isEmpty(strA)) {
            return b(o.a("007cddefgg") + str);
        }
        if (str.startsWith(strA + ".")) {
            return b(o.a("007cddefgg") + str);
        }
        return b(o.a("007cddefgg") + strA + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str);
    }

    public static String a(String str, int i) throws NumberFormatException {
        int i2;
        int i3 = 0;
        int i4 = 3;
        if (str.startsWith("00")) {
            i2 = Integer.parseInt(str.substring(2, 3));
        } else if (str.startsWith("0")) {
            i2 = Integer.parseInt(str.substring(1, 3));
        } else {
            i2 = Integer.parseInt(str.substring(0, 3));
        }
        char[] charArray = str.toCharArray();
        int[] iArr = new int[i2];
        boolean z = true;
        while (i4 < charArray.length) {
            char c = charArray[i4];
            if (c < 'a') {
                z = !z;
            } else {
                if (z) {
                    iArr[i3] = c - i;
                } else {
                    int i5 = (c - i) * 10;
                    iArr[i3] = i5;
                    i4++;
                    iArr[i3] = i5 + (charArray[i4] - i);
                }
                int i6 = iArr[i3];
                i3++;
            }
            i4++;
        }
        return d.a(iArr);
    }
}
