package com.mob.commons.a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.face.ModuleDescriptor;
import com.mob.commons.C5340r;
import com.mob.commons.d;
import com.mob.commons.u;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;

/* loaded from: classes2.dex */
public class d implements Handler.Callback {
    private static d a = new d();
    private Handler b;

    private d() {
        String str;
        if (TextUtils.isEmpty("M-")) {
            str = null;
        } else {
            str = u.a + a("004Yfjhjijhm");
        }
        this.b = MobHandlerThread.newHandler(str, this);
    }

    public static d a() {
        return a;
    }

    public boolean b(long j, Runnable runnable) {
        return a(1004, j * 1000, runnable);
    }

    public boolean c(long j, Runnable runnable) {
        return b(1005, j, runnable);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVarA;
        try {
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        if (!com.mob.commons.b.d()) {
            Message messageObtain = Message.obtain();
            messageObtain.copyFrom(message);
            this.b.sendMessageDelayed(messageObtain, 60000L);
            return false;
        }
        int i = message.what;
        if (i == 1003 || i == 1004) {
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                u.d.execute(runnable);
            }
        } else if (i == 1002) {
            d.c cVar = (d.c) message.obj;
            if (cVar != null) {
                if (!cVar.a) {
                    cVar.a = true;
                }
                u.d.execute(cVar);
                int i2 = message.arg1;
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 1002;
                messageObtain2.obj = cVar;
                messageObtain2.arg1 = i2;
                a(messageObtain2, i2 * 1000);
            }
        } else if (i == 1005) {
            Runnable runnable2 = (Runnable) message.obj;
            if (runnable2 != null) {
                u.c.execute(runnable2);
            }
        } else if (i >= 10000 || i < -10000) {
            Object[] objArr = (Object[]) message.obj;
            Class cls = (Class) objArr[0];
            if (cls != null && (aVarA = a.a((Class<? extends a>) cls)) != null) {
                Object[] objArr2 = (Object[]) objArr[1];
                aVarA.b = ((Integer) objArr2[0]).intValue();
                aVarA.a = objArr2[1];
                aVarA.e();
            }
        }
        return false;
    }

    public void a(long j, Class<? extends a> cls, Object[] objArr, int i) {
        int iA = a(cls);
        if (i == 1) {
            this.b.removeMessages(iA);
        } else if (i == 2 && this.b.hasMessages(iA)) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = iA;
        messageObtain.obj = new Object[]{cls, objArr};
        a(messageObtain, j * 1000);
    }

    public void b() {
        this.b.removeMessages(1002);
    }

    private boolean b(int i, long j, Runnable runnable) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        messageObtain.obj = runnable;
        a(messageObtain, j);
        return true;
    }

    public boolean a(long j, Runnable runnable) {
        return a(1003, j * 1000, runnable);
    }

    public void a(long j, int i, d.c cVar) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1002;
        messageObtain.arg1 = i;
        messageObtain.obj = cVar;
        a(messageObtain, j * 1000);
    }

    private boolean a(int i, long j, Runnable runnable) {
        if (this.b.hasMessages(i)) {
            return false;
        }
        b(i, j, runnable);
        return true;
    }

    private int a(Class<? extends a> cls) {
        int iHashCode = cls.getName().hashCode();
        return iHashCode > 0 ? iHashCode + ModuleDescriptor.MODULE_VERSION : iHashCode - 10000;
    }

    private void a(Message message, long j) {
        if (j > 0) {
            this.b.sendMessageDelayed(message, j);
        } else {
            this.b.sendMessage(message);
        }
    }

    public static String a(String str) {
        return C5340r.a(str, 100);
    }
}
