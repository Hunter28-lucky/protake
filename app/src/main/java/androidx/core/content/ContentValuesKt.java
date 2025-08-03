package androidx.core.content;

import android.content.ContentValues;
import defpackage.C3921;
import kotlin.Pair;

/* compiled from: ContentValues.kt */
/* loaded from: classes.dex */
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(Pair<String, ? extends Object>... pairArr) {
        C3921.m12666(pairArr, "pairs");
        ContentValues contentValues = new ContentValues(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            String strM7207 = pair.m7207();
            Object objM7208 = pair.m7208();
            if (objM7208 == null) {
                contentValues.putNull(strM7207);
            } else if (objM7208 instanceof String) {
                contentValues.put(strM7207, (String) objM7208);
            } else if (objM7208 instanceof Integer) {
                contentValues.put(strM7207, (Integer) objM7208);
            } else if (objM7208 instanceof Long) {
                contentValues.put(strM7207, (Long) objM7208);
            } else if (objM7208 instanceof Boolean) {
                contentValues.put(strM7207, (Boolean) objM7208);
            } else if (objM7208 instanceof Float) {
                contentValues.put(strM7207, (Float) objM7208);
            } else if (objM7208 instanceof Double) {
                contentValues.put(strM7207, (Double) objM7208);
            } else if (objM7208 instanceof byte[]) {
                contentValues.put(strM7207, (byte[]) objM7208);
            } else if (objM7208 instanceof Byte) {
                contentValues.put(strM7207, (Byte) objM7208);
            } else {
                if (!(objM7208 instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + objM7208.getClass().getCanonicalName() + " for key \"" + strM7207 + '\"');
                }
                contentValues.put(strM7207, (Short) objM7208);
            }
        }
        return contentValues;
    }
}
