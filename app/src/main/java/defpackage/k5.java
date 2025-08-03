package defpackage;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.jcodec.platform.Platform;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class k5 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final Charset f7821 = Charset.forName("US-ASCII");

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Charset f7822 = Charset.forName(Platform.UTF_8);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m7174(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m7175(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                m7175(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }
}
