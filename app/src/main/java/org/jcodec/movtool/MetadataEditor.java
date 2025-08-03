package org.jcodec.movtool;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.jcodec.common.Format;
import org.jcodec.common.JCodecUtil;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MetaBox;
import org.jcodec.containers.mp4.boxes.MetaValue;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.MovieFragmentBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.UdtaMetaBox;

/* loaded from: classes2.dex */
public class MetadataEditor {
    private Map<Integer, MetaValue> itunesMeta;
    private Map<String, MetaValue> keyedMeta;
    private File source;

    public MetadataEditor(File file, Map<String, MetaValue> map, Map<Integer, MetaValue> map2) {
        this.source = file;
        this.keyedMeta = map;
        this.itunesMeta = map2;
    }

    public static MetadataEditor createFrom(File file) throws Throwable {
        Format formatDetectFormat = JCodecUtil.detectFormat(file);
        if (formatDetectFormat == Format.MOV) {
            MP4Util.Movie fullMovie = MP4Util.parseFullMovie(file);
            MetaBox metaBox = (MetaBox) NodeBox.findFirst(fullMovie.getMoov(), MetaBox.class, MetaBox.fourcc());
            MetaBox metaBox2 = (MetaBox) NodeBox.findFirstPath(fullMovie.getMoov(), MetaBox.class, new String[]{"udta", MetaBox.fourcc()});
            return new MetadataEditor(file, metaBox == null ? new HashMap<>() : metaBox.getKeyedMeta(), metaBox2 == null ? new HashMap<>() : metaBox2.getItunesMeta());
        }
        throw new IllegalArgumentException("Unsupported format: " + formatDetectFormat);
    }

    public Map<Integer, MetaValue> getItunesMeta() {
        return this.itunesMeta;
    }

    public Map<String, MetaValue> getKeyedMeta() {
        return this.keyedMeta;
    }

    public void save(boolean z) throws Throwable {
        MP4Edit mP4Edit = new MP4Edit() { // from class: org.jcodec.movtool.MetadataEditor.1
            @Override // org.jcodec.movtool.MP4Edit
            public void apply(MovieBox movieBox) {
                MetaBox metaBoxCreateMetaBox = (MetaBox) NodeBox.findFirst(movieBox, MetaBox.class, MetaBox.fourcc());
                MetaBox metaBoxCreateUdtaMetaBox = (MetaBox) NodeBox.findFirstPath(movieBox, MetaBox.class, new String[]{"udta", MetaBox.fourcc()});
                if (this.keyedMeta != null && this.keyedMeta.size() > 0) {
                    if (metaBoxCreateMetaBox == null) {
                        metaBoxCreateMetaBox = MetaBox.createMetaBox();
                        movieBox.add(metaBoxCreateMetaBox);
                    }
                    metaBoxCreateMetaBox.setKeyedMeta(this.keyedMeta);
                }
                if (this.itunesMeta == null || this.itunesMeta.size() <= 0) {
                    return;
                }
                if (metaBoxCreateUdtaMetaBox == null) {
                    metaBoxCreateUdtaMetaBox = UdtaMetaBox.createUdtaMetaBox();
                    NodeBox nodeBox = (NodeBox) NodeBox.findFirst(movieBox, NodeBox.class, "udta");
                    if (nodeBox == null) {
                        nodeBox = new NodeBox(Header.createHeader("udta", 0L));
                        movieBox.add(nodeBox);
                    }
                    nodeBox.add(metaBoxCreateUdtaMetaBox);
                }
                metaBoxCreateUdtaMetaBox.setItunesMeta(this.itunesMeta);
            }

            @Override // org.jcodec.movtool.MP4Edit
            public void applyToFragment(MovieBox movieBox, MovieFragmentBox[] movieFragmentBoxArr) {
            }
        };
        if (z) {
            new RelocateMP4Editor().modifyOrRelocate(this.source, mP4Edit);
        } else {
            new ReplaceMP4Editor().modifyOrReplace(this.source, mP4Edit);
        }
    }
}
