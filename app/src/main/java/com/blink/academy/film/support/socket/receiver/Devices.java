package com.blink.academy.film.support.socket.receiver;

import com.blink.academy.film.bean.socket.SocketAddressBean;
import com.blink.academy.film.bean.socket.SocketMessage;
import com.blink.academy.film.support.socket.SocketHelper;
import com.blink.academy.film.support.socket.sender.Sender;
import defpackage.C4638;
import defpackage.r1;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/* loaded from: classes.dex */
public class Devices {
    private Receiver broadCastReceiver;
    private InetAddress multiCastAddress;
    private Receiver multicastReceiver;
    private MulticastSocket multicastSocket;
    private Receiver p2pReceiver;
    private DatagramSocket p2pSocket;
    private int port;
    private Receiver receiver;
    private Sender sender;
    private DatagramSocket socket;

    public interface OnSocketReceiveListener {
        void onReceived(SocketAddressBean socketAddressBean);
    }

    public Devices(InetAddress inetAddress, int i) {
        this.multiCastAddress = inetAddress;
        this.port = i;
    }

    private void broadCastReceiver(final OnSocketReceiveListener onSocketReceiveListener) throws SocketException {
        try {
            this.socket = new DatagramSocket(this.port);
            this.broadCastReceiver = new Receiver(this.socket) { // from class: com.blink.academy.film.support.socket.receiver.Devices.1
                @Override // com.blink.academy.film.support.socket.receiver.Receiver
                public boolean handlePacket(DatagramPacket datagramPacket) {
                    Devices.this.receiveMessage(datagramPacket, onSocketReceiveListener);
                    return true;
                }
            };
            startBroadCastThread();
            DatagramSocket datagramSocket = this.socket;
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    private SocketMessage initReceiverMessage(byte[] bArr) {
        return SocketHelper.getReceiveMessage(bArr);
    }

    private void multiCastReceiver(final OnSocketReceiveListener onSocketReceiveListener) {
        try {
            this.multicastSocket = new MulticastSocket(this.port);
            this.multicastReceiver = new Receiver(this.multicastSocket, this.multiCastAddress) { // from class: com.blink.academy.film.support.socket.receiver.Devices.3
                @Override // com.blink.academy.film.support.socket.receiver.Receiver
                public boolean handlePacket(DatagramPacket datagramPacket) {
                    Devices.this.receiveMessage(datagramPacket, onSocketReceiveListener);
                    return true;
                }
            };
            startMultiCastThread();
            MulticastSocket multicastSocket = this.multicastSocket;
            if (multicastSocket != null) {
                multicastSocket.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void p2pReceiver(final OnSocketReceiveListener onSocketReceiveListener) {
        try {
            this.p2pSocket = new DatagramSocket(this.port);
            this.p2pReceiver = new Receiver(this.p2pSocket) { // from class: com.blink.academy.film.support.socket.receiver.Devices.2
                @Override // com.blink.academy.film.support.socket.receiver.Receiver
                public boolean handlePacket(DatagramPacket datagramPacket) {
                    Devices.this.receiveMessage(datagramPacket, onSocketReceiveListener);
                    return true;
                }
            };
            startP2PThread();
            DatagramSocket datagramSocket = this.p2pSocket;
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receiveMessage(DatagramPacket datagramPacket, OnSocketReceiveListener onSocketReceiveListener) {
        SocketMessage socketMessageInitReceiverMessage = initReceiverMessage(datagramPacket.getData());
        if (r1.m8142(socketMessageInitReceiverMessage)) {
            SocketAddressBean socketAddressBean = new SocketAddressBean();
            String strM494 = socketMessageInitReceiverMessage.m494();
            socketAddressBean.m491(strM494);
            socketMessageInitReceiverMessage.m498(strM494);
            socketAddressBean.m492(socketMessageInitReceiverMessage);
            if (onSocketReceiveListener != null) {
                onSocketReceiveListener.onReceived(socketAddressBean);
            }
        }
    }

    private void startBroadCastThread() throws InterruptedException {
        if (this.broadCastReceiver != null) {
            Thread thread = new Thread(this.broadCastReceiver);
            thread.start();
            thread.join();
        }
    }

    private void startMultiCastThread() throws InterruptedException {
        if (this.multicastReceiver != null) {
            Thread thread = new Thread(this.multicastReceiver);
            thread.start();
            thread.join();
        }
    }

    private void startP2PThread() throws InterruptedException {
        if (this.p2pReceiver != null) {
            Thread thread = new Thread(this.p2pReceiver);
            thread.start();
            thread.join();
        }
    }

    public void close() {
        stop();
        DatagramSocket datagramSocket = this.socket;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
        MulticastSocket multicastSocket = this.multicastSocket;
        if (multicastSocket != null) {
            multicastSocket.close();
        }
    }

    public void start(int i, OnSocketReceiveListener onSocketReceiveListener) throws SocketException, InterruptedException {
        if (i == 0) {
            broadCastReceiver(onSocketReceiveListener);
            multiCastReceiver(onSocketReceiveListener);
            p2pReceiver(onSocketReceiveListener);
        } else if (i == 1) {
            broadCastReceiver(onSocketReceiveListener);
        } else if (i == 2) {
            multiCastReceiver(onSocketReceiveListener);
        } else {
            if (i != 3) {
                return;
            }
            p2pReceiver(onSocketReceiveListener);
        }
    }

    public void stop() {
        Receiver receiver = this.broadCastReceiver;
        if (receiver != null) {
            receiver.setRunning(false);
        }
        Receiver receiver2 = this.multicastReceiver;
        if (receiver2 != null) {
            receiver2.setRunning(false);
        }
        C4638.m14101("WME", "Device is stop receive.");
    }
}
