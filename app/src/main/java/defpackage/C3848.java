package defpackage;

import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.view.Surface;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.util.GmsVersion;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import net.sourceforge.jaad.aac.syntax.SyntaxConstants;

/* compiled from: FilmVideoEncoder.java */
/* renamed from: ߜ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3848 {

    /* renamed from: ފ, reason: contains not printable characters */
    public static int f13222 = 30;

    /* renamed from: ދ, reason: contains not printable characters */
    public static int f13223 = 30;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public HandlerThread f13224;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Handler f13225;

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean f13226;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public a2 f13227;

    /* renamed from: ֏, reason: contains not printable characters */
    public WeakReference<q5> f13235;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f13236;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f13237;

    /* renamed from: ހ, reason: contains not printable characters */
    public double f13238;

    /* renamed from: ށ, reason: contains not printable characters */
    public double f13239;

    /* renamed from: ނ, reason: contains not printable characters */
    public double f13240;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f13241;

    /* renamed from: ބ, reason: contains not printable characters */
    public MediaCodec f13242;

    /* renamed from: ޅ, reason: contains not printable characters */
    public Surface f13243;

    /* renamed from: އ, reason: contains not printable characters */
    public boolean f13245;

    /* renamed from: މ, reason: contains not printable characters */
    public boolean f13247;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Object f13228 = new Object();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f13229 = false;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f13230 = 0;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f13231 = SyntaxConstants.WINDOW_SMALL_LEN_LONG;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f13232 = 720;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f13233 = -1;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f13234 = -1;

    /* renamed from: ކ, reason: contains not printable characters */
    public boolean f13244 = false;

    /* renamed from: ވ, reason: contains not printable characters */
    public final Object f13246 = new Object();

    /* compiled from: FilmVideoEncoder.java */
    /* renamed from: ߜ$Ϳ, reason: contains not printable characters */
    public class RunnableC3849 implements Runnable {
        public RunnableC3849() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* compiled from: FilmVideoEncoder.java */
    /* renamed from: ߜ$Ԩ, reason: contains not printable characters */
    public class RunnableC3850 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f13249;

        public RunnableC3850(Runnable runnable) {
            this.f13249 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3848.this.f13242.start();
            C3848.this.f13244 = true;
            Runnable runnable = this.f13249;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* compiled from: FilmVideoEncoder.java */
    /* renamed from: ߜ$Ԫ, reason: contains not printable characters */
    public class RunnableC3851 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f13251;

        public RunnableC3851(Runnable runnable) {
            this.f13251 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C3848 c3848 = C3848.this;
                c3848.m12272(c3848.f13227, this.f13251);
            } catch (Exception e2) {
                e2.printStackTrace();
                C3848.this.f13244 = false;
                q5 q5Var = (q5) C3848.this.f13235.get();
                if (q5Var != null) {
                    q5Var.m8037();
                }
            }
        }
    }

    /* compiled from: FilmVideoEncoder.java */
    /* renamed from: ߜ$Ԭ, reason: contains not printable characters */
    public class RunnableC3852 implements Runnable {
        public RunnableC3852() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C3848.this.f13244) {
                return;
            }
            C3848.this.m12282();
        }
    }

    /* compiled from: FilmVideoEncoder.java */
    /* renamed from: ߜ$Ԯ, reason: contains not printable characters */
    public class RunnableC3853 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f13254;

        public RunnableC3853(boolean z) {
            this.f13254 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C3848.this.m12273(this.f13254);
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                C3848.this.f13244 = false;
                q5 q5Var = (q5) C3848.this.f13235.get();
                if (q5Var != null) {
                    q5Var.m8037();
                }
            }
        }
    }

    public C3848(a2 a2Var, q5 q5Var, boolean z) {
        this.f13235 = new WeakReference<>(q5Var);
        m12280(a2Var, z);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m12271() {
        synchronized (this.f13246) {
            this.f13247 = true;
            C4638.m14101("FilmVideoEncoder", Thread.currentThread().getId() + " video -- callMuxStarted...");
            this.f13246.notifyAll();
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m12272(a2 a2Var, Runnable runnable) throws IOException {
        Range<Integer> bitrateRange;
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(a2Var.f6, this.f13233, this.f13234);
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        int iIntValue = a2Var.f2;
        mediaFormatCreateVideoFormat.setInteger("bitrate", iIntValue);
        mediaFormatCreateVideoFormat.setInteger("frame-rate", f13223);
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", 1);
        mediaFormatCreateVideoFormat.setInteger("max-width", this.f13233);
        mediaFormatCreateVideoFormat.setInteger("max-height", this.f13234);
        mediaFormatCreateVideoFormat.setFloat("capture-rate", f13223);
        if (Build.VERSION.SDK_INT >= 24) {
            mediaFormatCreateVideoFormat.setInteger("color-range", 2);
            mediaFormatCreateVideoFormat.setInteger("color-standard", 1);
        }
        this.f13236 = iIntValue;
        this.f13237 = f13223;
        this.f13239 = iIntValue / 8.0d;
        this.f13238 = 0.0d;
        this.f13240 = 0.0d;
        this.f13241 = 0;
        mediaFormatCreateVideoFormat.setInteger("priority", 0);
        for (MediaCodecInfo mediaCodecInfo : C5000.m14787(a2Var.f6)) {
        }
        MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(a2Var.f6);
        this.f13242 = mediaCodecCreateEncoderByType;
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecCreateEncoderByType.getCodecInfo().getCapabilitiesForType(a2Var.f6);
        MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
        if (videoCapabilities != null && (bitrateRange = videoCapabilities.getBitrateRange()) != null && iIntValue > ((Integer) bitrateRange.getUpper()).intValue()) {
            iIntValue = ((Integer) bitrateRange.getUpper()).intValue();
            mediaFormatCreateVideoFormat.setInteger("bitrate", iIntValue);
            this.f13236 = iIntValue;
            this.f13237 = f13223;
            this.f13239 = iIntValue / 8.0d;
            this.f13238 = 0.0d;
            this.f13240 = 0.0d;
            this.f13241 = 0;
        }
        MediaCodecInfo.EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
        if (Build.VERSION.SDK_INT >= 28) {
            encoderCapabilities.getQualityRange();
        }
        encoderCapabilities.getComplexityRange();
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
        HashMap map = new HashMap();
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            int i = codecProfileLevel.level;
            int i2 = codecProfileLevel.profile;
            Integer num = (Integer) map.get(Integer.valueOf(i2));
            if (num == null) {
                map.put(Integer.valueOf(i2), Integer.valueOf(i));
            } else {
                map.put(Integer.valueOf(i2), Integer.valueOf(Math.max(num.intValue(), i)));
            }
        }
        String str = Build.MODEL;
        if (!"Galaxy A31".equalsIgnoreCase(str) && !"SM-A315F".equalsIgnoreCase(str) && !"SM-A315G/LF".equalsIgnoreCase(str) && !"SM-A315G".equalsIgnoreCase(str) && !"SM-A315N".equalsIgnoreCase(str)) {
            if ("video/avc".equals(a2Var.f6)) {
                Integer num2 = (Integer) map.get(8);
                if (num2 != null) {
                    mediaFormatCreateVideoFormat.setInteger(Scopes.PROFILE, 8);
                    mediaFormatCreateVideoFormat.setInteger("level", num2.intValue());
                    new C2732(a2Var.f6, 8, num2.intValue()).m9985();
                }
            } else {
                Integer num3 = (Integer) map.get(1);
                if (num3 != null) {
                    mediaFormatCreateVideoFormat.setInteger(Scopes.PROFILE, 1);
                    mediaFormatCreateVideoFormat.setInteger("level", num3.intValue());
                    new C2732(a2Var.f6, 1, num3.intValue()).m9985();
                }
            }
        }
        try {
            this.f13242.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        } catch (Exception unused) {
            int i3 = this.f13234;
            int iM12277 = i3 > 1080 ? m12277() : i3 > 720 ? m12276() : m12278();
            if (iIntValue <= iM12277) {
                iM12277 = iIntValue;
            }
            mediaFormatCreateVideoFormat.setInteger("bitrate", iM12277);
            this.f13236 = iIntValue;
            this.f13237 = f13223;
            this.f13239 = iIntValue / 8.0d;
            this.f13238 = 0.0d;
            this.f13240 = 0.0d;
            this.f13241 = 0;
            this.f13242.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        }
        this.f13242.getCodecInfo();
        this.f13243 = this.f13242.createInputSurface();
        runnable.run();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final boolean m12273(boolean z) {
        MediaCodec mediaCodec = this.f13242;
        if (mediaCodec == null || !this.f13244) {
            return false;
        }
        if (z) {
            mediaCodec.signalEndOfInputStream();
        }
        q5 q5Var = this.f13235.get();
        if (q5Var == null) {
            return false;
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        while (true) {
            int iDequeueOutputBuffer = this.f13242.dequeueOutputBuffer(bufferInfo, 10000L);
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", this.f13227.f2);
            this.f13242.setParameters(bundle);
            if (iDequeueOutputBuffer == -1) {
                if (!z) {
                    return false;
                }
            } else if (iDequeueOutputBuffer == -3) {
                continue;
            } else if (iDequeueOutputBuffer == -2) {
                MediaFormat outputFormat = this.f13242.getOutputFormat();
                q5 q5Var2 = this.f13235.get();
                if (q5Var2 != null) {
                    q5Var2.m8029(0, outputFormat);
                }
                synchronized (this.f13246) {
                    try {
                        if (!this.f13247) {
                            this.f13246.wait();
                        }
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (iDequeueOutputBuffer >= 0) {
                ByteBuffer outputBuffer = this.f13242.getOutputBuffer(iDequeueOutputBuffer);
                if (outputBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + iDequeueOutputBuffer + " was null");
                }
                if ((bufferInfo.flags & 2) != 0) {
                    bufferInfo.size = 0;
                }
                boolean zM8047 = q5Var.m8047();
                if (bufferInfo.size != 0 && zM8047) {
                    this.f13230++;
                    outputBuffer.toString();
                    outputBuffer.position(bufferInfo.offset);
                    outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                    m12283(bufferInfo.size);
                    System.nanoTime();
                    q5Var.m8066(new o5(0, outputBuffer, bufferInfo));
                }
                this.f13242.releaseOutputBuffer(iDequeueOutputBuffer, false);
                if ((bufferInfo.flags & 4) != 0) {
                    q5Var.m8062(0);
                    m12282();
                    return true;
                }
            } else {
                continue;
            }
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final double m12274(int i) {
        return Math.pow(4.0d, i / 20.0d);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public Surface m12275() {
        return this.f13243;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final int m12276() {
        try {
            return CamcorderProfile.get(2004).videoBitRate;
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                return CamcorderProfile.get(6).videoBitRate;
            } catch (Exception e3) {
                e3.printStackTrace();
                return GmsVersion.VERSION_MANCHEGO;
            }
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final int m12277() {
        try {
            return CamcorderProfile.get(2005).videoBitRate;
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                return CamcorderProfile.get(8).videoBitRate;
            } catch (Exception e3) {
                e3.printStackTrace();
                return GmsVersion.VERSION_MANCHEGO;
            }
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final int m12278() {
        try {
            return CamcorderProfile.get(2003).videoBitRate;
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                return CamcorderProfile.get(5).videoBitRate;
            } catch (Exception e3) {
                e3.printStackTrace();
                return GmsVersion.VERSION_MANCHEGO;
            }
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m12279(boolean z) {
        Handler handler = this.f13225;
        if (handler == null) {
            return;
        }
        handler.post(new RunnableC3853(z));
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m12280(a2 a2Var, boolean z) {
        if (this.f13245) {
            synchronized (this.f13228) {
                try {
                    this.f13228.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        this.f13226 = z;
        this.f13227 = a2Var;
        this.f13229 = false;
        this.f13230 = 0;
        f13222 = a2Var.f4;
        int i = a2Var.f5;
        f13223 = i;
        if (i == 6) {
            f13223 = 24;
        }
        int i2 = a2Var.f0;
        this.f13231 = i2;
        int i3 = a2Var.f1;
        this.f13232 = i3;
        if (a2Var.f13) {
            this.f13231 = i3;
            this.f13232 = i2;
        }
        this.f13233 = this.f13231;
        this.f13234 = this.f13232;
        synchronized (this.f13228) {
            HandlerThread handlerThread = new HandlerThread("FilmVideoEncoder");
            this.f13224 = handlerThread;
            handlerThread.setPriority(4);
            this.f13224.start();
            Handler handler = new Handler(this.f13224.getLooper());
            this.f13225 = handler;
            handler.post(new RunnableC3849());
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m12281(Runnable runnable) {
        this.f13225.post(new RunnableC3851(runnable));
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m12282() {
        MediaCodec mediaCodec = this.f13242;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f13242.release();
            this.f13242 = null;
        }
        synchronized (this.f13228) {
            HandlerThread handlerThread = this.f13224;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.f13224 = null;
            this.f13225 = null;
            this.f13244 = false;
            this.f13245 = false;
            this.f13228.notify();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0090  */
    /* renamed from: ކ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m12283(int r12) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C3848.m12283(int):void");
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final boolean m12284(int i, int i2) {
        int i3 = i * 1000;
        this.f13236 = i3;
        this.f13237 = i2;
        int i4 = (i3 * i2) / i2;
        C4638.m14107("FilmVideoEncoder", "setRates: " + i + " -> " + (i4 / 1000) + " kbps. Fps: " + this.f13237);
        StringBuilder sb = new StringBuilder();
        sb.append("setRates: ");
        sb.append(i);
        sb.append(" kbps. codecBitrateBps: ");
        sb.append(i4);
        C4638.m14107("FilmVideoEncoder", sb.toString());
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", i4);
            this.f13242.setParameters(bundle);
            return true;
        } catch (IllegalStateException e2) {
            C4638.m14102("FilmVideoEncoder", "setRates failed", e2);
            return false;
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m12285(Runnable runnable) {
        this.f13225.post(new RunnableC3850(runnable));
    }

    /* renamed from: މ, reason: contains not printable characters */
    public void m12286() {
        this.f13245 = true;
        Handler handler = this.f13225;
        if (handler != null) {
            handler.post(new RunnableC3852());
        } else {
            this.f13245 = false;
        }
    }
}
