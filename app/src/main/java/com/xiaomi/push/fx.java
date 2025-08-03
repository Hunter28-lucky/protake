package com.xiaomi.push;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.blink.academy.film.stream.FinderManager;
import com.xiaomi.push.fn;
import com.xiaomi.push.fr;
import com.xiaomi.push.ft;
import com.xiaomi.push.service.am;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public class fx {
    private static XmlPullParser a;

    public static fp a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, fj {
        String attributeValue;
        boolean z = false;
        String strNextText = null;
        if ("1".equals(xmlPullParser.getAttributeValue("", com.umeng.analytics.pro.am.aB))) {
            String attributeValue2 = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue4 = xmlPullParser.getAttributeValue("", TypedValues.TransitionType.S_FROM);
            String attributeValue5 = xmlPullParser.getAttributeValue("", TypedValues.TransitionType.S_TO);
            String attributeValue6 = xmlPullParser.getAttributeValue("", "type");
            am.b bVarA = com.xiaomi.push.service.am.a().a(attributeValue2, attributeValue5);
            if (bVarA == null) {
                bVarA = com.xiaomi.push.service.am.a().a(attributeValue2, attributeValue4);
            }
            if (bVarA == null) {
                throw new fj("the channel id is wrong while receiving a encrypted message");
            }
            fp fpVarA = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!com.umeng.analytics.pro.am.aB.equals(xmlPullParser.getName())) {
                        throw new fj("error while receiving a encrypted message with wrong format");
                    }
                    if (xmlPullParser.next() != 4) {
                        throw new fj("error while receiving a encrypted message with wrong format");
                    }
                    String text = xmlPullParser.getText();
                    if ("5".equals(attributeValue2) || "6".equals(attributeValue2)) {
                        fo foVar = new fo();
                        foVar.l(attributeValue2);
                        foVar.b(true);
                        foVar.n(attributeValue4);
                        foVar.m(attributeValue5);
                        foVar.k(attributeValue3);
                        foVar.f(attributeValue6);
                        fm fmVar = new fm(com.umeng.analytics.pro.am.aB, null, null, null);
                        fmVar.m5494a(text);
                        foVar.a(fmVar);
                        return foVar;
                    }
                    a(com.xiaomi.push.service.ar.a(com.xiaomi.push.service.ar.a(bVarA.h, attributeValue3), text));
                    a.next();
                    fpVarA = a(a);
                } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                    z = true;
                }
            }
            if (fpVarA != null) {
                return fpVarA;
            }
            throw new fj("error while receiving a encrypted message with wrong format");
        }
        fo foVar2 = new fo();
        String attributeValue7 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue7 == null) {
            attributeValue7 = "ID_NOT_AVAILABLE";
        }
        foVar2.k(attributeValue7);
        foVar2.m(xmlPullParser.getAttributeValue("", TypedValues.TransitionType.S_TO));
        foVar2.n(xmlPullParser.getAttributeValue("", TypedValues.TransitionType.S_FROM));
        foVar2.l(xmlPullParser.getAttributeValue("", "chid"));
        foVar2.a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            attributeValue = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused) {
            attributeValue = null;
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                foVar2.b(attributeValue8);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                foVar2.c(attributeValue9);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue10)) {
                foVar2.d(attributeValue10);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue11 = xmlPullParser.getAttributeValue("", NotificationCompat.CATEGORY_STATUS);
            if (!TextUtils.isEmpty(attributeValue11)) {
                foVar2.e(attributeValue11);
            }
        } catch (Exception unused5) {
        }
        foVar2.a(!TextUtils.isEmpty(attributeValue) && attributeValue.equalsIgnoreCase("true"));
        foVar2.f(xmlPullParser.getAttributeValue("", "type"));
        String strB = b(xmlPullParser);
        if (strB == null || "".equals(strB.trim())) {
            fp.q();
        } else {
            foVar2.j(strB);
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    b(xmlPullParser);
                    foVar2.g(m5508a(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue12 = xmlPullParser.getAttributeValue("", "encode");
                    String strM5508a = m5508a(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue12)) {
                        foVar2.h(strM5508a);
                    } else {
                        foVar2.a(strM5508a, attributeValue12);
                    }
                } else if (name.equals("thread")) {
                    if (strNextText == null) {
                        strNextText = xmlPullParser.nextText();
                    }
                } else if (name.equals(com.umeng.analytics.pro.d.O)) {
                    foVar2.a(m5507a(xmlPullParser));
                } else {
                    foVar2.a(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        foVar2.i(strNextText);
        return foVar2;
    }

    private static String b(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    private static void a(byte[] bArr) throws XmlPullParserException {
        if (a == null) {
            try {
                XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
                a = xmlPullParserNewPullParser;
                xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            }
        }
        a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    /* renamed from: a, reason: collision with other method in class */
    private static String m5508a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static fr m5505a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        fr.b bVarValueOf = fr.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVarValueOf = fr.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        fr frVar = new fr(bVarValueOf);
        frVar.m(xmlPullParser.getAttributeValue("", TypedValues.TransitionType.S_TO));
        frVar.n(xmlPullParser.getAttributeValue("", TypedValues.TransitionType.S_FROM));
        frVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        frVar.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(NotificationCompat.CATEGORY_STATUS)) {
                    frVar.a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        frVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        frVar.a(0);
                    }
                } else if (name.equals("show")) {
                    String strNextText = xmlPullParser.nextText();
                    try {
                        frVar.a(fr.a.valueOf(strNextText));
                    } catch (IllegalArgumentException unused4) {
                        System.err.println("Found invalid presence mode " + strNextText);
                    }
                } else if (name.equals(com.umeng.analytics.pro.d.O)) {
                    frVar.a(m5507a(xmlPullParser));
                } else {
                    frVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return frVar;
    }

    public static fn a(XmlPullParser xmlPullParser, fb fbVar) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", TypedValues.TransitionType.S_TO);
        String attributeValue3 = xmlPullParser.getAttributeValue("", TypedValues.TransitionType.S_FROM);
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        fn.a aVarA = fn.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap map = new HashMap();
        boolean z = false;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            map.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        fn fnVar = null;
        ft ftVarM5507a = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(com.umeng.analytics.pro.d.O)) {
                    ftVarM5507a = m5507a(xmlPullParser);
                } else {
                    fnVar = new fn();
                    fnVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (fnVar == null) {
            if (fn.a.a != aVarA && fn.a.b != aVarA) {
                fnVar = new fn() { // from class: com.xiaomi.push.fx.2
                    @Override // com.xiaomi.push.fn
                    public String b() {
                        return null;
                    }
                };
            } else {
                fn fnVar2 = new fn() { // from class: com.xiaomi.push.fx.1
                    @Override // com.xiaomi.push.fn
                    public String b() {
                        return null;
                    }
                };
                fnVar2.k(attributeValue);
                fnVar2.m(attributeValue3);
                fnVar2.n(attributeValue2);
                fnVar2.a(fn.a.d);
                fnVar2.l(attributeValue4);
                fnVar2.a(new ft(ft.a.f17868e));
                fbVar.a(fnVar2);
                com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
                return null;
            }
        }
        fnVar.k(attributeValue);
        fnVar.m(attributeValue2);
        fnVar.l(attributeValue4);
        fnVar.n(attributeValue3);
        fnVar.a(aVarA);
        fnVar.a(ftVarM5507a);
        fnVar.a(map);
        return fnVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static fs m5506a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        fs fsVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                fsVar = new fs(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals(com.umeng.analytics.pro.d.O)) {
                z = true;
            }
        }
        return fsVar;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static ft m5507a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        String attributeValue = FinderManager.MACHINE_NOT_VALID;
        String attributeValue2 = null;
        String attributeValue3 = null;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals("code")) {
                attributeValue = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i).equals("type")) {
                attributeValue3 = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i).equals("reason")) {
                attributeValue2 = xmlPullParser.getAttributeValue("", "reason");
            }
        }
        String str = null;
        String strNextText = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals(NotificationCompat.MessagingStyle.Message.KEY_TEXT)) {
                    strNextText = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals(com.umeng.analytics.pro.d.O)) {
                    z = true;
                }
            } else if (next == 4) {
                strNextText = xmlPullParser.getText();
            }
        }
        return new ft(Integer.parseInt(attributeValue), attributeValue3 == null ? "cancel" : attributeValue3, attributeValue2, str, strNextText, arrayList);
    }

    public static fm a(String str, String str2, XmlPullParser xmlPullParser) {
        Object objM5503a = fw.a().m5503a("all", "xm:chat");
        if (objM5503a == null || !(objM5503a instanceof com.xiaomi.push.service.i)) {
            return null;
        }
        return ((com.xiaomi.push.service.i) objM5503a).b(xmlPullParser);
    }
}
