package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.blink.academy.film.http.okhttp.interceptor.CacheInterceptor;
import com.blink.academy.film.stream.FinderManager;
import com.xiaomi.push.af;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.do, reason: invalid class name */
/* loaded from: classes2.dex */
public class Cdo extends af.a {
    private Context a;

    /* renamed from: a, reason: collision with other field name */
    private SharedPreferences f5737a;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.push.service.ah f5738a;

    public Cdo(Context context) {
        this.a = context;
        this.f5737a = context.getSharedPreferences("mipush_extra", 0);
        this.f5738a = com.xiaomi.push.service.ah.a(context);
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m5339a() {
        if (av.d(this.a)) {
            return false;
        }
        if ((av.f(this.a) || av.e(this.a)) && !c()) {
            return true;
        }
        return (av.g(this.a) && !b()) || av.h(this.a);
    }

    private boolean b() {
        if (!this.f5738a.a(gl.Upload3GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f5737a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f5738a.a(gl.Upload3GFrequency.a(), 432000)));
    }

    private boolean c() {
        if (!this.f5738a.a(gl.Upload4GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f5737a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f5738a.a(gl.Upload4GFrequency.a(), CacheInterceptor.maxStale)));
    }

    @Override // com.xiaomi.push.af.a
    /* renamed from: a */
    public String mo5248a() {
        return "1";
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        File file = new File(this.a.getFilesDir(), "push_cdata.data");
        if (!av.c(this.a)) {
            if (file.length() > 1863680) {
                file.delete();
                return;
            }
            return;
        }
        if (!m5339a() && file.exists()) {
            List<go> listA = a(file);
            if (!aa.a(listA)) {
                int size = listA.size();
                if (size > 4000) {
                    listA = listA.subList(size - 4000, size);
                }
                gz gzVar = new gz();
                gzVar.a(listA);
                byte[] bArrA = x.a(hq.a(gzVar));
                hf hfVar = new hf(FinderManager.MACHINE_NOT_VALID, false);
                hfVar.c(gq.DataCollection.f6003a);
                hfVar.a(bArrA);
                dg dgVarM5334a = dh.a().m5334a();
                if (dgVarM5334a != null) {
                    dgVarM5334a.a(hfVar, gg.Notification, null);
                }
                a();
            }
            file.delete();
        }
    }

    private void a() {
        SharedPreferences.Editor editorEdit = this.f5737a.edit();
        editorEdit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        editorEdit.commit();
    }

    private List<go> a(File file) {
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        dg dgVarM5334a = dh.a().m5334a();
        String strA = dgVarM5334a == null ? "" : dgVarM5334a.a();
        FileLock fileLock = null;
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (dk.a) {
            try {
                File file2 = new File(this.a.getFilesDir(), "push_cdata.lock");
                x.m5831a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    FileLock fileLockLock = randomAccessFile.getChannel().lock();
                    try {
                        fileInputStream = new FileInputStream(file);
                        while (fileInputStream.read(bArr) == 4) {
                            try {
                                int iA = z.a(bArr);
                                byte[] bArr2 = new byte[iA];
                                if (fileInputStream.read(bArr2) != iA) {
                                    break;
                                }
                                byte[] bArrA = dj.a(strA, bArr2);
                                if (bArrA != null && bArrA.length != 0) {
                                    go goVar = new go();
                                    hq.a(goVar, bArrA);
                                    arrayList.add(goVar);
                                    a(goVar);
                                }
                            } catch (Exception unused) {
                                fileLock = fileLockLock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                x.a((Closeable) fileInputStream);
                                x.a(randomAccessFile);
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                fileLock = fileLockLock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                x.a((Closeable) fileInputStream);
                                x.a(randomAccessFile);
                                throw th;
                            }
                        }
                        if (fileLockLock != null && fileLockLock.isValid()) {
                            try {
                                fileLockLock.release();
                            } catch (IOException unused4) {
                            }
                        }
                        x.a((Closeable) fileInputStream);
                    } catch (Exception unused5) {
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                    }
                } catch (Exception unused6) {
                    fileInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
            } catch (Exception unused7) {
                randomAccessFile = null;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                fileInputStream = null;
            }
            x.a(randomAccessFile);
        }
        return arrayList;
    }

    private void a(go goVar) {
        if (goVar.f5994a != gi.AppInstallList || goVar.f5995a.startsWith("same_")) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f5737a.edit();
        editorEdit.putLong("dc_job_result_time_4", goVar.f5993a);
        editorEdit.putString("dc_job_result_4", bc.a(goVar.f5995a));
        editorEdit.commit();
    }
}
