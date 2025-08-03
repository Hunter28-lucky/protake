package com.xiaomi.push;

import android.os.Bundle;

/* loaded from: classes2.dex */
public class fr extends fp {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private a f5939a;

    /* renamed from: a, reason: collision with other field name */
    private b f5940a;
    private String b;

    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public fr(b bVar) {
        this.f5940a = b.available;
        this.b = null;
        this.a = Integer.MIN_VALUE;
        this.f5939a = null;
        a(bVar);
    }

    @Override // com.xiaomi.push.fp
    public Bundle a() {
        Bundle bundleA = super.a();
        b bVar = this.f5940a;
        if (bVar != null) {
            bundleA.putString("ext_pres_type", bVar.toString());
        }
        String str = this.b;
        if (str != null) {
            bundleA.putString("ext_pres_status", str);
        }
        int i = this.a;
        if (i != Integer.MIN_VALUE) {
            bundleA.putInt("ext_pres_prio", i);
        }
        a aVar = this.f5939a;
        if (aVar != null && aVar != a.available) {
            bundleA.putString("ext_pres_mode", aVar.toString());
        }
        return bundleA;
    }

    public fr(Bundle bundle) {
        super(bundle);
        this.f5940a = b.available;
        this.b = null;
        this.a = Integer.MIN_VALUE;
        this.f5939a = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.f5940a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f5939a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.f5940a = bVar;
            return;
        }
        throw new NullPointerException("Type cannot be null");
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(int i) {
        if (i >= -128 && i <= 128) {
            this.a = i;
            return;
        }
        throw new IllegalArgumentException("Priority value " + i + " is not valid. Valid range is -128 through 128.");
    }

    public void a(a aVar) {
        this.f5939a = aVar;
    }

    @Override // com.xiaomi.push.fp
    /* renamed from: a */
    public String mo5496a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"");
            sb.append(j());
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"");
            sb.append(fy.a(l()));
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"");
            sb.append(fy.a(m()));
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"");
            sb.append(fy.a(k()));
            sb.append("\"");
        }
        if (this.f5940a != null) {
            sb.append(" type=\"");
            sb.append(this.f5940a);
            sb.append("\"");
        }
        sb.append(">");
        if (this.b != null) {
            sb.append("<status>");
            sb.append(fy.a(this.b));
            sb.append("</status>");
        }
        if (this.a != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.a);
            sb.append("</priority>");
        }
        a aVar = this.f5939a;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>");
            sb.append(this.f5939a);
            sb.append("</show>");
        }
        sb.append(o());
        ft ftVarM5497a = m5497a();
        if (ftVarM5497a != null) {
            sb.append(ftVarM5497a.m5500a());
        }
        sb.append("</presence>");
        return sb.toString();
    }
}
