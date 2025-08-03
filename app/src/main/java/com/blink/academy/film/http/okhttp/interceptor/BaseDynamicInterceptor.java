package com.blink.academy.film.http.okhttp.interceptor;

import com.blink.academy.film.http.okhttp.interceptor.BaseDynamicInterceptor;
import com.blink.academy.film.http.okhttp.utils.HttpUtil;
import com.blink.academy.film.http.okhttp.utils.Utils;
import defpackage.C3135;
import defpackage.C3573;
import defpackage.C3577;
import defpackage.C4539;
import defpackage.C4638;
import defpackage.C4770;
import defpackage.InterfaceC2818;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: classes.dex */
public abstract class BaseDynamicInterceptor<R extends BaseDynamicInterceptor> implements InterfaceC2818 {
    private C3573 httpUrl;
    private boolean isSign = false;
    private boolean timeStamp = false;
    private boolean accessToken = false;

    private C4539 addGetParamsSign(C4539 c4539) throws UnsupportedEncodingException {
        C3573 c3573M13925 = c4539.m13925();
        C3573.C3574 c3574M11534 = c3573M13925.m11534();
        Set<String> setM11539 = c3573M13925.m11539();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(setM11539);
        TreeMap<String, String> treeMap = new TreeMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            treeMap.put((String) arrayList.get(i), (c3573M13925.m11540((String) arrayList.get(i)) == null || c3573M13925.m11540((String) arrayList.get(i)).size() <= 0) ? "" : c3573M13925.m11540((String) arrayList.get(i)).get(0));
        }
        String string = Collections.singletonList(arrayList).toString();
        TreeMap<String, String> treeMapDynamic = dynamic(treeMap);
        Utils.checkNotNull(treeMapDynamic, "newParams==null");
        for (Map.Entry<String, String> entry : treeMapDynamic.entrySet()) {
            String strEncode = URLEncoder.encode(entry.getValue(), HttpUtil.UTF8.name());
            if (!string.contains(entry.getKey())) {
                c3574M11534.m11547(entry.getKey(), strEncode);
            }
        }
        return c4539.m13924().m13934(c3574M11534.m11548()).m13927();
    }

    private C4539 addPostParamsSign(C4539 c4539) throws UnsupportedEncodingException {
        if (!(c4539.m13916() instanceof C3135)) {
            if (!(c4539.m13916() instanceof C3577)) {
                return c4539;
            }
            C3577 c3577 = (C3577) c4539.m13916();
            C3577.C3578 c3578M11597 = new C3577.C3578().m11597(C3577.f12477);
            List<C3577.C3580> listM11592 = c3577.m11592();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(listM11592);
            for (Map.Entry<String, String> entry : dynamic(new TreeMap<>()).entrySet()) {
                arrayList.add(C3577.C3580.m11599(entry.getKey(), entry.getValue()));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c3578M11597.m11595((C3577.C3580) it.next());
            }
            return c4539.m13924().m13932(c3578M11597.m11596()).m13927();
        }
        C3135.C3136 c3136 = new C3135.C3136();
        C3135 c3135 = (C3135) c4539.m13916();
        TreeMap<String, String> treeMap = new TreeMap<>();
        for (int i = 0; i < c3135.m10728(); i++) {
            treeMap.put(c3135.m10726(i), c3135.m10727(i));
        }
        TreeMap<String, String> treeMapDynamic = dynamic(treeMap);
        Utils.checkNotNull(treeMapDynamic, "newParams==null");
        for (Map.Entry<String, String> entry2 : treeMapDynamic.entrySet()) {
            c3136.m10731(entry2.getKey(), URLDecoder.decode(entry2.getValue(), HttpUtil.UTF8.name()));
        }
        C4638.m14103(HttpUtil.createUrlFromParams(this.httpUrl.m11545().toString(), treeMapDynamic));
        return c4539.m13924().m13932(c3136.m10732()).m13927();
    }

    private String parseUrl(String str) {
        return ("".equals(str) || !str.contains("?")) ? str : str.substring(0, str.indexOf(63));
    }

    public R accessToken(boolean z) {
        this.accessToken = z;
        return this;
    }

    public abstract TreeMap<String, String> dynamic(TreeMap<String, String> treeMap);

    public C3573 getHttpUrl() {
        return this.httpUrl;
    }

    @Override // defpackage.InterfaceC2818
    public C4770 intercept(InterfaceC2818.InterfaceC2819 interfaceC2819) throws IOException {
        C4539 c4539Request = interfaceC2819.request();
        if (c4539Request.m13923().equals("GET")) {
            this.httpUrl = C3573.m11525(parseUrl(c4539Request.m13925().m11545().toString()));
            c4539Request = addGetParamsSign(c4539Request);
        } else if (c4539Request.m13923().equals("POST")) {
            this.httpUrl = c4539Request.m13925();
            c4539Request = addPostParamsSign(c4539Request);
        }
        return interfaceC2819.mo10160(c4539Request);
    }

    public boolean isAccessToken() {
        return this.accessToken;
    }

    public boolean isSign() {
        return this.isSign;
    }

    public boolean isTimeStamp() {
        return this.timeStamp;
    }

    public R sign(boolean z) {
        this.isSign = z;
        return this;
    }

    public R timeStamp(boolean z) {
        this.timeStamp = z;
        return this;
    }
}
