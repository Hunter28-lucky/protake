package com.mob.tools.utils;

import android.content.BroadcastReceiver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.mob.commons.j;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ReflectHelper implements PublicMemberKeeper {
    private static HashSet<String> a;
    private static HashMap<String, Class<?>> b;
    private static HashMap<Class<?>, String> c;
    private static LinkedHashMap<String, Method> d;

    /* renamed from: e, reason: collision with root package name */
    private static LinkedHashMap<String, Constructor<?>> f17725e;

    public interface a<ArgType, RetType> {
        RetType a(ArgType argtype);
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        a = hashSet;
        hashSet.add(j.a("009Xfdbd6h?bdcjcbbdbidd"));
        a.add(j.a("007OfdbdWh<bdcjbcca"));
        a.add(j.a("008Xfdbd0hWbdcjbibcca"));
        a.add("java.net");
        a.add(j.a("0096fdbd!h_bdcjba b+bccb"));
        HashMap<String, Class<?>> map = new HashMap<>();
        b = map;
        map.put(j.a("006f@cabadacb=g"), Double.TYPE);
        b.put(j.a("0054dfcbcabd1b"), Float.TYPE);
        b.put("long", Long.TYPE);
        b.put(j.a("003>bcbi%b"), Integer.TYPE);
        b.put("short", Short.TYPE);
        b.put("byte", Byte.TYPE);
        b.put(j.a("004KbeZa,bdbf"), Character.TYPE);
        b.put(TypedValues.Custom.S_BOOLEAN, Boolean.TYPE);
        b.put("Object", Object.class);
        b.put("String", String.class);
        b.put("Thread", Thread.class);
        b.put(j.a("008Hecbabibibddacb*g"), Runnable.class);
        b.put(j.a("006Lcfbgde[bgj"), System.class);
        b.put(j.a("006f5cabadacb)g"), Double.class);
        b.put("Float", Float.class);
        b.put("Long", Long.class);
        b.put("Integer", Integer.class);
        b.put(j.a("005JcfKa6cabf b"), Short.class);
        b.put("Byte", Byte.class);
        b.put(j.a("009@eeQa.bdbfbdbeTbgJbf"), Character.class);
        b.put("Boolean", Boolean.class);
        c = new HashMap<>();
        for (Map.Entry<String, Class<?>> entry : b.entrySet()) {
            c.put(entry.getValue(), entry.getKey());
        }
        d = new LinkedHashMap<String, Method>() { // from class: com.mob.tools.utils.ReflectHelper.1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, Method> entry2) {
                return size() > 10;
            }
        };
        f17725e = new LinkedHashMap<String, Constructor<?>>() { // from class: com.mob.tools.utils.ReflectHelper.2
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, Constructor<?>> entry2) {
                return size() > 10;
            }
        };
    }

    private static synchronized Class<?> a(String str) {
        Class<?> cls;
        cls = b.get(str);
        if (cls == null) {
            Iterator<String> it = a.iterator();
            while (it.hasNext()) {
                try {
                    importClass(it.next() + "." + str);
                } catch (Throwable unused) {
                }
                cls = b.get(str);
                if (cls != null) {
                    break;
                }
            }
        }
        return cls;
    }

    private static boolean b(Class<?>[] clsArr, Class<?>[] clsArr2) {
        boolean z;
        if (clsArr.length - clsArr2.length != 1) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= clsArr2.length) {
                z = true;
                break;
            }
            Class<?> cls = clsArr2[i];
            if (cls != null && !a(clsArr[i], cls) && !clsArr[i].isAssignableFrom(clsArr2[i])) {
                z = false;
                break;
            }
            i++;
        }
        return z && clsArr[clsArr.length - 1].isArray();
    }

    public static Object createProxy(HashMap<String, a<Object, Object[]>> map, Class<?>... clsArr) throws Throwable {
        HashMap map2 = new HashMap();
        for (final Map.Entry<String, a<Object, Object[]>> entry : map.entrySet()) {
            map2.put(entry.getKey(), new a<Object[], Object>() { // from class: com.mob.tools.utils.ReflectHelper.3
                @Override // com.mob.tools.utils.ReflectHelper.a
                public Object a(Object[] objArr) {
                    return ((Object[]) ((a) entry.getValue()).a(objArr))[0];
                }
            });
        }
        return createProxy((Map<String, a<Object[], Object>>) map2, clsArr);
    }

    public static Class<?> getClass(String str) throws Throwable {
        Class<?> clsA = a(str);
        if (clsA != null) {
            return clsA;
        }
        try {
            clsA = Class.forName(str);
            b.put(str, clsA);
            return clsA;
        } catch (Throwable unused) {
            return clsA;
        }
    }

    public static <T> T getInstanceField(Object obj, String str) throws Throwable {
        try {
            return (T) a(obj, str);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + obj.getClass() + ", fieldName: " + str, th);
        }
    }

    public static String getName(Class<?> cls) throws Throwable {
        String simpleName = c.get(cls);
        if (simpleName == null) {
            simpleName = cls.getSimpleName();
            if (b.containsKey(simpleName)) {
                c.remove(b.get(simpleName));
            }
            b.put(simpleName, cls);
            c.put(cls, simpleName);
        }
        return simpleName;
    }

    public static <T> T getStaticField(String str, String str2) throws Throwable {
        try {
            return (T) a(str, str2);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", fieldName: " + str2, th);
        }
    }

    public static String importClass(String str) throws Throwable {
        return importClass(null, str);
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws Throwable {
        return (T) a(null, obj, str, objArr, clsArr);
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object[] objArr, Class<?>[] clsArr) throws Throwable {
        return (T) a(str, null, str2, objArr, clsArr);
    }

    public static Object newInstance(String str, Object... objArr) throws Throwable {
        try {
            return a(str, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", methodName: <init>", th);
        }
    }

    public static void setInstanceField(Object obj, String str, Object obj2) throws Throwable {
        try {
            a(obj, str, obj2);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2), th);
        }
    }

    public static void setStaticField(String str, String str2, Object obj) throws Throwable {
        try {
            a(str, str2, obj);
        } catch (Throwable th) {
            if (th instanceof NoSuchFieldException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", fieldName: " + str2 + ", value: " + String.valueOf(obj), th);
        }
    }

    public static synchronized String importClass(String str, String str2) throws Throwable {
        if (str2.endsWith(".*")) {
            a.add(str2.substring(0, str2.length() - 2));
            return "*";
        }
        Class<?> cls = Class.forName(str2);
        if (str == null) {
            str = cls.getSimpleName();
        }
        if (b.containsKey(str)) {
            c.remove(b.get(str));
        }
        b.put(str, cls);
        c.put(cls, str);
        return str;
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) throws Throwable {
        try {
            return (T) a(null, obj, str, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                throw th;
            }
            throw new Throwable("className: " + obj.getClass() + ", methodName: " + str, th);
        }
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object... objArr) throws Throwable {
        try {
            return (T) a(str, null, str2, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                throw th;
            }
            throw new Throwable("className: " + str + ", methodName: " + str2, th);
        }
    }

    public static Object createProxy(final Map<String, a<Object[], Object>> map, Class<?>... clsArr) throws Throwable {
        if (clsArr.length == 0) {
            return null;
        }
        return Proxy.newProxyInstance(clsArr[0].getClassLoader(), clsArr, new InvocationHandler() { // from class: com.mob.tools.utils.ReflectHelper.4
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                a aVar = (a) map.get(method.getName());
                if (aVar != null) {
                    return aVar.a(objArr);
                }
                throw new NoSuchMethodException();
            }
        });
    }

    private static Class<?>[] a(Object[] objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj instanceof BroadcastReceiver) {
                clsArr[i] = BroadcastReceiver.class;
            } else {
                clsArr[i] = obj == null ? null : obj.getClass();
            }
        }
        return clsArr;
    }

    private static Object b(String str, Object... objArr) throws Throwable {
        Class<?> clsA;
        String strSubstring = str;
        int i = 0;
        while (strSubstring.startsWith("[")) {
            i++;
            strSubstring = strSubstring.substring(1);
        }
        int[] iArr = null;
        if (i == objArr.length) {
            int[] iArr2 = new int[i];
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    iArr2[i2] = Integer.parseInt(String.valueOf(objArr[i2]));
                } catch (Throwable unused) {
                }
            }
            iArr = iArr2;
        }
        if (iArr != null) {
            if (TransmitHelper.CAMERA_UNIT_B_CONTENT.equals(strSubstring)) {
                clsA = Byte.TYPE;
            } else if (ExifInterface.LATITUDE_SOUTH.equals(strSubstring)) {
                clsA = Short.TYPE;
            } else if ("I".equals(strSubstring)) {
                clsA = Integer.TYPE;
            } else if ("J".equals(strSubstring)) {
                clsA = Long.TYPE;
            } else if ("F".equals(strSubstring)) {
                clsA = Float.TYPE;
            } else if (TransmitHelper.CAMERA_UNIT_D_CONTENT.equals(strSubstring)) {
                clsA = Double.TYPE;
            } else if ("Z".equals(strSubstring)) {
                clsA = Boolean.TYPE;
            } else if (TransmitHelper.CAMERA_UNIT_C_CONTENT.equals(strSubstring)) {
                clsA = Character.TYPE;
            } else {
                clsA = a(strSubstring);
            }
            if (clsA != null) {
                return Array.newInstance(clsA, iArr);
            }
        }
        throw new NoSuchMethodException("className: [" + str + ", methodName: <init>");
    }

    private static boolean a(Class<?> cls, Class<?> cls2) {
        return (cls == Byte.TYPE && cls2 == Byte.class) || (cls == Short.TYPE && (cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Character.TYPE && (cls2 == Character.class || cls2 == Short.class || cls2 == Byte.class)) || ((cls == Integer.TYPE && (cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Long.TYPE && (cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Float.TYPE && (cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || ((cls == Double.TYPE && (cls2 == Double.class || cls2 == Float.class || cls2 == Long.class || cls2 == Integer.class || cls2 == Short.class || cls2 == Byte.class || cls2 == Character.class)) || (cls == Boolean.TYPE && cls2 == Boolean.class))))));
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i = 0; i < clsArr2.length; i++) {
            Class<?> cls = clsArr2[i];
            if (cls != null && !a(clsArr[i], cls) && !clsArr[i].isAssignableFrom(clsArr2[i])) {
                return false;
            }
        }
        return true;
    }

    private static Object a(String str, Object... objArr) throws Throwable {
        boolean z;
        if (str.startsWith("[")) {
            return b(str, objArr);
        }
        Class<?> clsA = a(str);
        String str2 = clsA.getName() + "#" + objArr.length;
        Constructor<?> constructor = f17725e.get(str2);
        Class<?>[] clsArrA = a(objArr);
        if (constructor != null && a(constructor.getParameterTypes(), clsArrA)) {
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        }
        Constructor<?>[] declaredConstructors = clsA.getDeclaredConstructors();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Constructor<?> constructor2 : declaredConstructors) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if (a(parameterTypes, clsArrA)) {
                f17725e.put(str2, constructor2);
                constructor2.setAccessible(true);
                return constructor2.newInstance(objArr);
            }
            if (parameterTypes.length > 0 && parameterTypes[parameterTypes.length - 1].isArray() && clsArrA.length >= parameterTypes.length - 1) {
                arrayList.add(constructor2);
                arrayList2.add(parameterTypes);
            }
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            Class[] clsArr = (Class[]) arrayList2.get(i);
            Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
            if (b((Class<?>[]) clsArr, clsArrA)) {
                Object[] objArr2 = new Object[objArr.length + 1];
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                objArr2[objArr.length] = Array.newInstance(componentType, 0);
                Constructor constructor3 = (Constructor) arrayList.get(i);
                constructor3.setAccessible(true);
                return constructor3.newInstance(objArr);
            }
            int length = clsArr.length - 1;
            while (true) {
                if (length >= clsArrA.length) {
                    z = true;
                    break;
                }
                if (!clsArrA[length].equals(componentType)) {
                    z = false;
                    break;
                }
                length++;
            }
            if (z) {
                int length2 = (clsArrA.length - clsArr.length) + 1;
                Object objNewInstance = Array.newInstance(componentType, length2);
                for (int i2 = 0; i2 < length2; i2++) {
                    Array.set(objNewInstance, i2, objArr[(clsArr.length - 1) + i2]);
                }
                Object[] objArr3 = new Object[objArr.length + 1];
                System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
                objArr3[objArr.length] = objNewInstance;
                Constructor constructor4 = (Constructor) arrayList.get(i);
                constructor4.setAccessible(true);
                return constructor4.newInstance(objArr);
            }
        }
        throw new NoSuchMethodException("className: " + str + ", methodName: <init>");
    }

    private static Object b(Object obj, String str) throws Throwable {
        int i;
        int i2;
        if (obj instanceof List) {
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i2 = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused) {
                    i2 = -1;
                }
                if (i2 != -1) {
                    return ((List) obj).get(i2);
                }
            }
        } else {
            if (j.a("006NcbOgLbidd0ba").equals(str)) {
                return Integer.valueOf(Array.getLength(obj));
            }
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused2) {
                    i = -1;
                }
                if (i != -1) {
                    return Array.get(obj, i);
                }
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
    }

    private static void b(Object obj, String str, Object obj2) throws Throwable {
        int i;
        int i2;
        if (obj instanceof List) {
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i2 = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused) {
                    i2 = -1;
                }
                if (i2 != -1) {
                    ((List) obj).set(i2, obj2);
                    return;
                }
            }
        } else if (str.startsWith("[") && str.endsWith("]")) {
            try {
                i = Integer.parseInt(str.substring(1, str.length() - 1));
            } catch (Throwable unused2) {
                i = -1;
            }
            if (i != -1) {
                String name = obj.getClass().getName();
                while (name.startsWith("[")) {
                    name = name.substring(1);
                }
                Class<?> cls = obj2.getClass();
                if (!TransmitHelper.CAMERA_UNIT_B_CONTENT.equals(name)) {
                    Object objValueOf = null;
                    if (ExifInterface.LATITUDE_SOUTH.equals(name)) {
                        if (cls == Short.class) {
                            objValueOf = obj2;
                        } else if (cls == Byte.class) {
                            objValueOf = Short.valueOf(((Byte) obj2).byteValue());
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i, objValueOf);
                            return;
                        }
                    } else if ("I".equals(name)) {
                        if (cls == Integer.class) {
                            objValueOf = obj2;
                        } else if (cls == Short.class) {
                            objValueOf = Integer.valueOf(((Short) obj2).shortValue());
                        } else if (cls == Byte.class) {
                            objValueOf = Integer.valueOf(((Byte) obj2).byteValue());
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i, objValueOf);
                            return;
                        }
                    } else if ("J".equals(name)) {
                        if (cls == Long.class) {
                            objValueOf = obj2;
                        } else if (cls == Integer.class) {
                            objValueOf = Long.valueOf(((Integer) obj2).intValue());
                        } else if (cls == Short.class) {
                            objValueOf = Long.valueOf(((Short) obj2).shortValue());
                        } else if (cls == Byte.class) {
                            objValueOf = Long.valueOf(((Byte) obj2).byteValue());
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i, objValueOf);
                            return;
                        }
                    } else if ("F".equals(name)) {
                        if (cls == Float.class) {
                            objValueOf = obj2;
                        } else if (cls == Long.class) {
                            objValueOf = Float.valueOf(((Long) obj2).longValue());
                        } else if (cls == Integer.class) {
                            objValueOf = Float.valueOf(((Integer) obj2).intValue());
                        } else if (cls == Short.class) {
                            objValueOf = Float.valueOf(((Short) obj2).shortValue());
                        } else if (cls == Byte.class) {
                            objValueOf = Float.valueOf(((Byte) obj2).byteValue());
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i, objValueOf);
                            return;
                        }
                    } else if (TransmitHelper.CAMERA_UNIT_D_CONTENT.equals(name)) {
                        if (cls == Double.class) {
                            objValueOf = obj2;
                        } else if (cls == Float.class) {
                            objValueOf = Double.valueOf(((Float) obj2).floatValue());
                        } else if (cls == Long.class) {
                            objValueOf = Double.valueOf(((Long) obj2).longValue());
                        } else if (cls == Integer.class) {
                            objValueOf = Double.valueOf(((Integer) obj2).intValue());
                        } else if (cls == Short.class) {
                            objValueOf = Double.valueOf(((Short) obj2).shortValue());
                        } else if (cls == Byte.class) {
                            objValueOf = Double.valueOf(((Byte) obj2).byteValue());
                        }
                        if (objValueOf != null) {
                            Array.set(obj, i, objValueOf);
                            return;
                        }
                    } else if ("Z".equals(name)) {
                        if (cls == Boolean.class) {
                            Array.set(obj, i, obj2);
                            return;
                        }
                    } else if (TransmitHelper.CAMERA_UNIT_C_CONTENT.equals(name)) {
                        if (cls == Character.class) {
                            Array.set(obj, i, obj2);
                            return;
                        }
                    } else if (name.equals(cls.getName())) {
                        Array.set(obj, i, obj2);
                        return;
                    }
                } else if (cls == Byte.class) {
                    Array.set(obj, i, obj2);
                    return;
                }
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2));
    }

    private static <T> T a(String str, Object obj, String str2, Object[] objArr, Class<?>[] clsArr) throws Throwable {
        Class<?> superclass;
        if (objArr == null) {
            objArr = new Object[0];
        }
        if (clsArr == null) {
            clsArr = new Class[0];
        }
        if (obj == null) {
            superclass = a(str);
        } else {
            superclass = obj.getClass();
        }
        String str3 = superclass.getName() + "#" + str2 + "#" + objArr.length;
        Method method = d.get(str3);
        if (method != null) {
            method.setAccessible(true);
            try {
                if (method.getReturnType() == Void.TYPE) {
                    method.invoke(obj, objArr);
                    return null;
                }
                return (T) method.invoke(obj, objArr);
            } catch (InvocationTargetException e2) {
                throw e2;
            }
        }
        while (superclass != null) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str2, clsArr);
                d.put(str3, declaredMethod);
                declaredMethod.setAccessible(true);
                if (declaredMethod.getReturnType() == Void.TYPE) {
                    declaredMethod.invoke(obj, objArr);
                    return null;
                }
                return (T) declaredMethod.invoke(obj, objArr);
            } catch (InvocationTargetException e3) {
                throw e3;
            } catch (Throwable unused) {
                superclass = superclass.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("className: ");
        Object obj2 = str;
        if (obj != null) {
            obj2 = obj.getClass();
        }
        sb.append(obj2);
        sb.append(", methodName: ");
        sb.append(str2);
        throw new NoSuchMethodException(sb.toString());
    }

    private static <T> T a(String str, Object obj, String str2, Object... objArr) throws Throwable {
        Class<?> superclass;
        Class<?>[] clsArrA;
        if (obj == null) {
            superclass = a(str);
        } else {
            superclass = obj.getClass();
        }
        boolean z = false;
        if (str2.equals(j.a("009Pdd>gbGeg>gbaKcaTf")) && objArr != null && objArr.length == 2) {
            clsArrA = new Class[]{String.class, Class[].class};
            if (objArr[1] == String.class) {
                objArr[1] = new Class[]{String.class};
            }
        } else if (str2.equals(j.a("011$ddDgb@dgZgh.bcbeBg2ce;f")) && objArr != null && objArr.length == 1) {
            clsArrA = new Class[]{Integer.TYPE};
        } else if (str2.equals(j.a("0063bcbi+h9cabhZg")) && objArr != null && objArr.length == 2) {
            clsArrA = new Class[]{Object.class, Object[].class};
        } else {
            clsArrA = (str2.equals(j.a("013!de9gbCchbebe?g dedebcdacb2g")) && objArr != null && objArr.length == 1) ? new Class[]{Boolean.TYPE} : a(objArr);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = clsArrA.length;
        for (int i = 0; i < length; i++) {
            Class<?> cls = clsArrA[i];
            stringBuffer.append(cls == null ? "" : cls.getName());
        }
        String str3 = superclass.getName() + "#" + str2 + "#" + objArr.length + stringBuffer.toString();
        Method method = d.get(str3);
        if (method != null) {
            boolean zIsStatic = Modifier.isStatic(method.getModifiers());
            if (obj == null) {
                z = zIsStatic;
            } else if (!zIsStatic) {
                z = true;
            }
            if (z && a(method.getParameterTypes(), clsArrA)) {
                method.setAccessible(true);
                try {
                    if (method.getReturnType() == Void.TYPE) {
                        method.invoke(obj, objArr);
                        return null;
                    }
                    return (T) method.invoke(obj, objArr);
                } catch (InvocationTargetException e2) {
                    throw e2;
                }
            }
        }
        while (superclass != null) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str2, clsArrA);
                d.put(str3, declaredMethod);
                declaredMethod.setAccessible(true);
                if (declaredMethod.getReturnType() == Void.TYPE) {
                    declaredMethod.invoke(obj, objArr);
                    return null;
                }
                return (T) declaredMethod.invoke(obj, objArr);
            } catch (InvocationTargetException e3) {
                throw e3;
            } catch (Throwable unused) {
                superclass = superclass.getSuperclass();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("className: ");
        Object obj2 = str;
        if (obj != null) {
            obj2 = obj.getClass();
        }
        sb.append(obj2);
        sb.append(", methodName: ");
        sb.append(str2);
        throw new NoSuchMethodException(sb.toString());
    }

    private static <T> T a(String str, String str2) throws Throwable {
        Field declaredField;
        ArrayList arrayList = new ArrayList();
        for (Class<?> clsA = a(str); clsA != null; clsA = clsA.getSuperclass()) {
            arrayList.add(clsA);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                declaredField = ((Class) it.next()).getDeclaredField(str2);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                return (T) declaredField.get(null);
            }
        }
        throw new NoSuchFieldException("className: " + str + ", fieldName: " + str2);
    }

    private static void a(String str, String str2, Object obj) throws Throwable {
        Field declaredField;
        ArrayList arrayList = new ArrayList();
        for (Class<?> clsA = a(str); clsA != null; clsA = clsA.getSuperclass()) {
            arrayList.add(clsA);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                declaredField = ((Class) it.next()).getDeclaredField(str2);
            } catch (Throwable unused) {
                declaredField = null;
            }
            if (declaredField != null && Modifier.isStatic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
                declaredField.set(null, obj);
                return;
            }
        }
        throw new NoSuchFieldException("className: " + str + ", fieldName: " + str2 + ", value: " + String.valueOf(obj));
    }

    private static <T> T a(Object obj, String str) throws Throwable {
        if (!(obj instanceof List) && !obj.getClass().isArray()) {
            if (obj instanceof Map) {
                return (T) ((Map) obj).get(str);
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                arrayList.add(superclass);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Field declaredField = null;
                try {
                    declaredField = ((Class) it.next()).getDeclaredField(str);
                } catch (Throwable unused) {
                }
                if (declaredField != null && !Modifier.isStatic(declaredField.getModifiers())) {
                    declaredField.setAccessible(true);
                    return (T) declaredField.get(obj);
                }
            }
            throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
        }
        return (T) b(obj, str);
    }

    private static void a(Object obj, String str, Object obj2) throws Throwable {
        if (!(obj instanceof List) && !obj.getClass().isArray()) {
            if (obj instanceof Map) {
                ((Map) obj).put(str, obj2);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                arrayList.add(superclass);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Field declaredField = null;
                try {
                    declaredField = ((Class) it.next()).getDeclaredField(str);
                } catch (Throwable unused) {
                }
                if (declaredField != null && !Modifier.isStatic(declaredField.getModifiers())) {
                    declaredField.setAccessible(true);
                    declaredField.set(obj, obj2);
                    return;
                }
            }
            throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2));
        }
        b(obj, str, obj2);
    }
}
