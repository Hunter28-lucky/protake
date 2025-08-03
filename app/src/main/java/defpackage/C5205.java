package defpackage;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import java.io.File;
import java.io.IOException;

/* compiled from: MediaUtils.java */
/* renamed from: Ⴊ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5205 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int f17260;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static synchronized MediaExtractor m15175(String str) throws IOException {
        MediaExtractor mediaExtractor;
        try {
            mediaExtractor = new MediaExtractor();
            String str2 = String.format("id:%d file:%s", Integer.valueOf(m15178()), new File(str).getName());
            mediaExtractor.setDataSource(str);
            m15176(str2, mediaExtractor);
        } catch (IOException e2) {
            e2.printStackTrace();
            throw e2;
        }
        return mediaExtractor;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static synchronized void m15176(String str, MediaExtractor mediaExtractor) {
        for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            if (trackFormat != null) {
                trackFormat.getString("mime");
            }
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static MediaFormat m15177(MediaExtractor mediaExtractor) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
                try {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
                    if (trackFormat.getString("mime").startsWith("audio/")) {
                        mediaExtractor.selectTrack(i2);
                        return trackFormat;
                    }
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                    return null;
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            Thread.sleep(250L);
        }
        return null;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static synchronized int m15178() {
        int i;
        i = f17260;
        f17260 = i + 1;
        return i;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static MediaFormat m15179(MediaExtractor mediaExtractor) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < mediaExtractor.getTrackCount(); i2++) {
                try {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
                    if (trackFormat.getString("mime").startsWith("video/")) {
                        mediaExtractor.selectTrack(i2);
                        return trackFormat;
                    }
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                    return null;
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            Thread.sleep(250L);
        }
        return null;
    }
}
