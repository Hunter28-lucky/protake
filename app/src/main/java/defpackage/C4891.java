package defpackage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: InactivityTimer.java */
/* renamed from: ธ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4891 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final String f16524 = "ธ";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Activity f16525;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final BroadcastReceiver f16526 = new C4894();

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean f16527 = false;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public AsyncTask<Object, Object, Object> f16528;

    /* compiled from: InactivityTimer.java */
    /* renamed from: ธ$Ԩ, reason: contains not printable characters */
    public final class AsyncTaskC4893 extends AsyncTask<Object, Object, Object> {
        public AsyncTaskC4893() {
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Object... objArr) throws InterruptedException {
            try {
                Thread.sleep(Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL);
                Log.i(C4891.f16524, "Finishing activity due to inactivity");
                C4891.this.f16525.finish();
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    /* compiled from: InactivityTimer.java */
    /* renamed from: ธ$Ԫ, reason: contains not printable characters */
    public final class C4894 extends BroadcastReceiver {
        public C4894() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                if (intent.getIntExtra("plugged", -1) <= 0) {
                    C4891.this.m14619();
                } else {
                    C4891.this.m14618();
                }
            }
        }
    }

    public C4891(Activity activity) {
        this.f16525 = activity;
        m14619();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final synchronized void m14618() {
        AsyncTask<Object, Object, Object> asyncTask = this.f16528;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f16528 = null;
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public synchronized void m14619() {
        m14618();
        AsyncTaskC4893 asyncTaskC4893 = new AsyncTaskC4893();
        this.f16528 = asyncTaskC4893;
        try {
            asyncTaskC4893.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        } catch (RejectedExecutionException unused) {
            Log.w(f16524, "Couldn't schedule inactivity task; ignoring");
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public synchronized void m14620() {
        m14618();
        if (this.f16527) {
            this.f16525.unregisterReceiver(this.f16526);
            this.f16527 = false;
        } else {
            Log.w(f16524, "PowerStatusReceiver was never registered?");
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public synchronized void m14621() {
        if (this.f16527) {
            Log.w(f16524, "PowerStatusReceiver was already registered?");
        } else {
            this.f16525.registerReceiver(this.f16526, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            this.f16527 = true;
        }
        m14619();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m14622() {
        m14618();
    }
}
