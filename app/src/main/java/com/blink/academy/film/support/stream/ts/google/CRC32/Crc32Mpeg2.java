package com.blink.academy.film.support.stream.ts.google.CRC32;

/* loaded from: classes.dex */
public class Crc32Mpeg2 extends Cksum {
    @Override // com.blink.academy.film.support.stream.ts.google.CRC32.Cksum, com.blink.academy.film.support.stream.ts.google.CRC32.AbstractChecksum, java.util.zip.Checksum
    public long getValue() {
        return ((Cksum) this).value & 4294967295L;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.CRC32.Cksum, com.blink.academy.film.support.stream.ts.google.CRC32.AbstractChecksum, java.util.zip.Checksum
    public void reset() {
        ((Cksum) this).value = -1;
        this.length = 0L;
    }
}
