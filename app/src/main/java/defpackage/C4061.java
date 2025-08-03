package defpackage;

import android.hardware.Camera;
import android.util.Log;
import com.blink.academy.film.zxing.camera.open.CameraFacing;

/* compiled from: OpenCameraInterface.java */
/* renamed from: ख, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4061 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String f14089 = "ख";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C2928 m12990(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(f14089, "No cameras!");
            return null;
        }
        if (i >= numberOfCameras) {
            Log.w(f14089, "Requested camera does not exist: " + i);
            return null;
        }
        if (i <= -1) {
            i = 0;
            while (i < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (CameraFacing.values()[cameraInfo.facing] == CameraFacing.BACK) {
                    break;
                }
                i++;
            }
            if (i == numberOfCameras) {
                Log.i(f14089, "No camera facing " + CameraFacing.BACK + "; returning camera #0");
                i = 0;
            }
        }
        Log.i(f14089, "Opening camera #" + i);
        Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo2);
        Camera cameraOpen = Camera.open(i);
        if (cameraOpen == null) {
            return null;
        }
        return new C2928(i, cameraOpen, CameraFacing.values()[cameraInfo2.facing], cameraInfo2.orientation);
    }
}
