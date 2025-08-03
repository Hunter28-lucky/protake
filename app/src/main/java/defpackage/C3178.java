package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.zxing.DecodeHintType;
import com.xiaomi.mipush.sdk.Constants;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: DecodeHintManager.java */
/* renamed from: Դ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3178 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String f11256 = "Դ";

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Pattern f11257 = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static Map<DecodeHintType, Object> m10786(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        for (DecodeHintType decodeHintType : DecodeHintType.values()) {
            if (decodeHintType != DecodeHintType.CHARACTER_SET && decodeHintType != DecodeHintType.NEED_RESULT_POINT_CALLBACK && decodeHintType != DecodeHintType.POSSIBLE_FORMATS) {
                String strName = decodeHintType.name();
                if (extras.containsKey(strName)) {
                    if (decodeHintType.getValueType().equals(Void.class)) {
                        enumMap.put((EnumMap) decodeHintType, (DecodeHintType) Boolean.TRUE);
                    } else {
                        Object obj = extras.get(strName);
                        if (decodeHintType.getValueType().isInstance(obj)) {
                            enumMap.put((EnumMap) decodeHintType, (DecodeHintType) obj);
                        } else {
                            Log.w(f11256, "Ignoring hint " + decodeHintType + " because it is not a " + decodeHintType.getValueType());
                        }
                    }
                }
            }
        }
        return enumMap;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Map<DecodeHintType, ?> m10787(Uri uri) {
        String strSubstring;
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null || encodedQuery.isEmpty()) {
            return null;
        }
        Map<String, String> mapM10788 = m10788(encodedQuery);
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        for (DecodeHintType decodeHintType : DecodeHintType.values()) {
            if (decodeHintType != DecodeHintType.CHARACTER_SET && decodeHintType != DecodeHintType.NEED_RESULT_POINT_CALLBACK && decodeHintType != DecodeHintType.POSSIBLE_FORMATS && (strSubstring = mapM10788.get(decodeHintType.name())) != null) {
                if (decodeHintType.getValueType().equals(Object.class)) {
                    enumMap.put((EnumMap) decodeHintType, (DecodeHintType) strSubstring);
                } else if (decodeHintType.getValueType().equals(Void.class)) {
                    enumMap.put((EnumMap) decodeHintType, (DecodeHintType) Boolean.TRUE);
                } else if (decodeHintType.getValueType().equals(String.class)) {
                    enumMap.put((EnumMap) decodeHintType, (DecodeHintType) strSubstring);
                } else if (decodeHintType.getValueType().equals(Boolean.class)) {
                    if (strSubstring.isEmpty()) {
                        enumMap.put((EnumMap) decodeHintType, (DecodeHintType) Boolean.TRUE);
                    } else if ("0".equals(strSubstring) || "false".equalsIgnoreCase(strSubstring) || "no".equalsIgnoreCase(strSubstring)) {
                        enumMap.put((EnumMap) decodeHintType, (DecodeHintType) Boolean.FALSE);
                    } else {
                        enumMap.put((EnumMap) decodeHintType, (DecodeHintType) Boolean.TRUE);
                    }
                } else if (decodeHintType.getValueType().equals(int[].class)) {
                    if (!strSubstring.isEmpty() && strSubstring.charAt(strSubstring.length() - 1) == ',') {
                        strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                    }
                    String[] strArrSplit = f11257.split(strSubstring);
                    int[] iArr = new int[strArrSplit.length];
                    for (int i = 0; i < strArrSplit.length; i++) {
                        try {
                            iArr[i] = Integer.parseInt(strArrSplit[i]);
                        } catch (NumberFormatException unused) {
                            Log.w(f11256, "Skipping array of integers hint " + decodeHintType + " due to invalid numeric value");
                            iArr = null;
                        }
                    }
                    if (iArr != null) {
                        enumMap.put((EnumMap) decodeHintType, (DecodeHintType) iArr);
                    }
                } else {
                    Log.w(f11256, "Unsupported hint type '" + decodeHintType + "' of type " + decodeHintType.getValueType());
                }
            }
        }
        return enumMap;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static Map<String, String> m10788(String str) {
        String strDecode;
        HashMap map = new HashMap();
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                break;
            }
            if (str.charAt(i) == '&') {
                i++;
            } else {
                int iIndexOf = str.indexOf(38, i);
                int iIndexOf2 = str.indexOf(61, i);
                String strDecode2 = "";
                if (iIndexOf < 0) {
                    if (iIndexOf2 < 0) {
                        strDecode = Uri.decode(str.substring(i).replace(PhoneNumberUtil.PLUS_SIGN, ' '));
                    } else {
                        String strDecode3 = Uri.decode(str.substring(i, iIndexOf2).replace(PhoneNumberUtil.PLUS_SIGN, ' '));
                        strDecode2 = Uri.decode(str.substring(iIndexOf2 + 1).replace(PhoneNumberUtil.PLUS_SIGN, ' '));
                        strDecode = strDecode3;
                    }
                    if (!map.containsKey(strDecode)) {
                        map.put(strDecode, strDecode2);
                    }
                } else {
                    if (iIndexOf2 < 0 || iIndexOf2 > iIndexOf) {
                        String strDecode4 = Uri.decode(str.substring(i, iIndexOf).replace(PhoneNumberUtil.PLUS_SIGN, ' '));
                        if (!map.containsKey(strDecode4)) {
                            map.put(strDecode4, "");
                        }
                    } else {
                        String strDecode5 = Uri.decode(str.substring(i, iIndexOf2).replace(PhoneNumberUtil.PLUS_SIGN, ' '));
                        String strDecode6 = Uri.decode(str.substring(iIndexOf2 + 1, iIndexOf).replace(PhoneNumberUtil.PLUS_SIGN, ' '));
                        if (!map.containsKey(strDecode5)) {
                            map.put(strDecode5, strDecode6);
                        }
                    }
                    i = iIndexOf + 1;
                }
            }
        }
        return map;
    }
}
