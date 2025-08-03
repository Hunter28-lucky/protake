package com.blink.academy.film.support.stream.ts.google.Test;

import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DC_ServiceLocation;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.Descriptor;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorFactory;
import com.blink.academy.film.support.stream.ts.google.API.Descriptor.DescriptorTag;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PAT;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PMT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCTChannel;
import com.blink.academy.film.support.stream.ts.google.API.SITableFactory;
import com.blink.academy.film.support.stream.ts.google.API.ServiceType;
import com.blink.academy.film.support.stream.ts.google.API.StreamType;
import com.blink.academy.film.support.stream.ts.google.API.TableType;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.Random;

/* loaded from: classes.dex */
public class ATSCTestStreamGen {
    public static int NUM_LOCATIONS = 50;
    public static long m_bitrate = 19400000;
    public static long m_stream_length_ms = 15 * 1000;
    public static long m_stream_seconds = 15;
    public int m_global_source_id = 1;
    public Location[] m_locations;

    public class Location {
        public int major_number;
        public MGT mgt;
        public int num_channels;
        public PAT pat;
        public PMT[] pmts;
        public DC_ServiceLocation svc_loc_desc;
        public int ts_id;
        public TVCT tvct;

        public Location(int i, int i2, int i3) {
            this.pat = null;
            this.pmts = null;
            this.mgt = null;
            this.tvct = null;
            this.svc_loc_desc = null;
            this.ts_id = i;
            this.num_channels = i2;
            this.major_number = i3;
            Random random = new Random();
            int i4 = 32;
            this.pat = SITableFactory.createPAT(random.nextInt(32), this.ts_id);
            this.tvct = SITableFactory.createTVCT(random.nextInt(32), this.ts_id);
            this.pmts = new PMT[this.num_channels];
            int i5 = 500;
            int i6 = 600;
            int i7 = 0;
            while (i7 < this.num_channels) {
                int i8 = i7 + 1;
                this.pmts[i7] = SITableFactory.createPMT(i7 + 200, random.nextInt(i4), i8, i7 + 100);
                PMT pmt = this.pmts[i7];
                StreamType streamType = StreamType.ISO_IEC_11172_Video;
                pmt.addStream(SITableFactory.createPMTStream(streamType, i5));
                PMT pmt2 = this.pmts[i7];
                StreamType streamType2 = StreamType.ISO_IEC_11172_Audio;
                pmt2.addStream(SITableFactory.createPMTStream(streamType2, i6));
                this.pat.addProgram(SITableFactory.createPATProgram(this.pmts[i7].getProgramNumber(), this.pmts[i7].getTablePID()));
                char[] charArray = ("CH" + Integer.toString(i3) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Integer.toString(i8)).toCharArray();
                int programNumber = this.pmts[i7].getProgramNumber();
                ServiceType serviceType = ServiceType.ATSC_DIGITAL_TELEVISION;
                int i9 = ATSCTestStreamGen.this.m_global_source_id;
                ATSCTestStreamGen.this.m_global_source_id = i9 + 1;
                TVCTChannel tVCTChannelCreateTVCTChannel = SITableFactory.createTVCTChannel(charArray, i3, i8, 4, 0, programNumber, serviceType, i9);
                tVCTChannelCreateTVCTChannel.setChannelTSID(this.ts_id);
                DC_ServiceLocation dC_ServiceLocationCreateServiceLocation = DescriptorFactory.createServiceLocation();
                this.svc_loc_desc = dC_ServiceLocationCreateServiceLocation;
                dC_ServiceLocationCreateServiceLocation.addElement(streamType, i5, 7040882);
                this.svc_loc_desc.addElement(streamType2, i6, 7040882);
                Descriptor descriptorCreateDescriptor = DescriptorFactory.createDescriptor(DescriptorTag.SERVICE_LOCATION);
                descriptorCreateDescriptor.setContent(this.svc_loc_desc);
                tVCTChannelCreateTVCTChannel.addDescriptor(descriptorCreateDescriptor);
                this.tvct.addChannel(tVCTChannelCreateTVCTChannel);
                i5++;
                i6++;
                i7 = i8;
                i4 = 32;
            }
            MGT mgtCreateMGT = SITableFactory.createMGT(random.nextInt(i4));
            this.mgt = mgtCreateMGT;
            mgtCreateMGT.addTable(SITableFactory.createMGTTable(TableType.Terrestrial_VCT_with_current_next_indicator_1, this.tvct.getTablePID(), this.tvct.getTableVersion(), 0));
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00c5 A[Catch: IOException -> 0x00d5, LOOP:2: B:26:0x00c0->B:28:0x00c5, LOOP_END, TryCatch #0 {IOException -> 0x00d5, blocks: (B:25:0x009b, B:26:0x00c0, B:28:0x00c5, B:29:0x00d1), top: B:42:0x009b }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00fc A[LOOP:3: B:34:0x00f7->B:36:0x00fc, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0148 A[LOOP:4: B:38:0x0143->B:40:0x0148, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00d1 A[EDGE_INSN: B:50:0x00d1->B:29:0x00d1 BREAK  A[LOOP:2: B:26:0x00c0->B:28:0x00c5], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0104 A[EDGE_INSN: B:51:0x0104->B:37:0x0104 BREAK  A[LOOP:3: B:34:0x00f7->B:36:0x00fc], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0150 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void fileGenerate() throws java.lang.InterruptedException, java.io.IOException {
            /*
                Method dump skipped, instructions count: 337
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.support.stream.ts.google.Test.ATSCTestStreamGen.Location.fileGenerate():void");
        }

        public String fileName() {
            return ("atsc_ts(0x" + Integer.toHexString(this.ts_id) + ")") + "_ch(" + Integer.toString(this.major_number) + ".1~" + Integer.toString(this.num_channels) + ")";
        }
    }

    public ATSCTestStreamGen() {
        this.m_locations = null;
        Random random = new Random();
        this.m_locations = new Location[NUM_LOCATIONS];
        int i = 0;
        while (i < NUM_LOCATIONS) {
            int i2 = i + 1;
            this.m_locations[i] = new Location(i2, random.nextInt(i2) + 1, i2);
            System.out.println(this.m_locations[i].fileName());
            i = i2;
        }
    }

    public static void main(String[] strArr) throws InterruptedException, IOException {
        if (strArr.length < 2) {
            System.out.println();
            System.out.println("Usage:  java -jar atsc_ts_generator.jar <num_streams> <duration_secs> [bitrate]");
            System.out.println();
            System.out.println("        <num_streams> : the number of streams to generate");
            System.out.println("        <duration_secs> : stream length in seconds");
            System.out.println("        [duration_secs] : bitrates(optional). default is '19400000'.");
            System.out.println();
            return;
        }
        ATSCTestStreamGen aTSCTestStreamGen = new ATSCTestStreamGen();
        NUM_LOCATIONS = Integer.valueOf(strArr[0]).intValue();
        m_stream_seconds = Integer.valueOf(strArr[1]).intValue();
        if (strArr.length > 2) {
            m_bitrate = Integer.valueOf(strArr[2]).intValue();
        }
        m_stream_length_ms = m_stream_seconds * 1000;
        for (int i = 0; i < NUM_LOCATIONS; i++) {
            aTSCTestStreamGen.getLocation(i).fileGenerate();
        }
    }

    public Location getLocation(int i) {
        return this.m_locations[i];
    }
}
