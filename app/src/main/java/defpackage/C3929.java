package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.blink.academy.film.zxing.camera.FrontLightMode;
import com.blink.academy.film.zxing.camera.open.CameraFacing;
import com.google.zxing.client.android.camera.CameraConfigurationUtils;
import org.jcodec.codecs.mpeg12.MPEGConst;

/* compiled from: CameraConfigurationManager.java */
/* renamed from: ࡉ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3929 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Context f13558;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f13559;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f13560;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public Point f13561;

    /* renamed from: ԫ, reason: contains not printable characters */
    public Point f13562;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Point f13563;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Point f13564;

    public C3929(Context context) {
        this.f13558 = context;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m12693(Camera.Parameters parameters, boolean z, boolean z2) {
        CameraConfigurationUtils.setTorch(parameters, z);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f13558);
        if (z2 || defaultSharedPreferences.getBoolean("preferences_disable_exposure", true)) {
            return;
        }
        CameraConfigurationUtils.setBestExposure(parameters, z);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Point m12694() {
        return this.f13562;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public Point m12695() {
        return this.f13561;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean m12696(Camera camera) {
        Camera.Parameters parameters;
        if (camera == null || (parameters = camera.getParameters()) == null) {
            return false;
        }
        String flashMode = parameters.getFlashMode();
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m12697(C2928 c2928) {
        int i;
        Camera.Parameters parameters = c2928.m10328().getParameters();
        Display defaultDisplay = ((WindowManager) this.f13558.getSystemService("window")).getDefaultDisplay();
        int rotation = defaultDisplay.getRotation();
        if (rotation == 0) {
            i = 0;
        } else if (rotation == 1) {
            i = 90;
        } else if (rotation == 2) {
            i = MPEGConst.SEQUENCE_ERROR_CODE;
        } else if (rotation == 3) {
            i = 270;
        } else {
            if (rotation % 90 != 0) {
                throw new IllegalArgumentException("Bad rotation: " + rotation);
            }
            i = (rotation + 360) % 360;
        }
        Log.i("CameraConfiguration", "Display at: " + i);
        int iM10330 = c2928.m10330();
        Log.i("CameraConfiguration", "Camera at: " + iM10330);
        CameraFacing cameraFacingM10329 = c2928.m10329();
        CameraFacing cameraFacing = CameraFacing.FRONT;
        if (cameraFacingM10329 == cameraFacing) {
            iM10330 = (360 - iM10330) % 360;
            Log.i("CameraConfiguration", "Front camera overriden to: " + iM10330);
        }
        this.f13560 = ((iM10330 + 360) - i) % 360;
        Log.i("CameraConfiguration", "Final display orientation: " + this.f13560);
        if (c2928.m10329() == cameraFacing) {
            Log.i("CameraConfiguration", "Compensating rotation for front camera");
            this.f13559 = (360 - this.f13560) % 360;
        } else {
            this.f13559 = this.f13560;
        }
        Log.i("CameraConfiguration", "Clockwise rotation from display to camera: " + this.f13559);
        Point point = new Point();
        defaultDisplay.getSize(point);
        int iMax = Math.max(point.x, point.y);
        int iMin = Math.min(point.x, point.y);
        point.x = iMax;
        point.y = iMin;
        this.f13561 = point;
        Log.i("CameraConfiguration", "Screen resolution in current orientation: " + this.f13561);
        this.f13562 = CameraConfigurationUtils.findBestPreviewSizeValue(parameters, this.f13561);
        Log.i("CameraConfiguration", "Camera resolution: " + this.f13562);
        this.f13563 = CameraConfigurationUtils.findBestPreviewSizeValue(parameters, this.f13561);
        Log.i("CameraConfiguration", "Best available preview size: " + this.f13563);
        Point point2 = this.f13561;
        boolean z = point2.x < point2.y;
        Point point3 = this.f13563;
        if (z == (point3.x < point3.y)) {
            this.f13564 = point3;
        } else {
            Point point4 = this.f13563;
            this.f13564 = new Point(point4.y, point4.x);
        }
        Log.i("CameraConfiguration", "Preview size on screen: " + this.f13564);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m12698(Camera.Parameters parameters, SharedPreferences sharedPreferences, boolean z) {
        m12693(parameters, FrontLightMode.readPref(sharedPreferences) == FrontLightMode.ON, z);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m12699(C2928 c2928, boolean z) {
        Camera cameraM10328 = c2928.m10328();
        Camera.Parameters parameters = cameraM10328.getParameters();
        if (parameters == null) {
            Log.w("CameraConfiguration", "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i("CameraConfiguration", "Initial camera parameters: " + parameters.flatten());
        if (z) {
            Log.w("CameraConfiguration", "In camera config safe mode -- most settings will not be honored");
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f13558);
        m12698(parameters, defaultSharedPreferences, z);
        CameraConfigurationUtils.setFocus(parameters, defaultSharedPreferences.getBoolean("preferences_auto_focus", true), defaultSharedPreferences.getBoolean("preferences_disable_continuous_focus", false), z);
        if (!z) {
            if (defaultSharedPreferences.getBoolean("preferences_invert_scan", false)) {
                CameraConfigurationUtils.setInvertColor(parameters);
            }
            if (!defaultSharedPreferences.getBoolean("preferences_disable_barcode_scene_mode", true)) {
                CameraConfigurationUtils.setBarcodeSceneMode(parameters);
            }
            if (!defaultSharedPreferences.getBoolean("preferences_disable_metering", true)) {
                CameraConfigurationUtils.setVideoStabilization(parameters);
                CameraConfigurationUtils.setFocusArea(parameters);
                CameraConfigurationUtils.setMetering(parameters);
            }
            parameters.setRecordingHint(true);
        }
        Point point = this.f13563;
        parameters.setPreviewSize(point.x, point.y);
        cameraM10328.setParameters(parameters);
        cameraM10328.setDisplayOrientation(this.f13560);
        Camera.Size previewSize = cameraM10328.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point2 = this.f13563;
            if (point2.x == previewSize.width && point2.y == previewSize.height) {
                return;
            }
            Log.w("CameraConfiguration", "Camera said it supported preview size " + this.f13563.x + 'x' + this.f13563.y + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
            Point point3 = this.f13563;
            point3.x = previewSize.width;
            point3.y = previewSize.height;
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m12700(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        m12693(parameters, z, false);
        camera.setParameters(parameters);
    }
}
