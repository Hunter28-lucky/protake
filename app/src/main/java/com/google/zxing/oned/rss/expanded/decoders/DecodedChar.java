package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes2.dex */
final class DecodedChar extends DecodedObject {
    public static final char FNC1 = '$';
    private final char value;

    public DecodedChar(int i, char c) {
        super(i);
        this.value = c;
    }

    public char getValue() {
        return this.value;
    }

    public boolean isFNC1() {
        return this.value == '$';
    }
}
