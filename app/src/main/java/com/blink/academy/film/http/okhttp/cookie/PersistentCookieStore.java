package com.blink.academy.film.http.okhttp.cookie;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.C2632;
import defpackage.C3573;
import defpackage.C4638;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class PersistentCookieStore {
    private static final String COOKIE_PREFS = "Cookies_Prefs";
    private final SharedPreferences cookiePrefs;
    private final Map<String, ConcurrentHashMap<String, C2632>> cookies;

    public PersistentCookieStore(Context context) {
        C2632 c2632DecodeCookie;
        SharedPreferences sharedPreferences = context.getSharedPreferences(COOKIE_PREFS, 0);
        this.cookiePrefs = sharedPreferences;
        this.cookies = new HashMap();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            for (String str : TextUtils.split((String) entry.getValue(), Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                String string = this.cookiePrefs.getString(str, null);
                if (string != null && (c2632DecodeCookie = decodeCookie(string)) != null) {
                    if (!this.cookies.containsKey(entry.getKey())) {
                        this.cookies.put(entry.getKey(), new ConcurrentHashMap<>());
                    }
                    this.cookies.get(entry.getKey()).put(str, c2632DecodeCookie);
                }
            }
        }
    }

    public void add(C3573 c3573, C2632 c2632) {
        String cookieToken = getCookieToken(c2632);
        if (!this.cookies.containsKey(c3573.m11532())) {
            this.cookies.put(c3573.m11532(), new ConcurrentHashMap<>());
        }
        if (this.cookies.containsKey(c3573.m11532())) {
            this.cookies.get(c3573.m11532()).remove(cookieToken);
        }
        this.cookies.get(c3573.m11532()).put(cookieToken, c2632);
        if (c2632.m9698()) {
            SharedPreferences.Editor editorEdit = this.cookiePrefs.edit();
            editorEdit.putString(c3573.m11532(), TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, this.cookies.get(c3573.m11532()).keySet()));
            editorEdit.putString(cookieToken, encodeCookie(new SerializableOkHttpCookies(c2632)));
            editorEdit.apply();
            return;
        }
        SharedPreferences.Editor editorEdit2 = this.cookiePrefs.edit();
        editorEdit2.remove(c3573.m11532());
        editorEdit2.remove(cookieToken);
        editorEdit2.apply();
    }

    public void addCookies(List<C2632> list) {
        for (C2632 c2632 : list) {
            String strM9692 = c2632.m9692();
            if (this.cookies.get(strM9692) == null) {
                this.cookies.put(strM9692, new ConcurrentHashMap<>());
            }
            list.add(c2632);
        }
    }

    public String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & ExifInterface.MARKER;
            if (i < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString().toUpperCase(Locale.US);
    }

    public C2632 decodeCookie(String str) {
        try {
            return ((SerializableOkHttpCookies) new ObjectInputStream(new ByteArrayInputStream(hexStringToByteArray(str))).readObject()).getCookies();
        } catch (IOException e2) {
            C4638.m14098("IOException in decodeCookie" + e2.getMessage());
            return null;
        } catch (ClassNotFoundException e3) {
            C4638.m14098("ClassNotFoundException in decodeCookie" + e3.getMessage());
            return null;
        }
    }

    public String encodeCookie(SerializableOkHttpCookies serializableOkHttpCookies) throws IOException {
        if (serializableOkHttpCookies == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(serializableOkHttpCookies);
            return byteArrayToHexString(byteArrayOutputStream.toByteArray());
        } catch (IOException e2) {
            C4638.m14098("IOException in encodeCookie" + e2.getMessage());
            return null;
        }
    }

    public List<C2632> get(C3573 c3573) {
        ArrayList arrayList = new ArrayList();
        if (this.cookies.containsKey(c3573.m11532())) {
            arrayList.addAll(this.cookies.get(c3573.m11532()).values());
        }
        return arrayList;
    }

    public String getCookieToken(C2632 c2632) {
        return c2632.m9696() + "@" + c2632.m9692();
    }

    public List<C2632> getCookies() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.cookies.keySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll(this.cookies.get(it.next()).values());
        }
        return arrayList;
    }

    public byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public boolean remove(C3573 c3573, C2632 c2632) {
        String cookieToken = getCookieToken(c2632);
        if (!this.cookies.containsKey(c3573.m11532()) || !this.cookies.get(c3573.m11532()).containsKey(cookieToken)) {
            return false;
        }
        this.cookies.get(c3573.m11532()).remove(cookieToken);
        SharedPreferences.Editor editorEdit = this.cookiePrefs.edit();
        if (this.cookiePrefs.contains(cookieToken)) {
            editorEdit.remove(cookieToken);
        }
        editorEdit.putString(c3573.m11532(), TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, this.cookies.get(c3573.m11532()).keySet()));
        editorEdit.apply();
        return true;
    }

    public boolean removeAll() {
        SharedPreferences.Editor editorEdit = this.cookiePrefs.edit();
        editorEdit.clear();
        editorEdit.apply();
        this.cookies.clear();
        return true;
    }
}
