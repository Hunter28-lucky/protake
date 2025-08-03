package org.jcodec.common.logging;

import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class BufferLogSink implements LogSink {
    private List<Message> messages = new LinkedList();

    public List<Message> getMessages() {
        return this.messages;
    }

    @Override // org.jcodec.common.logging.LogSink
    public void postMessage(Message message) {
        this.messages.add(message);
    }
}
