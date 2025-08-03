package com.blink.academy.film.support.stream.ts.google.API;

import com.blink.academy.film.support.stream.ts.google.API.DVB.DVBEITEvent;
import com.blink.academy.film.support.stream.ts.google.API.DVB.EITPF;
import com.blink.academy.film.support.stream.ts.google.API.DVB.EITSchedule;
import com.blink.academy.film.support.stream.ts.google.API.DVB.NIT;
import com.blink.academy.film.support.stream.ts.google.API.DVB.NITTransportStream;
import com.blink.academy.film.support.stream.ts.google.API.DVB.SDT;
import com.blink.academy.film.support.stream.ts.google.API.DVB.SDTService;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PAT;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PATProgram;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PMT;
import com.blink.academy.film.support.stream.ts.google.API.PSI.PMTStream;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.CVCTChannel;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.EIT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.EITEvent;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.ETT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.MGT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.MGTTable;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.RRT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimension;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.RRTDimensionValue;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.STT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCT;
import com.blink.academy.film.support.stream.ts.google.API.PSIP.TVCTChannel;
import com.blink.academy.film.support.stream.ts.google.Core.DVB.DVBEITEventImpl;
import com.blink.academy.film.support.stream.ts.google.Core.DVB.EITPFImpl;
import com.blink.academy.film.support.stream.ts.google.Core.DVB.EITScheduleImpl;
import com.blink.academy.film.support.stream.ts.google.Core.DVB.NITImpl;
import com.blink.academy.film.support.stream.ts.google.Core.DVB.NITTransportStreamImpl;
import com.blink.academy.film.support.stream.ts.google.Core.DVB.SDTImpl;
import com.blink.academy.film.support.stream.ts.google.Core.DVB.SDTServiceImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSI.PATDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSI.PATProgramDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSI.PMTDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSI.PMTStreamDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSIP.CVCTChannelDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSIP.CVCTDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSIP.EITDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSIP.EITEventDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSIP.ETTDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSIP.MGTDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSIP.MGTTableDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSIP.RRTDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSIP.RRTDimensionDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSIP.RRTDimensionValueDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSIP.STTDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSIP.TVCTChannelDefaultImpl;
import com.blink.academy.film.support.stream.ts.google.Core.PSIP.TVCTDefaultImpl;

/* loaded from: classes.dex */
public class SITableFactory {
    public static CVCT createCVCT(int i, int i2) {
        CVCTDefaultImpl cVCTDefaultImpl = new CVCTDefaultImpl();
        cVCTDefaultImpl.setVersionNumber(i);
        cVCTDefaultImpl.setTransportStreamId(i2);
        return cVCTDefaultImpl;
    }

    public static CVCTChannel createCVCTChannel(char[] cArr, int i, int i2, int i3, int i4, int i5, ServiceType serviceType, int i6) {
        CVCTChannelDefaultImpl cVCTChannelDefaultImpl = new CVCTChannelDefaultImpl();
        cVCTChannelDefaultImpl.setShortName(cArr);
        cVCTChannelDefaultImpl.setMajorChannelNumber(i);
        cVCTChannelDefaultImpl.setMinorChannelNumber(i2);
        cVCTChannelDefaultImpl.setModulationMode(i3);
        cVCTChannelDefaultImpl.setCarrierFrequency(i4);
        cVCTChannelDefaultImpl.setProgramNumber(i5);
        cVCTChannelDefaultImpl.setETMLocation(1);
        cVCTChannelDefaultImpl.setAccessControlled(0);
        cVCTChannelDefaultImpl.setHidden(0);
        cVCTChannelDefaultImpl.setPathSelect(0);
        cVCTChannelDefaultImpl.setOutOfBand(0);
        cVCTChannelDefaultImpl.setHideGuide(0);
        cVCTChannelDefaultImpl.setServiceType(serviceType);
        cVCTChannelDefaultImpl.setSourceId(i6);
        return cVCTChannelDefaultImpl;
    }

    public static DVBEITEvent createDVBEITEvent(int i, long j, int i2, int i3, int i4) {
        DVBEITEventImpl dVBEITEventImpl = new DVBEITEventImpl();
        dVBEITEventImpl.setEventId(i);
        dVBEITEventImpl.setStartTime(j);
        dVBEITEventImpl.setDuration(i2);
        dVBEITEventImpl.setRunningStatus(i3);
        dVBEITEventImpl.setFreeCaMode(i4);
        return dVBEITEventImpl;
    }

    public static EIT createEIT(int i, int i2, int i3) {
        EITDefaultImpl eITDefaultImpl = new EITDefaultImpl(i);
        eITDefaultImpl.setVersionNumber(i2);
        eITDefaultImpl.setSourceId(i3);
        return eITDefaultImpl;
    }

    public static EITEvent createEITEvent(int i, long j, int i2) {
        EITEventDefaultImpl eITEventDefaultImpl = new EITEventDefaultImpl();
        eITEventDefaultImpl.setEventId(i);
        eITEventDefaultImpl.setStartTime(j);
        eITEventDefaultImpl.setLengthInSeconds(i2);
        eITEventDefaultImpl.setETMLocation(1);
        return eITEventDefaultImpl;
    }

    public static EITPF createEITPF(boolean z, int i, int i2, int i3, int i4) {
        EITPFImpl eITPFImpl = new EITPFImpl();
        eITPFImpl.setIsActual(z);
        eITPFImpl.setVersionNumber(i);
        eITPFImpl.setServiceId(i2);
        eITPFImpl.setTransportStreamId(i3);
        eITPFImpl.setOrgNetworkId(i4);
        return eITPFImpl;
    }

    public static EITSchedule createEITSchedule(boolean z, int i, int i2, int i3, int i4) {
        EITScheduleImpl eITScheduleImpl = new EITScheduleImpl();
        eITScheduleImpl.setIsActual(z);
        eITScheduleImpl.setVersionNumber(i);
        eITScheduleImpl.setServiceId(i2);
        eITScheduleImpl.setTransportStreamId(i3);
        eITScheduleImpl.setOrgNetworkId(i4);
        return eITScheduleImpl;
    }

    public static ETT createETT(int i, int i2, long j) {
        ETTDefaultImpl eTTDefaultImpl = new ETTDefaultImpl(i);
        eTTDefaultImpl.setETTTableIdExtension(i2);
        eTTDefaultImpl.setETMId(j);
        return eTTDefaultImpl;
    }

    public static MGT createMGT(int i) {
        MGTDefaultImpl mGTDefaultImpl = new MGTDefaultImpl();
        mGTDefaultImpl.setVersionNumber(i);
        return mGTDefaultImpl;
    }

    public static MGTTable createMGTTable(TableType tableType, int i, int i2, int i3) {
        MGTTableDefaultImpl mGTTableDefaultImpl = new MGTTableDefaultImpl(tableType);
        mGTTableDefaultImpl.setTableTypePID(i);
        mGTTableDefaultImpl.setTableTypeVersionNumber(i2);
        mGTTableDefaultImpl.setNumberBytes(i3);
        return mGTTableDefaultImpl;
    }

    public static NIT createNIT(boolean z, int i, int i2) {
        NITImpl nITImpl = new NITImpl();
        nITImpl.setIsActual(z);
        nITImpl.setNetworkId(i2);
        nITImpl.setVersionNumber(i);
        return nITImpl;
    }

    public static NITTransportStream createNITTransportStream(int i, int i2) {
        NITTransportStreamImpl nITTransportStreamImpl = new NITTransportStreamImpl();
        nITTransportStreamImpl.setTransportStreamId(i);
        nITTransportStreamImpl.setOrgNetworkId(i2);
        return nITTransportStreamImpl;
    }

    public static PAT createPAT(int i, int i2) {
        return new PATDefaultImpl(i, i2);
    }

    public static PATProgram createPATProgram(int i, int i2) {
        return new PATProgramDefaultImpl(i, i2);
    }

    public static PMT createPMT(int i, int i2, int i3, int i4) {
        return new PMTDefaultImpl(i, i2, i3, i4);
    }

    public static PMTStream createPMTStream(StreamType streamType, int i) {
        return new PMTStreamDefaultImpl(streamType, i);
    }

    public static RRT createRRT(int i, int i2) {
        RRTDefaultImpl rRTDefaultImpl = new RRTDefaultImpl();
        rRTDefaultImpl.setVersionNumber(i);
        rRTDefaultImpl.setRatingRegion(i2);
        return rRTDefaultImpl;
    }

    public static RRTDimension createRRTDimension(int i) {
        RRTDimensionDefaultImpl rRTDimensionDefaultImpl = new RRTDimensionDefaultImpl();
        rRTDimensionDefaultImpl.setGraduatedScale(i);
        return rRTDimensionDefaultImpl;
    }

    public static RRTDimensionValue createRRTDimensionValue() {
        return new RRTDimensionValueDefaultImpl();
    }

    public static SDT createSDT(boolean z, int i, int i2, int i3) {
        SDTImpl sDTImpl = new SDTImpl();
        sDTImpl.setIsActual(z);
        sDTImpl.setVersionNumber(i);
        sDTImpl.setTransportStreamId(i2);
        sDTImpl.setOrgNetworkId(i3);
        return sDTImpl;
    }

    public static SDTService createSDTService(int i, int i2, int i3, int i4, int i5) {
        SDTServiceImpl sDTServiceImpl = new SDTServiceImpl();
        sDTServiceImpl.setServiceId(i);
        sDTServiceImpl.setEitPfFlag(i2);
        sDTServiceImpl.setEitSchedFlag(i3);
        sDTServiceImpl.setRunningStatus(i4);
        sDTServiceImpl.setFreeCaMode(i5);
        return sDTServiceImpl;
    }

    public static STT createSTT(int i, long j, int i2, int i3) {
        STTDefaultImpl sTTDefaultImpl = new STTDefaultImpl();
        sTTDefaultImpl.setVersionNumber(i);
        sTTDefaultImpl.setSystemTime(j);
        sTTDefaultImpl.setGPS_UTC_Offset(i2);
        sTTDefaultImpl.setDatlightSavings(i3);
        return sTTDefaultImpl;
    }

    public static TVCT createTVCT(int i, int i2) {
        TVCTDefaultImpl tVCTDefaultImpl = new TVCTDefaultImpl();
        tVCTDefaultImpl.setVersionNumber(i);
        tVCTDefaultImpl.setTransportStreamId(i2);
        return tVCTDefaultImpl;
    }

    public static TVCTChannel createTVCTChannel(char[] cArr, int i, int i2, int i3, int i4, int i5, ServiceType serviceType, int i6) {
        TVCTChannelDefaultImpl tVCTChannelDefaultImpl = new TVCTChannelDefaultImpl();
        tVCTChannelDefaultImpl.setShortName(cArr);
        tVCTChannelDefaultImpl.setMajorChannelNumber(i);
        tVCTChannelDefaultImpl.setMinorChannelNumber(i2);
        tVCTChannelDefaultImpl.setModulationMode(i3);
        tVCTChannelDefaultImpl.setCarrierFrequency(i4);
        tVCTChannelDefaultImpl.setProgramNumber(i5);
        tVCTChannelDefaultImpl.setETMLocation(1);
        tVCTChannelDefaultImpl.setAccessControlled(0);
        tVCTChannelDefaultImpl.setHidden(0);
        tVCTChannelDefaultImpl.setHideGuide(0);
        tVCTChannelDefaultImpl.setServiceType(serviceType);
        tVCTChannelDefaultImpl.setSourceId(i6);
        return tVCTChannelDefaultImpl;
    }
}
