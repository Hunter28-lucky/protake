package defpackage;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import java.io.File;
import java.io.IOException;
import java.util.WeakHashMap;

/* compiled from: FileMedia.java */
/* renamed from: ཞ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5052 {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static WeakHashMap<String, C5052> f16828 = new WeakHashMap<>();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public long f16829;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f16830;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f16831;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public MediaFormat f16832;

    /* renamed from: ԫ, reason: contains not printable characters */
    public MediaFormat f16833;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public long f16834;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f16835;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f16836;

    public C5052(long j, String str, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        File file = new File(str);
        this.f16829 = j;
        this.f16830 = str;
        this.f16831 = file.getName();
        this.f16832 = mediaFormat;
        this.f16833 = mediaFormat2;
        this.f16834 = file.lastModified();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static synchronized C5052 m14865(File file) {
        int integer;
        int integer2;
        long j;
        try {
            String absolutePath = file.getAbsolutePath();
            if (f16828.containsKey(absolutePath)) {
                C5052 c5052 = f16828.get(absolutePath);
                if (c5052 != null && c5052.f16834 == file.lastModified()) {
                    return c5052;
                }
                f16828.remove(absolutePath);
            }
            MediaExtractor mediaExtractorM15175 = C5205.m15175(absolutePath);
            MediaFormat mediaFormatM15179 = C5205.m15179(mediaExtractorM15175);
            if (mediaFormatM15179 != null) {
                j = mediaFormatM15179.getLong("durationUs");
                integer = mediaFormatM15179.getInteger("width");
                integer2 = mediaFormatM15179.getInteger("height");
            } else {
                integer = 16;
                integer2 = 16;
                j = Long.MAX_VALUE;
            }
            MediaFormat mediaFormatM15177 = C5205.m15177(mediaExtractorM15175);
            long jMin = Math.min(j, mediaFormatM15177 != null ? mediaFormatM15177.getLong("durationUs") : Long.MAX_VALUE);
            if (jMin <= 0) {
                return null;
            }
            C5052 c50522 = new C5052(jMin, absolutePath, mediaFormatM15179, mediaFormatM15177);
            c50522.f16835 = integer;
            c50522.f16836 = integer2;
            f16828.put(absolutePath, c50522);
            mediaExtractorM15175.release();
            return c50522;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static C5052 m14866(String str) {
        return m14865(new File(str));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public int m14867() {
        return this.f16836;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int m14868() {
        return this.f16835;
    }
}
