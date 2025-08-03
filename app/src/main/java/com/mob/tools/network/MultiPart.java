package com.mob.tools.network;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class MultiPart extends HTTPPart {
    private ArrayList<HTTPPart> a = new ArrayList<>();

    @Override // com.mob.tools.network.HTTPPart
    public InputStream a() throws Throwable {
        MultiPartInputStream multiPartInputStream = new MultiPartInputStream();
        Iterator<HTTPPart> it = this.a.iterator();
        while (it.hasNext()) {
            multiPartInputStream.addInputStream(it.next().a());
        }
        return multiPartInputStream;
    }

    public MultiPart append(HTTPPart hTTPPart) throws Throwable {
        this.a.add(hTTPPart);
        return this;
    }

    @Override // com.mob.tools.network.HTTPPart
    public long b() throws Throwable {
        Iterator<HTTPPart> it = this.a.iterator();
        long jB = 0;
        while (it.hasNext()) {
            jB += it.next().b();
        }
        return jB;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<HTTPPart> it = this.a.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
        }
        return sb.toString();
    }
}
