package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import defpackage.C3921;
import java.io.Serializable;
import kotlin.Pair;

/* compiled from: Bundle.kt */
/* loaded from: classes.dex */
public final class BundleKt {
    public static final Bundle bundleOf(Pair<String, ? extends Object>... pairArr) {
        C3921.m12666(pairArr, "pairs");
        Bundle bundle = new Bundle(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            String strM7207 = pair.m7207();
            Object objM7208 = pair.m7208();
            if (objM7208 == null) {
                bundle.putString(strM7207, null);
            } else if (objM7208 instanceof Boolean) {
                bundle.putBoolean(strM7207, ((Boolean) objM7208).booleanValue());
            } else if (objM7208 instanceof Byte) {
                bundle.putByte(strM7207, ((Number) objM7208).byteValue());
            } else if (objM7208 instanceof Character) {
                bundle.putChar(strM7207, ((Character) objM7208).charValue());
            } else if (objM7208 instanceof Double) {
                bundle.putDouble(strM7207, ((Number) objM7208).doubleValue());
            } else if (objM7208 instanceof Float) {
                bundle.putFloat(strM7207, ((Number) objM7208).floatValue());
            } else if (objM7208 instanceof Integer) {
                bundle.putInt(strM7207, ((Number) objM7208).intValue());
            } else if (objM7208 instanceof Long) {
                bundle.putLong(strM7207, ((Number) objM7208).longValue());
            } else if (objM7208 instanceof Short) {
                bundle.putShort(strM7207, ((Number) objM7208).shortValue());
            } else if (objM7208 instanceof Bundle) {
                bundle.putBundle(strM7207, (Bundle) objM7208);
            } else if (objM7208 instanceof CharSequence) {
                bundle.putCharSequence(strM7207, (CharSequence) objM7208);
            } else if (objM7208 instanceof Parcelable) {
                bundle.putParcelable(strM7207, (Parcelable) objM7208);
            } else if (objM7208 instanceof boolean[]) {
                bundle.putBooleanArray(strM7207, (boolean[]) objM7208);
            } else if (objM7208 instanceof byte[]) {
                bundle.putByteArray(strM7207, (byte[]) objM7208);
            } else if (objM7208 instanceof char[]) {
                bundle.putCharArray(strM7207, (char[]) objM7208);
            } else if (objM7208 instanceof double[]) {
                bundle.putDoubleArray(strM7207, (double[]) objM7208);
            } else if (objM7208 instanceof float[]) {
                bundle.putFloatArray(strM7207, (float[]) objM7208);
            } else if (objM7208 instanceof int[]) {
                bundle.putIntArray(strM7207, (int[]) objM7208);
            } else if (objM7208 instanceof long[]) {
                bundle.putLongArray(strM7207, (long[]) objM7208);
            } else if (objM7208 instanceof short[]) {
                bundle.putShortArray(strM7207, (short[]) objM7208);
            } else if (objM7208 instanceof Object[]) {
                Class<?> componentType = objM7208.getClass().getComponentType();
                C3921.m12664(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    bundle.putParcelableArray(strM7207, (Parcelable[]) objM7208);
                } else if (String.class.isAssignableFrom(componentType)) {
                    bundle.putStringArray(strM7207, (String[]) objM7208);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    bundle.putCharSequenceArray(strM7207, (CharSequence[]) objM7208);
                } else {
                    if (!Serializable.class.isAssignableFrom(componentType)) {
                        throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + strM7207 + '\"');
                    }
                    bundle.putSerializable(strM7207, (Serializable) objM7208);
                }
            } else if (objM7208 instanceof Serializable) {
                bundle.putSerializable(strM7207, (Serializable) objM7208);
            } else if (objM7208 instanceof IBinder) {
                BundleApi18ImplKt.putBinder(bundle, strM7207, (IBinder) objM7208);
            } else if (objM7208 instanceof Size) {
                BundleApi21ImplKt.putSize(bundle, strM7207, (Size) objM7208);
            } else {
                if (!(objM7208 instanceof SizeF)) {
                    throw new IllegalArgumentException("Illegal value type " + objM7208.getClass().getCanonicalName() + " for key \"" + strM7207 + '\"');
                }
                BundleApi21ImplKt.putSizeF(bundle, strM7207, (SizeF) objM7208);
            }
        }
        return bundle;
    }

    public static final Bundle bundleOf() {
        return new Bundle(0);
    }
}
