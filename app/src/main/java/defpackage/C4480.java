package defpackage;

import android.hardware.camera2.CaptureRequest;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: KeyGenerator.java */
/* renamed from: ய, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4480 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static Constructor f15387;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Constructor f15388;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static Constructor f15389;

    static {
        try {
            Constructor<?> declaredConstructor = Class.forName("android.hardware.camera2.CameraCharacteristics$Key").getDeclaredConstructor(String.class, Class.class);
            f15389 = declaredConstructor;
            if (declaredConstructor != null) {
                declaredConstructor.setAccessible(true);
            }
            Constructor<?> declaredConstructor2 = Class.forName("android.hardware.camera2.CaptureRequest$Key").getDeclaredConstructor(String.class, Class.class);
            f15387 = declaredConstructor2;
            if (declaredConstructor2 != null) {
                declaredConstructor2.setAccessible(true);
            }
            Constructor<?> declaredConstructor3 = Class.forName("android.hardware.camera2.CaptureResult$Key").getDeclaredConstructor(String.class, Class.class);
            f15388 = declaredConstructor3;
            if (declaredConstructor3 != null) {
                declaredConstructor3.setAccessible(true);
            }
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.d("KeyGenerator", "exception when invoke constructor of Key." + e2.getCause());
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static CaptureRequest.Key m13736(String str, Class cls) {
        Constructor constructor = f15387;
        if (constructor == null) {
            return null;
        }
        try {
            return (CaptureRequest.Key) constructor.newInstance(str, cls);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            Log.d("KeyGenerator", "new request key exception!" + e2.getCause());
            return null;
        }
    }
}
