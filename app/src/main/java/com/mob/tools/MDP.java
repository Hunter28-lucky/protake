package com.mob.tools;

import com.blink.academy.film.http.okhttp.OkHttpUtils;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.face.ModuleDescriptor;
import com.mob.commons.u;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.e;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class MDP implements PublicMemberKeeper {
    private static Object a = new Object();

    public static Object get(String str, ArrayList<Object> arrayList) {
        return get(str, arrayList, false, 0);
    }

    private static Object a(String str, BlockingQueue blockingQueue) throws InterruptedException {
        return blockingQueue.poll(("gia".equals(str) || "gal".equals(str) || "gsl".equals(str)) ? 30000 : "glctn".equals(str) ? OkHttpUtils.DEFAULT_MILLISECONDS : "rgwsr".equals(str) ? ModuleDescriptor.MODULE_VERSION : 3000, TimeUnit.MILLISECONDS);
    }

    public static Object get(String str, ArrayList<Object> arrayList, int i) {
        return get(str, arrayList, false, i);
    }

    public static Object get(String str, ArrayList<Object> arrayList, boolean z) {
        return get(str, arrayList, z, 0);
    }

    public static Object get(final String str, final ArrayList<Object> arrayList, boolean z, int i) {
        Object objPoll;
        if (z) {
            return com.mob.tools.b.a.a(str, arrayList);
        }
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        u.f17687e.execute(new e() { // from class: com.mob.tools.MDP.1
            @Override // com.mob.tools.utils.e
            public void a() {
                Object objA = com.mob.tools.b.a.a(str, arrayList);
                if (objA == null) {
                    objA = MDP.a;
                }
                linkedBlockingQueue.offer(objA);
            }
        });
        try {
            if (i <= 0) {
                objPoll = a(str, linkedBlockingQueue);
            } else {
                objPoll = linkedBlockingQueue.poll(i, TimeUnit.MILLISECONDS);
            }
            if (objPoll == a) {
                return null;
            }
            return objPoll;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }
}
