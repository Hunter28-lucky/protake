package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum SceneMode {
    WALK(0),
    RUN(1);

    public final int value;

    SceneMode(int i) {
        this.value = i;
    }

    public static SceneMode valueOf(int i) {
        SceneMode sceneMode = WALK;
        for (SceneMode sceneMode2 : values()) {
            if (sceneMode2.value == i) {
                return sceneMode2;
            }
        }
        return sceneMode;
    }
}
