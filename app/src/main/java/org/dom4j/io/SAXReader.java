package org.dom4j.io;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes2.dex */
public class SAXReader {
    private DispatchHandler dispatchHandler;
    private EntityResolver entityResolver;
    private ErrorHandler errorHandler;
    private DocumentFactory factory;
    private boolean validating;
    private XMLFilter xmlFilter;
    private XMLReader xmlReader;
    private boolean stringInternEnabled = true;
    private boolean includeInternalDTDDeclarations = false;
    private boolean includeExternalDTDDeclarations = false;
    private boolean mergeAdjacentText = false;
    private boolean stripWhitespaceText = false;
    private boolean ignoreComments = false;
    private String encoding = null;

    public static class SAXEntityResolver implements EntityResolver, Serializable {
        public String uriPrefix;

        public SAXEntityResolver(String str) {
            this.uriPrefix = str;
        }

        @Override // org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) {
            if (str2 != null && str2.length() > 0 && this.uriPrefix != null && str2.indexOf(58) <= 0) {
                str2 = this.uriPrefix + str2;
            }
            return new InputSource(str2);
        }
    }

    public void configureReader(XMLReader xMLReader, DefaultHandler defaultHandler) throws SAXNotRecognizedException, SAXNotSupportedException, DocumentException {
        SAXHelper.setParserProperty(xMLReader, "http://xml.org/sax/handlers/LexicalHandler", defaultHandler);
        SAXHelper.setParserProperty(xMLReader, "http://xml.org/sax/properties/lexical-handler", defaultHandler);
        if (this.includeInternalDTDDeclarations || this.includeExternalDTDDeclarations) {
            SAXHelper.setParserProperty(xMLReader, "http://xml.org/sax/properties/declaration-handler", defaultHandler);
        }
        SAXHelper.setParserFeature(xMLReader, "http://xml.org/sax/features/namespaces", true);
        SAXHelper.setParserFeature(xMLReader, "http://xml.org/sax/features/namespace-prefixes", false);
        SAXHelper.setParserFeature(xMLReader, "http://xml.org/sax/features/string-interning", isStringInternEnabled());
        SAXHelper.setParserFeature(xMLReader, "http://xml.org/sax/features/use-locator2", true);
        try {
            xMLReader.setFeature("http://xml.org/sax/features/validation", isValidating());
            ErrorHandler errorHandler = this.errorHandler;
            if (errorHandler != null) {
                xMLReader.setErrorHandler(errorHandler);
            } else {
                xMLReader.setErrorHandler(defaultHandler);
            }
        } catch (Exception e2) {
            if (isValidating()) {
                throw new DocumentException("Validation not supported for XMLReader: " + xMLReader, e2);
            }
        }
    }

    public SAXContentHandler createContentHandler(XMLReader xMLReader) {
        return new SAXContentHandler(getDocumentFactory(), this.dispatchHandler);
    }

    public EntityResolver createDefaultEntityResolver(String str) {
        int iLastIndexOf;
        return new SAXEntityResolver((str == null || str.length() <= 0 || (iLastIndexOf = str.lastIndexOf(47)) <= 0) ? null : str.substring(0, iLastIndexOf + 1));
    }

    public XMLReader createXMLReader() throws SAXException {
        return SAXHelper.createXMLReader(isValidating());
    }

    public DocumentFactory getDocumentFactory() {
        if (this.factory == null) {
            this.factory = DocumentFactory.getInstance();
        }
        return this.factory;
    }

    public XMLFilter getXMLFilter() {
        return this.xmlFilter;
    }

    public XMLReader getXMLReader() throws SAXException {
        if (this.xmlReader == null) {
            this.xmlReader = createXMLReader();
        }
        return this.xmlReader;
    }

    public XMLReader installXMLFilter(XMLReader xMLReader) {
        XMLFilter xMLFilter = getXMLFilter();
        if (xMLFilter == null) {
            return xMLReader;
        }
        XMLFilter xMLFilter2 = xMLFilter;
        while (true) {
            XMLReader parent = xMLFilter2.getParent();
            if (!(parent instanceof XMLFilter)) {
                xMLFilter2.setParent(xMLReader);
                return xMLFilter;
            }
            xMLFilter2 = (XMLFilter) parent;
        }
    }

    public boolean isIgnoreComments() {
        return this.ignoreComments;
    }

    public boolean isIncludeExternalDTDDeclarations() {
        return this.includeExternalDTDDeclarations;
    }

    public boolean isIncludeInternalDTDDeclarations() {
        return this.includeInternalDTDDeclarations;
    }

    public boolean isMergeAdjacentText() {
        return this.mergeAdjacentText;
    }

    public boolean isStringInternEnabled() {
        return this.stringInternEnabled;
    }

    public boolean isStripWhitespaceText() {
        return this.stripWhitespaceText;
    }

    public boolean isValidating() {
        return this.validating;
    }

    public Document read(Reader reader) throws DocumentException {
        InputSource inputSource = new InputSource(reader);
        String str = this.encoding;
        if (str != null) {
            inputSource.setEncoding(str);
        }
        return read(inputSource);
    }

    public Document read(InputSource inputSource) throws DocumentException, SAXException, IOException {
        try {
            XMLReader xMLReaderInstallXMLFilter = installXMLFilter(getXMLReader());
            EntityResolver entityResolverCreateDefaultEntityResolver = this.entityResolver;
            if (entityResolverCreateDefaultEntityResolver == null) {
                entityResolverCreateDefaultEntityResolver = createDefaultEntityResolver(inputSource.getSystemId());
                this.entityResolver = entityResolverCreateDefaultEntityResolver;
            }
            xMLReaderInstallXMLFilter.setEntityResolver(entityResolverCreateDefaultEntityResolver);
            SAXContentHandler sAXContentHandlerCreateContentHandler = createContentHandler(xMLReaderInstallXMLFilter);
            sAXContentHandlerCreateContentHandler.setEntityResolver(entityResolverCreateDefaultEntityResolver);
            sAXContentHandlerCreateContentHandler.setInputSource(inputSource);
            boolean zIsIncludeInternalDTDDeclarations = isIncludeInternalDTDDeclarations();
            boolean zIsIncludeExternalDTDDeclarations = isIncludeExternalDTDDeclarations();
            sAXContentHandlerCreateContentHandler.setIncludeInternalDTDDeclarations(zIsIncludeInternalDTDDeclarations);
            sAXContentHandlerCreateContentHandler.setIncludeExternalDTDDeclarations(zIsIncludeExternalDTDDeclarations);
            sAXContentHandlerCreateContentHandler.setMergeAdjacentText(isMergeAdjacentText());
            sAXContentHandlerCreateContentHandler.setStripWhitespaceText(isStripWhitespaceText());
            sAXContentHandlerCreateContentHandler.setIgnoreComments(isIgnoreComments());
            xMLReaderInstallXMLFilter.setContentHandler(sAXContentHandlerCreateContentHandler);
            configureReader(xMLReaderInstallXMLFilter, sAXContentHandlerCreateContentHandler);
            xMLReaderInstallXMLFilter.parse(inputSource);
            return sAXContentHandlerCreateContentHandler.getDocument();
        } catch (Exception e2) {
            if (e2 instanceof SAXParseException) {
                SAXParseException sAXParseException = (SAXParseException) e2;
                String systemId = sAXParseException.getSystemId();
                if (systemId == null) {
                    systemId = "";
                }
                throw new DocumentException("Error on line " + sAXParseException.getLineNumber() + " of document " + systemId + " : " + sAXParseException.getMessage(), e2);
            }
            throw new DocumentException(e2.getMessage(), e2);
        }
    }
}
