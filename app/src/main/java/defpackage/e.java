package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import com.blink.academy.film.bean.socket.DecoderParamsBean;
import com.blink.academy.film.support.stream.ts.EsPacket;
import com.blink.academy.film.support.stream.ts.TsParser;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: SrtReaderHelper.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: ؠ, reason: contains not printable characters */
    public static final Object f6579 = new Object();

    /* renamed from: ހ, reason: contains not printable characters */
    public static final String f6580 = "e";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public HandlerThread f6581;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Handler f6582;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public byte[] f6584;

    /* renamed from: ԫ, reason: contains not printable characters */
    public byte[] f6585;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public byte[] f6586;

    /* renamed from: ԯ, reason: contains not printable characters */
    public DecoderParamsBean f6589;

    /* renamed from: ՠ, reason: contains not printable characters */
    public InterfaceC1957 f6590;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f6593;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f6583 = "video/hevc";

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f6591 = 0;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f6592 = true;

    /* renamed from: ԭ, reason: contains not printable characters */
    public BlockingQueue<EsPacket> f6587 = new LinkedBlockingQueue();

    /* renamed from: Ԯ, reason: contains not printable characters */
    public BlockingQueue<EsPacket> f6588 = new LinkedBlockingQueue();

    /* compiled from: SrtReaderHelper.java */
    /* renamed from: e$Ϳ, reason: contains not printable characters */
    public class C1955 implements Handler.Callback {
        public C1955() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) throws InterruptedException {
            Handler handler;
            if (message.what != 10001) {
                return false;
            }
            Handler handler2 = e.this.f6582;
            Message messageObtainMessage = handler2 != null ? handler2.obtainMessage(10001) : null;
            e.this.m5958();
            if (!e.this.f6593 || (handler = e.this.f6582) == null) {
                return true;
            }
            if (messageObtainMessage == null) {
                messageObtainMessage = handler.obtainMessage(10001);
            }
            e.this.f6582.sendMessage(messageObtainMessage);
            return true;
        }
    }

    /* compiled from: SrtReaderHelper.java */
    /* renamed from: e$Ԩ, reason: contains not printable characters */
    public class RunnableC1956 implements Runnable {
        public RunnableC1956() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.m5953();
        }
    }

    /* compiled from: SrtReaderHelper.java */
    /* renamed from: e$Ԫ, reason: contains not printable characters */
    public interface InterfaceC1957 {
        void onHeadIn(DecoderParamsBean decoderParamsBean);

        void onRelease();
    }

    /* compiled from: SrtReaderHelper.java */
    /* renamed from: e$Ԭ, reason: contains not printable characters */
    public interface InterfaceC1958 {
        void onDataIn(DecoderParamsBean decoderParamsBean, C2557 c2557, C2557 c25572);
    }

    public e() {
        synchronized (f6579) {
            HandlerThread handlerThread = new HandlerThread(f6580);
            this.f6581 = handlerThread;
            handlerThread.setPriority(4);
            this.f6581.start();
            Handler handler = new Handler(this.f6581.getLooper(), new C1955());
            this.f6582 = handler;
            handler.sendEmptyMessage(10001);
        }
        this.f6593 = true;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static byte[] m5949(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m5950(EsPacket esPacket) {
        this.f6587.offer(esPacket);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m5951(EsPacket esPacket) {
        this.f6588.offer(esPacket);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m5952() {
        this.f6587.clear();
        this.f6588.clear();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m5953() {
        Object obj = f6579;
        synchronized (obj) {
            HandlerThread handlerThread = this.f6581;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.f6582.removeCallbacksAndMessages(null);
            this.f6581 = null;
            this.f6582 = null;
            obj.notify();
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public int m5954() {
        return this.f6591;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public byte[] m5955() {
        byte[] bArr;
        synchronized (f6579) {
            bArr = this.f6584;
        }
        return bArr;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public InterfaceC1957 m5956() {
        return this.f6590;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m5957(byte[] bArr) {
        TsParser.VideoConfig videoConfig = new TsParser.VideoConfig(this.f6583, bArr);
        int width = videoConfig.getWidth();
        int height = videoConfig.getHeight();
        DecoderParamsBean decoderParamsBean = this.f6589;
        if (decoderParamsBean != null && decoderParamsBean.m475() == width && this.f6589.m473() == height) {
            return;
        }
        DecoderParamsBean decoderParamsBean2 = new DecoderParamsBean();
        this.f6589 = decoderParamsBean2;
        decoderParamsBean2.m482(this.f6583);
        this.f6589.m483(width);
        this.f6589.m481(height);
        this.f6584 = bArr;
        InterfaceC1957 interfaceC1957 = this.f6590;
        if (interfaceC1957 != null) {
            interfaceC1957.onHeadIn(this.f6589);
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m5958() throws InterruptedException {
        try {
            EsPacket esPacketTake = this.f6588.take();
            int type = esPacketTake.getType();
            byte[] data = esPacketTake.getData();
            if (type == 2) {
                m5957(data);
                return;
            }
            if (type == 8) {
                if (this.f6585 != null && this.f6586 != null) {
                    this.f6585 = null;
                    this.f6586 = null;
                }
                this.f6585 = data;
                byte[] bArr = this.f6586;
                if (bArr != null) {
                    m5957(m5949(bArr, data));
                    return;
                }
                return;
            }
            if (type == 7) {
                if (this.f6585 != null && this.f6586 != null) {
                    this.f6585 = null;
                    this.f6586 = null;
                }
                this.f6586 = data;
                byte[] bArr2 = this.f6585;
                if (bArr2 != null) {
                    m5957(m5949(data, bArr2));
                    return;
                }
                return;
            }
            if (this.f6589 != null) {
                if (!this.f6592) {
                    m5950(esPacketTake);
                } else if (esPacketTake.getType() == 5) {
                    this.f6592 = false;
                    m5950(esPacketTake);
                }
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public EsPacket m5959() {
        try {
            return this.f6587.take();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m5960() {
        C4638.m14101("slimC213", "srtReadrHelper release");
        this.f6593 = false;
        this.f6587.clear();
        this.f6588.clear();
        this.f6584 = null;
        this.f6585 = null;
        this.f6586 = null;
        HandlerThread handlerThread = this.f6581;
        if (handlerThread != null) {
            handlerThread.interrupt();
            this.f6582.post(new RunnableC1956());
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m5961() {
        this.f6589 = null;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m5962(int i) {
        this.f6591 = i;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m5963(boolean z) {
        this.f6592 = z;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m5964(InterfaceC1957 interfaceC1957) {
        this.f6590 = interfaceC1957;
    }
}
