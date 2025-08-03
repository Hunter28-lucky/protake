package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: AutoFocusManager.java */
/* renamed from: ဨ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C5140 implements Camera.AutoFocusCallback {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final String f17068 = C5140.class.getSimpleName();

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final Collection<String> f17069;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f17070;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f17071;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean f17072;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Camera f17073;

    /* renamed from: ԫ, reason: contains not printable characters */
    public AsyncTask<?, ?, ?> f17074;

    /* compiled from: AutoFocusManager.java */
    /* renamed from: ဨ$Ԩ, reason: contains not printable characters */
    public final class AsyncTaskC5142 extends AsyncTask<Object, Object, Object> {
        public AsyncTaskC5142() {
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Object... objArr) throws InterruptedException {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException unused) {
            }
            C5140.this.m15052();
            return null;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f17069 = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public C5140(Context context, Camera camera) {
        this.f17073 = camera;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String focusMode = camera.getParameters().getFocusMode();
        boolean z = defaultSharedPreferences.getBoolean("preferences_auto_focus", true) && f17069.contains(focusMode);
        this.f17072 = z;
        Log.i(f17068, "Current focus mode '" + focusMode + "'; use auto focus? " + z);
        m15052();
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.f17071 = false;
        m15050();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final synchronized void m15050() {
        if (!this.f17070 && this.f17074 == null) {
            AsyncTaskC5142 asyncTaskC5142 = new AsyncTaskC5142();
            try {
                asyncTaskC5142.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                this.f17074 = asyncTaskC5142;
            } catch (RejectedExecutionException e2) {
                Log.w(f17068, "Could not request auto focus", e2);
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final synchronized void m15051() {
        AsyncTask<?, ?, ?> asyncTask = this.f17074;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                this.f17074.cancel(true);
            }
            this.f17074 = null;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public synchronized void m15052() {
        if (this.f17072) {
            this.f17074 = null;
            if (!this.f17070 && !this.f17071) {
                try {
                    this.f17073.autoFocus(this);
                    this.f17071 = true;
                } catch (RuntimeException e2) {
                    Log.w(f17068, "Unexpected exception while focusing", e2);
                    m15050();
                }
            }
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public synchronized void m15053() {
        this.f17070 = true;
        if (this.f17072) {
            m15051();
            try {
                this.f17073.cancelAutoFocus();
            } catch (RuntimeException e2) {
                Log.w(f17068, "Unexpected exception while cancelling focusing", e2);
            }
        }
    }
}
