package com.mob.commons.cc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class u {
    public static final HashMap<String, Class<?>> a = new HashMap<>();
    private final ArrayList<w> b;
    private final ArrayList<Object> c;

    public u(ArrayList<w> arrayList, ArrayList<Object> arrayList2) {
        this.b = arrayList;
        this.c = arrayList2;
    }

    public void a(HashMap<String, Object> map, s sVar) throws Throwable {
        q qVar = new q(map, sVar);
        a(qVar);
        a(0, this.b.size(), qVar, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        r0.d = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r4, int r5, com.mob.commons.cc.q r6, java.util.List<java.lang.Object> r7) throws java.lang.Throwable {
        /*
            r3 = this;
            com.mob.commons.cc.w$a r0 = new com.mob.commons.cc.w$a
            r0.<init>()
            r0.a = r4
            r0.b = r6
            r0.c = r7
            java.util.ArrayList<com.mob.commons.cc.w> r4 = r3.b
            r0.f = r4
            java.util.ArrayList<java.lang.Object> r4 = r3.c
            r0.g = r4
        L13:
            int r4 = r0.a     // Catch: java.lang.Throwable -> L4d
            if (r4 >= r5) goto L39
            boolean r4 = r6.f()     // Catch: java.lang.Throwable -> L4d
            r1 = 1
            if (r4 == 0) goto L21
            r0.d = r1     // Catch: java.lang.Throwable -> L4d
            goto L39
        L21:
            java.util.ArrayList<com.mob.commons.cc.w> r4 = r3.b     // Catch: java.lang.Throwable -> L4d
            int r2 = r0.a     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r4 = r4.get(r2)     // Catch: java.lang.Throwable -> L4d
            com.mob.commons.cc.w r4 = (com.mob.commons.cc.w) r4     // Catch: java.lang.Throwable -> L4d
            r4.a(r0)     // Catch: java.lang.Throwable -> L4d
            boolean r4 = r0.f17674e     // Catch: java.lang.Throwable -> L4d
            if (r4 == 0) goto L33
            goto L39
        L33:
            int r4 = r0.a     // Catch: java.lang.Throwable -> L4d
            int r4 = r4 + r1
            r0.a = r4     // Catch: java.lang.Throwable -> L4d
            goto L13
        L39:
            boolean r4 = r0.d
            if (r4 != 0) goto L4c
            int r4 = r6.d()
            if (r4 <= 0) goto L4c
            if (r7 == 0) goto L4c
            java.lang.Object r4 = r6.a()     // Catch: java.lang.Throwable -> L4c
            r7.add(r4)     // Catch: java.lang.Throwable -> L4c
        L4c:
            return
        L4d:
            r4 = move-exception
            boolean r5 = r4 instanceof com.mob.commons.cc.t
            if (r5 == 0) goto L6a
            java.lang.String r5 = r4.getMessage()
            if (r5 != 0) goto L61
            java.lang.Class r5 = r4.getClass()
            java.lang.String r5 = r5.getSimpleName()
            goto L65
        L61:
            java.lang.String r5 = r4.getMessage()
        L65:
            java.lang.Throwable r4 = r4.getCause()
            goto L8e
        L6a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Suba Runtime Error: "
            r5.append(r6)
            java.lang.String r6 = r4.getMessage()
            if (r6 != 0) goto L83
            java.lang.Class r6 = r4.getClass()
            java.lang.String r6 = r6.getSimpleName()
            goto L87
        L83:
            java.lang.String r6 = r4.getMessage()
        L87:
            r5.append(r6)
            java.lang.String r5 = r5.toString()
        L8e:
            java.util.ArrayList<com.mob.commons.cc.w> r6 = r3.b
            int r7 = r0.a
            java.lang.Object r6 = r6.get(r7)
            com.mob.commons.cc.w r6 = (com.mob.commons.cc.w) r6
            java.lang.String r6 = r6.b
            java.util.ArrayList<com.mob.commons.cc.w> r7 = r3.b
            int r0 = r0.a
            java.lang.Object r7 = r7.get(r0)
            com.mob.commons.cc.w r7 = (com.mob.commons.cc.w) r7
            int r7 = r7.c
            com.mob.commons.cc.t r0 = new com.mob.commons.cc.t
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            java.lang.String r5 = "\r\n\tat "
            r1.append(r5)
            r1.append(r6)
            java.lang.String r5 = " ("
            r1.append(r5)
            r1.append(r7)
            java.lang.String r5 = ")"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.cc.u.a(int, int, com.mob.commons.cc.q, java.util.List):void");
    }

    private void a(q qVar) {
        qVar.a("Object", Object.class);
        qVar.a("Class", Class.class);
        qVar.a("Method", Method.class);
        qVar.a("String", String.class);
        qVar.a("Thread", Thread.class);
        qVar.a("Runnable", Runnable.class);
        qVar.a("System", System.class);
        qVar.a("File", File.class);
        qVar.a("URL", URL.class);
        qVar.a("Double", Double.class);
        qVar.a("Float", Float.class);
        qVar.a("Long", Long.class);
        qVar.a("Integer", Integer.class);
        qVar.a("Short", Short.class);
        qVar.a("Byte", Byte.class);
        qVar.a("Number", Number.class);
        qVar.a("Character", Character.class);
        qVar.a("Boolean", Boolean.class);
        qVar.a("double", Double.TYPE);
        qVar.a(TypedValues.Custom.S_FLOAT, Float.TYPE);
        qVar.a("long", Long.TYPE);
        qVar.a("int", Integer.TYPE);
        qVar.a("short", Short.TYPE);
        qVar.a("byte", Byte.TYPE);
        qVar.a("char", Character.TYPE);
        qVar.a(TypedValues.Custom.S_BOOLEAN, Boolean.TYPE);
        qVar.a("bigInt", BigInteger.class);
        qVar.a("BigInteger", BigInteger.class);
        qVar.a("bigDec", BigDecimal.class);
        qVar.a("BigDecimal", BigDecimal.class);
        qVar.a("List", List.class);
        qVar.a("Map", Map.class);
        qVar.a("Function", x.class);
        qVar.a("fun", x.class);
        qVar.a("Range", y.class);
        qVar.a("Array", Array.class);
        qVar.a("Suba", v.class);
        qVar.a("VM", v.class);
        for (Map.Entry<String, Class<?>> entry : a.entrySet()) {
            qVar.a(entry.getKey(), entry.getValue());
        }
    }

    public ArrayList<w> a() {
        return this.b;
    }
}
