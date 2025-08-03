package org.dom4j.tree;

import java.util.ArrayList;
import java.util.List;
import org.dom4j.Branch;
import org.dom4j.Comment;
import org.dom4j.Element;
import org.dom4j.IllegalAddException;
import org.dom4j.Node;
import org.dom4j.ProcessingInstruction;
import org.dom4j.QName;

/* loaded from: classes2.dex */
public abstract class AbstractBranch extends AbstractNode implements Branch {
    public void add(Node node) {
        short nodeType = node.getNodeType();
        if (nodeType == 1) {
            add((Element) node);
            return;
        }
        if (nodeType == 7) {
            add((ProcessingInstruction) node);
        } else if (nodeType != 8) {
            invalidNodeTypeAddException(node);
        } else {
            add((Comment) node);
        }
    }

    @Override // org.dom4j.Branch
    public Element addElement(QName qName) {
        Element elementCreateElement = getDocumentFactory().createElement(qName);
        add(elementCreateElement);
        return elementCreateElement;
    }

    public abstract void addNode(Node node);

    public void appendContent(Branch branch) {
        int iNodeCount = branch.nodeCount();
        for (int i = 0; i < iNodeCount; i++) {
            add((Node) branch.node(i).clone());
        }
    }

    public abstract void childAdded(Node node);

    public abstract void childRemoved(Node node);

    @Override // org.dom4j.Branch
    public List<Node> content() {
        return new ContentListFacade(this, contentList());
    }

    public abstract List<Node> contentList();

    public List<Node> createContentList() {
        return new ArrayList(5);
    }

    public String getContentAsText(Object obj) {
        if (!(obj instanceof Node)) {
            return obj instanceof String ? (String) obj : "";
        }
        Node node = (Node) obj;
        short nodeType = node.getNodeType();
        return (nodeType == 3 || nodeType == 4 || nodeType == 5) ? node.getText() : "";
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public String getText() {
        List<Node> listContentList = contentList();
        if (listContentList == null) {
            return "";
        }
        int size = listContentList.size();
        if (size < 1) {
            return "";
        }
        String contentAsText = getContentAsText(listContentList.get(0));
        if (size == 1) {
            return contentAsText;
        }
        StringBuilder sb = new StringBuilder(contentAsText);
        for (int i = 1; i < size; i++) {
            sb.append(getContentAsText(listContentList.get(i)));
        }
        return sb.toString();
    }

    public void invalidNodeTypeAddException(Node node) {
        throw new IllegalAddException("Invalid node type. Cannot add node: " + node + " to this branch: " + this);
    }

    @Override // org.dom4j.tree.AbstractNode, org.dom4j.Node
    public boolean isReadOnly() {
        return false;
    }

    @Override // org.dom4j.Branch
    public Node node(int i) {
        return contentList().get(i);
    }

    @Override // org.dom4j.Branch
    public int nodeCount() {
        return contentList().size();
    }

    public void add(Comment comment) {
        addNode(comment);
    }

    public void add(Element element) {
        addNode(element);
    }

    public void add(ProcessingInstruction processingInstruction) {
        addNode(processingInstruction);
    }
}
