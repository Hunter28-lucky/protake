package cn.smssdk.utils;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: LogCatHelper.java */
/* loaded from: classes.dex */
public class c {
    static {
        "0123456789ABCDEF".toCharArray();
    }

    public static String a(Map map) {
        if (map == null) {
            return "";
        }
        String string = "[";
        for (Map.Entry entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(MyUTIL.white_space);
            sb.append(entry.getKey());
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(entry.getValue() == null ? "" : entry.getValue());
            string = sb.toString();
        }
        return string + " ]";
    }

    public static String b(int i) {
        return i != -1 ? i != 0 ? String.valueOf(i) : "RESULT_ERROR" : "RESULT_COMPLETE";
    }

    public static String a(List list) {
        if (list == null) {
            return "";
        }
        Iterator it = list.iterator();
        String string = "";
        while (it.hasNext()) {
            Object next = it.next();
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            if (next == null) {
                next = "";
            }
            sb.append(next);
            string = sb.toString();
            if (it.hasNext()) {
                string = string + " ,";
            }
        }
        return string;
    }

    public static String a(int i) {
        switch (i) {
            case 1:
                return "EVENT_GET_SUPPORTED_COUNTRIES";
            case 2:
                return "EVENT_GET_VERIFICATION_CODE";
            case 3:
                return "EVENT_SUBMIT_VERIFICATION_CODE";
            case 4:
                return "EVENT_GET_CONTACTS";
            case 5:
                return "EVENT_SUBMIT_USER_INFO";
            case 6:
                return "EVENT_GET_FRIENDS_IN_APP";
            case 7:
                return "EVENT_GET_NEW_FRIENDS_COUNT";
            case 8:
                return "EVENT_GET_VOICE_VERIFICATION_CODE";
            default:
                return String.valueOf(i);
        }
    }
}
