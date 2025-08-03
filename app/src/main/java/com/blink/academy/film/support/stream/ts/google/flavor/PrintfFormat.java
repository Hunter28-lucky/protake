package com.blink.academy.film.support.stream.ts.google.flavor;

import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.support.stream.ts.TsConstants;
import java.text.DecimalFormatSymbols;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Vector;

/* loaded from: classes.dex */
public class PrintfFormat {
    private int cPos;
    private DecimalFormatSymbols dfs;
    private Vector vFmt;

    public class ConversionSpecification {
        private static final int defaultDigits = 6;
        private boolean alternateForm;
        private int argumentPosition;
        private int argumentPositionForFieldWidth;
        private int argumentPositionForPrecision;
        private char conversionCharacter;
        private int fieldWidth;
        private boolean fieldWidthSet;
        private String fmt;
        private boolean leadingSign;
        private boolean leadingSpace;
        private boolean leadingZeros;
        private boolean leftJustify;
        private boolean optionalL;
        private boolean optionalh;
        private boolean optionall;
        private int pos;
        private boolean positionalFieldWidth;
        private boolean positionalPrecision;
        private boolean positionalSpecification;
        private int precision;
        private boolean precisionSet;
        private boolean thousands;
        private boolean variableFieldWidth;
        private boolean variablePrecision;

        public ConversionSpecification() {
            this.thousands = false;
            this.leftJustify = false;
            this.leadingSign = false;
            this.leadingSpace = false;
            this.alternateForm = false;
            this.leadingZeros = false;
            this.variableFieldWidth = false;
            this.fieldWidth = 0;
            this.fieldWidthSet = false;
            this.precision = 0;
            this.variablePrecision = false;
            this.precisionSet = false;
            this.positionalSpecification = false;
            this.argumentPosition = 0;
            this.positionalFieldWidth = false;
            this.argumentPositionForFieldWidth = 0;
            this.positionalPrecision = false;
            this.argumentPositionForPrecision = 0;
            this.optionalh = false;
            this.optionall = false;
            this.optionalL = false;
            this.conversionCharacter = (char) 0;
            this.pos = 0;
        }

        private char[] applyFloatPadding(char[] cArr, boolean z) {
            char[] cArr2;
            int length;
            int i;
            if (!this.fieldWidthSet) {
                return cArr;
            }
            int i2 = 0;
            if (this.leftJustify) {
                int length2 = this.fieldWidth - cArr.length;
                if (length2 <= 0) {
                    return cArr;
                }
                cArr2 = new char[cArr.length + length2];
                int i3 = 0;
                while (i3 < cArr.length) {
                    cArr2[i3] = cArr[i3];
                    i3++;
                }
                while (i2 < length2) {
                    cArr2[i3] = ' ';
                    i2++;
                    i3++;
                }
            } else {
                boolean z2 = this.leadingZeros;
                if (!z2 || z) {
                    int length3 = this.fieldWidth - cArr.length;
                    if (length3 <= 0) {
                        return cArr;
                    }
                    cArr2 = new char[cArr.length + length3];
                    int i4 = 0;
                    while (i4 < length3) {
                        cArr2[i4] = ' ';
                        i4++;
                    }
                    while (i2 < cArr.length) {
                        cArr2[i4] = cArr[i2];
                        i4++;
                        i2++;
                    }
                } else {
                    if (!z2 || (length = this.fieldWidth - cArr.length) <= 0) {
                        return cArr;
                    }
                    cArr2 = new char[cArr.length + length];
                    if (cArr[0] == '-') {
                        cArr2[0] = '-';
                        i = 1;
                    } else {
                        i = 0;
                    }
                    while (i2 < length) {
                        cArr2[i] = '0';
                        i++;
                        i2++;
                    }
                    for (int i5 = i; i5 < cArr.length; i5++) {
                        cArr2[i] = cArr[i5];
                        i++;
                    }
                }
            }
            return cArr2;
        }

        private boolean checkForCarry(char[] cArr, int i) {
            if (i >= cArr.length) {
                return false;
            }
            char c = cArr[i];
            if (c != '6' && c != '7' && c != '8' && c != '9') {
                if (c != '5') {
                    return false;
                }
                int i2 = i + 1;
                while (i2 < cArr.length && cArr[i2] == '0') {
                    i2++;
                }
                boolean z = i2 < cArr.length;
                if (z || i <= 0) {
                    return z;
                }
                char c2 = cArr[i - 1];
                if (c2 != '1' && c2 != '3' && c2 != '5' && c2 != '7' && c2 != '9') {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:121:0x019f  */
        /* JADX WARN: Removed duplicated region for block: B:130:0x01b8 A[LOOP:4: B:128:0x01b4->B:130:0x01b8, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:133:0x01c3  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x01c8  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x01e6  */
        /* JADX WARN: Removed duplicated region for block: B:153:0x0210  */
        /* JADX WARN: Removed duplicated region for block: B:154:0x0213  */
        /* JADX WARN: Removed duplicated region for block: B:155:0x0216  */
        /* JADX WARN: Removed duplicated region for block: B:156:0x0219  */
        /* JADX WARN: Removed duplicated region for block: B:157:0x021c  */
        /* JADX WARN: Removed duplicated region for block: B:158:0x021f  */
        /* JADX WARN: Removed duplicated region for block: B:159:0x0222  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:160:0x0225  */
        /* JADX WARN: Removed duplicated region for block: B:161:0x0228  */
        /* JADX WARN: Removed duplicated region for block: B:162:0x022b  */
        /* JADX WARN: Removed duplicated region for block: B:166:0x0234  */
        /* JADX WARN: Removed duplicated region for block: B:167:0x0237  */
        /* JADX WARN: Removed duplicated region for block: B:168:0x023a  */
        /* JADX WARN: Removed duplicated region for block: B:169:0x023d  */
        /* JADX WARN: Removed duplicated region for block: B:170:0x0240  */
        /* JADX WARN: Removed duplicated region for block: B:171:0x0243  */
        /* JADX WARN: Removed duplicated region for block: B:172:0x0246  */
        /* JADX WARN: Removed duplicated region for block: B:173:0x0249  */
        /* JADX WARN: Removed duplicated region for block: B:174:0x024c  */
        /* JADX WARN: Removed duplicated region for block: B:175:0x024f  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:211:0x029b  */
        /* JADX WARN: Removed duplicated region for block: B:221:0x02b6  */
        /* JADX WARN: Removed duplicated region for block: B:227:0x02c5  */
        /* JADX WARN: Removed duplicated region for block: B:230:0x02ca A[LOOP:6: B:229:0x02c8->B:230:0x02ca, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:243:0x02ee  */
        /* JADX WARN: Removed duplicated region for block: B:253:0x0302  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00f6  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x010c  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0147  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x015a  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0169  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private char[] eFormatDigits(double r20, char r22) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 922
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.support.stream.ts.google.flavor.PrintfFormat.ConversionSpecification.eFormatDigits(double, char):char[]");
        }

        private String eFormatString(double d, char c) {
            return new String(applyFloatPadding(Double.isInfinite(d) ? d == Double.POSITIVE_INFINITY ? this.leadingSign ? "+Inf".toCharArray() : this.leadingSpace ? " Inf".toCharArray() : "Inf".toCharArray() : "-Inf".toCharArray() : Double.isNaN(d) ? this.leadingSign ? "+NaN".toCharArray() : this.leadingSpace ? " NaN".toCharArray() : "NaN".toCharArray() : eFormatDigits(d, c), false));
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:173:0x0203  */
        /* JADX WARN: Removed duplicated region for block: B:183:0x021e  */
        /* JADX WARN: Removed duplicated region for block: B:189:0x022d  */
        /* JADX WARN: Removed duplicated region for block: B:192:0x0234 A[LOOP:6: B:191:0x0232->B:192:0x0234, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:196:0x023f A[LOOP:7: B:194:0x023c->B:196:0x023f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:204:0x0256  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:214:0x026a  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00b1  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00bd A[LOOP:1: B:54:0x00bb->B:55:0x00bd, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00c9 A[LOOP:2: B:57:0x00c7->B:58:0x00c9, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x00fa  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x010b  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0142  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private char[] fFormatDigits(double r19) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 699
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.support.stream.ts.google.flavor.PrintfFormat.ConversionSpecification.fFormatDigits(double):char[]");
        }

        private String fFormatString(double d) {
            return new String(applyFloatPadding(Double.isInfinite(d) ? d == Double.POSITIVE_INFINITY ? this.leadingSign ? "+Inf".toCharArray() : this.leadingSpace ? " Inf".toCharArray() : "Inf".toCharArray() : "-Inf".toCharArray() : Double.isNaN(d) ? this.leadingSign ? "+NaN".toCharArray() : this.leadingSpace ? " NaN".toCharArray() : "NaN".toCharArray() : fFormatDigits(d), false));
        }

        private String printCFormat(char c) {
            int i = this.fieldWidth;
            if (!this.fieldWidthSet) {
                i = 1;
            }
            char[] cArr = new char[i];
            int i2 = 0;
            if (this.leftJustify) {
                cArr[0] = c;
                for (int i3 = 1; i3 <= i - 1; i3++) {
                    cArr[i3] = ' ';
                }
            } else {
                while (i2 < i - 1) {
                    cArr[i2] = ' ';
                    i2++;
                }
                cArr[i2] = c;
            }
            return new String(cArr);
        }

        private String printDFormat(short s) {
            return printDFormat(Short.toString(s));
        }

        private String printEFormat(double d) {
            return this.conversionCharacter == 'e' ? eFormatString(d, 'e') : eFormatString(d, 'E');
        }

        private String printFFormat(double d) {
            return fFormatString(d);
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00e6  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x015c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.String printGFormat(double r12) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 405
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.support.stream.ts.google.flavor.PrintfFormat.ConversionSpecification.printGFormat(double):java.lang.String");
        }

        private String printOFormat(short s) {
            String string;
            if (s == Short.MIN_VALUE) {
                string = "100000";
            } else if (s < 0) {
                String string2 = Integer.toString((~((-s) - 1)) ^ (-32768), 8);
                int length = string2.length();
                if (length == 1) {
                    string = "10000" + string2;
                } else if (length == 2) {
                    string = "1000" + string2;
                } else if (length == 3) {
                    string = "100" + string2;
                } else if (length == 4) {
                    string = "10" + string2;
                } else if (length != 5) {
                    string = null;
                } else {
                    string = "1" + string2;
                }
            } else {
                string = Integer.toString(s, 8);
            }
            return printOFormat(string);
        }

        private String printSFormat(String str) {
            int i;
            int i2;
            int length = str.length();
            int i3 = this.fieldWidth;
            if (this.precisionSet && length > (i2 = this.precision)) {
                length = i2;
            }
            if (!this.fieldWidthSet) {
                i3 = length;
            }
            int i4 = 0;
            int i5 = i3 > length ? (i3 - length) + 0 : 0;
            char[] cArr = new char[length >= str.length() ? i5 + str.length() : i5 + length];
            if (this.leftJustify) {
                if (length >= str.length()) {
                    char[] charArray = str.toCharArray();
                    i = 0;
                    while (i < str.length()) {
                        cArr[i] = charArray[i];
                        i++;
                    }
                } else {
                    char[] charArray2 = str.substring(0, length).toCharArray();
                    i = 0;
                    while (i < length) {
                        cArr[i] = charArray2[i];
                        i++;
                    }
                }
                while (i4 < i3 - length) {
                    cArr[i] = ' ';
                    i4++;
                    i++;
                }
            } else {
                int i6 = 0;
                while (i6 < i3 - length) {
                    cArr[i6] = ' ';
                    i6++;
                }
                if (length >= str.length()) {
                    char[] charArray3 = str.toCharArray();
                    while (i4 < str.length()) {
                        cArr[i6] = charArray3[i4];
                        i6++;
                        i4++;
                    }
                } else {
                    char[] charArray4 = str.substring(0, length).toCharArray();
                    while (i4 < length) {
                        cArr[i6] = charArray4[i4];
                        i6++;
                        i4++;
                    }
                }
            }
            return new String(cArr);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x00e9  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.String printXFormat(short r6) {
            /*
                Method dump skipped, instructions count: 316
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.support.stream.ts.google.flavor.PrintfFormat.ConversionSpecification.printXFormat(short):java.lang.String");
        }

        private void setArgPosition() {
            int i = this.pos;
            while (i < this.fmt.length() && Character.isDigit(this.fmt.charAt(i))) {
                i++;
            }
            if (i <= this.pos || i >= this.fmt.length() || this.fmt.charAt(i) != '$') {
                return;
            }
            this.positionalSpecification = true;
            this.argumentPosition = Integer.parseInt(this.fmt.substring(this.pos, i));
            this.pos = i + 1;
        }

        private boolean setConversionCharacter() {
            this.conversionCharacter = (char) 0;
            if (this.pos >= this.fmt.length()) {
                return false;
            }
            char cCharAt = this.fmt.charAt(this.pos);
            if (cCharAt != 'i' && cCharAt != 'd' && cCharAt != 'f' && cCharAt != 'g' && cCharAt != 'G' && cCharAt != 'o' && cCharAt != 'x' && cCharAt != 'X' && cCharAt != 'e' && cCharAt != 'E' && cCharAt != 'c' && cCharAt != 's' && cCharAt != '%') {
                return false;
            }
            this.conversionCharacter = cCharAt;
            this.pos++;
            return true;
        }

        private void setFieldWidth() {
            int i = this.pos;
            this.fieldWidth = 0;
            this.fieldWidthSet = false;
            if (i < this.fmt.length() && this.fmt.charAt(this.pos) == '*') {
                this.pos++;
                if (setFieldWidthArgPosition()) {
                    return;
                }
                this.variableFieldWidth = true;
                this.fieldWidthSet = true;
                return;
            }
            while (this.pos < this.fmt.length() && Character.isDigit(this.fmt.charAt(this.pos))) {
                this.pos++;
            }
            if (i >= this.pos || i >= this.fmt.length()) {
                return;
            }
            this.fieldWidth = Integer.parseInt(this.fmt.substring(i, this.pos));
            this.fieldWidthSet = true;
        }

        private boolean setFieldWidthArgPosition() {
            int i = this.pos;
            while (i < this.fmt.length() && Character.isDigit(this.fmt.charAt(i))) {
                i++;
            }
            if (i <= this.pos || i >= this.fmt.length() || this.fmt.charAt(i) != '$') {
                return false;
            }
            this.positionalFieldWidth = true;
            this.argumentPositionForFieldWidth = Integer.parseInt(this.fmt.substring(this.pos, i));
            this.pos = i + 1;
            return true;
        }

        private void setFlagCharacters() {
            this.thousands = false;
            this.leftJustify = false;
            this.leadingSign = false;
            this.leadingSpace = false;
            this.alternateForm = false;
            this.leadingZeros = false;
            while (this.pos < this.fmt.length()) {
                char cCharAt = this.fmt.charAt(this.pos);
                if (cCharAt == '\'') {
                    this.thousands = true;
                } else if (cCharAt == '-') {
                    this.leftJustify = true;
                    this.leadingZeros = false;
                } else if (cCharAt == '+') {
                    this.leadingSign = true;
                    this.leadingSpace = false;
                } else if (cCharAt == ' ') {
                    if (!this.leadingSign) {
                        this.leadingSpace = true;
                    }
                } else if (cCharAt == '#') {
                    this.alternateForm = true;
                } else {
                    if (cCharAt != '0') {
                        return;
                    }
                    if (!this.leftJustify) {
                        this.leadingZeros = true;
                    }
                }
                this.pos++;
            }
        }

        private void setOptionalHL() {
            this.optionalh = false;
            this.optionall = false;
            this.optionalL = false;
            if (this.pos < this.fmt.length()) {
                char cCharAt = this.fmt.charAt(this.pos);
                if (cCharAt == 'h') {
                    this.optionalh = true;
                    this.pos++;
                } else if (cCharAt == 'l') {
                    this.optionall = true;
                    this.pos++;
                } else if (cCharAt == 'L') {
                    this.optionalL = true;
                    this.pos++;
                }
            }
        }

        private void setPrecision() {
            int i = this.pos;
            this.precisionSet = false;
            if (i >= this.fmt.length() || this.fmt.charAt(this.pos) != '.') {
                return;
            }
            int i2 = this.pos + 1;
            this.pos = i2;
            if (i2 < this.fmt.length() && this.fmt.charAt(this.pos) == '*') {
                this.pos++;
                if (setPrecisionArgPosition()) {
                    return;
                }
                this.variablePrecision = true;
                this.precisionSet = true;
                return;
            }
            while (this.pos < this.fmt.length() && Character.isDigit(this.fmt.charAt(this.pos))) {
                this.pos++;
            }
            int i3 = this.pos;
            int i4 = i + 1;
            if (i3 > i4) {
                this.precision = Integer.parseInt(this.fmt.substring(i4, i3));
                this.precisionSet = true;
            }
        }

        private boolean setPrecisionArgPosition() {
            int i = this.pos;
            while (i < this.fmt.length() && Character.isDigit(this.fmt.charAt(i))) {
                i++;
            }
            if (i <= this.pos || i >= this.fmt.length() || this.fmt.charAt(i) != '$') {
                return false;
            }
            this.positionalPrecision = true;
            this.argumentPositionForPrecision = Integer.parseInt(this.fmt.substring(this.pos, i));
            this.pos = i + 1;
            return true;
        }

        private boolean startSymbolicCarry(char[] cArr, int i, int i2) {
            boolean z = true;
            while (z && i >= i2) {
                z = false;
                switch (cArr[i]) {
                    case '0':
                        cArr[i] = '1';
                        break;
                    case '1':
                        cArr[i] = '2';
                        break;
                    case '2':
                        cArr[i] = '3';
                        break;
                    case '3':
                        cArr[i] = '4';
                        break;
                    case '4':
                        cArr[i] = '5';
                        break;
                    case '5':
                        cArr[i] = '6';
                        break;
                    case '6':
                        cArr[i] = '7';
                        break;
                    case '7':
                        cArr[i] = '8';
                        break;
                    case '8':
                        cArr[i] = '9';
                        break;
                    case '9':
                        cArr[i] = '0';
                        z = true;
                        break;
                }
                i--;
            }
            return z;
        }

        public int getArgumentPosition() {
            return this.argumentPosition;
        }

        public int getArgumentPositionForFieldWidth() {
            return this.argumentPositionForFieldWidth;
        }

        public int getArgumentPositionForPrecision() {
            return this.argumentPositionForPrecision;
        }

        public char getConversionCharacter() {
            return this.conversionCharacter;
        }

        public String getLiteral() {
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (i < this.fmt.length()) {
                if (this.fmt.charAt(i) == '\\') {
                    i++;
                    if (i < this.fmt.length()) {
                        char cCharAt = this.fmt.charAt(i);
                        if (cCharAt == '\\') {
                            stringBuffer.append('\\');
                        } else if (cCharAt == 'f') {
                            stringBuffer.append('\f');
                        } else if (cCharAt == 'n') {
                            stringBuffer.append(System.getProperty("line.separator"));
                        } else if (cCharAt == 'r') {
                            stringBuffer.append('\r');
                        } else if (cCharAt == 't') {
                            stringBuffer.append('\t');
                        } else if (cCharAt == 'v') {
                            stringBuffer.append((char) 11);
                        } else if (cCharAt == 'a') {
                            stringBuffer.append((char) 7);
                        } else if (cCharAt == 'b') {
                            stringBuffer.append('\b');
                        }
                    } else {
                        stringBuffer.append('\\');
                    }
                }
                i++;
            }
            return this.fmt;
        }

        public String internalsprintf(int i) throws IllegalArgumentException {
            char c = this.conversionCharacter;
            if (c != 'C') {
                if (c != 'X') {
                    if (c != 'i') {
                        if (c == 'o') {
                            return this.optionalh ? printOFormat((short) i) : this.optionall ? printOFormat(i) : printOFormat(i);
                        }
                        if (c != 'x') {
                            if (c != 'c') {
                                if (c != 'd') {
                                    throw new IllegalArgumentException("Cannot format a int with a format using a " + this.conversionCharacter + " conversion character.");
                                }
                            }
                        }
                    }
                    return this.optionalh ? printDFormat((short) i) : this.optionall ? printDFormat(i) : printDFormat(i);
                }
                return this.optionalh ? printXFormat((short) i) : this.optionall ? printXFormat(i) : printXFormat(i);
            }
            return printCFormat((char) i);
        }

        public boolean isPositionalFieldWidth() {
            return this.positionalFieldWidth;
        }

        public boolean isPositionalPrecision() {
            return this.positionalPrecision;
        }

        public boolean isPositionalSpecification() {
            return this.positionalSpecification;
        }

        public boolean isVariableFieldWidth() {
            return this.variableFieldWidth;
        }

        public boolean isVariablePrecision() {
            return this.variablePrecision;
        }

        public void setFieldWidthWithArg(int i) {
            if (i < 0) {
                this.leftJustify = true;
            }
            this.fieldWidthSet = true;
            this.fieldWidth = Math.abs(i);
        }

        public void setLiteral(String str) {
            this.fmt = str;
        }

        public void setPrecisionWithArg(int i) {
            this.precisionSet = true;
            this.precision = Math.max(i, 0);
        }

        private String printDFormat(long j) {
            return printDFormat(Long.toString(j));
        }

        private String printDFormat(int i) {
            return printDFormat(Integer.toString(i));
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00a3 A[LOOP:0: B:59:0x00a1->B:60:0x00a3, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00ad A[LOOP:1: B:61:0x00aa->B:63:0x00ad, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00b8 A[LOOP:2: B:64:0x00b6->B:65:0x00b8, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x00fe A[LOOP:6: B:91:0x00fc->B:92:0x00fe, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.String printDFormat(java.lang.String r12) {
            /*
                Method dump skipped, instructions count: 291
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.support.stream.ts.google.flavor.PrintfFormat.ConversionSpecification.printDFormat(java.lang.String):java.lang.String");
        }

        private String printOFormat(long j) {
            String string;
            if (j == Long.MIN_VALUE) {
                string = "1000000000000000000000";
            } else if (j < 0) {
                String string2 = Long.toString((~((-j) - 1)) ^ Long.MIN_VALUE, 8);
                switch (string2.length()) {
                    case 1:
                        string = "100000000000000000000" + string2;
                        break;
                    case 2:
                        string = "10000000000000000000" + string2;
                        break;
                    case 3:
                        string = "1000000000000000000" + string2;
                        break;
                    case 4:
                        string = "100000000000000000" + string2;
                        break;
                    case 5:
                        string = "10000000000000000" + string2;
                        break;
                    case 6:
                        string = "1000000000000000" + string2;
                        break;
                    case 7:
                        string = "100000000000000" + string2;
                        break;
                    case 8:
                        string = "10000000000000" + string2;
                        break;
                    case 9:
                        string = "1000000000000" + string2;
                        break;
                    case 10:
                        string = "100000000000" + string2;
                        break;
                    case 11:
                        string = "10000000000" + string2;
                        break;
                    case 12:
                        string = "1000000000" + string2;
                        break;
                    case 13:
                        string = "100000000" + string2;
                        break;
                    case 14:
                        string = "10000000" + string2;
                        break;
                    case 15:
                        string = "1000000" + string2;
                        break;
                    case 16:
                        string = "100000" + string2;
                        break;
                    case 17:
                        string = "10000" + string2;
                        break;
                    case 18:
                        string = "1000" + string2;
                        break;
                    case 19:
                        string = "100" + string2;
                        break;
                    case 20:
                        string = "10" + string2;
                        break;
                    case 21:
                        string = "1" + string2;
                        break;
                    default:
                        string = null;
                        break;
                }
            } else {
                string = Long.toString(j, 8);
            }
            return printOFormat(string);
        }

        private String printXFormat(long j) {
            String string;
            if (j == Long.MIN_VALUE) {
                string = "8000000000000000";
            } else if (j < 0) {
                String string2 = Long.toString((~((-j) - 1)) ^ Long.MIN_VALUE, 16);
                switch (string2.length()) {
                    case 1:
                        string = "800000000000000" + string2;
                        break;
                    case 2:
                        string = "80000000000000" + string2;
                        break;
                    case 3:
                        string = "8000000000000" + string2;
                        break;
                    case 4:
                        string = "800000000000" + string2;
                        break;
                    case 5:
                        string = "80000000000" + string2;
                        break;
                    case 6:
                        string = "8000000000" + string2;
                        break;
                    case 7:
                        string = "800000000" + string2;
                        break;
                    case 8:
                        string = "80000000" + string2;
                        break;
                    case 9:
                        string = "8000000" + string2;
                        break;
                    case 10:
                        string = "800000" + string2;
                        break;
                    case 11:
                        string = "80000" + string2;
                        break;
                    case 12:
                        string = "8000" + string2;
                        break;
                    case 13:
                        string = "800" + string2;
                        break;
                    case 14:
                        string = "80" + string2;
                        break;
                    case 15:
                        string = FinderManager.MACHINE_D + string2;
                        break;
                    case 16:
                        switch (string2.charAt(0)) {
                            case '1':
                                string = "9" + string2.substring(1, 16);
                                break;
                            case '2':
                                string = "a" + string2.substring(1, 16);
                                break;
                            case '3':
                                string = TsConstants.kLinkParam_suffix + string2.substring(1, 16);
                                break;
                            case '4':
                                string = "c" + string2.substring(1, 16);
                                break;
                            case '5':
                                string = "d" + string2.substring(1, 16);
                                break;
                            case '6':
                                string = TsConstants.kLinkParam_machine + string2.substring(1, 16);
                                break;
                            case '7':
                                string = TsConstants.kLinkParam_recording + string2.substring(1, 16);
                                break;
                        }
                    default:
                        string = null;
                        break;
                }
            } else {
                string = Long.toString(j, 16);
            }
            return printXFormat(string);
        }

        public String internalsprintf(long j) throws IllegalArgumentException {
            char c = this.conversionCharacter;
            if (c != 'C') {
                if (c != 'X') {
                    if (c != 'i') {
                        if (c == 'o') {
                            if (this.optionalh) {
                                return printOFormat((short) j);
                            }
                            if (this.optionall) {
                                return printOFormat(j);
                            }
                            return printOFormat((int) j);
                        }
                        if (c != 'x') {
                            if (c != 'c') {
                                if (c != 'd') {
                                    throw new IllegalArgumentException("Cannot format a long with a format using a " + this.conversionCharacter + " conversion character.");
                                }
                            }
                        }
                    }
                    if (this.optionalh) {
                        return printDFormat((short) j);
                    }
                    if (this.optionall) {
                        return printDFormat(j);
                    }
                    return printDFormat((int) j);
                }
                if (this.optionalh) {
                    return printXFormat((short) j);
                }
                if (this.optionall) {
                    return printXFormat(j);
                }
                return printXFormat((int) j);
            }
            return printCFormat((char) j);
        }

        public ConversionSpecification(String str) throws IllegalArgumentException {
            this.thousands = false;
            this.leftJustify = false;
            this.leadingSign = false;
            this.leadingSpace = false;
            this.alternateForm = false;
            this.leadingZeros = false;
            this.variableFieldWidth = false;
            this.fieldWidth = 0;
            this.fieldWidthSet = false;
            this.precision = 0;
            this.variablePrecision = false;
            this.precisionSet = false;
            this.positionalSpecification = false;
            this.argumentPosition = 0;
            this.positionalFieldWidth = false;
            this.argumentPositionForFieldWidth = 0;
            this.positionalPrecision = false;
            this.argumentPositionForPrecision = 0;
            this.optionalh = false;
            this.optionall = false;
            this.optionalL = false;
            this.conversionCharacter = (char) 0;
            this.pos = 0;
            str.getClass();
            if (str.length() != 0) {
                if (str.charAt(0) == '%') {
                    this.fmt = str;
                    this.pos = 1;
                    setArgPosition();
                    setFlagCharacters();
                    setFieldWidth();
                    setPrecision();
                    setOptionalHL();
                    if (setConversionCharacter()) {
                        if (this.pos == str.length()) {
                            if (this.leadingZeros && this.leftJustify) {
                                this.leadingZeros = false;
                            }
                            if (this.precisionSet && this.leadingZeros) {
                                char c = this.conversionCharacter;
                                if (c == 'd' || c == 'i' || c == 'o' || c == 'x') {
                                    this.leadingZeros = false;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        throw new IllegalArgumentException("Malformed conversion specification=" + str);
                    }
                    throw new IllegalArgumentException("Malformed conversion specification=" + str);
                }
                throw new IllegalArgumentException("Control strings must begin with %.");
            }
            throw new IllegalArgumentException("Control strings must have positive lengths.");
        }

        private String printOFormat(int i) {
            String string;
            if (i == Integer.MIN_VALUE) {
                string = "20000000000";
            } else if (i < 0) {
                String string2 = Integer.toString((~((-i) - 1)) ^ Integer.MIN_VALUE, 8);
                switch (string2.length()) {
                    case 1:
                        string = "2000000000" + string2;
                        break;
                    case 2:
                        string = "200000000" + string2;
                        break;
                    case 3:
                        string = "20000000" + string2;
                        break;
                    case 4:
                        string = "2000000" + string2;
                        break;
                    case 5:
                        string = "200000" + string2;
                        break;
                    case 6:
                        string = "20000" + string2;
                        break;
                    case 7:
                        string = "2000" + string2;
                        break;
                    case 8:
                        string = "200" + string2;
                        break;
                    case 9:
                        string = "20" + string2;
                        break;
                    case 10:
                        string = "2" + string2;
                        break;
                    case 11:
                        string = "3" + string2.substring(1);
                        break;
                    default:
                        string = null;
                        break;
                }
            } else {
                string = Integer.toString(i, 8);
            }
            return printOFormat(string);
        }

        public String internalsprintf(double d) throws IllegalArgumentException {
            char c = this.conversionCharacter;
            if (c != 'E') {
                if (c != 'G') {
                    switch (c) {
                        case 'e':
                            break;
                        case 'f':
                            return printFFormat(d);
                        case 'g':
                            break;
                        default:
                            throw new IllegalArgumentException("Cannot format a double with a format using a " + this.conversionCharacter + " conversion character.");
                    }
                }
                return printGFormat(d);
            }
            return printEFormat(d);
        }

        public String internalsprintf(String str) throws IllegalArgumentException {
            char c = this.conversionCharacter;
            if (c != 's' && c != 'S') {
                throw new IllegalArgumentException("Cannot format a String with a format using a " + this.conversionCharacter + " conversion character.");
            }
            return printSFormat(str);
        }

        private String printXFormat(int i) {
            String string;
            if (i == Integer.MIN_VALUE) {
                string = "80000000";
            } else if (i < 0) {
                String string2 = Integer.toString((~((-i) - 1)) ^ Integer.MIN_VALUE, 16);
                switch (string2.length()) {
                    case 1:
                        string = "8000000" + string2;
                        break;
                    case 2:
                        string = "800000" + string2;
                        break;
                    case 3:
                        string = "80000" + string2;
                        break;
                    case 4:
                        string = "8000" + string2;
                        break;
                    case 5:
                        string = "800" + string2;
                        break;
                    case 6:
                        string = "80" + string2;
                        break;
                    case 7:
                        string = FinderManager.MACHINE_D + string2;
                        break;
                    case 8:
                        switch (string2.charAt(0)) {
                            case '1':
                                string = "9" + string2.substring(1, 8);
                                break;
                            case '2':
                                string = "a" + string2.substring(1, 8);
                                break;
                            case '3':
                                string = TsConstants.kLinkParam_suffix + string2.substring(1, 8);
                                break;
                            case '4':
                                string = "c" + string2.substring(1, 8);
                                break;
                            case '5':
                                string = "d" + string2.substring(1, 8);
                                break;
                            case '6':
                                string = TsConstants.kLinkParam_machine + string2.substring(1, 8);
                                break;
                            case '7':
                                string = TsConstants.kLinkParam_recording + string2.substring(1, 8);
                                break;
                        }
                    default:
                        string = null;
                        break;
                }
            } else {
                string = Integer.toString(i, 16);
            }
            return printXFormat(string);
        }

        public String internalsprintf(Object obj) {
            char c = this.conversionCharacter;
            if (c != 's' && c != 'S') {
                throw new IllegalArgumentException("Cannot format a String with a format using a " + this.conversionCharacter + " conversion character.");
            }
            return printSFormat(obj.toString());
        }

        private String printOFormat(String str) {
            int i;
            if (str.equals("0") && this.precisionSet && this.precision == 0) {
                str = "";
            }
            int i2 = 0;
            int length = this.precisionSet ? this.precision - str.length() : 0;
            if (this.alternateForm) {
                length++;
            }
            if (length < 0) {
                length = 0;
            }
            int length2 = this.fieldWidthSet ? (this.fieldWidth - length) - str.length() : 0;
            if (length2 < 0) {
                length2 = 0;
            }
            char[] cArr = new char[str.length() + length + length2];
            if (this.leftJustify) {
                int i3 = 0;
                while (i3 < length) {
                    cArr[i3] = '0';
                    i3++;
                }
                char[] charArray = str.toCharArray();
                int i4 = 0;
                while (i4 < charArray.length) {
                    cArr[i3] = charArray[i4];
                    i4++;
                    i3++;
                }
                while (i2 < length2) {
                    cArr[i3] = ' ';
                    i2++;
                    i3++;
                }
            } else {
                if (this.leadingZeros) {
                    i = 0;
                    while (i < length2) {
                        cArr[i] = '0';
                        i++;
                    }
                } else {
                    i = 0;
                    while (i < length2) {
                        cArr[i] = ' ';
                        i++;
                    }
                }
                int i5 = 0;
                while (i5 < length) {
                    cArr[i] = '0';
                    i5++;
                    i++;
                }
                char[] charArray2 = str.toCharArray();
                while (i2 < charArray2.length) {
                    cArr[i] = charArray2[i2];
                    i2++;
                    i++;
                }
            }
            return new String(cArr);
        }

        private String printXFormat(String str) {
            int length;
            int i;
            if (str.equals("0") && this.precisionSet && this.precision == 0) {
                str = "";
            }
            int i2 = 0;
            int length2 = this.precisionSet ? this.precision - str.length() : 0;
            if (length2 < 0) {
                length2 = 0;
            }
            if (this.fieldWidthSet) {
                length = (this.fieldWidth - length2) - str.length();
                if (this.alternateForm) {
                    length -= 2;
                }
            } else {
                length = 0;
            }
            if (length < 0) {
                length = 0;
            }
            int i3 = 2;
            char[] cArr = new char[(this.alternateForm ? 2 : 0) + length2 + str.length() + length];
            if (this.leftJustify) {
                if (this.alternateForm) {
                    cArr[0] = '0';
                    cArr[1] = 'x';
                } else {
                    i3 = 0;
                }
                int i4 = 0;
                while (i4 < length2) {
                    cArr[i3] = '0';
                    i4++;
                    i3++;
                }
                char[] charArray = str.toCharArray();
                int i5 = 0;
                while (i5 < charArray.length) {
                    cArr[i3] = charArray[i5];
                    i5++;
                    i3++;
                }
                while (i2 < length) {
                    cArr[i3] = ' ';
                    i2++;
                    i3++;
                }
            } else {
                if (this.leadingZeros) {
                    i = 0;
                } else {
                    int i6 = 0;
                    i = 0;
                    while (i6 < length) {
                        cArr[i] = ' ';
                        i6++;
                        i++;
                    }
                }
                if (this.alternateForm) {
                    int i7 = i + 1;
                    cArr[i] = '0';
                    i = i7 + 1;
                    cArr[i7] = 'x';
                }
                if (this.leadingZeros) {
                    int i8 = 0;
                    while (i8 < length) {
                        cArr[i] = '0';
                        i8++;
                        i++;
                    }
                }
                int i9 = 0;
                while (i9 < length2) {
                    cArr[i] = '0';
                    i9++;
                    i++;
                }
                char[] charArray2 = str.toCharArray();
                while (i2 < charArray2.length) {
                    cArr[i] = charArray2[i2];
                    i2++;
                    i++;
                }
            }
            String str2 = new String(cArr);
            return this.conversionCharacter == 'X' ? str2.toUpperCase() : str2;
        }
    }

    public PrintfFormat(String str) throws IllegalArgumentException {
        this(Locale.getDefault(), str);
    }

    private String nonControl(String str, int i) {
        int iIndexOf = str.indexOf("%", i);
        this.cPos = iIndexOf;
        if (iIndexOf == -1) {
            this.cPos = str.length();
        }
        return str.substring(i, this.cPos);
    }

    public String sprintf(Object[] objArr) {
        Enumeration enumerationElements = this.vFmt.elements();
        StringBuffer stringBuffer = new StringBuffer();
        int argumentPosition = 0;
        while (enumerationElements.hasMoreElements()) {
            ConversionSpecification conversionSpecification = (ConversionSpecification) enumerationElements.nextElement();
            char conversionCharacter = conversionSpecification.getConversionCharacter();
            if (conversionCharacter == 0) {
                stringBuffer.append(conversionSpecification.getLiteral());
            } else if (conversionCharacter == '%') {
                stringBuffer.append("%");
            } else {
                if (conversionSpecification.isPositionalSpecification()) {
                    argumentPosition = conversionSpecification.getArgumentPosition() - 1;
                    if (conversionSpecification.isPositionalFieldWidth()) {
                        conversionSpecification.setFieldWidthWithArg(((Integer) objArr[conversionSpecification.getArgumentPositionForFieldWidth() - 1]).intValue());
                    }
                    if (conversionSpecification.isPositionalPrecision()) {
                        conversionSpecification.setPrecisionWithArg(((Integer) objArr[conversionSpecification.getArgumentPositionForPrecision() - 1]).intValue());
                    }
                } else {
                    if (conversionSpecification.isVariableFieldWidth()) {
                        conversionSpecification.setFieldWidthWithArg(((Integer) objArr[argumentPosition]).intValue());
                        argumentPosition++;
                    }
                    if (conversionSpecification.isVariablePrecision()) {
                        conversionSpecification.setPrecisionWithArg(((Integer) objArr[argumentPosition]).intValue());
                        argumentPosition++;
                    }
                }
                Object obj = objArr[argumentPosition];
                if (obj instanceof Byte) {
                    stringBuffer.append(conversionSpecification.internalsprintf((int) ((Byte) obj).byteValue()));
                } else if (obj instanceof Short) {
                    stringBuffer.append(conversionSpecification.internalsprintf((int) ((Short) obj).shortValue()));
                } else if (obj instanceof Integer) {
                    stringBuffer.append(conversionSpecification.internalsprintf(((Integer) obj).intValue()));
                } else if (obj instanceof Long) {
                    stringBuffer.append(conversionSpecification.internalsprintf(((Long) obj).longValue()));
                } else if (obj instanceof Float) {
                    stringBuffer.append(conversionSpecification.internalsprintf(((Float) obj).floatValue()));
                } else if (obj instanceof Double) {
                    stringBuffer.append(conversionSpecification.internalsprintf(((Double) obj).doubleValue()));
                } else if (obj instanceof Character) {
                    stringBuffer.append(conversionSpecification.internalsprintf((int) ((Character) obj).charValue()));
                } else if (obj instanceof String) {
                    stringBuffer.append(conversionSpecification.internalsprintf((String) obj));
                } else {
                    stringBuffer.append(conversionSpecification.internalsprintf(obj));
                }
                if (!conversionSpecification.isPositionalSpecification()) {
                    argumentPosition++;
                }
            }
        }
        return stringBuffer.toString();
    }

    public PrintfFormat(Locale locale, String str) throws IllegalArgumentException {
        char cCharAt;
        this.vFmt = new Vector();
        this.cPos = 0;
        this.dfs = null;
        this.dfs = new DecimalFormatSymbols(locale);
        String strNonControl = nonControl(str, 0);
        if (strNonControl != null) {
            ConversionSpecification conversionSpecification = new ConversionSpecification();
            conversionSpecification.setLiteral(strNonControl);
            this.vFmt.addElement(conversionSpecification);
        }
        while (true) {
            int i = this.cPos;
            if (i == -1 || i >= str.length()) {
                return;
            }
            int i2 = this.cPos;
            do {
                i2++;
                if (i2 >= str.length() || (cCharAt = str.charAt(i2)) == 'i' || cCharAt == 'd' || cCharAt == 'f' || cCharAt == 'g' || cCharAt == 'G' || cCharAt == 'o' || cCharAt == 'x' || cCharAt == 'X' || cCharAt == 'e' || cCharAt == 'E' || cCharAt == 'c' || cCharAt == 's') {
                    break;
                }
            } while (cCharAt != '%');
            int iMin = Math.min(i2 + 1, str.length());
            this.vFmt.addElement(new ConversionSpecification(str.substring(this.cPos, iMin)));
            String strNonControl2 = nonControl(str, iMin);
            if (strNonControl2 != null) {
                ConversionSpecification conversionSpecification2 = new ConversionSpecification();
                conversionSpecification2.setLiteral(strNonControl2);
                this.vFmt.addElement(conversionSpecification2);
            }
        }
    }

    public String sprintf() {
        Enumeration enumerationElements = this.vFmt.elements();
        StringBuffer stringBuffer = new StringBuffer();
        while (enumerationElements.hasMoreElements()) {
            ConversionSpecification conversionSpecification = (ConversionSpecification) enumerationElements.nextElement();
            char conversionCharacter = conversionSpecification.getConversionCharacter();
            if (conversionCharacter == 0) {
                stringBuffer.append(conversionSpecification.getLiteral());
            } else if (conversionCharacter == '%') {
                stringBuffer.append("%");
            }
        }
        return stringBuffer.toString();
    }

    public String sprintf(int i) throws IllegalArgumentException {
        Enumeration enumerationElements = this.vFmt.elements();
        StringBuffer stringBuffer = new StringBuffer();
        while (enumerationElements.hasMoreElements()) {
            ConversionSpecification conversionSpecification = (ConversionSpecification) enumerationElements.nextElement();
            char conversionCharacter = conversionSpecification.getConversionCharacter();
            if (conversionCharacter == 0) {
                stringBuffer.append(conversionSpecification.getLiteral());
            } else if (conversionCharacter == '%') {
                stringBuffer.append("%");
            } else {
                stringBuffer.append(conversionSpecification.internalsprintf(i));
            }
        }
        return stringBuffer.toString();
    }

    public String sprintf(long j) throws IllegalArgumentException {
        Enumeration enumerationElements = this.vFmt.elements();
        StringBuffer stringBuffer = new StringBuffer();
        while (enumerationElements.hasMoreElements()) {
            ConversionSpecification conversionSpecification = (ConversionSpecification) enumerationElements.nextElement();
            char conversionCharacter = conversionSpecification.getConversionCharacter();
            if (conversionCharacter == 0) {
                stringBuffer.append(conversionSpecification.getLiteral());
            } else if (conversionCharacter == '%') {
                stringBuffer.append("%");
            } else {
                stringBuffer.append(conversionSpecification.internalsprintf(j));
            }
        }
        return stringBuffer.toString();
    }

    public String sprintf(double d) throws IllegalArgumentException {
        Enumeration enumerationElements = this.vFmt.elements();
        StringBuffer stringBuffer = new StringBuffer();
        while (enumerationElements.hasMoreElements()) {
            ConversionSpecification conversionSpecification = (ConversionSpecification) enumerationElements.nextElement();
            char conversionCharacter = conversionSpecification.getConversionCharacter();
            if (conversionCharacter == 0) {
                stringBuffer.append(conversionSpecification.getLiteral());
            } else if (conversionCharacter == '%') {
                stringBuffer.append("%");
            } else {
                stringBuffer.append(conversionSpecification.internalsprintf(d));
            }
        }
        return stringBuffer.toString();
    }

    public String sprintf(String str) throws IllegalArgumentException {
        Enumeration enumerationElements = this.vFmt.elements();
        StringBuffer stringBuffer = new StringBuffer();
        while (enumerationElements.hasMoreElements()) {
            ConversionSpecification conversionSpecification = (ConversionSpecification) enumerationElements.nextElement();
            char conversionCharacter = conversionSpecification.getConversionCharacter();
            if (conversionCharacter == 0) {
                stringBuffer.append(conversionSpecification.getLiteral());
            } else if (conversionCharacter == '%') {
                stringBuffer.append("%");
            } else {
                stringBuffer.append(conversionSpecification.internalsprintf(str));
            }
        }
        return stringBuffer.toString();
    }

    public String sprintf(Object obj) throws IllegalArgumentException {
        Enumeration enumerationElements = this.vFmt.elements();
        StringBuffer stringBuffer = new StringBuffer();
        while (enumerationElements.hasMoreElements()) {
            ConversionSpecification conversionSpecification = (ConversionSpecification) enumerationElements.nextElement();
            char conversionCharacter = conversionSpecification.getConversionCharacter();
            if (conversionCharacter == 0) {
                stringBuffer.append(conversionSpecification.getLiteral());
            } else if (conversionCharacter == '%') {
                stringBuffer.append("%");
            } else if (obj instanceof Byte) {
                stringBuffer.append(conversionSpecification.internalsprintf((int) ((Byte) obj).byteValue()));
            } else if (obj instanceof Short) {
                stringBuffer.append(conversionSpecification.internalsprintf((int) ((Short) obj).shortValue()));
            } else if (obj instanceof Integer) {
                stringBuffer.append(conversionSpecification.internalsprintf(((Integer) obj).intValue()));
            } else if (obj instanceof Long) {
                stringBuffer.append(conversionSpecification.internalsprintf(((Long) obj).longValue()));
            } else if (obj instanceof Float) {
                stringBuffer.append(conversionSpecification.internalsprintf(((Float) obj).floatValue()));
            } else if (obj instanceof Double) {
                stringBuffer.append(conversionSpecification.internalsprintf(((Double) obj).doubleValue()));
            } else if (obj instanceof Character) {
                stringBuffer.append(conversionSpecification.internalsprintf((int) ((Character) obj).charValue()));
            } else if (obj instanceof String) {
                stringBuffer.append(conversionSpecification.internalsprintf((String) obj));
            } else {
                stringBuffer.append(conversionSpecification.internalsprintf(obj));
            }
        }
        return stringBuffer.toString();
    }
}
