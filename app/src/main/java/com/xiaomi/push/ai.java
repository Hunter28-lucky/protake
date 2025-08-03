package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;

/* loaded from: classes2.dex */
class ai implements aj {
    private static boolean a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5571a;

    /* renamed from: a, reason: collision with other field name */
    private ServiceConnection f5572a;

    /* renamed from: a, reason: collision with other field name */
    private volatile int f5570a = 0;

    /* renamed from: a, reason: collision with other field name */
    private volatile String f5574a = null;

    /* renamed from: b, reason: collision with other field name */
    private volatile boolean f5575b = false;
    private volatile String b = null;

    /* renamed from: a, reason: collision with other field name */
    private final Object f5573a = new Object();

    public class a implements ServiceConnection {
        private a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            new Thread(new Runnable() { // from class: com.xiaomi.push.ai.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ai.this.f5574a = b.a(iBinder);
                        ai.this.f5575b = b.m5203a(iBinder);
                        ai.this.b();
                        ai.this.f5570a = 2;
                        synchronized (ai.this.f5573a) {
                            try {
                                ai.this.f5573a.notifyAll();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        ai.this.b();
                        ai.this.f5570a = 2;
                        synchronized (ai.this.f5573a) {
                            try {
                                ai.this.f5573a.notifyAll();
                            } catch (Exception unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        ai.this.b();
                        ai.this.f5570a = 2;
                        synchronized (ai.this.f5573a) {
                            try {
                                ai.this.f5573a.notifyAll();
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

    public ai(Context context) {
        this.f5571a = context;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ServiceConnection serviceConnection = this.f5572a;
        if (serviceConnection != null) {
            try {
                this.f5571a.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.aj
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo5202a() {
        return a;
    }

    @Override // com.xiaomi.push.aj
    /* renamed from: a, reason: collision with other method in class */
    public String mo5201a() {
        a("getOAID");
        return this.f5574a;
    }

    private void a() {
        boolean zBindService;
        this.f5572a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            zBindService = this.f5571a.bindService(intent, this.f5572a, 1);
        } catch (Exception unused) {
            zBindService = false;
        }
        this.f5570a = zBindService ? 1 : 2;
    }

    public static class b {
        public static String a(IBinder iBinder) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        /* renamed from: a, reason: collision with other method in class */
        public static boolean m5203a(IBinder iBinder) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    private void a(String str) {
        if (this.f5570a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f5573a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m5113a("huawei's " + str + " wait...");
                this.f5573a.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) throws PackageManager.NameNotFoundException {
        boolean z;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            z = (packageInfo.applicationInfo.flags & 1) != 0;
            a = packageInfo.versionCode >= 20602000;
        } catch (Exception unused) {
        }
        return z;
    }
}
