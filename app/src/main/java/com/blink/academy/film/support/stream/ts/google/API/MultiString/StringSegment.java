package com.blink.academy.film.support.stream.ts.google.API.MultiString;

import com.blink.academy.film.support.stream.ts.google.Core.ByteRepresentation;
import com.blink.academy.film.support.stream.ts.google.Core.XMLRepresentation;

/* loaded from: classes.dex */
public interface StringSegment extends ByteRepresentation, XMLRepresentation {
    byte[] getCompressedStringByte();

    int getCompressedStringNumberBytes();

    int getCompressionType();

    int getMode();

    void setCompressedStringByte(byte[] bArr);

    void setCompressionType(int i);

    void setMode(int i);
}
