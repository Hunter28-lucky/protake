package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
final class zzaf {
    public static void zza(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        }
        if (obj2 != null) {
            return;
        }
        String string = obj.toString();
        StringBuilder sb = new StringBuilder(string.length() + 26);
        sb.append("null value in entry: ");
        sb.append(string);
        sb.append("=null");
        throw new NullPointerException(sb.toString());
    }
}
