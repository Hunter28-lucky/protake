package net.sourceforge.jaad.aac;

import java.io.IOException;

/* loaded from: classes2.dex */
public class AACException extends IOException {
    private boolean eos;

    public AACException(String str) {
        super(str);
    }

    public static AACException endOfStream() {
        AACException aACException = new AACException("end of stream");
        aACException.eos = true;
        return aACException;
    }

    public static AACException wrap(Exception exc) {
        if (exc != null && (exc instanceof AACException)) {
            return (AACException) exc;
        }
        if (exc != null && exc.getMessage() != null) {
            return new AACException(exc.getMessage());
        }
        return new AACException("" + exc);
    }

    public boolean isEndOfStream() {
        return this.eos;
    }
}
