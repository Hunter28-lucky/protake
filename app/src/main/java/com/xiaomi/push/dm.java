package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.af;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: classes2.dex */
public abstract class dm extends af.a {
    public int a;

    /* renamed from: a, reason: collision with other field name */
    public Context f5736a;

    public dm(Context context, int i) {
        this.a = i;
        this.f5736a = context;
    }

    private String c() {
        return "dc_job_result_time_" + mo5248a();
    }

    private String d() {
        return "dc_job_result_" + mo5248a();
    }

    public abstract gi a();

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5336a() {
        return dj.a(this.f5736a, String.valueOf(mo5248a()), this.a);
    }

    public abstract String b();

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5337b() {
        return true;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5338c() {
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        if (m5336a()) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("DC run job mutual: " + mo5248a());
            return;
        }
        dg dgVarM5334a = dh.a().m5334a();
        String strA = dgVarM5334a == null ? "" : dgVarM5334a.a();
        if (!TextUtils.isEmpty(strA) && m5337b()) {
            if (m5338c()) {
                SharedPreferences sharedPreferences = this.f5736a.getSharedPreferences("mipush_extra", 0);
                if (bc.a(strB).equals(sharedPreferences.getString(d(), null))) {
                    long j = sharedPreferences.getLong(c(), 0L);
                    int iA = com.xiaomi.push.service.ah.a(this.f5736a).a(gl.DCJobUploadRepeatedInterval.a(), 604800);
                    if ((System.currentTimeMillis() - j) / 1000 < this.a) {
                        return;
                    }
                    if ((System.currentTimeMillis() - j) / 1000 < iA) {
                        strB = "same_" + j;
                    }
                }
            }
            go goVar = new go();
            goVar.a(strB);
            goVar.a(System.currentTimeMillis());
            goVar.a(a());
            a(this.f5736a, goVar, strA);
        }
    }

    public static void a(Context context, go goVar) {
        dg dgVarM5334a = dh.a().m5334a();
        String strA = dgVarM5334a == null ? "" : dgVarM5334a.a();
        if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(goVar.a())) {
            return;
        }
        a(context, goVar, strA);
    }

    private static void a(Context context, go goVar, String str) {
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        byte[] bArrB = dj.b(str, hq.a(goVar));
        if (bArrB == null || bArrB.length == 0) {
            return;
        }
        synchronized (dk.a) {
            FileLock fileLock = null;
            BufferedOutputStream bufferedOutputStream2 = null;
            fileLock = null;
            fileLock = null;
            fileLock = null;
            try {
                try {
                    File file = new File(context.getFilesDir(), "push_cdata.lock");
                    x.m5831a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        FileLock fileLockLock = randomAccessFile.getChannel().lock();
                        try {
                            File file2 = new File(context.getFilesDir(), "push_cdata.data");
                            if (w.m5830a(file2)) {
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, true));
                                try {
                                    bufferedOutputStream.write(z.a(bArrB.length));
                                    bufferedOutputStream.write(bArrB);
                                    bufferedOutputStream.flush();
                                    file2.setLastModified(0L);
                                    bufferedOutputStream2 = bufferedOutputStream;
                                } catch (IOException e2) {
                                    e = e2;
                                    fileLock = fileLockLock;
                                    try {
                                        e.printStackTrace();
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException unused) {
                                            }
                                        }
                                        x.a(bufferedOutputStream);
                                        x.a(randomAccessFile);
                                    } catch (Throwable th) {
                                        th = th;
                                        if (fileLock != null && fileLock.isValid()) {
                                            try {
                                                fileLock.release();
                                            } catch (IOException unused2) {
                                            }
                                        }
                                        x.a(bufferedOutputStream);
                                        x.a(randomAccessFile);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileLock = fileLockLock;
                                    if (fileLock != null) {
                                        fileLock.release();
                                    }
                                    x.a(bufferedOutputStream);
                                    x.a(randomAccessFile);
                                    throw th;
                                }
                            }
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException unused3) {
                                }
                            }
                            x.a(bufferedOutputStream2);
                        } catch (IOException e3) {
                            e = e3;
                            bufferedOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedOutputStream = null;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        bufferedOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                }
                x.a(randomAccessFile);
            } catch (Throwable th6) {
                throw th6;
            }
        }
    }
}
