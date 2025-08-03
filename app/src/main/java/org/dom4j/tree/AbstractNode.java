package org.dom4j.tree;

import java.io.Serializable;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Node;

/* loaded from: classes2.dex */
public abstract class AbstractNode implements Node, Cloneable, Serializable {
    public static final String[] NODE_TYPE_NAMES = {"Node", "Element", "Attribute", "Text", "CDATA", "Entity", "Entity", "ProcessingInstruction", "Comment", "Document", "DocumentType", "DocumentFragment", "Notation", "Namespace", "Unknown"};
    private static final DocumentFactory DOCUMENT_FACTORY = DocumentFactory.getInstance();

    @Override // org.dom4j.Node
    public Object clone() {
        if (isReadOnly()) {
            return this;
        }
        try {
            Node node = (Node) super.clone();
            node.setParent(null);
            node.setDocument(null);
            return node;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException("This should never happen. Caught: " + e2);
        }
    }

    @Override // org.dom4j.Node
    public Document getDocument() {
        Element parent = getParent();
        if (parent != null) {
            return parent.getDocument();
        }
        return null;
    }

    public DocumentFactory getDocumentFactory() {
        return DOCUMENT_FACTORY;
    }

    @Override // org.dom4j.Node
    public String getName() {
        return null;
    }

    @Override // org.dom4j.Node
    public Element getParent() {
        return null;
    }

    @Override // org.dom4j.Node
    public abstract String getText();

    @Override // org.dom4j.Node
    public boolean isReadOnly() {
        return true;
    }

    @Override // org.dom4j.Node
    public void setDocument(Document document) {
    }

    @Override // org.dom4j.Node
    public void setName(String str) {
        throw new UnsupportedOperationException("This node cannot be modified");
    }

    @Override // org.dom4j.Node
    public void setParent(Element element) {
    }

    @Override // org.dom4j.Node
    public boolean supportsParent() {
        return false;
    }
}
