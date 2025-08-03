package com.blink.academy.film.http.okhttp.utils;

import android.util.Base64;
import defpackage.C4494;
import defpackage.C4638;
import defpackage.r1;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.jcodec.platform.Platform;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class HttpUtil {
    public static final String KEY = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEA8Z0H6puWeC2wTvW0j4dg\nWplYlwOfX6KVK63Wvfky7Tkja0R101GbhUezA/TtOcdna+EKcSFCvx/0Y05Ku7Ti\njqzQDng+kNcxBJZM9MaAVJnqq2BM3q1hJKIyM6ysGuGB7f6aFAxeSEw6PbPY0I6c\naxNTsB5Qv5+ROywjRq5Wxj5105mxBx8kjeIOlLMfCnOjd74k4GnUNxTiyYkcuSQx\nKFkFaza0CXMdFzR59rc2ShTOxmq2CFQ7H54uLK1eHZ5DEKLjV255Wjb8l3vnfzUh\nlZyutz8uLU3L6N2hCiBzzOaGcs1cLgDMBCgPwkVM6oRs8kov0Z+lA32wGGTSED2a\nSUvofJ+UIFe/Wzk43KwZASJBuDgHCRN0Wc3P6pL2v5xfxY5rIOOaPHx1wMUqn534\nUKiCcIqSh0s8sO2CkMeBtpFMaSiIfhFhQopEFaZvgXfCWuthtpXtF6hfO4pEACiN\nvZr6x0Xv5ww6JhbNWjDuM95JDV8GMAJ2S/jbnFkAn8PVzLwcb7lgoUvnrQmOtho/\nTTFCJPKR/O56Hds7VUvrx8JWFpxAFsP24UhnTq3qbhHfic6oKpFtbqOvPV+fIzNp\nWJMBVuijQBrJRvjCTowe1ZGrdnAGEsHNBj9L+rkrYoypcSHWMb3g5zadCuKXyI1W\n5aSSbWI/ObehNMQtN0F/DRkCAwEAAQ==";
    public static final String RSA = "RSA";
    public static final int SOURCE_ALI_GEN_ORDER = 8;
    public static final int SOURCE_APP_ALERT = 14;
    public static final int SOURCE_DOWNLOAD_TOKEN = 6;
    public static final int SOURCE_GEN_WECHAT_ORDER = 13;
    public static final int SOURCE_IGNORE = 12;
    public static final int SOURCE_LOGIN = 2;
    public static final int SOURCE_MODULE_LIST = 10;
    public static final int SOURCE_NVT_INFO = 17;
    public static final int SOURCE_NVT_PRODUCT_LIST = 18;
    public static final int SOURCE_RECEIVE_REWARD = 19;
    public static final int SOURCE_SRT_CREATE = 16;
    public static final int SOURCE_SRT_ROOM_ID = 15;
    public static final int SOURCE_STATUS_TYPE = 7;
    public static final int SOURCE_STORE = 1;
    public static final int SOURCE_STRING = 11;
    public static final int SOURCE_SUBS = 3;
    public static final int SOURCE_USER_INFO = 5;
    public static final int SOURCE_VERIFY_PHONE = 4;
    public static final String TRANSFORMATION = "RSA/None/PKCS1Padding";
    public static final Charset UTF8 = Charset.forName(Platform.UTF_8);
    public static List<String> uInfoClientNonceList = new ArrayList();
    public static List<String> filterClientNonceList = new ArrayList();
    public static List<String> registerClientNonceList = new ArrayList();

    public static String createUrlFromParams(String str, Map<String, String> map) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf(38) > 0 || str.indexOf(63) > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String value = entry.getValue();
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(value);
                sb.append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        } catch (Exception e2) {
            C4638.m14100(e2.getMessage());
            return str;
        }
    }

    public static Object decodeJWT(String str, int i, String str2) throws JSONException, NoSuchAlgorithmException {
        return parseData(i, (String) new JSONObject(str).get("sign"), str2);
    }

    public static byte[] decryptByPrivateKey(byte[] bArr, byte[] bArr2) throws Exception {
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance(RSA).generatePrivate(new PKCS8EncodedKeySpec(bArr2));
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, privateKeyGeneratePrivate);
        return cipher.doFinal(bArr);
    }

    public static String[] encodeData(String str) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeyGenerateKey);
        byte[] bArrDoFinal = cipher.doFinal(str.getBytes(Charset.forName("utf-8")));
        PublicKey publicKeyM13783 = C4494.m13783(KEY);
        Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher2.init(1, publicKeyM13783);
        byte[] bArrDoFinal2 = cipher2.doFinal(secretKeyGenerateKey.getEncoded());
        String strEncodeToString = Base64.encodeToString(bArrDoFinal, 0);
        String strEncodeToString2 = Base64.encodeToString(bArrDoFinal2, 0);
        String[] strArr = {strEncodeToString, strEncodeToString2};
        C4638.m14099("encodeData", String.format("encodeString : %s , encodeKey : %s ", strEncodeToString, strEncodeToString2));
        return strArr;
    }

    public static byte[] encryptByPublicKey(byte[] bArr, byte[] bArr2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(RSA).generatePublic(new X509EncodedKeySpec(bArr2));
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, publicKeyGeneratePublic);
        return cipher.doFinal(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object getJsonStr(io.jsonwebtoken.Claims r25, int r26, java.lang.String r27) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 3230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.http.okhttp.utils.HttpUtil.getJsonStr(io.jsonwebtoken.Claims, int, java.lang.String):java.lang.Object");
    }

    private static int getLong(Object obj) {
        try {
            return Integer.parseInt(getString(obj));
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String getString(Object obj) {
        if (!r1.m8142(obj)) {
            return "";
        }
        return "" + obj;
    }

    public static Object parseData(int i, String str, String str2) {
        JwtParser allowedClockSkewSeconds = Jwts.parser().setAllowedClockSkewSeconds(Long.MAX_VALUE);
        try {
            allowedClockSkewSeconds = allowedClockSkewSeconds.setSigningKey(C4494.m13783(KEY));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return getJsonStr(allowedClockSkewSeconds.parseClaimsJws(str).getBody(), i, str2);
    }
}
