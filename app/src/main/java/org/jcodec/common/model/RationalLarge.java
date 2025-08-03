package org.jcodec.common.model;

import com.xiaomi.mipush.sdk.Constants;
import org.jcodec.common.StringUtils;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class RationalLarge {
    public final long den;
    public final long num;
    public static final RationalLarge ONE = new RationalLarge(1, 1);
    public static final RationalLarge HALF = new RationalLarge(1, 2);
    public static final RationalLarge ZERO = new RationalLarge(0, 1);

    public RationalLarge(long j, long j2) {
        this.num = j;
        this.den = j2;
    }

    public static RationalLarge R(long j, long j2) {
        return new RationalLarge(j, j2);
    }

    public static RationalLarge R1(long j) {
        return R(j, 1L);
    }

    public static RationalLarge parse(String str) {
        String[] strArrSplitS = StringUtils.splitS(str, Constants.COLON_SEPARATOR);
        return strArrSplitS.length > 1 ? R(Long.parseLong(strArrSplitS[0]), Long.parseLong(strArrSplitS[1])) : R(Long.parseLong(str), 1L);
    }

    public static RationalLarge reduceLong(long j, long j2) {
        long jGcdLong = MathUtil.gcdLong(j, j2);
        return new RationalLarge(j / jGcdLong, j2 / jGcdLong);
    }

    public RationalLarge divideBy(RationalLarge rationalLarge) {
        return reduceLong(this.num * rationalLarge.den, this.den * rationalLarge.num);
    }

    public RationalLarge divideByLong(long j) {
        return new RationalLarge(this.num, this.den * j);
    }

    public RationalLarge divideByR(Rational rational) {
        return reduceLong(this.num * rational.den, this.den * rational.num);
    }

    public long divideByS(long j) {
        return this.num / (this.den * j);
    }

    public RationalLarge divideLong(long j) {
        return new RationalLarge(this.den * j, this.num);
    }

    public RationalLarge divideR(Rational rational) {
        return reduceLong(rational.num * this.den, rational.den * this.num);
    }

    public RationalLarge divideRL(RationalLarge rationalLarge) {
        return reduceLong(rationalLarge.num * this.den, rationalLarge.den * this.num);
    }

    public long divideS(long j) {
        return (this.den * j) / this.num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RationalLarge rationalLarge = (RationalLarge) obj;
        return this.den == rationalLarge.den && this.num == rationalLarge.num;
    }

    public boolean equalsLarge(RationalLarge rationalLarge) {
        return this.num * rationalLarge.den == rationalLarge.num * this.den;
    }

    public RationalLarge flip() {
        return new RationalLarge(this.den, this.num);
    }

    public long getDen() {
        return this.den;
    }

    public long getNum() {
        return this.num;
    }

    public boolean greaterOrEqualTo(RationalLarge rationalLarge) {
        return this.num * rationalLarge.den >= rationalLarge.num * this.den;
    }

    public boolean greaterThen(RationalLarge rationalLarge) {
        return this.num * rationalLarge.den > rationalLarge.num * this.den;
    }

    public int hashCode() {
        long j = this.den;
        int i = (((int) (j ^ (j >>> 32))) + 31) * 31;
        long j2 = this.num;
        return i + ((int) ((j2 >>> 32) ^ j2));
    }

    public boolean lessThen(RationalLarge rationalLarge) {
        return this.num * rationalLarge.den < rationalLarge.num * this.den;
    }

    public RationalLarge minus(RationalLarge rationalLarge) {
        long j = this.num;
        long j2 = rationalLarge.den;
        long j3 = rationalLarge.num;
        long j4 = this.den;
        return reduceLong((j * j2) - (j3 * j4), j4 * j2);
    }

    public RationalLarge minusLong(long j) {
        long j2 = this.num;
        long j3 = this.den;
        return new RationalLarge(j2 - (j * j3), j3);
    }

    public RationalLarge minusR(Rational rational) {
        long j = this.num;
        int i = rational.den;
        long j2 = j * i;
        long j3 = rational.num;
        long j4 = this.den;
        return reduceLong(j2 - (j3 * j4), j4 * i);
    }

    public RationalLarge multiply(RationalLarge rationalLarge) {
        return reduceLong(this.num * rationalLarge.num, this.den * rationalLarge.den);
    }

    public RationalLarge multiplyLong(long j) {
        return new RationalLarge(this.num * j, this.den);
    }

    public RationalLarge multiplyR(Rational rational) {
        return reduceLong(this.num * rational.num, this.den * rational.den);
    }

    public long multiplyS(long j) {
        return (this.num * j) / this.den;
    }

    public RationalLarge plus(RationalLarge rationalLarge) {
        long j = this.num;
        long j2 = rationalLarge.den;
        long j3 = rationalLarge.num;
        long j4 = this.den;
        return reduceLong((j * j2) + (j3 * j4), j4 * j2);
    }

    public RationalLarge plusLong(long j) {
        long j2 = this.num;
        long j3 = this.den;
        return new RationalLarge(j2 + (j * j3), j3);
    }

    public RationalLarge plusR(Rational rational) {
        long j = this.num;
        int i = rational.den;
        long j2 = j * i;
        long j3 = rational.num;
        long j4 = this.den;
        return reduceLong(j2 + (j3 * j4), j4 * i);
    }

    public double scalar() {
        return this.num / this.den;
    }

    public long scalarClip() {
        return this.num / this.den;
    }

    public boolean smallerOrEqualTo(RationalLarge rationalLarge) {
        return this.num * rationalLarge.den <= rationalLarge.num * this.den;
    }

    public String toString() {
        return this.num + Constants.COLON_SEPARATOR + this.den;
    }
}
