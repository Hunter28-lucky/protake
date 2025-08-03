package com.github.thibaultbee.srtdroid.models;

import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.github.thibaultbee.srtdroid.Srt;
import com.github.thibaultbee.srtdroid.enums.ErrorType;
import com.github.thibaultbee.srtdroid.enums.RejectReasonCode;
import com.github.thibaultbee.srtdroid.enums.SockOpt;
import com.github.thibaultbee.srtdroid.enums.SockStatus;
import com.github.thibaultbee.srtdroid.listeners.SocketListener;
import com.github.thibaultbee.srtdroid.models.rejectreason.InternalRejectReason;
import com.github.thibaultbee.srtdroid.models.rejectreason.PredefinedRejectReason;
import com.github.thibaultbee.srtdroid.models.rejectreason.RejectReason;
import com.github.thibaultbee.srtdroid.models.rejectreason.UserDefinedRejectReason;
import defpackage.C3921;
import defpackage.C4184;
import defpackage.C4542;
import defpackage.C5241;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;

/* compiled from: Socket.kt */
/* loaded from: classes.dex */
public final class Socket implements Closeable {
    public static final Companion Companion = new Companion(null);
    private SocketListener listener;
    private int srtsocket;

    /* compiled from: Socket.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C4184 c4184) {
            this();
        }
    }

    /* compiled from: Socket.kt */
    public static final class SrtSocketOutputStream extends OutputStream {
        private final MsgCtrl msgCtrl;
        private final Socket socket;

        public SrtSocketOutputStream(Socket socket, MsgCtrl msgCtrl) {
            C3921.m12666(socket, "socket");
            this.socket = socket;
            this.msgCtrl = msgCtrl;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws SocketException {
            this.socket.close();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            write(new byte[]{(byte) i}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            C3921.m12666(bArr, "buffer");
            if (this.socket.isClose()) {
                throw new SocketException(ErrorType.ESCLOSED.toString());
            }
            Object sockFlag = this.socket.getSockFlag(SockOpt.MESSAGEAPI);
            if (sockFlag == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            if (!((Boolean) sockFlag).booleanValue()) {
                MsgCtrl msgCtrl = this.msgCtrl;
                if (msgCtrl != null) {
                    this.socket.send(bArr, i, i2, msgCtrl);
                    return;
                } else {
                    this.socket.send(bArr, i, i2);
                    return;
                }
            }
            Object sockFlag2 = this.socket.getSockFlag(SockOpt.PAYLOADSIZE);
            if (sockFlag2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            int iIntValue = ((Integer) sockFlag2).intValue();
            while (i2 > 0) {
                int iSend = this.msgCtrl != null ? this.socket.send(bArr, i, C4542.m13945(i2, iIntValue), this.msgCtrl) : this.socket.send(bArr, i, C4542.m13945(i2, iIntValue));
                i2 -= iSend;
                i += iSend;
            }
        }
    }

    static {
        Srt.INSTANCE.startUp();
    }

    public Socket(StandardProtocolFamily standardProtocolFamily) {
        C3921.m12666(standardProtocolFamily, "af");
        this.srtsocket = socket(standardProtocolFamily, 0, 0);
    }

    private final native int createSocket();

    public static /* synthetic */ InputStream getInputStream$default(Socket socket, MsgCtrl msgCtrl, int i, Object obj) {
        if ((i & 1) != 0) {
            msgCtrl = null;
        }
        return socket.getInputStream(msgCtrl);
    }

    public static /* synthetic */ OutputStream getOutputStream$default(Socket socket, MsgCtrl msgCtrl, int i, Object obj) {
        if ((i & 1) != 0) {
            msgCtrl = null;
        }
        return socket.getOutputStream(msgCtrl);
    }

    private final native Pair<Socket, InetSocketAddress> nativeAccept();

    private final native int nativeBind(InetSocketAddress inetSocketAddress);

    private final native int nativeClose();

    private final native int nativeConnect(InetSocketAddress inetSocketAddress);

    private final native long nativeGetConnectionTime();

    private final native InetSocketAddress nativeGetPeerName();

    private final native int nativeGetRejectReason();

    private final native Object nativeGetSockFlag(SockOpt sockOpt);

    private final native InetSocketAddress nativeGetSockName();

    private final native SockStatus nativeGetSockState();

    private final native boolean nativeIsValid();

    private final native int nativeListen(int i);

    private final native Pair<Integer, byte[]> nativeRecv(int i);

    private final native Pair<Integer, byte[]> nativeRecv(int i, MsgCtrl msgCtrl);

    private final native Pair<Integer, byte[]> nativeRecv(byte[] bArr, int i, int i2);

    private final native Pair<Integer, byte[]> nativeRecv(byte[] bArr, int i, int i2, MsgCtrl msgCtrl);

    private final native long nativeRecvFile(String str, long j, long j2, int i);

    public static /* synthetic */ long nativeRecvFile$default(Socket socket, String str, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 7280000;
        }
        return socket.nativeRecvFile(str, j, j2, i);
    }

    private final native int nativeRendezVous(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2);

    private final native int nativeSend(ByteBuffer byteBuffer, int i, int i2);

    private final native int nativeSend(ByteBuffer byteBuffer, int i, int i2, int i3, boolean z);

    private final native int nativeSend(ByteBuffer byteBuffer, int i, int i2, MsgCtrl msgCtrl);

    private final native int nativeSend(byte[] bArr, int i, int i2);

    private final native int nativeSend(byte[] bArr, int i, int i2, int i3, boolean z);

    private final native int nativeSend(byte[] bArr, int i, int i2, MsgCtrl msgCtrl);

    public static /* synthetic */ int nativeSend$default(Socket socket, ByteBuffer byteBuffer, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            i3 = -1;
        }
        int i5 = i3;
        if ((i4 & 16) != 0) {
            z = false;
        }
        return socket.nativeSend(byteBuffer, i, i2, i5, z);
    }

    private final native long nativeSendFile(String str, long j, long j2, int i);

    public static /* synthetic */ long nativeSendFile$default(Socket socket, String str, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 364000;
        }
        return socket.nativeSendFile(str, j, j2, i);
    }

    private final native int nativeSetRejectReason(int i);

    private final native int nativeSetSockFlag(SockOpt sockOpt, Object obj);

    private final void onConnect(Socket socket, ErrorType errorType, InetSocketAddress inetSocketAddress, int i) {
        SocketListener socketListener = this.listener;
        if (socketListener != null) {
            socketListener.onConnectionLost(socket, errorType, inetSocketAddress, i);
        }
    }

    private final int onListen(Socket socket, int i, InetSocketAddress inetSocketAddress, String str) {
        SocketListener socketListener = this.listener;
        if (socketListener != null) {
            return socketListener.onListen(socket, i, inetSocketAddress, str);
        }
        return 0;
    }

    public static /* synthetic */ Pair recv$default(Socket socket, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return socket.recv(bArr, i, i2);
    }

    public static /* synthetic */ long recvFile$default(Socket socket, String str, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i2 & 8) != 0) {
            i = 7280000;
        }
        return socket.recvFile(str, j3, j2, i);
    }

    public static /* synthetic */ int send$default(Socket socket, ByteBuffer byteBuffer, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return socket.send(byteBuffer, i, z);
    }

    public static /* synthetic */ long sendFile$default(Socket socket, String str, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i2 & 8) != 0) {
            i = 364000;
        }
        return socket.sendFile(str, j3, j2, i);
    }

    private final native int socket(StandardProtocolFamily standardProtocolFamily, int i, int i2);

    public final Pair<Socket, InetSocketAddress> accept() throws SocketException {
        Pair<Socket, InetSocketAddress> pairNativeAccept = nativeAccept();
        if (((Socket) pairNativeAccept.first).isValid()) {
            return pairNativeAccept;
        }
        throw new SocketException(Error.INSTANCE.getLastErrorMessage());
    }

    public final int available() throws IOException {
        Object sockFlag = getSockFlag(SockOpt.RCVDATA);
        if (sockFlag != null) {
            return ((Integer) sockFlag).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final void bind(InetSocketAddress inetSocketAddress) throws BindException {
        C3921.m12666(inetSocketAddress, "address");
        if (nativeBind(inetSocketAddress) != 0) {
            throw new BindException(Error.INSTANCE.getLastErrorMessage());
        }
    }

    public final native Stats bistats(boolean z, boolean z2);

    public final native Stats bstats(boolean z);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws SocketException {
        if (nativeClose() != 0) {
            throw new SocketException(Error.INSTANCE.getLastErrorMessage());
        }
    }

    public final void connect(InetSocketAddress inetSocketAddress) throws ConnectException {
        C3921.m12666(inetSocketAddress, "address");
        if (nativeConnect(inetSocketAddress) != 0) {
            throw new ConnectException(Error.INSTANCE.getLastErrorMessage());
        }
    }

    public final long getConnectionTime() throws SocketException {
        long jNativeGetConnectionTime = nativeGetConnectionTime();
        if (jNativeGetConnectionTime >= 0) {
            return jNativeGetConnectionTime;
        }
        throw new SocketException(Error.INSTANCE.getLastErrorMessage());
    }

    public final InetAddress getInetAddress() {
        InetAddress address = getPeerName().getAddress();
        C3921.m12665(address, "peerName.address");
        return address;
    }

    public final InputStream getInputStream(MsgCtrl msgCtrl) {
        return new SrtSocketInputStream(this, msgCtrl);
    }

    public final SocketListener getListener() {
        return this.listener;
    }

    public final InetAddress getLocalAddress() {
        InetAddress address = getSockName().getAddress();
        C3921.m12665(address, "sockName.address");
        return address;
    }

    public final int getLocalPort() {
        return getSockName().getPort();
    }

    public final OutputStream getOutputStream(MsgCtrl msgCtrl) {
        return new SrtSocketOutputStream(this, msgCtrl);
    }

    public final InetSocketAddress getPeerName() throws SocketException {
        InetSocketAddress inetSocketAddressNativeGetPeerName = nativeGetPeerName();
        if (inetSocketAddressNativeGetPeerName != null) {
            return inetSocketAddressNativeGetPeerName;
        }
        throw new SocketException(Error.INSTANCE.getLastErrorMessage());
    }

    public final int getPort() {
        return getPeerName().getPort();
    }

    public final int getReceiveBufferSize() throws IOException {
        Object sockFlag = getSockFlag(SockOpt.RCVBUF);
        if (sockFlag != null) {
            return ((Integer) sockFlag).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final RejectReason getRejectReason() {
        int iNativeGetRejectReason = nativeGetRejectReason();
        return iNativeGetRejectReason < 1000 ? new InternalRejectReason(RejectReasonCode.values()[iNativeGetRejectReason]) : iNativeGetRejectReason < 2000 ? new PredefinedRejectReason(iNativeGetRejectReason - 1000) : new UserDefinedRejectReason(iNativeGetRejectReason - 2000);
    }

    public final boolean getReuseAddress() throws IOException {
        Object sockFlag = getSockFlag(SockOpt.REUSEADDR);
        if (sockFlag != null) {
            return ((Boolean) sockFlag).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    public final int getSendBufferSize() throws IOException {
        Object sockFlag = getSockFlag(SockOpt.SNDBUF);
        if (sockFlag != null) {
            return ((Integer) sockFlag).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final int getSoLinger() throws IOException {
        Object sockFlag = getSockFlag(SockOpt.LINGER);
        if (sockFlag != null) {
            return ((Integer) sockFlag).intValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final Object getSockFlag(SockOpt sockOpt) throws IOException {
        C3921.m12666(sockOpt, "opt");
        Object objNativeGetSockFlag = nativeGetSockFlag(sockOpt);
        if (objNativeGetSockFlag != null) {
            return objNativeGetSockFlag;
        }
        throw new IOException(Error.INSTANCE.getLastErrorMessage());
    }

    public final InetSocketAddress getSockName() throws SocketException {
        InetSocketAddress inetSocketAddressNativeGetSockName = nativeGetSockName();
        if (inetSocketAddressNativeGetSockName != null) {
            return inetSocketAddressNativeGetSockName;
        }
        throw new SocketException(Error.INSTANCE.getLastErrorMessage());
    }

    public final SockStatus getSockState() {
        return nativeGetSockState();
    }

    public final boolean isBound() {
        return getSockState() == SockStatus.OPENED;
    }

    public final boolean isClose() {
        return getSockState() == SockStatus.CLOSED || getSockState() == SockStatus.NON_EXIST;
    }

    public final boolean isConnected() {
        return getSockState() == SockStatus.CONNECTED;
    }

    public final boolean isValid() {
        return nativeIsValid();
    }

    public final void listen(int i) throws SocketException {
        if (nativeListen(i) != 0) {
            throw new SocketException(Error.INSTANCE.getLastErrorMessage());
        }
    }

    public final Pair<Integer, byte[]> recv(int i) throws SocketException, SocketTimeoutException {
        Pair<Integer, byte[]> pairNativeRecv = nativeRecv(i);
        Integer num = (Integer) pairNativeRecv.first;
        if (num.intValue() < 0) {
            throw new SocketException(Error.INSTANCE.getLastErrorMessage());
        }
        if (num.intValue() != 0) {
            return pairNativeRecv;
        }
        throw new SocketTimeoutException(ErrorType.ESCLOSED.toString());
    }

    public final long recvFile(String str, long j, long j2, int i) throws SocketException, SocketTimeoutException {
        C3921.m12666(str, "path");
        long jNativeRecvFile = nativeRecvFile(str, j, j2, i);
        if (jNativeRecvFile < 0) {
            throw new SocketException(Error.INSTANCE.getLastErrorMessage());
        }
        if (jNativeRecvFile != 0) {
            return jNativeRecvFile;
        }
        throw new SocketTimeoutException(ErrorType.ESCLOSED.toString());
    }

    public final void rendezVous(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2) throws SocketException {
        C3921.m12666(inetSocketAddress, "localAddress");
        C3921.m12666(inetSocketAddress2, "remoteAddress");
        if (nativeRendezVous(inetSocketAddress, inetSocketAddress2) != 0) {
            throw new SocketException(Error.INSTANCE.getLastErrorMessage());
        }
    }

    public final int send(ByteBuffer byteBuffer) throws SocketException, SocketTimeoutException {
        C3921.m12666(byteBuffer, NotificationCompat.CATEGORY_MESSAGE);
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("msg must be a direct ByteBuffer".toString());
        }
        int iNativeSend = nativeSend(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
        if (iNativeSend < 0) {
            throw new SocketException(Error.INSTANCE.getLastErrorMessage());
        }
        if (iNativeSend != 0) {
            return iNativeSend;
        }
        throw new SocketTimeoutException(ErrorType.ESCLOSED.toString());
    }

    public final long sendFile(String str, long j, long j2, int i) throws SocketException, SocketTimeoutException {
        C3921.m12666(str, "path");
        long jNativeSendFile = nativeSendFile(str, j, j2, i);
        if (jNativeSendFile < 0) {
            throw new SocketException(Error.INSTANCE.getLastErrorMessage());
        }
        if (jNativeSendFile != 0) {
            return jNativeSendFile;
        }
        throw new SocketTimeoutException(ErrorType.ESCLOSED.toString());
    }

    public final void setListener(SocketListener socketListener) {
        this.listener = socketListener;
    }

    public final void setReceiveBufferSize(int i) throws IOException {
        setSockFlag(SockOpt.RCVBUF, Integer.valueOf(i));
    }

    public final void setRejectReason(RejectReason rejectReason) throws SocketException {
        C3921.m12666(rejectReason, "value");
        if (nativeSetRejectReason(rejectReason instanceof InternalRejectReason ? ((InternalRejectReason) rejectReason).getCode().ordinal() : rejectReason instanceof PredefinedRejectReason ? ((PredefinedRejectReason) rejectReason).getCode() + 1000 : rejectReason instanceof UserDefinedRejectReason ? ((UserDefinedRejectReason) rejectReason).getCode() + 2000 : RejectReasonCode.UNKNOWN.ordinal()) != 0) {
            throw new SocketException(Error.INSTANCE.getLastErrorMessage());
        }
    }

    public final void setReuseAddress(boolean z) throws IOException {
        setSockFlag(SockOpt.REUSEADDR, Boolean.valueOf(z));
    }

    public final void setSendBufferSize(int i) throws IOException {
        setSockFlag(SockOpt.SNDBUF, Integer.valueOf(i));
    }

    public final void setSoLinger(int i) throws IOException {
        setSockFlag(SockOpt.LINGER, Integer.valueOf(i));
    }

    public final void setSockFlag(SockOpt sockOpt, Object obj) throws IOException {
        C3921.m12666(sockOpt, "opt");
        C3921.m12666(obj, "value");
        if (nativeSetSockFlag(sockOpt, obj) != 0) {
            throw new IOException(Error.INSTANCE.getLastErrorMessage());
        }
    }

    public Socket() {
        this.srtsocket = createSocket();
    }

    public static /* synthetic */ int nativeSend$default(Socket socket, byte[] bArr, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            i3 = -1;
        }
        int i5 = i3;
        if ((i4 & 16) != 0) {
            z = false;
        }
        return socket.nativeSend(bArr, i, i2, i5, z);
    }

    public static /* synthetic */ Pair recv$default(Socket socket, byte[] bArr, int i, int i2, MsgCtrl msgCtrl, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return socket.recv(bArr, i, i2, msgCtrl);
    }

    public static /* synthetic */ long recvFile$default(Socket socket, File file, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i2 & 8) != 0) {
            i = 7280000;
        }
        return socket.recvFile(file, j3, j2, i);
    }

    public static /* synthetic */ int send$default(Socket socket, byte[] bArr, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            i3 = -1;
        }
        int i5 = i3;
        if ((i4 & 16) != 0) {
            z = false;
        }
        return socket.send(bArr, i, i2, i5, z);
    }

    public static /* synthetic */ long sendFile$default(Socket socket, File file, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i2 & 8) != 0) {
            i = 364000;
        }
        return socket.sendFile(file, j3, j2, i);
    }

    private Socket(int i) {
        this.srtsocket = i;
    }

    public static /* synthetic */ int send$default(Socket socket, byte[] bArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return socket.send(bArr, i, z);
    }

    public static /* synthetic */ long sendFile$default(Socket socket, File file, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 364000;
        }
        return socket.sendFile(file, i);
    }

    public final void bind(String str, int i) throws BindException {
        C3921.m12666(str, "address");
        bind(new InetSocketAddress(str, i));
    }

    public final void connect(String str, int i) throws ConnectException {
        C3921.m12666(str, "address");
        connect(new InetSocketAddress(str, i));
    }

    public final void rendezVous(String str, String str2, int i) throws SocketException {
        C3921.m12666(str, "localAddress");
        C3921.m12666(str2, "remoteAddress");
        rendezVous(new InetSocketAddress(str, i), new InetSocketAddress(str2, i));
    }

    public static /* synthetic */ int send$default(Socket socket, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return socket.send(str, i, z);
    }

    public final void bind(InetAddress inetAddress, int i) throws BindException {
        C3921.m12666(inetAddress, "address");
        bind(new InetSocketAddress(inetAddress, i));
    }

    public final void connect(InetAddress inetAddress, int i) throws ConnectException {
        C3921.m12666(inetAddress, "address");
        connect(new InetSocketAddress(inetAddress, i));
    }

    public final long recvFile(File file, long j, long j2, int i) {
        C3921.m12666(file, "file");
        String path = file.getPath();
        C3921.m12665(path, "file.path");
        return recvFile(path, j, j2, i);
    }

    public final long sendFile(File file, long j, long j2, int i) {
        C3921.m12666(file, "file");
        String path = file.getPath();
        C3921.m12665(path, "file.path");
        return sendFile(path, j, j2, i);
    }

    public final long sendFile(File file, int i) {
        C3921.m12666(file, "file");
        String path = file.getPath();
        C3921.m12665(path, "file.path");
        return sendFile(path, 0L, file.length(), i);
    }

    public final void rendezVous(InetAddress inetAddress, InetAddress inetAddress2, int i) throws SocketException {
        C3921.m12666(inetAddress, "localAddress");
        C3921.m12666(inetAddress2, "remoteAddress");
        rendezVous(new InetSocketAddress(inetAddress, i), new InetSocketAddress(inetAddress2, i));
    }

    public final int send(byte[] bArr, int i, int i2) throws SocketException, SocketTimeoutException {
        C3921.m12666(bArr, NotificationCompat.CATEGORY_MESSAGE);
        int iNativeSend = nativeSend(bArr, i, i2);
        if (iNativeSend < 0) {
            throw new SocketException(Error.INSTANCE.getLastErrorMessage());
        }
        if (iNativeSend != 0) {
            return iNativeSend;
        }
        throw new SocketTimeoutException(ErrorType.ESCLOSED.toString());
    }

    /* compiled from: Socket.kt */
    public static final class SrtSocketInputStream extends InputStream {
        private final MsgCtrl msgCtrl;
        private final Socket socket;

        public SrtSocketInputStream(Socket socket, MsgCtrl msgCtrl) {
            C3921.m12666(socket, "socket");
            this.socket = socket;
            this.msgCtrl = msgCtrl;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.socket.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws SocketException {
            this.socket.close();
        }

        @Override // java.io.InputStream
        public int read() {
            MsgCtrl msgCtrl = this.msgCtrl;
            Pair<Integer, byte[]> pairRecv = msgCtrl != null ? this.socket.recv(1, msgCtrl) : this.socket.recv(1);
            Integer num = (Integer) pairRecv.first;
            byte[] bArr = (byte[]) pairRecv.second;
            if (num.intValue() > 0) {
                return bArr[0];
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws SocketException, SocketTimeoutException {
            Pair<Integer, byte[]> pairRecv;
            C3921.m12666(bArr, "buffer");
            if (i2 == 0) {
                return 0;
            }
            MsgCtrl msgCtrl = this.msgCtrl;
            if (msgCtrl != null) {
                pairRecv = this.socket.recv(bArr, i, i2, msgCtrl);
            } else {
                pairRecv = this.socket.recv(bArr, i, i2);
            }
            Object obj = pairRecv.first;
            C3921.m12665(obj, "pair.first");
            return ((Number) obj).intValue();
        }
    }

    public final Pair<Integer, byte[]> recv(byte[] bArr, int i, int i2) throws SocketException, SocketTimeoutException {
        C3921.m12666(bArr, "buffer");
        Pair<Integer, byte[]> pairNativeRecv = nativeRecv(bArr, i, i2);
        Integer num = (Integer) pairNativeRecv.first;
        if (num.intValue() >= 0) {
            if (num.intValue() != 0) {
                return pairNativeRecv;
            }
            throw new SocketTimeoutException(ErrorType.ESCLOSED.toString());
        }
        throw new SocketException(Error.INSTANCE.getLastErrorMessage());
    }

    public final int send(byte[] bArr) {
        C3921.m12666(bArr, NotificationCompat.CATEGORY_MESSAGE);
        return send(bArr, 0, bArr.length);
    }

    public final int send(String str) {
        C3921.m12666(str, NotificationCompat.CATEGORY_MESSAGE);
        byte[] bytes = str.getBytes(C5241.f17365);
        C3921.m12665(bytes, "(this as java.lang.String).getBytes(charset)");
        return send(bytes);
    }

    public final int send(ByteBuffer byteBuffer, int i, boolean z) throws SocketException, SocketTimeoutException {
        C3921.m12666(byteBuffer, NotificationCompat.CATEGORY_MESSAGE);
        if (byteBuffer.isDirect()) {
            int iNativeSend = nativeSend(byteBuffer, byteBuffer.position(), byteBuffer.remaining(), i, z);
            if (iNativeSend < 0) {
                throw new SocketException(Error.INSTANCE.getLastErrorMessage());
            }
            if (iNativeSend != 0) {
                return iNativeSend;
            }
            throw new SocketTimeoutException(ErrorType.ESCLOSED.toString());
        }
        throw new IllegalArgumentException("msg must be a direct ByteBuffer".toString());
    }

    public final Pair<Integer, byte[]> recv(int i, MsgCtrl msgCtrl) throws SocketException, SocketTimeoutException {
        C3921.m12666(msgCtrl, "msgCtrl");
        Pair<Integer, byte[]> pairNativeRecv = nativeRecv(i, msgCtrl);
        Integer num = (Integer) pairNativeRecv.first;
        if (num.intValue() >= 0) {
            if (num.intValue() != 0) {
                return pairNativeRecv;
            }
            throw new SocketTimeoutException(ErrorType.ESCLOSED.toString());
        }
        throw new SocketException(Error.INSTANCE.getLastErrorMessage());
    }

    public final int send(byte[] bArr, int i, int i2, int i3, boolean z) throws SocketException, SocketTimeoutException {
        C3921.m12666(bArr, NotificationCompat.CATEGORY_MESSAGE);
        int iNativeSend = nativeSend(bArr, i, i2, i3, z);
        if (iNativeSend < 0) {
            throw new SocketException(Error.INSTANCE.getLastErrorMessage());
        }
        if (iNativeSend != 0) {
            return iNativeSend;
        }
        throw new SocketTimeoutException(ErrorType.ESCLOSED.toString());
    }

    public final Pair<Integer, byte[]> recv(byte[] bArr, int i, int i2, MsgCtrl msgCtrl) throws SocketException, SocketTimeoutException {
        C3921.m12666(bArr, "buffer");
        C3921.m12666(msgCtrl, "msgCtrl");
        Pair<Integer, byte[]> pairNativeRecv = nativeRecv(bArr, i, i2, msgCtrl);
        Integer num = (Integer) pairNativeRecv.first;
        if (num.intValue() >= 0) {
            if (num.intValue() != 0) {
                return pairNativeRecv;
            }
            throw new SocketTimeoutException(ErrorType.ESCLOSED.toString());
        }
        throw new SocketException(Error.INSTANCE.getLastErrorMessage());
    }

    public final int send(byte[] bArr, int i, boolean z) {
        C3921.m12666(bArr, NotificationCompat.CATEGORY_MESSAGE);
        return send(bArr, 0, bArr.length, i, z);
    }

    public final int send(String str, int i, boolean z) {
        C3921.m12666(str, NotificationCompat.CATEGORY_MESSAGE);
        byte[] bytes = str.getBytes(C5241.f17365);
        C3921.m12665(bytes, "(this as java.lang.String).getBytes(charset)");
        return send(bytes, i, z);
    }

    public final int send(ByteBuffer byteBuffer, MsgCtrl msgCtrl) throws SocketException, SocketTimeoutException {
        C3921.m12666(byteBuffer, NotificationCompat.CATEGORY_MESSAGE);
        C3921.m12666(msgCtrl, "msgCtrl");
        if (byteBuffer.isDirect()) {
            int iNativeSend = nativeSend(byteBuffer, byteBuffer.position(), byteBuffer.remaining(), msgCtrl);
            if (iNativeSend < 0) {
                throw new SocketException(Error.INSTANCE.getLastErrorMessage());
            }
            if (iNativeSend != 0) {
                return iNativeSend;
            }
            throw new SocketTimeoutException(ErrorType.ESCLOSED.toString());
        }
        throw new IllegalArgumentException("msg must be a direct ByteBuffer".toString());
    }

    public final int send(byte[] bArr, int i, int i2, MsgCtrl msgCtrl) throws SocketException, SocketTimeoutException {
        C3921.m12666(bArr, NotificationCompat.CATEGORY_MESSAGE);
        C3921.m12666(msgCtrl, "msgCtrl");
        int iNativeSend = nativeSend(bArr, i, i2, msgCtrl);
        if (iNativeSend < 0) {
            throw new SocketException(Error.INSTANCE.getLastErrorMessage());
        }
        if (iNativeSend != 0) {
            return iNativeSend;
        }
        throw new SocketTimeoutException(ErrorType.ESCLOSED.toString());
    }

    public final int send(byte[] bArr, MsgCtrl msgCtrl) {
        C3921.m12666(bArr, NotificationCompat.CATEGORY_MESSAGE);
        C3921.m12666(msgCtrl, "msgCtrl");
        return send(bArr, 0, bArr.length, msgCtrl);
    }

    public final int send(String str, MsgCtrl msgCtrl) {
        C3921.m12666(str, NotificationCompat.CATEGORY_MESSAGE);
        C3921.m12666(msgCtrl, "msgCtrl");
        byte[] bytes = str.getBytes(C5241.f17365);
        C3921.m12665(bytes, "(this as java.lang.String).getBytes(charset)");
        return send(bytes, msgCtrl);
    }
}
