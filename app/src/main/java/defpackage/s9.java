package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import defpackage.na;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class s9 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public na f8510 = null;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f8511 = null;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f8512 = null;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Object f8513 = new Object();

    /* renamed from: ԫ, reason: contains not printable characters */
    public ServiceConnection f8514 = new ServiceConnectionC2261();

    /* renamed from: s9$Ϳ, reason: contains not printable characters */
    public class ServiceConnectionC2261 implements ServiceConnection {
        public ServiceConnectionC2261() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            s9.this.f8510 = na.AbstractBinderC2194.m7643(iBinder);
            synchronized (s9.this.f8513) {
                s9.this.f8513.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            s9.this.f8510 = null;
        }
    }

    /* renamed from: s9$Ԩ, reason: contains not printable characters */
    public static class C2262 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final s9 f8516 = new s9(null);
    }

    public /* synthetic */ s9(ServiceConnectionC2261 serviceConnectionC2261) {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: Ϳ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String m8215(android.content.Context r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.os.Looper r0 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> L6f
            android.os.Looper r1 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L6f
            if (r0 == r1) goto L67
            na r0 = r4.f8510     // Catch: java.lang.Throwable -> L6f
            if (r0 != 0) goto L59
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L6f
            r0.<init>()     // Catch: java.lang.Throwable -> L6f
            android.content.ComponentName r1 = new android.content.ComponentName     // Catch: java.lang.Throwable -> L6f
            java.lang.String r2 = "com.heytap.openid"
            java.lang.String r3 = "com.heytap.openid.IdentifyService"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L6f
            r0.setComponent(r1)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r1 = "action.com.heytap.openid.OPEN_ID_SERVICE"
            r0.setAction(r1)     // Catch: java.lang.Throwable -> L6f
            android.content.ServiceConnection r1 = r4.f8514     // Catch: java.lang.Throwable -> L6f
            r2 = 1
            boolean r0 = r5.bindService(r0, r1, r2)     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L43
            java.lang.Object r0 = r4.f8513     // Catch: java.lang.Throwable -> L6f
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r1 = r4.f8513     // Catch: java.lang.Throwable -> L39 java.lang.InterruptedException -> L3b
            r2 = 3000(0xbb8, double:1.482E-320)
            r1.wait(r2)     // Catch: java.lang.Throwable -> L39 java.lang.InterruptedException -> L3b
            goto L3f
        L39:
            r5 = move-exception
            goto L41
        L3b:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L39
        L3f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L39
            goto L43
        L41:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L39
            throw r5     // Catch: java.lang.Throwable -> L6f
        L43:
            na r0 = r4.f8510     // Catch: java.lang.Throwable -> L6f
            if (r0 != 0) goto L4b
            java.lang.String r5 = ""
            monitor-exit(r4)
            return r5
        L4b:
            java.lang.String r5 = r4.m8217(r5, r6)     // Catch: android.os.RemoteException -> L51 java.lang.Throwable -> L6f
            monitor-exit(r4)
            return r5
        L51:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r5 = ""
            monitor-exit(r4)
            return r5
        L59:
            java.lang.String r5 = r4.m8217(r5, r6)     // Catch: android.os.RemoteException -> L5f java.lang.Throwable -> L6f
            monitor-exit(r4)
            return r5
        L5f:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r5 = ""
            monitor-exit(r4)
            return r5
        L67:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L6f
            java.lang.String r6 = "Cannot run on MainThread"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L6f
            throw r5     // Catch: java.lang.Throwable -> L6f
        L6f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s9.m8215(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean m8216(Context context) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            return Build.VERSION.SDK_INT >= 28 ? packageInfo != null && packageInfo.getLongVersionCode() >= 1 : packageInfo != null && packageInfo.versionCode >= 1;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String m8217(Context context, String str) throws NoSuchAlgorithmException {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.f8511)) {
            this.f8511 = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f8512)) {
            String string = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.f8511, 64).signatures;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & ExifInterface.MARKER) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    }
                } catch (NoSuchAlgorithmException e3) {
                    e3.printStackTrace();
                }
            }
            this.f8512 = string;
        }
        String strM7644 = ((na.AbstractBinderC2194.C2195) this.f8510).m7644(this.f8511, this.f8512, str);
        return TextUtils.isEmpty(strM7644) ? "" : strM7644;
    }
}
