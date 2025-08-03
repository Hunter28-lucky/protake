package com.xiaomi.push;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: classes2.dex */
public class ad {
    public static boolean a(Context context, String str, long j) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock = null;
        try {
            File file = new File(context.getFilesDir(), "/.vdevdir/");
            if (!w.m5830a(file)) {
                x.a((Closeable) null);
                return true;
            }
            File file2 = new File(file, "lcfp.lock");
            x.m5831a(file2);
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                try {
                    fileLockLock = randomAccessFile.getChannel().lock();
                    boolean zB = b(context, str, j);
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    x.a(randomAccessFile);
                    return zB;
                } catch (Throwable th) {
                    th = th;
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused2) {
                        }
                    }
                    x.a(randomAccessFile);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                if (fileLockLock != null && fileLockLock.isValid()) {
                    try {
                        fileLockLock.release();
                    } catch (IOException unused3) {
                    }
                }
                x.a(randomAccessFile);
                return true;
            }
        } catch (IOException e3) {
            e = e3;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            if (fileLockLock != null) {
                fileLockLock.release();
            }
            x.a(randomAccessFile);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d8 A[Catch: all -> 0x00ec, IOException -> 0x00ef, LOOP:0: B:42:0x00d2->B:44:0x00d8, LOOP_END, TRY_LEAVE, TryCatch #7 {IOException -> 0x00ef, all -> 0x00ec, blocks: (B:41:0x00ce, B:42:0x00d2, B:44:0x00d8), top: B:71:0x00ce }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(android.content.Context r16, java.lang.String r17, long r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ad.b(android.content.Context, java.lang.String, long):boolean");
    }
}
