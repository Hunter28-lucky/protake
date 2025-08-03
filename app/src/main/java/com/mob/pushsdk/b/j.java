package com.mob.pushsdk.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class j {
    public static List<String> a(String str, String str2) {
        List<String> listAsList = Arrays.asList(str.split(str2));
        return listAsList == null ? new ArrayList() : listAsList;
    }

    public static String[] b(String str, String str2) {
        return str.split(str2);
    }

    public static String a(List<String> list, String str) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        int i = 0;
        int size = list.size();
        String string = "";
        while (i < size) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(list.get(i));
            i++;
            sb.append(i == size ? "" : str);
            string = sb.toString();
        }
        return string;
    }

    public static String a(String[] strArr, String str) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        int i = 0;
        int length = strArr.length;
        String string = "";
        while (i < length) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(strArr[i]);
            i++;
            sb.append(i == length ? "" : str);
            string = sb.toString();
        }
        return string;
    }
}
