package org.dom4j.dtd;

/* loaded from: classes2.dex */
public class ExternalEntityDecl implements Decl {
    private String name;
    private String publicID;
    private String systemID;

    public ExternalEntityDecl(String str, String str2, String str3) {
        this.name = str;
        this.publicID = str2;
        this.systemID = str3;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("<!ENTITY ");
        if (this.name.startsWith("%")) {
            stringBuffer.append("% ");
            stringBuffer.append(this.name.substring(1));
        } else {
            stringBuffer.append(this.name);
        }
        if (this.publicID != null) {
            stringBuffer.append(" PUBLIC \"");
            stringBuffer.append(this.publicID);
            stringBuffer.append("\" ");
            if (this.systemID != null) {
                stringBuffer.append("\"");
                stringBuffer.append(this.systemID);
                stringBuffer.append("\" ");
            }
        } else if (this.systemID != null) {
            stringBuffer.append(" SYSTEM \"");
            stringBuffer.append(this.systemID);
            stringBuffer.append("\" ");
        }
        stringBuffer.append(">");
        return stringBuffer.toString();
    }
}
