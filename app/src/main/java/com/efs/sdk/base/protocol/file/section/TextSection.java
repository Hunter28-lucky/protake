package com.efs.sdk.base.protocol.file.section;

import androidx.core.app.NotificationCompat;

/* loaded from: classes.dex */
public class TextSection extends AbsSection {
    private String body;

    public TextSection(String str) {
        super(NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.name = str;
    }

    @Override // com.efs.sdk.base.protocol.file.section.AbsSection
    public String changeToStr() {
        return getDeclarationLine() + "\n" + this.body + "\n";
    }

    public void setBody(String str) {
        this.body = str;
    }
}
