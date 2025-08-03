package com.blink.academy.film.support.socket.sender;

import com.blink.academy.film.bean.socket.SocketMessage;
import com.blink.academy.film.support.socket.SocketHelper;
import defpackage.C3973;
import defpackage.C4638;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

/* loaded from: classes.dex */
public class Broadcaster {
    private final InetAddress inetAddress;
    private boolean isServer;
    private final int mPort;
    private final InetAddress multiCastAddress;
    private Sender multicastSender;
    private MulticastSocket multicastSocket;
    private Sender p2PSender;
    private InetAddress p2pAddress;
    private DatagramSocket p2pSocket;
    private Sender sender;
    private DatagramSocket socket;

    public Broadcaster(InetAddress inetAddress, InetAddress inetAddress2, InetAddress inetAddress3, int i) {
        this.inetAddress = inetAddress;
        this.mPort = i;
        this.multiCastAddress = inetAddress2;
        this.p2pAddress = inetAddress3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] initSenderMessage() {
        SocketMessage socketMessage = new SocketMessage();
        socketMessage.m498(C3973.m12823());
        socketMessage.m501(C3973.m12822());
        socketMessage.m497(System.currentTimeMillis());
        socketMessage.m499(this.isServer ? 1 : 0);
        return SocketHelper.getSenderMessage(socketMessage);
    }

    private void startBroadCastSender() {
        try {
            this.socket = new DatagramSocket();
            this.sender = new Sender(this.socket, new InetSocketAddress(this.inetAddress, this.mPort), 200) { // from class: com.blink.academy.film.support.socket.sender.Broadcaster.1
                @Override // com.blink.academy.film.support.socket.sender.Sender
                public byte[] getNextData() {
                    return Broadcaster.this.initSenderMessage();
                }
            };
            new Thread(this.sender).start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void startMultiCastSender() throws IOException {
        try {
            MulticastSocket multicastSocket = new MulticastSocket(this.mPort);
            this.multicastSocket = multicastSocket;
            multicastSocket.setTimeToLive(1);
            this.multicastSocket.joinGroup(this.multiCastAddress);
            this.multicastSender = new Sender(this.multicastSocket, this.multiCastAddress, 200, this.mPort) { // from class: com.blink.academy.film.support.socket.sender.Broadcaster.3
                @Override // com.blink.academy.film.support.socket.sender.Sender
                public byte[] getNextData() {
                    return Broadcaster.this.initSenderMessage();
                }
            };
            new Thread(this.multicastSender).start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void startP2PSender() {
        try {
            this.p2pSocket = new DatagramSocket();
            this.p2PSender = new Sender(this.p2pSocket, this.p2pAddress, 200, this.mPort) { // from class: com.blink.academy.film.support.socket.sender.Broadcaster.2
                @Override // com.blink.academy.film.support.socket.sender.Sender
                public byte[] getNextData() {
                    return Broadcaster.this.initSenderMessage();
                }
            };
            new Thread(this.p2PSender).start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void close() {
        if (this.socket != null) {
            Sender sender = this.sender;
            if (sender != null) {
                sender.setRunning(false);
            }
            this.socket.close();
        }
        if (this.multicastSocket != null) {
            Sender sender2 = this.multicastSender;
            if (sender2 != null) {
                sender2.setRunning(false);
            }
            this.multicastSocket.close();
        }
        if (this.p2pSocket != null) {
            Sender sender3 = this.p2PSender;
            if (sender3 != null) {
                sender3.setRunning(false);
            }
            this.p2pSocket.close();
        }
        C4638.m14101("WME", "BroadCast is stop send.");
    }

    public void start(int i, boolean z) throws IOException {
        this.isServer = z;
        if (i == 0) {
            startBroadCastSender();
            startMultiCastSender();
            startP2PSender();
        } else if (i == 1) {
            startBroadCastSender();
        } else {
            if (i != 3) {
                return;
            }
            startP2PSender();
        }
    }
}
