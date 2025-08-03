package com.blink.academy.film.support.stream.ts;

import com.blink.academy.film.support.stream.ts.TsReceiver;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/* loaded from: classes.dex */
public class TsMulticastReceiver implements TsReceiver {
    public TsReceiver.DataCallback mDataCallback;
    public Thread mThread;
    public String groupHost = "230.198.112.0";
    public int port = 9876;
    public boolean released = false;

    public TsMulticastReceiver(TsReceiver.DataCallback dataCallback) {
        this.mDataCallback = dataCallback;
        Thread thread = new Thread(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsMulticastReceiver.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                TsMulticastReceiver.this.threadEntry();
            }
        });
        this.mThread = thread;
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void threadEntry() throws IOException {
        try {
            MulticastSocket multicastSocket = new MulticastSocket(this.port);
            InetAddress byName = InetAddress.getByName(this.groupHost);
            multicastSocket.joinGroup(byName);
            while (!this.released) {
                byte[] bArr = new byte[TsConstants.TS_PACKET_SIZE];
                multicastSocket.receive(new DatagramPacket(bArr, TsConstants.TS_PACKET_SIZE));
                int i = new TsPacket(bArr).mTsHeader.continuity_counter;
                TsReceiver.DataCallback dataCallback = this.mDataCallback;
                if (dataCallback != null) {
                    dataCallback.onDataReceived(bArr);
                }
            }
            multicastSocket.leaveGroup(byName);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.blink.academy.film.support.stream.ts.TsReceiver
    public void release() {
        this.released = true;
    }
}
