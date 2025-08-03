package org.jcodec.containers.mp4;

import java.util.HashMap;
import java.util.Map;
import org.jcodec.containers.mp4.boxes.Box;

/* loaded from: classes2.dex */
public abstract class Boxes {
    public final Map<String, Class<? extends Box>> mappings = new HashMap();

    public void clear() {
        this.mappings.clear();
    }

    public void override(String str, Class<? extends Box> cls) {
        this.mappings.put(str, cls);
    }

    public Class<? extends Box> toClass(String str) {
        return this.mappings.get(str);
    }
}
