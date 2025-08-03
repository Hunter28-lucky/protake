package com.blink.academy.film.support.stream.ts.google.API.Descriptor;

/* loaded from: classes.dex */
public interface DC_AC3Audio extends DescriptorContent {
    byte[] getAdditionalInfo();

    int getAsvcFlags();

    int getBitRateCode();

    int getBsid();

    int getBsmod();

    int getFullSvc();

    int getLangCod();

    int getLangCod2();

    int getMainId();

    int getNumChannels();

    int getSampleRateCode();

    int getSurroundMode();

    char[] getText();

    int getTextCode();

    int getTextLen();

    void setAdditionalInfo(byte[] bArr);

    void setAsvcFlags(int i);

    void setBitRateCode(int i);

    void setBsid(int i);

    void setBsmod(int i);

    void setFullSvc(int i);

    void setLangCod(int i);

    void setLangCod2(int i);

    void setMainId(int i);

    void setNumChannels(int i);

    void setSampleRateCode(int i);

    void setSurroundMode(int i);

    void setText(char[] cArr);

    void setTextCode(int i);

    void setTextLen(int i);
}
