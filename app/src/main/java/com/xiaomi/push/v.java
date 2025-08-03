package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class v implements Runnable {
    private Context a;

    /* renamed from: a, reason: collision with other field name */
    private File f6512a;

    /* renamed from: a, reason: collision with other field name */
    private Runnable f6513a;

    public static void a(Context context, File file, final Runnable runnable) throws IOException {
        new v(context, file) { // from class: com.xiaomi.push.v.1
            @Override // com.xiaomi.push.v
            public void a(Context context2) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        }.run();
    }

    public abstract void a(Context context);

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        u uVarA = null;
        try {
            try {
                if (this.f6512a == null) {
                    this.f6512a = new File(this.a.getFilesDir(), "default_locker");
                }
                uVarA = u.a(this.a, this.f6512a);
                Runnable runnable = this.f6513a;
                if (runnable != null) {
                    runnable.run();
                }
                a(this.a);
                if (uVarA == null) {
                    return;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (uVarA == null) {
                    return;
                }
            }
            uVarA.a();
        } catch (Throwable th) {
            if (uVarA != null) {
                uVarA.a();
            }
            throw th;
        }
    }

    private v(Context context, File file) {
        this.a = context;
        this.f6512a = file;
    }
}
