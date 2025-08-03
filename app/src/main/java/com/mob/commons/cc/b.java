package com.mob.commons.cc;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

/* loaded from: classes2.dex */
public class b implements r<Context> {
    @Override // com.mob.commons.cc.r
    public boolean a(Context context, Class<Context> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (com.mob.commons.o.a("016YffHid3ehdifgSdil1ehPi8dhFjRdedg i").equals(str) && objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                try {
                    objArr2[0] = context.getSystemService((String) obj);
                } catch (Throwable th) {
                    objArr2[0] = null;
                    thArr[0] = th;
                }
                return true;
            }
        }
        if ("getApplicationInfo".equals(str) && objArr.length == 0) {
            objArr2[0] = context.getApplicationInfo();
            return true;
        }
        if (com.mob.commons.o.a("018:ffQid5ggecdk2di>dkNdUgeNiEfgeced=jiKdh").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getContentResolver();
            return true;
        }
        if (com.mob.commons.o.a("014EffQidLghdfdgdjdfffPi5efdfOli").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getPackageName();
            return true;
        }
        if (com.mob.commons.o.a("0174ffTid@ghdfdgdjdfffLi^gidfdkdfffJi*dh").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getPackageManager();
            return true;
        }
        if ("startActivity".equals(str) && objArr.length == 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof Intent) {
                context.startActivity((Intent) obj2);
                return true;
            }
        }
        if (com.mob.commons.o.a("011$ffIid*fkdeed=i5fgfidedh").equals(str)) {
            objArr2[0] = context.getFilesDir();
            return true;
        }
        if (com.mob.commons.o.a("009;ffDid$ejfgfg$id+fg").equals(str)) {
            objArr2[0] = context.getAssets();
            return true;
        }
        if (com.mob.commons.o.a("0193dg ci_dgdjeh3i edfhgh%iPdh(l,defgfgdeecdk").equals(str) && objArr.length == 1) {
            Object obj3 = objArr[0];
            if (obj3 instanceof String) {
                objArr2[0] = Integer.valueOf(context.checkSelfPermission((String) obj3));
                return true;
            }
        }
        if ("bindService".equals(str) && objArr.length == 3) {
            objArr2[0] = Boolean.valueOf(context.bindService((Intent) objArr[0], (ServiceConnection) objArr[1], ((Integer) objArr[2]).intValue()));
            return true;
        }
        if ("unbindService".equals(str) && objArr.length == 1) {
            Object obj4 = objArr[0];
            if (obj4 instanceof ServiceConnection) {
                context.unbindService((ServiceConnection) obj4);
                return true;
            }
        }
        return false;
    }
}
