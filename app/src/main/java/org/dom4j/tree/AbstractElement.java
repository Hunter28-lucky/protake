package org.dom4j.tree;

import java.util.ArrayList;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.CDATA;
import org.dom4j.Comment;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Entity;
import org.dom4j.IllegalAddException;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.ProcessingInstruction;
import org.dom4j.QName;
import org.dom4j.Text;
import org.xml.sax.Attributes;

/* loaded from: classes2.dex */
public abstract class AbstractElement extends AbstractBranch implements Element {
    private static final DocumentFactory DOCUMENT_FACTORY = DocumentFactory.getInstance();

    public void add(Attribute attribute) {
        if (attribute.getParent() != null) {
            throw new IllegalAddException((Element) this, (Node) attribute, "The Attribute already has an existing parent \"" + attribute.getParent().getQualifiedName() + "\"");
        }
        if (attribute.getValue() != null) {
            attributeList().add(attribute);
            childAdded(attribute);
        } else {
            Attribute attribute2 = attribute(attribute.getQName());
            if (attribute2 != null) {
                remove(attribute2);
            }
        }
    }

    @Override // org.dom4j.Element
    public Element addAttribute(QName qName, String str) {
        Attribute attribute = attribute(qName);
        if (str != null) {
            if (attribute == null) {
                add(getDocumentFactory().createAttribute(this, qName, str));
            } else if (attribute.isReadOnly()) {
                remove(attribute);
                add(getDocumentFactory().createAttribute(this, qName, str));
            } else {
                attribute.setValue(str);
            }
        } else if (attribute != null) {
            remove(attribute);
        }
        return this;
    }

    @Override // org.dom4j.Element
    public Element addCDATA(String str) {
        addNewNode(getDocumentFactory().createCDATA(str));
        return this;
    }

    @Override // org.dom4j.Element
    public Element addComment(String str) {
        addNewNode(getDocumentFactory().createComment(str));
        return this;
    }

    @Override // org.dom4j.Element
    public Element addEntity(String str, String str2) {
        addNewNode(getDocumentFactory().createEntity(str, str2));
        return this;
    }

    public void addNewNode(Node node) {
        contentList().add(node);
        childAdded(node);
    }

    @Override // org.dom4j.tree.AbstractBranch
    public void addNode(Node node) {
        if (node.getParent() == null) {
            addNewNode(node);
            return;
        }
        throw new IllegalAddException((Element) this, node, "The Node already has an existing parent of \"" + node.getParent().getQualifiedName() + "\"");
    }

    @Override // org.dom4j.Element
    public Element addProcessingInstruction(String str, String str2) {
        addNewNode(getDocumentFactory().createProcessingInstruction(str, str2));
        return this;
    }

    @Override // org.dom4j.Element
    public Element addText(String str) {
        addNewNode(getDocumentFactory().createText(str));
        return this;
    }

    public void appendAttributes(Element element) {
        int iAttributeCount = element.attributeCount();
        for (int i = 0; i < iAttributeCount; i++) {
            Attribute attribute = element.attribute(i);
            if (attribute.supportsParent()) {
                addAttribute(attribute.getQName(), attribute.getValue());
            } else {
                add(attribute);
            }
        }
    }

    @Override // org.dom4j.Element
    public Attribute attribute(int i) {
        return attributeList().get(i);
    }

    @Override // org.dom4j.Element
    public int attributeCount() {
        return attributeList().size();
    }

    public abstract List<Attribute> attributeList();

    public abstract List<Attribute> attributeList(int i);

    @Override // org.dom4j.tree.AbstractBranch
    public void childAdded(Node node) {
        if (node != null) {
            node.setParent(this);
        }
    }

    @Override // org.dom4j.tree.AbstractBranch
    public void childRemoved(Node node) {
        if (node != null) {
            node.setParent(null);
            node.setDocument(null);
        }
    }

    public List<Attribute> createAttributeList() {
        return createAttributeList(5);
    }

    @Override // org.dom4j.tree.AbstractNode
    public DocumentFactory getDocumentFactory() {
        DocumentFactory documentFactory;
        QName qName = getQName();
        return (qName == null || (documentFactory = qName.getDocumentFactory()) == null) ? DOCUMENT_FACTORY : documentFactory;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getName() {
        return getQName().getName();
    }

    @Override // org.dom4j.Element
    public Namespace getNamespace() {
        return getQName().getNamespace();
    }

    public String getNamespaceURI() {
        return getQName().getNamespaceURI();
    }

    @Override // org.dom4j.Node
    public short getNodeType() {
        return (short) 1;
    }

    @Override // org.dom4j.Element
    public String getQualifiedName() {
        return getQName().getQualifiedName();
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public Node node(int i) {
        Node node;
        if (i >= 0) {
            List<Node> listContentList = contentList();
            if (i < listContentList.size() && (node = listContentList.get(i)) != null) {
                return node;
            }
        }
        return null;
    }

    @Override // org.dom4j.tree.AbstractBranch, org.dom4j.Branch
    public int nodeCount() {
        return contentList().size();
    }

    public boolean remove(Attribute attribute) {
        List<Attribute> listAttributeList = attributeList();
        boolean zRemove = listAttributeList.remove(attribute);
        if (zRemove) {
            childRemoved(attribute);
            return zRemove;
        }
        Attribute attribute2 = attribute(attribute.getQName());
        if (attribute2 == null) {
            return zRemove;
        }
        listAttributeList.remove(attribute2);
        return true;
    }

    public void setAttributes(Attributes attributes, NamespaceStack namespaceStack, boolean z) {
        int length = attributes.getLength();
        if (length > 0) {
            DocumentFactory documentFactory = getDocumentFactory();
            if (length == 1) {
                String qName = attributes.getQName(0);
                if (z || !qName.startsWith("xmlns")) {
                    String uri = attributes.getURI(0);
                    String localName = attributes.getLocalName(0);
                    add(documentFactory.createAttribute(this, namespaceStack.getAttributeQName(uri, localName, qName), attributes.getValue(0)));
                    return;
                }
                return;
            }
            List<Attribute> listAttributeList = attributeList(length);
            listAttributeList.clear();
            for (int i = 0; i < length; i++) {
                String qName2 = attributes.getQName(i);
                if (z || !qName2.startsWith("xmlns")) {
                    String uri2 = attributes.getURI(i);
                    String localName2 = attributes.getLocalName(i);
                    Attribute attributeCreateAttribute = documentFactory.createAttribute(this, namespaceStack.getAttributeQName(uri2, localName2, qName2), attributes.getValue(i));
                    listAttributeList.add(attributeCreateAttribute);
                    childAdded(attributeCreateAttribute);
                }
            }
        }
    }

    public String toString() {
        String namespaceURI = getNamespaceURI();
        if (namespaceURI == null || namespaceURI.length() <= 0) {
            return super.toString() + " [Element: <" + getQualifiedName() + " attributes: " + attributeList() + "/>]";
        }
        return super.toString() + " [Element: <" + getQualifiedName() + " uri: " + namespaceURI + " attributes: " + attributeList() + "/>]";
    }

    @Override // org.dom4j.Element
    public Attribute attribute(String str) {
        for (Attribute attribute : attributeList()) {
            if (str.equals(attribute.getName())) {
                return attribute;
            }
        }
        return null;
    }

    public List<Attribute> createAttributeList(int i) {
        return new ArrayList(i);
    }

    public Attribute attribute(QName qName) {
        for (Attribute attribute : attributeList()) {
            if (qName.equals(attribute.getQName())) {
                return attribute;
            }
        }
        return null;
    }

    @Override // org.dom4j.tree.AbstractBranch
    public void add(Node node) {
        short nodeType = node.getNodeType();
        if (nodeType == 1) {
            add((Element) node);
            return;
        }
        if (nodeType == 2) {
            add((Attribute) node);
            return;
        }
        if (nodeType == 3) {
            add((Text) node);
            return;
        }
        if (nodeType == 4) {
            add((CDATA) node);
            return;
        }
        if (nodeType == 5) {
            add((Entity) node);
            return;
        }
        if (nodeType == 7) {
            add((ProcessingInstruction) node);
            return;
        }
        if (nodeType == 8) {
            add((Comment) node);
        } else if (nodeType != 13) {
            invalidNodeTypeAddException(node);
        } else {
            add((Namespace) node);
        }
    }

    public void add(CDATA cdata) {
        addNode(cdata);
    }

    @Override // org.dom4j.tree.AbstractBranch
    public void add(Comment comment) {
        addNode(comment);
    }

    @Override // org.dom4j.tree.AbstractBranch
    public void add(Element element) {
        addNode(element);
    }

    public void add(Entity entity) {
        addNode(entity);
    }

    @Override // org.dom4j.Element
    public void add(Namespace namespace) {
        addNode(namespace);
    }

    @Override // org.dom4j.tree.AbstractBranch
    public void add(ProcessingInstruction processingInstruction) {
        addNode(processingInstruction);
    }

    public void add(Text text) {
        addNode(text);
    }
}
