package net.sourceforge.jaad.aac.syntax;

import net.sourceforge.jaad.aac.AACException;

/* loaded from: classes2.dex */
public interface IBitStream {
    void byteAlign() throws AACException;

    void destroy();

    int getBitsLeft();

    int getPosition();

    int maskBits(int i);

    int peekBit() throws AACException;

    int peekBits(int i) throws AACException;

    int readBit() throws AACException;

    int readBits(int i) throws AACException;

    boolean readBool() throws AACException;

    void reset();

    void setData(byte[] bArr);

    void skipBit() throws AACException;

    void skipBits(int i) throws AACException;
}
