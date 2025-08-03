package defpackage;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.GLES20;
import java.util.HashMap;

/* compiled from: ResourceTracker.java */
/* renamed from: ஓ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4462 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int f15345;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static int f15346;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static HashMap<Integer, C4463> f15347 = new HashMap<>();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static HashMap<Integer, C4463> f15348 = new HashMap<>();

    /* renamed from: ԫ, reason: contains not printable characters */
    public static HashMap<Integer, C4463> f15349 = new HashMap<>();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static HashMap<Integer, C4463> f15350 = new HashMap<>();

    /* compiled from: ResourceTracker.java */
    /* renamed from: ஓ$Ϳ, reason: contains not printable characters */
    public static final class C4463 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public StackTraceElement[] f15351;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f15352;

        /* renamed from: ԩ, reason: contains not printable characters */
        public String f15353;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public int f15354;

        /* renamed from: ԫ, reason: contains not printable characters */
        public int f15355;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public int f15356;
    }

    @TargetApi(17)
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m13722() {
        if (EGL14.eglGetCurrentContext() == null) {
            throw new RuntimeException("NO VALID CONTEXT TO FREE RESOURCES!");
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static synchronized void m13723(int i) {
        C4650.m14121();
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        C4463 c4463 = f15347.get(Integer.valueOf(i));
        if (c4463 == null) {
            throw new RuntimeException(String.format("texture id:%s is not used during free", Integer.valueOf(i)));
        }
        f15347.remove(Integer.valueOf(i));
        f15345--;
        f15346 -= (c4463.f15354 * c4463.f15355) * c4463.f15356;
        m13725();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static synchronized void m13724(int i, String str, int i2, int i3, int i4) {
        m13722();
        if (f15347.get(Integer.valueOf(i)) != null) {
            throw new RuntimeException(String.format("texture id:%d is already used during allocation", Integer.valueOf(i)));
        }
        C4463 c4463 = new C4463();
        c4463.f15353 = str;
        c4463.f15352 = i;
        c4463.f15351 = Thread.currentThread().getStackTrace();
        c4463.f15354 = i2;
        c4463.f15355 = i3;
        c4463.f15356 = i4;
        f15347.put(Integer.valueOf(i), c4463);
        f15345++;
        f15346 += i2 * i3 * i4;
        m13725();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m13725() {
    }
}
