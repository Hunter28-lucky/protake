package org.jcodec.common.model;

import com.xiaomi.mipush.sdk.Constants;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class Rational {
    public final int den;
    public final int num;
    public static final Rational ONE = new Rational(1, 1);
    public static final Rational HALF = new Rational(1, 2);
    public static final Rational ZERO = new Rational(0, 1);

    public Rational(int i, int i2) {
        this.num = i;
        this.den = i2;
    }

    public static Rational R(int i, int i2) {
        return new Rational(i, i2);
    }

    public static Rational R1(int i) {
        return R(i, 1);
    }

    public static Rational parse(String str) {
        int iIndexOf = str.indexOf(Constants.COLON_SEPARATOR);
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf("/");
        }
        if (iIndexOf <= 0) {
            return R(Integer.parseInt(str), 1);
        }
        return new Rational(Integer.parseInt(str.substring(0, iIndexOf)), Integer.parseInt(str.substring(iIndexOf + 1)));
    }

    public static Rational parseRational(String str) {
        return parse(str);
    }

    public static Rational reduce(int i, int i2) {
        int iGcd = MathUtil.gcd(i, i2);
        return new Rational(i / iGcd, i2 / iGcd);
    }

    public static Rational reduceRational(Rational rational) {
        return reduce(rational.getNum(), rational.getDen());
    }

    public Rational divide(Rational rational) {
        return reduce(rational.num * this.den, rational.den * this.num);
    }

    public Rational divideBy(Rational rational) {
        return reduce(this.num * rational.den, this.den * rational.num);
    }

    public Rational divideByInt(int i) {
        return new Rational(this.num, this.den * i);
    }

    public RationalLarge divideByLarge(RationalLarge rationalLarge) {
        return RationalLarge.reduceLong(this.num * rationalLarge.den, this.den * rationalLarge.num);
    }

    public int divideByS(int i) {
        return this.num / (this.den * i);
    }

    public Rational divideInt(int i) {
        return new Rational(this.den * i, this.num);
    }

    public RationalLarge divideLarge(RationalLarge rationalLarge) {
        return RationalLarge.reduceLong(rationalLarge.num * this.den, rationalLarge.den * this.num);
    }

    public long divideLong(long j) {
        return (this.den * j) / this.num;
    }

    public int divideS(int i) {
        return (int) ((this.den * i) / this.num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rational rational = (Rational) obj;
        return this.den == rational.den && this.num == rational.num;
    }

    public boolean equalsRational(Rational rational) {
        return this.num * rational.den == rational.num * this.den;
    }

    public Rational flip() {
        return new Rational(this.den, this.num);
    }

    public int getDen() {
        return this.den;
    }

    public int getNum() {
        return this.num;
    }

    public boolean greaterOrEqualTo(Rational rational) {
        return this.num * rational.den >= rational.num * this.den;
    }

    public boolean greaterThen(Rational rational) {
        return this.num * rational.den > rational.num * this.den;
    }

    public int hashCode() {
        return ((this.den + 31) * 31) + this.num;
    }

    public Rational minus(Rational rational) {
        int i = this.num;
        int i2 = rational.den;
        int i3 = rational.num;
        int i4 = this.den;
        return reduce((i * i2) - (i3 * i4), i4 * i2);
    }

    public Rational minusInt(int i) {
        int i2 = this.num;
        int i3 = this.den;
        return new Rational(i2 - (i * i3), i3);
    }

    public RationalLarge minusLarge(RationalLarge rationalLarge) {
        long j = this.num;
        long j2 = rationalLarge.den;
        long j3 = rationalLarge.num;
        int i = this.den;
        return RationalLarge.reduceLong((j * j2) - (j3 * i), i * j2);
    }

    public Rational multiply(Rational rational) {
        return reduce(this.num * rational.num, this.den * rational.den);
    }

    public Rational multiplyInt(int i) {
        return new Rational(this.num * i, this.den);
    }

    public RationalLarge multiplyLarge(RationalLarge rationalLarge) {
        return RationalLarge.reduceLong(this.num * rationalLarge.num, this.den * rationalLarge.den);
    }

    public long multiplyLong(long j) {
        return (this.num * j) / this.den;
    }

    public int multiplyS(int i) {
        return (int) ((this.num * i) / this.den);
    }

    public Rational plus(Rational rational) {
        int i = this.num;
        int i2 = rational.den;
        int i3 = rational.num;
        int i4 = this.den;
        return reduce((i * i2) + (i3 * i4), i4 * i2);
    }

    public Rational plusInt(int i) {
        int i2 = this.num;
        int i3 = this.den;
        return new Rational(i2 + (i * i3), i3);
    }

    public RationalLarge plusLarge(RationalLarge rationalLarge) {
        long j = this.num;
        long j2 = rationalLarge.den;
        long j3 = rationalLarge.num;
        int i = this.den;
        return RationalLarge.reduceLong((j * j2) + (j3 * i), i * j2);
    }

    public float scalar() {
        return this.num / this.den;
    }

    public int scalarClip() {
        return this.num / this.den;
    }

    public boolean smallerOrEqualTo(Rational rational) {
        return this.num * rational.den <= rational.num * this.den;
    }

    public boolean smallerThen(Rational rational) {
        return this.num * rational.den < rational.num * this.den;
    }

    public double toDouble() {
        return this.num / this.den;
    }

    public String toString() {
        return this.num + "/" + this.den;
    }
}
