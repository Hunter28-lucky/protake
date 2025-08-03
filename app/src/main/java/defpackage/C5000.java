package defpackage;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MediaCodecHelper.java */
/* renamed from: ຽ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5000 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static List<MediaCodecInfo> m14787(String str) {
        MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : codecInfos) {
            String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
            if (mediaCodecInfo.isEncoder()) {
                int length = supportedTypes.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (supportedTypes[i].equalsIgnoreCase(str)) {
                        arrayList.add(mediaCodecInfo);
                        break;
                    }
                    i++;
                }
            }
        }
        return arrayList;
    }
}
