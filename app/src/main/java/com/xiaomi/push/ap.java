package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import androidx.exifinterface.media.ExifInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
class ap implements aj {
    private static boolean a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5594a;

    /* renamed from: a, reason: collision with other field name */
    private ServiceConnection f5595a;

    /* renamed from: a, reason: collision with other field name */
    private volatile int f5593a = 0;

    /* renamed from: a, reason: collision with other field name */
    private volatile a f5596a = null;

    /* renamed from: a, reason: collision with other field name */
    private final Object f5597a = new Object();

    public class a {

        /* renamed from: a, reason: collision with other field name */
        public String f5598a;
        public String b;
        public String c;
        public String d;

        private a() {
            this.f5598a = null;
            this.b = null;
            this.c = null;
            this.d = null;
        }
    }

    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            if (ap.this.f5596a != null) {
                return;
            }
            new Thread(new Runnable() { // from class: com.xiaomi.push.ap.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String packageName = ap.this.f5594a.getPackageName();
                        String strB = ap.this.b();
                        a aVar = new a();
                        aVar.b = c.a(iBinder, packageName, strB, "OUID");
                        ap.this.f5596a = aVar;
                        ap.this.m5208b();
                        ap.this.f5593a = 2;
                        synchronized (ap.this.f5597a) {
                            try {
                                ap.this.f5597a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        ap.this.m5208b();
                        ap.this.f5593a = 2;
                        synchronized (ap.this.f5597a) {
                            try {
                                ap.this.f5597a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        ap.this.m5208b();
                        ap.this.f5593a = 2;
                        synchronized (ap.this.f5597a) {
                            try {
                                ap.this.f5597a.notifyAll();
                            } catch (Exception unused4) {
                            }
                            throw th;
                        }
                    }
                }
            }).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static class c {
        public static String a(IBinder iBinder, String str, String str2, String str3) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                parcelObtain.writeString(str);
                parcelObtain.writeString(str2);
                parcelObtain.writeString(str3);
                iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    public ap(Context context) {
        this.f5594a = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: collision with other method in class */
    public void m5208b() {
        ServiceConnection serviceConnection = this.f5595a;
        if (serviceConnection != null) {
            try {
                this.f5594a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() throws NoSuchAlgorithmException {
        try {
            Signature[] signatureArr = this.f5594a.getPackageManager().getPackageInfo(this.f5594a.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            StringBuilder sb = new StringBuilder();
            for (byte b2 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb.append(Integer.toHexString((b2 & ExifInterface.MARKER) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.xiaomi.push.aj
    /* renamed from: a */
    public boolean mo5202a() {
        return a;
    }

    @Override // com.xiaomi.push.aj
    /* renamed from: a */
    public String mo5201a() {
        a("getOAID");
        if (this.f5596a == null) {
            return null;
        }
        return this.f5596a.b;
    }

    private void a() {
        boolean zBindService;
        this.f5595a = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        try {
            zBindService = this.f5594a.bindService(intent, this.f5595a, 1);
        } catch (Exception unused) {
            zBindService = false;
        }
        this.f5593a = zBindService ? 1 : 2;
    }

    private void a(String str) {
        if (this.f5593a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f5597a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m5113a("oppo's " + str + " wait...");
                this.f5597a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) throws PackageManager.NameNotFoundException {
        long longVersionCode;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    longVersionCode = packageInfo.getLongVersionCode();
                } else {
                    longVersionCode = packageInfo.versionCode;
                }
                boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                a = longVersionCode >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
