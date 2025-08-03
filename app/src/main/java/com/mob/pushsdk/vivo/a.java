package com.mob.pushsdk.vivo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.mob.MobSDK;
import com.mob.pushsdk.vivo.a.b;
import com.mob.pushsdk.vivo.c.d;
import com.mob.tools.utils.DH;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public class a {
    private static a a;
    private volatile b b;
    private int c = 0;
    private String d;

    /* renamed from: e, reason: collision with root package name */
    private String f17705e;

    public void b() {
        Bundle bundle = new Bundle();
        bundle.putString("method", "method_sdk_bind");
        bundle.putInt("command", 2006);
        b(bundle);
        a(bundle);
    }

    public void c() {
        Bundle bundle = new Bundle();
        bundle.putString("method", "method_sdk_unbind");
        bundle.putInt("command", 2007);
        bundle.putInt("PUSH_UNBIND_SOURCE_CODE", 1);
        b(bundle);
        a(bundle);
    }

    public boolean d() {
        final boolean[] zArr = {false};
        try {
            String strA = com.mob.pushsdk.vivo.c.b.a();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            DH.requester(MobSDK.getContext()).getAInfoForPkg(strA, 128).getPInfoForce(true, DH.SyncMtd.getPackageName(), 0).request(new DH.DHResponder() { // from class: com.mob.pushsdk.vivo.a.2
                /* JADX WARN: Removed duplicated region for block: B:38:0x00e4  */
                /* JADX WARN: Removed duplicated region for block: B:73:0x0136 A[ADDED_TO_REGION] */
                @Override // com.mob.tools.utils.DH.DHResponder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onResponse(com.mob.tools.utils.DH.DHResponse r20) throws android.os.RemoteException {
                    /*
                        Method dump skipped, instructions count: 368
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mob.pushsdk.vivo.a.AnonymousClass2.onResponse(com.mob.tools.utils.DH$DHResponse):void");
                }
            });
            try {
                countDownLatch.await();
            } catch (Throwable th) {
                d.a().b(th);
            }
        } catch (Throwable th2) {
            d.a().b(th2);
        }
        return zArr[0];
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    private void a(final Bundle bundle) {
        try {
            this.c++;
            if (com.mob.pushsdk.vivo.c.a.b(this.b)) {
                try {
                    this.b.a(bundle, null);
                } catch (Throwable th) {
                    d.a().a(th);
                }
            } else {
                Intent intent = new Intent("com.vivo.vms.aidlservice");
                intent.setPackage(com.mob.pushsdk.vivo.c.b.a());
                MobSDK.getContext().bindService(intent, new ServiceConnection() { // from class: com.mob.pushsdk.vivo.a.1
                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        try {
                            a.this.b = b.a.a(iBinder);
                            a.this.b.a(bundle, null);
                        } catch (Throwable th2) {
                            d.a().a(th2);
                        }
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                        d.a().a("onServiceDisconnected:" + componentName);
                    }
                }, 1);
            }
        } catch (Throwable th2) {
            d.a().b(th2);
        }
    }

    private void b(Bundle bundle) {
        bundle.putString("client_pkgname", DH.SyncMtd.getPackageName());
        bundle.putString("req_id", String.valueOf(this.c));
        bundle.putString("package_name", DH.SyncMtd.getPackageName());
        bundle.putLong("sdk_version", 354L);
        bundle.putInt("PUSH_APP_STATUS", -1);
        bundle.putString("BaseAppCommand.EXTRA_APPID", this.d);
        bundle.putString("BaseAppCommand.EXTRA_APPKEY", this.f17705e);
        bundle.putString("PUSH_REGID", null);
        bundle.putString("sdk_clients", null);
    }

    public void a(String str, String str2) {
        this.d = str;
        this.f17705e = str2;
    }
}
