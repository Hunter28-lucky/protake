package defpackage;

import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: CodecInfo.java */
/* renamed from: ғ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2958 {

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final String f10680 = "ғ";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String f10681;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final MediaCodecInfo f10682;

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean f10683;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public Range<Integer> f10684;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f10685;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f10686;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Range<Integer> f10687;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public Range<Integer> f10688;

    /* renamed from: ԯ, reason: contains not printable characters */
    public Range<Integer> f10689;

    public C2958(String str, MediaCodecInfo mediaCodecInfo) {
        if (mediaCodecInfo == null) {
            throw new RuntimeException(" mediaCodecInfo is null ! ");
        }
        this.f10681 = str;
        this.f10682 = mediaCodecInfo;
        m10369();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Range<Integer> m10367() {
        return this.f10689;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Range<Integer> m10368() {
        return this.f10688;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m10369() {
        int i;
        char c;
        String[] supportedTypes = this.f10682.getSupportedTypes();
        String name = this.f10682.getName();
        int i2 = Build.VERSION.SDK_INT;
        char c2 = 29;
        int i3 = 1;
        String str = String.format("name : %s , canonicalName : %s ", name, i2 >= 29 ? this.f10682.getCanonicalName() : null);
        String str2 = f10680;
        C4638.m14099(str2, str);
        if (i2 >= 29) {
            C4638.m14099(str2, String.format("softwareOnly : %s , alias : %s , hardwareAccelerated : %s , vendor : %s ", Boolean.valueOf(this.f10682.isSoftwareOnly()), Boolean.valueOf(this.f10682.isAlias()), Boolean.valueOf(this.f10682.isHardwareAccelerated()), Boolean.valueOf(this.f10682.isVendor())));
        }
        C4638.m14099(str2, String.format("supportedTypes : %s ", Arrays.toString(supportedTypes)));
        int length = supportedTypes.length;
        int i4 = 0;
        while (i4 < length) {
            String str3 = supportedTypes[i4];
            if (this.f10681.equals(str3)) {
                MediaCodecInfo.CodecCapabilities capabilitiesForType = this.f10682.getCapabilitiesForType(str3);
                int[] iArr = capabilitiesForType.colorFormats;
                Object[] objArr = new Object[i3];
                objArr[0] = Arrays.toString(iArr);
                C4638.m14099(f10680, String.format("colorFormats : %s ", objArr));
                this.f10683 = m10370(iArr, 2130708361);
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                HashMap map = new HashMap();
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
                    int i5 = codecProfileLevel.profile;
                    int i6 = codecProfileLevel.level;
                    ArrayList arrayList = (ArrayList) map.get(String.valueOf(i5));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(String.valueOf(i6));
                    map.put(String.valueOf(i5), arrayList);
                    C4638.m14099(f10680, String.format("profileLevel profile : %s , level : %s ", Integer.valueOf(i5), Integer.valueOf(i6)));
                }
                for (String str4 : map.keySet()) {
                    ArrayList arrayList2 = (ArrayList) map.get(str4);
                    C4638.m14099(f10680, arrayList2 != null ? String.format("profileLevel profile : %s , level : %s ", str4, arrayList2.toString()) : null);
                }
                String str5 = String.format("maxSupportedInstances : %s , mimeType : %s ", Integer.valueOf(capabilitiesForType.getMaxSupportedInstances()), capabilitiesForType.getMimeType());
                String str6 = f10680;
                C4638.m14099(str6, str5);
                C4638.m14099(str6, String.format("defaultFormat : %s ", capabilitiesForType.getDefaultFormat()));
                MediaCodecInfo.AudioCapabilities audioCapabilities = capabilitiesForType.getAudioCapabilities();
                if (audioCapabilities != null) {
                    Range<Integer> bitrateRange = audioCapabilities.getBitrateRange();
                    int maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
                    Range<Integer>[] supportedSampleRateRanges = audioCapabilities.getSupportedSampleRateRanges();
                    int[] supportedSampleRates = audioCapabilities.getSupportedSampleRates();
                    i = 1;
                    C4638.m14099(str6, String.format("bitrateRange : %s ", bitrateRange));
                    C4638.m14099(str6, String.format("maxInputChannelCount : %s ", Integer.valueOf(maxInputChannelCount)));
                    C4638.m14099(str6, String.format("supportedSampleRateRanges : %s ", Arrays.toString(supportedSampleRateRanges)));
                    C4638.m14099(str6, String.format("supportedSampleRates : %s ", Arrays.toString(supportedSampleRates)));
                } else {
                    i = 1;
                    C4638.m14099(str6, String.format("audioCapabilities : %s ", "null"));
                }
                MediaCodecInfo.EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
                if (encoderCapabilities != null) {
                    Object[] objArr2 = new Object[i];
                    objArr2[0] = encoderCapabilities.getComplexityRange();
                    C4638.m14099(str6, String.format("complexityRange : %s ", objArr2));
                    if (Build.VERSION.SDK_INT >= 28) {
                        Object[] objArr3 = new Object[i];
                        objArr3[0] = encoderCapabilities.getQualityRange();
                        C4638.m14099(str6, String.format("qualityRange : %s ", objArr3));
                    }
                } else {
                    Object[] objArr4 = new Object[i];
                    objArr4[0] = "null";
                    C4638.m14099(str6, String.format("encoderCapabilities : %s ", objArr4));
                }
                MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                if (videoCapabilities != null) {
                    Range<Integer> bitrateRange2 = videoCapabilities.getBitrateRange();
                    Object[] objArr5 = new Object[i];
                    objArr5[0] = bitrateRange2;
                    C4638.m14099(str6, String.format("videoBitrateRange : %s ", objArr5));
                    this.f10684 = bitrateRange2;
                    int widthAlignment = videoCapabilities.getWidthAlignment();
                    Object[] objArr6 = new Object[i];
                    objArr6[0] = Integer.valueOf(widthAlignment);
                    C4638.m14099(str6, String.format("widthAlignment : %s ", objArr6));
                    this.f10685 = widthAlignment;
                    int heightAlignment = videoCapabilities.getHeightAlignment();
                    Object[] objArr7 = new Object[i];
                    objArr7[0] = Integer.valueOf(heightAlignment);
                    C4638.m14099(str6, String.format("heightAlignment : %s ", objArr7));
                    this.f10686 = heightAlignment;
                    Range<Integer> supportedFrameRates = videoCapabilities.getSupportedFrameRates();
                    Object[] objArr8 = new Object[i];
                    objArr8[0] = supportedFrameRates;
                    C4638.m14099(str6, String.format("supportedFrameRates : %s ", objArr8));
                    this.f10687 = supportedFrameRates;
                    Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
                    Object[] objArr9 = new Object[i];
                    objArr9[0] = supportedWidths;
                    C4638.m14099(str6, String.format("supportedWidths : %s ", objArr9));
                    this.f10688 = supportedWidths;
                    Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
                    Object[] objArr10 = new Object[i];
                    objArr10[0] = supportedHeights;
                    C4638.m14099(str6, String.format("supportedHeights : %s ", objArr10));
                    this.f10689 = supportedHeights;
                    c = 29;
                    if (Build.VERSION.SDK_INT >= 29) {
                        videoCapabilities.getSupportedPerformancePoints();
                    }
                    i3 = 1;
                } else {
                    i3 = i;
                    c = 29;
                    Object[] objArr11 = new Object[i3];
                    objArr11[0] = "null";
                    C4638.m14099(str6, String.format("videoCapabilities : %s ", objArr11));
                }
            } else {
                c = c2;
            }
            i4++;
            c2 = c;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final boolean m10370(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }
}
