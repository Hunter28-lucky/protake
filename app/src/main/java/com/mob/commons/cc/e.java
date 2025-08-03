package com.mob.commons.cc;

import android.content.Intent;
import android.content.pm.PackageManager;

/* loaded from: classes2.dex */
public class e implements r<PackageManager> {
    @Override // com.mob.commons.cc.r
    public boolean a(PackageManager packageManager, Class<PackageManager> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if (com.mob.commons.j.a("019i)ba)gIbfbgcebiLbg biAb,cfXg8bf,hRbcbe[gHde").equals(str) && objArr.length == 2) {
            Object obj = objArr[0];
            if (obj instanceof Intent) {
                Object obj2 = objArr[1];
                if (obj2 instanceof Integer) {
                    objArr2[0] = packageManager.queryIntentServices((Intent) obj, ((Integer) obj2).intValue());
                    return true;
                }
            }
        }
        if (com.mob.commons.j.a("025*ddXgbCcibdbabibe6aQcebi>bg1bi9b^dicabfefbdbebhbdddHg").equals(str) && objArr.length == 1) {
            Object obj3 = objArr[0];
            if (obj3 instanceof String) {
                objArr2[0] = packageManager.getLaunchIntentForPackage((String) obj3);
                return true;
            }
        }
        if (com.mob.commons.j.a("015:bf+gZdecacbJhg!chbe@b5bc=h5bc7b,bg").equals(str) && objArr.length == 2) {
            Object obj4 = objArr[0];
            if (obj4 instanceof Integer) {
                Object obj5 = objArr[1];
                if (obj5 instanceof Integer) {
                    objArr2[0] = packageManager.resolveActivity((Intent) obj4, ((Integer) obj5).intValue());
                    return true;
                }
            }
        }
        return false;
    }
}
