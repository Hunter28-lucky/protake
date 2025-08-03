package com.mob.commons;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mob.MobSDK;
import com.mob.tools.proguard.EverythingKeeper;
import com.mob.tools.utils.SharePrefrenceHelper;
import com.umeng.analytics.pro.am;

/* loaded from: classes2.dex */
public enum InternationalDomain implements EverythingKeeper {
    AD(am.aw, "Andorra"),
    AE("ae", "United Arab Emirates"),
    AF("af", "Afghanistan"),
    AG("ag", "Antigua and Barbuda"),
    AI("ai", "Anguilla"),
    AL("al", "Albania"),
    AM("am", "Armenia"),
    AO("ao", "Angola"),
    AR("ar", "Argentina"),
    AT("at", "Austria"),
    AU("au", "Australia"),
    AZ("az", "Azerbaijan"),
    BB("bb", "Barbados"),
    BD("bd", "Bangladesh"),
    BE("be", "Belgium"),
    BF("bf", "Burkina-faso"),
    BG("bg", "Bulgaria"),
    BH("bh", "Bahrain"),
    BI("bi", "Burundi"),
    BJ("bj", "Benin"),
    BL("bl", "Palestine"),
    BM("bm", "Bermuda Is."),
    BN("bn", "Brunei"),
    BO("bo", "Bolivia"),
    BR("br", "Brazil"),
    BS("bs", "Bahamas"),
    BW("bw", "Botswana"),
    BY("by", "Belarus"),
    BZ("bz", "Belize"),
    CA("ca", "Canada"),
    CF("cf", "Central African Republic"),
    CG("cg", "Congo"),
    CH("ch", "Switzerland"),
    CK("ck", "Cook Is."),
    CL("cl", "Chile"),
    CM("cm", "Cameroon"),
    CN("cn", "China"),
    CO("co", "Colombia"),
    CR("cr", "Costa Rica"),
    CS("cs", "Czech"),
    CU("cu", "Cuba"),
    CY("cy", "Cyprus"),
    CZ("cz", "Czech Republic"),
    DE("de", "Germany"),
    DJ("dj", "Djibouti"),
    DK(am.bo, "Denmark"),
    DO("do", "Dominica Rep."),
    DZ("dz", "Algeria"),
    EC("ec", "Ecuador"),
    EE("ee", "Estonia"),
    EG("eg", "Egypt"),
    ES("es", "Spain"),
    ET("et", "Ethiopia"),
    FI("fi", "Finland"),
    FJ("fj", "Fiji"),
    FR("fr", "France"),
    GA("ga", "Gabon"),
    GB("gb", "United Kiongdom"),
    GD("gd", "Grenada"),
    GE("ge", "Georgia"),
    GF("gf", "French Guiana"),
    GH("gh", "Ghana"),
    GI("gi", "Gibraltar"),
    GM("gm", "Gambia"),
    GN("gn", "Guinea"),
    GR("gr", "Greece"),
    GT("gt", "Guatemala"),
    GU("gu", "Guam"),
    GY("gy", "Guyana"),
    HK("hk", "Hongkong"),
    HN("hn", "Honduras"),
    HT("ht", "Haiti"),
    HU("hu", "Hungary"),
    ID("id", "Indonesia"),
    IE("ie", "Ireland"),
    IL("il", "Israel"),
    IN("in", "India"),
    IQ("iq", "Iraq"),
    IR("ir", "Iran"),
    IS(am.ae, "Iceland"),
    IT("it", "Italy"),
    JM("jm", "Jamaica"),
    JO("jo", "Jordan"),
    JP("jp", "Japan"),
    KE("ke", "Kenya"),
    KG("kg", "Kyrgyzstan"),
    KH("kh", "Kampuchea (Cambodia )"),
    KP("kp", "North Korea"),
    KR("kr", "Korea"),
    KT("kt", "Republic of Ivory Coast"),
    KW("kw", "Kuwait"),
    KZ("kz", "Kazakstan"),
    LA("la", "Laos"),
    LB("lb", "Lebanon"),
    LC("lc", "St.Lucia"),
    LI("li", "Liechtenstein"),
    LK("lk", "Sri Lanka"),
    LR("lr", "Liberia"),
    LS("ls", "Lesotho"),
    LT("lt", "Lithuania"),
    LU("lu", "Luxembourg"),
    LV("lv", "Latvia"),
    LY("ly", "Libya"),
    MA("ma", "Morocco"),
    MC(am.A, "Monaco"),
    MD("md", "Moldova, Republic of"),
    MG("mg", "Madagascar"),
    ML("ml", "Mali"),
    MM("mm", "Burma"),
    MN("mn", "Mongolia"),
    MO("mo", "Macao"),
    MS("ms", "Montserrat Is"),
    MT("mt", "Malta"),
    MU("mu", "Mauritius"),
    MV("mv", "Maldives"),
    MW("mw", "Malawi"),
    MX("mx", "Mexico"),
    MY("my", "Malaysia"),
    MZ("mz", "Mozambique"),
    NA("na", "Namibia"),
    NE("ne", "Niger"),
    NG("ng", "Nigeria"),
    NI("ni", "Nicaragua"),
    NL("nl", "Netherlands"),
    NO("no", "Norway"),
    NP("np", "Nepal"),
    NR("nr", "Nauru"),
    NZ("nz", "New Zealand"),
    OM("om", "Oman"),
    PA("pa", "Panama"),
    PE("pe", "Peru"),
    PF("pf", "French Polynesia"),
    PG(am.aA, "Papua New Cuinea"),
    PH("ph", "Philippines"),
    PK("pk", "Pakistan"),
    PL(am.az, "Poland"),
    PR(am.ay, "Puerto Rico"),
    PT("pt", "Portugal"),
    PY("py", "Paraguay"),
    QA("qa", "Qatar"),
    RO("ro", "Romania"),
    RU("ru", "Russia"),
    SA("sa", "Saudi Arabia"),
    SB("sb", "Solomon Is"),
    SC("sc", "Seychelles"),
    SD("sd", "Sudan"),
    SE("se", "Sweden"),
    SG("sg", "Singapore"),
    SI("si", "Slovenia"),
    SK("sk", "Slovakia"),
    SL("sl", "Sierra Leone"),
    SM("sm", "San Marino"),
    SN("sn", "Senegal"),
    SO("so", "Somali"),
    SR("sr", "Suriname"),
    ST("st", "Sao Tome and Principe"),
    SV("sv", "EI Salvador"),
    SY("sy", "Syria"),
    SZ("sz", "Swaziland"),
    TD("td", "Chad"),
    TG("tg", "Togo"),
    TH("th", "Thailand"),
    TJ("tj", "Tajikstan"),
    TM("tm", "Turkmenistan"),
    TN("tn", "Tunisia"),
    TO(TypedValues.TransitionType.S_TO, "Tonga"),
    TR("tr", "Turkey"),
    TT("tt", "Trinidad and Tobago"),
    TW("tw", "Taiwan"),
    TZ("tz", "Tanzania"),
    UA("ua", "Ukraine"),
    UG("ug", "Uganda"),
    US("us", "United States of America"),
    UY("uy", "Uruguay"),
    UZ("uz", "Uzbekistan"),
    VC("vc", "Saint Vincent"),
    VE("ve", "Venezuela"),
    VN("vn", "Vietnam"),
    YE("ye", "Yemen"),
    YU("yu", "Yugoslavia"),
    ZA("za", "South Africa"),
    ZM("zm", "Zambia"),
    ZR("zr", "Zaire"),
    ZW("zw", "Zimbabwe"),
    DEFAULT(null, null);

    private static SharePrefrenceHelper sp;
    private String domain;
    private String region;

    InternationalDomain(String str, String str2) {
        this.domain = str;
        this.region = str2;
    }

    public static InternationalDomain domainOf(String str) {
        if (str == null) {
            return DEFAULT;
        }
        for (InternationalDomain internationalDomain : values()) {
            if (str.equalsIgnoreCase(internationalDomain.domain)) {
                return internationalDomain;
            }
        }
        return DEFAULT;
    }

    public static synchronized InternationalDomain readFromBuffer() {
        if (sp == null) {
            SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
            sp = sharePrefrenceHelper;
            sharePrefrenceHelper.open("domain", 1);
        }
        String string = sp.getString("domain");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        if ("null".equalsIgnoreCase(string)) {
            return DEFAULT;
        }
        return domainOf(string);
    }

    public static synchronized void saveBuffer(InternationalDomain internationalDomain) {
        if (sp == null) {
            SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
            sp = sharePrefrenceHelper;
            sharePrefrenceHelper.open("domain", 1);
        }
        if (internationalDomain == null) {
            sp.putString("domain", "null");
        } else {
            sp.putString("domain", internationalDomain.domain);
        }
    }

    public String getDomain() {
        return this.domain;
    }

    public String getRegion() {
        return this.region;
    }
}
