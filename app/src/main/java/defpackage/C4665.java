package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.IBinder;
import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.FilmApp;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: AppInfoUtils.java */
/* renamed from: ೲ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4665 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m14148(byte[] bArr) throws NoSuchAlgorithmException {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            for (int i = 0; i < bArrDigest.length; i++) {
                if (Integer.toHexString(bArrDigest[i] & ExifInterface.MARKER).length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(Integer.toHexString(bArrDigest[i] & ExifInterface.MARKER));
                } else {
                    stringBuffer.append(Integer.toHexString(bArrDigest[i] & ExifInterface.MARKER));
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Object m14149() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method declaredMethod = Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", String.class);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, "package");
            Constructor<?> declaredConstructor = Class.forName("android.content.pm.IPackageManager$Stub$Proxy").getDeclaredConstructor(IBinder.class);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objInvoke);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m14150(Context context) {
        try {
            return m14148(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m14151(Signature signature, String str) throws NoSuchAlgorithmException {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] bArrDigest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & ExifInterface.MARKER) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "error!";
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static Signature[] m14152(Context context, String str) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            if (FilmApp.m405().m406()) {
                m14154(context, m14149());
            }
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static String m14153(Context context, String str, String str2) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, NoSuchAlgorithmException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String strM14151;
        Signature[] signatureArrM14152 = m14152(context, str);
        if (signatureArrM14152 != null) {
            for (Signature signature : signatureArrM14152) {
                if ("SHA1".equals(str2)) {
                    strM14151 = m14151(signature, "SHA1");
                    break;
                }
            }
            strM14151 = null;
        } else {
            strM14151 = null;
        }
        C4638.m14099("AppInfo", String.format("signal : %s ", strM14151));
        return strM14151;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static void m14154(Context context, Object obj) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getDeclaredMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("sPackageManager");
            declaredField.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("getPackageManager", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
            declaredField.set(objInvoke, obj);
            PackageManager packageManager = context.getPackageManager();
            Field declaredField2 = packageManager.getClass().getDeclaredField("mPM");
            declaredField2.setAccessible(true);
            declaredField2.set(packageManager, obj);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
