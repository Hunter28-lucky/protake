package defpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import org.jcodec.platform.Platform;

/* compiled from: FastServiceLoader.kt */
/* renamed from: ݹ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3770 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C3770 f13011 = new C3770();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final <S> S m12068(String str, ClassLoader classLoader, Class<S> cls) throws ClassNotFoundException {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final <S> List<S> m12069(Class<S> cls, ClassLoader classLoader) {
        try {
            return m12071(cls, classLoader);
        } catch (Throwable unused) {
            return C2543.m9382(ServiceLoader.load(cls, classLoader));
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final List<MainDispatcherFactory> m12070() {
        MainDispatcherFactory mainDispatcherFactory;
        if (!C3177.m10785()) {
            return m12069(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 == null) {
                return arrayList;
            }
            arrayList.add(mainDispatcherFactory2);
            return arrayList;
        } catch (Throwable unused3) {
            return m12069(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final <S> List<S> m12071(Class<S> cls, ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources(C3921.m12673("META-INF/services/", cls.getName())));
        C3921.m12665(list, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C3864.m12311(arrayList, f13011.m12072((URL) it.next()));
        }
        Set setM9385 = C2543.m9385(arrayList);
        if (!(!setM9385.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        ArrayList arrayList2 = new ArrayList(C4362.m13522(setM9385, 10));
        Iterator it2 = setM9385.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f13011.m12068((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final List<String> m12072(URL url) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        BufferedReader bufferedReader;
        String string = url.toString();
        if (!e0.m5980(string, "jar", false, 2, null)) {
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> listM12073 = f13011.m12073(bufferedReader);
                C3494.m11412(bufferedReader, null);
                return listM12073;
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        }
        String strM7317 = StringsKt__StringsKt.m7317(StringsKt__StringsKt.m7312(string, "jar:file:", null, 2, null), '!', null, 2, null);
        String strM7312 = StringsKt__StringsKt.m7312(string, "!/", null, 2, null);
        JarFile jarFile = new JarFile(strM7317, false);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(strM7312)), Platform.UTF_8));
            try {
                List<String> listM120732 = f13011.m12073(bufferedReader);
                C3494.m11412(bufferedReader, null);
                jarFile.close();
                return listM120732;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                try {
                    jarFile.close();
                    throw th3;
                } catch (Throwable th4) {
                    C4147.m13130(th2, th4);
                    throw th2;
                }
            }
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final List<String> m12073(BufferedReader bufferedReader) throws IOException {
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return C2543.m9382(linkedHashSet);
            }
            String strM7318 = StringsKt__StringsKt.m7318(line, "#", null, 2, null);
            if (strM7318 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String string = StringsKt__StringsKt.m7319(strM7318).toString();
            int i = 0;
            while (true) {
                if (i >= string.length()) {
                    z = true;
                    break;
                }
                char cCharAt = string.charAt(i);
                if (!(cCharAt == '.' || Character.isJavaIdentifierPart(cCharAt))) {
                    z = false;
                    break;
                }
                i++;
            }
            if (!z) {
                throw new IllegalArgumentException(C3921.m12673("Illegal service provider class name: ", string).toString());
            }
            if (string.length() > 0) {
                linkedHashSet.add(string);
            }
        }
    }
}
