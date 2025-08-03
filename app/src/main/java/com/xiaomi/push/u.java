package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class u {
    private static final Set<String> a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a, reason: collision with other field name */
    private Context f6508a;

    /* renamed from: a, reason: collision with other field name */
    private RandomAccessFile f6509a;

    /* renamed from: a, reason: collision with other field name */
    private String f6510a;

    /* renamed from: a, reason: collision with other field name */
    private FileLock f6511a;

    private u(Context context) {
        this.f6508a = context;
    }

    public static u a(Context context, File file) throws IOException {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        Set<String> set = a;
        if (!set.add(str)) {
            throw new IOException("abtain lock failure");
        }
        u uVar = new u(context);
        uVar.f6510a = str;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            uVar.f6509a = randomAccessFile;
            uVar.f6511a = randomAccessFile.getChannel().lock();
            com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + uVar.f6511a);
            if (uVar.f6511a == null) {
                RandomAccessFile randomAccessFile2 = uVar.f6509a;
                if (randomAccessFile2 != null) {
                    x.a(randomAccessFile2);
                }
                set.remove(uVar.f6510a);
            }
            return uVar;
        } catch (Throwable th) {
            if (uVar.f6511a == null) {
                RandomAccessFile randomAccessFile3 = uVar.f6509a;
                if (randomAccessFile3 != null) {
                    x.a(randomAccessFile3);
                }
                a.remove(uVar.f6510a);
            }
            throw th;
        }
    }

    public void a() throws IOException {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f6511a);
        FileLock fileLock = this.f6511a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f6511a.release();
            } catch (IOException unused) {
            }
            this.f6511a = null;
        }
        RandomAccessFile randomAccessFile = this.f6509a;
        if (randomAccessFile != null) {
            x.a(randomAccessFile);
        }
        a.remove(this.f6510a);
    }
}
