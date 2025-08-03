package defpackage;

import android.hardware.Camera;
import com.blink.academy.film.zxing.camera.open.CameraFacing;

/* compiled from: OpenCamera.java */
/* renamed from: њ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2928 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int f10635;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Camera f10636;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final CameraFacing f10637;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int f10638;

    public C2928(int i, Camera camera, CameraFacing cameraFacing, int i2) {
        this.f10635 = i;
        this.f10636 = camera;
        this.f10637 = cameraFacing;
        this.f10638 = i2;
    }

    public String toString() {
        return "Camera #" + this.f10635 + " : " + this.f10637 + ',' + this.f10638;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Camera m10328() {
        return this.f10636;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public CameraFacing m10329() {
        return this.f10637;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public int m10330() {
        return this.f10638;
    }
}
