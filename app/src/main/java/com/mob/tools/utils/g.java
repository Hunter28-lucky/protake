package com.mob.tools.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.i;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DH;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class g {
    private static final int[] a = {92, 80, 82, 17, 84, 74, 88, 80, 74, 17, 94, 81, 91, 77, 80, 86, 91, 19, 92, 80, 82, 17, 75, 90, 81, 92, 90, 81, 75, 17, 78, 78, 79, 86, 82, 19, 92, 80, 82, 17, 71, 86, 82, 94, 83, 94, 70, 94, 17, 75, 86, 81, 88, 17, 94, 81, 91, 77, 80, 86, 91, 19, 92, 80, 82, 17, 86, 89, 83, 70, 75, 90, 84, 17, 86, 81, 79, 74, 75, 82, 90, 75, 87, 80, 91, 19, 92, 80, 82, 17, 92, 83, 90, 94, 81, 82, 94, 76, 75, 90, 77, 17, 82, 88, 74, 94, 77, 91, 96, 92, 81, 19, 92, 80, 82, 17, 110, 74, 81, 94, 77, 19, 92, 80, 82, 17, 94, 74, 75, 80, 81, 94, 73, 86, 17, 82, 86, 81, 86, 82, 94, 79, 19, 92, 80, 82, 17, 91, 76, 86, 17, 94, 81, 75, 17, 76, 90, 77, 73, 90, 77, 19, 92, 80, 82, 17, 75, 90, 81, 92, 90, 81, 75, 17, 81, 90, 72, 76, 19, 92, 80, 82, 17, 82, 90, 91, 86, 94, 75, 90, 84, 17, 82, 75, 84, 83, 80, 88, 88, 90, 77, 19, 92, 80, 82, 17, 76, 76, 17, 94, 81, 91, 77, 80, 86, 91, 17, 94, 77, 75, 86, 92, 83, 90, 17, 73, 86, 91, 90, 80, 19, 92, 80, 82, 17, 94, 92, 87, 86, 90, 73, 80, 17, 73, 86, 79, 76, 87, 80, 79, 19, 92, 81, 17, 72, 79, 76, 17, 82, 80, 89, 89, 86, 92, 90, 96, 90, 81, 88, 19, 92, 80, 82, 17, 87, 94, 79, 79, 70, 90, 83, 90, 82, 90, 81, 75, 76, 17, 126, 81, 91, 77, 80, 86, 91, 126, 81, 86, 82, 94, 83, 19, 92, 80, 82, 17, 82, 90, 91, 86, 94, 75, 90, 84, 17, 94, 75, 92, 86, 17, 76, 90, 77, 73, 86, 92, 90, 19, 92, 80, 82, 17, 75, 82, 77, 86, 17, 94, 79, 79, 17, 82, 94, 86, 81, 19, 92, 80, 82, 17, 78, 86, 87, 80, 80, 17, 94, 79, 79, 76, 75, 80, 77, 90, 19, 92, 80, 82, 17, 106, 124, 114, 80, 93, 86, 83, 90, 19, 92, 80, 82, 17, 82, 90, 91, 86, 94, 75, 90, 84, 17, 90, 81, 88, 86, 81, 90, 90, 77, 82, 80, 91, 90, 19, 92, 80, 82, 17, 78, 74, 94, 83, 92, 80, 82, 82, 17, 72, 89, 91, 17, 76, 90, 77, 73, 86, 92, 90};
    private static final int[] b = {92, 80, 82, 17, 114, 80, 93, 86, 83, 90, 107, 86, 92, 84, 90, 75, 19, 92, 80, 82, 17, 82, 90, 91, 86, 94, 75, 90, 84, 17, 79, 77, 80, 73, 86, 91, 90, 77, 76, 17, 91, 77, 82, 19, 92, 80, 82, 17, 78, 75, 86, 17, 76, 90, 77, 73, 86, 92, 90, 17, 92, 80, 83, 80, 77, 76, 90, 77, 73, 86, 92, 90, 19, 92, 80, 82, 17, 75, 90, 81, 92, 90, 81, 75, 17, 94, 81, 91, 77, 80, 86, 91, 17, 78, 78, 91, 80, 72, 81, 83, 80, 94, 91, 90, 77, 19, 92, 80, 82, 17, 91, 86, 94, 81, 79, 86, 81, 88, 17, 73, 14, 19, 92, 80, 82, 17, 82, 90, 91, 86, 94, 75, 90, 84, 17, 89, 72, 84, 17, 79, 83, 74, 88, 86, 81, 19, 92, 80, 82, 17, 88, 77, 90, 90, 81, 79, 80, 86, 81, 75, 17, 94, 81, 91, 77, 80, 86, 91, 17, 82, 92, 14, 15, 15, 7, 9, 17, 94, 92, 75, 86, 73, 86, 75, 70, 19, 92, 80, 82, 17, 78, 74, 94, 83, 92, 80, 82, 82, 17, 75, 86, 82, 90, 76, 90, 77, 73, 86, 92, 90, 19, 92, 80, 82, 17, 82, 90, 91, 86, 94, 75, 90, 84, 19, 92, 80, 82, 17, 78, 74, 94, 83, 92, 80, 82, 82, 17, 78, 92, 77, 86, 83, 82, 76, 88, 75, 74, 81, 81, 90, 83, 19, 92, 80, 82, 17, 75, 90, 81, 92, 90, 81, 75, 17, 82, 80, 93, 86, 83, 90, 78, 78, 19, 92, 80, 82, 17, 76, 76, 17, 94, 81, 91, 77, 80, 86, 91, 17, 74, 88, 92, 17, 94, 72, 90, 82, 90, 19, 92, 80, 82, 17, 92, 83, 90, 94, 81, 82, 94, 76, 75, 90, 77, 17, 76, 91, 84, 19, 92, 80, 82, 17, 71, 74, 81, 82, 90, 81, 88, 17, 79, 86, 81, 91, 74, 80, 91, 74, 80, 19, 92, 80, 82, 17, 72, 74, 93, 94, 19, 92, 80, 82, 17, 82, 90, 91, 86, 94, 75, 90, 84, 17, 83, 93, 76, 17, 90, 82, 13, 17, 74, 86, 19, 92, 80, 82, 17, 76, 86, 81, 94, 17, 72, 90, 86, 93, 80, 19, 92, 80, 82, 17, 82, 90, 91, 86, 94, 75, 90, 84, 17, 80, 82, 94, 92, 79, 19, 92, 80, 82, 17, 94, 82, 94, 79, 17, 94, 81, 91, 77, 80, 86, 91, 17, 83, 80, 92, 94, 75, 86, 80, 81, 19, 92, 81, 17, 84, 74, 72, 80, 17, 79, 83, 94, 70, 90, 77};
    private static final int[] c = {92, 80, 82, 17, 75, 90, 81, 92, 90, 81, 75, 17, 82, 75, 75, 19, 92, 80, 82, 17, 78, 86, 70, 86, 17, 73, 86, 91, 90, 80, 19, 92, 80, 82, 17, 88, 80, 80, 88, 83, 90, 17, 94, 81, 91, 77, 80, 86, 91, 17, 72, 90, 93, 73, 86, 90, 72, 19, 92, 80, 82, 17, 75, 90, 81, 92, 90, 81, 75, 17, 84, 94, 77, 94, 80, 84, 90, 19, 92, 75, 77, 86, 79, 17, 94, 81, 91, 77, 80, 86, 91, 17, 73, 86, 90, 72, 19, 92, 80, 82, 17, 88, 80, 80, 88, 83, 90, 17, 94, 81, 91, 77, 80, 86, 91, 17, 88, 76, 89, 19, 92, 80, 82, 17, 93, 94, 86, 91, 74, 17, 81, 90, 75, 91, 86, 76, 84, 19, 92, 80, 82, 17, 75, 90, 81, 92, 90, 81, 75, 17, 94, 81, 91, 77, 80, 86, 91, 78, 78, 82, 94, 86, 83, 19, 92, 80, 82, 17, 94, 81, 91, 77, 80, 86, 91, 17, 83, 80, 92, 94, 75, 86, 80, 81, 17, 89, 74, 76, 90, 91, 19, 80, 77, 88, 17, 92, 80, 91, 90, 94, 74, 77, 80, 77, 94, 17, 93, 83, 74, 90, 75, 80, 80, 75, 87, 19, 92, 80, 82, 17, 82, 75, 17, 82, 75, 71, 71, 17, 82, 75, 71, 71, 19, 92, 80, 82, 17, 85, 86, 81, 88, 91, 80, 81, 88, 17, 94, 79, 79, 17, 82, 94, 83, 83, 19, 92, 80, 82, 17, 78, 74, 94, 83, 92, 80, 82, 82, 17, 86, 81, 75, 90, 77, 89, 94, 92, 90, 79, 90, 77, 82, 86, 76, 76, 86, 80, 81, 76, 19, 92, 80, 82, 17, 93, 94, 86, 91, 74, 17, 94, 79, 79, 76, 90, 94, 77, 92, 87, 19, 92, 80, 82, 17, 75, 90, 81, 92, 90, 81, 75, 17, 72, 86, 89, 86, 82, 94, 81, 94, 88, 90, 77, 19, 92, 80, 82, 17, 93, 94, 86, 91, 74, 17, 87, 94, 80, 84, 94, 81, 19, 92, 80, 82, 17, 73, 86, 73, 80, 17, 90, 94, 76, 70, 76, 87, 94, 77, 90, 19, 92, 80, 82, 17, 75, 94, 80, 93, 94, 80, 17, 75, 94, 80, 93, 94, 80, 19, 92, 80, 82, 17, 92, 80, 83, 80, 77, 80, 76, 17, 72, 90, 94, 75, 87, 90, 77, 19, 80, 77, 88, 17, 76, 86, 82, 94, 83, 83, 86, 94, 81, 92, 90, 17, 80, 79, 90, 81, 82, 80, 93, 86, 83, 90, 94, 79, 86, 17, 76, 90, 77, 73, 86, 92, 90};
    private static final int[] d = {92, 80, 82, 17, 78, 74, 94, 83, 92, 80, 82, 82, 17, 83, 80, 92, 94, 75, 86, 80, 81, 19, 92, 80, 82, 17, 82, 90, 91, 86, 94, 75, 90, 84, 17, 93, 94, 75, 75, 90, 77, 70, 72, 94, 77, 81, 86, 81, 88, 19, 92, 80, 82, 17, 93, 94, 86, 91, 74, 17, 125, 94, 86, 91, 74, 114, 94, 79, 19, 92, 80, 82, 17, 75, 90, 81, 92, 90, 81, 75, 17, 78, 78, 82, 74, 76, 86, 92, 19, 92, 80, 82, 17, 76, 73, 80, 71, 17, 79, 86, 92, 80, 19, 92, 80, 82, 17, 93, 93, 84, 17, 86, 78, 80, 80, 17, 89, 90, 90, 91, 93, 94, 92, 84, 19, 92, 80, 82, 17, 70, 80, 74, 84, 74, 17, 79, 87, 80, 81, 90, 19, 92, 80, 82, 17, 75, 90, 81, 92, 90, 81, 75, 17, 78, 78, 79, 86, 82, 76, 90, 92, 74, 77, 90, 19, 92, 80, 82, 17, 93, 94, 86, 91, 74, 17, 76, 90, 94, 77, 92, 87, 93, 80, 71, 19, 92, 80, 82, 17, 76, 94, 81, 84, 74, 94, 86, 17, 82, 90, 86, 75, 74, 94, 81, 19, 92, 80, 82, 17, 78, 74, 94, 83, 92, 80, 82, 82, 17, 76, 87, 74, 75, 91, 80, 72, 81, 83, 86, 76, 75, 81, 90, 77, 19, 92, 80, 82, 17, 78, 86, 87, 80, 80, 12, 9, 15, 17, 82, 80, 93, 86, 83, 90, 76, 94, 89, 90, 19, 92, 80, 82, 17, 86, 89, 83, 70, 75, 90, 84, 17, 76, 79, 90, 90, 92, 87, 92, 83, 80, 74, 91, 19, 92, 80, 82, 17, 90, 88, 17, 94, 81, 91, 77, 80, 86, 91, 17, 126, 83, 86, 79, 94, 70, 120, 79, 87, 80, 81, 90, 19, 92, 80, 82, 17, 88, 80, 80, 88, 83, 90, 17, 94, 81, 91, 77, 80, 86, 91, 17, 76, 70, 81, 92, 94, 91, 94, 79, 75, 90, 77, 76, 17, 92, 80, 81, 75, 94, 92, 75, 76, 19, 92, 80, 82, 17, 88, 80, 80, 88, 83, 90, 17, 94, 81, 91, 77, 80, 86, 91, 17, 76, 70, 81, 92, 94, 91, 94, 79, 75, 90, 77, 76, 17, 92, 94, 83, 90, 81, 91, 94, 77, 19, 92, 80, 82, 17, 93, 94, 80, 89, 90, 81, 88, 17, 82, 85, 17, 73, 86, 91, 90, 80, 79, 83, 74, 88, 86, 81, 19, 92, 80, 82, 17, 75, 90, 81, 92, 90, 81, 75, 17, 82, 82, 19, 92, 80, 82, 17, 82, 90, 91, 86, 94, 75, 90, 84, 17, 75, 87, 90, 77, 82, 94, 83, 82, 94, 81, 94, 88, 90, 77, 19, 92, 80, 82, 17, 76, 91, 74, 17, 91, 86, 91, 86, 17, 79, 76, 81, 88, 90, 77};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f17728e = {92, 80, 82, 17, 76, 75, 80, 77, 82, 17, 76, 75, 80, 77, 82, 88, 94, 82, 90, 19, 92, 80, 82, 17, 76, 76, 17, 94, 81, 91, 77, 80, 86, 91, 17, 74, 88, 92, 17, 83, 86, 73, 90, 19, 80, 77, 88, 17, 92, 80, 91, 90, 94, 74, 77, 80, 77, 94, 17, 86, 82, 76, 19, 92, 80, 82, 17, 75, 82, 94, 83, 83, 17, 72, 86, 77, 90, 83, 90, 76, 76, 19, 92, 80, 82, 17, 93, 89, 88, 94, 82, 90, 17, 94, 79, 79, 19, 92, 80, 82, 17, 78, 74, 86, 92, 86, 81, 92, 17, 92, 81, 90, 17, 124, 113, 122, 108, 90, 77, 73, 86, 92, 90, 19, 92, 80, 82, 17, 93, 94, 86, 91, 74, 17, 82, 94, 79, 17, 83, 80, 92, 94, 75, 86, 80, 81, 19, 92, 80, 82, 17, 76, 76, 17, 94, 81, 91, 77, 80, 86, 91, 17, 94, 77, 75, 86, 92, 83, 90, 17, 83, 86, 75, 90, 19, 92, 80, 82, 17, 76, 81, 91, 94, 17, 72, 86, 89, 86, 83, 80, 92, 94, 75, 86, 81, 88, 19, 92, 80, 82, 17, 76, 80, 87, 74, 17, 86, 81, 79, 74, 75, 82, 90, 75, 87, 80, 91, 17, 76, 80, 88, 80, 74, 19, 92, 80, 82, 17, 75, 90, 81, 92, 90, 81, 75, 17, 75, 82, 88, 79, 17, 76, 88, 94, 82, 90, 19, 92, 80, 82, 17, 78, 74, 94, 83, 92, 80, 82, 82, 17, 78, 92, 80, 82, 96, 78, 82, 86, 19, 92, 80, 82, 17, 82, 90, 91, 86, 94, 75, 90, 84, 17, 70, 88, 79, 76, 19, 92, 80, 82, 17, 75, 90, 81, 92, 90, 81, 75, 17, 78, 78, 83, 86, 73, 90, 19, 92, 80, 82, 17, 76, 76, 17, 94, 81, 91, 77, 80, 86, 91, 17, 94, 77, 75, 86, 92, 83, 90, 17, 81, 90, 72, 76, 19, 92, 80, 82, 17, 92, 87, 86, 81, 94, 82, 72, 80, 77, 83, 91, 17, 82, 94, 86, 81, 19, 92, 80, 82, 17, 88, 80, 80, 88, 83, 90, 17, 94, 81, 91, 77, 80, 86, 91, 17, 88, 76, 89, 17, 83, 80, 88, 86, 81, 19, 92, 80, 82, 17, 82, 90, 86, 75, 74, 17, 82, 90, 86, 70, 94, 81, 92, 94, 82, 90, 77, 94, 19, 92, 80, 82, 17, 76, 82, 86, 83, 90, 17, 88, 86, 89, 82, 94, 84, 90, 77};

    public int b(Context context) throws InterruptedException {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        DH.requester(MobSDK.getContext()).getBoardFromSysProperty().request(new DH.DHResponder() { // from class: com.mob.tools.utils.g.2
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    String boardFromSysProperty = dHResponse.getBoardFromSysProperty();
                    if (TextUtils.isEmpty(boardFromSysProperty) || boardFromSysProperty.indexOf(i.a("0077fhfm?j<fjgefgCj")) > -1 || boardFromSysProperty.indexOf(i.a("008<hhgegf3jUhjfghi6e")) > -1) {
                        atomicInteger.set(1);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        });
        try {
            countDownLatch.await(100L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
        return atomicInteger.get();
    }

    public int c(Context context) throws InterruptedException {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        DH.requester(MobSDK.getContext()).getBoardPlatform().request(new DH.DHResponder() { // from class: com.mob.tools.utils.g.3
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    String boardPlatform = dHResponse.getBoardPlatform();
                    if (TextUtils.isEmpty(boardPlatform) || boardPlatform.indexOf(i.a("0075fhfm-j*fjgefgGj")) > -1 || boardPlatform.indexOf(i.a("010%hi'j%flffhhBgeIgefmJk")) > -1) {
                        atomicInteger.set(1);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        });
        try {
            countDownLatch.await(100L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
        return atomicInteger.get();
    }

    public int d(Context context) throws InterruptedException {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        DH.requester(MobSDK.getContext()).getFlavor().request(new DH.DHResponder() { // from class: com.mob.tools.utils.g.4
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    if (dHResponse.getFlavor().indexOf(i.a("004lQhegefn")) > -1) {
                        atomicInteger.set(1);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        });
        try {
            countDownLatch.await(100L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
        return atomicInteger.get();
    }

    public int e(Context context) throws InterruptedException {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        DH.requester(MobSDK.getContext()).getCgroup().request(new DH.DHResponder() { // from class: com.mob.tools.utils.g.5
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    if (TextUtils.isEmpty(dHResponse.getCgroup())) {
                        atomicInteger.set(1);
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
            }
        });
        try {
            countDownLatch.await(100L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
        return atomicInteger.get();
    }

    public int f(final Context context) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        try {
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        if (DeviceHelper.getInstance(context).checkPermission(i.a("035IfhfmQj+fjgefgNjIgn$gk(fj nCfghihifggefmgnigifglhkffijjfhnghifffgjgkglgkif")) && Build.VERSION.SDK_INT < 29) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            DH.requester(MobSDK.getContext()).getIMEI().request(new DH.DHResponder() { // from class: com.mob.tools.utils.g.6
                @Override // com.mob.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    String imei = DeviceHelper.getInstance(context).getIMEI();
                    if (TextUtils.isEmpty(imei)) {
                        return;
                    }
                    if (imei.contains("*") || g.this.a(imei) == imei.length()) {
                        atomicInteger.set(1);
                    }
                }
            });
            countDownLatch.await(100L, TimeUnit.MILLISECONDS);
            return atomicInteger.get();
        }
        return -1;
    }

    public int g(Context context) {
        try {
            final AtomicInteger atomicInteger = new AtomicInteger(0);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(a(a));
            arrayList.addAll(a(b));
            arrayList.addAll(a(c));
            arrayList.addAll(a(d));
            arrayList.addAll(a(f17728e));
            DH.RequestBuilder requestBuilderRequester = DH.requester(MobSDK.getContext());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                requestBuilderRequester.getPInfo((String) it.next(), 0);
            }
            requestBuilderRequester.request(new DH.DHResponder() { // from class: com.mob.tools.utils.g.7
                @Override // com.mob.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        try {
                            PackageInfo pInfo = dHResponse.getPInfo(i);
                            if (pInfo != null && (1 & pInfo.applicationInfo.flags) == 0) {
                                atomicInteger.getAndIncrement();
                            }
                        } finally {
                            countDownLatch.countDown();
                        }
                    }
                }
            });
            countDownLatch.await(120L, TimeUnit.MILLISECONDS);
            return atomicInteger.get() == 0 ? 1 : 0;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return 0;
        }
    }

    public int a(Context context) throws InterruptedException {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        DH.requester(MobSDK.getContext()).getBaseband().request(new DH.DHResponder() { // from class: com.mob.tools.utils.g.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    String baseband = dHResponse.getBaseband();
                    if (TextUtils.isEmpty(baseband) || baseband.contains(i.a("007[ingnhggnhggnhg"))) {
                        atomicInteger.set(1);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        });
        try {
            countDownLatch.await(100L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
        return atomicInteger.get();
    }

    private String b(int[] iArr) {
        int length = iArr.length;
        char[] cArr = new char[length];
        int iMin = Math.min(length, 63);
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (iArr[i] ^ iMin);
        }
        return String.valueOf(cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '0') {
                i++;
            }
        }
        return i;
    }

    private List<String> a(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : b(iArr).split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                arrayList.add(str);
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        return arrayList;
    }

    public int a() throws InterruptedException {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        DH.requester(MobSDK.getContext()).getCInfo().request(new DH.DHResponder() { // from class: com.mob.tools.utils.g.8
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    String cInfo = dHResponse.getCInfo();
                    if (cInfo.indexOf(i.a("005>fgfm<fkWgf")) > -1 || cInfo.indexOf(i.a("003:fh]nj")) > -1) {
                        atomicInteger.set(1);
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await(100L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
        return atomicInteger.get();
    }
}
