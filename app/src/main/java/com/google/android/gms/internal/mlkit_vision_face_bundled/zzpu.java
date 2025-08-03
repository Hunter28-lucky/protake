package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzpu {
    public static String zza(zzps zzpsVar, String str) throws SecurityException {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzpsVar, sb, 0);
        return sb.toString();
    }

    public static final void zzb(StringBuilder sb, int i, String str, Object obj) throws SecurityException {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzqt.zza(zznl.zzm((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof zznl) {
            sb.append(": \"");
            sb.append(zzqt.zza((zznl) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzon) {
            sb.append(" {");
            zzd((zzon) obj, sb, i + 2);
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i4 = i + 2;
        zzb(sb, i4, "key", entry.getKey());
        zzb(sb, i4, "value", entry.getValue());
        sb.append("\n");
        while (i2 < i) {
            sb.append(' ');
            i2++;
        }
        sb.append("}");
    }

    private static final String zzc(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    private static void zzd(zzps zzpsVar, StringBuilder sb, int i) throws SecurityException {
        boolean zEquals;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzpsVar.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String strSubstring = str.startsWith("get") ? str.substring(3) : str;
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List")) {
                String strValueOf = String.valueOf(strSubstring.substring(0, 1).toLowerCase());
                String strValueOf2 = String.valueOf(strSubstring.substring(1, strSubstring.length() - 4));
                String strConcat = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                Method method2 = (Method) map.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zzc(strConcat), zzon.zzB(method2, zzpsVar, new Object[0]));
                }
            }
            if (strSubstring.endsWith("Map") && !strSubstring.equals("Map")) {
                String strValueOf3 = String.valueOf(strSubstring.substring(0, 1).toLowerCase());
                String strValueOf4 = String.valueOf(strSubstring.substring(1, strSubstring.length() - 3));
                String strConcat2 = strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3);
                Method method3 = (Method) map.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i, zzc(strConcat2), zzon.zzB(method3, zzpsVar, new Object[0]));
                }
            }
            if (((Method) map2.get(strSubstring.length() != 0 ? "set".concat(strSubstring) : new String("set"))) != null) {
                if (strSubstring.endsWith("Bytes")) {
                    String strValueOf5 = String.valueOf(strSubstring.substring(0, strSubstring.length() - 5));
                    if (!map.containsKey(strValueOf5.length() != 0 ? "get".concat(strValueOf5) : new String("get"))) {
                    }
                }
                String strValueOf6 = String.valueOf(strSubstring.substring(0, 1).toLowerCase());
                String strValueOf7 = String.valueOf(strSubstring.substring(1));
                String strConcat3 = strValueOf7.length() != 0 ? strValueOf6.concat(strValueOf7) : new String(strValueOf6);
                Method method4 = (Method) map.get(strSubstring.length() != 0 ? "get".concat(strSubstring) : new String("get"));
                Method method5 = (Method) map.get(strSubstring.length() != 0 ? "has".concat(strSubstring) : new String("has"));
                if (method4 != null) {
                    Object objZzB = zzon.zzB(method4, zzpsVar, new Object[0]);
                    if (method5 == null) {
                        if (objZzB instanceof Boolean) {
                            if (((Boolean) objZzB).booleanValue()) {
                                zzb(sb, i, zzc(strConcat3), objZzB);
                            }
                        } else if (objZzB instanceof Integer) {
                            if (((Integer) objZzB).intValue() != 0) {
                                zzb(sb, i, zzc(strConcat3), objZzB);
                            }
                        } else if (objZzB instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objZzB).floatValue()) != 0) {
                                zzb(sb, i, zzc(strConcat3), objZzB);
                            }
                        } else if (!(objZzB instanceof Double)) {
                            if (objZzB instanceof String) {
                                zEquals = objZzB.equals("");
                            } else if (objZzB instanceof zznl) {
                                zEquals = objZzB.equals(zznl.zzb);
                            } else if (objZzB instanceof zzps) {
                                if (objZzB != ((zzps) objZzB).zzt()) {
                                    zzb(sb, i, zzc(strConcat3), objZzB);
                                }
                            } else if (!(objZzB instanceof Enum) || ((Enum) objZzB).ordinal() != 0) {
                                zzb(sb, i, zzc(strConcat3), objZzB);
                            }
                            if (!zEquals) {
                                zzb(sb, i, zzc(strConcat3), objZzB);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objZzB).doubleValue()) != 0) {
                            zzb(sb, i, zzc(strConcat3), objZzB);
                        }
                    } else if (((Boolean) zzon.zzB(method5, zzpsVar, new Object[0])).booleanValue()) {
                        zzb(sb, i, zzc(strConcat3), objZzB);
                    }
                }
            }
        }
        if (zzpsVar instanceof zzoj) {
            Iterator itZzf = ((zzoj) zzpsVar).zzb.zzf();
            while (itZzf.hasNext()) {
                Map.Entry entry = (Map.Entry) itZzf.next();
                zzb(sb, i, "[202056002]", entry.getValue());
            }
        }
        zzqw zzqwVar = ((zzon) zzpsVar).zzc;
        if (zzqwVar != null) {
            zzqwVar.zzg(sb, i);
        }
    }
}
