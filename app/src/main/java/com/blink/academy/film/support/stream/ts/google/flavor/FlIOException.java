package com.blink.academy.film.support.stream.ts.google.flavor;

import java.io.IOException;

/* loaded from: classes.dex */
public class FlIOException extends IOException {
    public static int ENDOFDATA = 0;
    public static int FILEOPENFAILED = 4;
    public static int INVALIDALIGNMENT = 1;
    public static int INVALIDBITSIZE = 7;
    public static int INVALIDIOTYPE = 6;
    public static int NOTENOUGHDATA = 8;
    private static int NUMBER_OF_EXCEPTION_TYPE = 10;
    public static int READFAILED = 2;
    public static int SYSTEMIOFAILED = 5;
    public static int UNKNOWN = 9;
    public static int WRITEFAILED = 3;
    private static String[] errormsg = {"End of Data", "Invalid Alignment", "Read I/O Failed", "Write I/O Failed", "File Open Failed", "System I/O Error", "Invalid Input Type", "Invalid bit size", "Not enough data", "Unknown Error"};
    private int reason;
    private String system_error_msg;

    public FlIOException() {
        this.reason = UNKNOWN;
        this.system_error_msg = "";
    }

    @Override // java.lang.Throwable
    public String toString() {
        if (this.reason != SYSTEMIOFAILED) {
            return super.toString();
        }
        return super.toString() + "\n" + this.system_error_msg;
    }

    public FlIOException(String str) {
        super(str);
        this.reason = UNKNOWN;
        this.system_error_msg = "";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FlIOException(int i) {
        String[] strArr = errormsg;
        int i2 = NUMBER_OF_EXCEPTION_TYPE;
        super(strArr[i >= i2 ? i2 - 1 : i]);
        this.reason = UNKNOWN;
        this.system_error_msg = "";
        int i3 = NUMBER_OF_EXCEPTION_TYPE;
        this.reason = i >= i3 ? i3 - 1 : i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FlIOException(int i, String str) {
        String[] strArr = errormsg;
        int i2 = NUMBER_OF_EXCEPTION_TYPE;
        super(strArr[i > i2 ? i2 - 1 : i]);
        this.reason = UNKNOWN;
        this.system_error_msg = "";
        int i3 = NUMBER_OF_EXCEPTION_TYPE;
        this.reason = i >= i3 ? i3 - 1 : i;
        this.system_error_msg = str;
    }
}
