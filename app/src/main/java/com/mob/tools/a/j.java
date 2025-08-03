package com.mob.tools.a;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/* loaded from: classes2.dex */
public interface j {
    PackageInfo a(String str, int i) throws PackageManager.NameNotFoundException;

    String a(String str);

    String a(String str, String str2);

    Enumeration<NetworkInterface> a();

    Enumeration<InetAddress> a(NetworkInterface networkInterface);

    List<ResolveInfo> a(Intent intent, int i);

    int b();

    ApplicationInfo b(String str, int i) throws PackageManager.NameNotFoundException;

    ResolveInfo b(Intent intent, int i);

    int c();

    ApplicationInfo d();
}
