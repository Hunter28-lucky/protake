package org.jcodec.platform;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.jcodec.common.tools.ToJSON;

/* loaded from: classes2.dex */
public class Platform {
    public static final String ISO8859_1 = "iso8859-1";
    public static final String UTF_16 = "UTF-16";
    public static final String UTF_16BE = "UTF-16BE";
    public static final String UTF_8 = "UTF-8";
    private static final Map<Class, Class> boxed2primitive;

    static {
        HashMap map = new HashMap();
        boxed2primitive = map;
        map.put(Void.class, Void.TYPE);
        map.put(Byte.class, Byte.TYPE);
        map.put(Short.class, Short.TYPE);
        map.put(Character.class, Character.TYPE);
        map.put(Integer.class, Integer.TYPE);
        map.put(Long.class, Long.TYPE);
        map.put(Float.class, Float.TYPE);
        map.put(Double.class, Double.TYPE);
    }

    public static Class<?> arrayComponentType(Object[] objArr) {
        return objArr.getClass().getComponentType();
    }

    public static boolean arrayEqualsByte(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public static boolean arrayEqualsInt(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    public static boolean arrayEqualsObj(Object[] objArr, Object[] objArr2) {
        return Arrays.equals(objArr, objArr2);
    }

    public static String arrayToString(Object[] objArr) {
        return Arrays.toString(objArr);
    }

    private static Class[] classes(Object[] objArr) {
        Class[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Class<?> cls = objArr[i].getClass();
            Map<Class, Class> map = boxed2primitive;
            if (map.containsKey(cls)) {
                clsArr[i] = map.get(cls);
            } else {
                clsArr[i] = cls;
            }
        }
        return clsArr;
    }

    public static boolean[] copyOfBool(boolean[] zArr, int i) {
        return Arrays.copyOf(zArr, i);
    }

    public static byte[] copyOfByte(byte[] bArr, int i) {
        return Arrays.copyOf(bArr, i);
    }

    public static int[] copyOfInt(int[] iArr, int i) {
        return Arrays.copyOf(iArr, i);
    }

    public static long[] copyOfLong(long[] jArr, int i) {
        return Arrays.copyOf(jArr, i);
    }

    public static <T> T[] copyOfObj(T[] tArr, int i) {
        return (T[]) Arrays.copyOf(tArr, i);
    }

    public static byte[] copyOfRangeB(byte[] bArr, int i, int i2) {
        return Arrays.copyOfRange(bArr, i, i2);
    }

    public static int[] copyOfRangeI(int[] iArr, int i, int i2) {
        return Arrays.copyOfRange(iArr, i, i2);
    }

    public static long[] copyOfRangeL(long[] jArr, int i, int i2) {
        return Arrays.copyOfRange(jArr, i, i2);
    }

    public static <T> T[] copyOfRangeO(T[] tArr, int i, int i2) {
        return (T[]) Arrays.copyOfRange(tArr, i, i2);
    }

    public static boolean deleteFile(File file) {
        return file.delete();
    }

    public static byte[] getBytes(String str) {
        try {
            return str.getBytes(ISO8859_1);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static byte[] getBytesForCharset(String str, String str2) {
        return str.getBytes(Charset.forName(str2));
    }

    public static Field[] getDeclaredFields(Class<?> cls) {
        return cls.getDeclaredFields();
    }

    public static Field[] getFields(Class<?> cls) {
        return cls.getFields();
    }

    public static <T> T invokeStaticMethod(Class<?> cls, String str, Object[] objArr) throws NoSuchMethodException, SecurityException {
        try {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.getName().equals(str)) {
                    return (T) method.invoke(null, objArr);
                }
            }
            throw new NoSuchMethodException(cls + "." + str);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean isAssignableFrom(Class cls, Class cls2) {
        if (cls == cls2 || cls.equals(cls2)) {
            return true;
        }
        return cls.isAssignableFrom(cls2);
    }

    public static <T> T newInstance(Class<T> cls, Object[] objArr) {
        try {
            return cls.getConstructor(classes(objArr)).newInstance(objArr);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static InputStream stdin() {
        return System.in;
    }

    public static String stringFromBytes(byte[] bArr) {
        try {
            return new String(bArr, ISO8859_1);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static String stringFromChars(char[] cArr) {
        return new String(cArr);
    }

    public static String stringFromCharset(byte[] bArr, String str) {
        return new String(bArr, Charset.forName(str));
    }

    public static String stringFromCharset4(byte[] bArr, int i, int i2, String str) {
        return new String(bArr, i, i2, Charset.forName(str));
    }

    public static String toJSON(Object obj) {
        return ToJSON.toJSON(obj);
    }

    public static long unsignedInt(int i) {
        return i & 4294967295L;
    }
}
