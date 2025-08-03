package com.zhiyun.protocol.constants;

/* loaded from: classes2.dex */
public enum JoystickSpeed {
    VALUE(-1),
    LOW(0),
    MEDIUM(1),
    HIGH(2);

    public final int code;

    JoystickSpeed(int i) {
        this.code = i;
    }

    public static JoystickSpeed valueOf(int i) {
        JoystickSpeed joystickSpeed = LOW;
        for (JoystickSpeed joystickSpeed2 : values()) {
            if (joystickSpeed2.code == i) {
                return joystickSpeed2;
            }
        }
        return joystickSpeed;
    }
}
