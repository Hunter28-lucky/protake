package com.mob.commons.cc;

import android.database.ContentObserver;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class j extends ContentObserver implements r<j> {
    private l a;

    public j() {
        super(null);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        if (this.a != null) {
            ArrayList<Object> arrayList = new ArrayList<>(1);
            arrayList.add(Boolean.valueOf(z));
            this.a.a("onChange", arrayList);
        }
    }

    public void a(l lVar) {
        this.a = lVar;
    }

    @Override // com.mob.commons.cc.r
    public boolean a(j jVar, Class<j> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        Object obj;
        if (!"setHandler".equals(str) || objArr.length != 1 || (obj = objArr[0]) == null || !(obj instanceof l)) {
            return false;
        }
        jVar.a((l) obj);
        return true;
    }
}
