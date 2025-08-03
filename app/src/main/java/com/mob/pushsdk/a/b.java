package com.mob.pushsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.mob.tools.utils.BitmapHelper;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public class b implements Runnable {
    private CountDownLatch a;
    private Context b;
    private String c;
    private a d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f17692e;
    private int f;

    public interface a {
        void a(int i, Bitmap bitmap);
    }

    public b(Context context, CountDownLatch countDownLatch, int i, String str, a aVar) {
        this.a = countDownLatch;
        this.f = i;
        this.c = str;
        this.b = context;
        this.d = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Bitmap bitmap = BitmapHelper.getBitmap(this.b, this.c);
            this.f17692e = bitmap;
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(this.f, bitmap);
            }
        } catch (Throwable unused) {
            a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.a(this.f, this.f17692e);
            }
        }
        this.a.countDown();
    }
}
