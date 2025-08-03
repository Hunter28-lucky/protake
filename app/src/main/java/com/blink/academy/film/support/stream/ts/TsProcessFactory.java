package com.blink.academy.film.support.stream.ts;

import android.os.Handler;
import android.os.HandlerThread;
import com.blink.academy.film.support.stream.ts.PatPacket;
import com.blink.academy.film.support.stream.ts.PmtPacket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public class TsProcessFactory {
    private Runnable delayRunnable;
    public int elementaryPid;
    private DataCallback mDataCallback;
    public PatPacket mPatPacket;
    public PmtPacket mPmtPacket;
    private Handler mProcessHandler;
    private HandlerThread mProcessThread;
    private ArrayList<TsPacketMerger> mTsPacketMergers;
    private ArrayList<TsPacket> oneFrame;
    public int pmtId;
    public byte streamType;
    public LinkedBlockingQueue<TsPacket> mLinkedBlockingQueue = new LinkedBlockingQueue<>();
    public int needStreamType = -1;
    public int lastCc = -1;

    public interface DataCallback {
        void onStreamReceive(List<PmtPacket.Stream> list);
    }

    public static abstract class TsPacketMerger {
        private boolean abort = false;
        public int lastCc = -1;
        private int needPid;
        private ArrayList<TsPacket> oneFrame;
        private byte streamType;

        public TsPacketMerger(byte b, int i) {
            this.streamType = b;
            this.needPid = i;
        }

        public abstract void onPacketProcessFinish(EsPacket esPacket);

        public void process(TsPacket tsPacket) {
            ArrayList<TsPacket> arrayList;
            TsHeader tsHeader = tsPacket.mTsHeader;
            if (tsHeader.pid == this.needPid) {
                int i = tsHeader.continuity_counter;
                int i2 = this.lastCc;
                if (i2 != -1) {
                    int i3 = ((i + 16) - i2) % 16;
                    if (this.streamType == 36 && i3 != 1) {
                        this.abort = true;
                    }
                }
                this.lastCc = i;
                if (tsHeader.payload_unit_start_indicator == 1) {
                    if (!this.abort && (arrayList = this.oneFrame) != null && arrayList.size() > 0) {
                        Iterator<EsPacket> it = TsParser.mergeToPes(this.streamType, this.oneFrame).iterator();
                        while (it.hasNext()) {
                            onPacketProcessFinish(it.next());
                        }
                    }
                    this.oneFrame = new ArrayList<>();
                    this.abort = false;
                }
                ArrayList<TsPacket> arrayList2 = this.oneFrame;
                if (arrayList2 != null) {
                    arrayList2.add(tsPacket);
                }
            }
        }
    }

    public TsProcessFactory() {
        HandlerThread handlerThread = new HandlerThread("TsProcessThread");
        this.mProcessThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.mProcessThread.getLooper());
        this.mProcessHandler = handler;
        handler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsProcessFactory.1
            @Override // java.lang.Runnable
            public void run() {
                TsProcessFactory.this.mTsPacketMergers = new ArrayList();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processTsPacket() {
        int i;
        while (this.mLinkedBlockingQueue.peek() != null) {
            TsPacket tsPacketPoll = this.mLinkedBlockingQueue.poll();
            if (tsPacketPoll != null) {
                Runnable runnable = this.delayRunnable;
                if (runnable != null) {
                    runnable.run();
                }
                tsPacketPoll.refreshHeader();
                TsHeader tsHeader = tsPacketPoll.mTsHeader;
                if (tsHeader.pid == 0) {
                    PatPacket patPacket = new PatPacket(tsPacketPoll.mBytes, tsHeader.payload_unit_start_indicator == 1 ? 5 : 4);
                    this.mPatPacket = patPacket;
                    for (PatPacket.Program program : patPacket.mPrograms) {
                        if (program.program_number == 1) {
                            this.pmtId = program.PID;
                        }
                    }
                }
                if (this.mPatPacket != null && (i = this.pmtId) != 0 && tsHeader.pid == i) {
                    PmtPacket pmtPacket = new PmtPacket(tsPacketPoll.mBytes, tsHeader.payload_unit_start_indicator != 1 ? 4 : 5);
                    this.mPmtPacket = pmtPacket;
                    List<PmtPacket.Stream> list = pmtPacket.mStreams;
                    DataCallback dataCallback = this.mDataCallback;
                    if (dataCallback != null) {
                        dataCallback.onStreamReceive(list);
                    }
                    ArrayList arrayList = new ArrayList();
                    for (PmtPacket.Stream stream : list) {
                        arrayList.add(Integer.valueOf(stream.stream_type));
                        int i2 = this.needStreamType;
                        if (i2 != -1) {
                            byte b = stream.stream_type;
                            if (b == i2) {
                                this.streamType = b;
                                this.elementaryPid = stream.elementary_PID;
                            }
                        } else {
                            this.elementaryPid = 0;
                        }
                    }
                }
                Iterator<TsPacketMerger> it = this.mTsPacketMergers.iterator();
                while (it.hasNext()) {
                    TsPacketMerger next = it.next();
                    if (tsHeader.pid == next.needPid) {
                        next.process(tsPacketPoll);
                    }
                }
            }
        }
    }

    public void addData(byte[] bArr) {
        this.mLinkedBlockingQueue.add(new TsPacket(bArr));
        this.mProcessHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsProcessFactory.2
            @Override // java.lang.Runnable
            public void run() {
                TsProcessFactory.this.processTsPacket();
            }
        });
    }

    public void addTsPacketMerger(final TsPacketMerger tsPacketMerger) {
        this.mProcessHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsProcessFactory.4
            @Override // java.lang.Runnable
            public void run() {
                TsProcessFactory.this.mTsPacketMergers.add(tsPacketMerger);
            }
        });
    }

    public void destroy() {
        LinkedBlockingQueue<TsPacket> linkedBlockingQueue = this.mLinkedBlockingQueue;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
        }
        this.mProcessThread.quitSafely();
    }

    public void removeTsPacketMerger(final TsPacketMerger tsPacketMerger) {
        this.mProcessHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsProcessFactory.5
            @Override // java.lang.Runnable
            public void run() {
                TsProcessFactory.this.mTsPacketMergers.remove(tsPacketMerger);
            }
        });
    }

    public TsProcessFactory setDataCallback(DataCallback dataCallback) {
        this.mDataCallback = dataCallback;
        return this;
    }

    public void setNeedStreamType(final int i) {
        this.delayRunnable = new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsProcessFactory.3
            @Override // java.lang.Runnable
            public void run() {
                TsProcessFactory.this.needStreamType = i;
            }
        };
    }
}
