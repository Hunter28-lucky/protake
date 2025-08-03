package com.blink.academy.film.http.okhttp.model;

import android.os.Build;
import android.text.TextUtils;
import com.blink.academy.film.FilmApp;
import com.umeng.umcrash.BuildConfig;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.C4638;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class HttpHeaders implements Serializable {
    public static final String FORMAT_HTTP_DATA = "EEE, dd MMM y HH:mm:ss 'GMT'";
    public static final TimeZone GMT_TIME_ZONE = TimeZone.getTimeZone("GMT");
    public static final String HEAD_KEY_ACCEPT = "Accept";
    public static final String HEAD_KEY_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEAD_KEY_ACCEPT_LANGUAGE = "Accept-Language";
    public static final String HEAD_KEY_CACHE_CONTROL = "Cache-Control";
    public static final String HEAD_KEY_CONNECTION = "Connection";
    public static final String HEAD_KEY_CONTENT_DISPOSITION = "Content-Disposition";
    public static final String HEAD_KEY_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEAD_KEY_CONTENT_LENGTH = "Content-Length";
    public static final String HEAD_KEY_CONTENT_RANGE = "Content-Range";
    public static final String HEAD_KEY_CONTENT_TYPE = "Content-Type";
    public static final String HEAD_KEY_COOKIE = "Cookie";
    public static final String HEAD_KEY_COOKIE2 = "Cookie2";
    public static final String HEAD_KEY_DATE = "Date";
    public static final String HEAD_KEY_EXPIRES = "Expires";
    public static final String HEAD_KEY_E_TAG = "ETag";
    public static final String HEAD_KEY_IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String HEAD_KEY_IF_NONE_MATCH = "If-None-Match";
    public static final String HEAD_KEY_LAST_MODIFIED = "Last-Modified";
    public static final String HEAD_KEY_LOCATION = "Location";
    public static final String HEAD_KEY_PRAGMA = "Pragma";
    public static final String HEAD_KEY_RESPONSE_CODE = "ResponseCode";
    public static final String HEAD_KEY_RESPONSE_MESSAGE = "ResponseMessage";
    public static final String HEAD_KEY_SET_COOKIE = "Set-Cookie";
    public static final String HEAD_KEY_SET_COOKIE2 = "Set-Cookie2";
    public static final String HEAD_KEY_USER_AGENT = "User-Agent";
    public static final String HEAD_VALUE_ACCEPT_ENCODING = "gzip, deflate";
    public static final String HEAD_VALUE_CONNECTION_CLOSE = "close";
    public static final String HEAD_VALUE_CONNECTION_KEEP_ALIVE = "keep-alive";
    private static String acceptLanguage;
    private static String userAgent;
    public LinkedHashMap<String, String> headersMap;

    public HttpHeaders() {
        init();
    }

    public static String formatMillisToGMT(long j) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_HTTP_DATA, Locale.US);
        simpleDateFormat.setTimeZone(GMT_TIME_ZONE);
        return simpleDateFormat.format(date);
    }

    public static String getAcceptLanguage() {
        if (!TextUtils.isEmpty(acceptLanguage)) {
            return acceptLanguage;
        }
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        StringBuilder sb = new StringBuilder(language);
        if (!TextUtils.isEmpty(country)) {
            sb.append('-');
            sb.append(country);
            sb.append(',');
            sb.append(language);
            sb.append(";q=0.8");
        }
        String string = sb.toString();
        acceptLanguage = string;
        return string;
    }

    public static String getCacheControl(String str, String str2) {
        if (str != null) {
            return str;
        }
        if (str2 != null) {
            return str2;
        }
        return null;
    }

    public static long getDate(String str) {
        try {
            return parseGMTToMillis(str);
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static long getExpiration(String str) {
        try {
            return parseGMTToMillis(str);
        } catch (ParseException unused) {
            return -1L;
        }
    }

    public static long getLastModified(String str) {
        try {
            return parseGMTToMillis(str);
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static String getUserAgent() {
        if (!TextUtils.isEmpty(userAgent)) {
            return userAgent;
        }
        String string = null;
        try {
            string = FilmApp.m402().getString(((Integer) Class.forName("com.android.internal.R$string").getDeclaredField("web_user_agent").get(null)).intValue());
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(string)) {
            string = "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/5.0 %sSafari/533.1";
        }
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str = Build.VERSION.RELEASE;
        if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append(BuildConfig.VERSION_NAME);
        }
        stringBuffer.append("; ");
        String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language.toLowerCase(locale));
            String country = locale.getCountry();
            if (!TextUtils.isEmpty(country)) {
                stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                stringBuffer.append(country.toLowerCase(locale));
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str2 = Build.MODEL;
            if (str2.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str2);
            }
        }
        String str3 = Build.ID;
        if (str3.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str3);
        }
        String str4 = String.format(string, stringBuffer, "Mobile ");
        userAgent = str4;
        return str4;
    }

    private void init() {
        this.headersMap = new LinkedHashMap<>();
    }

    public static long parseGMTToMillis(String str) throws ParseException {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_HTTP_DATA, Locale.US);
        simpleDateFormat.setTimeZone(GMT_TIME_ZONE);
        return simpleDateFormat.parse(str).getTime();
    }

    public static void setAcceptLanguage(String str) {
        acceptLanguage = str;
    }

    public static void setUserAgent(String str) {
        userAgent = str;
    }

    public void clear() {
        this.headersMap.clear();
    }

    public String get(String str) {
        return this.headersMap.get(str);
    }

    public Set<String> getNames() {
        return this.headersMap.keySet();
    }

    public boolean isEmpty() {
        return this.headersMap.isEmpty();
    }

    public void put(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.headersMap.remove(str);
        this.headersMap.put(str, str2);
    }

    public String remove(String str) {
        return this.headersMap.remove(str);
    }

    public final String toJSONString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.headersMap.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e2) {
            C4638.m14100(e2);
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "HttpHeaders{headersMap=" + this.headersMap + '}';
    }

    public static String getDate(long j) {
        return formatMillisToGMT(j);
    }

    public HttpHeaders(String str, String str2) {
        init();
        put(str, str2);
    }

    public void put(HttpHeaders httpHeaders) {
        LinkedHashMap<String, String> linkedHashMap;
        if (httpHeaders == null || (linkedHashMap = httpHeaders.headersMap) == null || linkedHashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : httpHeaders.headersMap.entrySet()) {
            this.headersMap.remove(entry.getKey());
            this.headersMap.put(entry.getKey(), entry.getValue());
        }
    }
}
