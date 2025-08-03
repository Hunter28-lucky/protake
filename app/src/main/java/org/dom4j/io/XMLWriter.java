package org.dom4j.io;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.dom4j.Attribute;
import org.dom4j.Comment;
import org.dom4j.Document;
import org.dom4j.DocumentType;
import org.dom4j.Element;
import org.dom4j.Entity;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.ProcessingInstruction;
import org.dom4j.Text;
import org.dom4j.tree.NamespaceStack;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.XMLFilterImpl;

/* loaded from: classes2.dex */
public class XMLWriter extends XMLFilterImpl implements LexicalHandler {
    private boolean autoFlush;
    private OutputFormat format;
    private boolean inDTD;
    private char lastChar;
    public int lastOutputNodeType;
    private LexicalHandler lexicalHandler;
    private int maximumAllowedCharacter;
    private Map<String, String> namespacesMap;
    private boolean showCommentsInDTDs;
    public Writer writer;
    public static final String[] LEXICAL_HANDLER_NAMES = {"http://xml.org/sax/properties/lexical-handler", "http://xml.org/sax/handlers/LexicalHandler"};
    public static final OutputFormat DEFAULT_FORMAT = new OutputFormat();
    private boolean resolveEntityRefs = true;
    private boolean lastElementClosed = false;
    public boolean preserve = false;
    private NamespaceStack namespaceStack = new NamespaceStack();
    private boolean escapeText = true;
    private int indentLevel = 0;
    private StringBuffer buffer = new StringBuffer();
    private boolean charsAdded = false;

    public XMLWriter(Writer writer, OutputFormat outputFormat) {
        this.writer = writer;
        this.format = outputFormat;
        this.namespaceStack.push(Namespace.NO_NAMESPACE);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException, IOException {
        if (cArr == null || cArr.length == 0 || i2 <= 0) {
            return;
        }
        try {
            String strValueOf = String.valueOf(cArr, i, i2);
            if (this.escapeText) {
                strValueOf = escapeElementEntities(strValueOf);
            }
            if (this.format.isTrimText()) {
                if (this.lastOutputNodeType == 3 && !this.charsAdded) {
                    this.writer.write(32);
                } else if (this.charsAdded && Character.isWhitespace(this.lastChar)) {
                    this.writer.write(32);
                } else if (this.lastOutputNodeType == 1 && this.format.isPadText() && this.lastElementClosed && Character.isWhitespace(cArr[0])) {
                    this.writer.write(MyUTIL.white_space);
                }
                String str = "";
                StringTokenizer stringTokenizer = new StringTokenizer(strValueOf);
                while (stringTokenizer.hasMoreTokens()) {
                    this.writer.write(str);
                    this.writer.write(stringTokenizer.nextToken());
                    str = MyUTIL.white_space;
                }
            } else {
                this.writer.write(strValueOf);
            }
            this.charsAdded = true;
            this.lastChar = cArr[(i + i2) - 1];
            this.lastOutputNodeType = 3;
            super.characters(cArr, i, i2);
        } catch (IOException e2) {
            handleException(e2);
        }
    }

    public void close() throws IOException {
        this.writer.close();
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i, int i2) throws SAXException {
        if (this.showCommentsInDTDs || !this.inDTD) {
            try {
                this.charsAdded = false;
                writeComment(new String(cArr, i, i2));
            } catch (IOException e2) {
                handleException(e2);
            }
        }
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.comment(cArr, i, i2);
        }
    }

    public int defaultMaximumAllowedCharacter() {
        String encoding = this.format.getEncoding();
        return (encoding == null || !encoding.equals("US-ASCII")) ? -1 : 127;
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endCDATA() throws SAXException, IOException {
        try {
            this.writer.write("]]>");
        } catch (IOException e2) {
            handleException(e2);
        }
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.endCDATA();
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endDTD() throws SAXException {
        this.inDTD = false;
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.endDTD();
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        super.endDocument();
        if (this.autoFlush) {
            try {
                flush();
            } catch (IOException unused) {
            }
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        try {
            this.charsAdded = false;
            this.indentLevel--;
            if (this.lastElementClosed) {
                writePrintln();
                indent();
            }
            writeClose(str3);
            this.lastOutputNodeType = 1;
            this.lastElementClosed = true;
            super.endElement(str, str2, str3);
        } catch (IOException e2) {
            handleException(e2);
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endEntity(String str) throws SAXException {
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.endEntity(str);
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) throws SAXException {
        super.endPrefixMapping(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String escapeAttributeEntities(java.lang.String r11) {
        /*
            r10 = this;
            org.dom4j.io.OutputFormat r0 = r10.format
            char r0 = r0.getAttributeQuoteCharacter()
            int r1 = r11.length()
            r2 = 0
            r3 = 0
            r6 = r2
            r4 = r3
            r5 = r4
        Lf:
            if (r4 >= r1) goto L83
            char r7 = r11.charAt(r4)
            r8 = 9
            if (r7 == r8) goto L69
            r8 = 10
            if (r7 == r8) goto L69
            r8 = 13
            if (r7 == r8) goto L69
            r8 = 34
            if (r7 == r8) goto L64
            r8 = 60
            if (r7 == r8) goto L61
            r8 = 62
            if (r7 == r8) goto L5e
            r8 = 38
            if (r7 == r8) goto L5b
            r8 = 39
            if (r7 == r8) goto L56
            r8 = 32
            if (r7 < r8) goto L3f
            boolean r8 = r10.shouldEncodeChar(r7)
            if (r8 == 0) goto L69
        L3f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "&#"
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = ";"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            goto L6a
        L56:
            if (r0 != r8) goto L69
            java.lang.String r7 = "&apos;"
            goto L6a
        L5b:
            java.lang.String r7 = "&amp;"
            goto L6a
        L5e:
            java.lang.String r7 = "&gt;"
            goto L6a
        L61:
            java.lang.String r7 = "&lt;"
            goto L6a
        L64:
            if (r0 != r8) goto L69
            java.lang.String r7 = "&quot;"
            goto L6a
        L69:
            r7 = r2
        L6a:
            if (r7 == 0) goto L80
            if (r6 != 0) goto L72
            char[] r6 = r11.toCharArray()
        L72:
            java.lang.StringBuffer r8 = r10.buffer
            int r9 = r4 - r5
            r8.append(r6, r5, r9)
            java.lang.StringBuffer r5 = r10.buffer
            r5.append(r7)
            int r5 = r4 + 1
        L80:
            int r4 = r4 + 1
            goto Lf
        L83:
            if (r5 != 0) goto L86
            return r11
        L86:
            if (r5 >= r1) goto L94
            if (r6 != 0) goto L8e
            char[] r6 = r11.toCharArray()
        L8e:
            java.lang.StringBuffer r11 = r10.buffer
            int r4 = r4 - r5
            r11.append(r6, r5, r4)
        L94:
            java.lang.StringBuffer r11 = r10.buffer
            java.lang.String r11 = r11.toString()
            java.lang.StringBuffer r0 = r10.buffer
            r0.setLength(r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.dom4j.io.XMLWriter.escapeAttributeEntities(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String escapeElementEntities(java.lang.String r10) {
        /*
            r9 = this;
            int r0 = r10.length()
            r1 = 0
            r2 = 0
            r5 = r1
            r3 = r2
            r4 = r3
        L9:
            if (r3 >= r0) goto L74
            char r6 = r10.charAt(r3)
            r7 = 9
            if (r6 == r7) goto L51
            r7 = 10
            if (r6 == r7) goto L51
            r7 = 13
            if (r6 == r7) goto L51
            r7 = 38
            if (r6 == r7) goto L4e
            r7 = 60
            if (r6 == r7) goto L4b
            r7 = 62
            if (r6 == r7) goto L48
            r7 = 32
            if (r6 < r7) goto L31
            boolean r7 = r9.shouldEncodeChar(r6)
            if (r7 == 0) goto L5a
        L31:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "&#"
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = ";"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            goto L5b
        L48:
            java.lang.String r6 = "&gt;"
            goto L5b
        L4b:
            java.lang.String r6 = "&lt;"
            goto L5b
        L4e:
            java.lang.String r6 = "&amp;"
            goto L5b
        L51:
            boolean r7 = r9.preserve
            if (r7 == 0) goto L5a
            java.lang.String r6 = java.lang.String.valueOf(r6)
            goto L5b
        L5a:
            r6 = r1
        L5b:
            if (r6 == 0) goto L71
            if (r5 != 0) goto L63
            char[] r5 = r10.toCharArray()
        L63:
            java.lang.StringBuffer r7 = r9.buffer
            int r8 = r3 - r4
            r7.append(r5, r4, r8)
            java.lang.StringBuffer r4 = r9.buffer
            r4.append(r6)
            int r4 = r3 + 1
        L71:
            int r3 = r3 + 1
            goto L9
        L74:
            if (r4 != 0) goto L77
            return r10
        L77:
            if (r4 >= r0) goto L85
            if (r5 != 0) goto L7f
            char[] r5 = r10.toCharArray()
        L7f:
            java.lang.StringBuffer r10 = r9.buffer
            int r3 = r3 - r4
            r10.append(r5, r4, r3)
        L85:
            java.lang.StringBuffer r10 = r9.buffer
            java.lang.String r10 = r10.toString()
            java.lang.StringBuffer r0 = r9.buffer
            r0.setLength(r2)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.dom4j.io.XMLWriter.escapeElementEntities(java.lang.String):java.lang.String");
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public LexicalHandler getLexicalHandler() {
        return this.lexicalHandler;
    }

    public int getMaximumAllowedCharacter() {
        if (this.maximumAllowedCharacter == 0) {
            this.maximumAllowedCharacter = defaultMaximumAllowedCharacter();
        }
        return this.maximumAllowedCharacter;
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.XMLReader
    public Object getProperty(String str) throws SAXNotRecognizedException, SAXNotSupportedException {
        for (String str2 : LEXICAL_HANDLER_NAMES) {
            if (str2.equals(str)) {
                return getLexicalHandler();
            }
        }
        return super.getProperty(str);
    }

    public void handleException(IOException iOException) throws SAXException {
        throw new SAXException(iOException);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        super.ignorableWhitespace(cArr, i, i2);
    }

    public void indent() throws IOException {
        String indent = this.format.getIndent();
        if (indent == null || indent.length() <= 0) {
            return;
        }
        for (int i = 0; i < this.indentLevel; i++) {
            this.writer.write(indent);
        }
    }

    public void installLexicalHandler() throws SAXNotRecognizedException, SAXNotSupportedException {
        XMLReader parent = getParent();
        if (parent == null) {
            throw new NullPointerException("No parent for filter");
        }
        for (String str : LEXICAL_HANDLER_NAMES) {
            try {
                parent.setProperty(str, this);
                return;
            } catch (SAXNotRecognizedException | SAXNotSupportedException unused) {
            }
        }
    }

    public final boolean isElementSpacePreserved(Element element) {
        Attribute attribute = element.attribute("space");
        boolean z = this.preserve;
        if (attribute != null) {
            return "xml".equals(attribute.getNamespacePrefix()) && "preserve".equals(attribute.getText());
        }
        return z;
    }

    public boolean isNamespaceDeclaration(Namespace namespace) {
        return (namespace == null || namespace == Namespace.XML_NAMESPACE || namespace.getURI() == null || this.namespaceStack.contains(namespace)) ? false : true;
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.DTDHandler
    public void notationDecl(String str, String str2, String str3) throws SAXException {
        super.notationDecl(str, str2, str3);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.XMLReader
    public void parse(InputSource inputSource) throws SAXException, IOException {
        installLexicalHandler();
        super.parse(inputSource);
    }

    public void println() throws IOException {
        this.writer.write(this.format.getLineSeparator());
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws SAXException, IOException {
        try {
            indent();
            this.writer.write("<?");
            this.writer.write(str);
            this.writer.write(MyUTIL.white_space);
            this.writer.write(str2);
            this.writer.write("?>");
            writePrintln();
            this.lastOutputNodeType = 7;
            super.processingInstruction(str, str2);
        } catch (IOException e2) {
            handleException(e2);
        }
    }

    public boolean resolveEntityRefs() {
        return this.resolveEntityRefs;
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        super.setDocumentLocator(locator);
    }

    public void setLexicalHandler(LexicalHandler lexicalHandler) {
        if (lexicalHandler == null) {
            throw new NullPointerException("Null lexical handler");
        }
        this.lexicalHandler = lexicalHandler;
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.XMLReader
    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        for (String str2 : LEXICAL_HANDLER_NAMES) {
            if (str2.equals(str)) {
                setLexicalHandler((LexicalHandler) obj);
                return;
            }
        }
        super.setProperty(str, obj);
    }

    public boolean shouldEncodeChar(char c) {
        int maximumAllowedCharacter = getMaximumAllowedCharacter();
        return maximumAllowedCharacter > 0 && c > maximumAllowedCharacter;
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startCDATA() throws SAXException, IOException {
        try {
            this.writer.write("<![CDATA[");
        } catch (IOException e2) {
            handleException(e2);
        }
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.startCDATA();
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startDTD(String str, String str2, String str3) throws SAXException {
        this.inDTD = true;
        try {
            writeDocType(str, str2, str3);
        } catch (IOException e2) {
            handleException(e2);
        }
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.startDTD(str, str2, str3);
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        try {
            writeDeclaration();
            super.startDocument();
        } catch (IOException e2) {
            handleException(e2);
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException, IOException {
        try {
            this.charsAdded = false;
            writePrintln();
            indent();
            this.writer.write("<");
            this.writer.write(str3);
            writeNamespaces();
            writeAttributes(attributes);
            this.writer.write(">");
            this.indentLevel++;
            this.lastOutputNodeType = 1;
            this.lastElementClosed = false;
            super.startElement(str, str2, str3, attributes);
        } catch (IOException e2) {
            handleException(e2);
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startEntity(String str) throws SAXException {
        try {
            writeEntityRef(str);
        } catch (IOException e2) {
            handleException(e2);
        }
        LexicalHandler lexicalHandler = this.lexicalHandler;
        if (lexicalHandler != null) {
            lexicalHandler.startEntity(str);
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) throws SAXException {
        if (this.namespacesMap == null) {
            this.namespacesMap = new HashMap();
        }
        this.namespacesMap.put(str, str2);
        super.startPrefixMapping(str, str2);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.DTDHandler
    public void unparsedEntityDecl(String str, String str2, String str3, String str4) throws SAXException {
        super.unparsedEntityDecl(str, str2, str3, str4);
    }

    public void write(Document document) throws IndexOutOfBoundsException, IOException {
        writeDeclaration();
        if (document.getDocType() != null) {
            indent();
            writeDocType(document.getDocType());
        }
        int iNodeCount = document.nodeCount();
        for (int i = 0; i < iNodeCount; i++) {
            writeNode(document.node(i));
        }
        writePrintln();
        if (this.autoFlush) {
            flush();
        }
    }

    public void writeAttribute(Attribute attribute) throws IOException {
        this.writer.write(MyUTIL.white_space);
        this.writer.write(attribute.getQualifiedName());
        this.writer.write("=");
        char attributeQuoteCharacter = this.format.getAttributeQuoteCharacter();
        this.writer.write(attributeQuoteCharacter);
        writeEscapeAttributeEntities(attribute.getValue());
        this.writer.write(attributeQuoteCharacter);
        this.lastOutputNodeType = 2;
    }

    public void writeAttributes(Element element) throws IOException {
        int iAttributeCount = element.attributeCount();
        for (int i = 0; i < iAttributeCount; i++) {
            Attribute attribute = element.attribute(i);
            Namespace namespace = attribute.getNamespace();
            if (namespace != null && namespace != Namespace.NO_NAMESPACE && namespace != Namespace.XML_NAMESPACE) {
                if (!namespace.getURI().equals(this.namespaceStack.getURI(namespace.getPrefix()))) {
                    writeNamespace(namespace);
                    this.namespaceStack.push(namespace);
                }
            }
            String name = attribute.getName();
            if (name.startsWith("xmlns:")) {
                String strSubstring = name.substring(6);
                if (this.namespaceStack.getNamespaceForPrefix(strSubstring) == null) {
                    String value = attribute.getValue();
                    this.namespaceStack.push(strSubstring, value);
                    writeNamespace(strSubstring, value);
                }
            } else if (!name.equals("xmlns")) {
                char attributeQuoteCharacter = this.format.getAttributeQuoteCharacter();
                this.writer.write(MyUTIL.white_space);
                this.writer.write(attribute.getQualifiedName());
                this.writer.write("=");
                this.writer.write(attributeQuoteCharacter);
                writeEscapeAttributeEntities(attribute.getValue());
                this.writer.write(attributeQuoteCharacter);
            } else if (this.namespaceStack.getDefaultNamespace() == null) {
                String value2 = attribute.getValue();
                this.namespaceStack.push(null, value2);
                writeNamespace(null, value2);
            }
        }
    }

    public void writeCDATA(String str) throws IOException {
        this.writer.write("<![CDATA[");
        if (str != null) {
            this.writer.write(str);
        }
        this.writer.write("]]>");
        this.lastOutputNodeType = 4;
    }

    public void writeClose(String str) throws IOException {
        this.writer.write("</");
        this.writer.write(str);
        this.writer.write(">");
    }

    public void writeComment(String str) throws IOException {
        if (this.format.isNewlines()) {
            println();
            indent();
        }
        this.writer.write("<!--");
        this.writer.write(str);
        this.writer.write("-->");
        this.lastOutputNodeType = 8;
    }

    public void writeDeclaration() throws IOException {
        String encoding = this.format.getEncoding();
        if (this.format.isSuppressDeclaration()) {
            return;
        }
        if (encoding.equals("UTF8")) {
            this.writer.write("<?xml version=\"1.0\"");
            if (!this.format.isOmitEncoding()) {
                this.writer.write(" encoding=\"UTF-8\"");
            }
            this.writer.write("?>");
        } else {
            this.writer.write("<?xml version=\"1.0\"");
            if (!this.format.isOmitEncoding()) {
                this.writer.write(" encoding=\"" + encoding + "\"");
            }
            this.writer.write("?>");
        }
        if (this.format.isNewLineAfterDeclaration()) {
            println();
        }
    }

    public void writeDocType(DocumentType documentType) throws IOException {
        if (documentType != null) {
            documentType.write(this.writer);
            writePrintln();
        }
    }

    public void writeElement(Element element) throws IndexOutOfBoundsException, IOException {
        int iNodeCount = element.nodeCount();
        String qualifiedName = element.getQualifiedName();
        writePrintln();
        indent();
        this.writer.write("<");
        this.writer.write(qualifiedName);
        int size = this.namespaceStack.size();
        Namespace namespace = element.getNamespace();
        if (isNamespaceDeclaration(namespace)) {
            this.namespaceStack.push(namespace);
            writeNamespace(namespace);
        }
        boolean z = true;
        for (int i = 0; i < iNodeCount; i++) {
            Node node = element.node(i);
            if (node instanceof Namespace) {
                Namespace namespace2 = (Namespace) node;
                if (isNamespaceDeclaration(namespace2)) {
                    this.namespaceStack.push(namespace2);
                    writeNamespace(namespace2);
                }
            } else if ((node instanceof Element) || (node instanceof Comment)) {
                z = false;
            }
        }
        writeAttributes(element);
        this.lastOutputNodeType = 1;
        if (iNodeCount <= 0) {
            writeEmptyElementClose(qualifiedName);
        } else {
            this.writer.write(">");
            if (z) {
                writeElementContent(element);
            } else {
                this.indentLevel++;
                writeElementContent(element);
                this.indentLevel--;
                writePrintln();
                indent();
            }
            this.writer.write("</");
            this.writer.write(qualifiedName);
            this.writer.write(">");
        }
        while (this.namespaceStack.size() > size) {
            this.namespaceStack.pop();
        }
        this.lastOutputNodeType = 1;
    }

    public void writeElementContent(Element element) throws IOException {
        char cCharAt;
        boolean zIsTrimText = this.format.isTrimText();
        boolean z = this.preserve;
        if (zIsTrimText) {
            boolean zIsElementSpacePreserved = isElementSpacePreserved(element);
            this.preserve = zIsElementSpacePreserved;
            zIsTrimText = !zIsElementSpacePreserved;
        }
        if (!zIsTrimText) {
            loop1: while (true) {
                Node node = null;
                for (Node node2 : element.content()) {
                    if (node2 instanceof Text) {
                        writeNode(node2);
                        node = node2;
                    } else {
                        if (node != null && this.format.isPadText()) {
                            String text = node.getText();
                            if (Character.isWhitespace(text.charAt(text.length() - 1))) {
                                this.writer.write(MyUTIL.white_space);
                            }
                        }
                        writeNode(node2);
                    }
                }
                break loop1;
            }
        } else {
            boolean z2 = true;
            Text text2 = null;
            StringBuilder sb = null;
            for (Node node3 : element.content()) {
                if (!(node3 instanceof Text)) {
                    if (!z2 && this.format.isPadText()) {
                        char cCharAt2 = 'a';
                        if (sb != null) {
                            cCharAt2 = sb.charAt(0);
                        } else if (text2 != null) {
                            cCharAt2 = text2.getText().charAt(0);
                        }
                        if (Character.isWhitespace(cCharAt2)) {
                            this.writer.write(MyUTIL.white_space);
                        }
                    }
                    if (text2 != null) {
                        if (sb != null) {
                            writeString(sb.toString());
                            sb = null;
                        } else {
                            writeString(text2.getText());
                        }
                        if (this.format.isPadText()) {
                            if (sb != null) {
                                cCharAt = sb.charAt(sb.length() - 1);
                            } else {
                                String text3 = text2.getText();
                                cCharAt = text3.charAt(text3.length() - 1);
                            }
                            if (Character.isWhitespace(cCharAt)) {
                                this.writer.write(MyUTIL.white_space);
                            }
                        }
                        text2 = null;
                    }
                    writeNode(node3);
                    z2 = false;
                } else if (text2 == null) {
                    text2 = (Text) node3;
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(text2.getText());
                    }
                    sb.append(node3.getText());
                }
            }
            if (text2 != null) {
                if (!z2 && this.format.isPadText()) {
                    if (Character.isWhitespace(sb != null ? sb.charAt(0) : text2.getText().charAt(0))) {
                        this.writer.write(MyUTIL.white_space);
                    }
                }
                if (sb != null) {
                    writeString(sb.toString());
                } else {
                    writeString(text2.getText());
                }
            }
        }
        this.preserve = z;
    }

    public void writeEmptyElementClose(String str) throws IOException {
        if (!this.format.isExpandEmptyElements()) {
            this.writer.write("/>");
            return;
        }
        this.writer.write("></");
        this.writer.write(str);
        this.writer.write(">");
    }

    public void writeEntity(Entity entity) throws IOException {
        if (resolveEntityRefs()) {
            this.writer.write(entity.getText());
        } else {
            writeEntityRef(entity.getName());
        }
    }

    public void writeEntityRef(String str) throws IOException {
        this.writer.write("&");
        this.writer.write(str);
        this.writer.write(";");
        this.lastOutputNodeType = 5;
    }

    public void writeEscapeAttributeEntities(String str) throws IOException {
        if (str != null) {
            this.writer.write(escapeAttributeEntities(str));
        }
    }

    public void writeNamespace(Namespace namespace) throws IOException {
        if (namespace != null) {
            writeNamespace(namespace.getPrefix(), namespace.getURI());
        }
    }

    public void writeNamespaces() throws IOException {
        Map<String, String> map = this.namespacesMap;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writeNamespace(entry.getKey(), entry.getValue());
            }
            this.namespacesMap = null;
        }
    }

    public void writeNode(Node node) throws IndexOutOfBoundsException, IOException {
        switch (node.getNodeType()) {
            case 1:
                writeElement((Element) node);
                return;
            case 2:
                writeAttribute((Attribute) node);
                return;
            case 3:
                writeNodeText(node);
                return;
            case 4:
                writeCDATA(node.getText());
                return;
            case 5:
                writeEntity((Entity) node);
                return;
            case 6:
            case 11:
            case 12:
            default:
                throw new IOException("Invalid node type: " + node);
            case 7:
                writeProcessingInstruction((ProcessingInstruction) node);
                return;
            case 8:
                writeComment(node.getText());
                return;
            case 9:
                write((Document) node);
                return;
            case 10:
                writeDocType((DocumentType) node);
                return;
            case 13:
                return;
        }
    }

    public void writeNodeText(Node node) throws IOException {
        String text = node.getText();
        if (text == null || text.length() <= 0) {
            return;
        }
        if (this.escapeText) {
            text = escapeElementEntities(text);
        }
        this.lastOutputNodeType = 3;
        this.writer.write(text);
    }

    public void writePrintln() throws IOException {
        if (this.format.isNewlines()) {
            this.writer.write(this.format.getLineSeparator());
        }
    }

    public void writeProcessingInstruction(ProcessingInstruction processingInstruction) throws IOException {
        this.writer.write("<?");
        this.writer.write(processingInstruction.getName());
        this.writer.write(MyUTIL.white_space);
        this.writer.write(processingInstruction.getText());
        this.writer.write("?>");
        writePrintln();
        this.lastOutputNodeType = 7;
    }

    public void writeString(String str) throws IOException {
        if (str == null || str.length() <= 0) {
            return;
        }
        if (this.escapeText) {
            str = escapeElementEntities(str);
        }
        if (!this.format.isTrimText()) {
            this.lastOutputNodeType = 3;
            this.writer.write(str);
            return;
        }
        boolean z = true;
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (z) {
                z = false;
                if (this.lastOutputNodeType == 3) {
                    this.writer.write(MyUTIL.white_space);
                }
            } else {
                this.writer.write(MyUTIL.white_space);
            }
            this.writer.write(strNextToken);
            this.lastOutputNodeType = 3;
        }
    }

    public void writeNamespace(String str, String str2) throws IOException {
        if (str == null || str.length() <= 0) {
            this.writer.write(" xmlns=\"");
        } else {
            this.writer.write(" xmlns:");
            this.writer.write(str);
            this.writer.write("=\"");
        }
        this.writer.write(str2);
        this.writer.write("\"");
    }

    public void writeDocType(String str, String str2, String str3) throws IOException {
        boolean z;
        this.writer.write("<!DOCTYPE ");
        this.writer.write(str);
        if (str2 == null || str2.equals("")) {
            z = false;
        } else {
            this.writer.write(" PUBLIC \"");
            this.writer.write(str2);
            this.writer.write("\"");
            z = true;
        }
        if (str3 != null && !str3.equals("")) {
            if (!z) {
                this.writer.write(" SYSTEM");
            }
            this.writer.write(" \"");
            this.writer.write(str3);
            this.writer.write("\"");
        }
        this.writer.write(">");
        writePrintln();
    }

    public void writeAttribute(Attributes attributes, int i) throws IOException {
        char attributeQuoteCharacter = this.format.getAttributeQuoteCharacter();
        this.writer.write(MyUTIL.white_space);
        this.writer.write(attributes.getQName(i));
        this.writer.write("=");
        this.writer.write(attributeQuoteCharacter);
        writeEscapeAttributeEntities(attributes.getValue(i));
        this.writer.write(attributeQuoteCharacter);
    }

    public void writeAttributes(Attributes attributes) throws IOException {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            writeAttribute(attributes, i);
        }
    }
}
