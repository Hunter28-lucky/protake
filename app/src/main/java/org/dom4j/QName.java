package org.dom4j;

import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.dom4j.tree.QNameCache;
import org.dom4j.util.SimpleSingleton;
import org.dom4j.util.SingletonStrategy;

/* loaded from: classes2.dex */
public class QName implements Serializable {
    private static SingletonStrategy<QNameCache> singleton;
    private DocumentFactory documentFactory;
    private int hashCode;
    private String name;
    private transient Namespace namespace;
    private String qualifiedName;

    static {
        Class cls;
        try {
            cls = Class.forName(System.getProperty("org.dom4j.QName.singleton.strategy", "org.dom4j.util.SimpleSingleton"));
        } catch (Exception unused) {
            cls = SimpleSingleton.class;
        }
        try {
            SingletonStrategy<QNameCache> singletonStrategy = (SingletonStrategy) cls.newInstance();
            singleton = singletonStrategy;
            singletonStrategy.setSingletonClassName(QNameCache.class.getName());
        } catch (Exception unused2) {
        }
    }

    public QName(String str, Namespace namespace) {
        this.name = str == null ? "" : str;
        this.namespace = namespace == null ? Namespace.NO_NAMESPACE : namespace;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        String str = (String) objectInputStream.readObject();
        String str2 = (String) objectInputStream.readObject();
        objectInputStream.defaultReadObject();
        this.namespace = Namespace.get(str, str2);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.namespace.getPrefix());
        objectOutputStream.writeObject(this.namespace.getURI());
        objectOutputStream.defaultWriteObject();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QName) {
            QName qName = (QName) obj;
            if (hashCode() == qName.hashCode()) {
                return getName().equals(qName.getName()) && getNamespaceURI().equals(qName.getNamespaceURI());
            }
        }
        return false;
    }

    public DocumentFactory getDocumentFactory() {
        return this.documentFactory;
    }

    public String getName() {
        return this.name;
    }

    public Namespace getNamespace() {
        return this.namespace;
    }

    public String getNamespacePrefix() {
        Namespace namespace = this.namespace;
        return namespace == null ? "" : namespace.getPrefix();
    }

    public String getNamespaceURI() {
        Namespace namespace = this.namespace;
        return namespace == null ? "" : namespace.getURI();
    }

    public String getQualifiedName() {
        if (this.qualifiedName == null) {
            String namespacePrefix = getNamespacePrefix();
            if (namespacePrefix == null || namespacePrefix.length() <= 0) {
                this.qualifiedName = this.name;
            } else {
                this.qualifiedName = namespacePrefix + Constants.COLON_SEPARATOR + this.name;
            }
        }
        return this.qualifiedName;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            int iHashCode = getName().hashCode() ^ getNamespaceURI().hashCode();
            this.hashCode = iHashCode;
            if (iHashCode == 0) {
                this.hashCode = 47806;
            }
        }
        return this.hashCode;
    }

    public void setDocumentFactory(DocumentFactory documentFactory) {
        this.documentFactory = documentFactory;
    }

    public String toString() {
        return super.toString() + " [name: " + getName() + " namespace: \"" + getNamespace() + "\"]";
    }
}
