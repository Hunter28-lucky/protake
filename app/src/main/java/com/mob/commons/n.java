package com.mob.commons;

import android.content.Context;
import android.os.Bundle;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import java.io.Closeable;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;

/* loaded from: classes2.dex */
public class n {
    public static volatile String a = null;
    public static volatile String b = null;
    public static volatile InternationalDomain c = null;
    public static volatile boolean d = false;

    /* renamed from: e, reason: collision with root package name */
    public static volatile boolean f17685e = true;
    public static volatile boolean f = false;
    public static volatile boolean g = true;
    public static volatile boolean h = false;
    public static volatile String i;
    private static AtomicBoolean j = new AtomicBoolean(false);
    private static HashMap<String, HashMap<String, Object>> k = new HashMap<>();

    public static void a(Context context) {
        try {
            if (j.compareAndSet(false, true)) {
                try {
                    if (a == null) {
                        a = (String) MobMeta.get(null, "Mob-AppKey", String.class, null);
                    }
                    if (b == null) {
                        b = (String) MobMeta.get(null, "Mob-AppSecret", String.class, null);
                    }
                    if (b == null) {
                        b = (String) MobMeta.get(null, "Mob-AppSeret", String.class, null);
                    }
                } catch (Throwable unused) {
                }
                try {
                    String str = (String) MobMeta.get(null, b("006>ehdb2k(cecdcj"), String.class, null);
                    if (str != null) {
                        c = InternationalDomain.domainOf(str);
                    }
                } catch (Throwable unused2) {
                    c = InternationalDomain.DEFAULT;
                }
                i = (String) MobMeta.get(null, "Mob-OdVivoAppId", String.class, null);
                String strB = b("009EfhdbebghgcMccd!ef");
                Class cls = Boolean.TYPE;
                Boolean bool = Boolean.FALSE;
                d = ((Boolean) MobMeta.get(null, strB, cls, bool)).booleanValue();
                f17685e = ((Boolean) MobMeta.get(null, b("015Ffhdbebghfg$d^de h9cfBhBefefcecgch"), cls, Boolean.valueOf(f17685e))).booleanValue();
                f = ((Boolean) MobMeta.get(null, b("006Ufhdbebghfehd"), cls, bool)).booleanValue();
                g = ((Boolean) MobMeta.get(null, "Mob-elog", cls, Boolean.TRUE)).booleanValue();
                h = ((Boolean) MobMeta.get(null, "Mob-GPP", cls, bool)).booleanValue();
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    public static String b(String str) {
        return C5340r.a(str, 98);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v5 */
    public static <T> T a(String str, Class<T> cls, MobProduct mobProduct) {
        T t;
        ObjectInputStream objectInputStream;
        HashMap<String, Object> map;
        Object obj;
        T tCast;
        Closeable closeable = (T) null;
        try {
            String strA = a(mobProduct);
            if (k.containsKey(strA)) {
                map = k.get(strA);
                objectInputStream = null;
            } else {
                objectInputStream = new ObjectInputStream(new GZIPInputStream(MobSDK.getContext().getResources().getAssets().open(strA)));
                try {
                    HashMap<String, Object> map2 = (HashMap) objectInputStream.readObject();
                    if (map2 != null && !map2.isEmpty()) {
                        k.put(strA, map2);
                    }
                    map = map2;
                } catch (Throwable th) {
                    th = th;
                    obj = 0;
                    closeable = (T) objectInputStream;
                    t = obj;
                    try {
                        MobLog.getInstance().d(th);
                        C5340r.a(closeable);
                        return t;
                    } catch (Throwable th2) {
                        C5340r.a(closeable);
                        throw th2;
                    }
                }
            }
            if (map != null && !map.isEmpty()) {
                obj = map.get(str);
                if (b("009?fhdbebghgcPccdEef").equals(str) && obj != 0 && (obj instanceof String)) {
                    closeable = (T) Boolean.valueOf(b("003Ych*h3ef").equalsIgnoreCase(String.valueOf(obj)) || b("004cUcgcb(h").equalsIgnoreCase(String.valueOf(obj)));
                } else if (obj != 0) {
                    if (cls == null) {
                        closeable = (T) obj;
                    } else if (cls != Void.class) {
                        try {
                            if (cls == Boolean.TYPE) {
                                if (obj instanceof String) {
                                    tCast = (T) Boolean.valueOf((String) obj);
                                } else {
                                    tCast = (T) Boolean.class.cast(obj);
                                }
                            } else if (cls == Integer.TYPE) {
                                if (obj instanceof String) {
                                    tCast = (T) Integer.valueOf((String) obj);
                                } else {
                                    tCast = (T) Integer.class.cast(obj);
                                }
                            } else if (cls == Byte.TYPE) {
                                if (obj instanceof String) {
                                    tCast = (T) Byte.valueOf((String) obj);
                                } else {
                                    tCast = (T) Byte.class.cast(obj);
                                }
                            } else {
                                Class<T> cls2 = Character.TYPE;
                                if (cls == cls2) {
                                    if (obj instanceof String) {
                                        tCast = cls2.cast(obj);
                                    } else {
                                        tCast = (T) Character.class.cast(obj);
                                    }
                                } else if (cls == Short.TYPE) {
                                    if (obj instanceof String) {
                                        tCast = (T) Short.valueOf((String) obj);
                                    } else {
                                        tCast = (T) Short.class.cast(obj);
                                    }
                                } else if (cls == Long.TYPE) {
                                    if (obj instanceof String) {
                                        tCast = (T) Long.valueOf((String) obj);
                                    } else {
                                        tCast = (T) Long.class.cast(obj);
                                    }
                                } else if (cls == Float.TYPE) {
                                    if (obj instanceof String) {
                                        tCast = (T) Float.valueOf((String) obj);
                                    } else {
                                        tCast = (T) Float.class.cast(obj);
                                    }
                                } else if (cls == Double.TYPE) {
                                    if (obj instanceof String) {
                                        tCast = (T) Double.valueOf((String) obj);
                                    } else {
                                        tCast = (T) Double.class.cast(obj);
                                    }
                                } else {
                                    tCast = cls.cast(obj);
                                }
                            }
                            closeable = (T) tCast;
                        } catch (Throwable th3) {
                            try {
                                MobLog.getInstance().d(th3);
                            } catch (Throwable th4) {
                                th = th4;
                                closeable = (T) objectInputStream;
                                t = obj;
                                MobLog.getInstance().d(th);
                                C5340r.a(closeable);
                                return t;
                            }
                        }
                    }
                }
            }
            C5340r.a(objectInputStream);
            return (T) closeable;
        } catch (Throwable th5) {
            th = th5;
            t = null;
        }
    }

    public static <T> T a(String str) {
        try {
            Bundle bundle = com.mob.tools.a.c.a(MobSDK.getContext()).b().a(false, 0, MobSDK.getContext().getPackageName(), 128).applicationInfo.metaData;
            if (bundle == null) {
                return null;
            }
            T t = (T) bundle.get(str);
            if (b("009Tfhdbebghgc ccdKef").equals(str) && t != null && (t instanceof String)) {
                return (T) Boolean.valueOf(b("003!chSh.ef").equalsIgnoreCase(String.valueOf(t)));
            }
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    private static String a(MobProduct mobProduct) {
        String str;
        if (mobProduct == null) {
            return "MobSDK.mt";
        }
        try {
            String productTag = mobProduct.getProductTag();
            if ("SHARESDK".equals(productTag)) {
                str = "ShareSDK.mt";
            } else if (b("006;dgfhdgdgehgi").equals(productTag)) {
                str = "SMSSDK.mt";
            } else if ("MOBLINK".equals(productTag)) {
                str = "MobLink.mt";
            } else if ("MOBPUSH".equals(productTag)) {
                str = "MobPush.mt";
            } else {
                if (!b("009_dgfcfffefcfddfejhh").equals(productTag)) {
                    return "MobSDK.mt";
                }
                str = "SecVerify.mt";
            }
            return str;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return "MobSDK.mt";
        }
    }
}
