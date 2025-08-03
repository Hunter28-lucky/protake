package com.mob.commons.cc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: classes2.dex */
public class q {
    private s a;
    private HashMap<String, Object> c;

    /* renamed from: e, reason: collision with root package name */
    private q f17671e;
    private boolean f;
    private LinkedList<Object> b = new LinkedList<>();
    private HashMap<String, Class<?>> d = new HashMap<>();

    public q(HashMap<String, Object> map, s sVar) {
        this.a = sVar;
        this.c = new HashMap<>(map);
    }

    public void a(Object obj) {
        this.b.push(obj);
    }

    public void b(String str, Object obj) {
        if (this.c.containsKey(str)) {
            this.c.put(str, obj);
            return;
        }
        q qVar = this.f17671e;
        if (qVar != null) {
            qVar.b(str, obj);
            return;
        }
        throw new RuntimeException("\"" + str + "\" has not defined");
    }

    public q c() {
        return this.f17671e;
    }

    public int d() {
        return this.b.size();
    }

    public void e() {
        this.f = true;
    }

    public boolean f() {
        return this.f;
    }

    public s g() {
        return this.a;
    }

    public Object a() {
        return this.b.pop();
    }

    public void a(String str, Object obj) {
        if (!this.c.containsKey(str)) {
            this.c.put(str, obj);
            return;
        }
        throw new RuntimeException("\"" + str + "\" has defined");
    }

    public Object a(String str) {
        for (q qVar = this; qVar != null; qVar = qVar.f17671e) {
            if (qVar.c.containsKey(str)) {
                return qVar.c.get(str);
            }
        }
        throw new RuntimeException("Can not find \"" + str + "\"");
    }

    public Class<?> b(String str) {
        for (q qVar = this; qVar != null; qVar = qVar.f17671e) {
            if (qVar.d.containsKey(str)) {
                return qVar.d.get(str);
            }
        }
        throw new RuntimeException("Can not find class " + str);
    }

    public void a(String str, Class<?> cls) {
        this.d.put(str, cls);
    }

    public q b() {
        q qVar = new q(new HashMap(), this.a);
        qVar.f17671e = this;
        return qVar;
    }

    public Object a(final Object obj, final boolean z, Class<?>... clsArr) {
        return Proxy.newProxyInstance(getClass().getClassLoader(), clsArr, new InvocationHandler() { // from class: com.mob.commons.cc.q.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj2, Method method, Object[] objArr) throws Throwable {
                Throwable th;
                x xVar;
                try {
                    Object obj3 = obj;
                    xVar = obj3 != null ? obj3 instanceof x ? (x) obj3 : (x) ((Map) obj3).get(method.getName()) : null;
                } catch (Throwable unused) {
                }
                if (xVar != null) {
                    if (objArr == null) {
                        objArr = new Object[0];
                    }
                    LinkedList<Object> linkedListB = z ? xVar.b(objArr) : xVar.b(objArr);
                    if (linkedListB.isEmpty()) {
                        return null;
                    }
                    return linkedListB.get(0);
                }
                th = null;
                if (th == null) {
                    return null;
                }
                throw th;
            }
        });
    }

    public void a(Method method, int i) throws Throwable {
        Object[] objArr = new Object[i];
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = a();
        }
        a(method, objArr);
    }

    public void a(Method method, Object[] objArr) throws Throwable {
        Object obj;
        if (Modifier.isStatic(method.getModifiers())) {
            obj = null;
        } else if (objArr.length > 0) {
            obj = objArr[0];
            int length = objArr.length - 1;
            Object[] objArr2 = new Object[length];
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                objArr2[i] = objArr[i2];
                i = i2;
            }
            objArr = objArr2;
        } else {
            throw new RuntimeException("receiver not found");
        }
        method.setAccessible(true);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (method.getParameterTypes()[i3].isInterface()) {
                Object obj2 = objArr[i3];
                if (obj2 instanceof x) {
                    objArr[i3] = a(obj2, true, method.getParameterTypes()[i3]);
                }
            }
        }
        if (method.getReturnType() == Void.TYPE) {
            method.invoke(obj, objArr);
        } else {
            a(method.invoke(obj, objArr));
        }
    }
}
