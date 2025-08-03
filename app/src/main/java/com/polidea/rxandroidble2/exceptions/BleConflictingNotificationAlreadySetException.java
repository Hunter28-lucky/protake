package com.polidea.rxandroidble2.exceptions;

import java.util.UUID;

/* loaded from: classes2.dex */
public class BleConflictingNotificationAlreadySetException extends BleException {
    private final boolean alreadySetIsIndication;
    private final UUID characteristicUuid;

    public BleConflictingNotificationAlreadySetException(UUID uuid, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("Characteristic ");
        sb.append(uuid);
        sb.append(" notification already set to ");
        sb.append(z ? "indication" : "notification");
        super(sb.toString());
        this.characteristicUuid = uuid;
        this.alreadySetIsIndication = z;
    }

    public UUID getCharacteristicUuid() {
        return this.characteristicUuid;
    }

    public boolean indicationAlreadySet() {
        return this.alreadySetIsIndication;
    }

    public boolean notificationAlreadySet() {
        return !this.alreadySetIsIndication;
    }
}
