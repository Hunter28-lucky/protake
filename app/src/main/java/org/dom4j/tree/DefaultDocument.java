package org.dom4j.tree;

import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.dom4j.IllegalAddException;
import org.dom4j.Node;
import org.xml.sax.EntityResolver;

/* loaded from: classes2.dex */
public class DefaultDocument extends AbstractDocument {
    private List<Node> content;
    private DocumentType docType;
    private DocumentFactory documentFactory = DocumentFactory.getInstance();
    private transient EntityResolver entityResolver;
    private String name;
    private Element rootElement;

    @Override // org.dom4j.Document
    public Document addDocType(String str, String str2, String str3) {
        setDocType(getDocumentFactory().createDocType(str, str2, str3));
        return this;
    }

    @Override // org.dom4j.tree.AbstractBranch
    public void addNode(Node node) {
        if (node != null) {
            Document document = node.getDocument();
            if (document == null || document == this) {
                contentList().add(node);
                childAdded(node);
            } else {
                throw new IllegalAddException(this, node, "The Node already has an existing document: " + document);
            }
        }
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public Object clone() {
        DefaultDocument defaultDocument = (DefaultDocument) super.clone();
        defaultDocument.rootElement = null;
        defaultDocument.content = null;
        defaultDocument.appendContent(this);
        return defaultDocument;
    }

    @Override // org.dom4j.tree.AbstractBranch
    public List<Node> contentList() {
        if (this.content == null) {
            List<Node> listCreateContentList = createContentList();
            this.content = listCreateContentList;
            Element element = this.rootElement;
            if (element != null) {
                listCreateContentList.add(element);
            }
        }
        return this.content;
    }

    @Override // org.dom4j.Document
    public DocumentType getDocType() {
        return this.docType;
    }

    @Override // org.dom4j.tree.AbstractNode
    public DocumentFactory getDocumentFactory() {
        return this.documentFactory;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getName() {
        return this.name;
    }

    @Override // org.dom4j.Document
    public Element getRootElement() {
        return this.rootElement;
    }

    @Override // org.dom4j.tree.AbstractDocument
    public void rootElementAdded(Element element) {
        this.rootElement = element;
        element.setDocument(this);
    }

    public void setDocType(DocumentType documentType) {
        this.docType = documentType;
    }

    public void setDocumentFactory(DocumentFactory documentFactory) {
        this.documentFactory = documentFactory;
    }

    @Override // org.dom4j.Document
    public void setEntityResolver(EntityResolver entityResolver) {
        this.entityResolver = entityResolver;
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public void setName(String str) {
        this.name = str;
    }
}
