package cn.smssdk.utils;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Constants.java */
/* loaded from: classes.dex */
public class a {
    public static String a = "http://init.sms.mob.com/v3/sdk/init";
    public static Boolean b;
    public static Boolean c;
    public static Boolean d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f17624e;

    static {
        Boolean bool = Boolean.FALSE;
        b = bool;
        c = bool;
        d = Boolean.TRUE;
        int i = 0;
        for (String str : "3.7.8".split("\\.")) {
            i = (i * 100) + Integer.parseInt(str);
        }
        f17624e = i;
    }

    public static HashMap<Character, ArrayList<String[]>> a() {
        HashMap<Character, ArrayList<String[]>> map = new HashMap<>();
        ArrayList<String[]> arrayList = new ArrayList<>();
        arrayList.add(new String[]{"中国", "86", "42", "46006|46007|46005|46002|46003|46000|46001"});
        map.put('Z', arrayList);
        return map;
    }
}
