package defpackage;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.ColorSpaceTransform;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.RggbChannelVector;
import android.os.Handler;
import android.util.Range;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.blink.academy.film.FilmApp;
import defpackage.AbstractC2341;
import defpackage.C3444;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: CameraController2.java */
/* renamed from: ߖ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3835 extends AbstractC2341 {

    /* renamed from: ߿, reason: contains not printable characters */
    public static final SparseIntArray f13138;

    /* renamed from: ࡠ, reason: contains not printable characters */
    public static final SparseIntArray f13139;

    /* renamed from: ࡡ, reason: contains not printable characters */
    public static final SparseIntArray f13140;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f13141;

    /* renamed from: ֈ, reason: contains not printable characters */
    public Handler f13142;

    /* renamed from: ֏, reason: contains not printable characters */
    public CameraDevice f13143;

    /* renamed from: ׯ, reason: contains not printable characters */
    public CameraCaptureSession f13144;

    /* renamed from: ؠ, reason: contains not printable characters */
    public CameraCharacteristics f13145;

    /* renamed from: ހ, reason: contains not printable characters */
    public CaptureRequest.Builder f13146;

    /* renamed from: ށ, reason: contains not printable characters */
    public C4378 f13147;

    /* renamed from: ނ, reason: contains not printable characters */
    public Surface f13148;

    /* renamed from: ރ, reason: contains not printable characters */
    public C4378 f13149;

    /* renamed from: ބ, reason: contains not printable characters */
    public int[] f13150;

    /* renamed from: ޅ, reason: contains not printable characters */
    public Float f13151;

    /* renamed from: ކ, reason: contains not printable characters */
    public Float f13152;

    /* renamed from: އ, reason: contains not printable characters */
    public Rect f13153;

    /* renamed from: ވ, reason: contains not printable characters */
    public Range<Long> f13154;

    /* renamed from: މ, reason: contains not printable characters */
    public long f13155;

    /* renamed from: ފ, reason: contains not printable characters */
    public long f13156;

    /* renamed from: ދ, reason: contains not printable characters */
    public Range<Integer> f13157;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f13158;

    /* renamed from: ލ, reason: contains not printable characters */
    public int f13159;

    /* renamed from: ގ, reason: contains not printable characters */
    public Range<Integer>[] f13160;

    /* renamed from: ޏ, reason: contains not printable characters */
    public ArrayList<Integer> f13161;

    /* renamed from: ސ, reason: contains not printable characters */
    public boolean f13162;

    /* renamed from: ޑ, reason: contains not printable characters */
    public boolean f13163;

    /* renamed from: ޒ, reason: contains not printable characters */
    public Integer f13164;

    /* renamed from: ޓ, reason: contains not printable characters */
    public Integer f13165;

    /* renamed from: ޔ, reason: contains not printable characters */
    public int[] f13166;

    /* renamed from: ޕ, reason: contains not printable characters */
    public int[] f13167;

    /* renamed from: ޖ, reason: contains not printable characters */
    public List<CaptureRequest.Key<?>> f13168;

    /* renamed from: ޗ, reason: contains not printable characters */
    public String f13169;

    /* renamed from: ޘ, reason: contains not printable characters */
    public int f13170;

    /* renamed from: ޙ, reason: contains not printable characters */
    public C3641 f13171;

    /* renamed from: ޚ, reason: contains not printable characters */
    public C3485 f13172;

    /* renamed from: ޛ, reason: contains not printable characters */
    public float[] f13173;

    /* renamed from: ޜ, reason: contains not printable characters */
    public float f13174;

    /* renamed from: ޝ, reason: contains not printable characters */
    public final CameraDevice.StateCallback f13175;

    /* renamed from: ޞ, reason: contains not printable characters */
    public boolean f13176;

    /* renamed from: ޟ, reason: contains not printable characters */
    public SurfaceTexture.OnFrameAvailableListener f13177;

    /* renamed from: ޠ, reason: contains not printable characters */
    public SurfaceTexture.OnFrameAvailableListener f13178;

    /* renamed from: ޡ, reason: contains not printable characters */
    public SurfaceTexture.OnFrameAvailableListener f13179;

    /* renamed from: ޢ, reason: contains not printable characters */
    public final CameraCaptureSession.StateCallback f13180;

    /* renamed from: ޣ, reason: contains not printable characters */
    public float f13181;

    /* renamed from: ޤ, reason: contains not printable characters */
    public int f13182;

    /* renamed from: ޥ, reason: contains not printable characters */
    public CameraCaptureSession.CaptureCallback f13183;

    /* renamed from: ޱ, reason: contains not printable characters */
    public float f13184;

    /* renamed from: ߾, reason: contains not printable characters */
    public long f13185;

    /* compiled from: CameraController2.java */
    /* renamed from: ߖ$Ϳ, reason: contains not printable characters */
    public class C3836 extends CameraDevice.StateCallback {
        public C3836() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            if (C3835.this.f13141) {
                C4638.m14099("CameraController2", String.format("CameraDevice.StateCallback onDisconnected ", new Object[0]));
            }
            cameraDevice.close();
            C3835.this.f13143 = null;
            AbstractC2341.InterfaceC2342 interfaceC2342 = C3835.this.f8873;
            if (interfaceC2342 != null) {
                interfaceC2342.mo1362(" camera disconnected ");
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            if (C3835.this.f13141) {
                C4638.m14101("CameraController2", String.format(Locale.US, "CameraDevice.StateCallback onError:%d ", Integer.valueOf(i)));
            }
            C3835.this.mo8765();
            AbstractC2341.InterfaceC2342 interfaceC2342 = C3835.this.f8873;
            if (interfaceC2342 != null) {
                interfaceC2342.mo1362(String.format(Locale.US, " camera onError : %d", Integer.valueOf(i)));
            }
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            if (C3835.this.f13141) {
                C4638.m14099("CameraController2", String.format("CameraDevice.StateCallback onOpened ", new Object[0]));
            }
            C3835.this.f13143 = cameraDevice;
            C3835.this.m12188();
        }
    }

    /* compiled from: CameraController2.java */
    /* renamed from: ߖ$Ԩ, reason: contains not printable characters */
    public class C3837 implements SurfaceTexture.OnFrameAvailableListener {
        public C3837() {
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            C3835 c3835 = C3835.this;
            c3835.f8873.mo2047(c3835.f13147);
        }
    }

    /* compiled from: CameraController2.java */
    /* renamed from: ߖ$Ԫ, reason: contains not printable characters */
    public class C3838 implements SurfaceTexture.OnFrameAvailableListener {
        public C3838() {
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            C4638.m14099("CameraController2", String.format("mTestFrameAvailable onFrameAvailable", new Object[0]));
        }
    }

    /* compiled from: CameraController2.java */
    /* renamed from: ߖ$Ԭ, reason: contains not printable characters */
    public class C3839 implements SurfaceTexture.OnFrameAvailableListener {
        public C3839() {
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        }
    }

    /* compiled from: CameraController2.java */
    /* renamed from: ߖ$Ԯ, reason: contains not printable characters */
    public class C3840 extends CameraCaptureSession.StateCallback {
        public C3840() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(@NonNull CameraCaptureSession cameraCaptureSession) {
            super.onActive(cameraCaptureSession);
            if (C3835.this.f13141) {
                C4638.m14099("CameraController2", String.format("CameraCaptureSession.StateCallback onActive", new Object[0]));
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onCaptureQueueEmpty(@NonNull CameraCaptureSession cameraCaptureSession) {
            super.onCaptureQueueEmpty(cameraCaptureSession);
            if (C3835.this.f13141) {
                C4638.m14099("CameraController2", String.format("CameraCaptureSession.StateCallback onCaptureQueueEmpty", new Object[0]));
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(@NonNull CameraCaptureSession cameraCaptureSession) {
            super.onClosed(cameraCaptureSession);
            if (C3835.this.f13141) {
                C4638.m14099("CameraController2", String.format("CameraCaptureSession.StateCallback onClosed", new Object[0]));
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            if (C3835.this.f13141) {
                C4638.m14099("CameraController2", String.format("CameraCaptureSession.StateCallback onConfigureFailed", new Object[0]));
            }
            if (C3835.this.f13143 != null) {
                C3835.this.f13143.close();
                C3835.this.f13143 = null;
            }
            AbstractC2341.InterfaceC2342 interfaceC2342 = C3835.this.f8873;
            if (interfaceC2342 != null) {
                interfaceC2342.mo1362("onConfigureFailed");
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        @RequiresApi(api = 23)
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) throws CameraAccessException {
            if (C3835.this.f13141) {
                C4638.m14099("CameraController2", String.format("CameraCaptureSession.StateCallback onConfigured", new Object[0]));
            }
            C3835.this.f13144 = cameraCaptureSession;
            C3835.this.m12200();
            C3835.this.f13176 = false;
            C3835.this.m12204();
            C3835.this.m8770(1);
            C3835 c3835 = C3835.this;
            c3835.f8873.mo1363(c3835.f8872);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
            super.onReady(cameraCaptureSession);
            if (C3835.this.f13141) {
                C4638.m14099("CameraController2", String.format("CameraCaptureSession.StateCallback onReady", new Object[0]));
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onSurfacePrepared(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull Surface surface) {
            super.onSurfacePrepared(cameraCaptureSession, surface);
            if (C3835.this.f13141) {
                C4638.m14099("CameraController2", String.format("CameraCaptureSession.StateCallback onSurfacePrepared", new Object[0]));
            }
        }
    }

    /* compiled from: CameraController2.java */
    /* renamed from: ߖ$ՠ, reason: contains not printable characters */
    public class RunnableC3841 implements Runnable {
        public RunnableC3841() {
        }

        @Override // java.lang.Runnable
        public void run() throws CameraAccessException {
            C3835.this.m12205(true);
        }
    }

    /* compiled from: CameraController2.java */
    /* renamed from: ߖ$ֈ, reason: contains not printable characters */
    public class C3842 extends CameraCaptureSession.CaptureCallback {
        public C3842() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureBufferLost(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull Surface surface, long j) {
            super.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
            if (C3835.this.f13141) {
                C4638.m14099("CameraController2", String.format("CameraCaptureSession.CaptureCallback onCaptureBufferLost", new Object[0]));
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
            RggbChannelVector rggbChannelVector = (RggbChannelVector) totalCaptureResult.get(CaptureResult.COLOR_CORRECTION_GAINS);
            c8.m199((ColorSpaceTransform) totalCaptureResult.get(CaptureResult.COLOR_CORRECTION_TRANSFORM));
            C4506 c4506M8784 = C3835.this.f8872.m8784();
            if (rggbChannelVector != null) {
                int[] iArrM201 = c8.m201(rggbChannelVector);
                c4506M8784.m13825(iArrM201[0]);
                c4506M8784.m13826(iArrM201[1]);
            }
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY);
            Long l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
            Float f = (Float) totalCaptureResult.get(CaptureResult.LENS_FOCUS_DISTANCE);
            if (f != null) {
                C3835.this.f13181 = f.floatValue();
            }
            Float f2 = (Float) totalCaptureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
            Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY);
            Long l2 = (Long) totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
            if (num2 != null && l2 != null) {
                C3835.this.f13185 = num2.intValue() * l2.longValue();
            }
            c4506M8784.m13824((Range) totalCaptureResult.get(TotalCaptureResult.CONTROL_AE_TARGET_FPS_RANGE));
            if (f2 != null) {
                c4506M8784.m12249(f2.floatValue());
            }
            if (num != null) {
                c4506M8784.m12246(num.intValue());
            } else {
                c4506M8784.m12246(0);
            }
            if (l != null) {
                c4506M8784.m12242(l.longValue());
            } else {
                c4506M8784.m12242(0L);
            }
            C3835 c3835 = C3835.this;
            AbstractC2341.InterfaceC2342 interfaceC2342 = c3835.f8873;
            if (interfaceC2342 != null) {
                interfaceC2342.mo1361(c3835.f8872);
            }
            Integer num3 = (Integer) totalCaptureResult.get(TotalCaptureResult.CONTROL_AF_TRIGGER);
            Integer num4 = (Integer) totalCaptureResult.get(TotalCaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
            Integer num5 = (Integer) totalCaptureResult.get(TotalCaptureResult.CONTROL_AF_STATE);
            Integer num6 = (Integer) totalCaptureResult.get(TotalCaptureResult.CONTROL_AE_STATE);
            if ("METER_FOCUS_TAG".equals(captureRequest.getTag()) && C3835.this.f13141) {
                C4638.m14099("CameraController2", String.format("CONTROL_AF_STATE : %s  , CONTROL_AE_STATE : %s , CONTROL_AF_TRIGGER : %s , CONTROL_AE_PRECAPTURE_TRIGGER : %s ", num5, num6, num3, num4));
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureFailure captureFailure) {
            super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
            if (C3835.this.f13141) {
                C4638.m14099("CameraController2", String.format("CameraCaptureSession.CaptureCallback onCaptureFailed", new Object[0]));
            }
            C3835.m12178(C3835.this);
            if (C3835.this.f13182 > 60) {
                C3835.this.f13182 = 0;
                AbstractC2341.InterfaceC2342 interfaceC2342 = C3835.this.f8873;
                if (interfaceC2342 != null) {
                    interfaceC2342.mo1362("No camera available. Camera size = 0");
                }
                C3835.this.mo8765();
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(@NonNull CameraCaptureSession cameraCaptureSession, int i) {
            super.onCaptureSequenceAborted(cameraCaptureSession, i);
            if (C3835.this.f13141) {
                C4638.m14099("CameraController2", String.format("CameraCaptureSession.CaptureCallback onCaptureSequenceAborted", new Object[0]));
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(@NonNull CameraCaptureSession cameraCaptureSession, int i, long j) {
            super.onCaptureSequenceCompleted(cameraCaptureSession, i, j);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j, long j2) {
            super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13138 = sparseIntArray;
        sparseIntArray.put(2, 1);
        sparseIntArray.put(4, 2);
        sparseIntArray.put(5, 5);
        sparseIntArray.put(6, 6);
        sparseIntArray.put(7, 3);
        sparseIntArray.put(8, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f13139 = sparseIntArray2;
        sparseIntArray2.put(0, 0);
        sparseIntArray2.put(2, 2);
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        f13140 = sparseIntArray3;
        sparseIntArray3.put(0, 0);
        sparseIntArray3.put(1, 1);
    }

    public C3835(AbstractC2341.C2343 c2343, Handler handler, AbstractC2341.InterfaceC2342 interfaceC2342) {
        super(c2343, handler, interfaceC2342);
        this.f13141 = false;
        this.f13155 = 0L;
        this.f13156 = 0L;
        this.f13158 = 0;
        this.f13159 = 0;
        this.f13162 = false;
        this.f13163 = false;
        this.f13169 = null;
        this.f13170 = 2;
        this.f13175 = new C3836();
        this.f13176 = true;
        this.f13177 = new C3837();
        this.f13178 = new C3838();
        this.f13179 = new C3839();
        this.f13180 = new C3840();
        this.f13182 = 0;
        this.f13183 = new C3842();
        this.f13184 = -1.0f;
        this.f13142 = handler;
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 init ", new Object[0]));
        }
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public static /* synthetic */ int m12178(C3835 c3835) {
        int i = c3835.f13182;
        c3835.f13182 = i + 1;
        return i;
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: Ϳ */
    public void mo8760(RectF rectF, Runnable runnable) throws CameraAccessException {
        if (m12195()) {
            this.f13146.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            this.f13146.set(CaptureRequest.CONTROL_AF_MODE, 0);
            this.f13146.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(this.f13181));
            m12204();
        }
        runnable.run();
    }

    @Override // defpackage.AbstractC2341
    @SuppressLint({"MissingPermission"})
    /* renamed from: ԩ */
    public void mo8762() throws Resources.NotFoundException, CameraAccessException {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 initCamera ", new Object[0]));
        }
        mo8765();
        this.f13162 = false;
        this.f13163 = false;
        d1 d1VarM8785 = this.f8872.m8785();
        String strM12212 = d1VarM8785.m12212();
        CameraManager cameraManager = (CameraManager) FilmApp.m405().getSystemService("camera");
        if (cameraManager == null) {
            if (this.f13141) {
                C4638.m14099("CameraController2", String.format("No CameraManager available.", new Object[0]));
            }
            AbstractC2341.InterfaceC2342 interfaceC2342 = this.f8873;
            if (interfaceC2342 != null) {
                interfaceC2342.mo1362("No CameraManager available.");
            }
            mo8765();
            return;
        }
        C3641 c3641M11713 = C3641.m11713(cameraManager);
        this.f13171 = c3641M11713;
        if (c3641M11713.m11723().size() == 0) {
            if (this.f13141) {
                C4638.m14099("CameraController2", String.format("No camera available.", new Object[0]));
            }
            AbstractC2341.InterfaceC2342 interfaceC23422 = this.f8873;
            if (interfaceC23422 != null) {
                interfaceC23422.mo1362("No camera available. Camera size = 0");
            }
            mo8765();
            return;
        }
        C3485 c3485M11721 = this.f13171.m11721(strM12212);
        this.f13172 = c3485M11721;
        if (c3485M11721 == null) {
            if (this.f13141) {
                C4638.m14099("CameraController2", String.format("Not found available camera. needCameraId : %s", strM12212));
            }
            strM12212 = "0";
            this.f13172 = this.f13171.m11721("0");
        }
        if (this.f13172 == null) {
            if (this.f13141) {
                C4638.m14099("CameraController2", String.format("Not found available camera. needCameraId : %s", strM12212));
            }
            AbstractC2341.InterfaceC2342 interfaceC23423 = this.f8873;
            if (interfaceC23423 != null) {
                interfaceC23423.mo1362("Not found available camera.");
            }
            mo8765();
            return;
        }
        try {
            this.f13169 = strM12212;
            this.f13145 = cameraManager.getCameraCharacteristics(strM12212);
            C4638.m14099("CameraController2", String.format("mCameraId : %s ", this.f13169));
            C4506 c4506M8784 = this.f8872.m8784();
            c4506M8784.m12238(this.f13169);
            d1VarM8785.m12238(this.f13169);
            c4506M8784.m13823(this.f13172.m11374());
            float[] fArrM11361 = this.f13172.m11361();
            this.f13173 = fArrM11361;
            d1VarM8785.m12247(fArrM11361);
            int[] iArrM11362 = this.f13172.m11362();
            this.f13150 = iArrM11362;
            c4506M8784.m13820(iArrM11362);
            List<CaptureRequest.Key<?>> listM11351 = this.f13172.m11351();
            this.f13168 = listM11351;
            c4506M8784.m13821(listM11351);
            this.f13161 = null;
            Range<Integer>[] rangeArrM11352 = this.f13172.m11352();
            this.f13160 = rangeArrM11352;
            if (rangeArrM11352 != null) {
                this.f13161 = new ArrayList<>();
                for (Range<Integer> range : this.f13160) {
                    if (((Integer) range.getUpper()).intValue() == ((Integer) range.getLower()).intValue()) {
                        this.f13161.add((Integer) range.getLower());
                    }
                }
            }
            if (this.f13161 == null) {
                if (this.f13141) {
                    C4638.m14099("CameraController2", String.format("Not found available fps. needCameraId : %s", strM12212));
                }
                AbstractC2341.InterfaceC2342 interfaceC23424 = this.f8873;
                if (interfaceC23424 != null) {
                    interfaceC23424.mo1362("Not found available fps.");
                }
                mo8765();
                return;
            }
            if (!m12196()) {
                if (this.f13141) {
                    C4638.m14099("CameraController2", String.format("Not found available size. needCameraId : %s", strM12212));
                }
                AbstractC2341.InterfaceC2342 interfaceC23425 = this.f8873;
                if (interfaceC23425 != null) {
                    interfaceC23425.mo1362("no validate size");
                }
                mo8765();
                return;
            }
            this.f13151 = this.f13172.m11363();
            this.f13152 = this.f13172.m11368();
            this.f13153 = this.f13172.m11369();
            this.f13154 = this.f13172.m11370();
            this.f13157 = this.f13172.m11371();
            Range<Long> range2 = this.f13154;
            this.f13155 = range2 != null ? ((Long) range2.getUpper()).longValue() : 0L;
            Range<Long> range3 = this.f13154;
            this.f13156 = range3 != null ? ((Long) range3.getLower()).longValue() : 0L;
            Range<Integer> range4 = this.f13157;
            this.f13158 = range4 != null ? ((Integer) range4.getUpper()).intValue() : 0;
            Range<Integer> range5 = this.f13157;
            this.f13159 = range5 != null ? ((Integer) range5.getLower()).intValue() : 0;
            int[] iArrM11373 = this.f13172.m11373();
            this.f13166 = iArrM11373;
            c4506M8784.m13819(iArrM11373);
            this.f13167 = this.f13172.m11357();
            this.f13164 = this.f13172.m11353();
            this.f13165 = this.f13172.m11354();
            c4506M8784.m13828(this.f13158);
            c4506M8784.m13830(this.f13159);
            c4506M8784.m13827(this.f13155);
            c4506M8784.m13829(this.f13156);
            c4506M8784.m13822(this.f13172);
            if (this.f13172.m11385()) {
                cameraManager.openCamera(this.f13172.m11364(), this.f13175, this.f13142);
            } else {
                cameraManager.openCamera(this.f13169, this.f13175, this.f13142);
            }
            if (this.f13141) {
                C4638.m14099("CameraController2", String.format("CameraController2 initCamera finished", new Object[0]));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            m8770(2);
            if (this.f13141) {
                C4638.m14099("CameraController2", String.format("onCameraOpenFailed : %s", e2.getMessage()));
            }
            mo8765();
            AbstractC2341.InterfaceC2342 interfaceC23426 = this.f8873;
            if (interfaceC23426 != null) {
                interfaceC23426.mo1362(e2.getMessage());
            }
            if (this.f13141) {
                C4638.m14099("CameraController2", String.format("CameraController2 initCamera failed", new Object[0]));
            }
        }
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: Ԫ */
    public void mo8763() throws CameraAccessException {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 : %s ", "lockFocus"));
        }
        this.f13146.set(CaptureRequest.CONTROL_AF_MODE, 0);
        this.f13146.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(this.f13181));
        this.f13146.set(CaptureRequest.CONTROL_AE_MODE, 1);
        this.f13146.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
        m12204();
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: Ԭ */
    public void mo8765() {
        CaptureRequest.Builder builder;
        CaptureRequest.Builder builder2;
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("releaseCamera", new Object[0]));
        }
        Surface surface = this.f13148;
        if (surface != null && (builder2 = this.f13146) != null) {
            builder2.removeTarget(surface);
        }
        C4378 c4378 = this.f13147;
        if (c4378 != null && (builder = this.f13146) != null) {
            builder.removeTarget(c4378.m13550());
        }
        CameraCaptureSession cameraCaptureSession = this.f13144;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.f13144 = null;
        }
        CameraDevice cameraDevice = this.f13143;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.f13143 = null;
        }
        C4378 c43782 = this.f13147;
        if (c43782 != null) {
            c43782.m13549();
            this.f13147 = null;
        }
        C4378 c43783 = this.f13149;
        if (c43783 != null) {
            c43783.m13549();
            this.f13149 = null;
        }
        Surface surface2 = this.f13148;
        if (surface2 != null) {
            surface2.release();
            this.f13148 = null;
        }
        m8770(0);
        this.f8873.mo1359();
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController release success", new Object[0]));
        }
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: ԭ */
    public void mo8766() {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 restartPreview ", new Object[0]));
        }
        m8764(this.f8872);
        m12188();
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: Ԯ */
    public void mo8767() {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 resume ", new Object[0]));
        }
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: ԯ */
    public void mo8768() throws CameraAccessException {
        try {
            if (((Integer) this.f13146.get(CaptureRequest.CONTROL_AE_MODE)).intValue() == 1) {
                if (!((Boolean) this.f13146.get(CaptureRequest.CONTROL_AE_LOCK)).booleanValue()) {
                    return;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 : %s ", "setCameraAutoExposure"));
        }
        this.f13146.set(CaptureRequest.CONTROL_AE_MODE, 1);
        this.f13146.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
        m12204();
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: ՠ */
    public void mo8769(float f, float f2) throws CameraAccessException {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 : %s ", "setCameraAutoMode"));
        }
        CaptureRequest.Builder builder = this.f13146;
        if (builder == null) {
            return;
        }
        builder.set(CaptureRequest.CONTROL_AWB_MODE, 1);
        CaptureRequest.Builder builder2 = this.f13146;
        CaptureRequest.Key key = CaptureRequest.CONTROL_AWB_LOCK;
        Boolean bool = Boolean.FALSE;
        builder2.set(key, bool);
        this.f13146.set(CaptureRequest.CONTROL_MODE, 1);
        this.f13146.set(CaptureRequest.CONTROL_AE_MODE, 1);
        this.f13146.set(CaptureRequest.CONTROL_AF_MODE, 3);
        this.f13146.set(CaptureRequest.CONTROL_AE_LOCK, bool);
        this.f13184 = -1.0f;
        if (this.f13153 != null) {
            Rect rect = this.f13153;
            MeteringRectangle[] meteringRectangleArr = {new MeteringRectangle(rect.left, rect.top, rect.right, rect.bottom, 0)};
            this.f13146.set(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
            this.f13146.set(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr);
            if (this.f13141) {
                C4638.m14099("CameraController2", String.format("CONTROL_AF_REGIONS : %s ", Arrays.toString(meteringRectangleArr)));
            }
        }
        mo8779(f, f2);
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: ֏ */
    public void mo8771(int i) throws CameraAccessException {
        try {
            if (((Integer) this.f13146.get(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION)).intValue() == i) {
                return;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 setExposure : %s ", Integer.valueOf(i)));
        }
        CaptureRequest.Builder builder = this.f13146;
        if (builder == null) {
            return;
        }
        builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(i));
        m12204();
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: ׯ */
    public void mo8772(int i) throws CameraAccessException {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 setFlashMode : %s", Integer.valueOf(i)));
        }
        this.f13146.set(CaptureRequest.FLASH_MODE, Integer.valueOf(f13139.get(i, 0)));
        m12204();
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: ؠ */
    public void mo8773(float f) throws CameraAccessException {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 setFocusDistanceByPercent : %s", Float.valueOf(f)));
        }
        if (f == -1.0f) {
            this.f13146.set(CaptureRequest.CONTROL_AF_MODE, 3);
            this.f13184 = -1.0f;
            if (this.f13153 != null) {
                Rect rect = this.f13153;
                MeteringRectangle[] meteringRectangleArr = {new MeteringRectangle(rect.left, rect.top, rect.right, rect.bottom, 0)};
                this.f13146.set(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
                if (this.f13141) {
                    C4638.m14099("CameraController2", String.format("CONTROL_AF_REGIONS : %s ", Arrays.toString(meteringRectangleArr)));
                }
            }
        } else {
            Float f2 = this.f13151;
            if (f2 == null) {
                return;
            }
            float fFloatValue = f2.floatValue() * f;
            if (this.f13184 == fFloatValue) {
                return;
            }
            this.f13146.set(CaptureRequest.CONTROL_AF_MODE, 0);
            if (fFloatValue < 1.0E-6f) {
                fFloatValue = 1.0E-6f;
            }
            this.f13184 = fFloatValue;
            C4638.m14099("CameraController2", String.format("focusDistance : %s ", Float.valueOf(fFloatValue)));
            this.f13146.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(fFloatValue));
        }
        m12204();
        this.f8872.m8784().m12245(f);
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: ހ */
    public void mo8774(int i, long j) throws CameraAccessException {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 setISOAndExposureTime  iso : %s , time : %s ", Integer.valueOf(i), Long.valueOf(j)));
        }
        if (i == 0 && j == 0) {
            if (this.f13141) {
                C4638.m14099("CameraController2", String.format("iso : %s , time : %s  is  0 , 0", Integer.valueOf(i), Long.valueOf(j)));
            }
            this.f13146.set(CaptureRequest.CONTROL_AE_MODE, 1);
            this.f13146.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            m12204();
            C4506 c4506M8784 = this.f8872.m8784();
            c4506M8784.m12246(i);
            c4506M8784.m12242(j);
            return;
        }
        if (j == 0) {
            j = this.f13185 / i;
        } else if (i == 0) {
            i = Long.valueOf(this.f13185 / j).intValue();
        }
        long j2 = this.f13156;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.f13155;
        if (j > j3) {
            j = j3;
        }
        int i2 = this.f13159;
        if (i < i2) {
            i = i2;
        }
        int i3 = this.f13158;
        if (i > i3) {
            i = i3;
        }
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("iso : %s , time : %s ", Integer.valueOf(i), Long.valueOf(j)));
        }
        this.f13146.set(CaptureRequest.CONTROL_AE_MODE, 0);
        this.f13146.set(CaptureRequest.SENSOR_SENSITIVITY, Integer.valueOf(i));
        this.f13146.set(CaptureRequest.SENSOR_EXPOSURE_TIME, Long.valueOf(j));
        if (C2813.f10260) {
            this.f13146.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
        }
        m12204();
        C4506 c4506M87842 = this.f8872.m8784();
        c4506M87842.m12246(i);
        c4506M87842.m12242(j);
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: ށ */
    public void mo8775(RectF rectF) throws CameraAccessException {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 setMeterAeRegion : %s ", rectF));
        }
        if (!m12194() || this.f13153 == null || rectF == null) {
            return;
        }
        C4638.m14099("CameraController2", String.format("meterAeRegion : %s", rectF));
        MeteringRectangle[] meteringRectangleArr = (MeteringRectangle[]) this.f13146.get(CaptureRequest.CONTROL_AE_REGIONS);
        if (meteringRectangleArr != null) {
            C4638.m14099("CameraController2", String.format("last meter rect size : %s , meterRect : %s ", Integer.valueOf(meteringRectangleArr.length), meteringRectangleArr[0]));
        } else {
            C4638.m14099("CameraController2", String.format("last meter is null : %s , ", "null"));
        }
        Rect rect = this.f13153;
        int i = rect.right;
        int i2 = rect.left;
        int i3 = rect.bottom;
        int i4 = rect.top;
        float f = rectF.left;
        float f2 = rectF.right;
        float f3 = rectF.top;
        float f4 = i - i2;
        int i5 = ((int) (f * f4)) + i2;
        float f5 = i3 - i4;
        int i6 = (int) ((rectF.bottom - f3) * f5);
        this.f13146.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
        this.f13146.set(CaptureRequest.CONTROL_AE_MODE, 1);
        MeteringRectangle meteringRectangle = new MeteringRectangle(i5, ((int) (f3 * f5)) + i4, (int) ((f2 - f) * f4), i6, 1000);
        MeteringRectangle[] meteringRectangleArr2 = {meteringRectangle};
        this.f13146.set(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr2);
        C4638.m14099("CameraController2", String.format("cur meter rectangle : %s", meteringRectangle));
        this.f13146.set(CaptureRequest.CONTROL_AF_MODE, 1);
        if (m12195()) {
            this.f13146.set(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr2);
        }
        m12204();
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: ނ */
    public void mo8776(RectF rectF) throws CameraAccessException {
        Rect rect;
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 setMeterAfRegion : %s ", rectF));
        }
        if (!m12195() || (rect = this.f13153) == null || rectF == null || this.f13146 == null) {
            return;
        }
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("meterAfRegion : %s , mACTIVEArraySize : %s ", rectF, rect));
        }
        if (this.f13141) {
            MeteringRectangle[] meteringRectangleArr = (MeteringRectangle[]) this.f13146.get(CaptureRequest.CONTROL_AF_REGIONS);
            if (meteringRectangleArr != null) {
                C4638.m14099("CameraController2", String.format("last meter rect size : %s , meterRect : %s ", Integer.valueOf(meteringRectangleArr.length), meteringRectangleArr[0]));
            } else {
                C4638.m14099("CameraController2", String.format("last meter is null : %s , ", "null"));
            }
        }
        Rect rect2 = this.f13153;
        int i = rect2.right;
        int i2 = rect2.left;
        int i3 = rect2.bottom;
        int i4 = rect2.top;
        float f = rectF.left;
        float f2 = rectF.right;
        float f3 = rectF.top;
        float f4 = i - i2;
        int i5 = ((int) (f * f4)) + i2;
        float f5 = i3 - i4;
        int i6 = (int) ((rectF.bottom - f3) * f5);
        this.f13146.set(CaptureRequest.CONTROL_AF_MODE, 1);
        MeteringRectangle meteringRectangle = new MeteringRectangle(i5, ((int) (f3 * f5)) + i4, (int) ((f2 - f) * f4), i6, 1000);
        MeteringRectangle[] meteringRectangleArr2 = {meteringRectangle};
        if (m12195()) {
            this.f13146.set(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr2);
        }
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("cur meter rectangle : %s", meteringRectangle));
        }
        m12201();
        m12199();
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: ރ */
    public void mo8777(Surface surface) {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 setRecorderSurface ", new Object[0]));
        }
        this.f13148 = surface;
        m12190();
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: ބ */
    public void mo8778(SurfaceTexture surfaceTexture) {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 setRecorderTexture ", new Object[0]));
        }
        if (this.f13162) {
            return;
        }
        this.f13148 = new Surface(surfaceTexture);
        m12190();
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: ޅ */
    public void mo8779(float f, float f2) throws CameraAccessException {
        if (m12209(f, f2)) {
            return;
        }
        m12204();
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: ކ */
    public void mo8780() {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 stopPreview ", new Object[0]));
        }
        if (this.f13143 == null || this.f13144 == null) {
            this.f13176 = true;
            return;
        }
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 begin stopPreview ", new Object[0]));
        }
        try {
            try {
                CameraCaptureSession cameraCaptureSession = this.f13144;
                if (cameraCaptureSession != null) {
                    cameraCaptureSession.abortCaptures();
                }
            } catch (Exception e2) {
                try {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            this.f13176 = true;
            Surface surface = this.f13148;
            if (surface != null) {
                this.f13146.removeTarget(surface);
            }
            C4378 c4378 = this.f13147;
            if (c4378 != null) {
                this.f13146.removeTarget(c4378.m13550());
            }
            CameraCaptureSession cameraCaptureSession2 = this.f13144;
            if (cameraCaptureSession2 != null) {
                cameraCaptureSession2.close();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: އ */
    public void mo8781() {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 updateRecorderPreview ", new Object[0]));
        }
        m12190();
    }

    @Override // defpackage.AbstractC2341
    /* renamed from: ވ */
    public void mo8782() throws CameraAccessException {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 : %s ", "updateWhiteBalanceSetting"));
        }
        m12208();
        m12204();
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final void m12188() {
        int i;
        boolean z;
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraDevice.StateCallback checkConfigOnOpened ", new Object[0]));
        }
        if (m12189()) {
            return;
        }
        d1 d1VarM8785 = this.f8872.m8785();
        if (this.f8877.m8846() != d1VarM8785.m12227() || this.f8877.m8843() != d1VarM8785.m12226()) {
            C2375 c2375 = C3444.InterfaceC3447.f11883;
            d1VarM8785.m12253(c2375.m8846());
            d1VarM8785.m12252(c2375.m8843());
            m8764(this.f8872);
        }
        if (m12189()) {
            return;
        }
        C4506 c4506M8784 = this.f8872.m8784();
        d1VarM8785.m12253(this.f8877.m8846());
        d1VarM8785.m12252(this.f8877.m8843());
        c4506M8784.m12253(this.f8877.m8846());
        c4506M8784.m12252(this.f8877.m8843());
        int iM12225 = d1VarM8785.m12225();
        List<Integer> list = d1VarM8785.m12213() == 1 ? this.f8878.get(this.f8877) : this.f13161;
        if (list == null || list.size() == 0) {
            if (this.f13141) {
                C4638.m14099("CameraController2", String.format("no supportFps ", new Object[0]));
            }
            this.f13143.close();
            this.f13143 = null;
            mo8765();
            AbstractC2341.InterfaceC2342 interfaceC2342 = this.f8873;
            if (interfaceC2342 != null) {
                interfaceC2342.mo1362("no supportFps");
                return;
            }
            return;
        }
        if (!list.contains(Integer.valueOf(iM12225))) {
            v5 v5Var = C3444.InterfaceC3448.f11887;
            v5 v5Var2 = C3444.InterfaceC3448.f11888;
            v5 v5Var3 = C3444.InterfaceC3448.f11889;
            v5 v5Var4 = C3444.InterfaceC3448.f11892;
            v5 v5Var5 = C3444.InterfaceC3448.f11893;
            int iM8464 = v5Var3.m8464();
            for (int size = list.size() - 1; size >= 0; size--) {
                Integer num = list.get(size);
                if (num.intValue() == v5Var.m8464() || num.intValue() == v5Var2.m8464() || num.intValue() == v5Var3.m8464() || num.intValue() == v5Var4.m8464() || num.intValue() == v5Var5.m8464()) {
                    iM12225 = num.intValue();
                    break;
                }
            }
            iM12225 = iM8464;
            d1VarM8785.m12251(iM12225);
            d1VarM8785.m12255(iM12225);
            c4506M8784.m12251(iM12225);
            c4506M8784.m12255(iM12225);
        }
        m12197();
        int iM12231 = d1VarM8785.m12231();
        if (iM12231 != 1) {
            int i2 = f13138.get(iM12231, -1);
            int[] iArrM11356 = this.f13172.m11356();
            if (iArrM11356 == null || iArrM11356.length == 0) {
                iM12231 = 2;
                d1VarM8785.m12257(iM12231);
                c4506M8784.m12257(iM12231);
            } else {
                int i3 = 0;
                while (true) {
                    if (i3 >= iArrM11356.length) {
                        z = false;
                        break;
                    } else {
                        if (i2 == iArrM11356[i3]) {
                            z = true;
                            break;
                        }
                        i3++;
                    }
                }
                if (!z) {
                    C4638.m14099("CameraController2", String.format("whiteBalanceMode : %s , wb : %s ", Integer.valueOf(iM12231), Integer.valueOf(i2)));
                    iM12231 = 2;
                }
                d1VarM8785.m12257(iM12231);
                c4506M8784.m12257(iM12231);
            }
        }
        if (iM12225 > 60) {
            this.f13163 = true;
            i = 0;
        } else {
            i = 0;
            this.f13163 = false;
        }
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraDevice.StateCallback checkConfigOnOpened end", new Object[i]));
        }
        AbstractC2341.InterfaceC2342 interfaceC23422 = this.f8873;
        if (interfaceC23422 != null) {
            interfaceC23422.mo1358(this.f8872);
        }
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final boolean m12189() {
        if (this.f8877 != null && this.f8876 != null) {
            return false;
        }
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("no valid size ", new Object[0]));
        }
        this.f13143.close();
        this.f13143 = null;
        mo8765();
        AbstractC2341.InterfaceC2342 interfaceC2342 = this.f8873;
        if (interfaceC2342 == null) {
            return true;
        }
        interfaceC2342.mo1362("no valid size");
        return true;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final synchronized void m12190() {
        if (this.f13148 != null) {
            mo8780();
            while (!this.f13176) {
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            m12198();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00e0 A[Catch: Exception -> 0x021d, TryCatch #1 {Exception -> 0x021d, blocks: (B:9:0x001b, B:11:0x0033, B:14:0x0039, B:16:0x005c, B:26:0x007f, B:28:0x00e0, B:30:0x00ef, B:31:0x00f4, B:32:0x00f9, B:34:0x0124, B:36:0x0128, B:37:0x0132, B:39:0x013a, B:41:0x0140, B:44:0x017c, B:48:0x0186, B:50:0x018a, B:52:0x01aa, B:53:0x01be, B:56:0x01c9, B:47:0x0183, B:57:0x01cc, B:59:0x01d0, B:61:0x01f0, B:62:0x0204, B:17:0x005f, B:19:0x0065, B:20:0x006a, B:22:0x0070, B:63:0x020e, B:65:0x0219), top: B:77:0x001b, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x018a A[Catch: CameraAccessException -> 0x01c8, Exception -> 0x021d, TryCatch #2 {CameraAccessException -> 0x01c8, blocks: (B:48:0x0186, B:50:0x018a, B:52:0x01aa, B:53:0x01be), top: B:78:0x0186, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d0 A[Catch: Exception -> 0x021d, TryCatch #1 {Exception -> 0x021d, blocks: (B:9:0x001b, B:11:0x0033, B:14:0x0039, B:16:0x005c, B:26:0x007f, B:28:0x00e0, B:30:0x00ef, B:31:0x00f4, B:32:0x00f9, B:34:0x0124, B:36:0x0128, B:37:0x0132, B:39:0x013a, B:41:0x0140, B:44:0x017c, B:48:0x0186, B:50:0x018a, B:52:0x01aa, B:53:0x01be, B:56:0x01c9, B:47:0x0183, B:57:0x01cc, B:59:0x01d0, B:61:0x01f0, B:62:0x0204, B:17:0x005f, B:19:0x0065, B:20:0x006a, B:22:0x0070, B:63:0x020e, B:65:0x0219), top: B:77:0x001b, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x017c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v12, types: [android.hardware.camera2.params.OutputConfiguration, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v13, types: [android.hardware.camera2.params.SessionConfiguration] */
    /* JADX WARN: Type inference failed for: r9v15, types: [android.hardware.camera2.params.OutputConfiguration, java.lang.Object] */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: ޚ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m12191() throws android.hardware.camera2.CameraAccessException {
        /*
            Method dump skipped, instructions count: 576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C3835.m12191():void");
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public final boolean m12192(Size[] sizeArr, Size size) {
        if (sizeArr != null && sizeArr.length > 0) {
            for (Size size2 : sizeArr) {
                if (size2.equals(size)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public final boolean m12193(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public final boolean m12194() {
        Integer num = this.f13164;
        return (num == null || num.intValue() == 0) ? false : true;
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public final boolean m12195() {
        Integer num = this.f13165;
        return (num == null || num.intValue() == 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b4 A[LOOP:1: B:69:0x01b2->B:70:0x01b4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0285  */
    /* renamed from: ޟ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m12196() {
        /*
            Method dump skipped, instructions count: 669
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C3835.m12196():boolean");
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public final void m12197() {
        List<Integer> list = this.f8878.get(this.f8877);
        C4506 c4506M8784 = this.f8872.m8784();
        if (list == null) {
            c4506M8784.m13833(null);
            return;
        }
        if (C2813.m10152(this.f13169)) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (120 == next.intValue() || 240 == next.intValue()) {
                    it.remove();
                }
            }
        }
        c4506M8784.m13833(list);
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public void m12198() {
        try {
            m12191();
        } catch (Exception e2) {
            e2.printStackTrace();
            if (this.f13141) {
                C4638.m14099("CameraController2", String.format("createCameraPreviewSession. failed . %s", e2.getMessage()));
            }
            AbstractC2341.InterfaceC2342 interfaceC2342 = this.f8873;
            if (interfaceC2342 != null) {
                interfaceC2342.mo1362("CreateCameraPreviewSession failed.");
            }
            mo8765();
        }
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public final void m12199() {
        CaptureRequest.Builder builder = this.f13146;
        if (builder != null) {
            try {
                builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
                builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                m12204();
                builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                m12204();
                builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                m12204();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public final void m12200() throws CameraAccessException {
        if (this.f13146 == null) {
            return;
        }
        d1 d1VarM8785 = this.f8872.m8785();
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("targetCameraConfig : %s ", d1VarM8785));
        }
        int iM12220 = d1VarM8785.m12220();
        long jM12216 = d1VarM8785.m12216();
        float fM12219 = d1VarM8785.m12219();
        this.f13146.set(CaptureRequest.CONTROL_MODE, 1);
        if (fM12219 == -1.0f) {
            this.f13146.set(CaptureRequest.CONTROL_AF_MODE, 3);
            if (this.f13153 != null) {
                Rect rect = this.f13153;
                MeteringRectangle[] meteringRectangleArr = {new MeteringRectangle(rect.left, rect.top, rect.right, rect.bottom, 0)};
                this.f13146.set(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
                if (this.f13141) {
                    C4638.m14099("CameraController2", String.format("CONTROL_AF_REGIONS : %s ", Arrays.toString(meteringRectangleArr)));
                }
            }
        } else {
            Float f = this.f13151;
            if (f != null) {
                float fFloatValue = fM12219 * f.floatValue();
                this.f13146.set(CaptureRequest.CONTROL_AF_MODE, 0);
                this.f13184 = fFloatValue;
                this.f13146.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(fFloatValue));
            }
        }
        m12209(d1VarM8785.m12218(), d1VarM8785.m12233());
        if (iM12220 == 0 || jM12216 == 0) {
            this.f13146.set(CaptureRequest.CONTROL_AE_MODE, 1);
            this.f13146.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            float fM12214 = d1VarM8785.m12214();
            Range<Integer> rangeM11355 = this.f13172.m11355();
            int iM12726 = (int) C3947.m12726(fM12214, ((Integer) rangeM11355.getUpper()).intValue(), ((Integer) rangeM11355.getLower()).intValue());
            this.f13146.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(iM12726));
            if (this.f13141) {
                C4638.m14099("CameraController2", String.format("evPercent : %s , etRealValue : %s ", Float.valueOf(fM12214), Integer.valueOf(iM12726)));
            }
        } else {
            this.f13146.set(CaptureRequest.CONTROL_AE_MODE, 0);
            this.f13146.set(CaptureRequest.SENSOR_SENSITIVITY, Integer.valueOf(iM12220));
            this.f13146.set(CaptureRequest.SENSOR_EXPOSURE_TIME, Long.valueOf(jM12216));
            if (C2813.f10260) {
                this.f13146.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
            }
            if (this.f13141) {
                C4638.m14099("CameraController2", String.format("iso : %s , exposureTime : %s ", Integer.valueOf(iM12220), Long.valueOf(jM12216)));
            }
        }
        m12208();
        m12207();
        m12203();
        m12202();
        this.f13146.set(CaptureRequest.FLASH_MODE, Integer.valueOf(f13139.get(d1VarM8785.m12217(), 0)));
        if (C2813.f10274) {
            int iM12222 = d1VarM8785.m12222();
            if (iM12222 == 1) {
                this.f13146.set(C2808.f10240, (byte) 0);
            } else if (iM12222 == 2) {
                this.f13146.set(C2808.f10240, (byte) 1);
            } else {
                if (iM12222 != 3) {
                    return;
                }
                this.f13146.set(C2808.f10240, (byte) 2);
            }
        }
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public final void m12201() throws CameraAccessException {
        this.f13146.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        m12206();
        this.f13146.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public final void m12202() {
        int iM12215 = this.f8872.m8785().m12215();
        int i = f13140.get(iM12215);
        boolean zM12193 = m12193(this.f13167, i);
        C4506 c4506M8784 = this.f8872.m8784();
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("updateEdgeEnhancement  mEDGEAvailableEdgeModes : %s , edgeMode : %s , contains : %s ", Arrays.toString(this.f13167), Integer.valueOf(i), Boolean.valueOf(zM12193)));
        }
        if (!zM12193) {
            c4506M8784.m12241(0);
        } else {
            this.f13146.set(CaptureRequest.EDGE_MODE, Integer.valueOf(i));
            c4506M8784.m12241(iM12215);
        }
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public final void m12203() {
        if (this.f13146 == null) {
            return;
        }
        int iM12224 = this.f8872.m8785().m12224();
        if (iM12224 == 1) {
            this.f13146.set(CaptureRequest.NOISE_REDUCTION_MODE, 1);
        } else if (iM12224 == 0) {
            this.f13146.set(CaptureRequest.NOISE_REDUCTION_MODE, 0);
        } else {
            this.f13146.set(CaptureRequest.NOISE_REDUCTION_MODE, 0);
        }
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public final void m12204() throws CameraAccessException {
        m12205(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f9, code lost:
    
        mo8765();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00a9 -> B:52:0x00f9). Please report as a decompilation issue!!! */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: ߿, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m12205(boolean r8) throws android.hardware.camera2.CameraAccessException {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C3835.m12205(boolean):void");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: ࡠ, reason: contains not printable characters */
    public final void m12206() throws CameraAccessException {
        if (this.f13143 == null) {
            return;
        }
        if (this.f13163) {
            try {
                this.f13144.captureBurst(((CameraConstrainedHighSpeedCaptureSession) this.f13144).createHighSpeedRequestList(this.f13146.build()), this.f13183, this.f13142);
                return;
            } catch (CameraAccessException e2) {
                e2.printStackTrace();
                C4638.m14101("CameraController2", String.format("high fps updatePreview fail : %s ", e2.getMessage()));
                return;
            }
        }
        try {
            this.f13144.capture(this.f13146.build(), this.f13183, this.f13142);
        } catch (CameraAccessException e3) {
            e3.printStackTrace();
            C4638.m14101("CameraController2", String.format("normal updatePreview fail : %s ", e3.getMessage()));
        }
    }

    /* renamed from: ࡡ, reason: contains not printable characters */
    public final void m12207() {
        C2375 c2375;
        d1 d1VarM8785 = this.f8872.m8785();
        int iM12230 = d1VarM8785.m12230();
        int iM12213 = d1VarM8785.m12213();
        if (iM12213 == 0 && (c2375 = this.f8877) != null && c2375.m8846() == C3444.InterfaceC3447.f11884.m8846() && C2813.f10260 && !C2813.f10266) {
            iM12230 = 0;
        }
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("captureMode : %s , videoStabilizationMode : %s ", Integer.valueOf(iM12213), Integer.valueOf(iM12230)));
        }
        if (iM12230 == 1) {
            this.f13146.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 1);
        } else if (iM12230 == 0) {
            this.f13146.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
        } else {
            this.f13146.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
        }
    }

    /* renamed from: ࡢ, reason: contains not printable characters */
    public final void m12208() {
        if (this.f13146 == null) {
        }
        int iM12231 = this.f8872.m8785().m12231();
        this.f8872.m8784().m12257(iM12231);
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("updateWhiteBalance : %s ", Integer.valueOf(iM12231)));
        }
        switch (iM12231) {
            case 1:
                this.f13146.set(CaptureRequest.CONTROL_AWB_MODE, 0);
                this.f13146.set(CaptureRequest.COLOR_CORRECTION_MODE, 0);
                this.f13146.set(CaptureRequest.COLOR_CORRECTION_TRANSFORM, c8.m193());
                this.f13146.set(CaptureRequest.COLOR_CORRECTION_GAINS, c8.m192());
                break;
            case 2:
            default:
                this.f13146.set(CaptureRequest.CONTROL_AWB_MODE, 1);
                this.f13146.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.FALSE);
                break;
            case 3:
                this.f13146.set(CaptureRequest.CONTROL_AWB_MODE, 1);
                this.f13146.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.TRUE);
                break;
            case 4:
                this.f13146.set(CaptureRequest.CONTROL_AWB_MODE, 2);
                break;
            case 5:
                this.f13146.set(CaptureRequest.CONTROL_AWB_MODE, 5);
                break;
            case 6:
                this.f13146.set(CaptureRequest.CONTROL_AWB_MODE, 6);
                break;
            case 7:
                this.f13146.set(CaptureRequest.CONTROL_AWB_MODE, 3);
                break;
            case 8:
                this.f13146.set(CaptureRequest.CONTROL_AWB_MODE, 8);
                break;
        }
    }

    /* renamed from: ࡣ, reason: contains not printable characters */
    public final boolean m12209(float f, float f2) throws CameraAccessException {
        if (this.f13141) {
            C4638.m14099("CameraController2", String.format("CameraController2 focalLength : %s , setZoomByRatio : %s , mCameraName : %s ", Float.valueOf(f), Float.valueOf(f2), this.f13169));
        }
        Float f3 = this.f13152;
        if (f3 == null || this.f13153 == null) {
            return true;
        }
        float fFloatValue = f3.floatValue();
        Rect rect = this.f13153;
        if (f2 > fFloatValue) {
            f2 = fFloatValue;
        }
        int iWidth = (rect.width() - ((int) (rect.width() / f2))) / 2;
        int iHeight = (rect.height() - ((int) (rect.height() / f2))) / 2;
        int i = iWidth - (iWidth & 3);
        int i2 = iHeight - (iHeight & 3);
        Rect rect2 = new Rect(i, i2, rect.width() - i, rect.height() - i2);
        C4638.m14099("CameraController2", String.format("zoomRatio : %s , maxZoom : %s , zoomResult : %s ", Float.valueOf(f2), Float.valueOf(fFloatValue), rect2));
        this.f13146.set(CaptureRequest.SCALER_CROP_REGION, rect2);
        Float f4 = (Float) this.f13146.get(CaptureRequest.LENS_FOCAL_LENGTH);
        if (f4 != null && f != 0.0f && f4.floatValue() != f) {
            this.f13146.set(CaptureRequest.LENS_FOCAL_LENGTH, Float.valueOf(f));
            if (C2813.f10276) {
                m12206();
            }
        }
        return false;
    }
}
