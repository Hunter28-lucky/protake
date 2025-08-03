package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class fm implements fq {
    private String a;

    /* renamed from: a, reason: collision with other field name */
    private List<fm> f5927a;

    /* renamed from: a, reason: collision with other field name */
    private String[] f5928a;
    private String b;

    /* renamed from: b, reason: collision with other field name */
    private String[] f5929b;
    private String c;

    public fm(String str, String str2, String[] strArr, String[] strArr2) {
        this.f5927a = null;
        this.a = str;
        this.b = str2;
        this.f5928a = strArr;
        this.f5929b = strArr2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5493a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.c) ? fy.b(this.c) : this.c;
    }

    @Override // com.xiaomi.push.fq
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.a);
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(MyUTIL.white_space);
            sb.append("xmlns=");
            sb.append("\"");
            sb.append(this.b);
            sb.append("\"");
        }
        String[] strArr = this.f5928a;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < this.f5928a.length; i++) {
                if (!TextUtils.isEmpty(this.f5929b[i])) {
                    sb.append(MyUTIL.white_space);
                    sb.append(this.f5928a[i]);
                    sb.append("=\"");
                    sb.append(fy.a(this.f5929b[i]));
                    sb.append("\"");
                }
            }
        }
        if (TextUtils.isEmpty(this.c)) {
            List<fm> list = this.f5927a;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
            } else {
                sb.append(">");
                Iterator<fm> it = this.f5927a.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().d());
                }
                sb.append("</");
                sb.append(this.a);
                sb.append(">");
            }
        } else {
            sb.append(">");
            sb.append(this.c);
            sb.append("</");
            sb.append(this.a);
            sb.append(">");
        }
        return sb.toString();
    }

    public String toString() {
        return d();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.a);
        bundle.putString("ext_ns", this.b);
        bundle.putString("ext_text", this.c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f5928a;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.f5928a;
                if (i >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i], this.f5929b[i]);
                i++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<fm> list = this.f5927a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", a(this.f5927a));
        }
        return bundle;
    }

    public fm(String str, String str2, String[] strArr, String[] strArr2, String str3, List<fm> list) {
        this.a = str;
        this.b = str2;
        this.f5928a = strArr;
        this.f5929b = strArr2;
        this.c = str3;
        this.f5927a = list;
    }

    /* renamed from: a, reason: collision with other method in class */
    public Parcelable m5492a() {
        return a();
    }

    public static Parcelable[] a(fm[] fmVarArr) {
        if (fmVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[fmVarArr.length];
        for (int i = 0; i < fmVarArr.length; i++) {
            parcelableArr[i] = fmVarArr[i].m5492a();
        }
        return parcelableArr;
    }

    public static Parcelable[] a(List<fm> list) {
        return a((fm[]) list.toArray(new fm[list.size()]));
    }

    public static fm a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> setKeySet = bundle2.keySet();
        String[] strArr = new String[setKeySet.size()];
        String[] strArr2 = new String[setKeySet.size()];
        int i = 0;
        for (String str : setKeySet) {
            strArr[i] = str;
            strArr2[i] = bundle2.getString(str);
            i++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new fm(string, string2, strArr, strArr2, string3, arrayList);
    }

    public String a(String str) {
        if (str != null) {
            if (this.f5928a == null) {
                return null;
            }
            int i = 0;
            while (true) {
                String[] strArr = this.f5928a;
                if (i >= strArr.length) {
                    return null;
                }
                if (str.equals(strArr[i])) {
                    return this.f5929b[i];
                }
                i++;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void a(fm fmVar) {
        if (this.f5927a == null) {
            this.f5927a = new ArrayList();
        }
        if (this.f5927a.contains(fmVar)) {
            return;
        }
        this.f5927a.add(fmVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5494a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c = fy.a(str);
        } else {
            this.c = str;
        }
    }
}
