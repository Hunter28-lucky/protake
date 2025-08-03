package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.stream.LinkEntity;
import com.blink.academy.film.stream.LinkManager;
import com.github.thibaultbee.srtdroid.enums.SockOpt;
import com.github.thibaultbee.srtdroid.enums.SockStatus;
import com.github.thibaultbee.srtdroid.models.Socket;
import defpackage.C2701;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: SocketServer.kt */
/* renamed from: ʥ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2701 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final C2702 f10004 = new C2702(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String f10005 = "SocketServer";

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean f10006;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final HandlerThread f10007;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Handler f10008;

    /* renamed from: ԫ, reason: contains not printable characters */
    public C2704 f10009;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC2703 f10010;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Socket f10011;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f10012;

    /* compiled from: SocketServer.kt */
    /* renamed from: ʥ$Ϳ, reason: contains not printable characters */
    public static final class C2702 {
        public C2702() {
        }

        public /* synthetic */ C2702(C4184 c4184) {
            this();
        }
    }

    /* compiled from: SocketServer.kt */
    /* renamed from: ʥ$Ԩ, reason: contains not printable characters */
    public interface InterfaceC2703 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo9941(Socket socket);

        /* renamed from: Ԩ, reason: contains not printable characters */
        boolean mo9942();
    }

    /* compiled from: SocketServer.kt */
    /* renamed from: ʥ$Ԫ, reason: contains not printable characters */
    public static final class C2704 extends Thread {

        /* renamed from: ԫ, reason: contains not printable characters */
        public Socket f10013;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2703 f10014;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f10015;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f10016;

        public C2704(Socket socket, InterfaceC2703 interfaceC2703) {
            C3921.m12666(socket, "serverSocket");
            C3921.m12666(interfaceC2703, "serverListener");
            this.f10013 = socket;
            this.f10014 = interfaceC2703;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f10016 = true;
            try {
                Socket socket = this.f10013;
                if (this.f10015) {
                    t tVar = t.f8531;
                    String str = String.format("isBound : %s , state : %s ", Arrays.copyOf(new Object[]{Boolean.valueOf(socket.isBound()), socket.getSockState()}, 2));
                    C3921.m12665(str, "format(format, *args)");
                    C4638.m14099("SocketServer", str);
                }
                while (this.f10016 && socket.isValid()) {
                    try {
                        if (this.f10015) {
                            t tVar2 = t.f8531;
                            String str2 = String.format("serverListener.closed() : %s , state : %s ", Arrays.copyOf(new Object[]{Boolean.valueOf(this.f10014.mo9942()), socket.getSockState()}, 2));
                            C3921.m12665(str2, "format(format, *args)");
                            C4638.m14099("SocketServer", str2);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (this.f10015) {
                            t tVar3 = t.f8531;
                            String str3 = String.format("serverSocket close : %s , state : %s ", Arrays.copyOf(new Object[]{FinderManager.MACHINE_D, socket.getSockState()}, 2));
                            C3921.m12665(str3, "format(format, *args)");
                            C4638.m14099("SocketServer", str3);
                        }
                    }
                    if (this.f10014.mo9942()) {
                        break;
                    }
                    if (this.f10016 && socket.isValid()) {
                        if (this.f10015) {
                            t tVar4 = t.f8531;
                            String str4 = String.format("before accept , isRunning : %s , it.isValid : %s , state : %s ", Arrays.copyOf(new Object[]{Boolean.valueOf(this.f10016), Boolean.valueOf(socket.isValid()), socket.getSockState()}, 3));
                            C3921.m12665(str4, "format(format, *args)");
                            C4638.m14099("SocketServer", str4);
                        }
                        Pair<Socket, InetSocketAddress> pairAccept = socket.accept();
                        if (this.f10014.mo9942()) {
                            if (!this.f10015) {
                                break;
                            }
                            t tVar5 = t.f8531;
                            String str5 = String.format("after accept , isRunning : %s , it.isValid : %s , state : %s ", Arrays.copyOf(new Object[]{Boolean.valueOf(this.f10016), Boolean.valueOf(socket.isValid()), socket.getSockState()}, 3));
                            C3921.m12665(str5, "format(format, *args)");
                            C4638.m14099("SocketServer", str5);
                            break;
                        }
                        if (this.f10015) {
                            t tVar6 = t.f8531;
                            String str6 = String.format("after accept , isRunning : %s , it.isValid : %s , state : %s ", Arrays.copyOf(new Object[]{Boolean.valueOf(this.f10016), Boolean.valueOf(socket.isValid()), socket.getSockState()}, 3));
                            C3921.m12665(str6, "format(format, *args)");
                            C4638.m14099("SocketServer", str6);
                        }
                        Socket socket2 = (Socket) pairAccept.first;
                        if (this.f10014.mo9942()) {
                            break;
                        }
                        if (socket2.isValid()) {
                            InterfaceC2703 interfaceC2703 = this.f10014;
                            C3921.m12665(socket2, "clientSocket");
                            interfaceC2703.mo9941(socket2);
                        }
                    }
                }
                if (this.f10015) {
                    t tVar7 = t.f8531;
                    String str7 = String.format("serverSocket close : %s , state : %s ", Arrays.copyOf(new Object[]{FinderManager.MACHINE_C, socket.getSockState()}, 2));
                    C3921.m12665(str7, "format(format, *args)");
                    C4638.m14099("SocketServer", str7);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                if (this.f10015) {
                    t tVar8 = t.f8531;
                    String str8 = String.format("serverSocket close : %s , state : %s ", Arrays.copyOf(new Object[]{"2", this.f10013.getSockState()}, 2));
                    C3921.m12665(str8, "format(format, *args)");
                    C4638.m14099("SocketServer", str8);
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final void m9943(boolean z) {
            this.f10016 = z;
        }
    }

    /* compiled from: SocketServer.kt */
    /* renamed from: ʥ$Ԭ, reason: contains not printable characters */
    public static final class C2705 implements InterfaceC2703 {
        public C2705() {
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static final void m9945(Socket socket) {
            C3921.m12666(socket, "$client");
            LinkManager.getInstance().addClient(socket);
        }

        @Override // defpackage.C2701.InterfaceC2703
        /* renamed from: Ϳ */
        public void mo9941(final Socket socket) {
            C3921.m12666(socket, "client");
            if (C2701.this.f10006) {
                C4638.m14099(C2701.this.f10005, "socket  " + socket.getSockName() + " : " + socket.getPeerName() + " connected !");
            }
            C2701.this.f10008.post(new Runnable() { // from class: ඇ
                @Override // java.lang.Runnable
                public final void run() {
                    C2701.C2705.m9945(socket);
                }
            });
        }

        @Override // defpackage.C2701.InterfaceC2703
        /* renamed from: Ԩ */
        public boolean mo9942() {
            return C2701.this.f10012;
        }
    }

    public C2701() {
        HandlerThread handlerThread = new HandlerThread("SocketServer");
        this.f10007 = handlerThread;
        handlerThread.start();
        this.f10008 = new Handler(handlerThread.getLooper());
        this.f10010 = new C2705();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final void m9932(C2701 c2701) throws SocketException, InterruptedException {
        Socket socket;
        C3921.m12666(c2701, "this$0");
        C2704 c2704 = c2701.f10009;
        if (c2704 != null) {
            c2704.m9943(false);
        }
        c2701.f10012 = true;
        if (c2701.f10006) {
            t tVar = t.f8531;
            Object[] objArr = new Object[2];
            objArr[0] = "1";
            Socket socket2 = c2701.f10011;
            objArr[1] = socket2 != null ? socket2.getSockState() : null;
            String str = String.format("serverSocket close : %s , state : %s ", Arrays.copyOf(objArr, 2));
            C3921.m12665(str, "format(format, *args)");
            C4638.m14099("SocketServer", str);
        }
        Socket socket3 = c2701.f10011;
        if ((socket3 != null ? socket3.getSockState() : null) != SockStatus.BROKEN) {
            Socket socket4 = c2701.f10011;
            if ((socket4 != null ? socket4.getSockState() : null) != SockStatus.CLOSED && (socket = c2701.f10011) != null) {
                socket.close();
            }
        }
        if (c2701.f10006) {
            t tVar2 = t.f8531;
            Object[] objArr2 = new Object[2];
            objArr2[0] = "6";
            Socket socket5 = c2701.f10011;
            objArr2[1] = socket5 != null ? socket5.getSockState() : null;
            String str2 = String.format("serverSocket close : %s , state : %s ", Arrays.copyOf(objArr2, 2));
            C3921.m12665(str2, "format(format, *args)");
            C4638.m14099("SocketServer", str2);
        }
        C2704 c27042 = c2701.f10009;
        if (c27042 != null) {
            c27042.join();
        }
        c2701.f10011 = null;
        C4806.m14521().m14526();
        c2701.f10007.quit();
        if (c2701.f10006) {
            t tVar3 = t.f8531;
            Object[] objArr3 = new Object[2];
            objArr3[0] = "handler thread quit";
            Socket socket6 = c2701.f10011;
            objArr3[1] = socket6 != null ? socket6.getSockState() : null;
            String str3 = String.format("serverSocket close : %s , state : %s ", Arrays.copyOf(objArr3, 2));
            C3921.m12665(str3, "format(format, *args)");
            C4638.m14099("SocketServer", str3);
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static final void m9933(C2701 c2701, String str, int i) throws Exception {
        C3921.m12666(c2701, "this$0");
        C3921.m12666(str, "$ip");
        LinkManager.getInstance().clearClientLinks();
        C2704 c2704 = c2701.f10009;
        if (c2704 != null) {
            c2704.m9943(false);
            c2704.join();
        }
        c2701.m9938(str, i);
        Socket socket = c2701.f10011;
        C3921.m12664(socket);
        C2704 c27042 = new C2704(socket, c2701.f10010);
        c2701.f10009 = c27042;
        c27042.setName("SocketServerListener");
        C2704 c27043 = c2701.f10009;
        if (c27043 != null) {
            c27043.start();
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static final void m9934(byte[] bArr, C2701 c2701) {
        C3921.m12666(bArr, "$datas");
        C3921.m12666(c2701, "this$0");
        ArrayList arrayList = new ArrayList();
        List<LinkEntity> links = LinkManager.getInstance().getLinks();
        if (r1.m8144(links)) {
            C3921.m12665(links, "links");
            for (LinkEntity linkEntity : links) {
                Socket socket = linkEntity.getSocket();
                if (linkEntity.getType() == 0 && socket != null) {
                    SockStatus sockState = socket.getSockState();
                    if (sockState == SockStatus.CONNECTED) {
                        try {
                            if (socket.send(bArr) == -1) {
                                C4638.m14099(c2701.f10005, socket.getPeerName() + " closed !");
                                socket.close();
                                arrayList.add(linkEntity);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (sockState == SockStatus.BROKEN || sockState == SockStatus.CLOSED || sockState == SockStatus.CLOSING || sockState == SockStatus.NON_EXIST) {
                        arrayList.add(linkEntity);
                    }
                }
            }
            LinkManager.getInstance().removeClientLinks(arrayList);
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static final void m9935(byte[] bArr, C2701 c2701) throws SocketException {
        C3921.m12666(bArr, "$datas");
        C3921.m12666(c2701, "this$0");
        ArrayList arrayList = new ArrayList();
        List<LinkEntity> links = LinkManager.getInstance().getLinks();
        if (r1.m8144(links)) {
            int i = 0;
            C3921.m12665(links, "links");
            for (LinkEntity linkEntity : links) {
                Socket socket = linkEntity.getSocket();
                if (linkEntity.getType() == 0 && socket != null) {
                    SockStatus sockState = socket.getSockState();
                    if (sockState == SockStatus.CONNECTED && r1.m8143(linkEntity.getUuid()) && !linkEntity.isBanned() && i < 4) {
                        try {
                            if (socket.send(bArr) == -1) {
                                C4638.m14099(c2701.f10005, socket.getPeerName() + " closed !");
                                socket.close();
                                arrayList.add(linkEntity);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            socket.close();
                            arrayList.add(linkEntity);
                        }
                        i++;
                    } else if (sockState == SockStatus.BROKEN || sockState == SockStatus.CLOSED || sockState == SockStatus.CLOSING || sockState == SockStatus.NON_EXIST) {
                        arrayList.add(linkEntity);
                    }
                }
            }
            LinkManager.getInstance().removeClientLinks(arrayList);
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m9936() {
        if (this.f10006) {
            t tVar = t.f8531;
            Object[] objArr = new Object[2];
            objArr[0] = "1";
            Socket socket = this.f10011;
            objArr[1] = socket != null ? socket.getSockState() : null;
            String str = String.format("begin serverSocket close : %s , state : %s ", Arrays.copyOf(objArr, 2));
            C3921.m12665(str, "format(format, *args)");
            C4638.m14099("SocketServer", str);
        }
        this.f10008.post(new Runnable() { // from class: ʤ
            @Override // java.lang.Runnable
            public final void run() throws SocketException, InterruptedException {
                C2701.m9932(this.f10003);
            }
        });
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m9937(final String str, final int i) {
        C3921.m12666(str, "ip");
        this.f10008.post(new Runnable() { // from class: ල
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                C2701.m9933(this.f16356, str, i);
            }
        });
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m9938(String str, int i) throws Exception {
        C3921.m12666(str, "ip");
        if (this.f10006) {
            t tVar = t.f8531;
            String str2 = String.format("serverSocket create : %s", Arrays.copyOf(new Object[]{"1"}, 1));
            C3921.m12665(str2, "format(format, *args)");
            C4638.m14099("SocketServer", str2);
        }
        Socket socket = new Socket();
        this.f10011 = socket;
        if (!socket.isValid()) {
            throw new Exception("Failed to create a Socket");
        }
        SockOpt sockOpt = SockOpt.RCVSYN;
        Boolean bool = Boolean.TRUE;
        socket.setSockFlag(sockOpt, bool);
        socket.setSockFlag(SockOpt.TSBPDMODE, bool);
        if (ACHelper.getInstance().getCameraQualityType() == 3) {
            socket.setSockFlag(SockOpt.PEERLATENCY, 60);
        } else {
            socket.setSockFlag(SockOpt.PEERLATENCY, 250);
        }
        socket.setSockFlag(SockOpt.RCVLATENCY, 30);
        SockOpt sockOpt2 = SockOpt.PASSPHRASE;
        String strM5991 = e5.m5988().m5991();
        C3921.m12665(strM5991, "getInstance().uuid");
        socket.setSockFlag(sockOpt2, strM5991);
        socket.setSockFlag(SockOpt.STREAMID, "1");
        socket.setSockFlag(SockOpt.TLPKTDROP, bool);
        socket.bind(str, i);
        socket.listen(1);
        if (this.f10006) {
            t tVar2 = t.f8531;
            String str3 = String.format("isBound : %s", Arrays.copyOf(new Object[]{Boolean.valueOf(socket.isBound())}, 1));
            C3921.m12665(str3, "format(format, *args)");
            C4638.m14099("SocketServer", str3);
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m9939(final byte[] bArr) {
        C3921.m12666(bArr, "datas");
        this.f10008.post(new Runnable() { // from class: ඌ
            @Override // java.lang.Runnable
            public final void run() {
                C2701.m9934(bArr, this);
            }
        });
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m9940(final byte[] bArr) {
        C3921.m12666(bArr, "datas");
        this.f10008.post(new Runnable() { // from class: ඓ
            @Override // java.lang.Runnable
            public final void run() throws SocketException {
                C2701.m9935(bArr, this);
            }
        });
    }
}
