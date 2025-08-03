package com.mob.tools.a;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.mob.tools.utils.ReflectHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class h {
    private static final String a = com.mob.commons.j.a("014GcjdeejeidchaehffbddeQf7fd,h*ej");
    private static h b;
    private a c;

    public interface a {
        <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) throws Throwable;
    }

    public static class b implements a {
        private Method a;
        private Method b;
        private Method c;
        private Method d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f17715e;

        public b(Context context) {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f17715e = false;
            try {
                File file = new File(context.getFilesDir(), h.a);
                if (!file.exists()) {
                    byte[] bArrDecode = Base64.decode("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", 2);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(bArrDecode);
                    fileOutputStream.close();
                }
                Class cls = (Class) ReflectHelper.invokeInstanceMethod(ReflectHelper.newInstance(ReflectHelper.importClass(com.mob.commons.j.a("021fLbdcbAhEbcbhcjdebgdeEbgjIcjdgYg.bjdibccb7g")), file), com.mob.commons.j.a("009_cbcabd-f'eecbbddede"), new Object[]{com.mob.commons.j.a("026Gbeca4jIcjHjfCcjbebd0b>cjdabcbi'fgNbfcjfbbcdhbcbi%fg[bf"), null}, new Class[]{String.class, ClassLoader.class});
                Method declaredMethod = cls.getDeclaredMethod(com.mob.commons.j.a("010WbcbiLh$cabh_g9fbchefce"), Class.class, Object.class, String.class, Class[].class, Object[].class);
                this.a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = cls.getDeclaredMethod(com.mob.commons.j.a("010SbcbiAhRcabhWgYfbchefce"), String.class, Object.class, String.class, Class[].class, Object[].class);
                this.b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls.getDeclaredMethod(com.mob.commons.j.a("0124biIg=dbfbcebide>b5bdbibeWg"), String.class);
                this.c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                Method declaredMethod4 = cls.getDeclaredMethod(com.mob.commons.j.a("009Zdd:gb9fbdibc$gYcbNf"), String.class, String.class, Object.class);
                this.d = declaredMethod4;
                declaredMethod4.setAccessible(true);
                this.f17715e = true;
            } catch (Throwable unused) {
            }
        }

        @Override // com.mob.tools.a.h.a
        public <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) throws Throwable {
            Method method = this.a;
            if (method != null) {
                return (T) method.invoke(null, cls, obj, str, clsArr, objArr);
            }
            throw new Throwable("IHA is null");
        }
    }

    public static class c implements a {
        @Override // com.mob.tools.a.h.a
        public <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) throws Throwable {
            Method method = (Method) Class.class.getDeclaredMethod(com.mob.commons.j.a("0178ddBgbMdgQg becbbdbf=gf0eg gbaAcaYf"), String.class, Class[].class).invoke(cls, str, clsArr);
            method.setAccessible(true);
            return (T) method.invoke(obj, objArr);
        }
    }

    private h(Context context, int i) {
        if (i < 30 || Build.VERSION.SDK_INT < 30) {
            this.c = new c();
        } else {
            this.c = new b(context);
        }
    }

    public static synchronized h a(Context context, int i) {
        if (b == null) {
            b = new h(context, i);
        }
        return b;
    }

    public <T> T a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) throws Throwable {
        return (T) this.c.a(cls, obj, str, clsArr, objArr);
    }
}
