package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ManifestParser.java */
@Deprecated
/* renamed from: ߩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3869 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Context f13311;

    public C3869(Context context) {
        this.f13311 = context;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static InterfaceC4372 m12316(String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName(str);
            Object objNewInstance = null;
            try {
                objNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e2) {
                m12317(cls, e2);
            } catch (InstantiationException e3) {
                m12317(cls, e3);
            } catch (NoSuchMethodException e4) {
                m12317(cls, e4);
            } catch (InvocationTargetException e5) {
                m12317(cls, e5);
            }
            if (objNewInstance instanceof InterfaceC4372) {
                return (InterfaceC4372) objNewInstance;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + objNewInstance);
        } catch (ClassNotFoundException e6) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e6);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m12317(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public List<InterfaceC4372> m12318() throws PackageManager.NameNotFoundException {
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f13311.getPackageManager().getApplicationInfo(this.f13311.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Got null app info metadata");
                }
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                Log.v("ManifestParser", "Got app info metadata: " + applicationInfo.metaData);
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(m12316(str));
                    if (Log.isLoggable("ManifestParser", 3)) {
                        Log.d("ManifestParser", "Loaded Glide module: " + str);
                    }
                }
            }
            if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Finished loading Glide modules");
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e2);
        }
    }
}
