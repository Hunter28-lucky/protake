package com.blink.academy.film.stream.secondscreen;

/* loaded from: classes.dex */
public interface SecondScreenView {
    void destroyFromOther();

    void destroyPlayerBuffer();

    void dismiss();

    void drawContent(int i, int i2, int i3);

    void drawPlayerContent(int i, int i2, int i3);

    int getSetScreenOrientation();

    void refreshContentOrientation(int i);

    void refreshViewOnFrameRatioChange(float f, float f2, boolean z);

    void resizeContentSize(int i, int i2);

    void setHomeRatioCoverCropAlpha(int i);

    void show();
}
