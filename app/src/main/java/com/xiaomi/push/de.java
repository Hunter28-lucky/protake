package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class de implements LoggerInterface {
    private static volatile de a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5727a;

    /* renamed from: a, reason: collision with other field name */
    private Handler f5728a;
    private String b;

    /* renamed from: a, reason: collision with other field name */
    private static final SimpleDateFormat f5725a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* renamed from: a, reason: collision with other field name */
    public static String f5724a = "/MiPushLog";

    /* renamed from: a, reason: collision with other field name */
    private static List<Pair<String, Throwable>> f5726a = Collections.synchronizedList(new ArrayList());

    private de(Context context) {
        this.f5727a = context;
        if (context.getApplicationContext() != null) {
            this.f5727a = context.getApplicationContext();
        }
        this.b = this.f5727a.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Process.myPid();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f5728a = new Handler(handlerThread.getLooper());
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(String str) {
        log(str, null);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void setTag(String str) {
        this.b = str;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public final void log(final String str, final Throwable th) {
        this.f5728a.post(new Runnable() { // from class: com.xiaomi.push.de.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                de.f5726a.add(new Pair(String.format("%1$s %2$s %3$s ", de.f5725a.format(new Date()), de.this.b, str), th));
                if (de.f5726a.size() > 20000) {
                    int size = (de.f5726a.size() - 20000) + 50;
                    for (int i = 0; i < size; i++) {
                        try {
                            if (de.f5726a.size() > 0) {
                                de.f5726a.remove(0);
                            }
                        } catch (IndexOutOfBoundsException unused) {
                        }
                    }
                    de.f5726a.add(new Pair(String.format("%1$s %2$s %3$s ", de.f5725a.format(new Date()), de.this.b, "flush " + size + " lines logs."), null));
                }
                try {
                    de.this.m5332a();
                } catch (Exception e2) {
                    Log.e(de.this.b, "", e2);
                }
            }
        });
    }

    public static de a(Context context) {
        if (a == null) {
            synchronized (de.class) {
                if (a == null) {
                    a = new de(context);
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x015b -> B:102:0x0160). Please report as a decompilation issue!!! */
    /* renamed from: a, reason: collision with other method in class */
    public void m5332a() throws Throwable {
        RandomAccessFile randomAccessFile;
        FileLock fileLockLock;
        File file;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    file = new File(this.f5727a.getFilesDir(), f5724a);
                } catch (Exception e2) {
                    e = e2;
                    fileLockLock = null;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    fileLockLock = null;
                    randomAccessFile = null;
                }
            } catch (IOException e3) {
                Log.e(this.b, "", e3);
            }
            if (!w.m5830a(file)) {
                Log.w(this.b, "Cannot wirte internal file: " + file);
                return;
            }
            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                Log.w(this.b, "Create mipushlog directory fail.");
                return;
            }
            File file2 = new File(file, "log.lock");
            if (!file2.exists() || file2.isDirectory()) {
                file2.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                fileLockLock = randomAccessFile.getChannel().lock();
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                    while (!f5726a.isEmpty()) {
                        try {
                            Pair<String, Throwable> pairRemove = f5726a.remove(0);
                            String str = (String) pairRemove.first;
                            if (pairRemove.second != null) {
                                str = (str + "\n") + Log.getStackTraceString((Throwable) pairRemove.second);
                            }
                            bufferedWriter2.write(str + "\n");
                        } catch (Exception e4) {
                            e = e4;
                            bufferedWriter = bufferedWriter2;
                            Log.e(this.b, "", e);
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e5) {
                                    Log.e(this.b, "", e5);
                                }
                            }
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e6) {
                                    Log.e(this.b, "", e6);
                                }
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e7) {
                                    Log.e(this.b, "", e7);
                                }
                            }
                            if (fileLockLock != null && fileLockLock.isValid()) {
                                try {
                                    fileLockLock.release();
                                } catch (IOException e8) {
                                    Log.e(this.b, "", e8);
                                }
                            }
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                    throw th;
                                } catch (IOException e9) {
                                    Log.e(this.b, "", e9);
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    File file3 = new File(file, "log1.txt");
                    if (file3.length() >= Config.DEFAULT_MAX_FILE_LENGTH) {
                        File file4 = new File(file, "log0.txt");
                        if (file4.exists() && file4.isFile()) {
                            file4.delete();
                        }
                        file3.renameTo(file4);
                    }
                    if (fileLockLock != null && fileLockLock.isValid()) {
                        try {
                            fileLockLock.release();
                        } catch (IOException e10) {
                            Log.e(this.b, "", e10);
                        }
                    }
                    randomAccessFile.close();
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Exception e12) {
                e = e12;
                fileLockLock = null;
            } catch (Throwable th3) {
                th = th3;
                fileLockLock = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
