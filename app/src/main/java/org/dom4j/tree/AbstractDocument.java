package org.dom4j.tree;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.IllegalAddException;
import org.dom4j.Node;
import org.dom4j.QName;

/* loaded from: classes2.dex */
public abstract class AbstractDocument extends AbstractBranch implements Document {
    public String encoding;

    @Override // org.dom4j.tree.AbstractBranch
    public void add(Element element) {
        checkAddElementAllowed(element);
        super.add(element);
        rootElementAdded(element);
    }

    @Override // org.dom4j.Document
    public Document addComment(String str) {
        add(getDocumentFactory().createComment(str));
        return this;
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public Element addElement(QName qName) {
        Element elementCreateElement = getDocumentFactory().createElement(qName);
        add(elementCreateElement);
        return elementCreateElement;
    }

    @Override // org.dom4j.Document
    public Document addProcessingInstruction(String str, String str2) {
        add(getDocumentFactory().createProcessingInstruction(str, str2));
        return this;
    }

    public void checkAddElementAllowed(Element element) {
        Element rootElement = getRootElement();
        if (rootElement == null) {
            return;
        }
        throw new IllegalAddException(this, element, "Cannot add another element to this Document as it already has a root element of: " + rootElement.getQualifiedName());
    }

    @Override // org.dom4j.tree.AbstractBranch
    public void childAdded(Node node) {
        if (node != null) {
            node.setDocument(this);
        }
    }

    @Override // org.dom4j.tree.AbstractBranch
    public void childRemoved(Node node) {
        if (node != null) {
            node.setDocument(null);
        }
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public Document getDocument() {
        return this;
    }

    @Override // org.dom4j.Node
    public short getNodeType() {
        return (short) 9;
    }

    public abstract void rootElementAdded(Element element);

    @Override // org.dom4j.Document
    public void setXMLEncoding(String str) {
        this.encoding = str;
    }

    public String toString() {
        return super.toString() + " [Document: name " + getName() + "]";
    }
}
