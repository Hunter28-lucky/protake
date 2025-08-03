package cn.smssdk.logger;

import cn.smssdk.utils.DHelper;
import cn.smssdk.utils.e;
import com.mob.tools.utils.DH;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseInformation.java */
/* loaded from: classes.dex */
public class a {
    private static a c;
    private String a;
    private List<String> b;

    private a() {
    }

    public static a m() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    public String a() {
        return DHelper.getDeviceId();
    }

    public String b() {
        return DH.SyncMtd.getModel();
    }

    public String c() {
        return DH.SyncMtd.getBrand();
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return DHelper.getSignMd5();
    }

    public String f() {
        return DHelper.getNetworkType();
    }

    public List<String> g() {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        return this.b;
    }

    public int h() {
        return DH.SyncMtd.getOSVersionInt();
    }

    public String i() {
        return DH.SyncMtd.getPackageName();
    }

    public String j() {
        return DH.SyncMtd.getOSVersionName();
    }

    public String k() {
        return "3.7.8";
    }

    public String l() {
        return e.a();
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(List<String> list) {
        this.b = list;
    }
}
