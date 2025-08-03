package defpackage;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.blink.academy.film.bean.socket.DecoderParamsBean;
import com.blink.academy.film.support.stream.ts.EsPacket;
import defpackage.C4575;
import defpackage.e;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

/* compiled from: PreviewRealEncoder.java */
/* renamed from: ԛ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3158 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public HandlerThread f11208;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Handler f11209;

    /* renamed from: ԩ, reason: contains not printable characters */
    public DecoderParamsBean f11210;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Object f11211 = new Object();

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f11212 = -1;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f11213 = -1;

    /* renamed from: ԭ, reason: contains not printable characters */
    public e.InterfaceC1958 f11214;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C4575 f11215;

    /* renamed from: ԯ, reason: contains not printable characters */
    public MediaCodec f11216;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Surface f11217;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f11218;

    /* renamed from: ֏, reason: contains not printable characters */
    public C2557 f11219;

    /* compiled from: PreviewRealEncoder.java */
    /* renamed from: ԛ$Ϳ, reason: contains not printable characters */
    public class RunnableC3159 implements Runnable {
        public RunnableC3159() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* compiled from: PreviewRealEncoder.java */
    /* renamed from: ԛ$Ԩ, reason: contains not printable characters */
    public class RunnableC3160 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f11221;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ C4575.InterfaceC4584 f11222;

        public RunnableC3160(Runnable runnable, C4575.InterfaceC4584 interfaceC4584) {
            this.f11221 = runnable;
            this.f11222 = interfaceC4584;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C3158.this.f11216.start();
                Runnable runnable = this.f11221;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                C4575.InterfaceC4584 interfaceC4584 = this.f11222;
                if (interfaceC4584 != null) {
                    interfaceC4584.onFail();
                }
            }
        }
    }

    /* compiled from: PreviewRealEncoder.java */
    /* renamed from: ԛ$Ԫ, reason: contains not printable characters */
    public class RunnableC3161 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Runnable f11224;

        public RunnableC3161(Runnable runnable) {
            this.f11224 = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                C3158 c3158 = C3158.this;
                c3158.m10765(c3158.f11210, this.f11224);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: PreviewRealEncoder.java */
    /* renamed from: ԛ$Ԭ, reason: contains not printable characters */
    public class RunnableC3162 implements Runnable {
        public RunnableC3162() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3158.this.m10771();
        }
    }

    /* compiled from: PreviewRealEncoder.java */
    /* renamed from: ԛ$Ԯ, reason: contains not printable characters */
    public class RunnableC3163 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f11227;

        public RunnableC3163(boolean z) {
            this.f11227 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3158.this.m10766(this.f11227);
        }
    }

    public C3158(DecoderParamsBean decoderParamsBean, e.InterfaceC1958 interfaceC1958, C4575 c4575) {
        this.f11214 = interfaceC1958;
        this.f11215 = c4575;
        m10769(decoderParamsBean);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m10765(DecoderParamsBean decoderParamsBean, Runnable runnable) throws IOException {
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(decoderParamsBean.m474(), this.f11212, this.f11213);
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("bitrate", decoderParamsBean.m470());
        mediaFormatCreateVideoFormat.setInteger("frame-rate", decoderParamsBean.m472());
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", decoderParamsBean.m476());
        MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType(decoderParamsBean.m474());
        this.f11216 = mediaCodecCreateEncoderByType;
        try {
            mediaCodecCreateEncoderByType.configure(mediaFormatCreateVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f11216.getCodecInfo();
        this.f11217 = this.f11216.createInputSurface();
        runnable.run();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean m10766(boolean z) {
        int iDequeueOutputBuffer;
        MediaCodec mediaCodec = this.f11216;
        if (mediaCodec == null) {
            return false;
        }
        if (z) {
            mediaCodec.signalEndOfInputStream();
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        while (true) {
            try {
                iDequeueOutputBuffer = this.f11216.dequeueOutputBuffer(bufferInfo, 10000L);
                Bundle bundle = new Bundle();
                bundle.putInt("video-bitrate", this.f11210.m470());
                this.f11216.setParameters(bundle);
                if (iDequeueOutputBuffer != -1 && iDequeueOutputBuffer != -3) {
                    if (iDequeueOutputBuffer != -2) {
                        if (iDequeueOutputBuffer >= 0) {
                            break;
                        }
                    } else {
                        this.f11216.getOutputFormat();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        ByteBuffer outputBuffer = this.f11216.getOutputBuffer(iDequeueOutputBuffer);
        if (outputBuffer == null) {
            throw new RuntimeException("encoderOutputBuffer " + iDequeueOutputBuffer + " was null");
        }
        if ((bufferInfo.flags & 2) != 0) {
            byte[] bArr = new byte[bufferInfo.size];
            outputBuffer.position(0);
            outputBuffer.get(bArr);
            outputBuffer.position(bufferInfo.offset);
            outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
            C2557 c2557 = new C2557();
            c2557.m9412(new EsPacket(2, bufferInfo.presentationTimeUs, bArr));
            c2557.m9411(this.f11210);
            c2557.m9413(0);
            this.f11219 = c2557;
            this.f11214.onDataIn(this.f11210, null, c2557);
            bufferInfo.size = 0;
        }
        int i = bufferInfo.size;
        if (i != 0) {
            byte[] bArr2 = new byte[i];
            outputBuffer.position(0);
            outputBuffer.get(bArr2);
            outputBuffer.position(bufferInfo.offset);
            outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
            C2557 c25572 = new C2557();
            EsPacket esPacket = new EsPacket((bufferInfo.flags & 1) != 0 ? 5 : 1, bufferInfo.presentationTimeUs, bArr2);
            c25572.m9412(esPacket);
            c25572.m9411(this.f11210);
            c25572.m9413(1);
            C4575 c4575 = this.f11215;
            if (c4575 != null) {
                Map<Long, String> mapM14041 = c4575.m14041();
                if (r1.m8142(mapM14041) && mapM14041.containsKey(Long.valueOf(bufferInfo.presentationTimeUs))) {
                    String strRemove = mapM14041.remove(Long.valueOf(bufferInfo.presentationTimeUs));
                    if (r1.m8143(strRemove)) {
                        esPacket.appendData(strRemove.getBytes());
                    }
                }
                if (mapM14041.size() > 20) {
                    this.f11215.m14041().clear();
                }
            }
            this.f11214.onDataIn(this.f11210, c25572, this.f11219);
            outputBuffer.position(bufferInfo.offset);
            outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
        }
        this.f11216.releaseOutputBuffer(iDequeueOutputBuffer, false);
        if ((bufferInfo.flags & 4) == 0) {
            return false;
        }
        m10771();
        return true;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public Surface m10767() {
        return this.f11217;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m10768(boolean z) {
        Handler handler = this.f11209;
        if (handler == null) {
            return;
        }
        handler.post(new RunnableC3163(z));
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m10769(DecoderParamsBean decoderParamsBean) {
        if (this.f11218) {
            synchronized (this.f11211) {
                try {
                    this.f11211.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        this.f11210 = decoderParamsBean;
        this.f11212 = decoderParamsBean.m475();
        this.f11213 = decoderParamsBean.m473();
        synchronized (this.f11211) {
            HandlerThread handlerThread = new HandlerThread("PreviewRealEncoder");
            this.f11208 = handlerThread;
            handlerThread.setPriority(4);
            this.f11208.start();
            Handler handler = new Handler(this.f11208.getLooper());
            this.f11209 = handler;
            handler.post(new RunnableC3159());
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m10770(Runnable runnable) {
        this.f11209.post(new RunnableC3161(runnable));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m10771() {
        MediaCodec mediaCodec = this.f11216;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.f11216.release();
            this.f11216 = null;
        }
        synchronized (this.f11211) {
            HandlerThread handlerThread = this.f11208;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.f11208 = null;
            this.f11209 = null;
            this.f11218 = false;
            this.f11211.notify();
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m10772(Runnable runnable, C4575.InterfaceC4584 interfaceC4584) {
        this.f11209.post(new RunnableC3160(runnable, interfaceC4584));
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m10773() {
        this.f11218 = true;
        Handler handler = this.f11209;
        if (handler != null) {
            handler.post(new RunnableC3162());
        } else {
            this.f11218 = false;
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m10774(int i) {
        if (this.f11216 != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", i);
            this.f11216.setParameters(bundle);
        }
    }
}
