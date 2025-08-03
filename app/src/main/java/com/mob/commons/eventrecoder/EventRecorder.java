package com.mob.commons.eventrecoder;

import android.text.TextUtils;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.mob.MobSDK;
import com.mob.commons.k;
import com.mob.commons.l;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.FileLocker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class EventRecorder implements PublicMemberKeeper {
    private static File a;
    private static FileOutputStream b;

    public static final synchronized void addBegin(String str, String str2) {
        a(str + MyUTIL.white_space + str2 + " 0\n");
    }

    public static final synchronized void addEnd(String str, String str2) {
        a(str + MyUTIL.white_space + str2 + " 1\n");
    }

    public static final synchronized String checkRecord(final String str) {
        final LinkedList linkedList = new LinkedList();
        a(new k() { // from class: com.mob.commons.eventrecoder.EventRecorder.3
            @Override // com.mob.commons.k
            public boolean a(FileLocker fileLocker) {
                int iIndexOf;
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(EventRecorder.a), "utf-8"));
                    for (String line = bufferedReader.readLine(); !TextUtils.isEmpty(line); line = bufferedReader.readLine()) {
                        String[] strArrSplit = line.split(MyUTIL.white_space);
                        if (str.equals(strArrSplit[0])) {
                            if ("0".equals(strArrSplit[2])) {
                                linkedList.add(strArrSplit[1]);
                            } else if ("1".equals(strArrSplit[2]) && (iIndexOf = linkedList.indexOf(strArrSplit[1])) != -1) {
                                linkedList.remove(iIndexOf);
                            }
                        }
                    }
                    bufferedReader.close();
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
                return false;
            }
        });
        if (linkedList.size() <= 0) {
            return null;
        }
        return (String) linkedList.get(0);
    }

    public static final synchronized void clear() {
        a(new k() { // from class: com.mob.commons.eventrecoder.EventRecorder.4
            @Override // com.mob.commons.k
            public boolean a(FileLocker fileLocker) {
                try {
                    EventRecorder.b.close();
                    EventRecorder.a.delete();
                    File unused = EventRecorder.a = new File(MobSDK.getContext().getFilesDir(), ".mrecord");
                    EventRecorder.a.createNewFile();
                    FileOutputStream unused2 = EventRecorder.b = new FileOutputStream(EventRecorder.a, true);
                    return false;
                } catch (Throwable th) {
                    MobLog.getInstance().w(th);
                    return false;
                }
            }
        });
    }

    public static final synchronized void prepare() {
        a(new k() { // from class: com.mob.commons.eventrecoder.EventRecorder.1
            @Override // com.mob.commons.k
            public boolean a(FileLocker fileLocker) {
                try {
                    File unused = EventRecorder.a = new File(MobSDK.getContext().getFilesDir(), ".mrecord");
                    if (!EventRecorder.a.exists()) {
                        EventRecorder.a.createNewFile();
                    }
                    FileOutputStream unused2 = EventRecorder.b = new FileOutputStream(EventRecorder.a, true);
                    return false;
                } catch (Throwable th) {
                    MobLog.getInstance().w(th);
                    return false;
                }
            }
        });
    }

    private static final void a(k kVar) {
        l.a(new File(MobSDK.getContext().getFilesDir(), l.a), kVar);
    }

    private static final void a(final String str) {
        a(new k() { // from class: com.mob.commons.eventrecoder.EventRecorder.2
            @Override // com.mob.commons.k
            public boolean a(FileLocker fileLocker) {
                try {
                    EventRecorder.b.write(str.getBytes("utf-8"));
                    EventRecorder.b.flush();
                    return false;
                } catch (Throwable th) {
                    MobLog.getInstance().w(th);
                    return false;
                }
            }
        });
    }
}
