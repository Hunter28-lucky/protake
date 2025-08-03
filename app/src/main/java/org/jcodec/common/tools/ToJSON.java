package org.jcodec.common.tools;

import com.umeng.analytics.pro.am;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.io.NIOUtils;

/* loaded from: classes2.dex */
public class ToJSON {
    private static final Set<String> omitMethods;
    private static final Set<Class> primitive;

    static {
        HashSet hashSet = new HashSet();
        primitive = hashSet;
        HashSet hashSet2 = new HashSet();
        omitMethods = hashSet2;
        hashSet.add(Boolean.class);
        hashSet.add(Byte.class);
        hashSet.add(Short.class);
        hashSet.add(Integer.class);
        hashSet.add(Long.class);
        hashSet.add(Float.class);
        hashSet.add(Double.class);
        hashSet.add(Character.class);
        hashSet2.add("getClass");
        hashSet2.add("get");
    }

    private static void escape(String str, StringBuilder sb) {
        for (char c : str.toCharArray()) {
            if (c < ' ') {
                sb.append(String.format("\\%02x", Integer.valueOf(c)));
            } else {
                sb.append(c);
            }
        }
    }

    private static void invoke(Object obj, IntArrayList intArrayList, StringBuilder sb, Method method, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = method.invoke(obj, new Object[0]);
            sb.append('\"');
            sb.append(str);
            sb.append("\":");
            if (objInvoke == null || !primitive.contains(objInvoke.getClass())) {
                toJSONSub(objInvoke, intArrayList, sb);
            } else {
                sb.append(objInvoke);
            }
        } catch (Exception unused) {
        }
    }

    private static boolean isGetter(Method method) {
        if (Modifier.isPublic(method.getModifiers())) {
            return (method.getName().startsWith("get") || (method.getName().startsWith(am.ae) && method.getReturnType() == Boolean.TYPE)) && method.getParameterTypes().length == 0;
        }
        return false;
    }

    public static String toJSON(Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        StringBuilder sb = new StringBuilder();
        toJSONSub(obj, IntArrayList.createIntArrayList(), sb);
        return sb.toString();
    }

    private static void toJSONSub(Object obj, IntArrayList intArrayList, StringBuilder sb) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (obj == null) {
            sb.append("null");
            return;
        }
        String name = obj.getClass().getName();
        if (name.startsWith("java.lang") && !name.equals("java.lang.String")) {
            sb.append("null");
            return;
        }
        int iIdentityHashCode = System.identityHashCode(obj);
        if (intArrayList.contains(iIdentityHashCode)) {
            sb.append("null");
            return;
        }
        intArrayList.push(iIdentityHashCode);
        if (obj instanceof ByteBuffer) {
            obj = NIOUtils.toArray((ByteBuffer) obj);
        }
        if (obj == null) {
            sb.append("null");
        } else if (obj instanceof String) {
            sb.append("\"");
            escape((String) obj, sb);
            sb.append("\"");
        } else if (obj instanceof Map) {
            Iterator it = ((Map) obj).entrySet().iterator();
            sb.append("{");
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                sb.append("\"");
                sb.append(entry.getKey());
                sb.append("\":");
                toJSONSub(entry.getValue(), intArrayList, sb);
                if (it.hasNext()) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            sb.append("}");
        } else if (obj instanceof Iterable) {
            Iterator it2 = ((Iterable) obj).iterator();
            sb.append("[");
            while (it2.hasNext()) {
                toJSONSub(it2.next(), intArrayList, sb);
                if (it2.hasNext()) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            sb.append("]");
        } else {
            int i = 0;
            if (obj instanceof Object[]) {
                sb.append("[");
                int length = Array.getLength(obj);
                while (i < length) {
                    toJSONSub(Array.get(obj, i), intArrayList, sb);
                    if (i < length - 1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    i++;
                }
                sb.append("]");
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                sb.append("[");
                for (int i2 = 0; i2 < jArr.length; i2++) {
                    sb.append(String.format("0x%016x", Long.valueOf(jArr[i2])));
                    if (i2 < jArr.length - 1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                sb.append("]");
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                sb.append("[");
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    sb.append(String.format("0x%08x", Integer.valueOf(iArr[i3])));
                    if (i3 < iArr.length - 1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                sb.append("]");
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                sb.append("[");
                for (int i4 = 0; i4 < fArr.length; i4++) {
                    sb.append(String.format("%.3f", Float.valueOf(fArr[i4])));
                    if (i4 < fArr.length - 1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                sb.append("]");
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                sb.append("[");
                for (int i5 = 0; i5 < dArr.length; i5++) {
                    sb.append(String.format("%.6f", Double.valueOf(dArr[i5])));
                    if (i5 < dArr.length - 1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                sb.append("]");
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                sb.append("[");
                for (int i6 = 0; i6 < sArr.length; i6++) {
                    sb.append(String.format("0x%04x", Short.valueOf(sArr[i6])));
                    if (i6 < sArr.length - 1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                sb.append("]");
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                sb.append("[");
                for (int i7 = 0; i7 < bArr.length; i7++) {
                    sb.append(String.format("0x%02x", Byte.valueOf(bArr[i7])));
                    if (i7 < bArr.length - 1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                sb.append("]");
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                sb.append("[");
                while (i < zArr.length) {
                    sb.append(zArr[i]);
                    if (i < zArr.length - 1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    i++;
                }
                sb.append("]");
            } else if (obj.getClass().isEnum()) {
                sb.append(String.valueOf(obj));
            } else {
                sb.append("{");
                Method[] methods = obj.getClass().getMethods();
                ArrayList arrayList = new ArrayList();
                int length2 = methods.length;
                while (i < length2) {
                    Method method = methods[i];
                    if (!omitMethods.contains(method.getName()) && isGetter(method)) {
                        arrayList.add(method);
                    }
                    i++;
                }
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    Method method2 = (Method) it3.next();
                    invoke(obj, intArrayList, sb, method2, toName(method2));
                    if (it3.hasNext()) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                sb.append("}");
            }
        }
        intArrayList.pop();
    }

    private static String toName(Method method) {
        if (!isGetter(method)) {
            throw new IllegalArgumentException("Not a getter");
        }
        char[] charArray = method.getName().toCharArray();
        int i = charArray[0] == 'g' ? 3 : 2;
        charArray[i] = Character.toLowerCase(charArray[i]);
        return new String(charArray, i, charArray.length - i);
    }
}
