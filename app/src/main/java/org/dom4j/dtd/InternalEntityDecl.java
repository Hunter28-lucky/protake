package org.dom4j.dtd;

/* loaded from: classes2.dex */
public class InternalEntityDecl implements Decl {
    private String name;
    private String value;

    public InternalEntityDecl(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    private String escapeEntityValue(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                stringBuffer.append("&#34;");
            } else if (cCharAt == '<') {
                stringBuffer.append("&#38;#60;");
            } else if (cCharAt == '>') {
                stringBuffer.append("&#62;");
            } else if (cCharAt == '&') {
                stringBuffer.append("&#38;#38;");
            } else if (cCharAt == '\'') {
                stringBuffer.append("&#39;");
            } else if (cCharAt < ' ') {
                stringBuffer.append("&#" + ((int) cCharAt) + ";");
            } else {
                stringBuffer.append(cCharAt);
            }
        }
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("<!ENTITY ");
        if (this.name.startsWith("%")) {
            stringBuffer.append("% ");
            stringBuffer.append(this.name.substring(1));
        } else {
            stringBuffer.append(this.name);
        }
        stringBuffer.append(" \"");
        stringBuffer.append(escapeEntityValue(this.value));
        stringBuffer.append("\">");
        return stringBuffer.toString();
    }
}
