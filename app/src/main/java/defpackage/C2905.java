package defpackage;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import defpackage.C5220;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: FilmAudioEncoder.java */
/* renamed from: ь, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2905 implements C5220.InterfaceC5223 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C5220 f10581;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public WeakReference<q5> f10582;

    /* renamed from: ԩ, reason: contains not printable characters */
    public C5220.C5226 f10583;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public HandlerThread f10584;

    /* renamed from: ԫ, reason: contains not printable characters */
    public Handler f10585;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f10586;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f10588;

    /* renamed from: ԯ, reason: contains not printable characters */
    public MediaCodec f10589;

    /* renamed from: ՠ, reason: contains not printable characters */
    public MediaFormat f10590;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f10591;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f10592;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f10593;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f10594;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f10595;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f10596;

    /* renamed from: ރ, reason: contains not printable characters */
    public long f10598;

    /* renamed from: ބ, reason: contains not printable characters */
    public long f10599;

    /* renamed from: ޅ, reason: contains not printable characters */
    public long f10600;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Object f10587 = new Object();

    /* renamed from: ނ, reason: contains not printable characters */
    public int f10597 = 0;

    /* renamed from: ކ, reason: contains not printable characters */
    public boolean f10601 = false;

    /* compiled from: FilmAudioEncoder.java */
    /* renamed from: ь$Ϳ, reason: contains not printable characters */
    public class RunnableC2906 implements Runnable {
        public RunnableC2906() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2905.this.m10303();
            try {
                C2905.this.m10305();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: FilmAudioEncoder.java */
    /* renamed from: ь$Ԩ, reason: contains not printable characters */
    public class RunnableC2907 implements Runnable {
        public RunnableC2907() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2905.this.f10589.start();
            C2905.this.f10588 = true;
            C2905.this.m10301();
        }
    }

    /* compiled from: FilmAudioEncoder.java */
    /* renamed from: ь$Ԫ, reason: contains not printable characters */
    public class RunnableC2908 implements Runnable {
        public RunnableC2908() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C2905.this.f10588) {
                C2905.this.f10601 = true;
            } else {
                C2905.this.m10306();
            }
        }
    }

    /* compiled from: FilmAudioEncoder.java */
    /* renamed from: ь$Ԭ, reason: contains not printable characters */
    public class RunnableC2909 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ byte[] f10605;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ int f10606;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ long f10607;

        public RunnableC2909(byte[] bArr, int i, long j) {
            this.f10605 = bArr;
            this.f10606 = i;
            this.f10607 = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2905 c2905 = C2905.this;
            c2905.m10302(this.f10605, this.f10606, this.f10607, c2905.f10601);
        }
    }

    public C2905(C5220 c5220, q5 q5Var) {
        this.f10581 = c5220;
        this.f10582 = new WeakReference<>(q5Var);
    }

    @Override // defpackage.C5220.InterfaceC5223
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo10300(byte[] bArr, int i, long j) {
        if (this.f10588) {
            this.f10585.post(new RunnableC2909(bArr, i, j));
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m10301() {
        this.f10581.m15236(this);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m10302(byte[] bArr, int i, long j, boolean z) {
        int i2;
        long j2 = 0;
        long j3 = 1000;
        if (this.f10597 == 0) {
            this.f10598 = C4621.m14077(j) / 1000;
            this.f10599 = (((i * 1000000) / this.f10592) / 2) / 2;
            this.f10600 = 0L;
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            if ((bArr == null || i3 >= i) && (!z || z2)) {
                break;
            }
            try {
                int iDequeueInputBuffer = this.f10589.dequeueInputBuffer(10000L);
                if (iDequeueInputBuffer >= 0) {
                    ByteBuffer inputBuffer = this.f10589.getInputBuffer(iDequeueInputBuffer);
                    if (inputBuffer != null) {
                        if (bArr != null) {
                            int iMin = Math.min(inputBuffer.limit(), i - i3);
                            inputBuffer.put(bArr, i3, iMin);
                            i2 = iMin;
                        } else {
                            i2 = 0;
                        }
                        i3 += i2;
                        this.f10589.queueInputBuffer(iDequeueInputBuffer, 0, i2, C4621.m14077(j) / j3, (z && (bArr == null || i3 == i)) ? 4 : 0);
                        this.f10596 = true;
                    }
                }
                if (this.f10596) {
                    while (true) {
                        int iDequeueOutputBuffer = this.f10589.dequeueOutputBuffer(bufferInfo, j2);
                        if (iDequeueOutputBuffer == -2) {
                            MediaFormat outputFormat = this.f10589.getOutputFormat();
                            q5 q5Var = this.f10582.get();
                            if (q5Var != null) {
                                q5Var.m8029(1, outputFormat);
                            }
                        }
                        if (iDequeueOutputBuffer < 0) {
                            break;
                        }
                        if ((bufferInfo.flags & 2) != 0) {
                            bufferInfo.size = 0;
                        }
                        ByteBuffer outputBuffer = this.f10589.getOutputBuffer(iDequeueOutputBuffer);
                        q5 q5Var2 = this.f10582.get();
                        long j4 = bufferInfo.presentationTimeUs;
                        long j5 = this.f10600;
                        if (j4 < j5) {
                            bufferInfo.presentationTimeUs = j5 + 10000;
                        }
                        this.f10600 = bufferInfo.presentationTimeUs;
                        if (bufferInfo.size != 0 && q5Var2 != null && q5Var2.m8047()) {
                            q5Var2.m8066(new o5(1, outputBuffer, bufferInfo));
                        }
                        if ((bufferInfo.flags & 4) != 0) {
                            z2 = true;
                        }
                        this.f10589.releaseOutputBuffer(iDequeueOutputBuffer, false);
                        j2 = 0;
                        j3 = 1000;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (z2) {
            q5 q5Var3 = this.f10582.get();
            if (q5Var3 != null) {
                q5Var3.m8062(1);
            }
            m10306();
        }
        this.f10597++;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m10303() {
        MediaCodecInfo mediaCodecInfoM10307 = m10307("audio/mp4a-latm");
        if (mediaCodecInfoM10307 == null) {
            C4638.m14101("FilmAudioEncoder", "Unable to find an appropriate codec for audio/mp4a-latm");
            return;
        }
        C4638.m14099("FilmAudioEncoder", "selected codec: " + mediaCodecInfoM10307.getName());
        Iterator<MediaCodecInfo> it = C5000.m14787("audio/mp4a-latm").iterator();
        while (it.hasNext()) {
            C4638.m14099("FilmAudioEncoder", String.format("audio support MediaCodecInfo , name : %s ", it.next().getName()));
        }
        this.f10591 = AudioRecord.getMinBufferSize(this.f10592, this.f10593, this.f10594);
        C4638.m14099("FilmAudioEncoder", "mBufferSize: " + this.f10591);
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", this.f10592, 2);
        this.f10590 = mediaFormatCreateAudioFormat;
        mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
        this.f10590.setInteger("bitrate", this.f10595);
        this.f10590.setInteger("max-input-size", this.f10591);
        C4638.m14099("FilmAudioEncoder", String.format("mSampleRateHz : %s , CHANNEL_COUNT : %s , mBitRate : %s , mBufferSize : %s ", Integer.valueOf(this.f10592), 2, Integer.valueOf(this.f10595), Integer.valueOf(this.f10591)));
        C4638.m14099("FilmAudioEncoder", "format: " + this.f10590);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m10304(C5220.C5226 c5226) {
        if (this.f10586) {
            synchronized (this.f10587) {
                try {
                    this.f10587.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        this.f10588 = false;
        this.f10583 = c5226;
        this.f10592 = c5226.f17325;
        this.f10595 = c5226.f17326;
        this.f10593 = 12;
        this.f10594 = 2;
        this.f10597 = 0;
        synchronized (this.f10587) {
            HandlerThread handlerThread = new HandlerThread("FilmAudioEncoder");
            this.f10584 = handlerThread;
            handlerThread.setPriority(3);
            this.f10584.start();
            Handler handler = new Handler(this.f10584.getLooper());
            this.f10585 = handler;
            handler.post(new RunnableC2906());
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m10305() throws IOException {
        if (this.f10589 != null) {
            return;
        }
        MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
        this.f10589 = mediaCodecCreateEncoderByType;
        mediaCodecCreateEncoderByType.configure(this.f10590, (Surface) null, (MediaCrypto) null, 1);
        C4638.m14099("FilmAudioEncoder", String.format("prepareMediaCodec finishing , codecInfo : %s ", this.f10589.getCodecInfo().getName()));
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m10306() {
        this.f10588 = false;
        this.f10581.m15236(null);
        MediaCodec mediaCodec = this.f10589;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.f10589 = null;
        }
        synchronized (this.f10587) {
            this.f10585.removeCallbacksAndMessages(null);
            HandlerThread handlerThread = this.f10584;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.f10584 = null;
            this.f10585 = null;
            this.f10586 = false;
            this.f10587.notify();
        }
        C4638.m14099("FilmAudioEncoder", String.format("FilmAudioEncoder release : %s ", "success"));
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final MediaCodecInfo m10307(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        C4638.m14099("FilmAudioEncoder", "selectAudioCodec。。。" + codecCount);
        MediaCodecInfo mediaCodecInfo = null;
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                int i2 = 0;
                while (true) {
                    if (i2 < supportedTypes.length) {
                        C4638.m14099("FilmAudioEncoder", "supportedType:" + codecInfoAt.getName() + ",MIME=" + supportedTypes[i2]);
                        if (supportedTypes[i2].equalsIgnoreCase(str) && mediaCodecInfo == null) {
                            mediaCodecInfo = codecInfoAt;
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        return mediaCodecInfo;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m10308() {
        this.f10585.post(new RunnableC2907());
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m10309() {
        C4638.m14099("FilmAudioEncoder", String.format("audio encoder stop  handler : %s , audioEncodeEnabled : %s ,  ", this.f10585, Boolean.valueOf(this.f10588)));
        this.f10586 = true;
        Handler handler = this.f10585;
        if (handler != null) {
            handler.post(new RunnableC2908());
        } else {
            this.f10586 = false;
        }
    }
}
