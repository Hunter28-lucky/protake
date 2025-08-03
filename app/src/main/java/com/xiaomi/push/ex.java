package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public class ex {
    private XmlPullParser a;

    public ex() throws XmlPullParserException {
        try {
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.a = xmlPullParserNewPullParser;
            xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    public fp a(byte[] bArr, fb fbVar) throws XmlPullParserException, IOException, fj {
        this.a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.a.next();
        int eventType = this.a.getEventType();
        String name = this.a.getName();
        if (eventType != 2) {
            return null;
        }
        if (name.equals("message")) {
            return fx.a(this.a);
        }
        if (name.equals("iq")) {
            return fx.a(this.a, fbVar);
        }
        if (name.equals("presence")) {
            return fx.m5505a(this.a);
        }
        if (this.a.getName().equals("stream")) {
            return null;
        }
        if (this.a.getName().equals(com.umeng.analytics.pro.d.O)) {
            throw new fj(fx.m5506a(this.a));
        }
        if (!this.a.getName().equals("warning")) {
            this.a.getName().equals("bind");
            return null;
        }
        this.a.next();
        this.a.getName().equals("multi-login");
        return null;
    }
}
