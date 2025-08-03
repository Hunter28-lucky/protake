package defpackage;

import android.content.Intent;
import android.net.Uri;
import com.google.zxing.BarcodeFormat;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: DecodeFormatManager.java */
/* renamed from: ɜ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2580 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final Pattern f9602 = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Set<BarcodeFormat> f9603;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final Set<BarcodeFormat> f9604;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final Set<BarcodeFormat> f9605;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final Set<BarcodeFormat> f9606;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final Set<BarcodeFormat> f9607;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final Set<BarcodeFormat> f9608;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final Set<BarcodeFormat> f9609;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final Map<String, Set<BarcodeFormat>> f9610;

    static {
        EnumSet enumSetOf = EnumSet.of(BarcodeFormat.QR_CODE);
        f9606 = enumSetOf;
        EnumSet enumSetOf2 = EnumSet.of(BarcodeFormat.DATA_MATRIX);
        f9607 = enumSetOf2;
        EnumSet enumSetOf3 = EnumSet.of(BarcodeFormat.AZTEC);
        f9608 = enumSetOf3;
        EnumSet enumSetOf4 = EnumSet.of(BarcodeFormat.PDF_417);
        f9609 = enumSetOf4;
        EnumSet enumSetOf5 = EnumSet.of(BarcodeFormat.UPC_A, BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED);
        f9603 = enumSetOf5;
        EnumSet enumSetOf6 = EnumSet.of(BarcodeFormat.CODE_39, BarcodeFormat.CODE_93, BarcodeFormat.CODE_128, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
        f9604 = enumSetOf6;
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) enumSetOf5);
        f9605 = enumSetCopyOf;
        enumSetCopyOf.addAll(enumSetOf6);
        HashMap map = new HashMap();
        f9610 = map;
        map.put("ONE_D_MODE", enumSetCopyOf);
        map.put("PRODUCT_MODE", enumSetOf5);
        map.put("QR_CODE_MODE", enumSetOf);
        map.put("DATA_MATRIX_MODE", enumSetOf2);
        map.put("AZTEC_MODE", enumSetOf3);
        map.put("PDF417_MODE", enumSetOf4);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static Set<BarcodeFormat> m9453(Intent intent) {
        String stringExtra = intent.getStringExtra("SCAN_FORMATS");
        return m9455(stringExtra != null ? Arrays.asList(f9602.split(stringExtra)) : null, intent.getStringExtra("SCAN_MODE"));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Set<BarcodeFormat> m9454(Uri uri) {
        List<String> queryParameters = uri.getQueryParameters("SCAN_FORMATS");
        if (queryParameters != null && queryParameters.size() == 1 && queryParameters.get(0) != null) {
            queryParameters = Arrays.asList(f9602.split(queryParameters.get(0)));
        }
        return m9455(queryParameters, uri.getQueryParameter("SCAN_MODE"));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static Set<BarcodeFormat> m9455(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet enumSetNoneOf = EnumSet.noneOf(BarcodeFormat.class);
            try {
                Iterator<String> it = iterable.iterator();
                while (it.hasNext()) {
                    enumSetNoneOf.add(BarcodeFormat.valueOf(it.next()));
                }
                return enumSetNoneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return f9610.get(str);
        }
        return null;
    }
}
