package com.efs.sdk.launch;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class c {
    private static String a = "";

    public static String a(Context context) {
        Class<UMConfigure> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = UMConfigure.class;
            UMLog uMLog = UMConfigure.umDebugLog;
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getUMIDString", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, context);
            if (objInvoke != null) {
                return objInvoke.toString();
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        if (context == null || str == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putString("first_launch_cache", str);
        editorEdit.commit();
    }

    public static String b(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) == null) {
            return null;
        }
        return sharedPreferences.getString("first_launch_cache", null);
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putString("first_launch_cache", null);
        editorEdit.commit();
    }

    public static boolean d(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        SharedPreferences sharedPreferences2;
        if ((context == null || (sharedPreferences2 = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) == null) ? false : sharedPreferences2.getBoolean("is_install", false)) {
            return false;
        }
        if (context != null && (sharedPreferences = context.getApplicationContext().getSharedPreferences("efs_launch", 0)) != null && (editorEdit = sharedPreferences.edit()) != null) {
            editorEdit.putBoolean("is_install", true);
            editorEdit.commit();
        }
        return true;
    }

    public static boolean e(Context context) {
        try {
            String currentProcessName = ProcessUtil.getCurrentProcessName();
            String packageName = context.getApplicationContext().getPackageName();
            if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName)) {
                return false;
            }
            return currentProcessName.equals(packageName);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
