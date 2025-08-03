package com.mob.commons.cc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public class x {
    private String a;
    private int b;
    private q c;
    private int d;

    /* renamed from: e, reason: collision with root package name */
    private int f17675e;
    private u f;

    public static class a implements r<a> {
        public Throwable a;
        public Object b;

        public boolean a() {
            return this.a != null;
        }

        @Override // com.mob.commons.cc.r
        public boolean a(a aVar, Class<a> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
            if ("isError".equals(str) && objArr.length == 0) {
                objArr2[0] = Boolean.valueOf(aVar.a());
                return true;
            }
            if ("getError".equals(str) && objArr.length == 0) {
                objArr2[0] = aVar.a;
                return true;
            }
            if (!"getResult".equals(str) || objArr.length != 0) {
                return false;
            }
            objArr2[0] = aVar.b;
            return true;
        }
    }

    public x(String str, int i, ArrayList<w> arrayList, ArrayList<Object> arrayList2, int i2, int i3, q qVar) {
        this.a = str;
        this.b = i;
        this.f = new u(arrayList, arrayList2);
        this.d = i2;
        this.f17675e = i3;
        this.c = qVar;
    }

    public x a(q qVar, String str, int i) {
        if (this.b <= 1) {
            return this;
        }
        ArrayList<w> arrayList = new ArrayList<>();
        a(str, i, arrayList, 0);
        return new x(null, 1, arrayList, new ArrayList(), 0, arrayList.size(), qVar);
    }

    public LinkedList<Object> b(Object... objArr) throws Throwable {
        q qVarB = this.c.b();
        int i = this.b;
        if (i != 0) {
            if (objArr.length == i) {
                for (int length = objArr.length - 1; length >= 0; length--) {
                    qVarB.a(objArr[length]);
                }
            } else if (objArr.length < i) {
                for (int length2 = objArr.length; length2 < this.b; length2++) {
                    qVarB.a((Object) null);
                }
                for (int length3 = objArr.length - 1; length3 >= 0; length3--) {
                    qVarB.a(objArr[length3]);
                }
            } else {
                ArrayList arrayList = new ArrayList(0);
                for (int i2 = this.b - 1; i2 < objArr.length; i2++) {
                    arrayList.add(objArr[i2]);
                }
                qVarB.a(arrayList);
                for (int i3 = this.b - 2; i3 >= 0; i3--) {
                    qVarB.a(objArr[i3]);
                }
            }
        }
        LinkedList<Object> linkedList = new LinkedList<>();
        this.f.a(this.d, this.f17675e, qVarB, linkedList);
        return linkedList;
    }

    private void a(String str, int i, ArrayList<w> arrayList, int i2) {
        if (i2 != 0) {
            w wVar = new w(29);
            wVar.b = str;
            wVar.c = i;
            wVar.i = 1;
            arrayList.add(wVar);
        }
        w wVar2 = new w(1);
        wVar2.b = str;
        wVar2.c = i;
        StringBuilder sb = new StringBuilder();
        sb.append("arg");
        int i3 = i2 + 1;
        sb.append(i3);
        wVar2.h = sb.toString();
        arrayList.add(wVar2);
        int i4 = this.b;
        if (i2 < i4 - 1) {
            a(str, i, arrayList, i3);
            w wVar3 = new w(28);
            wVar3.b = str;
            wVar3.c = i;
            arrayList.add(wVar3);
        } else {
            for (int i5 = i4 - 1; i5 >= 0; i5 += -1) {
                w wVar4 = new w(3);
                wVar4.b = str;
                wVar4.c = i;
                wVar4.h = "arg" + (i5 + 1);
                arrayList.add(wVar4);
            }
            if (this.a == null) {
                w wVar5 = new w(2);
                wVar5.b = str;
                wVar5.c = i;
                wVar5.q = this;
                arrayList.add(wVar5);
                w wVar6 = new w(32);
                wVar6.b = str;
                wVar6.c = i;
                wVar6.i = this.b;
                arrayList.add(wVar6);
            } else {
                w wVar7 = new w(31);
                wVar7.b = str;
                wVar7.c = i;
                wVar7.h = this.a;
                wVar7.i = this.b;
                arrayList.add(wVar7);
            }
            Iterator<w> it = this.f.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().a == 28) {
                    w wVar8 = new w(28);
                    wVar8.b = str;
                    wVar8.c = i;
                    arrayList.add(wVar8);
                    break;
                }
            }
        }
        if (i2 != 0) {
            w wVar9 = new w(30);
            wVar9.b = str;
            wVar9.c = i;
            arrayList.add(wVar9);
        }
    }

    public a a(Object... objArr) {
        a aVar = new a();
        try {
            LinkedList<Object> linkedListB = b(objArr);
            if (!linkedListB.isEmpty()) {
                aVar.b = linkedListB.get(0);
            }
        } catch (Throwable th) {
            aVar.a = th;
        }
        return aVar;
    }

    public static x a(String str, int i, ArrayList<w> arrayList, ArrayList<Object> arrayList2, int i2, int i3, q qVar) {
        return new x(str, i, arrayList, arrayList2, i2, i3, qVar) { // from class: com.mob.commons.cc.x.1
            @Override // com.mob.commons.cc.x
            public LinkedList<Object> b(Object... objArr) throws Throwable {
                return new LinkedList<>();
            }
        };
    }
}
