package defpackage;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import com.blink.academy.film.bean.socket.DecoderParamsBean;
import com.blink.academy.film.support.stream.ts.EsPacket;
import com.blink.academy.film.videotools.C0851;
import defpackage.C2793;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: PreviewDecoder.java */
/* renamed from: ଆ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4382 implements C2793.InterfaceC2794 {

    /* renamed from: ވ, reason: contains not printable characters */
    public static final String f15065 = "ଆ";

    /* renamed from: މ, reason: contains not printable characters */
    public static boolean f15066 = false;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public MediaCodec f15070;

    /* renamed from: ԫ, reason: contains not printable characters */
    public HandlerThread f15071;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Handler f15072;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public e f15074;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C2793 f15075;

    /* renamed from: ֏, reason: contains not printable characters */
    public InterfaceC4387 f15078;

    /* renamed from: ׯ, reason: contains not printable characters */
    public DecoderParamsBean f15079;

    /* renamed from: ؠ, reason: contains not printable characters */
    public C0851.C0853 f15080;

    /* renamed from: ނ, reason: contains not printable characters */
    public boolean f15083;

    /* renamed from: ރ, reason: contains not printable characters */
    public long f15084;

    /* renamed from: ކ, reason: contains not printable characters */
    public boolean f15087;

    /* renamed from: އ, reason: contains not printable characters */
    public long f15088;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f15067 = -1;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f15068 = -1;

    /* renamed from: ԩ, reason: contains not printable characters */
    public MediaCodec.BufferInfo f15069 = new MediaCodec.BufferInfo();

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Object f15073 = new Object();

    /* renamed from: ՠ, reason: contains not printable characters */
    public Object f15076 = new Object();

    /* renamed from: ֈ, reason: contains not printable characters */
    public BlockingQueue<C0851.C0852> f15077 = new LinkedBlockingQueue();

    /* renamed from: ހ, reason: contains not printable characters */
    public Object f15081 = new Object();

    /* renamed from: ށ, reason: contains not printable characters */
    public MediaCodec.BufferInfo f15082 = new MediaCodec.BufferInfo();

    /* renamed from: ބ, reason: contains not printable characters */
    public int f15085 = 0;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f15086 = 0;

    /* compiled from: PreviewDecoder.java */
    /* renamed from: ଆ$Ϳ, reason: contains not printable characters */
    public class C4383 implements Handler.Callback {
        public C4383() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) throws MediaCodec.CryptoException {
            if (message.what != 10003) {
                return true;
            }
            C4382.this.m13578();
            return true;
        }
    }

    /* compiled from: PreviewDecoder.java */
    /* renamed from: ଆ$Ԩ, reason: contains not printable characters */
    public class RunnableC4384 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ DecoderParamsBean f15090;

        public RunnableC4384(DecoderParamsBean decoderParamsBean) {
            this.f15090 = decoderParamsBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C4382.this.m13576();
                C4382.this.m13564(this.f15090);
            } catch (IOException e2) {
                e2.printStackTrace();
                if (C4382.this.f15078 != null) {
                    C4382.this.f15078.onFail();
                }
            }
        }
    }

    /* compiled from: PreviewDecoder.java */
    /* renamed from: ଆ$Ԫ, reason: contains not printable characters */
    public class RunnableC4385 implements Runnable {
        public RunnableC4385() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4382.this.f15083 = true;
            C4382.this.f15087 = false;
            C4382.this.m13565();
        }
    }

    /* compiled from: PreviewDecoder.java */
    /* renamed from: ଆ$Ԭ, reason: contains not printable characters */
    public class RunnableC4386 implements Runnable {
        public RunnableC4386() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4382.this.m13566();
        }
    }

    /* compiled from: PreviewDecoder.java */
    /* renamed from: ଆ$Ԯ, reason: contains not printable characters */
    public interface InterfaceC4387 {
        void onFail();
    }

    public C4382(e eVar, InterfaceC4387 interfaceC4387) {
        this.f15074 = eVar;
        this.f15078 = interfaceC4387;
    }

    @Override // defpackage.C2793.InterfaceC2794
    /* renamed from: Ϳ */
    public void mo10104(C0851.C0853 c0853) {
        this.f15080 = c0853;
    }

    @Override // defpackage.C2793.InterfaceC2794
    /* renamed from: Ԩ */
    public void mo10105(C0851.C0852 c0852) {
        this.f15077.offer(c0852);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = c0852.f1880 / 1000;
        long j2 = (this.f15088 + j) - jCurrentTimeMillis;
        if (j2 < -200 || j2 > 200) {
            this.f15088 = jCurrentTimeMillis - j;
        }
    }

    @Override // defpackage.C2793.InterfaceC2794
    /* renamed from: ԩ */
    public void mo10106(C0851.C0852 c0852) {
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m13564(DecoderParamsBean decoderParamsBean) throws IOException {
        this.f15070 = MediaCodec.createDecoderByType(decoderParamsBean.m474());
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(decoderParamsBean.m474(), this.f15067, this.f15068);
        if (!f15066) {
            mediaFormatCreateVideoFormat.setInteger("color-format", 31);
        }
        byte[] bArrM5955 = this.f15074.m5955();
        if (bArrM5955 == null) {
            InterfaceC4387 interfaceC4387 = this.f15078;
            if (interfaceC4387 != null) {
                interfaceC4387.onFail();
                return;
            }
            return;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArrM5955.length);
        byteBufferAllocate.put(bArrM5955);
        byteBufferAllocate.position(0);
        byteBufferAllocate.limit(bArrM5955.length);
        mediaFormatCreateVideoFormat.setByteBuffer("csd-0", byteBufferAllocate);
        try {
            this.f15070.configure(mediaFormatCreateVideoFormat, this.f15075.m10099(), (MediaCrypto) null, 0);
            this.f15070.start();
            m13581();
        } catch (Exception e2) {
            e2.printStackTrace();
            InterfaceC4387 interfaceC43872 = this.f15078;
            if (interfaceC43872 != null) {
                interfaceC43872.onFail();
            }
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m13565() {
        if (this.f15070 == null) {
            return;
        }
        Handler handler = this.f15072;
        handler.sendMessage(handler.obtainMessage(10003));
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m13566() {
        synchronized (this.f15073) {
            Handler handler = this.f15072;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            HandlerThread handlerThread = this.f15071;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.f15071 = null;
            this.f15072 = null;
            this.f15073.notify();
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m13567(C0851.C0852 c0852) {
        synchronized (this.f15076) {
            if (this.f15080.m2103(c0852)) {
                this.f15080.m2104(c0852);
            } else if (this.f15080.m2105() == 0) {
                this.f15080.m2106();
            }
            this.f15076.notifyAll();
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public C0851.C0854 m13568() {
        C0851.C0852 c0852M13570 = m13570(-1L);
        if (c0852M13570 == null) {
            return null;
        }
        return new C0851.C0854(c0852M13570, c0852M13570.f1880, 0);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public int m13569() {
        return this.f15068;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final synchronized C0851.C0852 m13570(long j) {
        try {
        } catch (InterruptedException unused) {
            return null;
        }
        return j >= 0 ? this.f15077.poll(j, TimeUnit.MICROSECONDS) : this.f15077.take();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public int m13571() {
        BlockingQueue<C0851.C0852> blockingQueue = this.f15077;
        if (blockingQueue != null) {
            return blockingQueue.size();
        }
        return -1;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public long m13572() {
        return this.f15088;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public int m13573() {
        return this.f15067;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final C0851.C0852 m13574() {
        synchronized (this.f15076) {
            while (this.f15080.m2105() == 0 && !this.f15087) {
                try {
                    try {
                        this.f15076.wait();
                    } catch (InterruptedException unused) {
                        return null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f15087) {
                return null;
            }
            return this.f15080.m2102();
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m13575(DecoderParamsBean decoderParamsBean) {
        this.f15067 = decoderParamsBean.m475();
        this.f15068 = decoderParamsBean.m473();
        this.f15079 = decoderParamsBean;
        synchronized (this.f15073) {
            HandlerThread handlerThread = new HandlerThread(f15065);
            this.f15071 = handlerThread;
            handlerThread.setPriority(4);
            this.f15071.start();
            Handler handler = new Handler(this.f15071.getLooper(), new C4383());
            this.f15072 = handler;
            handler.post(new RunnableC4384(decoderParamsBean));
        }
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m13576() {
        this.f15075 = new C2793(this.f15079, this);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean m13577() {
        return this.f15083;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m13578() throws MediaCodec.CryptoException {
        Handler handler;
        byte[] data;
        MediaCodec mediaCodec;
        ByteBuffer inputBuffer;
        Handler handler2 = this.f15072;
        Message messageObtainMessage = handler2 != null ? handler2.obtainMessage(10003) : null;
        try {
            EsPacket esPacketM5959 = this.f15074.m5959();
            if (esPacketM5959 != null) {
                int i = this.f15085 + 1;
                this.f15085 = i;
                if (i <= 10 && (data = esPacketM5959.getData()) != null && (mediaCodec = this.f15070) != null) {
                    int i2 = this.f15082.flags;
                    int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L);
                    if (iDequeueInputBuffer >= 0 && (inputBuffer = this.f15070.getInputBuffer(iDequeueInputBuffer)) != null) {
                        inputBuffer.clear();
                        inputBuffer.put(data);
                        this.f15070.queueInputBuffer(iDequeueInputBuffer, 0, data.length, esPacketM5959.getPresentationTimeUs(), this.f15082.flags);
                    }
                    MediaCodec.BufferInfo bufferInfo = this.f15069;
                    boolean z = bufferInfo.size != 0;
                    int iDequeueOutputBuffer = this.f15070.dequeueOutputBuffer(bufferInfo, 10000L);
                    if (iDequeueOutputBuffer >= 0) {
                        this.f15086 = 0;
                        if (z) {
                            C2793 c2793 = this.f15075;
                            if (c2793 != null) {
                                c2793.m10103();
                            }
                            C0851.C0852 c0852M13574 = m13574();
                            if (c0852M13574 != null) {
                                long presentationTimeUs = esPacketM5959.getPresentationTimeUs();
                                c0852M13574.f1880 = presentationTimeUs;
                                int i3 = (this.f15084 > 0L ? 1 : (this.f15084 == 0L ? 0 : -1));
                                if (presentationTimeUs != 0) {
                                    this.f15084 = presentationTimeUs;
                                }
                                this.f15075.m10102(c0852M13574);
                                this.f15070.releaseOutputBuffer(iDequeueOutputBuffer, z);
                            }
                        } else {
                            this.f15070.releaseOutputBuffer(iDequeueOutputBuffer, z);
                        }
                    } else if (iDequeueOutputBuffer == -1) {
                        int i4 = this.f15086 + 1;
                        this.f15086 = i4;
                        if (i4 >= 90 && !f15066) {
                            f15066 = true;
                            m13579();
                        }
                    } else {
                        this.f15086 = 0;
                    }
                }
                this.f15085--;
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
        if (!this.f15083 || this.f15070 == null || (handler = this.f15072) == null) {
            return;
        }
        if (messageObtainMessage == null) {
            messageObtainMessage = handler.obtainMessage(10003);
        }
        if (this.f15087) {
            return;
        }
        this.f15072.sendMessage(messageObtainMessage);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m13579() {
        MediaCodec mediaCodec = this.f15070;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.f15070.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f15070 = null;
        }
        try {
            m13564(this.f15079);
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m13580() throws InterruptedException {
        this.f15083 = false;
        this.f15087 = true;
        MediaCodec mediaCodec = this.f15070;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.f15070.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f15070 = null;
        }
        C2793 c2793 = this.f15075;
        if (c2793 != null) {
            c2793.m10101();
        }
        if (r1.m8144(this.f15077)) {
            this.f15077.clear();
        }
        Handler handler = this.f15072;
        if (handler != null) {
            handler.post(new RunnableC4386());
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m13581() {
        this.f15072.post(new RunnableC4385());
    }
}
