package defpackage;

import android.util.Pair;
import com.github.thibaultbee.srtdroid.enums.ErrorType;
import com.github.thibaultbee.srtdroid.enums.SockOpt;
import com.github.thibaultbee.srtdroid.enums.SockStatus;
import com.github.thibaultbee.srtdroid.listeners.SocketListener;
import com.github.thibaultbee.srtdroid.models.Socket;
import com.umeng.analytics.pro.d;
import java.net.InetSocketAddress;
import java.net.SocketException;

/* compiled from: SocketClient.kt */
/* renamed from: ഈ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4672 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String f15865 = "SocketClient";

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean f15866;

    /* renamed from: ԩ, reason: contains not printable characters */
    public Socket f15867;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C4673 f15868;

    /* renamed from: ԫ, reason: contains not printable characters */
    public InterfaceC4493 f15869;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f15870;

    /* compiled from: SocketClient.kt */
    /* renamed from: ഈ$Ϳ, reason: contains not printable characters */
    public static final class C4673 extends Thread {

        /* renamed from: ԫ, reason: contains not printable characters */
        public C4672 f15871;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f15872;

        public C4673(C4672 c4672) {
            C3921.m12666(c4672, "socketClient");
            this.f15871 = c4672;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws SocketException {
            this.f15872 = true;
            while (this.f15872) {
                try {
                    byte[] bArrM14170 = this.f15871.m14170();
                    InterfaceC4493 interfaceC4493M14169 = this.f15871.m14169();
                    if (interfaceC4493M14169 != null) {
                        interfaceC4493M14169.onRecvBytes(bArrM14170);
                    }
                } catch (Exception e2) {
                    InterfaceC4493 interfaceC4493M141692 = this.f15871.m14169();
                    if (interfaceC4493M141692 != null) {
                        String message = e2.getMessage();
                        if (message == null) {
                            message = "";
                        }
                        interfaceC4493M141692.onConnectionClose(message);
                    }
                    this.f15871.m14166();
                    this.f15872 = false;
                    e2.printStackTrace();
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void m14177(boolean z) {
            this.f15872 = z;
        }
    }

    /* compiled from: SocketClient.kt */
    /* renamed from: ഈ$Ԩ, reason: contains not printable characters */
    public static final class C4674 implements SocketListener {
        public C4674() {
        }

        @Override // com.github.thibaultbee.srtdroid.listeners.SocketListener
        public void onConnectionLost(Socket socket, ErrorType errorType, InetSocketAddress inetSocketAddress, int i) {
            C3921.m12666(socket, "ns");
            C3921.m12666(errorType, d.O);
            C3921.m12666(inetSocketAddress, "peerAddress");
            if (C4672.this.f15866) {
                C4638.m14099(C4672.this.f15865, "error : " + errorType + ", token : " + i + ' ');
            }
        }

        @Override // com.github.thibaultbee.srtdroid.listeners.SocketListener
        public int onListen(Socket socket, int i, InetSocketAddress inetSocketAddress, String str) {
            C3921.m12666(socket, "ns");
            C3921.m12666(inetSocketAddress, "peerAddress");
            C3921.m12666(str, "streamId");
            if (!C4672.this.f15866) {
                return 0;
            }
            C4638.m14099(C4672.this.f15865, "hsVersion : " + i + ", streamId : " + str + " , peerAddress : " + inetSocketAddress + ' ');
            return 0;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m14165() {
        return this.f15867 != null;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m14166() throws SocketException {
        if (this.f15866) {
            C4638.m14099(this.f15865, "start close");
        }
        if (this.f15867 != null) {
            this.f15870 = false;
            m14176();
            Socket socket = this.f15867;
            if (socket != null) {
                socket.close();
            }
            this.f15867 = null;
            C4806.m14521().m14526();
            if (this.f15866) {
                C4638.m14099(this.f15865, "close finish!");
            }
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m14167(C4682 c4682) throws Exception {
        C3921.m12666(c4682, "params");
        if (this.f15866) {
            C4638.m14099(this.f15865, c4682.toString());
        }
        Socket socket = new Socket();
        this.f15867 = socket;
        if (!socket.isValid()) {
            throw new Exception("Failed to create a Socket");
        }
        socket.setListener(new C4674());
        SockOpt sockOpt = SockOpt.RCVSYN;
        Boolean bool = Boolean.TRUE;
        socket.setSockFlag(sockOpt, bool);
        socket.setSockFlag(SockOpt.TLPKTDROP, bool);
        socket.setSockFlag(SockOpt.RCVLATENCY, Integer.valueOf(c4682.m14189()));
        socket.setSockFlag(SockOpt.PEERLATENCY, Integer.valueOf(c4682.m14187()));
        socket.setSockFlag(SockOpt.PASSPHRASE, c4682.m14186());
        socket.setSockFlag(SockOpt.STREAMID, c4682.m14190());
        socket.setSockFlag(SockOpt.SNDTIMEO, 5000);
        socket.setSockFlag(SockOpt.CONNTIMEO, 5000);
        socket.connect(c4682.m14185(), c4682.m14188());
        if (!socket.isConnected()) {
            socket.close();
            throw new Exception("connect failed");
        }
        InetSocketAddress sockName = socket.getSockName();
        InetSocketAddress peerName = socket.getPeerName();
        SockStatus sockState = socket.getSockState();
        if (this.f15866) {
            C4638.m14099(this.f15865, "sockName " + sockName + " , peerName " + peerName + " , sockState " + sockState);
        }
        this.f15870 = true;
        m14175();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Socket m14168() {
        return this.f15867;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final InterfaceC4493 m14169() {
        return this.f15869;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final byte[] m14170() throws Exception {
        Socket socket = this.f15867;
        Pair<Integer, byte[]> pairRecv = socket != null ? socket.recv(2048) : null;
        Integer num = pairRecv != null ? (Integer) pairRecv.first : null;
        byte[] bArr = pairRecv != null ? (byte[]) pairRecv.second : null;
        if (num == null) {
            m14166();
            throw new Exception(C4995.f16752.m14785());
        }
        int iIntValue = num.intValue();
        if (iIntValue > 0) {
            C3921.m12664(bArr);
            return bArr;
        }
        if (iIntValue == 0) {
            m14166();
            throw new Exception("Connection has been closed");
        }
        m14166();
        throw new Exception(C4995.f16752.m14785());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m14171(byte[] bArr) throws SocketException {
        C3921.m12666(bArr, "message");
        if (this.f15870) {
            try {
                Socket socket = this.f15867;
                boolean z = false;
                if (socket != null && socket.send(bArr) == -1) {
                    z = true;
                }
                if (z) {
                    InterfaceC4493 interfaceC4493 = this.f15869;
                    if (interfaceC4493 != null) {
                        interfaceC4493.onConnectionClose(C4995.f16752.m14785());
                    }
                    m14166();
                }
            } catch (Exception unused) {
                InterfaceC4493 interfaceC44932 = this.f15869;
                if (interfaceC44932 != null) {
                    interfaceC44932.onConnectionClose(C4995.f16752.m14785());
                }
                m14166();
            }
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m14172(byte[] bArr) throws SocketException {
        C3921.m12666(bArr, "datas");
        if (this.f15870) {
            try {
                Socket socket = this.f15867;
                boolean z = false;
                if (socket != null && socket.send(bArr) == -1) {
                    z = true;
                }
                if (z) {
                    InterfaceC4493 interfaceC4493 = this.f15869;
                    if (interfaceC4493 != null) {
                        interfaceC4493.onConnectionClose(C4995.f16752.m14785());
                    }
                    m14166();
                }
            } catch (Exception unused) {
                InterfaceC4493 interfaceC44932 = this.f15869;
                if (interfaceC44932 != null) {
                    interfaceC44932.onConnectionClose(C4995.f16752.m14785());
                }
                m14166();
            }
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m14173(byte[] bArr) throws SocketException {
        C3921.m12666(bArr, "datas");
        if (this.f15870) {
            try {
                Socket socket = this.f15867;
                boolean z = false;
                if (socket != null && socket.send(bArr) == -1) {
                    z = true;
                }
                if (z) {
                    InterfaceC4493 interfaceC4493 = this.f15869;
                    if (interfaceC4493 != null) {
                        interfaceC4493.onConnectionClose(C4995.f16752.m14785());
                    }
                    m14166();
                }
            } catch (Exception unused) {
                InterfaceC4493 interfaceC44932 = this.f15869;
                if (interfaceC44932 != null) {
                    interfaceC44932.onConnectionClose(C4995.f16752.m14785());
                }
                m14166();
            }
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m14174(InterfaceC4493 interfaceC4493) {
        this.f15869 = interfaceC4493;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m14175() {
        C4673 c4673 = new C4673(this);
        this.f15868 = c4673;
        c4673.start();
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m14176() {
        C4673 c4673 = this.f15868;
        if (c4673 != null) {
            if (c4673 == null) {
                C3921.m12681("clientRecvThread");
                c4673 = null;
            }
            c4673.m14177(false);
        }
    }
}
