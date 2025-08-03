package org.dom4j.tree;

import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Branch;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.IllegalAddException;
import org.dom4j.Node;
import org.dom4j.QName;

/* loaded from: classes2.dex */
public class DefaultElement extends AbstractElement {
    private static final transient DocumentFactory DOCUMENT_FACTORY = DocumentFactory.getInstance();
    private Object attributes;
    private Object content;
    private Branch parentBranch;
    private QName qname;

    public DefaultElement(QName qName) {
        this.qname = qName;
    }

    @Override // org.dom4j.tree.AbstractElement
    public void add(Attribute attribute) {
        if (attribute.getParent() != null) {
            throw new IllegalAddException((Element) this, (Node) attribute, "The Attribute already has an existing parent \"" + attribute.getParent().getQualifiedName() + "\"");
        }
        if (attribute.getValue() == null) {
            Attribute attribute2 = attribute(attribute.getQName());
            if (attribute2 != null) {
                remove(attribute2);
                return;
            }
            return;
        }
        if (this.attributes == null) {
            this.attributes = attribute;
        } else {
            attributeList().add(attribute);
        }
        childAdded(attribute);
    }

    @Override // org.dom4j.tree.AbstractElement
    public void addNewNode(Node node) {
        Object obj = this.content;
        if (obj == null) {
            this.content = node;
        } else if (obj instanceof List) {
            ((List) obj).add(node);
        } else {
            List<Node> listCreateContentList = createContentList();
            listCreateContentList.add((Node) obj);
            listCreateContentList.add(node);
            this.content = listCreateContentList;
        }
        childAdded(node);
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element
    public Attribute attribute(int i) {
        Object obj = this.attributes;
        if (obj instanceof List) {
            return (Attribute) ((List) obj).get(i);
        }
        if (obj == null || i != 0) {
            return null;
        }
        return (Attribute) obj;
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element
    public int attributeCount() {
        Object obj = this.attributes;
        return obj instanceof List ? ((List) obj).size() : obj != null ? 1 : 0;
    }

    @Override // org.dom4j.tree.AbstractElement
    public List<Attribute> attributeList() {
        Object obj = this.attributes;
        if (obj instanceof List) {
            return (List) obj;
        }
        if (obj == null) {
            List<Attribute> listCreateAttributeList = createAttributeList();
            this.attributes = listCreateAttributeList;
            return listCreateAttributeList;
        }
        List<Attribute> listCreateAttributeList2 = createAttributeList();
        listCreateAttributeList2.add((Attribute) obj);
        this.attributes = listCreateAttributeList2;
        return listCreateAttributeList2;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public Object clone() {
        DefaultElement defaultElement = (DefaultElement) super.clone();
        if (defaultElement != this) {
            defaultElement.content = null;
            defaultElement.attributes = null;
            defaultElement.appendAttributes(this);
            defaultElement.appendContent(this);
        }
        return defaultElement;
    }

    @Override // org.dom4j.tree.AbstractBranch
    public List<Node> contentList() {
        Object obj = this.content;
        if (obj instanceof List) {
            return (List) obj;
        }
        List<Node> listCreateContentList = createContentList();
        if (obj != null) {
            listCreateContentList.add((Node) obj);
        }
        this.content = listCreateContentList;
        return listCreateContentList;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public Document getDocument() {
        Branch branch = this.parentBranch;
        if (branch instanceof Document) {
            return (Document) branch;
        }
        if (branch instanceof Element) {
            return ((Element) branch).getDocument();
        }
        return null;
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.tree.AbstractNode
    public DocumentFactory getDocumentFactory() {
        DocumentFactory documentFactory = this.qname.getDocumentFactory();
        return documentFactory != null ? documentFactory : DOCUMENT_FACTORY;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public Element getParent() {
        Branch branch = this.parentBranch;
        if (branch instanceof Element) {
            return (Element) branch;
        }
        return null;
    }

    @Override // org.dom4j.Element
    public QName getQName() {
        return this.qname;
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        Object obj = this.content;
        return obj instanceof List ? super.getText() : obj != null ? getContentAsText(obj) : "";
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public Node node(int i) {
        if (i < 0) {
            return null;
        }
        Object obj = this.content;
        if (!(obj instanceof List)) {
            return i == 0 ? (Node) obj : null;
        }
        List list = (List) obj;
        if (i >= list.size()) {
            return null;
        }
        return (Node) list.get(i);
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public int nodeCount() {
        Object obj = this.content;
        return obj instanceof List ? ((List) obj).size() : obj != null ? 1 : 0;
    }

    @Override // org.dom4j.tree.AbstractElement
    public boolean remove(Attribute attribute) {
        Attribute attribute2;
        Object obj = this.attributes;
        boolean z = true;
        if (obj instanceof List) {
            List list = (List) obj;
            boolean zRemove = list.remove(attribute);
            if (zRemove || (attribute2 = attribute(attribute.getQName())) == null) {
                z = zRemove;
            } else {
                list.remove(attribute2);
            }
        } else if (obj == null || !(attribute.equals(obj) || attribute.getQName().equals(((Attribute) obj).getQName()))) {
            z = false;
        } else {
            this.attributes = null;
        }
        if (z) {
            childRemoved(attribute);
        }
        return z;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setDocument(Document document) {
        if ((this.parentBranch instanceof Document) || document != null) {
            this.parentBranch = document;
        }
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setParent(Element element) {
        if ((this.parentBranch instanceof Element) || element != null) {
            this.parentBranch = element;
        }
    }

    @Override // org.dom4j.tree.AbstractElement, org.dom4j.Element
    public Attribute attribute(String str) {
        Object obj = this.attributes;
        if (obj instanceof List) {
            for (Attribute attribute : (List) obj) {
                if (str.equals(attribute.getName())) {
                    return attribute;
                }
            }
            return null;
        }
        if (obj == null) {
            return null;
        }
        Attribute attribute2 = (Attribute) obj;
        if (str.equals(attribute2.getName())) {
            return attribute2;
        }
        return null;
    }

    @Override // org.dom4j.tree.AbstractElement
    public List<Attribute> attributeList(int i) {
        Object obj = this.attributes;
        if (obj instanceof List) {
            return (List) obj;
        }
        if (obj != null) {
            List<Attribute> listCreateAttributeList = createAttributeList(i);
            listCreateAttributeList.add((Attribute) obj);
            this.attributes = listCreateAttributeList;
            return listCreateAttributeList;
        }
        List<Attribute> listCreateAttributeList2 = createAttributeList(i);
        this.attributes = listCreateAttributeList2;
        return listCreateAttributeList2;
    }

    @Override // org.dom4j.tree.AbstractElement
    public Attribute attribute(QName qName) {
        Object obj = this.attributes;
        if (obj instanceof List) {
            for (Attribute attribute : (List) obj) {
                if (qName.equals(attribute.getQName())) {
                    return attribute;
                }
            }
            return null;
        }
        if (obj == null) {
            return null;
        }
        Attribute attribute2 = (Attribute) obj;
        if (qName.equals(attribute2.getQName())) {
            return attribute2;
        }
        return null;
    }
}
