package com.blink.academy.film.stream;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.net.URI;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class PingUtil {
    private static final int DEFAULT_COUNT = 1;
    private static final String RESULT_BAD = "bad";
    private static final String RESULT_GOOD = "good";
    private static final String RESULT_NORMAL = "normal";
    private static final int TIME_OUT = 100;
    private static final int TYPE_AVG = 2;
    private static final int TYPE_MAX = 3;
    private static final int TYPE_MDEV = 4;
    private static final int TYPE_MIN = 1;
    private static final String ipRegex = "((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))";

    private static String createSimplePingCommand(int i, int i2, String str) {
        return "/system/bin/ping -c " + i + " -w " + i2 + MyUTIL.white_space + str;
    }

    private static String getDomain(String str) {
        String host = null;
        try {
            host = URI.create(str).getHost();
            if (host == null) {
                if (isMatch(ipRegex, str)) {
                    return str;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return host;
    }

    public static String getPacketLoss(String str) {
        return getPacketLoss(str, 1, 100);
    }

    public static float getPacketLossFloat(String str) {
        String packetLoss = getPacketLoss(str);
        if (packetLoss == null) {
            return -1.0f;
        }
        try {
            return Float.parseFloat(packetLoss.replace("%", ""));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1.0f;
        }
    }

    public static int getRTT(String str) {
        return getRTT(str, 2);
    }

    private static boolean isMatch(String str, String str2) {
        return Pattern.matches(str, str2);
    }

    public static String parseRTT(String str) {
        int rtt = getRTT(str);
        return (rtt <= 0 || rtt >= 50) ? ((rtt > 100 || rtt <= 50) && getPacketLossFloat(str) != 0.0f) ? RESULT_BAD : RESULT_NORMAL : RESULT_GOOD;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String ping(java.lang.String r6) throws java.lang.Throwable {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L40
            java.lang.Process r6 = r1.exec(r6)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L40
            java.io.InputStream r1 = r6.getInputStream()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            r3.<init>(r1)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            r2.<init>(r3)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            r3.<init>()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
        L1c:
            java.lang.String r4 = r2.readLine()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            if (r4 == 0) goto L2b
            r3.append(r4)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            java.lang.String r4 = "\n"
            r3.append(r4)     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            goto L1c
        L2b:
            r2.close()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            r1.close()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            java.lang.String r0 = r3.toString()     // Catch: java.io.IOException -> L39 java.lang.Throwable -> L4b
            r6.destroy()
            return r0
        L39:
            r1 = move-exception
            goto L42
        L3b:
            r6 = move-exception
            r5 = r0
            r0 = r6
            r6 = r5
            goto L4c
        L40:
            r1 = move-exception
            r6 = r0
        L42:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L4b
            if (r6 == 0) goto L4a
            r6.destroy()
        L4a:
            return r0
        L4b:
            r0 = move-exception
        L4c:
            if (r6 == 0) goto L51
            r6.destroy()
        L51:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.stream.PingUtil.ping(java.lang.String):java.lang.String");
    }

    public static String getPacketLoss(String str, int i, int i2) {
        String strPing;
        String domain = getDomain(str);
        if (domain != null && (strPing = ping(createSimplePingCommand(i, i2, domain))) != null) {
            try {
                String strSubstring = strPing.substring(strPing.indexOf("received,"));
                return strSubstring.substring(9, strSubstring.indexOf("packet"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static int getRTT(String str, int i) {
        return getRTT(str, i, 1, 100);
    }

    public static int getRTT(String str, int i, int i2, int i3) {
        String strPing;
        String domain = getDomain(str);
        if (domain != null && (strPing = ping(createSimplePingCommand(i2, i3, domain))) != null) {
            try {
                String[] strArrSplit = strPing.substring(strPing.indexOf("min/avg/max/mdev") + 19).split("/");
                if (i == 1) {
                    return Math.round(Float.parseFloat(strArrSplit[0]));
                }
                if (i == 2) {
                    return Math.round(Float.parseFloat(strArrSplit[1]));
                }
                if (i == 3) {
                    return Math.round(Float.parseFloat(strArrSplit[2]));
                }
                if (i != 4) {
                    return -1;
                }
                return Math.round(Float.parseFloat(strArrSplit[3]));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return -1;
    }

    public static String parseRTT(String str, int i, int i2, int i3) {
        int rtt = getRTT(str, i, i2, i3);
        return (rtt <= 0 || rtt >= 50) ? ((rtt > 100 || rtt <= 50) && getPacketLossFloat(str, i2, i3) != 0.0f) ? RESULT_BAD : RESULT_NORMAL : RESULT_GOOD;
    }

    public static float getPacketLossFloat(String str, int i, int i2) {
        String packetLoss = getPacketLoss(str, i, i2);
        if (packetLoss == null) {
            return -1.0f;
        }
        try {
            return Float.parseFloat(packetLoss.replace("%", ""));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1.0f;
        }
    }
}
