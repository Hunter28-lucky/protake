package org.jcodec.containers.mp4;

import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChannelBox;
import org.jcodec.containers.mp4.boxes.WaveExtension;

/* loaded from: classes2.dex */
public class AudioBoxes extends Boxes {
    public AudioBoxes() {
        this.mappings.put(WaveExtension.fourcc(), WaveExtension.class);
        this.mappings.put(ChannelBox.fourcc(), ChannelBox.class);
        this.mappings.put("esds", Box.LeafBox.class);
    }
}
