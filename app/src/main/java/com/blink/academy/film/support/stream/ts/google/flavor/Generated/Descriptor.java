package com.blink.academy.film.support.stream.ts.google.flavor.Generated;

import com.blink.academy.film.support.stream.ts.google.flavor.IBitstream;
import com.blink.academy.film.support.stream.ts.google.flavor.Util;
import java.io.IOException;

/* loaded from: classes.dex */
public class Descriptor {
    public int _F_lengthof;

    public int get(IBitstream iBitstream) throws IOException {
        Util.trace(iBitstream.getpos(), 0, 0, "begin Descriptor");
        this._F_lengthof = iBitstream.getpos();
        this._F_lengthof = iBitstream.getpos() - this._F_lengthof;
        Util.trace(iBitstream.getpos(), 0, 0, "end Descriptor");
        return 0;
    }

    public int put(IBitstream iBitstream) throws IOException {
        this._F_lengthof = iBitstream.getpos();
        this._F_lengthof = iBitstream.getpos() - this._F_lengthof;
        return 0;
    }

    public int putxml(IBitstream iBitstream, boolean z) throws IOException {
        this._F_lengthof = iBitstream.getpos();
        this._F_lengthof = iBitstream.getpos() - this._F_lengthof;
        return 0;
    }
}
