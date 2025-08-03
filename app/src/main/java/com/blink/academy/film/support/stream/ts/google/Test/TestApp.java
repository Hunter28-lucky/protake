package com.blink.academy.film.support.stream.ts.google.Test;

import androidx.core.view.InputDeviceCompat;
import com.blink.academy.film.support.stream.ts.TsConstants;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PAT;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PMT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCTChannel;
import com.blink.academy.film.support.stream.ts.google.API.SITableFactory;
import com.blink.academy.film.support.stream.ts.google.API.SITableRepository;
import com.blink.academy.film.support.stream.ts.google.API.ServiceType;
import com.blink.academy.film.support.stream.ts.google.API.StreamType;
import com.blink.academy.film.support.stream.ts.google.API.TableType;
import com.blink.academy.film.support.stream.ts.google.API.Transport.TransportStreamProducer;
import com.umeng.analytics.pro.o;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public class TestApp {
    public static void main(String[] strArr) {
        FileOutputStream fileOutputStream;
        PMT pmtCreatePMT = SITableFactory.createPMT(1001, 2, 53, 0);
        StreamType streamType = StreamType.ISO_IEC_11172_Video;
        pmtCreatePMT.addStream(SITableFactory.createPMTStream(streamType, 257));
        StreamType streamType2 = StreamType.ISO_IEC_11172_Audio;
        pmtCreatePMT.addStream(SITableFactory.createPMTStream(streamType2, TsConstants.kTS_PID_Data));
        PMT pmtCreatePMT2 = SITableFactory.createPMT(1002, 3, 101, 0);
        pmtCreatePMT2.addStream(SITableFactory.createPMTStream(streamType, InputDeviceCompat.SOURCE_DPAD));
        pmtCreatePMT2.addStream(SITableFactory.createPMTStream(streamType2, 514));
        PAT patCreatePAT = SITableFactory.createPAT(1, 2748);
        patCreatePAT.addProgram(SITableFactory.createPATProgram(pmtCreatePMT.getProgramNumber(), pmtCreatePMT.getTablePID()));
        patCreatePAT.addProgram(SITableFactory.createPATProgram(pmtCreatePMT2.getProgramNumber(), pmtCreatePMT2.getTablePID()));
        TVCT tvctCreateTVCT = SITableFactory.createTVCT(8, 2748);
        char[] charArray = new String("prog1").toCharArray();
        int programNumber = pmtCreatePMT.getProgramNumber();
        ServiceType serviceType = ServiceType.ATSC_DIGITAL_TELEVISION;
        TVCTChannel tVCTChannelCreateTVCTChannel = SITableFactory.createTVCTChannel(charArray, 11, 1, 4, o.a.l, programNumber, serviceType, 1281);
        TVCTChannel tVCTChannelCreateTVCTChannel2 = SITableFactory.createTVCTChannel(new String("prog2").toCharArray(), 9, 1, 4, 2305, pmtCreatePMT2.getProgramNumber(), serviceType, 1282);
        tvctCreateTVCT.addChannel(tVCTChannelCreateTVCTChannel);
        tvctCreateTVCT.addChannel(tVCTChannelCreateTVCTChannel2);
        MGT mgtCreateMGT = SITableFactory.createMGT(4);
        mgtCreateMGT.addTable(SITableFactory.createMGTTable(TableType.Terrestrial_VCT_with_current_next_indicator_1, tvctCreateTVCT.getTablePID(), tvctCreateTVCT.getTableVersion(), 0));
        patCreatePAT.setEndTime(15000L);
        pmtCreatePMT.setEndTime(15000L);
        pmtCreatePMT2.setEndTime(15000L);
        mgtCreateMGT.setEndTime(15000L);
        tvctCreateTVCT.setEndTime(15000L);
        SITableRepository.addTable(patCreatePAT);
        SITableRepository.addTable(pmtCreatePMT);
        SITableRepository.addTable(pmtCreatePMT2);
        SITableRepository.addTable(mgtCreateMGT);
        SITableRepository.addTable(tvctCreateTVCT);
        try {
            fileOutputStream = new FileOutputStream("example.ts");
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            fileOutputStream = null;
        }
        TransportStreamProducer transportStreamProducer = new TransportStreamProducer("ATSC_Streamer", 19400000L, 15000L, 10L, fileOutputStream, true);
        System.out.println(transportStreamProducer.getBitrate());
        transportStreamProducer.addSchedule(patCreatePAT);
        transportStreamProducer.addSchedule(pmtCreatePMT);
        transportStreamProducer.addSchedule(pmtCreatePMT2);
        transportStreamProducer.addSchedule(mgtCreateMGT);
        transportStreamProducer.addSchedule(tvctCreateTVCT);
        System.out.println("Expected file size: " + ((transportStreamProducer.getBitrate() / 8) * 15));
        transportStreamProducer.start();
    }
}
