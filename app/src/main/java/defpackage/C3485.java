package defpackage;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.media.MediaRecorder;
import android.media.audiofx.AutomaticGainControl;
import android.os.Build;
import android.renderscript.Allocation;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import android.util.SizeF;
import android.view.SurfaceHolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/* compiled from: CameraIdInfo.java */
/* renamed from: ه, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3485 {

    /* renamed from: ޱ, reason: contains not printable characters */
    public static String f12112 = "ه";

    /* renamed from: ߾, reason: contains not printable characters */
    public static StringBuilder f12113 = new StringBuilder();

    /* renamed from: ߿, reason: contains not printable characters */
    public static StringBuilder f12114 = new StringBuilder();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f12115;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public SizeF f12116;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f12117;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean f12118;

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f12119;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f12120;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f12121;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f12122;

    /* renamed from: ԯ, reason: contains not printable characters */
    public String f12123;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f12124;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int[] f12125;

    /* renamed from: ֏, reason: contains not printable characters */
    public Range<Integer>[] f12126;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Range<Long> f12127;

    /* renamed from: ؠ, reason: contains not printable characters */
    public Range<Integer> f12128;

    /* renamed from: ހ, reason: contains not printable characters */
    public int[] f12129;

    /* renamed from: ށ, reason: contains not printable characters */
    public Float f12130;

    /* renamed from: ނ, reason: contains not printable characters */
    public Float f12131;

    /* renamed from: ރ, reason: contains not printable characters */
    public Rect f12132;

    /* renamed from: ބ, reason: contains not printable characters */
    public int[] f12133;

    /* renamed from: ޅ, reason: contains not printable characters */
    public Integer f12134;

    /* renamed from: ކ, reason: contains not printable characters */
    public Integer f12135;

    /* renamed from: އ, reason: contains not printable characters */
    public float[] f12136;

    /* renamed from: ވ, reason: contains not printable characters */
    public int[] f12137;

    /* renamed from: މ, reason: contains not printable characters */
    public Integer f12138;

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean f12139;

    /* renamed from: ދ, reason: contains not printable characters */
    public boolean f12140;

    /* renamed from: ތ, reason: contains not printable characters */
    public boolean f12141;

    /* renamed from: ލ, reason: contains not printable characters */
    public double f12142;

    /* renamed from: ގ, reason: contains not printable characters */
    public List<CaptureRequest.Key<?>> f12143;

    /* renamed from: ޏ, reason: contains not printable characters */
    public Range<Integer> f12144;

    /* renamed from: ސ, reason: contains not printable characters */
    public Set<String> f12145;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int[] f12146;

    /* renamed from: ޒ, reason: contains not printable characters */
    public boolean f12147;

    /* renamed from: ޓ, reason: contains not printable characters */
    public boolean f12148;

    /* renamed from: ޔ, reason: contains not printable characters */
    public boolean f12149;

    /* renamed from: ޕ, reason: contains not printable characters */
    public boolean f12150;

    /* renamed from: ޖ, reason: contains not printable characters */
    public boolean f12151;

    /* renamed from: ޗ, reason: contains not printable characters */
    public boolean f12152;

    /* renamed from: ޘ, reason: contains not printable characters */
    public boolean f12153;

    /* renamed from: ޙ, reason: contains not printable characters */
    public boolean f12154;

    /* renamed from: ޚ, reason: contains not printable characters */
    public boolean f12155;

    /* renamed from: ޛ, reason: contains not printable characters */
    public boolean f12156;

    /* renamed from: ޜ, reason: contains not printable characters */
    public boolean f12157;

    /* renamed from: ޝ, reason: contains not printable characters */
    public boolean f12158;

    /* renamed from: ޞ, reason: contains not printable characters */
    public boolean f12159;

    /* renamed from: ޟ, reason: contains not printable characters */
    public boolean f12160;

    /* renamed from: ޠ, reason: contains not printable characters */
    public boolean f12161;

    /* renamed from: ޡ, reason: contains not printable characters */
    public boolean f12162;

    /* renamed from: ޢ, reason: contains not printable characters */
    public boolean f12163;

    /* renamed from: ޣ, reason: contains not printable characters */
    public boolean f12164;

    /* renamed from: ޤ, reason: contains not printable characters */
    public Size f12165;

    /* renamed from: ޥ, reason: contains not printable characters */
    public float f12166;

    /* compiled from: CameraIdInfo.java */
    /* renamed from: ه$Ϳ, reason: contains not printable characters */
    public class C3486 implements Comparator<Size> {
        public C3486() {
        }

        @Override // java.util.Comparator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public int compare(Size size, Size size2) {
            return (size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight());
        }
    }

    public C3485() {
        this.f12115 = false;
        this.f12118 = true;
        this.f12142 = -1.0d;
        this.f12152 = true;
        this.f12153 = true;
        this.f12154 = true;
        this.f12155 = true;
        this.f12156 = true;
        this.f12157 = true;
        this.f12158 = true;
        this.f12159 = true;
        this.f12160 = true;
        this.f12161 = false;
        this.f12162 = true;
        this.f12163 = false;
        this.f12164 = false;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static StringBuilder m11349() {
        return f12113;
    }

    public String toString() {
        return "CameraIdInfo{mId='" + this.f12117 + "', mIsValid=" + this.f12118 + ", mIsFacing=" + this.f12119 + ", mSupportedHardwareLevel=" + this.f12120 + ", mSensorOrientation=" + this.f12121 + ", mIsLogicalId=" + this.f12122 + ", hasMulti=" + this.f12139 + ", hasManualControl=" + this.f12140 + ", hasDepth=" + this.f12141 + ", hasWideFocalLength=" + this.f12148 + ", isLargeWideCamera=" + this.f12149 + ", isWideCamera=" + this.f12151 + ", isTelephotoCamera=" + this.f12150 + '}';
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean m11350(CameraCharacteristics cameraCharacteristics) {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            return false;
        }
        Size[] outputSizes = streamConfigurationMap.getOutputSizes(MediaCodec.class);
        if (this.f12115) {
            String str = String.format("support MediaCodec Sizes : \n%s ", Arrays.toString(outputSizes));
            StringBuilder sb = f12114;
            sb.append(str);
            sb.append("\n");
        }
        Size[] outputSizes2 = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        if (this.f12115) {
            String.format("support SurfaceTexture :  \n%s ", Arrays.toString(outputSizes2));
        }
        Size[] outputSizes3 = streamConfigurationMap.getOutputSizes(ImageReader.class);
        if (this.f12115) {
            String.format("support ImageReader : \n%s ", Arrays.toString(outputSizes3));
        }
        Size[] outputSizes4 = streamConfigurationMap.getOutputSizes(MediaRecorder.class);
        if (this.f12115) {
            String str2 = String.format("support MediaRecorder Sizes : \n%s ", Arrays.toString(outputSizes4));
            StringBuilder sb2 = f12114;
            sb2.append(str2);
            sb2.append("\n");
        }
        Size[] outputSizes5 = streamConfigurationMap.getOutputSizes(Allocation.class);
        if (this.f12115) {
            String.format("support Allocation : \n%s ", Arrays.toString(outputSizes5));
        }
        Size[] outputSizes6 = streamConfigurationMap.getOutputSizes(SurfaceHolder.class);
        if (this.f12115) {
            String.format("support SurfaceHolder : \n%s ", Arrays.toString(outputSizes6));
        }
        Size[] outputSizes7 = streamConfigurationMap.getOutputSizes(256);
        if (this.f12115) {
            String.format("support ImageFormat.JPEG : \n%s ", Arrays.toString(outputSizes7));
        }
        if (outputSizes2 != null && outputSizes2.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (Size size : outputSizes2) {
                if (m11384(outputSizes, size)) {
                    arrayList.add(size);
                }
            }
            Collections.sort(arrayList, new C3486());
            Size size2 = (Size) arrayList.get(arrayList.size() - 1);
            this.f12165 = size2;
            if (this.f12115) {
                C4638.m14099(f12112, String.format("support previewSizes : %s , maxSupportSize : %s ", arrayList, size2));
            }
        }
        return true;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public List<CaptureRequest.Key<?>> m11351() {
        return this.f12143;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public Range<Integer>[] m11352() {
        return this.f12126;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public Integer m11353() {
        return this.f12134;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public Integer m11354() {
        return this.f12135;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Range<Integer> m11355() {
        return this.f12144;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public int[] m11356() {
        return this.f12146;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public int[] m11357() {
        return this.f12133;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public double m11358() {
        return this.f12142;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final float m11359(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return -1.0f;
        }
        return fArr[0];
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public String m11360() {
        return this.f12117;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public float[] m11361() {
        return this.f12136;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public int[] m11362() {
        return this.f12125;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public Float m11363() {
        return this.f12130;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public String m11364() {
        return this.f12123;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public Size m11365() {
        return this.f12165;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public Set<String> m11366() {
        return this.f12145;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public int[] m11367() {
        return this.f12137;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public Float m11368() {
        return this.f12131;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public Rect m11369() {
        return this.f12132;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public Range<Long> m11370() {
        return this.f12127;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public Range<Integer> m11371() {
        return this.f12128;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public SizeF m11372() {
        return this.f12116;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public int[] m11373() {
        return this.f12129;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public int m11374() {
        return this.f12121;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public float m11375() {
        return this.f12166;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public boolean m11376() {
        return this.f12157;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public boolean m11377() {
        return this.f12159;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public boolean m11378() {
        return this.f12158;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public boolean m11379() {
        return this.f12160;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public boolean m11380() {
        return this.f12147;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public boolean m11381() {
        return this.f12161;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public boolean m11382() {
        return this.f12164;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public boolean m11383() {
        return this.f12119;
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final boolean m11384(Size[] sizeArr, Size size) {
        if (sizeArr != null && sizeArr.length > 0) {
            for (Size size2 : sizeArr) {
                if (size2.equals(size)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public boolean m11385() {
        return this.f12124;
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public boolean m11386() {
        return this.f12122;
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final boolean m11387(int[] iArr, int i) {
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

    /* renamed from: ޙ, reason: contains not printable characters */
    public boolean m11388() {
        return this.f12163;
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public final boolean m11389(CaptureRequest.Key key, List<CaptureRequest.Key<?>> list) {
        if (key == null || list == null) {
            return false;
        }
        return list.contains(key);
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public boolean m11390() {
        return this.f12162;
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public boolean m11391() {
        return this.f12152;
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public boolean m11392() {
        return this.f12154;
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public boolean m11393() {
        return this.f12155;
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public boolean m11394() {
        return this.f12153;
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public boolean m11395() {
        return this.f12156;
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public boolean m11396() {
        return this.f12118;
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public void m11397() {
        float fM11359 = m11359(this.f12136);
        SizeF sizeF = this.f12116;
        if (fM11359 != -1.0f && sizeF != null) {
            this.f12142 = (fM11359 * 43.27d) / Math.sqrt(Math.pow(sizeF.getWidth(), 2.0d) + Math.pow(sizeF.getHeight(), 2.0d));
        }
        if (this.f12115) {
            C4638.m14099(f12112, String.format("equivalentFocalLength : %s ", Double.valueOf(this.f12142)));
        }
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public C3485 m11398(boolean z) {
        this.f12124 = z;
        return this;
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public C3485 m11399(boolean z) {
        this.f12149 = z;
        return this;
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public C3485 m11400(String str) {
        this.f12123 = str;
        return this;
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public C3485 m11401(boolean z) {
        this.f12150 = z;
        return this;
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public C3485 m11402(boolean z) {
        this.f12151 = z;
        return this;
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public C3485 m11403(float f) {
        this.f12166 = f;
        return this;
    }

    public C3485(String str, CameraCharacteristics cameraCharacteristics) {
        Integer num;
        Integer num2;
        this.f12115 = false;
        this.f12118 = true;
        this.f12142 = -1.0d;
        this.f12152 = true;
        this.f12153 = true;
        this.f12154 = true;
        this.f12155 = true;
        this.f12156 = true;
        this.f12157 = true;
        this.f12158 = true;
        this.f12159 = true;
        this.f12160 = true;
        this.f12161 = false;
        this.f12162 = true;
        this.f12163 = false;
        this.f12164 = false;
        this.f12117 = str;
        if (cameraCharacteristics == null) {
            this.f12118 = false;
            return;
        }
        f12112 = C3485.class.getSimpleName() + " id : " + this.f12117;
        Integer num3 = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
        if (num3 == null) {
            this.f12118 = false;
        } else if (num3.intValue() == 0) {
            this.f12119 = true;
        } else if (num3.intValue() == 1) {
            this.f12119 = false;
        }
        if (this.f12115) {
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = this.f12119 ? "前置" : "后置";
            String str2 = String.format("camera  id  : %s  ,  LENS_FACING id : %s ", objArr);
            StringBuilder sb = f12114;
            sb.append(str2);
            sb.append("\n");
            C4638.m14099(f12112, str2);
            if (m11396()) {
                StringBuilder sb2 = f12113;
                sb2.append(str2);
                sb2.append("\n");
            }
        }
        Integer num4 = (Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num4 != null && num4.intValue() != 2) {
            this.f12120 = num4.intValue();
        } else {
            this.f12120 = 2;
        }
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  INFO_SUPPORTED_HARDWARE_LEVEL : %s ", num4));
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            String str3 = (String) cameraCharacteristics.get(CameraCharacteristics.INFO_VERSION);
            if (this.f12115) {
                C4638.m14099(f12112, String.format("camera  INFO_VERSION : %s ", str3));
            }
        }
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        this.f12137 = iArr;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  REQUEST_AVAILABLE_CAPABILITIES : %s ", Arrays.toString(iArr)));
        }
        if (i >= 28) {
            Integer num5 = (Integer) cameraCharacteristics.get(CameraCharacteristics.LOGICAL_MULTI_CAMERA_SENSOR_SYNC_TYPE);
            if (this.f12115) {
                C4638.m14099(f12112, String.format("camera  LOGICAL_MULTI_CAMERA_SENSOR_SYNC_TYPE : %s ", num5));
            }
        }
        this.f12145 = null;
        if (i >= 28) {
            Set<String> physicalCameraIds = cameraCharacteristics.getPhysicalCameraIds();
            this.f12145 = physicalCameraIds;
            if (this.f12115) {
                C4638.m14099(f12112, String.format("camera  getPhysicalCameraIds : %s ", physicalCameraIds));
            }
            if (this.f12145.size() > 0) {
                this.f12122 = true;
            }
        }
        List availablePhysicalCameraRequestKeys = i >= 28 ? cameraCharacteristics.getAvailablePhysicalCameraRequestKeys() : null;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  getAvailablePhysicalCameraRequestKeys : %s ", availablePhysicalCameraRequestKeys));
        }
        List<CaptureRequest.Key<?>> availableCaptureRequestKeys = cameraCharacteristics.getAvailableCaptureRequestKeys();
        this.f12143 = availableCaptureRequestKeys;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  getAvailableCaptureRequestKeys : %s ", availableCaptureRequestKeys));
        }
        boolean zM11389 = m11389(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, this.f12143);
        this.f12152 = zM11389;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("isRequestAvaliable  isSupportExposure : %s ", Boolean.valueOf(zM11389)));
        }
        boolean zM9308 = C2519.m9308(this.f12120);
        boolean z = m11389(CaptureRequest.SENSOR_SENSITIVITY, this.f12143) || zM9308;
        this.f12153 = z;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("isRequestAvaliable  isSupportISO : %s ", Boolean.valueOf(z)));
        }
        boolean z2 = m11389(CaptureRequest.SENSOR_EXPOSURE_TIME, this.f12143) || zM9308;
        this.f12154 = z2;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("isRequestAvaliable  isSupportExposureTime : %s ", Boolean.valueOf(z2)));
        }
        boolean z3 = m11389(CaptureRequest.LENS_FOCUS_DISTANCE, this.f12143) && !this.f12119;
        this.f12155 = z3;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("isRequestAvaliable  isSupportFocus : %s ", Boolean.valueOf(z3)));
        }
        boolean zM113892 = m11389(CaptureRequest.SCALER_CROP_REGION, this.f12143);
        this.f12156 = zM113892;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("isRequestAvaliable  isSupportZoom : %s ", Boolean.valueOf(zM113892)));
        }
        boolean zM113893 = m11389(CaptureRequest.CONTROL_AE_LOCK, this.f12143);
        this.f12157 = zM113893;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("isRequestAvaliable  isAELockAvailable : %s ", Boolean.valueOf(zM113893)));
        }
        boolean z4 = this.f12155;
        this.f12158 = z4;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("isRequestAvaliable  isAFLockAvailable : %s ", Boolean.valueOf(z4)));
        }
        boolean zIsAvailable = AutomaticGainControl.isAvailable();
        this.f12161 = zIsAvailable;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("isRequestAvaliable  isAutoGainAvailable : %s ", Boolean.valueOf(zIsAvailable)));
        }
        boolean zM113894 = m11389(CaptureRequest.CONTROL_AF_REGIONS, this.f12143);
        this.f12160 = zM113894;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("isRequestAvaliable  isAFMeterAvailable : %s ", Boolean.valueOf(zM113894)));
        }
        boolean zM113895 = m11389(CaptureRequest.CONTROL_AE_REGIONS, this.f12143);
        this.f12159 = zM113895;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("isRequestAvaliable  isAEMeterAvailable : %s ", Boolean.valueOf(zM113895)));
        }
        this.f12162 = m11389(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, this.f12143);
        if (C2813.m10155()) {
            this.f12162 = false;
        }
        if (this.f12115) {
            C4638.m14099(f12112, String.format("isRequestAvaliable  isStabilizationAvailable : %s ", Boolean.valueOf(this.f12162)));
        }
        boolean zM113896 = m11389(CaptureRequest.NOISE_REDUCTION_MODE, this.f12143);
        this.f12163 = zM113896;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("isRequestAvaliable  isNoiseReductionAvailable : %s ", Boolean.valueOf(zM113896)));
        }
        boolean zM113897 = m11389(CaptureRequest.EDGE_MODE, this.f12143);
        this.f12164 = zM113897;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("isRequestAvaliable  isEdgeSharpeningAvailable : %s ", Boolean.valueOf(zM113897)));
        }
        Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
        this.f12130 = f;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  LENS_INFO_MINIMUM_FOCUS_DISTANCE : %s ", f));
        }
        Float f2 = this.f12130;
        if (f2 == null || f2.floatValue() == 0.0f) {
            this.f12155 = false;
        }
        Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        this.f12132 = rect;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  SENSOR_INFO_ACTIVE_ARRAY_SIZE : %s ", rect));
        }
        if (this.f12132 == null) {
            this.f12160 = false;
            this.f12159 = false;
            if (this.f12115) {
                C4638.m14099(f12112, String.format("isRequestAvaliable  isAEAFMeterAvailable : %s ", false));
            }
        }
        SizeF sizeF = (SizeF) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
        this.f12116 = sizeF;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  SENSOR_INFO_PHYSICAL_SIZE : %s ", sizeF));
        }
        Size size = (Size) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  SENSOR_INFO_PIXEL_ARRAY_SIZE : %s ", size));
        }
        Rect rect2 = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE : %s ", rect2));
        }
        Integer num6 = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
        if (num6 == null) {
            this.f12121 = -1;
        } else {
            this.f12121 = num6.intValue();
        }
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  SENSOR_ORIENTATION : %s ", num6));
        }
        float[] fArr = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_APERTURES);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  LENS_INFO_AVAILABLE_APERTURES : %s ", Arrays.toString(fArr)));
        }
        float[] fArr2 = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FILTER_DENSITIES);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  LENS_INFO_AVAILABLE_FILTER_DENSITIES : %s ", Arrays.toString(fArr2)));
        }
        float[] fArr3 = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
        this.f12136 = fArr3;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  LENS_INFO_AVAILABLE_FOCAL_LENGTHS : %s ", Arrays.toString(fArr3)));
        }
        float[] fArr4 = this.f12136;
        if (fArr4 != null && fArr4.length > 1) {
            this.f12148 = true;
        }
        int[] iArr2 = (int[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
        this.f12125 = iArr2;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION : %s ", Arrays.toString(iArr2)));
        }
        Integer num7 = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_FOCUS_DISTANCE_CALIBRATION);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  LENS_INFO_FOCUS_DISTANCE_CALIBRATION : %s ", num7));
        }
        Float f3 = (Float) cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_HYPERFOCAL_DISTANCE);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  LENS_INFO_HYPERFOCAL_DISTANCE : %s ", f3));
        }
        if (i >= 28) {
            Integer num8 = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_POSE_REFERENCE);
            if (this.f12115) {
                C4638.m14099(f12112, String.format("camera  LENS_POSE_REFERENCE : %s ", num8));
            }
        }
        float[] fArr5 = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_POSE_ROTATION);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  LENS_POSE_ROTATION : %s ", Arrays.toString(fArr5)));
        }
        float[] fArr6 = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_POSE_TRANSLATION);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  LENS_POSE_TRANSLATION : %s ", Arrays.toString(fArr6)));
        }
        float[] fArr7 = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_INTRINSIC_CALIBRATION);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  LENS_INTRINSIC_CALIBRATION : %s ", Arrays.toString(fArr7)));
        }
        if (i >= 28) {
            float[] fArr8 = (float[]) cameraCharacteristics.get(CameraCharacteristics.LENS_DISTORTION);
            if (this.f12115) {
                C4638.m14099(f12112, String.format("camera  LENS_DISTORTION : %s ", Arrays.toString(fArr8)));
            }
        }
        int[] iArr3 = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_MODES);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_AVAILABLE_MODES : %s ", Arrays.toString(iArr3)));
        }
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_LOCK_AVAILABLE);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_AE_LOCK_AVAILABLE : %s ", bool));
        }
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            this.f12157 = zBooleanValue;
            if (this.f12115) {
                C4638.m14099(f12112, String.format("isRequestAvaliable  isAELockAvailable : %s ", Boolean.valueOf(zBooleanValue)));
            }
        }
        Range<Integer>[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        this.f12126 = rangeArr;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES : %s ", Arrays.toString(rangeArr)));
        }
        int[] iArr4 = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_AE_AVAILABLE_MODES : %s ", Arrays.toString(iArr4)));
        }
        int[] iArr5 = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_ANTIBANDING_MODES);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_AE_AVAILABLE_ANTIBANDING_MODES : %s ", Arrays.toString(iArr5)));
        }
        Range<Integer> range = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        this.f12144 = range;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_AE_COMPENSATION_RANGE : %s ", range));
        }
        Rational rational = (Rational) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_AE_COMPENSATION_STEP : %s ", rational));
        }
        int[] iArr6 = (int[]) cameraCharacteristics.get(CameraCharacteristics.NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES : %s ", Arrays.toString(iArr6)));
        }
        if (this.f12163) {
            boolean zM11387 = m11387(iArr6, 1);
            this.f12163 = zM11387;
            if (this.f12115) {
                C4638.m14099(f12112, String.format("isRequestAvaliable  isNoiseReductionAvailable : %s ", Boolean.valueOf(zM11387)));
            }
        }
        Integer num9 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        this.f12134 = num9;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_MAX_REGIONS_AE : %s ", num9));
        }
        if (this.f12159 && ((num2 = this.f12134) == null || num2.intValue() == 0)) {
            this.f12159 = false;
            if (this.f12115) {
                C4638.m14099(f12112, String.format("isRequestAvaliable  isAEMeterAvailable : %s ", false));
            }
        }
        Integer num10 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_MAX_REGIONS_AWB : %s ", num10));
        }
        Boolean bool2 = (Boolean) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_LOCK_AVAILABLE);
        if (bool2 != null) {
            this.f12147 = bool2.booleanValue();
        }
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_AWB_LOCK_AVAILABLE : %s ", bool2));
        }
        int[] iArr7 = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        this.f12146 = iArr7;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_AWB_AVAILABLE_MODES : %s ", Arrays.toString(iArr7)));
        }
        int[] iArr8 = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_AF_AVAILABLE_MODES : %s ", Arrays.toString(iArr8)));
        }
        Integer num11 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        this.f12135 = num11;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_MAX_REGIONS_AF : %s ", num11));
        }
        if (this.f12160 && ((num = this.f12135) == null || num.intValue() == 0)) {
            this.f12160 = false;
            if (this.f12115) {
                C4638.m14099(f12112, String.format("isRequestAvaliable  isAFMeterAvailable : %s ", false));
            }
        }
        int[] iArr9 = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_EFFECTS);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_AVAILABLE_EFFECTS : %s ", Arrays.toString(iArr9)));
        }
        int[] iArr10 = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES : %s ", Arrays.toString(iArr10)));
        }
        Boolean bool3 = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  FLASH_INFO_AVAILABLE : %s ", bool3));
        }
        int[] iArr11 = (int[]) cameraCharacteristics.get(CameraCharacteristics.COLOR_CORRECTION_AVAILABLE_ABERRATION_MODES);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  COLOR_CORRECTION_AVAILABLE_ABERRATION_MODES : %s ", Arrays.toString(iArr11)));
        }
        int[] iArr12 = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES);
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  CONTROL_AVAILABLE_SCENE_MODES : %s ", Arrays.toString(iArr12)));
        }
        if (i >= 28) {
            int[] iArr13 = (int[]) cameraCharacteristics.get(CameraCharacteristics.DISTORTION_CORRECTION_AVAILABLE_MODES);
            if (this.f12115) {
                C4638.m14099(f12112, String.format("camera  DISTORTION_CORRECTION_AVAILABLE_MODES : %s ", Arrays.toString(iArr13)));
            }
        }
        int[] iArr14 = (int[]) cameraCharacteristics.get(CameraCharacteristics.EDGE_AVAILABLE_EDGE_MODES);
        this.f12133 = iArr14;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  EDGE_AVAILABLE_EDGE_MODES : %s ", Arrays.toString(iArr14)));
        }
        if (this.f12164) {
            boolean zM113872 = m11387(this.f12133, 1);
            this.f12164 = zM113872;
            if (this.f12115) {
                C4638.m14099(f12112, String.format("isRequestAvaliable  isEdgeSharpeningAvailable : %s ", Boolean.valueOf(zM113872)));
            }
        }
        Float f4 = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        this.f12131 = f4;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  SCALER_AVAILABLE_MAX_DIGITAL_ZOOM : %s ", f4));
        }
        Range<Long> range2 = (Range) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE);
        this.f12127 = range2;
        if (this.f12115) {
            String str4 = String.format("camera  SENSOR_INFO_EXPOSURE_TIME_RANGE Nanoseconds: %s ", range2);
            C4638.m14099(f12112, str4);
            if (m11396()) {
                StringBuilder sb3 = f12113;
                sb3.append(str4);
                sb3.append("\n");
            }
        }
        Range<Integer> range3 = (Range) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE);
        this.f12128 = range3;
        if (this.f12115) {
            String str5 = String.format("camera  SENSOR_INFO_SENSITIVITY_RANGE : %s ", range3);
            C4638.m14099(f12112, str5);
            if (m11396()) {
                StringBuilder sb4 = f12113;
                sb4.append(str5);
                sb4.append("\n");
            }
        }
        if (i >= 28) {
            int[] iArr15 = (int[]) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_AVAILABLE_OIS_DATA_MODES);
            this.f12129 = iArr15;
            if (this.f12115) {
                C4638.m14099(f12112, String.format("camera  STATISTICS_INFO_AVAILABLE_OIS_DATA_MODES : %s ", Arrays.toString(iArr15)));
            }
        }
        Integer num12 = (Integer) cameraCharacteristics.get(CameraCharacteristics.TONEMAP_MAX_CURVE_POINTS);
        this.f12138 = num12;
        if (this.f12115) {
            C4638.m14099(f12112, String.format("camera  TONEMAP_MAX_CURVE_POINTS : %s ", num12));
        }
        m11397();
        m11350(cameraCharacteristics);
    }
}
