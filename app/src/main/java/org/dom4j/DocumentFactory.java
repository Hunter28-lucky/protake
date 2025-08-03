package org.dom4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Map;
import org.dom4j.tree.DefaultAttribute;
import org.dom4j.tree.DefaultCDATA;
import org.dom4j.tree.DefaultComment;
import org.dom4j.tree.DefaultDocument;
import org.dom4j.tree.DefaultDocumentType;
import org.dom4j.tree.DefaultElement;
import org.dom4j.tree.DefaultEntity;
import org.dom4j.tree.DefaultProcessingInstruction;
import org.dom4j.tree.DefaultText;
import org.dom4j.tree.QNameCache;
import org.dom4j.util.SimpleSingleton;
import org.dom4j.util.SingletonStrategy;

/* loaded from: classes2.dex */
public class DocumentFactory implements Serializable {
    private static SingletonStrategy<DocumentFactory> singleton;
    public transient QNameCache cache;
    private Map<String, String> xpathNamespaceURIs;

    public DocumentFactory() {
        init();
    }

    private static SingletonStrategy<DocumentFactory> createSingleton() {
        SingletonStrategy<DocumentFactory> simpleSingleton;
        String property = "org.dom4j.DocumentFactory";
        try {
            property = System.getProperty("org.dom4j.factory", "org.dom4j.DocumentFactory");
        } catch (Exception unused) {
        }
        try {
            simpleSingleton = (SingletonStrategy) Class.forName(System.getProperty("org.dom4j.DocumentFactory.singleton.strategy", "org.dom4j.util.SimpleSingleton")).newInstance();
        } catch (Exception unused2) {
            simpleSingleton = new SimpleSingleton<>();
        }
        simpleSingleton.setSingletonClassName(property);
        return simpleSingleton;
    }

    public static synchronized DocumentFactory getInstance() {
        if (singleton == null) {
            singleton = createSingleton();
        }
        return singleton.instance();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        init();
    }

    public Attribute createAttribute(Element element, QName qName, String str) {
        return new DefaultAttribute(qName, str);
    }

    public CDATA createCDATA(String str) {
        return new DefaultCDATA(str);
    }

    public Comment createComment(String str) {
        return new DefaultComment(str);
    }

    public DocumentType createDocType(String str, String str2, String str3) {
        return new DefaultDocumentType(str, str2, str3);
    }

    public Document createDocument() {
        DefaultDocument defaultDocument = new DefaultDocument();
        defaultDocument.setDocumentFactory(this);
        return defaultDocument;
    }

    public Element createElement(QName qName) {
        return new DefaultElement(qName);
    }

    public Entity createEntity(String str, String str2) {
        return new DefaultEntity(str, str2);
    }

    public Namespace createNamespace(String str, String str2) {
        return Namespace.get(str, str2);
    }

    public ProcessingInstruction createProcessingInstruction(String str, String str2) {
        return new DefaultProcessingInstruction(str, str2);
    }

    public QName createQName(String str, Namespace namespace) {
        return this.cache.get(str, namespace);
    }

    public QNameCache createQNameCache() {
        return new QNameCache(this);
    }

    public Text createText(String str) {
        if (str != null) {
            return new DefaultText(str);
        }
        throw new IllegalArgumentException("Adding text to an XML document must not be null");
    }

    public void init() {
        this.cache = createQNameCache();
    }

    public Document createDocument(String str) {
        Document documentCreateDocument = createDocument();
        documentCreateDocument.setXMLEncoding(str);
        return documentCreateDocument;
    }
}
