package org.dom4j.io;

import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class OutputFormat implements Cloneable {
    private char attributeQuoteChar;
    private boolean doXHTML;
    private String encoding;
    private boolean expandEmptyElements;
    private String indent;
    private String lineSeparator;
    private boolean newLineAfterDeclaration;
    private int newLineAfterNTags;
    private boolean newlines;
    private boolean omitEncoding;
    private boolean padText;
    private boolean suppressDeclaration;
    private boolean trimText;

    public OutputFormat() {
        this.suppressDeclaration = false;
        this.newLineAfterDeclaration = true;
        this.encoding = Platform.UTF_8;
        this.omitEncoding = false;
        this.indent = null;
        this.expandEmptyElements = false;
        this.newlines = false;
        this.lineSeparator = "\n";
        this.trimText = false;
        this.padText = false;
        this.doXHTML = false;
        this.newLineAfterNTags = 0;
        this.attributeQuoteChar = '\"';
    }

    public char getAttributeQuoteCharacter() {
        return this.attributeQuoteChar;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public String getIndent() {
        return this.indent;
    }

    public String getLineSeparator() {
        return this.lineSeparator;
    }

    public boolean isExpandEmptyElements() {
        return this.expandEmptyElements;
    }

    public boolean isNewLineAfterDeclaration() {
        return this.newLineAfterDeclaration;
    }

    public boolean isNewlines() {
        return this.newlines;
    }

    public boolean isOmitEncoding() {
        return this.omitEncoding;
    }

    public boolean isPadText() {
        return this.padText;
    }

    public boolean isSuppressDeclaration() {
        return this.suppressDeclaration;
    }

    public boolean isTrimText() {
        return this.trimText;
    }

    public OutputFormat(String str, boolean z) {
        this.suppressDeclaration = false;
        this.newLineAfterDeclaration = true;
        this.encoding = Platform.UTF_8;
        this.omitEncoding = false;
        this.expandEmptyElements = false;
        this.lineSeparator = "\n";
        this.trimText = false;
        this.padText = false;
        this.doXHTML = false;
        this.newLineAfterNTags = 0;
        this.attributeQuoteChar = '\"';
        this.indent = str;
        this.newlines = z;
    }
}
