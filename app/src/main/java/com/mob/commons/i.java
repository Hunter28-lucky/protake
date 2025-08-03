package com.mob.commons;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.utils.ActivityTracker;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class i {
    private static i a;
    private volatile Handler c;
    private final HashSet<h> b = new HashSet<>();
    private String d = null;

    /* renamed from: e, reason: collision with root package name */
    private volatile long f17679e = -1;

    private i() {
        String str = null;
        if (!TextUtils.isEmpty("M-")) {
            str = u.a + a("004,hmhljkin");
        }
        this.c = MobHandlerThread.newHandler(str, new Handler.Callback() { // from class: com.mob.commons.i.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    i.this.f17679e = SystemClock.elapsedRealtime();
                    i.this.a(false);
                    i.this.c();
                } else if (i == 1) {
                    i.this.a(true);
                } else if (i == 2) {
                    i.this.a(((Long) message.obj).longValue(), true);
                } else if (i == 3) {
                    try {
                        h hVar = (h) message.obj;
                        if (hVar != null) {
                            i.this.b.add(hVar);
                            hVar.a(i.this.f17679e > 0, true, 0L);
                        }
                    } catch (Throwable th) {
                        MobLog.getInstance().d(th);
                    }
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ActivityTracker.getInstance(MobSDK.getContext()).addTracker(new ActivityTracker.Tracker() { // from class: com.mob.commons.FBManager$2
            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onCreated(Activity activity, Bundle bundle) {
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onDestroyed(Activity activity) {
                if (this.a.f17679e > 0) {
                    onStopped(activity);
                }
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onPaused(Activity activity) {
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onResumed(Activity activity) {
                try {
                    if (this.a.f17679e == 0) {
                        this.a.f17679e = SystemClock.elapsedRealtime();
                        if (this.a.c != null) {
                            this.a.c.sendEmptyMessage(1);
                        }
                    }
                    this.a.d = activity == null ? null : activity.toString();
                } catch (Throwable unused) {
                }
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onSaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onStarted(Activity activity) {
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onStopped(Activity activity) {
                try {
                    if (this.a.d != null) {
                        if (!this.a.d.equals(activity == null ? null : activity.toString())) {
                            return;
                        }
                    }
                    if (this.a.c != null) {
                        long jElapsedRealtime = this.a.f17679e > 0 ? SystemClock.elapsedRealtime() - this.a.f17679e : 0L;
                        Message message = new Message();
                        message.what = 2;
                        message.obj = Long.valueOf(jElapsedRealtime);
                        this.a.c.sendMessage(message);
                    }
                    this.a.f17679e = 0L;
                    this.a.d = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    public boolean b() {
        return this.f17679e == 0;
    }

    public static synchronized i a() {
        if (a == null) {
            i iVar = new i();
            a = iVar;
            if (iVar.c != null) {
                a.c.sendEmptyMessage(0);
            }
        }
        return a;
    }

    public void a(h hVar) {
        if (hVar == null) {
            return;
        }
        synchronized (this.b) {
            if (this.b.contains(hVar)) {
                return;
            }
            if (this.c != null) {
                Message message = new Message();
                message.what = 3;
                message.obj = hVar;
                this.c.sendMessage(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            a(true, false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        if (z) {
            a(false, false, j);
        }
    }

    private void a(boolean z, boolean z2, long j) {
        synchronized (this.b) {
            Iterator<h> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(z, z2, j);
            }
        }
    }

    public static String a(String str) {
        return C5340r.a(str, 101);
    }
}
