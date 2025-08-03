package defpackage;

import android.content.Context;
import android.util.Log;
import com.blink.academy.filter.core.TextureFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.cyberagent.android.gpuimage.Rotation;
import org.jcodec.codecs.mpeg12.MPEGConst;

/* compiled from: DouYinSDKManager.java */
/* renamed from: ǹ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2500 {

    /* renamed from: ރ, reason: contains not printable characters */
    public static final Map<Integer, Float> f9254;

    /* renamed from: ބ, reason: contains not printable characters */
    public static final String f9255;

    /* renamed from: ޅ, reason: contains not printable characters */
    public static boolean f9256;

    /* renamed from: ކ, reason: contains not printable characters */
    public static boolean f9257;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Context f9258;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f9260;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f9261;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f9262;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f9263;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public p2 f9265;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C5184 f9266;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f9268;

    /* renamed from: ֏, reason: contains not printable characters */
    public float f9269;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f9270;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f9271;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f9272;

    /* renamed from: ށ, reason: contains not printable characters */
    public float f9273;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f9274;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public volatile boolean f9259 = false;

    /* renamed from: ՠ, reason: contains not printable characters */
    public String[] f9267 = new String[0];

    /* renamed from: ԭ, reason: contains not printable characters */
    public C5243 f9264 = new C5243();

    /* compiled from: DouYinSDKManager.java */
    /* renamed from: ǹ$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C2501 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f9275;

        static {
            int[] iArr = new int[Rotation.values().length];
            f9275 = iArr;
            try {
                iArr[Rotation.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9275[Rotation.ROTATION_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9275[Rotation.ROTATION_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9275[Rotation.ROTATION_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        HashMap map = new HashMap();
        map.put(65792, Float.valueOf(0.6f));
        map.put(66048, Float.valueOf(0.3f));
        map.put(66304, Float.valueOf(0.7f));
        Float fValueOf = Float.valueOf(0.0f);
        map.put(135424, fValueOf);
        map.put(135680, fValueOf);
        map.put(135936, fValueOf);
        map.put(136192, fValueOf);
        map.put(131328, Float.valueOf(0.5f));
        map.put(131840, fValueOf);
        f9254 = Collections.unmodifiableMap(map);
        f9255 = C2500.class.getSimpleName();
        f9256 = false;
        f9257 = false;
    }

    public C2500(Context context) {
        this.f9258 = context;
        C4402 c4402 = new C4402();
        this.f9265 = c4402;
        c4402.m7889(f9256);
        this.f9266 = new C5184();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m9212() {
        if (f9256) {
            C4638.m14099(f9255, "destroyEffectSDK");
        }
        this.f9264.m15264();
        this.f9266.m15149();
        this.f9259 = false;
        if (f9256) {
            C4638.m14099(f9255, "destroyEffectSDK finish");
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int m9213(Rotation rotation) {
        int i = C2501.f9275[rotation.ordinal()];
        if (i != 2) {
            return i != 3 ? i != 4 ? 0 : 270 : MPEGConst.SEQUENCE_ERROR_CODE;
        }
        return 90;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean m9214() {
        if (this.f9259) {
            return true;
        }
        C4919 c4919 = InterfaceC3224.f11362;
        c4919.m14646(1.0f);
        C4919 c49192 = InterfaceC3224.f11363;
        c49192.m14646(0.5f);
        C4919 c49193 = InterfaceC3224.f11364;
        c49193.m14646(0.5f);
        C4919 c49194 = InterfaceC3224.f11365;
        c49194.m14646(0.5f);
        C4919 c49195 = InterfaceC3224.f11366;
        c49195.m14646(1.0f);
        m9220(c4919, true);
        m9220(c49192, true);
        m9220(c49193, true);
        m9220(c49194, true);
        m9220(c49195, true);
        this.f9259 = true;
        f9257 = true;
        return true;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m9215(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.f9262 = i;
        this.f9263 = i2;
        this.f9264.m15265(i, i2);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public int m9216(int i, TextureFormat textureFormat, int i2, int i3, int i4, boolean z, Rotation rotation, long j) {
        int i5;
        int i6;
        if (i2 == 0 || i3 == 0) {
            return i;
        }
        long jNanoTime = System.nanoTime();
        int iM9213 = m9213(rotation);
        int i7 = z ? ((i4 - iM9213) + 360) % 360 : (i4 + iM9213) % 360;
        if (rotation == Rotation.ROTATION_270) {
            if (z) {
                i7 += 90;
                int i8 = this.f9274 + 90;
                this.f9274 = i8;
                this.f9274 = i8 % 360;
            } else {
                i7 += 90;
                int i9 = this.f9274 - 90;
                this.f9274 = i9;
                this.f9274 = (i9 + 360) % 360;
            }
        }
        int i10 = i7;
        if (i10 % MPEGConst.SEQUENCE_ERROR_CODE == 90) {
            i6 = i2;
            i5 = i3;
        } else {
            i5 = i2;
            i6 = i3;
        }
        int i11 = -i10;
        int iM15263 = this.f9264.m15263(i, textureFormat, i5, i6, i11, z, false);
        long jNanoTime2 = System.nanoTime();
        long jNanoTime3 = System.nanoTime();
        this.f9260 = i5;
        this.f9261 = i6;
        long jNanoTime4 = System.nanoTime();
        this.f9265.m7886("effectProcess");
        this.f9266.m15155(this.f9268);
        this.f9266.m15154(this.f9269);
        this.f9266.m15152(this.f9270);
        this.f9266.m15151(this.f9271);
        this.f9266.m15153(this.f9272);
        this.f9266.m15156(this.f9273);
        C5184 c5184 = this.f9266;
        TextureFormat textureFormat2 = TextureFormat.f5094;
        int iM15150 = c5184.m15150(iM15263, textureFormat2, i5, i6, 0, false, 0, 0L, this.f9274);
        this.f9265.m7890("effectProcess");
        long jNanoTime5 = System.nanoTime();
        int iM152632 = this.f9264.m15263(iM15150, textureFormat2, i2, i3, z ? i10 : i11, z, false);
        long jNanoTime6 = System.nanoTime();
        if (f9256) {
            C4638.m14099(f9255, String.format("sum : %s , 1 : %s , smooth : %s , prepare dst : %s , process : %s , draw offScreen : %s ", Long.valueOf((jNanoTime6 - jNanoTime) / 1000000), Long.valueOf((jNanoTime2 - jNanoTime) / 1000000), Long.valueOf((jNanoTime3 - jNanoTime2) / 1000000), Long.valueOf((jNanoTime4 - jNanoTime3) / 1000000), Long.valueOf((jNanoTime5 - jNanoTime4) / 1000000), Long.valueOf((jNanoTime6 - jNanoTime5) / 1000000)));
        }
        return iM152632;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m9217(boolean z) {
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public C2500 m9218(int i) {
        this.f9274 = i;
        return this;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m9219(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f9268 = f;
        this.f9269 = (float) (Math.sqrt(f2) * 1.5d * 2.0d);
        this.f9270 = f3 * 2.0f;
        this.f9271 = f4;
        this.f9272 = f5;
        this.f9273 = f6;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean m9220(C4919 c4919, boolean z) {
        Log.d("BaseEffectHelper", String.format("path : %s , key : %s , value : %s ", C4450.m13711(this.f9258) + c4919.m14644(), c4919.m14643(), Float.valueOf(c4919.m14645())));
        return false;
    }
}
