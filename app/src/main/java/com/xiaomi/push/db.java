package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
class db {
    private static String a = "/MiPushLog";

    /* renamed from: a, reason: collision with other field name */
    private int f5705a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f5708a;

    /* renamed from: b, reason: collision with other field name */
    private String f5709b;
    private String c;

    /* renamed from: a, reason: collision with other field name */
    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat f5706a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int b = 2097152;

    /* renamed from: a, reason: collision with other field name */
    private ArrayList<File> f5707a = new ArrayList<>();

    public db a(Date date, Date date2) {
        if (date.after(date2)) {
            this.f5709b = this.f5706a.format(date2);
            this.c = this.f5706a.format(date);
        } else {
            this.f5709b = this.f5706a.format(date);
            this.c = this.f5706a.format(date2);
        }
        return this;
    }

    public void a(int i) {
        if (i != 0) {
            this.b = i;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public db m5326a(File file) {
        if (file.exists()) {
            this.f5707a.add(file);
        }
        return this;
    }

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) throws IOException {
        char[] cArr = new char[4096];
        int i = bufferedReader.read(cArr);
        boolean z = false;
        while (i != -1 && !z) {
            String str = new String(cArr, 0, i);
            Matcher matcher = pattern.matcher(str);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= i || !matcher.find(i2)) {
                    break;
                }
                int iStart = matcher.start();
                String strSubstring = str.substring(iStart, this.f5709b.length() + iStart);
                if (!this.f5708a) {
                    if (strSubstring.compareTo(this.f5709b) >= 0) {
                        this.f5708a = true;
                        i3 = iStart;
                    }
                } else if (strSubstring.compareTo(this.c) > 0) {
                    z = true;
                    i = iStart;
                    break;
                }
                int iIndexOf = str.indexOf(10, iStart);
                if (iIndexOf == -1) {
                    iIndexOf = this.f5709b.length();
                }
                i2 = iStart + iIndexOf;
            }
            if (this.f5708a) {
                int i4 = i - i3;
                this.f5705a += i4;
                if (z) {
                    bufferedWriter.write(cArr, i3, i4);
                    return;
                } else {
                    bufferedWriter.write(cArr, i3, i4);
                    if (this.f5705a > this.b) {
                        return;
                    }
                }
            }
            i = bufferedReader.read(cArr);
        }
    }

    private void a(File file) throws Throwable {
        BufferedReader bufferedReader;
        Pattern patternCompile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter.write("model :" + k.a() + "; os :" + j.e() + "; uid :" + com.xiaomi.push.service.ax.m5771a() + "; lng :" + Locale.getDefault().toString() + "; sdk :48; andver :" + Build.VERSION.SDK_INT + "\n");
                    this.f5705a = 0;
                    Iterator<File> it = this.f5707a.iterator();
                    while (it.hasNext()) {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                        try {
                            a(bufferedReader, bufferedWriter, patternCompile);
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader;
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            bufferedReader2 = bufferedWriter;
                            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                            x.a(bufferedReader2);
                            x.a(bufferedReader);
                            return;
                        } catch (IOException e3) {
                            e = e3;
                            bufferedReader2 = bufferedWriter;
                            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter error = " + e.getMessage());
                            x.a(bufferedReader2);
                            x.a(bufferedReader);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedWriter;
                            x.a(bufferedReader2);
                            x.a(bufferedReader);
                            throw th;
                        }
                    }
                    bufferedWriter.write(ch.a().c());
                    x.a(bufferedWriter);
                    x.a(bufferedReader2);
                } catch (FileNotFoundException e4) {
                    e = e4;
                    bufferedReader = bufferedReader2;
                } catch (IOException e5) {
                    e = e5;
                    bufferedReader = bufferedReader2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedReader = null;
            } catch (IOException e7) {
                e = e7;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public File a(Context context, Date date, Date date2, File file) throws Throwable {
        File fileA;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            fileA = da.a(context);
            if (fileA == null) {
                return null;
            }
            m5326a(new File(fileA, "xmsf.log.1"));
            m5326a(new File(fileA, "xmsf.log"));
        } else {
            File file2 = new File(context.getFilesDir() + a);
            if (!w.m5830a(file2)) {
                return null;
            }
            m5326a(new File(file2, "log0.txt"));
            m5326a(new File(file2, "log1.txt"));
            fileA = file2;
        }
        if (!fileA.isDirectory()) {
            return null;
        }
        File file3 = new File(file, date.getTime() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + ".zip");
        if (file3.exists()) {
            return null;
        }
        a(date, date2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file4 = new File(file, "log.txt");
        a(file4);
        com.xiaomi.channel.commonutils.logger.b.c("LOG: filter cost = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        if (file4.exists()) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            x.a(file3, file4);
            com.xiaomi.channel.commonutils.logger.b.c("LOG: zip cost = " + (System.currentTimeMillis() - jCurrentTimeMillis2));
            file4.delete();
            if (file3.exists()) {
                return file3;
            }
        }
        return null;
    }
}
