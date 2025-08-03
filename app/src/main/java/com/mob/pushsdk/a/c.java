package com.mob.pushsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import com.mob.MobSDK;
import com.mob.pushsdk.a.b;
import com.mob.pushsdk.base.PLog;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public class c {
    private Bitmap[] a;
    private a b;

    public interface a {
        void a(Bitmap[] bitmapArr);
    }

    public void a(ArrayList<String> arrayList, a aVar) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.b = aVar;
        Context context = MobSDK.getContext();
        CountDownLatch countDownLatch = new CountDownLatch(arrayList.size());
        this.a = new Bitmap[arrayList.size()];
        b.a aVar2 = new b.a() { // from class: com.mob.pushsdk.a.c.1
            @Override // com.mob.pushsdk.a.b.a
            public void a(int i, Bitmap bitmap) {
                PLog.getInstance().d("result bitmap, index:" + i + ",bmp:" + bitmap, new Object[0]);
                c.this.a[i] = bitmap;
            }
        };
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            new Thread(new b(context, countDownLatch, i2, arrayList.get(i2), aVar2)).start();
        }
        try {
            countDownLatch.await();
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                Bitmap[] bitmapArr = this.a;
                if (i >= bitmapArr.length) {
                    break;
                }
                Bitmap bitmap = bitmapArr[i];
                if (bitmap != null) {
                    arrayList2.add(bitmap);
                }
                i++;
            }
            if (!arrayList2.isEmpty()) {
                aVar.a(this.a);
                return;
            }
        } catch (InterruptedException unused) {
            ArrayList arrayList3 = new ArrayList();
            while (true) {
                Bitmap[] bitmapArr2 = this.a;
                if (i >= bitmapArr2.length) {
                    break;
                }
                Bitmap bitmap2 = bitmapArr2[i];
                if (bitmap2 != null) {
                    arrayList3.add(bitmap2);
                }
                i++;
            }
            if (!arrayList3.isEmpty()) {
                aVar.a(this.a);
                return;
            }
        } catch (Throwable th) {
            ArrayList arrayList4 = new ArrayList();
            while (true) {
                Bitmap[] bitmapArr3 = this.a;
                if (i >= bitmapArr3.length) {
                    break;
                }
                Bitmap bitmap3 = bitmapArr3[i];
                if (bitmap3 != null) {
                    arrayList4.add(bitmap3);
                }
                i++;
            }
            if (arrayList4.isEmpty()) {
                aVar.a(null);
            } else {
                aVar.a(this.a);
            }
            throw th;
        }
        aVar.a(null);
    }
}
