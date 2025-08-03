package org.dom4j.io;

import java.util.ArrayList;
import java.util.List;
import org.dom4j.Branch;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.QName;
import org.dom4j.dtd.AttributeDecl;
import org.dom4j.dtd.Decl;
import org.dom4j.dtd.ElementDecl;
import org.dom4j.dtd.ExternalEntityDecl;
import org.dom4j.dtd.InternalEntityDecl;
import org.dom4j.tree.AbstractElement;
import org.dom4j.tree.NamespaceStack;
import org.xml.sax.Attributes;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.ext.DeclHandler;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.ext.Locator2;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes2.dex */
public class SAXContentHandler extends DefaultHandler implements LexicalHandler, DeclHandler {
    private StringBuffer cdataText;
    private Element currentElement;
    private int declaredNamespaceIndex;
    private Document document;
    private DocumentFactory documentFactory;
    private ElementHandler elementHandler;
    private ElementStack elementStack;
    private String entity;
    private int entityLevel;
    private EntityResolver entityResolver;
    private List<Decl> externalDTDDeclarations;
    private boolean ignoreComments;
    private boolean includeExternalDTDDeclarations;
    private boolean includeInternalDTDDeclarations;
    private InputSource inputSource;
    private boolean insideCDATASection;
    private boolean insideDTDSection;
    private List<Decl> internalDTDDeclarations;
    private boolean internalDTDsubset;
    private Locator locator;
    private boolean mergeAdjacentText;
    private NamespaceStack namespaceStack;
    private boolean stripWhitespaceText;
    private StringBuffer textBuffer;
    private boolean textInTextBuffer;

    public SAXContentHandler(DocumentFactory documentFactory, ElementHandler elementHandler) {
        this(documentFactory, elementHandler, null);
        this.elementStack = createElementStack();
    }

    private String getEncoding() {
        Locator locator = this.locator;
        if (locator != null && (locator instanceof Locator2)) {
            return ((Locator2) locator).getEncoding();
        }
        return null;
    }

    public void addAttributes(Element element, Attributes attributes) {
        if (element instanceof AbstractElement) {
            ((AbstractElement) element).setAttributes(attributes, this.namespaceStack, false);
            return;
        }
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            String qName = attributes.getQName(i);
            if (!qName.startsWith("xmlns")) {
                String uri = attributes.getURI(i);
                String localName = attributes.getLocalName(i);
                element.addAttribute(this.namespaceStack.getAttributeQName(uri, localName, qName), attributes.getValue(i));
            }
        }
    }

    public void addDTDDeclaration(Decl decl) {
        if (this.internalDTDDeclarations == null) {
            this.internalDTDDeclarations = new ArrayList();
        }
        this.internalDTDDeclarations.add(decl);
    }

    public void addDeclaredNamespaces(Element element) {
        element.getNamespace();
        int size = this.namespaceStack.size();
        while (true) {
            int i = this.declaredNamespaceIndex;
            if (i >= size) {
                return;
            }
            element.add(this.namespaceStack.getNamespace(i));
            this.declaredNamespaceIndex++;
        }
    }

    public void addExternalDTDDeclaration(Decl decl) {
        if (this.externalDTDDeclarations == null) {
            this.externalDTDDeclarations = new ArrayList();
        }
        this.externalDTDDeclarations.add(decl);
    }

    @Override // org.xml.sax.ext.DeclHandler
    public void attributeDecl(String str, String str2, String str3, String str4, String str5) throws SAXException {
        if (this.internalDTDsubset) {
            if (this.includeInternalDTDDeclarations) {
                addDTDDeclaration(new AttributeDecl(str, str2, str3, str4, str5));
            }
        } else if (this.includeExternalDTDDeclarations) {
            addExternalDTDDeclaration(new AttributeDecl(str, str2, str3, str4, str5));
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        Element element;
        if (i2 == 0 || (element = this.currentElement) == null) {
            return;
        }
        if (this.entity != null) {
            if (this.mergeAdjacentText && this.textInTextBuffer) {
                completeCurrentTextNode();
            }
            this.currentElement.addEntity(this.entity, new String(cArr, i, i2));
            this.entity = null;
            return;
        }
        if (this.insideCDATASection) {
            if (this.mergeAdjacentText && this.textInTextBuffer) {
                completeCurrentTextNode();
            }
            this.cdataText.append(new String(cArr, i, i2));
            return;
        }
        if (!this.mergeAdjacentText) {
            element.addText(new String(cArr, i, i2));
        } else {
            this.textBuffer.append(cArr, i, i2);
            this.textInTextBuffer = true;
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i, int i2) throws SAXException {
        if (this.ignoreComments) {
            return;
        }
        if (this.mergeAdjacentText && this.textInTextBuffer) {
            completeCurrentTextNode();
        }
        String str = new String(cArr, i, i2);
        if (this.insideDTDSection || str.length() <= 0) {
            return;
        }
        Element element = this.currentElement;
        if (element != null) {
            element.addComment(str);
        } else {
            getDocument().addComment(str);
        }
    }

    public void completeCurrentTextNode() {
        boolean z;
        if (this.stripWhitespaceText) {
            int length = this.textBuffer.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = true;
                    break;
                } else {
                    if (!Character.isWhitespace(this.textBuffer.charAt(i))) {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            if (!z) {
                this.currentElement.addText(this.textBuffer.toString());
            }
        } else {
            this.currentElement.addText(this.textBuffer.toString());
        }
        this.textBuffer.setLength(0);
        this.textInTextBuffer = false;
    }

    public Document createDocument() {
        Document documentCreateDocument = this.documentFactory.createDocument(getEncoding());
        documentCreateDocument.setEntityResolver(this.entityResolver);
        InputSource inputSource = this.inputSource;
        if (inputSource != null) {
            documentCreateDocument.setName(inputSource.getSystemId());
        }
        return documentCreateDocument;
    }

    public ElementStack createElementStack() {
        return new ElementStack();
    }

    @Override // org.xml.sax.ext.DeclHandler
    public void elementDecl(String str, String str2) throws SAXException {
        if (this.internalDTDsubset) {
            if (this.includeInternalDTDDeclarations) {
                addDTDDeclaration(new ElementDecl(str, str2));
            }
        } else if (this.includeExternalDTDDeclarations) {
            addExternalDTDDeclaration(new ElementDecl(str, str2));
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endCDATA() throws SAXException {
        this.insideCDATASection = false;
        this.currentElement.addCDATA(this.cdataText.toString());
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endDTD() throws SAXException {
        this.insideDTDSection = false;
        DocumentType docType = getDocument().getDocType();
        if (docType != null) {
            List<Decl> list = this.internalDTDDeclarations;
            if (list != null) {
                docType.setInternalDeclarations(list);
            }
            List<Decl> list2 = this.externalDTDDeclarations;
            if (list2 != null) {
                docType.setExternalDeclarations(list2);
            }
        }
        this.internalDTDDeclarations = null;
        this.externalDTDDeclarations = null;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        this.namespaceStack.clear();
        this.elementStack.clear();
        this.currentElement = null;
        this.textBuffer = null;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if (this.mergeAdjacentText && this.textInTextBuffer) {
            completeCurrentTextNode();
        }
        ElementHandler elementHandler = this.elementHandler;
        if (elementHandler != null && this.currentElement != null) {
            elementHandler.onEnd(this.elementStack);
        }
        this.elementStack.popElement();
        this.currentElement = this.elementStack.peekElement();
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endEntity(String str) throws SAXException {
        int i = this.entityLevel - 1;
        this.entityLevel = i;
        this.entity = null;
        if (i == 0) {
            this.internalDTDsubset = true;
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) throws SAXException {
        this.namespaceStack.pop(str);
        this.declaredNamespaceIndex = this.namespaceStack.size();
    }

    @Override // org.xml.sax.ext.DeclHandler
    public void externalEntityDecl(String str, String str2, String str3) throws SAXException {
        ExternalEntityDecl externalEntityDecl = new ExternalEntityDecl(str, str2, str3);
        if (this.internalDTDsubset) {
            if (this.includeInternalDTDDeclarations) {
                addDTDDeclaration(externalEntityDecl);
            }
        } else if (this.includeExternalDTDDeclarations) {
            addExternalDTDDeclaration(externalEntityDecl);
        }
    }

    public Document getDocument() {
        if (this.document == null) {
            this.document = createDocument();
        }
        return this.document;
    }

    @Override // org.xml.sax.ext.DeclHandler
    public void internalEntityDecl(String str, String str2) throws SAXException {
        if (this.internalDTDsubset) {
            if (this.includeInternalDTDDeclarations) {
                addDTDDeclaration(new InternalEntityDecl(str, str2));
            }
        } else if (this.includeExternalDTDDeclarations) {
            addExternalDTDDeclaration(new InternalEntityDecl(str, str2));
        }
    }

    public boolean isIgnorableEntity(String str) {
        return "amp".equals(str) || "apos".equals(str) || "gt".equals(str) || "lt".equals(str) || "quot".equals(str);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.DTDHandler
    public void notationDecl(String str, String str2, String str3) throws SAXException {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws SAXException {
        if (this.mergeAdjacentText && this.textInTextBuffer) {
            completeCurrentTextNode();
        }
        Element element = this.currentElement;
        if (element != null) {
            element.addProcessingInstruction(str, str2);
        } else {
            getDocument().addProcessingInstruction(str, str2);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
    }

    public void setEntityResolver(EntityResolver entityResolver) {
        this.entityResolver = entityResolver;
    }

    public void setIgnoreComments(boolean z) {
        this.ignoreComments = z;
    }

    public void setIncludeExternalDTDDeclarations(boolean z) {
        this.includeExternalDTDDeclarations = z;
    }

    public void setIncludeInternalDTDDeclarations(boolean z) {
        this.includeInternalDTDDeclarations = z;
    }

    public void setInputSource(InputSource inputSource) {
        this.inputSource = inputSource;
    }

    public void setMergeAdjacentText(boolean z) {
        this.mergeAdjacentText = z;
    }

    public void setStripWhitespaceText(boolean z) {
        this.stripWhitespaceText = z;
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startCDATA() throws SAXException {
        this.insideCDATASection = true;
        this.cdataText = new StringBuffer();
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startDTD(String str, String str2, String str3) throws SAXException {
        getDocument().addDocType(str, str2, str3);
        this.insideDTDSection = true;
        this.internalDTDsubset = true;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        this.document = null;
        this.currentElement = null;
        this.elementStack.clear();
        ElementHandler elementHandler = this.elementHandler;
        if (elementHandler != null && (elementHandler instanceof DispatchHandler)) {
            this.elementStack.setDispatchHandler((DispatchHandler) elementHandler);
        }
        this.namespaceStack.clear();
        this.declaredNamespaceIndex = 0;
        if (this.mergeAdjacentText && this.textBuffer == null) {
            this.textBuffer = new StringBuffer();
        }
        this.textInTextBuffer = false;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (this.mergeAdjacentText && this.textInTextBuffer) {
            completeCurrentTextNode();
        }
        QName qName = this.namespaceStack.getQName(str, str2, str3);
        Branch document = this.currentElement;
        if (document == null) {
            document = getDocument();
        }
        Element elementAddElement = document.addElement(qName);
        addDeclaredNamespaces(elementAddElement);
        addAttributes(elementAddElement, attributes);
        this.elementStack.pushElement(elementAddElement);
        this.currentElement = elementAddElement;
        this.entity = null;
        ElementHandler elementHandler = this.elementHandler;
        if (elementHandler != null) {
            elementHandler.onStart(this.elementStack);
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startEntity(String str) throws SAXException {
        this.entityLevel++;
        this.entity = null;
        if (!this.insideDTDSection && !isIgnorableEntity(str)) {
            this.entity = str;
        }
        this.internalDTDsubset = false;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) throws SAXException {
        this.namespaceStack.push(str, str2);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.DTDHandler
    public void unparsedEntityDecl(String str, String str2, String str3, String str4) throws SAXException {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) throws SAXException {
    }

    public SAXContentHandler(DocumentFactory documentFactory, ElementHandler elementHandler, ElementStack elementStack) {
        this.includeInternalDTDDeclarations = false;
        this.includeExternalDTDDeclarations = false;
        this.internalDTDsubset = false;
        this.mergeAdjacentText = false;
        this.textInTextBuffer = false;
        this.ignoreComments = false;
        this.stripWhitespaceText = false;
        this.documentFactory = documentFactory;
        this.elementHandler = elementHandler;
        this.elementStack = elementStack;
        this.namespaceStack = new NamespaceStack(documentFactory);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) throws SAXException {
        throw sAXParseException;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        throw sAXParseException;
    }
}
