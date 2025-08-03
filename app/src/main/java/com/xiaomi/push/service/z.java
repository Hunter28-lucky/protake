package com.xiaomi.push.service;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.push.cf;
import com.xiaomi.push.dp;
import com.xiaomi.push.ep;
import com.xiaomi.push.eq;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class z {

    /* renamed from: a, reason: collision with other field name */
    private static final Pattern f6505a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
    private static long a = 0;

    /* renamed from: a, reason: collision with other field name */
    private static ThreadPoolExecutor f6504a = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            com.xiaomi.channel.commonutils.logger.b.m5113a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(cf.m5290a(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            com.xiaomi.channel.commonutils.logger.b.m5113a("ConnectivityTest: connect to " + str + " in " + (System.currentTimeMillis() - jCurrentTimeMillis));
            socket.close();
            return true;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }

    public static void a() {
        dp.a aVarM5775a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ((f6504a.getActiveCount() <= 0 || jCurrentTimeMillis - a >= 1800000) && ep.m5447a().m5452a() && (aVarM5775a = ax.a().m5775a()) != null && aVarM5775a.e() > 0) {
            a = jCurrentTimeMillis;
            a(aVarM5775a.m5340a(), true);
        }
    }

    public static void a(final List<String> list, final boolean z) {
        f6504a.execute(new Runnable() { // from class: com.xiaomi.push.service.z.1
            @Override // java.lang.Runnable
            public void run() {
                boolean zB = z.b("www.baidu.com:80");
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    zB = zB || z.b((String) it.next());
                    if (zB && !z) {
                        break;
                    }
                }
                eq.a(zB ? 1 : 2);
            }
        });
    }

    private static String a(String str) throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append("\n");
                    sb.append(line);
                } else {
                    String string = sb.toString();
                    com.xiaomi.push.x.a(bufferedReader);
                    return string;
                }
            }
        } catch (Exception unused2) {
            com.xiaomi.push.x.a(bufferedReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            com.xiaomi.push.x.a(bufferedReader);
            throw th;
        }
    }

    public static void b() throws Throwable {
        String strA = a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(strA)) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("dump tcp for uid = " + Process.myUid());
            com.xiaomi.channel.commonutils.logger.b.m5113a(strA);
        }
        String strA2 = a("/proc/self/net/tcp6");
        if (TextUtils.isEmpty(strA2)) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("dump tcp6 for uid = " + Process.myUid());
        com.xiaomi.channel.commonutils.logger.b.m5113a(strA2);
    }
}
