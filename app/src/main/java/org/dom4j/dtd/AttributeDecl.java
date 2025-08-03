package org.dom4j.dtd;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;

/* loaded from: classes2.dex */
public class AttributeDecl implements Decl {
    private String attributeName;
    private String elementName;
    private String type;
    private String value;
    private String valueDefault;

    public AttributeDecl(String str, String str2, String str3, String str4, String str5) {
        this.elementName = str;
        this.attributeName = str2;
        this.type = str3;
        this.value = str5;
        this.valueDefault = str4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("<!ATTLIST ");
        stringBuffer.append(this.elementName);
        stringBuffer.append(MyUTIL.white_space);
        stringBuffer.append(this.attributeName);
        stringBuffer.append(MyUTIL.white_space);
        stringBuffer.append(this.type);
        stringBuffer.append(MyUTIL.white_space);
        String str = this.valueDefault;
        if (str != null) {
            stringBuffer.append(str);
            if (this.valueDefault.equals("#FIXED")) {
                stringBuffer.append(" \"");
                stringBuffer.append(this.value);
                stringBuffer.append("\"");
            }
        } else {
            stringBuffer.append("\"");
            stringBuffer.append(this.value);
            stringBuffer.append("\"");
        }
        stringBuffer.append(">");
        return stringBuffer.toString();
    }
}
