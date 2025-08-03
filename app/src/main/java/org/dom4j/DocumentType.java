package org.dom4j;

import java.util.List;
import org.dom4j.dtd.Decl;

/* loaded from: classes2.dex */
public interface DocumentType extends Node {
    String getElementName();

    List<Decl> getInternalDeclarations();

    String getPublicID();

    String getSystemID();

    void setExternalDeclarations(List<Decl> list);

    void setInternalDeclarations(List<Decl> list);
}
