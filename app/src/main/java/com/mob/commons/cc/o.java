package com.mob.commons.cc;

/* loaded from: classes2.dex */
public class o implements r<n> {
    @Override // com.mob.commons.cc.r
    public boolean a(n nVar, Class<n> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        Object obj;
        if (!"setHandler".equals(str) || objArr.length != 1 || (obj = objArr[0]) == null || !(obj instanceof l)) {
            return false;
        }
        nVar.a((l) obj);
        return true;
    }
}
