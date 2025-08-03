package com.efs.sdk.base.protocol.file.section;

import com.umeng.umcrash.BuildConfig;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes.dex */
public abstract class AbsSection {
    public static final String SEP_LINE_BREAK = "linebreak";
    public static final String SEP_ORIGIN_LINE_BREAK = "\n";
    public String type;
    public String name = "";
    public String version = BuildConfig.VERSION_NAME;
    public String sep = "";

    public AbsSection(String str) {
        this.type = str;
    }

    public abstract String changeToStr();

    public String getDeclarationLine() {
        return "section:" + this.name + Constants.ACCEPT_TIME_SEPARATOR_SP + this.type + Constants.ACCEPT_TIME_SEPARATOR_SP + this.version + Constants.ACCEPT_TIME_SEPARATOR_SP + this.sep;
    }

    public void setSep(String str) {
        if (str.equals("\n")) {
            this.sep = SEP_LINE_BREAK;
        } else {
            this.sep = str;
        }
    }
}
