package com.blink.academy.film.support.stream.ts.google.flavor;

/* loaded from: classes.dex */
public interface IBitstream {
    public static final int BS_INPUT = 0;
    public static final int BS_OUTPUT = 1;

    int align(int i) throws FlIOException;

    boolean atend();

    int getbits(int i) throws FlIOException;

    double getdouble() throws FlIOException;

    float getfloat() throws FlIOException;

    long getlong(int i) throws FlIOException;

    int getmode();

    int getpos();

    int little_getbits(int i) throws FlIOException;

    double little_getdouble() throws FlIOException;

    float little_getfloat() throws FlIOException;

    long little_getlong(int i) throws FlIOException;

    int little_nextbits(int i) throws FlIOException;

    double little_nextdouble() throws FlIOException;

    float little_nextfloat() throws FlIOException;

    long little_nextlong(int i) throws FlIOException;

    int little_putbits(int i, int i2) throws FlIOException;

    double little_putdouble(double d) throws FlIOException;

    float little_putfloat(float f) throws FlIOException;

    long little_putlong(long j, int i) throws FlIOException;

    int little_sgetbits(int i) throws FlIOException;

    long little_sgetlong(int i) throws FlIOException;

    int little_snextbits(int i) throws FlIOException;

    long little_snextlong(int i) throws FlIOException;

    int next(int i, int i2, int i3, int i4) throws FlIOException;

    int nextbits(int i) throws FlIOException;

    int nextcode(int i, int i2, int i3) throws FlIOException;

    double nextdouble() throws FlIOException;

    float nextfloat() throws FlIOException;

    long nextlong(int i) throws FlIOException;

    int putbits(int i, int i2) throws FlIOException;

    double putdouble(double d) throws FlIOException;

    float putfloat(float f) throws FlIOException;

    long putlong(long j, int i) throws FlIOException;

    int sgetbits(int i) throws FlIOException;

    long sgetlong(int i) throws FlIOException;

    void skipbits(int i) throws FlIOException;

    int snextbits(int i) throws FlIOException;

    long snextlong(int i) throws FlIOException;
}
