package org.jcodec.codecs.mpeg4.mp4;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.jcodec.codecs.aac.ADTSParser;
import org.jcodec.codecs.mpeg4.es.DecoderConfig;
import org.jcodec.codecs.mpeg4.es.DecoderSpecific;
import org.jcodec.codecs.mpeg4.es.DescriptorParser;
import org.jcodec.codecs.mpeg4.es.ES;
import org.jcodec.codecs.mpeg4.es.NodeDescriptor;
import org.jcodec.codecs.mpeg4.es.SL;
import org.jcodec.containers.mp4.boxes.FullBox;
import org.jcodec.containers.mp4.boxes.Header;

/* loaded from: classes2.dex */
public class EsdsBox extends FullBox {
    private int avgBitrate;
    private int bufSize;
    private int maxBitrate;
    private int objectType;
    private ByteBuffer streamInfo;
    private int trackId;

    public EsdsBox(Header header) {
        super(header);
    }

    public static EsdsBox createEsdsBox(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5) {
        EsdsBox esdsBox = new EsdsBox(new Header(fourcc()));
        esdsBox.objectType = i;
        esdsBox.bufSize = i2;
        esdsBox.maxBitrate = i3;
        esdsBox.avgBitrate = i4;
        esdsBox.trackId = i5;
        esdsBox.streamInfo = byteBuffer;
        return esdsBox;
    }

    public static String fourcc() {
        return "esds";
    }

    public static EsdsBox fromADTS(ADTSParser.Header header) {
        return createEsdsBox(ADTSParser.adtsToStreamInfo(header), header.getObjectType() << 5, 0, 210750, 133350, 2);
    }

    public static EsdsBox newEsdsBox() {
        return new EsdsBox(new Header(fourcc()));
    }

    @Override // org.jcodec.containers.mp4.boxes.FullBox, org.jcodec.containers.mp4.boxes.Box
    public void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        ByteBuffer byteBuffer2 = this.streamInfo;
        if (byteBuffer2 == null || byteBuffer2.remaining() <= 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new DecoderConfig(this.objectType, this.bufSize, this.maxBitrate, this.avgBitrate, new ArrayList()));
            arrayList.add(new SL());
            new ES(this.trackId, arrayList).write(byteBuffer);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new DecoderSpecific(this.streamInfo));
        arrayList2.add(new DecoderConfig(this.objectType, this.bufSize, this.maxBitrate, this.avgBitrate, arrayList3));
        arrayList2.add(new SL());
        new ES(this.trackId, arrayList2).write(byteBuffer);
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public int estimateSize() {
        return 64;
    }

    public int getAvgBitrate() {
        return this.avgBitrate;
    }

    public int getBufSize() {
        return this.bufSize;
    }

    public int getMaxBitrate() {
        return this.maxBitrate;
    }

    public int getObjectType() {
        return this.objectType;
    }

    public ByteBuffer getStreamInfo() {
        return this.streamInfo;
    }

    public int getTrackId() {
        return this.trackId;
    }

    @Override // org.jcodec.containers.mp4.boxes.FullBox, org.jcodec.containers.mp4.boxes.Box
    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        ES es = (ES) DescriptorParser.read(byteBuffer);
        this.trackId = es.getTrackId();
        DecoderConfig decoderConfig = (DecoderConfig) NodeDescriptor.findByTag(es, DecoderConfig.tag());
        this.objectType = decoderConfig.getObjectType();
        this.bufSize = decoderConfig.getBufSize();
        this.maxBitrate = decoderConfig.getMaxBitrate();
        this.avgBitrate = decoderConfig.getAvgBitrate();
        this.streamInfo = ((DecoderSpecific) NodeDescriptor.findByTag(decoderConfig, DecoderSpecific.tag())).getData();
    }
}
