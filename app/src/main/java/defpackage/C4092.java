package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.opengl.GLES10;
import android.opengl.GLES20;
import java.util.List;

/* compiled from: CheckUtil.java */
/* renamed from: ऱ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4092 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean f14229 = false;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean m13040(C4327 c4327, C4327 c43272) {
        if (c4327 == null) {
            return false;
        }
        if (c4327 == c43272) {
            return true;
        }
        if (!(c4327 instanceof C3606) || !(c43272 instanceof C3606)) {
            return false;
        }
        List<C4327> list = ((C3606) c4327).f12535;
        List<C4327> list2 = ((C3606) c43272).f12535;
        if (list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!m13040(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static int m13041() {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        if (iArr[0] == 0) {
            GLES10.glGetIntegerv(3379, iArr, 0);
            if (iArr[0] == 0) {
                GLES20.glGetIntegerv(3379, iArr, 0);
                if (iArr[0] == 0) {
                    GLES20.glGetIntegerv(3379, iArr, 0);
                }
            }
        }
        int i = iArr[0];
        if (i != 0) {
            return i;
        }
        return 2048;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m13042(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
