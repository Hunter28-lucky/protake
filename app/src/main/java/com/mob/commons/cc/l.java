package com.mob.commons.cc;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public class l {
    public a a;

    public interface a {
        Object a(String str, ArrayList<Object> arrayList);
    }

    public l(a aVar) {
        this.a = aVar;
    }

    public Object a(String str, ArrayList<Object> arrayList) {
        a aVar = this.a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(str, arrayList);
    }
}
