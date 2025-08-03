package org.jcodec.common;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public class StringUtils {
    public static final String[] zeroPad00 = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09"};

    public static String capitaliseAllWords(String str) {
        return capitalize(str);
    }

    public static String capitalize(String str) {
        return capitalizeD(str, null);
    }

    public static String capitalizeD(String str, char[] cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (str == null || str.length() == 0 || length == 0) {
            return str;
        }
        int length2 = str.length();
        StringBuilder sb = new StringBuilder(length2);
        boolean z = true;
        for (int i = 0; i < length2; i++) {
            char cCharAt = str.charAt(i);
            if (isDelimiter(cCharAt, cArr)) {
                sb.append(cCharAt);
                z = true;
            } else if (z) {
                sb.append(Character.toTitleCase(cCharAt));
                z = false;
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private static boolean isDelimiter(char c, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(c);
        }
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String join(Object[] objArr) {
        return joinS(objArr, null);
    }

    public static String join2(Object[] objArr, char c) {
        if (objArr == null) {
            return null;
        }
        return join4(objArr, c, 0, objArr.length);
    }

    public static String join4(Object[] objArr, char c, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        Object obj = objArr[i];
        StringBuilder sb = new StringBuilder(i3 * ((obj == null ? 16 : obj.toString().length()) + 1));
        for (int i4 = i; i4 < i2; i4++) {
            if (i4 > i) {
                sb.append(c);
            }
            Object obj2 = objArr[i4];
            if (obj2 != null) {
                sb.append(obj2);
            }
        }
        return sb.toString();
    }

    public static String joinS(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return joinS4(objArr, str, 0, objArr.length);
    }

    public static String joinS4(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        Object obj = objArr[i];
        StringBuilder sb = new StringBuilder(i3 * ((obj == null ? 16 : obj.toString().length()) + str.length()));
        for (int i4 = i; i4 < i2; i4++) {
            if (i4 > i) {
                sb.append(str);
            }
            Object obj2 = objArr[i4];
            if (obj2 != null) {
                sb.append(obj2);
            }
        }
        return sb.toString();
    }

    public static String[] split(String str) {
        return splitS3(str, null, -1);
    }

    public static String[] splitC(String str, char c) {
        return splitWorker(str, c, false);
    }

    public static String[] splitS(String str, String str2) {
        return splitWorker4(str, str2, -1, false);
    }

    public static String[] splitS3(String str, String str2, int i) {
        return splitWorker4(str, str2, i, false);
    }

    private static String[] splitWorker(String str, char c, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (i < length) {
            if (str.charAt(i) == c) {
                if (z2 || z) {
                    arrayList.add(str.substring(i2, i));
                    z2 = false;
                    z3 = true;
                }
                i2 = i + 1;
                i = i2;
            } else {
                i++;
                z3 = false;
                z2 = true;
            }
        }
        if (z2 || (z && z3)) {
            arrayList.add(str.substring(i2, i));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] splitWorker4(String str, String str2, int i, boolean z) {
        int i2;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        boolean z4;
        boolean z5;
        int i5;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            i4 = 0;
            z4 = false;
            z5 = false;
            i5 = 0;
            int i6 = 1;
            while (i4 < length) {
                if (Character.isWhitespace(str.charAt(i4))) {
                    if (z4 || z) {
                        int i7 = i6 + 1;
                        if (i6 == i) {
                            i4 = length;
                            z5 = false;
                        } else {
                            z5 = true;
                        }
                        arrayList.add(str.substring(i5, i4));
                        i6 = i7;
                        z4 = false;
                    }
                    i5 = i4 + 1;
                    i4 = i5;
                } else {
                    i4++;
                    z5 = false;
                    z4 = true;
                }
            }
        } else {
            if (str2.length() == 1) {
                char cCharAt = str2.charAt(0);
                i2 = 0;
                z2 = false;
                z3 = false;
                i3 = 0;
                int i8 = 1;
                while (i2 < length) {
                    if (str.charAt(i2) == cCharAt) {
                        if (z2 || z) {
                            int i9 = i8 + 1;
                            if (i8 == i) {
                                i2 = length;
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            arrayList.add(str.substring(i3, i2));
                            i8 = i9;
                            z2 = false;
                        }
                        i3 = i2 + 1;
                        i2 = i3;
                    } else {
                        i2++;
                        z3 = false;
                        z2 = true;
                    }
                }
            } else {
                i2 = 0;
                z2 = false;
                z3 = false;
                i3 = 0;
                int i10 = 1;
                while (i2 < length) {
                    if (str2.indexOf(str.charAt(i2)) >= 0) {
                        if (z2 || z) {
                            int i11 = i10 + 1;
                            if (i10 == i) {
                                i2 = length;
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            arrayList.add(str.substring(i3, i2));
                            i10 = i11;
                            z2 = false;
                        }
                        i3 = i2 + 1;
                        i2 = i3;
                    } else {
                        i2++;
                        z3 = false;
                        z2 = true;
                    }
                }
            }
            i4 = i2;
            z4 = z2;
            z5 = z3;
            i5 = i3;
        }
        if (z4 || (z && z5)) {
            arrayList.add(str.substring(i5, i4));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String zeroPad2(int i) {
        if (i >= 0 && i < 10) {
            return zeroPad00[i];
        }
        return "" + i;
    }

    public static String zeroPad3(int i) {
        String strZeroPad2 = zeroPad2(i);
        if (strZeroPad2.length() != 2) {
            return strZeroPad2;
        }
        return "0" + strZeroPad2;
    }
}
