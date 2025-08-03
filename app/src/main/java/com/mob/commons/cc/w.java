package com.mob.commons.cc;

import com.mob.commons.cc.v;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class w {
    public int a;
    public String b;
    public int c;
    public String d;

    /* renamed from: e, reason: collision with root package name */
    public String f17673e;
    public String f;
    public int g;
    public String h;
    public int i;
    public int j;
    public int k;
    public String l;
    public Object[] m;
    public String n;
    public String[] o;
    public String p;
    public Object q;
    public int r;
    public int s;

    public static class a {
        public int a;
        public q b;
        public List<Object> c;
        public boolean d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f17674e;
        public ArrayList<w> f;
        public ArrayList<Object> g;

        public Object a() {
            return this.b.a();
        }

        public Object b(String str) {
            return this.b.a(str);
        }

        public void a(Object obj) {
            this.b.a(obj);
        }

        public void b(String str, Object obj) {
            this.b.a(str, obj);
        }

        public Class<?> a(String str) {
            return this.b.b(str);
        }

        public void a(String str, Class<?> cls) {
            this.b.a(str, cls);
        }

        public void a(String str, Object obj) {
            this.b.b(str, obj);
        }
    }

    public w(int i) {
        this.a = i;
    }

    public void a(v.a aVar) throws Throwable {
        int i = 0;
        switch (this.a) {
            case 1:
                this.h = (String) aVar.b();
                aVar.a();
                break;
            case 2:
                this.q = aVar.b();
                break;
            case 3:
                this.h = (String) aVar.b();
                break;
            case 4:
                this.k = ((Integer) aVar.b()).intValue();
                break;
            case 5:
                this.k = ((Integer) aVar.b()).intValue();
                break;
            case 6:
                this.s = ((Integer) aVar.b()).intValue();
                break;
            case 7:
                this.r = ((Integer) aVar.b()).intValue();
                break;
            case 9:
                this.h = (String) aVar.b();
                break;
            case 10:
                this.d = (String) aVar.b();
                this.f17673e = (String) aVar.b();
                break;
            case 11:
                this.l = (String) aVar.b();
                break;
            case 12:
                this.p = (String) aVar.b();
                this.i = ((Integer) aVar.b()).intValue();
                break;
            case 13:
                this.n = (String) aVar.b();
                this.l = (String) aVar.b();
                break;
            case 14:
                this.n = (String) aVar.b();
                this.p = (String) aVar.b();
                this.i = ((Integer) aVar.b()).intValue();
                break;
            case 16:
                this.i = ((Integer) aVar.b()).intValue();
                break;
            case 17:
                this.n = (String) aVar.b();
                break;
            case 18:
                this.n = (String) aVar.b();
                this.i = ((Integer) aVar.b()).intValue();
                break;
            case 19:
                this.h = (String) aVar.b();
                break;
            case 20:
                this.f = (String) aVar.b();
                break;
            case 21:
                this.f = (String) aVar.b();
                int iIntValue = ((Integer) aVar.b()).intValue();
                this.g = iIntValue;
                this.g = iIntValue + aVar.c();
                break;
            case 22:
                this.f = (String) aVar.b();
                int iIntValue2 = ((Integer) aVar.b()).intValue();
                this.g = iIntValue2;
                this.g = iIntValue2 + aVar.c();
                break;
            case 24:
                this.l = (String) aVar.b();
                break;
            case 26:
                this.n = (String) aVar.b();
                this.l = (String) aVar.b();
                break;
            case 27:
                this.n = (String) aVar.b();
                break;
            case 29:
                this.h = (String) aVar.b();
                this.i = ((Integer) aVar.b()).intValue();
                int iIntValue3 = ((Integer) aVar.b()).intValue();
                this.j = iIntValue3;
                this.j = iIntValue3 + aVar.c();
                break;
            case 31:
                this.h = (String) aVar.b();
                this.i = ((Integer) aVar.b()).intValue();
                break;
            case 32:
                this.i = ((Integer) aVar.b()).intValue();
                break;
            case 35:
                this.d = (String) aVar.b();
                this.f17673e = (String) aVar.b();
                break;
            case 36:
                int iIntValue4 = ((Integer) aVar.b()).intValue();
                this.o = new String[iIntValue4];
                while (i < iIntValue4) {
                    this.o[i] = (String) aVar.b();
                    aVar.a();
                    i++;
                }
                break;
            case 37:
                int iIntValue5 = ((Integer) aVar.b()).intValue();
                this.m = new Object[iIntValue5];
                while (i < iIntValue5) {
                    this.m[i] = aVar.b();
                    i++;
                }
                break;
            case 38:
                int iIntValue6 = ((Integer) aVar.b()).intValue();
                this.o = new String[iIntValue6];
                while (i < iIntValue6) {
                    this.o[i] = (String) aVar.b();
                    i++;
                }
                break;
        }
    }

    public void b(Object obj, q qVar) throws Throwable {
        Object objA = qVar.a();
        if (obj instanceof Map) {
            ((Map) obj).put(this.l, objA);
            return;
        }
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            Field declaredField = null;
            try {
                declaredField = superclass.getDeclaredField(this.l);
            } catch (Throwable unused) {
            }
            if (declaredField != null && !Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                declaredField.set(obj, objA);
                return;
            }
        }
        w wVar = new w(12);
        wVar.b = this.b;
        wVar.c = this.c;
        wVar.p = "set" + Character.toUpperCase(this.l.charAt(0)) + this.l.substring(1);
        wVar.i = 1;
        wVar.a(obj, new Object[]{objA}, qVar);
    }

    public w() {
    }

    public void b(Class<?> cls, q qVar) throws Throwable {
        Field declaredField;
        Object objA = qVar.a();
        while (cls != null) {
            try {
                declaredField = cls.getDeclaredField(this.l);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                declaredField.set(null, objA);
                return;
            }
            cls = cls.getSuperclass();
        }
        w wVar = new w(14);
        wVar.b = this.b;
        wVar.c = this.c;
        wVar.n = this.n;
        wVar.p = "set" + Character.toUpperCase(this.l.charAt(0)) + this.l.substring(1);
        wVar.i = 1;
        wVar.a(cls, new Object[]{objA}, qVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0a55  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0a6e  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0a81 A[LOOP:13: B:427:0x0a7e->B:429:0x0a81, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0a8e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.mob.commons.cc.w.a r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 3908
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.cc.w.a(com.mob.commons.cc.w$a):void");
    }

    public void a(Object obj, q qVar) throws Throwable {
        if (obj instanceof Map) {
            qVar.a(((Map) obj).get(this.l));
            return;
        }
        if ("length".equals(this.l) && obj.getClass().isArray()) {
            qVar.a(Integer.valueOf(Array.getLength(obj)));
            return;
        }
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            Field declaredField = null;
            try {
                declaredField = superclass.getDeclaredField(this.l);
            } catch (Throwable unused) {
            }
            if (declaredField != null && !Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                qVar.a(declaredField.get(obj));
                return;
            }
        }
        w wVar = new w(12);
        wVar.b = this.b;
        wVar.c = this.c;
        wVar.p = "get" + Character.toUpperCase(this.l.charAt(0)) + this.l.substring(1);
        wVar.i = 0;
        wVar.a(obj, new Object[0], qVar);
    }

    public void a(Class<?> cls, q qVar) throws Throwable {
        Field declaredField;
        while (true) {
            if (cls != null) {
                if ("class".equals(this.l)) {
                    qVar.a(cls);
                    return;
                }
                if (cls.equals(v.class) && Constants.VERSION.equals(this.l)) {
                    qVar.a((Object) 70);
                    return;
                }
                if (cls.isEnum()) {
                    Object[] enumConstants = cls.getEnumConstants();
                    if (enumConstants != null) {
                        for (Object obj : enumConstants) {
                            if (((Enum) obj).name().equals(this.l)) {
                                qVar.a(obj);
                                return;
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    try {
                        declaredField = cls.getDeclaredField(this.l);
                    } catch (Throwable unused) {
                        declaredField = null;
                    }
                    if (declaredField != null && Modifier.isStatic(declaredField.getModifiers())) {
                        declaredField.setAccessible(true);
                        qVar.a(declaredField.get(null));
                        return;
                    }
                    cls = cls.getSuperclass();
                }
            } else {
                w wVar = new w(14);
                wVar.b = this.b;
                wVar.c = this.c;
                wVar.n = this.n;
                wVar.p = "get" + Character.toUpperCase(this.l.charAt(0)) + this.l.substring(1);
                wVar.i = 1;
                wVar.a(cls, new Object[0], qVar);
                return;
            }
        }
    }

    public void a(Class<?> cls, Object[] objArr, q qVar) throws Throwable {
        Class<?>[] parameterTypes;
        boolean[] zArr;
        boolean[] zArrA;
        Map map;
        Object obj;
        List arrayList;
        Class<?> superclass = cls;
        if ("new".equals(this.p)) {
            if (List.class.isAssignableFrom(superclass) && objArr.length == 1 && (obj = objArr[0]) != null && obj.getClass().isArray()) {
                int length = Array.getLength(objArr[0]);
                if (superclass.equals(List.class)) {
                    arrayList = new ArrayList(length);
                } else {
                    arrayList = (List) cls.newInstance();
                }
                for (int i = 0; i < length; i++) {
                    arrayList.add(Array.get(objArr[0], i));
                }
                qVar.a(arrayList);
                return;
            }
            if (Map.class.isAssignableFrom(superclass) && objArr.length == 1 && objArr[0] != null) {
                if (superclass.equals(Map.class)) {
                    map = new HashMap();
                } else {
                    map = (Map) cls.newInstance();
                }
                Object obj2 = objArr[0];
                if (obj2 instanceof Map) {
                    map.putAll((Map) obj2);
                } else {
                    Class<?> cls2 = Class.forName("org.json.JSONObject");
                    a(map, a(objArr[0], cls2), cls2, Class.forName("org.json.JSONArray"));
                }
                qVar.a(map);
                return;
            }
            if (superclass.equals(y.class)) {
                if (objArr.length == 2) {
                    qVar.a(new y((Number) objArr[0], (Number) objArr[1], null));
                    return;
                }
                if (objArr.length == 3) {
                    qVar.a(new y((Number) objArr[0], (Number) objArr[1], (Number) objArr[2]));
                    return;
                }
                throw new NoSuchMethodException("method name: new at line: " + this.b + "(" + this.c + ")");
            }
            boolean[][] zArr2 = new boolean[2][];
            Constructor constructorA = qVar.g().a(superclass, objArr, zArr2);
            if (constructorA != null) {
                Object[] objArrA = !zArr2[1][0] ? qVar.g().a(qVar, constructorA.getParameterTypes(), objArr, zArr2[0]) : objArr;
                constructorA.setAccessible(true);
                qVar.a(constructorA.newInstance(objArrA));
                return;
            }
            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                Class<?>[] parameterTypes2 = constructor.getParameterTypes();
                boolean[] zArr3 = new boolean[1];
                boolean[] zArrA2 = qVar.g().a(parameterTypes2, objArr, zArr3);
                if (zArrA2 != null) {
                    Object[] objArrA2 = !zArr3[0] ? qVar.g().a(qVar, parameterTypes2, objArr, zArrA2) : objArr;
                    constructor.setAccessible(true);
                    qVar.a(constructor.newInstance(objArrA2));
                    return;
                }
            }
            throw new NoSuchMethodException("method name: new at line: " + this.b + "(" + this.c + ")");
        }
        if ("fromJson".equals(this.p) && Map.class.isAssignableFrom(superclass) && objArr.length == 1 && objArr[0] != null) {
            this.p = "new";
            a(cls, objArr, qVar);
            return;
        }
        if (superclass.equals(Array.class)) {
            if (this.p.equals("newInstance") && objArr.length == 2) {
                Object obj3 = objArr[1];
                if (obj3 instanceof Integer) {
                    qVar.a(Array.newInstance((Class<?>) objArr[0], ((Integer) obj3).intValue()));
                    return;
                }
            }
            if ("copy".equals(this.p)) {
                int i2 = this.i;
                if (i2 == 5) {
                    System.arraycopy(objArr[0], Integer.parseInt(String.valueOf(objArr[1])), objArr[2], Integer.parseInt(String.valueOf(objArr[3])), Integer.parseInt(String.valueOf(objArr[44])));
                    return;
                }
                if (i2 == 2) {
                    Object obj4 = objArr[0];
                    System.arraycopy(obj4, 0, objArr[1], 0, Math.min(Array.getLength(obj4), Array.getLength(objArr[1])));
                    return;
                }
                throw new NoSuchMethodException("method name: copy at line: " + this.b + "(" + this.c + ")");
            }
        } else if ("quit".equals(this.p) && superclass.equals(v.class)) {
            qVar.e();
            return;
        }
        if (qVar.g().a((Object) null, cls, this.p, objArr, qVar)) {
            return;
        }
        for (Class<?> superclass2 = superclass; superclass2 != null; superclass2 = superclass2.getSuperclass()) {
            boolean[][] zArr4 = new boolean[2][];
            Method methodA = qVar.g().a(superclass2, this.p, true, objArr, zArr4);
            if (methodA != null) {
                Object[] objArrA3 = !zArr4[1][0] ? qVar.g().a(qVar, methodA.getParameterTypes(), objArr, zArr4[0]) : objArr;
                methodA.setAccessible(true);
                if (methodA.getReturnType() == Void.TYPE) {
                    methodA.invoke(null, objArrA3);
                    return;
                } else {
                    qVar.a(methodA.invoke(null, objArrA3));
                    return;
                }
            }
        }
        while (superclass != null) {
            for (Method method : superclass.getDeclaredMethods()) {
                if (method.getName().equals(this.p) && Modifier.isStatic(method.getModifiers()) && (zArrA = qVar.g().a((parameterTypes = method.getParameterTypes()), objArr, (zArr = new boolean[1]))) != null) {
                    Object[] objArrA4 = !zArr[0] ? qVar.g().a(qVar, parameterTypes, objArr, zArrA) : objArr;
                    method.setAccessible(true);
                    if (method.getReturnType() == Void.TYPE) {
                        method.invoke(null, objArrA4);
                        return;
                    } else {
                        qVar.a(method.invoke(null, objArrA4));
                        return;
                    }
                }
            }
            superclass = superclass.getSuperclass();
        }
        throw new NoSuchMethodException("method name: " + this.p + " at line: " + this.b + "(" + this.c + ")");
    }

    private Object a(Object obj, Class<?> cls) throws Throwable {
        if (obj instanceof ByteArrayOutputStream) {
            return a(((ByteArrayOutputStream) obj).toByteArray(), cls);
        }
        if (obj instanceof byte[]) {
            return a(new String((byte[]) obj, "utf-8"), cls);
        }
        if (!(obj instanceof StringBuffer) && !(obj instanceof StringBuilder)) {
            if (obj instanceof String) {
                return cls.getConstructor(String.class).newInstance(obj);
            }
            if (obj.getClass().equals(cls)) {
                return obj;
            }
            throw new ClassCastException("Failed to cast " + obj + " to be " + cls.getName() + " at line: " + this.b + "(" + this.c + ")");
        }
        return a(obj.toString(), cls);
    }

    private void a(Map map, Object obj, Class<?> cls, Class<?> cls2) throws Throwable {
        Field declaredField = cls.getDeclaredField("nameValuePairs");
        declaredField.setAccessible(true);
        Map map2 = (Map) declaredField.get(obj);
        Field declaredField2 = cls.getDeclaredField("NULL");
        declaredField2.setAccessible(true);
        Object obj2 = declaredField2.get(null);
        for (Map.Entry entry : map2.entrySet()) {
            map.put(entry.getKey(), a(entry.getValue(), obj2, cls, cls2));
        }
    }

    private Object a(Object obj, Object obj2, Class<?> cls, Class<?> cls2) throws Throwable {
        if (obj == null || obj2.equals(obj)) {
            return null;
        }
        if (obj.getClass().equals(cls)) {
            HashMap map = new HashMap();
            a((Map) map, obj, cls, cls2);
            return map;
        }
        if (!obj.getClass().equals(cls2)) {
            return obj;
        }
        Field declaredField = cls2.getDeclaredField("values");
        declaredField.setAccessible(true);
        List list = (List) declaredField.get(obj);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next(), obj2, cls, cls2));
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:268:0x0506  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.Object r18, java.lang.Object[] r19, com.mob.commons.cc.q r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.cc.w.a(java.lang.Object, java.lang.Object[], com.mob.commons.cc.q):void");
    }

    private String a(InputStream inputStream) throws Throwable {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        int i = inputStream.read(bArr);
        while (i != -1) {
            messageDigest.update(bArr, 0, i);
            i = inputStream.read(bArr);
        }
        return a(messageDigest.digest());
    }

    private String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }
}
