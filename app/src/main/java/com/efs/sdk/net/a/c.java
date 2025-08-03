package com.efs.sdk.net.a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class c implements Serializable {
    public static String a = "callStart";
    public static String b = "callEnd";
    public static String c = "callFailed";
    public static String d = "dnsStart";

    /* renamed from: e, reason: collision with root package name */
    public static String f17657e = "dnsEnd";
    public static String f = "connectStart";
    public static String g = "secureConnectStart";
    public static String h = "secureConnectEnd";
    public static String i = "connectEnd";
    public static String j = "connectFailed";
    public static String k = "requestHeadersStart";
    public static String l = "requestHeadersEnd";
    public static String m = "requestBodyStart";
    public static String n = "requestBodyEnd";
    public static String o = "responseHeadersStart";
    public static String p = "responseHeadersEnd";
    public static String q = "responseBodyStart";
    public static String r = "responseBodyEnd";
    public static String s = "totalTime";
    public static String t = "DNS";
    public static String u = "secureConnect";
    public static String v = "connect";
    public static String w = "requestHeaders";
    public static String x = "requestBody";
    public static String y = "responseHeaders";
    public static String z = "responseBody";
    public String A;
    public String B;
    public long C;
    public Map<String, Long> D = new HashMap();
    public Map<String, Long> E = new HashMap();
}
