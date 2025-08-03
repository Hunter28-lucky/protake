package com.blink.academy.film.support.stream.ts.google.flavor;

/* loaded from: classes.dex */
public class MapResult {
    public int _code;
    public double _dout;
    public float _fout;
    public boolean _hit;
    public int _iout;
    public int _length;
    public Object _o;

    public MapResult(boolean z, int i, int i2) {
        this._hit = z;
        this._code = i;
        this._length = i2;
    }

    public int getCode() {
        return this._code;
    }

    public int getCodeLength() {
        return this._length;
    }

    public boolean isHit() {
        return this._hit;
    }

    public MapResult(boolean z, int i, int i2, int i3) {
        this(z, i, i2);
        this._iout = i3;
    }

    public MapResult(boolean z, int i, int i2, float f) {
        this(z, i, i2);
        this._fout = f;
    }

    public MapResult(boolean z, int i, int i2, double d) {
        this(z, i, i2);
        this._dout = d;
    }

    public MapResult(boolean z, int i, int i2, Object obj) {
        this(z, i, i2);
        this._o = obj;
    }
}
