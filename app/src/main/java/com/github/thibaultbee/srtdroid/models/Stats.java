package com.github.thibaultbee.srtdroid.models;

/* compiled from: Stats.kt */
/* loaded from: classes.dex */
public final class Stats {
    private final int byteAvailRcvBuf;
    private final int byteAvailSndBuf;
    private final int byteMSS;
    private final int byteRcvBuf;
    private final long byteRcvDrop;
    private final long byteRcvDropTotal;
    private final long byteRcvLoss;
    private final long byteRcvLossTotal;
    private final long byteRcvUndecrypt;
    private final long byteRcvUndecryptTotal;
    private final long byteRecv;
    private final long byteRecvTotal;
    private final long byteRecvUnique;
    private final long byteRecvUniqueTotal;
    private final long byteRetrans;
    private final long byteRetransTotal;
    private final long byteSent;
    private final long byteSentTotal;
    private final long byteSentUnique;
    private final long byteSentUniqueTotal;
    private final int byteSndBuf;
    private final long byteSndDrop;
    private final long byteSndDropTotal;
    private final double mbpsBandwidth;
    private final double mbpsMaxBW;
    private final double mbpsRecvRate;
    private final double mbpsSendRate;
    private final double msRTT;
    private final int msRcvBuf;
    private final int msRcvTsbPdDelay;
    private final int msSndBuf;
    private final int msSndTsbPdDelay;
    private final long msTimeStamp;
    private final int pktCongestionWindow;
    private final int pktFlightSize;
    private final int pktFlowWindow;
    private final double pktRcvAvgBelatedTime;
    private final long pktRcvBelated;
    private final int pktRcvBuf;
    private final int pktRcvDrop;
    private final int pktRcvDropTotal;
    private final int pktRcvFilterExtra;
    private final int pktRcvFilterExtraTotal;
    private final int pktRcvFilterLoss;
    private final int pktRcvFilterLossTotal;
    private final int pktRcvFilterSupply;
    private final int pktRcvFilterSupplyTotal;
    private final int pktRcvLoss;
    private final int pktRcvLossTotal;
    private final int pktRcvRetrans;
    private final int pktRcvUndecrypt;
    private final int pktRcvUndecryptTotal;
    private final long pktRecv;
    private final int pktRecvACK;
    private final int pktRecvACKTotal;
    private final int pktRecvNAK;
    private final int pktRecvNAKTotal;
    private final long pktRecvTotal;
    private final long pktRecvUnique;
    private final long pktRecvUniqueTotal;
    private final int pktReorderDistance;
    private final int pktReorderTolerance;
    private final int pktRetrans;
    private final int pktRetransTotal;
    private final long pktSent;
    private final int pktSentACK;
    private final int pktSentACKTotal;
    private final int pktSentNAK;
    private final int pktSentNAKTotal;
    private final long pktSentTotal;
    private final long pktSentUnique;
    private final long pktSentUniqueTotal;
    private final int pktSndBuf;
    private final int pktSndDrop;
    private final int pktSndDropTotal;
    private final int pktSndFilterExtra;
    private final int pktSndFilterExtraTotal;
    private final int pktSndLoss;
    private final int pktSndLossTotal;
    private final double usPktSndPeriod;
    private final long usSndDuration;
    private final long usSndDurationTotal;

    public Stats(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j4, int i8, int i9, int i10, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, double d, double d2, long j14, int i19, double d3, long j15, int i20, int i21, int i22, long j16, long j17, long j18, long j19, long j20, long j21, long j22, double d4, int i23, int i24, int i25, double d5, double d6, int i26, int i27, double d7, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, int i39, int i40, int i41, int i42, int i43, int i44, int i45, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30) {
        this.msTimeStamp = j;
        this.pktSentTotal = j2;
        this.pktRecvTotal = j3;
        this.pktSndLossTotal = i;
        this.pktRcvLossTotal = i2;
        this.pktRetransTotal = i3;
        this.pktSentACKTotal = i4;
        this.pktRecvACKTotal = i5;
        this.pktSentNAKTotal = i6;
        this.pktRecvNAKTotal = i7;
        this.usSndDurationTotal = j4;
        this.pktSndDropTotal = i8;
        this.pktRcvDropTotal = i9;
        this.pktRcvUndecryptTotal = i10;
        this.byteSentTotal = j5;
        this.byteRecvTotal = j6;
        this.byteRcvLossTotal = j7;
        this.byteRetransTotal = j8;
        this.byteSndDropTotal = j9;
        this.byteRcvDropTotal = j10;
        this.byteRcvUndecryptTotal = j11;
        this.pktSent = j12;
        this.pktRecv = j13;
        this.pktSndLoss = i11;
        this.pktRcvLoss = i12;
        this.pktRetrans = i13;
        this.pktRcvRetrans = i14;
        this.pktSentACK = i15;
        this.pktRecvACK = i16;
        this.pktSentNAK = i17;
        this.pktRecvNAK = i18;
        this.mbpsSendRate = d;
        this.mbpsRecvRate = d2;
        this.usSndDuration = j14;
        this.pktReorderDistance = i19;
        this.pktRcvAvgBelatedTime = d3;
        this.pktRcvBelated = j15;
        this.pktSndDrop = i20;
        this.pktRcvDrop = i21;
        this.pktRcvUndecrypt = i22;
        this.byteSent = j16;
        this.byteRecv = j17;
        this.byteRcvLoss = j18;
        this.byteRetrans = j19;
        this.byteSndDrop = j20;
        this.byteRcvDrop = j21;
        this.byteRcvUndecrypt = j22;
        this.usPktSndPeriod = d4;
        this.pktFlowWindow = i23;
        this.pktCongestionWindow = i24;
        this.pktFlightSize = i25;
        this.msRTT = d5;
        this.mbpsBandwidth = d6;
        this.byteAvailSndBuf = i26;
        this.byteAvailRcvBuf = i27;
        this.mbpsMaxBW = d7;
        this.byteMSS = i28;
        this.pktSndBuf = i29;
        this.byteSndBuf = i30;
        this.msSndBuf = i31;
        this.msSndTsbPdDelay = i32;
        this.pktRcvBuf = i33;
        this.byteRcvBuf = i34;
        this.msRcvBuf = i35;
        this.msRcvTsbPdDelay = i36;
        this.pktSndFilterExtraTotal = i37;
        this.pktRcvFilterExtraTotal = i38;
        this.pktRcvFilterSupplyTotal = i39;
        this.pktRcvFilterLossTotal = i40;
        this.pktSndFilterExtra = i41;
        this.pktRcvFilterExtra = i42;
        this.pktRcvFilterSupply = i43;
        this.pktRcvFilterLoss = i44;
        this.pktReorderTolerance = i45;
        this.pktSentUniqueTotal = j23;
        this.pktRecvUniqueTotal = j24;
        this.byteSentUniqueTotal = j25;
        this.byteRecvUniqueTotal = j26;
        this.pktSentUnique = j27;
        this.pktRecvUnique = j28;
        this.byteSentUnique = j29;
        this.byteRecvUnique = j30;
    }

    public static /* synthetic */ Stats copy$default(Stats stats, long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j4, int i8, int i9, int i10, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, double d, double d2, long j14, int i19, double d3, long j15, int i20, int i21, int i22, long j16, long j17, long j18, long j19, long j20, long j21, long j22, double d4, int i23, int i24, int i25, double d5, double d6, int i26, int i27, double d7, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, int i39, int i40, int i41, int i42, int i43, int i44, int i45, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, int i46, int i47, int i48, Object obj) {
        long j31 = (i46 & 1) != 0 ? stats.msTimeStamp : j;
        long j32 = (i46 & 2) != 0 ? stats.pktSentTotal : j2;
        long j33 = (i46 & 4) != 0 ? stats.pktRecvTotal : j3;
        int i49 = (i46 & 8) != 0 ? stats.pktSndLossTotal : i;
        int i50 = (i46 & 16) != 0 ? stats.pktRcvLossTotal : i2;
        int i51 = (i46 & 32) != 0 ? stats.pktRetransTotal : i3;
        int i52 = (i46 & 64) != 0 ? stats.pktSentACKTotal : i4;
        int i53 = (i46 & 128) != 0 ? stats.pktRecvACKTotal : i5;
        int i54 = (i46 & 256) != 0 ? stats.pktSentNAKTotal : i6;
        int i55 = (i46 & 512) != 0 ? stats.pktRecvNAKTotal : i7;
        int i56 = i53;
        long j34 = (i46 & 1024) != 0 ? stats.usSndDurationTotal : j4;
        int i57 = (i46 & 2048) != 0 ? stats.pktSndDropTotal : i8;
        int i58 = (i46 & 4096) != 0 ? stats.pktRcvDropTotal : i9;
        int i59 = (i46 & 8192) != 0 ? stats.pktRcvUndecryptTotal : i10;
        int i60 = i57;
        long j35 = (i46 & 16384) != 0 ? stats.byteSentTotal : j5;
        long j36 = (i46 & 32768) != 0 ? stats.byteRecvTotal : j6;
        long j37 = (i46 & 65536) != 0 ? stats.byteRcvLossTotal : j7;
        long j38 = (i46 & 131072) != 0 ? stats.byteRetransTotal : j8;
        long j39 = (i46 & 262144) != 0 ? stats.byteSndDropTotal : j9;
        long j40 = (i46 & 524288) != 0 ? stats.byteRcvDropTotal : j10;
        long j41 = (i46 & 1048576) != 0 ? stats.byteRcvUndecryptTotal : j11;
        long j42 = (i46 & 2097152) != 0 ? stats.pktSent : j12;
        long j43 = (i46 & 4194304) != 0 ? stats.pktRecv : j13;
        int i61 = (i46 & 8388608) != 0 ? stats.pktSndLoss : i11;
        int i62 = (16777216 & i46) != 0 ? stats.pktRcvLoss : i12;
        int i63 = (i46 & 33554432) != 0 ? stats.pktRetrans : i13;
        int i64 = (i46 & 67108864) != 0 ? stats.pktRcvRetrans : i14;
        int i65 = (i46 & 134217728) != 0 ? stats.pktSentACK : i15;
        int i66 = (i46 & 268435456) != 0 ? stats.pktRecvACK : i16;
        int i67 = (i46 & 536870912) != 0 ? stats.pktSentNAK : i17;
        int i68 = i61;
        int i69 = (i46 & 1073741824) != 0 ? stats.pktRecvNAK : i18;
        double d8 = (i46 & Integer.MIN_VALUE) != 0 ? stats.mbpsSendRate : d;
        double d9 = (i47 & 1) != 0 ? stats.mbpsRecvRate : d2;
        long j44 = (i47 & 2) != 0 ? stats.usSndDuration : j14;
        int i70 = (i47 & 4) != 0 ? stats.pktReorderDistance : i19;
        long j45 = j44;
        double d10 = (i47 & 8) != 0 ? stats.pktRcvAvgBelatedTime : d3;
        long j46 = (i47 & 16) != 0 ? stats.pktRcvBelated : j15;
        int i71 = (i47 & 32) != 0 ? stats.pktSndDrop : i20;
        int i72 = (i47 & 64) != 0 ? stats.pktRcvDrop : i21;
        int i73 = (i47 & 128) != 0 ? stats.pktRcvUndecrypt : i22;
        int i74 = i71;
        long j47 = (i47 & 256) != 0 ? stats.byteSent : j16;
        long j48 = (i47 & 512) != 0 ? stats.byteRecv : j17;
        long j49 = (i47 & 1024) != 0 ? stats.byteRcvLoss : j18;
        long j50 = (i47 & 2048) != 0 ? stats.byteRetrans : j19;
        long j51 = (i47 & 4096) != 0 ? stats.byteSndDrop : j20;
        long j52 = (i47 & 8192) != 0 ? stats.byteRcvDrop : j21;
        long j53 = (i47 & 16384) != 0 ? stats.byteRcvUndecrypt : j22;
        double d11 = (i47 & 32768) != 0 ? stats.usPktSndPeriod : d4;
        int i75 = (i47 & 65536) != 0 ? stats.pktFlowWindow : i23;
        return stats.copy(j31, j32, j33, i49, i50, i51, i52, i56, i54, i55, j34, i60, i58, i59, j35, j36, j37, j38, j39, j40, j41, j42, j43, i68, i62, i63, i64, i65, i66, i67, i69, d8, d9, j45, i70, d10, j46, i74, i72, i73, j47, j48, j49, j50, j51, j52, j53, d11, i75, (i47 & 131072) != 0 ? stats.pktCongestionWindow : i24, (i47 & 262144) != 0 ? stats.pktFlightSize : i25, (i47 & 524288) != 0 ? stats.msRTT : d5, (i47 & 1048576) != 0 ? stats.mbpsBandwidth : d6, (i47 & 2097152) != 0 ? stats.byteAvailSndBuf : i26, (4194304 & i47) != 0 ? stats.byteAvailRcvBuf : i27, (i47 & 8388608) != 0 ? stats.mbpsMaxBW : d7, (i47 & 16777216) != 0 ? stats.byteMSS : i28, (33554432 & i47) != 0 ? stats.pktSndBuf : i29, (i47 & 67108864) != 0 ? stats.byteSndBuf : i30, (i47 & 134217728) != 0 ? stats.msSndBuf : i31, (i47 & 268435456) != 0 ? stats.msSndTsbPdDelay : i32, (i47 & 536870912) != 0 ? stats.pktRcvBuf : i33, (i47 & 1073741824) != 0 ? stats.byteRcvBuf : i34, (i47 & Integer.MIN_VALUE) != 0 ? stats.msRcvBuf : i35, (i48 & 1) != 0 ? stats.msRcvTsbPdDelay : i36, (i48 & 2) != 0 ? stats.pktSndFilterExtraTotal : i37, (i48 & 4) != 0 ? stats.pktRcvFilterExtraTotal : i38, (i48 & 8) != 0 ? stats.pktRcvFilterSupplyTotal : i39, (i48 & 16) != 0 ? stats.pktRcvFilterLossTotal : i40, (i48 & 32) != 0 ? stats.pktSndFilterExtra : i41, (i48 & 64) != 0 ? stats.pktRcvFilterExtra : i42, (i48 & 128) != 0 ? stats.pktRcvFilterSupply : i43, (i48 & 256) != 0 ? stats.pktRcvFilterLoss : i44, (i48 & 512) != 0 ? stats.pktReorderTolerance : i45, (i48 & 1024) != 0 ? stats.pktSentUniqueTotal : j23, (i48 & 2048) != 0 ? stats.pktRecvUniqueTotal : j24, (i48 & 4096) != 0 ? stats.byteSentUniqueTotal : j25, (i48 & 8192) != 0 ? stats.byteRecvUniqueTotal : j26, (i48 & 16384) != 0 ? stats.pktSentUnique : j27, (i48 & 32768) != 0 ? stats.pktRecvUnique : j28, (i48 & 65536) != 0 ? stats.byteSentUnique : j29, (i48 & 131072) != 0 ? stats.byteRecvUnique : j30);
    }

    public final long component1() {
        return this.msTimeStamp;
    }

    public final int component10() {
        return this.pktRecvNAKTotal;
    }

    public final long component11() {
        return this.usSndDurationTotal;
    }

    public final int component12() {
        return this.pktSndDropTotal;
    }

    public final int component13() {
        return this.pktRcvDropTotal;
    }

    public final int component14() {
        return this.pktRcvUndecryptTotal;
    }

    public final long component15() {
        return this.byteSentTotal;
    }

    public final long component16() {
        return this.byteRecvTotal;
    }

    public final long component17() {
        return this.byteRcvLossTotal;
    }

    public final long component18() {
        return this.byteRetransTotal;
    }

    public final long component19() {
        return this.byteSndDropTotal;
    }

    public final long component2() {
        return this.pktSentTotal;
    }

    public final long component20() {
        return this.byteRcvDropTotal;
    }

    public final long component21() {
        return this.byteRcvUndecryptTotal;
    }

    public final long component22() {
        return this.pktSent;
    }

    public final long component23() {
        return this.pktRecv;
    }

    public final int component24() {
        return this.pktSndLoss;
    }

    public final int component25() {
        return this.pktRcvLoss;
    }

    public final int component26() {
        return this.pktRetrans;
    }

    public final int component27() {
        return this.pktRcvRetrans;
    }

    public final int component28() {
        return this.pktSentACK;
    }

    public final int component29() {
        return this.pktRecvACK;
    }

    public final long component3() {
        return this.pktRecvTotal;
    }

    public final int component30() {
        return this.pktSentNAK;
    }

    public final int component31() {
        return this.pktRecvNAK;
    }

    public final double component32() {
        return this.mbpsSendRate;
    }

    public final double component33() {
        return this.mbpsRecvRate;
    }

    public final long component34() {
        return this.usSndDuration;
    }

    public final int component35() {
        return this.pktReorderDistance;
    }

    public final double component36() {
        return this.pktRcvAvgBelatedTime;
    }

    public final long component37() {
        return this.pktRcvBelated;
    }

    public final int component38() {
        return this.pktSndDrop;
    }

    public final int component39() {
        return this.pktRcvDrop;
    }

    public final int component4() {
        return this.pktSndLossTotal;
    }

    public final int component40() {
        return this.pktRcvUndecrypt;
    }

    public final long component41() {
        return this.byteSent;
    }

    public final long component42() {
        return this.byteRecv;
    }

    public final long component43() {
        return this.byteRcvLoss;
    }

    public final long component44() {
        return this.byteRetrans;
    }

    public final long component45() {
        return this.byteSndDrop;
    }

    public final long component46() {
        return this.byteRcvDrop;
    }

    public final long component47() {
        return this.byteRcvUndecrypt;
    }

    public final double component48() {
        return this.usPktSndPeriod;
    }

    public final int component49() {
        return this.pktFlowWindow;
    }

    public final int component5() {
        return this.pktRcvLossTotal;
    }

    public final int component50() {
        return this.pktCongestionWindow;
    }

    public final int component51() {
        return this.pktFlightSize;
    }

    public final double component52() {
        return this.msRTT;
    }

    public final double component53() {
        return this.mbpsBandwidth;
    }

    public final int component54() {
        return this.byteAvailSndBuf;
    }

    public final int component55() {
        return this.byteAvailRcvBuf;
    }

    public final double component56() {
        return this.mbpsMaxBW;
    }

    public final int component57() {
        return this.byteMSS;
    }

    public final int component58() {
        return this.pktSndBuf;
    }

    public final int component59() {
        return this.byteSndBuf;
    }

    public final int component6() {
        return this.pktRetransTotal;
    }

    public final int component60() {
        return this.msSndBuf;
    }

    public final int component61() {
        return this.msSndTsbPdDelay;
    }

    public final int component62() {
        return this.pktRcvBuf;
    }

    public final int component63() {
        return this.byteRcvBuf;
    }

    public final int component64() {
        return this.msRcvBuf;
    }

    public final int component65() {
        return this.msRcvTsbPdDelay;
    }

    public final int component66() {
        return this.pktSndFilterExtraTotal;
    }

    public final int component67() {
        return this.pktRcvFilterExtraTotal;
    }

    public final int component68() {
        return this.pktRcvFilterSupplyTotal;
    }

    public final int component69() {
        return this.pktRcvFilterLossTotal;
    }

    public final int component7() {
        return this.pktSentACKTotal;
    }

    public final int component70() {
        return this.pktSndFilterExtra;
    }

    public final int component71() {
        return this.pktRcvFilterExtra;
    }

    public final int component72() {
        return this.pktRcvFilterSupply;
    }

    public final int component73() {
        return this.pktRcvFilterLoss;
    }

    public final int component74() {
        return this.pktReorderTolerance;
    }

    public final long component75() {
        return this.pktSentUniqueTotal;
    }

    public final long component76() {
        return this.pktRecvUniqueTotal;
    }

    public final long component77() {
        return this.byteSentUniqueTotal;
    }

    public final long component78() {
        return this.byteRecvUniqueTotal;
    }

    public final long component79() {
        return this.pktSentUnique;
    }

    public final int component8() {
        return this.pktRecvACKTotal;
    }

    public final long component80() {
        return this.pktRecvUnique;
    }

    public final long component81() {
        return this.byteSentUnique;
    }

    public final long component82() {
        return this.byteRecvUnique;
    }

    public final int component9() {
        return this.pktSentNAKTotal;
    }

    public final Stats copy(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j4, int i8, int i9, int i10, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, double d, double d2, long j14, int i19, double d3, long j15, int i20, int i21, int i22, long j16, long j17, long j18, long j19, long j20, long j21, long j22, double d4, int i23, int i24, int i25, double d5, double d6, int i26, int i27, double d7, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, int i37, int i38, int i39, int i40, int i41, int i42, int i43, int i44, int i45, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30) {
        return new Stats(j, j2, j3, i, i2, i3, i4, i5, i6, i7, j4, i8, i9, i10, j5, j6, j7, j8, j9, j10, j11, j12, j13, i11, i12, i13, i14, i15, i16, i17, i18, d, d2, j14, i19, d3, j15, i20, i21, i22, j16, j17, j18, j19, j20, j21, j22, d4, i23, i24, i25, d5, d6, i26, i27, d7, i28, i29, i30, i31, i32, i33, i34, i35, i36, i37, i38, i39, i40, i41, i42, i43, i44, i45, j23, j24, j25, j26, j27, j28, j29, j30);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stats)) {
            return false;
        }
        Stats stats = (Stats) obj;
        return this.msTimeStamp == stats.msTimeStamp && this.pktSentTotal == stats.pktSentTotal && this.pktRecvTotal == stats.pktRecvTotal && this.pktSndLossTotal == stats.pktSndLossTotal && this.pktRcvLossTotal == stats.pktRcvLossTotal && this.pktRetransTotal == stats.pktRetransTotal && this.pktSentACKTotal == stats.pktSentACKTotal && this.pktRecvACKTotal == stats.pktRecvACKTotal && this.pktSentNAKTotal == stats.pktSentNAKTotal && this.pktRecvNAKTotal == stats.pktRecvNAKTotal && this.usSndDurationTotal == stats.usSndDurationTotal && this.pktSndDropTotal == stats.pktSndDropTotal && this.pktRcvDropTotal == stats.pktRcvDropTotal && this.pktRcvUndecryptTotal == stats.pktRcvUndecryptTotal && this.byteSentTotal == stats.byteSentTotal && this.byteRecvTotal == stats.byteRecvTotal && this.byteRcvLossTotal == stats.byteRcvLossTotal && this.byteRetransTotal == stats.byteRetransTotal && this.byteSndDropTotal == stats.byteSndDropTotal && this.byteRcvDropTotal == stats.byteRcvDropTotal && this.byteRcvUndecryptTotal == stats.byteRcvUndecryptTotal && this.pktSent == stats.pktSent && this.pktRecv == stats.pktRecv && this.pktSndLoss == stats.pktSndLoss && this.pktRcvLoss == stats.pktRcvLoss && this.pktRetrans == stats.pktRetrans && this.pktRcvRetrans == stats.pktRcvRetrans && this.pktSentACK == stats.pktSentACK && this.pktRecvACK == stats.pktRecvACK && this.pktSentNAK == stats.pktSentNAK && this.pktRecvNAK == stats.pktRecvNAK && Double.compare(this.mbpsSendRate, stats.mbpsSendRate) == 0 && Double.compare(this.mbpsRecvRate, stats.mbpsRecvRate) == 0 && this.usSndDuration == stats.usSndDuration && this.pktReorderDistance == stats.pktReorderDistance && Double.compare(this.pktRcvAvgBelatedTime, stats.pktRcvAvgBelatedTime) == 0 && this.pktRcvBelated == stats.pktRcvBelated && this.pktSndDrop == stats.pktSndDrop && this.pktRcvDrop == stats.pktRcvDrop && this.pktRcvUndecrypt == stats.pktRcvUndecrypt && this.byteSent == stats.byteSent && this.byteRecv == stats.byteRecv && this.byteRcvLoss == stats.byteRcvLoss && this.byteRetrans == stats.byteRetrans && this.byteSndDrop == stats.byteSndDrop && this.byteRcvDrop == stats.byteRcvDrop && this.byteRcvUndecrypt == stats.byteRcvUndecrypt && Double.compare(this.usPktSndPeriod, stats.usPktSndPeriod) == 0 && this.pktFlowWindow == stats.pktFlowWindow && this.pktCongestionWindow == stats.pktCongestionWindow && this.pktFlightSize == stats.pktFlightSize && Double.compare(this.msRTT, stats.msRTT) == 0 && Double.compare(this.mbpsBandwidth, stats.mbpsBandwidth) == 0 && this.byteAvailSndBuf == stats.byteAvailSndBuf && this.byteAvailRcvBuf == stats.byteAvailRcvBuf && Double.compare(this.mbpsMaxBW, stats.mbpsMaxBW) == 0 && this.byteMSS == stats.byteMSS && this.pktSndBuf == stats.pktSndBuf && this.byteSndBuf == stats.byteSndBuf && this.msSndBuf == stats.msSndBuf && this.msSndTsbPdDelay == stats.msSndTsbPdDelay && this.pktRcvBuf == stats.pktRcvBuf && this.byteRcvBuf == stats.byteRcvBuf && this.msRcvBuf == stats.msRcvBuf && this.msRcvTsbPdDelay == stats.msRcvTsbPdDelay && this.pktSndFilterExtraTotal == stats.pktSndFilterExtraTotal && this.pktRcvFilterExtraTotal == stats.pktRcvFilterExtraTotal && this.pktRcvFilterSupplyTotal == stats.pktRcvFilterSupplyTotal && this.pktRcvFilterLossTotal == stats.pktRcvFilterLossTotal && this.pktSndFilterExtra == stats.pktSndFilterExtra && this.pktRcvFilterExtra == stats.pktRcvFilterExtra && this.pktRcvFilterSupply == stats.pktRcvFilterSupply && this.pktRcvFilterLoss == stats.pktRcvFilterLoss && this.pktReorderTolerance == stats.pktReorderTolerance && this.pktSentUniqueTotal == stats.pktSentUniqueTotal && this.pktRecvUniqueTotal == stats.pktRecvUniqueTotal && this.byteSentUniqueTotal == stats.byteSentUniqueTotal && this.byteRecvUniqueTotal == stats.byteRecvUniqueTotal && this.pktSentUnique == stats.pktSentUnique && this.pktRecvUnique == stats.pktRecvUnique && this.byteSentUnique == stats.byteSentUnique && this.byteRecvUnique == stats.byteRecvUnique;
    }

    public final int getByteAvailRcvBuf() {
        return this.byteAvailRcvBuf;
    }

    public final int getByteAvailSndBuf() {
        return this.byteAvailSndBuf;
    }

    public final int getByteMSS() {
        return this.byteMSS;
    }

    public final int getByteRcvBuf() {
        return this.byteRcvBuf;
    }

    public final long getByteRcvDrop() {
        return this.byteRcvDrop;
    }

    public final long getByteRcvDropTotal() {
        return this.byteRcvDropTotal;
    }

    public final long getByteRcvLoss() {
        return this.byteRcvLoss;
    }

    public final long getByteRcvLossTotal() {
        return this.byteRcvLossTotal;
    }

    public final long getByteRcvUndecrypt() {
        return this.byteRcvUndecrypt;
    }

    public final long getByteRcvUndecryptTotal() {
        return this.byteRcvUndecryptTotal;
    }

    public final long getByteRecv() {
        return this.byteRecv;
    }

    public final long getByteRecvTotal() {
        return this.byteRecvTotal;
    }

    public final long getByteRecvUnique() {
        return this.byteRecvUnique;
    }

    public final long getByteRecvUniqueTotal() {
        return this.byteRecvUniqueTotal;
    }

    public final long getByteRetrans() {
        return this.byteRetrans;
    }

    public final long getByteRetransTotal() {
        return this.byteRetransTotal;
    }

    public final long getByteSent() {
        return this.byteSent;
    }

    public final long getByteSentTotal() {
        return this.byteSentTotal;
    }

    public final long getByteSentUnique() {
        return this.byteSentUnique;
    }

    public final long getByteSentUniqueTotal() {
        return this.byteSentUniqueTotal;
    }

    public final int getByteSndBuf() {
        return this.byteSndBuf;
    }

    public final long getByteSndDrop() {
        return this.byteSndDrop;
    }

    public final long getByteSndDropTotal() {
        return this.byteSndDropTotal;
    }

    public final double getMbpsBandwidth() {
        return this.mbpsBandwidth;
    }

    public final double getMbpsMaxBW() {
        return this.mbpsMaxBW;
    }

    public final double getMbpsRecvRate() {
        return this.mbpsRecvRate;
    }

    public final double getMbpsSendRate() {
        return this.mbpsSendRate;
    }

    public final double getMsRTT() {
        return this.msRTT;
    }

    public final int getMsRcvBuf() {
        return this.msRcvBuf;
    }

    public final int getMsRcvTsbPdDelay() {
        return this.msRcvTsbPdDelay;
    }

    public final int getMsSndBuf() {
        return this.msSndBuf;
    }

    public final int getMsSndTsbPdDelay() {
        return this.msSndTsbPdDelay;
    }

    public final long getMsTimeStamp() {
        return this.msTimeStamp;
    }

    public final int getPktCongestionWindow() {
        return this.pktCongestionWindow;
    }

    public final int getPktFlightSize() {
        return this.pktFlightSize;
    }

    public final int getPktFlowWindow() {
        return this.pktFlowWindow;
    }

    public final double getPktRcvAvgBelatedTime() {
        return this.pktRcvAvgBelatedTime;
    }

    public final long getPktRcvBelated() {
        return this.pktRcvBelated;
    }

    public final int getPktRcvBuf() {
        return this.pktRcvBuf;
    }

    public final int getPktRcvDrop() {
        return this.pktRcvDrop;
    }

    public final int getPktRcvDropTotal() {
        return this.pktRcvDropTotal;
    }

    public final int getPktRcvFilterExtra() {
        return this.pktRcvFilterExtra;
    }

    public final int getPktRcvFilterExtraTotal() {
        return this.pktRcvFilterExtraTotal;
    }

    public final int getPktRcvFilterLoss() {
        return this.pktRcvFilterLoss;
    }

    public final int getPktRcvFilterLossTotal() {
        return this.pktRcvFilterLossTotal;
    }

    public final int getPktRcvFilterSupply() {
        return this.pktRcvFilterSupply;
    }

    public final int getPktRcvFilterSupplyTotal() {
        return this.pktRcvFilterSupplyTotal;
    }

    public final int getPktRcvLoss() {
        return this.pktRcvLoss;
    }

    public final int getPktRcvLossTotal() {
        return this.pktRcvLossTotal;
    }

    public final int getPktRcvRetrans() {
        return this.pktRcvRetrans;
    }

    public final int getPktRcvUndecrypt() {
        return this.pktRcvUndecrypt;
    }

    public final int getPktRcvUndecryptTotal() {
        return this.pktRcvUndecryptTotal;
    }

    public final long getPktRecv() {
        return this.pktRecv;
    }

    public final int getPktRecvACK() {
        return this.pktRecvACK;
    }

    public final int getPktRecvACKTotal() {
        return this.pktRecvACKTotal;
    }

    public final int getPktRecvNAK() {
        return this.pktRecvNAK;
    }

    public final int getPktRecvNAKTotal() {
        return this.pktRecvNAKTotal;
    }

    public final long getPktRecvTotal() {
        return this.pktRecvTotal;
    }

    public final long getPktRecvUnique() {
        return this.pktRecvUnique;
    }

    public final long getPktRecvUniqueTotal() {
        return this.pktRecvUniqueTotal;
    }

    public final int getPktReorderDistance() {
        return this.pktReorderDistance;
    }

    public final int getPktReorderTolerance() {
        return this.pktReorderTolerance;
    }

    public final int getPktRetrans() {
        return this.pktRetrans;
    }

    public final int getPktRetransTotal() {
        return this.pktRetransTotal;
    }

    public final long getPktSent() {
        return this.pktSent;
    }

    public final int getPktSentACK() {
        return this.pktSentACK;
    }

    public final int getPktSentACKTotal() {
        return this.pktSentACKTotal;
    }

    public final int getPktSentNAK() {
        return this.pktSentNAK;
    }

    public final int getPktSentNAKTotal() {
        return this.pktSentNAKTotal;
    }

    public final long getPktSentTotal() {
        return this.pktSentTotal;
    }

    public final long getPktSentUnique() {
        return this.pktSentUnique;
    }

    public final long getPktSentUniqueTotal() {
        return this.pktSentUniqueTotal;
    }

    public final int getPktSndBuf() {
        return this.pktSndBuf;
    }

    public final int getPktSndDrop() {
        return this.pktSndDrop;
    }

    public final int getPktSndDropTotal() {
        return this.pktSndDropTotal;
    }

    public final int getPktSndFilterExtra() {
        return this.pktSndFilterExtra;
    }

    public final int getPktSndFilterExtraTotal() {
        return this.pktSndFilterExtraTotal;
    }

    public final int getPktSndLoss() {
        return this.pktSndLoss;
    }

    public final int getPktSndLossTotal() {
        return this.pktSndLossTotal;
    }

    public final double getUsPktSndPeriod() {
        return this.usPktSndPeriod;
    }

    public final long getUsSndDuration() {
        return this.usSndDuration;
    }

    public final long getUsSndDurationTotal() {
        return this.usSndDurationTotal;
    }

    public int hashCode() {
        long j = this.msTimeStamp;
        long j2 = this.pktSentTotal;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.pktRecvTotal;
        int i2 = (((((((((((((((i + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.pktSndLossTotal) * 31) + this.pktRcvLossTotal) * 31) + this.pktRetransTotal) * 31) + this.pktSentACKTotal) * 31) + this.pktRecvACKTotal) * 31) + this.pktSentNAKTotal) * 31) + this.pktRecvNAKTotal) * 31;
        long j4 = this.usSndDurationTotal;
        int i3 = (((((((i2 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.pktSndDropTotal) * 31) + this.pktRcvDropTotal) * 31) + this.pktRcvUndecryptTotal) * 31;
        long j5 = this.byteSentTotal;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.byteRecvTotal;
        int i5 = (i4 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.byteRcvLossTotal;
        int i6 = (i5 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        long j8 = this.byteRetransTotal;
        int i7 = (i6 + ((int) (j8 ^ (j8 >>> 32)))) * 31;
        long j9 = this.byteSndDropTotal;
        int i8 = (i7 + ((int) (j9 ^ (j9 >>> 32)))) * 31;
        long j10 = this.byteRcvDropTotal;
        int i9 = (i8 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.byteRcvUndecryptTotal;
        int i10 = (i9 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.pktSent;
        int i11 = (i10 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
        long j13 = this.pktRecv;
        int i12 = (((((((((((((((((i11 + ((int) (j13 ^ (j13 >>> 32)))) * 31) + this.pktSndLoss) * 31) + this.pktRcvLoss) * 31) + this.pktRetrans) * 31) + this.pktRcvRetrans) * 31) + this.pktSentACK) * 31) + this.pktRecvACK) * 31) + this.pktSentNAK) * 31) + this.pktRecvNAK) * 31;
        long jDoubleToLongBits = Double.doubleToLongBits(this.mbpsSendRate);
        int i13 = (i12 + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.mbpsRecvRate);
        int i14 = (i13 + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31;
        long j14 = this.usSndDuration;
        int i15 = (((i14 + ((int) (j14 ^ (j14 >>> 32)))) * 31) + this.pktReorderDistance) * 31;
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.pktRcvAvgBelatedTime);
        int i16 = (i15 + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)))) * 31;
        long j15 = this.pktRcvBelated;
        int i17 = (((((((i16 + ((int) (j15 ^ (j15 >>> 32)))) * 31) + this.pktSndDrop) * 31) + this.pktRcvDrop) * 31) + this.pktRcvUndecrypt) * 31;
        long j16 = this.byteSent;
        int i18 = (i17 + ((int) (j16 ^ (j16 >>> 32)))) * 31;
        long j17 = this.byteRecv;
        int i19 = (i18 + ((int) (j17 ^ (j17 >>> 32)))) * 31;
        long j18 = this.byteRcvLoss;
        int i20 = (i19 + ((int) (j18 ^ (j18 >>> 32)))) * 31;
        long j19 = this.byteRetrans;
        int i21 = (i20 + ((int) (j19 ^ (j19 >>> 32)))) * 31;
        long j20 = this.byteSndDrop;
        int i22 = (i21 + ((int) (j20 ^ (j20 >>> 32)))) * 31;
        long j21 = this.byteRcvDrop;
        int i23 = (i22 + ((int) (j21 ^ (j21 >>> 32)))) * 31;
        long j22 = this.byteRcvUndecrypt;
        int i24 = (i23 + ((int) (j22 ^ (j22 >>> 32)))) * 31;
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.usPktSndPeriod);
        int i25 = (((((((i24 + ((int) (jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32)))) * 31) + this.pktFlowWindow) * 31) + this.pktCongestionWindow) * 31) + this.pktFlightSize) * 31;
        long jDoubleToLongBits5 = Double.doubleToLongBits(this.msRTT);
        int i26 = (i25 + ((int) (jDoubleToLongBits5 ^ (jDoubleToLongBits5 >>> 32)))) * 31;
        long jDoubleToLongBits6 = Double.doubleToLongBits(this.mbpsBandwidth);
        int i27 = (((((i26 + ((int) (jDoubleToLongBits6 ^ (jDoubleToLongBits6 >>> 32)))) * 31) + this.byteAvailSndBuf) * 31) + this.byteAvailRcvBuf) * 31;
        long jDoubleToLongBits7 = Double.doubleToLongBits(this.mbpsMaxBW);
        int i28 = (((((((((((((((((((((((((((((((((((((i27 + ((int) (jDoubleToLongBits7 ^ (jDoubleToLongBits7 >>> 32)))) * 31) + this.byteMSS) * 31) + this.pktSndBuf) * 31) + this.byteSndBuf) * 31) + this.msSndBuf) * 31) + this.msSndTsbPdDelay) * 31) + this.pktRcvBuf) * 31) + this.byteRcvBuf) * 31) + this.msRcvBuf) * 31) + this.msRcvTsbPdDelay) * 31) + this.pktSndFilterExtraTotal) * 31) + this.pktRcvFilterExtraTotal) * 31) + this.pktRcvFilterSupplyTotal) * 31) + this.pktRcvFilterLossTotal) * 31) + this.pktSndFilterExtra) * 31) + this.pktRcvFilterExtra) * 31) + this.pktRcvFilterSupply) * 31) + this.pktRcvFilterLoss) * 31) + this.pktReorderTolerance) * 31;
        long j23 = this.pktSentUniqueTotal;
        int i29 = (i28 + ((int) (j23 ^ (j23 >>> 32)))) * 31;
        long j24 = this.pktRecvUniqueTotal;
        int i30 = (i29 + ((int) (j24 ^ (j24 >>> 32)))) * 31;
        long j25 = this.byteSentUniqueTotal;
        int i31 = (i30 + ((int) (j25 ^ (j25 >>> 32)))) * 31;
        long j26 = this.byteRecvUniqueTotal;
        int i32 = (i31 + ((int) (j26 ^ (j26 >>> 32)))) * 31;
        long j27 = this.pktSentUnique;
        int i33 = (i32 + ((int) (j27 ^ (j27 >>> 32)))) * 31;
        long j28 = this.pktRecvUnique;
        int i34 = (i33 + ((int) (j28 ^ (j28 >>> 32)))) * 31;
        long j29 = this.byteSentUnique;
        int i35 = (i34 + ((int) (j29 ^ (j29 >>> 32)))) * 31;
        long j30 = this.byteRecvUnique;
        return i35 + ((int) ((j30 >>> 32) ^ j30));
    }

    public String toString() {
        return "Stats(msTimeStamp=" + this.msTimeStamp + ", pktSentTotal=" + this.pktSentTotal + ", pktRecvTotal=" + this.pktRecvTotal + ", pktSndLossTotal=" + this.pktSndLossTotal + ", pktRcvLossTotal=" + this.pktRcvLossTotal + ", pktRetransTotal=" + this.pktRetransTotal + ", pktSentACKTotal=" + this.pktSentACKTotal + ", pktRecvACKTotal=" + this.pktRecvACKTotal + ", pktSentNAKTotal=" + this.pktSentNAKTotal + ", pktRecvNAKTotal=" + this.pktRecvNAKTotal + ", usSndDurationTotal=" + this.usSndDurationTotal + ", pktSndDropTotal=" + this.pktSndDropTotal + ", pktRcvDropTotal=" + this.pktRcvDropTotal + ", pktRcvUndecryptTotal=" + this.pktRcvUndecryptTotal + ", byteSentTotal=" + this.byteSentTotal + ", byteRecvTotal=" + this.byteRecvTotal + ", byteRcvLossTotal=" + this.byteRcvLossTotal + ", byteRetransTotal=" + this.byteRetransTotal + ", byteSndDropTotal=" + this.byteSndDropTotal + ", byteRcvDropTotal=" + this.byteRcvDropTotal + ", byteRcvUndecryptTotal=" + this.byteRcvUndecryptTotal + ", pktSent=" + this.pktSent + ", pktRecv=" + this.pktRecv + ", pktSndLoss=" + this.pktSndLoss + ", pktRcvLoss=" + this.pktRcvLoss + ", pktRetrans=" + this.pktRetrans + ", pktRcvRetrans=" + this.pktRcvRetrans + ", pktSentACK=" + this.pktSentACK + ", pktRecvACK=" + this.pktRecvACK + ", pktSentNAK=" + this.pktSentNAK + ", pktRecvNAK=" + this.pktRecvNAK + ", mbpsSendRate=" + this.mbpsSendRate + ", mbpsRecvRate=" + this.mbpsRecvRate + ", usSndDuration=" + this.usSndDuration + ", pktReorderDistance=" + this.pktReorderDistance + ", pktRcvAvgBelatedTime=" + this.pktRcvAvgBelatedTime + ", pktRcvBelated=" + this.pktRcvBelated + ", pktSndDrop=" + this.pktSndDrop + ", pktRcvDrop=" + this.pktRcvDrop + ", pktRcvUndecrypt=" + this.pktRcvUndecrypt + ", byteSent=" + this.byteSent + ", byteRecv=" + this.byteRecv + ", byteRcvLoss=" + this.byteRcvLoss + ", byteRetrans=" + this.byteRetrans + ", byteSndDrop=" + this.byteSndDrop + ", byteRcvDrop=" + this.byteRcvDrop + ", byteRcvUndecrypt=" + this.byteRcvUndecrypt + ", usPktSndPeriod=" + this.usPktSndPeriod + ", pktFlowWindow=" + this.pktFlowWindow + ", pktCongestionWindow=" + this.pktCongestionWindow + ", pktFlightSize=" + this.pktFlightSize + ", msRTT=" + this.msRTT + ", mbpsBandwidth=" + this.mbpsBandwidth + ", byteAvailSndBuf=" + this.byteAvailSndBuf + ", byteAvailRcvBuf=" + this.byteAvailRcvBuf + ", mbpsMaxBW=" + this.mbpsMaxBW + ", byteMSS=" + this.byteMSS + ", pktSndBuf=" + this.pktSndBuf + ", byteSndBuf=" + this.byteSndBuf + ", msSndBuf=" + this.msSndBuf + ", msSndTsbPdDelay=" + this.msSndTsbPdDelay + ", pktRcvBuf=" + this.pktRcvBuf + ", byteRcvBuf=" + this.byteRcvBuf + ", msRcvBuf=" + this.msRcvBuf + ", msRcvTsbPdDelay=" + this.msRcvTsbPdDelay + ", pktSndFilterExtraTotal=" + this.pktSndFilterExtraTotal + ", pktRcvFilterExtraTotal=" + this.pktRcvFilterExtraTotal + ", pktRcvFilterSupplyTotal=" + this.pktRcvFilterSupplyTotal + ", pktRcvFilterLossTotal=" + this.pktRcvFilterLossTotal + ", pktSndFilterExtra=" + this.pktSndFilterExtra + ", pktRcvFilterExtra=" + this.pktRcvFilterExtra + ", pktRcvFilterSupply=" + this.pktRcvFilterSupply + ", pktRcvFilterLoss=" + this.pktRcvFilterLoss + ", pktReorderTolerance=" + this.pktReorderTolerance + ", pktSentUniqueTotal=" + this.pktSentUniqueTotal + ", pktRecvUniqueTotal=" + this.pktRecvUniqueTotal + ", byteSentUniqueTotal=" + this.byteSentUniqueTotal + ", byteRecvUniqueTotal=" + this.byteRecvUniqueTotal + ", pktSentUnique=" + this.pktSentUnique + ", pktRecvUnique=" + this.pktRecvUnique + ", byteSentUnique=" + this.byteSentUnique + ", byteRecvUnique=" + this.byteRecvUnique + ")";
    }
}
