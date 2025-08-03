package defpackage;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

/* compiled from: PreviewCallback.java */
/* renamed from: ݾ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3775 implements Camera.PreviewCallback {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final String f13028 = C3775.class.getSimpleName();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C3929 f13029;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Handler f13030;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f13031;

    public C3775(C3929 c3929) {
        this.f13029 = c3929;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point pointM12694 = this.f13029.m12694();
        Handler handler = this.f13030;
        if (pointM12694 == null || handler == null) {
            Log.d(f13028, "Got preview callback, but no handler or resolution available");
        } else {
            handler.obtainMessage(this.f13031, pointM12694.x, pointM12694.y, bArr).sendToTarget();
            this.f13030 = null;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m12079(Handler handler, int i) {
        this.f13030 = handler;
        this.f13031 = i;
    }
}
