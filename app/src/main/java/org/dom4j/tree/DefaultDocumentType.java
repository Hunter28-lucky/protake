package org.dom4j.tree;

import java.util.List;
import org.dom4j.dtd.Decl;

/* loaded from: classes2.dex */
public class DefaultDocumentType extends AbstractDocumentType {
    public String elementName;
    private List<Decl> externalDeclarations;
    private List<Decl> internalDeclarations;
    private String publicID;
    private String systemID;

    public DefaultDocumentType(String str, String str2, String str3) {
        this.elementName = str;
        this.publicID = str2;
        this.systemID = str3;
    }

    @Override // org.dom4j.DocumentType
    public String getElementName() {
        return this.elementName;
    }

    @Override // org.dom4j.DocumentType
    public List<Decl> getInternalDeclarations() {
        return this.internalDeclarations;
    }

    @Override // org.dom4j.DocumentType
    public String getPublicID() {
        return this.publicID;
    }

    @Override // org.dom4j.DocumentType
    public String getSystemID() {
        return this.systemID;
    }

    @Override // org.dom4j.DocumentType
    public void setExternalDeclarations(List<Decl> list) {
        this.externalDeclarations = list;
    }

    @Override // org.dom4j.DocumentType
    public void setInternalDeclarations(List<Decl> list) {
        this.internalDeclarations = list;
    }
}
