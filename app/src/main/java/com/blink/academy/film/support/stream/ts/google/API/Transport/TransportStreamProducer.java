package com.blink.academy.film.support.stream.ts.google.API.Transport;

import com.blink.academy.film.support.stream.ts.TsConstants;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.support.stream.ts.google.API.SITable;
import com.blink.academy.film.support.stream.ts.google.API.SITableRepository;
import com.blink.academy.film.support.stream.ts.google.API.Section;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class TransportStreamProducer implements Runnable {
    private static final int DEFAULT_SCHEDULE_TIME_GRANULARITY_MILLISEC = 100;
    public static final int DUMMY_PCR_PID = 2313;
    private boolean bPCR_generate;
    private long bitrate_per_sec;
    private long end_time_ms;
    private String name;
    private int num_of_null_packets_for_idle;
    private OutputStream output_pipe;
    private long schedule_time_granularity_ms;
    private TreeMap<Long, Integer> schedule_tree = new TreeMap<>();
    private long current_time_ms = 0;
    private long next_timeout_ms = 0;
    private int total_written_packets = 0;
    private TreeMap<Integer, Integer> continuity_counter_server = new TreeMap<>();
    private long program_clock_reference_base = 0;
    private long program_clock_reference_extension = 0;
    private int last_pcr_sent = 0;
    private volatile boolean threadSuspended = false;
    private volatile Thread runningThread = null;
    private byte[] null_packet_bytes = TransportPacketFactory.createMPEGNullPacket().toByteArray();

    public TransportStreamProducer(String str, long j, long j2, long j3, OutputStream outputStream, boolean z) {
        this.schedule_time_granularity_ms = 100L;
        this.end_time_ms = 0L;
        this.num_of_null_packets_for_idle = 0;
        this.output_pipe = null;
        this.bPCR_generate = false;
        this.name = new String(str);
        this.num_of_null_packets_for_idle = (int) ((j * j3) / 1504000);
        this.bitrate_per_sec = (r6 * 1504000) / j3;
        this.end_time_ms = j2;
        this.schedule_time_granularity_ms = j3;
        this.output_pipe = outputStream;
        this.bPCR_generate = z;
    }

    private synchronized boolean addScheduleRuntime(SITable sITable) {
        if (this.schedule_tree.containsValue(new Integer(sITable.getUniqueID()))) {
            return false;
        }
        long intervalMillis = sITable.getIntervalMillis();
        long j = this.current_time_ms;
        while (true) {
            intervalMillis += j;
            if (!this.schedule_tree.containsKey(new Long(intervalMillis))) {
                this.schedule_tree.put(new Long(intervalMillis), new Integer(sITable.getUniqueID()));
                updateNextTimeout();
                return true;
            }
            j = this.schedule_time_granularity_ms;
        }
    }

    private void checkPCRSend() throws IOException {
        if (this.bPCR_generate) {
            if (this.total_written_packets - this.last_pcr_sent < 1024) {
                return;
            }
            long j = this.program_clock_reference_base + ((((r0 - r1) * TsConstants.TS_PACKET_SIZE) * 27000) / this.bitrate_per_sec);
            writePCRPacket(j, 0L);
            this.program_clock_reference_base = j;
        }
    }

    private void doIdleWork() throws IOException {
        writeNullPacket(this.num_of_null_packets_for_idle);
    }

    private int updateContinuityCounter(TransportPacket transportPacket) {
        if (transportPacket.getPID() == 8191) {
            return 0;
        }
        boolean z = (transportPacket.getAdaptationFieldControl() == 0 || transportPacket.getAdaptationFieldControl() == 2) ? false : true;
        Integer num = new Integer(transportPacket.getPID());
        if (this.continuity_counter_server.containsKey(num)) {
            Integer numValueOf = Integer.valueOf(this.continuity_counter_server.get(num).intValue());
            if (z) {
                numValueOf = Integer.valueOf((numValueOf.intValue() + 1) % 16);
            }
            this.continuity_counter_server.put(num, numValueOf);
            transportPacket.setContinuityCounter(numValueOf.intValue());
        } else {
            this.continuity_counter_server.put(num, new Integer(0));
            transportPacket.setContinuityCounter(0);
        }
        return 0;
    }

    private void updateNextTimeout() {
        if (this.schedule_tree.isEmpty()) {
            return;
        }
        this.next_timeout_ms = this.schedule_tree.firstKey().longValue();
    }

    private void writeNullPacket(int i) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                this.output_pipe.write(this.null_packet_bytes);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        this.total_written_packets += i;
        checkPCRSend();
    }

    private void writePCRPacket(long j, long j2) throws IOException {
        try {
            this.output_pipe.write(TransportPacketFactory.createEmptyPCRPacket(DUMMY_PCR_PID, j, j2).toByteArray());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.total_written_packets++;
    }

    private int writeTable(SITable sITable) throws IOException {
        int i = 0;
        for (Section section : sITable.toSection()) {
            TransportPacket[] transportPacketArrGeneratePackets = TransportPacketGenerator.generatePackets(section);
            for (int i2 = 0; i2 < transportPacketArrGeneratePackets.length; i2++) {
                updateContinuityCounter(transportPacketArrGeneratePackets[i2]);
                try {
                    this.output_pipe.write(transportPacketArrGeneratePackets[i2].toByteArray());
                    i++;
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        this.total_written_packets += i;
        checkPCRSend();
        return i;
    }

    public synchronized boolean addSchedule(SITable sITable) {
        if (this.schedule_tree.containsValue(new Integer(sITable.getUniqueID()))) {
            return false;
        }
        long intervalMillis = sITable.getIntervalMillis();
        long startTime = sITable.getStartTime();
        while (true) {
            intervalMillis += startTime;
            if (!this.schedule_tree.containsKey(new Long(intervalMillis))) {
                this.schedule_tree.put(new Long(intervalMillis), new Integer(sITable.getUniqueID()));
                updateNextTimeout();
                return true;
            }
            startTime = this.schedule_time_granularity_ms;
        }
    }

    public void debugDump() {
        System.out.println("CurrentTime: " + this.current_time_ms);
        for (Map.Entry<Long, Integer> entry : this.schedule_tree.entrySet()) {
            SITable table = SITableRepository.getTable(entry.getValue().intValue());
            if (table == null) {
                System.out.println("timeout: " + entry.getKey() + ", but deleted in repository.");
            } else {
                System.out.println("timeout: " + entry.getKey() + ", " + table.getTableID() + MyUTIL.white_space + table.getUniqueID());
            }
        }
        System.out.println();
    }

    public long getBitrate() {
        return this.bitrate_per_sec;
    }

    public String getName() {
        return this.name;
    }

    public int getNumPktsForSchedule() {
        return this.num_of_null_packets_for_idle;
    }

    public void join() throws InterruptedException {
        try {
            this.runningThread.join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public synchronized void pause() {
        if (this.threadSuspended) {
            return;
        }
        this.threadSuspended = true;
    }

    public synchronized boolean removeSchedule(SITable sITable) {
        int uniqueID = sITable.getUniqueID();
        for (Map.Entry<Long, Integer> entry : this.schedule_tree.entrySet()) {
            if (entry.getValue().intValue() == uniqueID) {
                this.schedule_tree.remove(entry.getKey());
                return true;
            }
        }
        return false;
    }

    public synchronized void resume() {
        if (this.threadSuspended) {
            return;
        }
        this.threadSuspended = true;
        notify();
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        Thread threadCurrentThread = Thread.currentThread();
        while (threadCurrentThread == this.runningThread && this.current_time_ms < this.end_time_ms) {
            synchronized (this) {
                while (this.threadSuspended && this.runningThread == threadCurrentThread) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
            long j = this.current_time_ms;
            if (j / 1000 != (j + this.schedule_time_granularity_ms) / 1000) {
                System.out.println(((this.current_time_ms / 1000) + 1) + " sec..");
            }
            this.current_time_ms += this.schedule_time_granularity_ms;
            if (this.schedule_tree.size() <= 0 || this.current_time_ms <= this.next_timeout_ms) {
                doIdleWork();
            } else {
                int iWriteTable = 0;
                while (this.schedule_tree.size() > 0 && this.current_time_ms > this.next_timeout_ms) {
                    SITable table = SITableRepository.getTable(this.schedule_tree.pollFirstEntry().getValue().intValue());
                    if (table != null) {
                        if (this.current_time_ms < table.getEndTime()) {
                            iWriteTable += writeTable(table);
                            addScheduleRuntime(table);
                        }
                        updateNextTimeout();
                    }
                }
                writeNullPacket(this.num_of_null_packets_for_idle - iWriteTable);
            }
        }
        System.out.println("TS generation is done.");
    }

    public synchronized void start() {
        if (this.runningThread != null) {
            return;
        }
        this.threadSuspended = false;
        this.runningThread = new Thread(this);
        this.runningThread.start();
    }

    public synchronized void stop() {
        this.runningThread = null;
    }
}
