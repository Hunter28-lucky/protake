package com.xiaomi.push;

import android.util.Log;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class w {
    private static final HashMap<String, String> a;

    static {
        HashMap<String, String> map = new HashMap<>();
        a = map;
        map.put("FFD8FF", "jpg");
        map.put("89504E47", "png");
        map.put("47494638", "gif");
        map.put("474946", "gif");
        map.put("424D", "bmp");
    }

    public static long a(File file) {
        long jA = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            for (int i = 0; i < fileArrListFiles.length; i++) {
                jA += fileArrListFiles[i].isDirectory() ? a(fileArrListFiles[i]) : fileArrListFiles[i].length();
            }
        } catch (Exception e2) {
            Log.e("FileUtils", "Get folder size error: " + e2.getMessage());
        }
        return jA;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m5830a(File file) {
        long length;
        if (file == null) {
            return false;
        }
        try {
            if (!file.exists()) {
                return true;
            }
            if (file.isDirectory()) {
                length = a(file);
            } else {
                length = file.length();
            }
            return length < 104857600;
        } catch (Exception e2) {
            Log.e("FileUtils", "Check if internal file can be written error :" + e2.getMessage());
            return false;
        }
    }
}
