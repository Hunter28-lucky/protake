package org.jcodec.codecs.h264.io.model;

import com.blink.academy.film.support.socket.TransmitHelper;

/* loaded from: classes2.dex */
public final class SliceType {
    private String _name;
    private int _ordinal;
    private static final SliceType[] _values = new SliceType[5];
    public static final SliceType P = new SliceType("P", 0);
    public static final SliceType B = new SliceType(TransmitHelper.CAMERA_UNIT_B_CONTENT, 1);
    public static final SliceType I = new SliceType("I", 2);
    public static final SliceType SP = new SliceType("SP", 3);
    public static final SliceType SI = new SliceType("SI", 4);

    private SliceType(String str, int i) {
        this._name = str;
        this._ordinal = i;
        _values[i] = this;
    }

    public static SliceType fromValue(int i) {
        return values()[i];
    }

    public static SliceType[] values() {
        return _values;
    }

    public boolean isInter() {
        return (this == I || this == SI) ? false : true;
    }

    public boolean isIntra() {
        return this == I || this == SI;
    }

    public String name() {
        return this._name;
    }

    public int ordinal() {
        return this._ordinal;
    }

    public String toString() {
        return this._name;
    }
}
